package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.C3277d;
import com.tencent.open.utils.C3289g;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c */
    private static boolean f11228c = false;
    public static SLog instance;

    /* renamed from: a */
    protected C3274a f11229a;

    /* renamed from: b */
    private Tracer f11230b;

    private SLog() {
    }

    /* renamed from: d */
    private void m10497d() {
        this.f11229a = new C3274a(new C3275b(m10495a(), C3276c.f11267m, C3276c.f11261g, C3276c.f11262h, C3276c.f11257c, C3276c.f11263i, 10, C3276c.f11259e, C3276c.f11268n));
    }

    /* renamed from: e */
    public static final void m10500e(String str, String str2) {
        getInstance().m10510a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().m10512c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    instance = new SLog();
                    instance.m10497d();
                    f11228c = true;
                }
            }
        }
        return instance;
    }

    /* renamed from: i */
    public static final void m10502i(String str, String str2) {
        getInstance().m10510a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().m10511b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    /* renamed from: u */
    public static final void m10504u(String str, String str2) {
        getInstance().m10510a(32, str, str2, null);
    }

    /* renamed from: v */
    public static final void m10506v(String str, String str2) {
        getInstance().m10510a(1, str, str2, null);
    }

    /* renamed from: w */
    public static final void m10508w(String str, String str2) {
        getInstance().m10510a(8, str, str2, null);
    }

    /* renamed from: a */
    protected void m10510a(int i2, String str, String str2, Throwable th) {
        if (f11228c) {
            String m10606b = C3289g.m10606b();
            if (!TextUtils.isEmpty(m10606b)) {
                String str3 = m10606b + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f11229a == null) {
                    return;
                }
                C3278e.f11273a.m10514a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f11229a.m10514a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f11228c = false;
            }
        }
        C3278e.f11273a.m10514a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (C3277d.a.m10549a(C3276c.f11256b, i2)) {
            C3274a c3274a = this.f11229a;
            if (c3274a == null) {
                return;
            } else {
                c3274a.m10514a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
        }
        Tracer tracer = this.f11230b;
        if (tracer != null) {
            try {
                tracer.m10514a(i2, Thread.currentThread(), System.currentTimeMillis(), str, m10496a(str2), th);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    protected void m10511b() {
        C3274a c3274a = this.f11229a;
        if (c3274a != null) {
            c3274a.m10526a();
            this.f11229a.m10528b();
            this.f11229a = null;
        }
    }

    /* renamed from: c */
    protected void m10512c() {
        C3274a c3274a = this.f11229a;
        if (c3274a != null) {
            c3274a.m10526a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f11230b = tracer;
    }

    /* renamed from: e */
    public static final void m10501e(String str, String str2, Throwable th) {
        getInstance().m10510a(16, str, str2, th);
    }

    /* renamed from: i */
    public static final void m10503i(String str, String str2, Throwable th) {
        getInstance().m10510a(4, str, str2, th);
    }

    /* renamed from: u */
    public static final void m10505u(String str, String str2, Throwable th) {
        getInstance().m10510a(32, str, str2, th);
    }

    /* renamed from: v */
    public static final void m10507v(String str, String str2, Throwable th) {
        getInstance().m10510a(1, str, str2, th);
    }

    /* renamed from: w */
    public static final void m10509w(String str, String str2, Throwable th) {
        getInstance().m10510a(8, str, str2, th);
    }

    /* renamed from: d */
    public static final void m10498d(String str, String str2) {
        getInstance().m10510a(2, str, str2, null);
    }

    /* renamed from: d */
    public static final void m10499d(String str, String str2, Throwable th) {
        getInstance().m10510a(2, str, str2, th);
    }

    /* renamed from: a */
    private String m10496a(String str) {
        return TextUtils.isEmpty(str) ? "" : C3277d.m10547a(str) ? "xxxxxx" : str;
    }

    /* renamed from: a */
    protected static File m10495a() {
        String str = C3276c.f11258d;
        try {
            C3277d.c m10551b = C3277d.b.m10551b();
            if (m10551b != null && m10551b.m10558c() > C3276c.f11260f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(C3289g.m10607c(), str);
        } catch (Throwable th) {
            m10501e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}
