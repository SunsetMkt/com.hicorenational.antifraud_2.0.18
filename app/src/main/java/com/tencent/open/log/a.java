package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a extends Tracer implements Handler.Callback {
    private b a;

    /* JADX INFO: renamed from: b */
    private FileWriter f6863b;

    /* JADX INFO: renamed from: c */
    private File f6864c;

    /* JADX INFO: renamed from: d */
    private char[] f6865d;

    /* JADX INFO: renamed from: e */
    private volatile f f6866e;

    /* JADX INFO: renamed from: f */
    private volatile f f6867f;

    /* JADX INFO: renamed from: g */
    private volatile f f6868g;

    /* JADX INFO: renamed from: h */
    private volatile f f6869h;

    /* JADX INFO: renamed from: i */
    private volatile boolean f6870i;

    /* JADX INFO: renamed from: j */
    private HandlerThread f6871j;

    /* JADX INFO: renamed from: k */
    private Handler f6872k;

    public a(b bVar) {
        this(c.f6882b, true, g.a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f6871j && !this.f6870i) {
            this.f6870i = true;
            i();
            try {
                try {
                    this.f6869h.a(g(), this.f6865d);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.f6870i = false;
            } finally {
                this.f6869h.b();
            }
        }
    }

    private Writer g() {
        File fileA = c().a();
        if (fileA != null && ((fileA != null && !fileA.equals(this.f6864c)) || (this.f6863b == null && fileA != null))) {
            this.f6864c = fileA;
            h();
            try {
                this.f6863b = new FileWriter(this.f6864c, true);
            } catch (IOException unused) {
                this.f6863b = null;
                SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
            }
            a(fileA);
        }
        return this.f6863b;
    }

    private void h() {
        try {
            if (this.f6863b != null) {
                this.f6863b.flush();
                this.f6863b.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f6868g == this.f6866e) {
                this.f6868g = this.f6867f;
                this.f6869h = this.f6866e;
            } else {
                this.f6868g = this.f6866e;
                this.f6869h = this.f6867f;
            }
        }
    }

    public void a() {
        if (this.f6872k.hasMessages(1024)) {
            this.f6872k.removeMessages(1024);
        }
        this.f6872k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f6871j.quit();
    }

    public b c() {
        return this.a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, g gVar, b bVar) {
        super(i2, z, gVar);
        this.f6870i = false;
        a(bVar);
        this.f6866e = new f();
        this.f6867f = new f();
        this.f6868g = this.f6866e;
        this.f6869h = this.f6867f;
        this.f6865d = new char[bVar.c()];
        this.f6871j = new HandlerThread(bVar.b(), bVar.d());
        HandlerThread handlerThread = this.f6871j;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f6871j.isAlive() || this.f6871j.getLooper() == null) {
            return;
        }
        this.f6872k = new Handler(this.f6871j.getLooper(), this);
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    private void a(String str) {
        this.f6868g.a(str);
        if (this.f6868g.a() >= c().c()) {
            a();
        }
    }

    private void a(File file) {
        File[] fileArrListFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (fileArrListFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? com.heytap.mcssdk.constant.a.f3869e : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
