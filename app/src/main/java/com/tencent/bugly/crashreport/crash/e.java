package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f6292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f6293i = new Object();
    protected final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b f6294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.tencent.bugly.crashreport.common.strategy.a f6295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.tencent.bugly.crashreport.common.info.a f6296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f6297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f6298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f6299g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6300j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.f6294b = bVar;
        this.f6295c = aVar;
        this.f6296d = aVar2;
    }

    public synchronized void a() {
        if (this.f6300j >= 10) {
            an.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f6299g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                an.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f6298f = defaultUncaughtExceptionHandler;
                this.f6297e = defaultUncaughtExceptionHandler;
            } else {
                an.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f6297e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f6300j++;
        an.a("registered java monitor: %s", toString());
    }

    public synchronized void b() {
        this.f6299g = false;
        an.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            an.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f6297e);
            this.f6300j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f6293i) {
            b(thread, th, true, null, null);
        }
    }

    public void b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            an.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                an.a("this class has handled this exception", new Object[0]);
                if (this.f6298f != null) {
                    an.a("call system handler", new Object[0]);
                    this.f6298f.uncaughtException(thread, th);
                } else {
                    a(thread, th);
                }
            }
        } else {
            an.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f6299g) {
                an.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6297e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        an.e("sys default last handle start!", new Object[0]);
                        this.f6297e.uncaughtException(thread, th);
                        an.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6298f != null) {
                        an.e("system handle start!", new Object[0]);
                        this.f6298f.uncaughtException(thread, th);
                        an.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        an.e("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        an.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f6295c.b()) {
                an.d("no remote but still store!", new Object[0]);
            }
            if (!this.f6295c.c().f6195g && this.f6295c.b()) {
                an.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", aq.a(), this.f6296d.f6176e, thread.getName(), aq.a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f6297e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        an.e("sys default last handle start!", new Object[0]);
                        this.f6297e.uncaughtException(thread, th);
                        an.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6298f != null) {
                        an.e("system handle start!", new Object[0]);
                        this.f6298f.uncaughtException(thread, th);
                        an.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        an.e("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        an.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanA = a(thread, th, z, str, bArr);
            if (crashDetailBeanA == null) {
                an.e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f6297e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        an.e("sys default last handle start!", new Object[0]);
                        this.f6297e.uncaughtException(thread, th);
                        an.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6298f != null) {
                        an.e("system handle start!", new Object[0]);
                        this.f6298f.uncaughtException(thread, th);
                        an.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        an.e("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        an.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", aq.a(), this.f6296d.f6176e, thread.getName(), aq.a(th), crashDetailBeanA);
            if (!this.f6294b.a(crashDetailBeanA)) {
                this.f6294b.a(crashDetailBeanA, 3000L, z);
            }
            if (z) {
                this.f6294b.b(crashDetailBeanA);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f6297e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    an.e("sys default last handle start!", new Object[0]);
                    this.f6297e.uncaughtException(thread, th);
                    an.e("sys default last handle end!", new Object[0]);
                } else if (this.f6298f != null) {
                    an.e("system handle start!", new Object[0]);
                    this.f6298f.uncaughtException(thread, th);
                    an.e("system handle end!", new Object[0]);
                } else {
                    an.e("crashreport last handle start!", new Object[0]);
                    a(thread, th);
                    an.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!an.a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f6297e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        an.e("sys default last handle start!", new Object[0]);
                        this.f6297e.uncaughtException(thread, th);
                        an.e("sys default last handle end!", new Object[0]);
                    } else if (this.f6298f != null) {
                        an.e("system handle start!", new Object[0]);
                        this.f6298f.uncaughtException(thread, th);
                        an.e("system handle end!", new Object[0]);
                    } else {
                        an.e("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        an.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f6297e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        an.e("sys default last handle start!", new Object[0]);
                        this.f6297e.uncaughtException(thread, th);
                        an.e("sys default last handle end!", new Object[0]);
                    } else if (this.f6298f != null) {
                        an.e("system handle start!", new Object[0]);
                        this.f6298f.uncaughtException(thread, th);
                        an.e("system handle end!", new Object[0]);
                    } else {
                        an.e("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        an.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    protected void a(Thread thread, Throwable th) {
        an.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public CrashDetailBean a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String strA;
        boolean z2 = false;
        if (th == null) {
            an.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean zL = c.a().l();
        String str2 = (zL && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (zL && z) {
            an.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
        crashDetailBean.F = this.f6296d.p();
        crashDetailBean.G = this.f6296d.o();
        crashDetailBean.H = this.f6296d.q();
        crashDetailBean.w = aq.a(this.a, c.f6267e, c.f6270h);
        crashDetailBean.y = ap.a();
        Object[] objArr = new Object[1];
        byte[] bArr2 = crashDetailBean.y;
        objArr[0] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        an.a("user log size:%d", objArr);
        crashDetailBean.f6216b = z ? 0 : 2;
        crashDetailBean.f6219e = this.f6296d.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f6296d;
        crashDetailBean.f6220f = aVar.p;
        crashDetailBean.f6221g = aVar.w();
        crashDetailBean.f6227m = this.f6296d.g();
        String name = th.getClass().getName();
        String strB = b(th, 1000);
        if (strB == null) {
            strB = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        an.e("stack frame :%d, has cause %b", objArr2);
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.f6228n = cause.getClass().getName();
            crashDetailBean.o = b(cause, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(strB);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f6228n);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(crashDetailBean.o);
            sb.append("\n");
            strA = a(cause, c.f6268f);
            sb.append(strA);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.f6228n = name;
            crashDetailBean.o = strB + "" + str2;
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = string;
            strA = a(th, c.f6268f);
            crashDetailBean.q = strA;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = aq.a(c.f6268f, false);
            crashDetailBean.A = this.f6296d.f6176e;
            crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.z.put(crashDetailBean.B, strA);
            crashDetailBean.I = this.f6296d.y();
            crashDetailBean.f6222h = this.f6296d.v();
            crashDetailBean.f6223i = this.f6296d.J();
            crashDetailBean.N = this.f6296d.a;
            crashDetailBean.O = this.f6296d.a();
            crashDetailBean.Q = this.f6296d.H();
            crashDetailBean.R = this.f6296d.I();
            crashDetailBean.S = this.f6296d.B();
            crashDetailBean.T = this.f6296d.G();
        } catch (Throwable th2) {
            an.e("handle crash error %s", th2.toString());
        }
        if (z) {
            this.f6294b.c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.P = new HashMap(1);
                crashDetailBean.P.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.U = bArr;
            }
        }
        return crashDetailBean;
    }

    private boolean a(Thread thread) {
        synchronized (f6293i) {
            if (f6292h != null && thread.getName().equals(f6292h)) {
                return true;
            }
            f6292h = thread.getName();
            return false;
        }
    }

    private boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i2 >= 0 && th.getMessage().length() > i2) {
            return th.getMessage().substring(0, i2) + "\n[Message over limit size:" + i2 + ", has been cutted!]";
        }
        return th.getMessage();
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f6195g != this.f6299g) {
                an.a("java changed to %b", Boolean.valueOf(strategyBean.f6195g));
                if (strategyBean.f6195g) {
                    a();
                } else {
                    b();
                }
            }
        }
    }

    public static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            an.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }
}
