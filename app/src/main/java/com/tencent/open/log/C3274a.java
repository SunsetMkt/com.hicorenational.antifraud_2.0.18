package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.a */
/* loaded from: classes2.dex */
public class C3274a extends Tracer implements Handler.Callback {

    /* renamed from: a */
    private C3275b f11234a;

    /* renamed from: b */
    private FileWriter f11235b;

    /* renamed from: c */
    private File f11236c;

    /* renamed from: d */
    private char[] f11237d;

    /* renamed from: e */
    private volatile C3279f f11238e;

    /* renamed from: f */
    private volatile C3279f f11239f;

    /* renamed from: g */
    private volatile C3279f f11240g;

    /* renamed from: h */
    private volatile C3279f f11241h;

    /* renamed from: i */
    private volatile boolean f11242i;

    /* renamed from: j */
    private HandlerThread f11243j;

    /* renamed from: k */
    private Handler f11244k;

    public C3274a(C3275b c3275b) {
        this(C3276c.f11256b, true, C3280g.f11276a, c3275b);
    }

    /* renamed from: f */
    private void m10522f() {
        if (Thread.currentThread() == this.f11243j && !this.f11242i) {
            this.f11242i = true;
            m10525i();
            try {
                try {
                    this.f11241h.m10562a(m10523g(), this.f11237d);
                } catch (IOException e2) {
                    SLog.m10501e("FileTracer", "flushBuffer exception", e2);
                }
                this.f11242i = false;
            } finally {
                this.f11241h.m10563b();
            }
        }
    }

    /* renamed from: g */
    private Writer m10523g() {
        File m10533a = m10529c().m10533a();
        if (m10533a != null && ((m10533a != null && !m10533a.equals(this.f11236c)) || (this.f11235b == null && m10533a != null))) {
            this.f11236c = m10533a;
            m10524h();
            try {
                this.f11235b = new FileWriter(this.f11236c, true);
            } catch (IOException unused) {
                this.f11235b = null;
                SLog.m10500e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
            }
            m10519a(m10533a);
        }
        return this.f11235b;
    }

    /* renamed from: h */
    private void m10524h() {
        try {
            if (this.f11235b != null) {
                this.f11235b.flush();
                this.f11235b.close();
            }
        } catch (IOException e2) {
            SLog.m10501e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
        }
    }

    /* renamed from: i */
    private void m10525i() {
        synchronized (this) {
            if (this.f11240g == this.f11238e) {
                this.f11240g = this.f11239f;
                this.f11241h = this.f11238e;
            } else {
                this.f11240g = this.f11238e;
                this.f11241h = this.f11239f;
            }
        }
    }

    /* renamed from: a */
    public void m10526a() {
        if (this.f11244k.hasMessages(1024)) {
            this.f11244k.removeMessages(1024);
        }
        this.f11244k.sendEmptyMessage(1024);
    }

    /* renamed from: b */
    public void m10528b() {
        m10524h();
        this.f11243j.quit();
    }

    /* renamed from: c */
    public C3275b m10529c() {
        return this.f11234a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        m10520a(m10518e().m10565a(i2, thread, j2, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        m10522f();
        return true;
    }

    public C3274a(int i2, boolean z, C3280g c3280g, C3275b c3275b) {
        super(i2, z, c3280g);
        this.f11242i = false;
        m10527a(c3275b);
        this.f11238e = new C3279f();
        this.f11239f = new C3279f();
        this.f11240g = this.f11238e;
        this.f11241h = this.f11239f;
        this.f11237d = new char[c3275b.m10541c()];
        this.f11243j = new HandlerThread(c3275b.m10537b(), c3275b.m10544d());
        HandlerThread handlerThread = this.f11243j;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f11243j.isAlive() || this.f11243j.getLooper() == null) {
            return;
        }
        this.f11244k = new Handler(this.f11243j.getLooper(), this);
    }

    /* renamed from: b */
    private boolean m10521b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.m10498d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    /* renamed from: a */
    private void m10520a(String str) {
        this.f11240g.m10561a(str);
        if (this.f11240g.m10560a() >= m10529c().m10541c()) {
            m10526a();
        }
    }

    /* renamed from: a */
    private void m10519a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (m10521b(file2)) {
                String name = file2.getName();
                if (C3275b.m10530a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? C2084a.f6123e : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.m10498d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    /* renamed from: a */
    public void m10527a(C3275b c3275b) {
        this.f11234a = c3275b;
    }
}
