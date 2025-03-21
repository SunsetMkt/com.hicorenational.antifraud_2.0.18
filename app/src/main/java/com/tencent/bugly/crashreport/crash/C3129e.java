package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.e */
/* loaded from: classes2.dex */
public class C3129e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h */
    private static String f10408h;

    /* renamed from: i */
    private static final Object f10409i = new Object();

    /* renamed from: a */
    protected final Context f10410a;

    /* renamed from: b */
    protected final C3126b f10411b;

    /* renamed from: c */
    protected final C3116a f10412c;

    /* renamed from: d */
    protected final C3113a f10413d;

    /* renamed from: e */
    protected Thread.UncaughtExceptionHandler f10414e;

    /* renamed from: f */
    protected Thread.UncaughtExceptionHandler f10415f;

    /* renamed from: g */
    protected boolean f10416g = false;

    /* renamed from: j */
    private int f10417j;

    public C3129e(Context context, C3126b c3126b, C3116a c3116a, C3113a c3113a) {
        this.f10410a = context;
        this.f10411b = c3126b;
        this.f10412c = c3116a;
        this.f10413d = c3113a;
    }

    /* renamed from: a */
    public synchronized void m9748a() {
        if (this.f10417j >= 10) {
            C3151an.m9915a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f10416g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C3151an.m9915a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f10415f = defaultUncaughtExceptionHandler;
                this.f10414e = defaultUncaughtExceptionHandler;
            } else {
                C3151an.m9915a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f10414e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f10417j++;
        C3151an.m9915a("registered java monitor: %s", toString());
    }

    /* renamed from: b */
    public synchronized void m9751b() {
        this.f10416g = false;
        C3151an.m9915a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C3151an.m9915a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f10414e);
            this.f10417j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f10409i) {
            m9752b(thread, th, true, null, null);
        }
    }

    /* renamed from: b */
    public void m9752b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            C3151an.m9923e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m9745a(thread)) {
                C3151an.m9915a("this class has handled this exception", new Object[0]);
                if (this.f10415f != null) {
                    C3151an.m9915a("call system handler", new Object[0]);
                    this.f10415f.uncaughtException(thread, th);
                } else {
                    m9750a(thread, th);
                }
            }
        } else {
            C3151an.m9923e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f10416g) {
                C3151an.m9921c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f10414e;
                    if (uncaughtExceptionHandler != null && m9744a(uncaughtExceptionHandler)) {
                        C3151an.m9923e("sys default last handle start!", new Object[0]);
                        this.f10414e.uncaughtException(thread, th);
                        C3151an.m9923e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10415f != null) {
                        C3151an.m9923e("system handle start!", new Object[0]);
                        this.f10415f.uncaughtException(thread, th);
                        C3151an.m9923e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3151an.m9923e("crashreport last handle start!", new Object[0]);
                        m9750a(thread, th);
                        C3151an.m9923e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f10412c.m9643b()) {
                C3151an.m9922d("no remote but still store!", new Object[0]);
            }
            if (!this.f10412c.m9644c().f10230g && this.f10412c.m9643b()) {
                C3151an.m9923e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C3126b.m9684a(z ? "JAVA_CRASH" : "JAVA_CATCH", C3154aq.m9952a(), this.f10413d.f10197e, thread.getName(), C3154aq.m9957a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f10414e;
                    if (uncaughtExceptionHandler2 != null && m9744a(uncaughtExceptionHandler2)) {
                        C3151an.m9923e("sys default last handle start!", new Object[0]);
                        this.f10414e.uncaughtException(thread, th);
                        C3151an.m9923e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10415f != null) {
                        C3151an.m9923e("system handle start!", new Object[0]);
                        this.f10415f.uncaughtException(thread, th);
                        C3151an.m9923e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3151an.m9923e("crashreport last handle start!", new Object[0]);
                        m9750a(thread, th);
                        C3151an.m9923e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean m9747a = m9747a(thread, th, z, str, bArr);
            if (m9747a == null) {
                C3151an.m9923e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f10414e;
                    if (uncaughtExceptionHandler3 != null && m9744a(uncaughtExceptionHandler3)) {
                        C3151an.m9923e("sys default last handle start!", new Object[0]);
                        this.f10414e.uncaughtException(thread, th);
                        C3151an.m9923e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10415f != null) {
                        C3151an.m9923e("system handle start!", new Object[0]);
                        this.f10415f.uncaughtException(thread, th);
                        C3151an.m9923e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C3151an.m9923e("crashreport last handle start!", new Object[0]);
                        m9750a(thread, th);
                        C3151an.m9923e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            C3126b.m9684a(z ? "JAVA_CRASH" : "JAVA_CATCH", C3154aq.m9952a(), this.f10413d.f10197e, thread.getName(), C3154aq.m9957a(th), m9747a);
            if (!this.f10411b.m9694a(m9747a)) {
                this.f10411b.m9691a(m9747a, 3000L, z);
            }
            if (z) {
                this.f10411b.m9699b(m9747a);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f10414e;
                if (uncaughtExceptionHandler4 != null && m9744a(uncaughtExceptionHandler4)) {
                    C3151an.m9923e("sys default last handle start!", new Object[0]);
                    this.f10414e.uncaughtException(thread, th);
                    C3151an.m9923e("sys default last handle end!", new Object[0]);
                } else if (this.f10415f != null) {
                    C3151an.m9923e("system handle start!", new Object[0]);
                    this.f10415f.uncaughtException(thread, th);
                    C3151an.m9923e("system handle end!", new Object[0]);
                } else {
                    C3151an.m9923e("crashreport last handle start!", new Object[0]);
                    m9750a(thread, th);
                    C3151an.m9923e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!C3151an.m9916a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f10414e;
                    if (uncaughtExceptionHandler5 != null && m9744a(uncaughtExceptionHandler5)) {
                        C3151an.m9923e("sys default last handle start!", new Object[0]);
                        this.f10414e.uncaughtException(thread, th);
                        C3151an.m9923e("sys default last handle end!", new Object[0]);
                    } else if (this.f10415f != null) {
                        C3151an.m9923e("system handle start!", new Object[0]);
                        this.f10415f.uncaughtException(thread, th);
                        C3151an.m9923e("system handle end!", new Object[0]);
                    } else {
                        C3151an.m9923e("crashreport last handle start!", new Object[0]);
                        m9750a(thread, th);
                        C3151an.m9923e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f10414e;
                    if (uncaughtExceptionHandler6 != null && m9744a(uncaughtExceptionHandler6)) {
                        C3151an.m9923e("sys default last handle start!", new Object[0]);
                        this.f10414e.uncaughtException(thread, th);
                        C3151an.m9923e("sys default last handle end!", new Object[0]);
                    } else if (this.f10415f != null) {
                        C3151an.m9923e("system handle start!", new Object[0]);
                        this.f10415f.uncaughtException(thread, th);
                        C3151an.m9923e("system handle end!", new Object[0]);
                    } else {
                        C3151an.m9923e("crashreport last handle start!", new Object[0]);
                        m9750a(thread, th);
                        C3151an.m9923e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    /* renamed from: a */
    protected void m9750a(Thread thread, Throwable th) {
        C3151an.m9923e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* renamed from: a */
    public CrashDetailBean m9747a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String m9743a;
        boolean z2 = false;
        if (th == null) {
            C3151an.m9922d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m9726l = C3127c.m9705a().m9726l();
        String str2 = (m9726l && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m9726l && z) {
            C3151an.m9923e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f10268C = C3114b.m9611i();
        crashDetailBean.f10269D = C3114b.m9607g();
        crashDetailBean.f10270E = C3114b.m9615k();
        crashDetailBean.f10271F = this.f10413d.m9583p();
        crashDetailBean.f10272G = this.f10413d.m9582o();
        crashDetailBean.f10273H = this.f10413d.m9584q();
        crashDetailBean.f10311w = C3154aq.m9954a(this.f10410a, C3127c.f10364e, C3127c.f10367h);
        crashDetailBean.f10313y = C3153ap.m9934a();
        Object[] objArr = new Object[1];
        byte[] bArr2 = crashDetailBean.f10313y;
        objArr[0] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        C3151an.m9915a("user log size:%d", objArr);
        crashDetailBean.f10290b = z ? 0 : 2;
        crashDetailBean.f10293e = this.f10413d.m9575h();
        C3113a c3113a = this.f10413d;
        crashDetailBean.f10294f = c3113a.f10208p;
        crashDetailBean.f10295g = c3113a.m9590w();
        crashDetailBean.f10301m = this.f10413d.m9573g();
        String name = th.getClass().getName();
        String m9746b = m9746b(th, 1000);
        if (m9746b == null) {
            m9746b = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C3151an.m9923e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f10302n = th2.getClass().getName();
            crashDetailBean.f10303o = m9746b(th2, 1000);
            if (crashDetailBean.f10303o == null) {
                crashDetailBean.f10303o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f10304p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(m9746b);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f10302n);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(crashDetailBean.f10303o);
            sb.append("\n");
            m9743a = m9743a(th2, C3127c.f10365f);
            sb.append(m9743a);
            crashDetailBean.f10305q = sb.toString();
        } else {
            crashDetailBean.f10302n = name;
            crashDetailBean.f10303o = m9746b + "" + str2;
            if (crashDetailBean.f10303o == null) {
                crashDetailBean.f10303o = "";
            }
            crashDetailBean.f10304p = stackTraceElement;
            m9743a = m9743a(th, C3127c.f10365f);
            crashDetailBean.f10305q = m9743a;
        }
        crashDetailBean.f10306r = System.currentTimeMillis();
        crashDetailBean.f10309u = C3154aq.m9981b(crashDetailBean.f10305q.getBytes());
        try {
            crashDetailBean.f10314z = C3154aq.m9962a(C3127c.f10365f, false);
            crashDetailBean.f10266A = this.f10413d.f10197e;
            crashDetailBean.f10267B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f10314z.put(crashDetailBean.f10267B, m9743a);
            crashDetailBean.f10274I = this.f10413d.m9592y();
            crashDetailBean.f10296h = this.f10413d.m9589v();
            crashDetailBean.f10297i = this.f10413d.m9544J();
            crashDetailBean.f10279N = this.f10413d.f10160a;
            crashDetailBean.f10280O = this.f10413d.m9559a();
            crashDetailBean.f10282Q = this.f10413d.m9542H();
            crashDetailBean.f10283R = this.f10413d.m9543I();
            crashDetailBean.f10284S = this.f10413d.m9536B();
            crashDetailBean.f10285T = this.f10413d.m9541G();
        } catch (Throwable th3) {
            C3151an.m9923e("handle crash error %s", th3.toString());
        }
        if (z) {
            this.f10411b.m9700c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.f10281P = new HashMap(1);
                crashDetailBean.f10281P.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.f10286U = bArr;
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private boolean m9745a(Thread thread) {
        synchronized (f10409i) {
            if (f10408h != null && thread.getName().equals(f10408h)) {
                return true;
            }
            f10408h = thread.getName();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m9744a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
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

    /* renamed from: b */
    public static String m9746b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i2 >= 0 && th.getMessage().length() > i2) {
            return th.getMessage().substring(0, i2) + "\n[Message over limit size:" + i2 + ", has been cutted!]";
        }
        return th.getMessage();
    }

    /* renamed from: a */
    public synchronized void m9749a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f10230g != this.f10416g) {
                C3151an.m9915a("java changed to %b", Boolean.valueOf(strategyBean.f10230g));
                if (strategyBean.f10230g) {
                    m9748a();
                } else {
                    m9751b();
                }
            }
        }
    }

    /* renamed from: a */
    public static String m9743a(Throwable th, int i2) {
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
            C3151an.m9923e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }
}
