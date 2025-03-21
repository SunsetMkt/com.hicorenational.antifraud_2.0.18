package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8953a = false;

    /* renamed from: b, reason: collision with root package name */
    public static a f8954b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f8955c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static long f8956d = 300000;

    /* renamed from: e, reason: collision with root package name */
    private static long f8957e = 30000;

    /* renamed from: f, reason: collision with root package name */
    private static long f8958f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f8959g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f8960h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f8961i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f8962j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f8963k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Class<?> f8964l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f8965m = true;

    static /* synthetic */ int g() {
        int i2 = f8959g;
        f8959g = i2 + 1;
        return i2;
    }

    private static void m() {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        if (b2 == null) {
            return;
        }
        String str = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                str = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (str == null) {
            str = "unknown";
        } else if (z) {
            b2.a(true);
        } else {
            str = "background";
        }
        b2.w = str;
    }

    private static void n() {
        f8961i = System.currentTimeMillis();
        f8954b.a(1, false, 0L);
        an.a("[session] launch app, new start", new Object[0]);
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (f8953a) {
            return;
        }
        f8965m = com.tencent.bugly.crashreport.common.info.a.a(context).f8981h;
        f8954b = new a(context, f8965m);
        f8953a = true;
        if (buglyStrategy != null) {
            f8964l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            am.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.c(context, buglyStrategy);
                }
            }, j2);
        }
    }

    @TargetApi(14)
    private static void d(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f8963k != null) {
                application.unregisterActivityLifecycleCallbacks(f8963k);
            }
        } catch (Exception e2) {
            if (an.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            if (!b(context)) {
                return;
            } else {
                z = false;
            }
        }
        m();
        if (z) {
            c(context);
        }
        if (f8965m) {
            n();
            f8954b.a();
            f8954b.b(21600000L);
        }
    }

    private static boolean b(Context context) {
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
        List<UserInfoBean> a3 = f8954b.a(a2.f8978e);
        if (a3 == null) {
            return true;
        }
        for (int i2 = 0; i2 < a3.size(); i2++) {
            UserInfoBean userInfoBean = a3.get(i2);
            if (userInfoBean.n.equals(a2.p) && userInfoBean.f8928b == 1) {
                long b2 = aq.b();
                if (b2 <= 0) {
                    return true;
                }
                if (userInfoBean.f8931e >= b2) {
                    if (userInfoBean.f8932f <= 0) {
                        f8954b.b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().q;
        }
        f8958f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        a aVar = f8954b;
        if (aVar != null && !z) {
            aVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.q;
        if (j2 > 0) {
            f8957e = j2;
        }
        int i2 = strategyBean.w;
        if (i2 > 0) {
            f8955c = i2;
        }
        long j3 = strategyBean.x;
        if (j3 > 0) {
            f8956d = j3;
        }
    }

    @TargetApi(14)
    private static void c(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f8963k == null) {
                f8963k = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.crashreport.biz.b.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f8964l == null || b.f8964l.getName().equals(name)) {
                            an.c(">>> %s onCreated <<<", name);
                            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                            if (b2 != null) {
                                b2.M.add(b.b(name, "onCreated"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f8964l == null || b.f8964l.getName().equals(name)) {
                            an.c(">>> %s onDestroyed <<<", name);
                            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                            if (b2 != null) {
                                b2.M.add(b.b(name, "onDestroyed"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f8964l == null || b.f8964l.getName().equals(name)) {
                            an.c(">>> %s onPaused <<<", name);
                            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                            if (b2 == null) {
                                return;
                            }
                            b2.M.add(b.b(name, "onPaused"));
                            b2.a(false);
                            b2.y = System.currentTimeMillis();
                            long j2 = b2.y;
                            b2.z = j2 - b2.x;
                            long unused = b.f8960h = j2;
                            if (b2.z < 0) {
                                b2.z = 0L;
                            }
                            if (activity != null) {
                                b2.w = "background";
                            } else {
                                b2.w = "unknown";
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f8964l == null || b.f8964l.getName().equals(name)) {
                            an.c(">>> %s onResumed <<<", name);
                            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                            if (b2 == null) {
                                return;
                            }
                            b2.M.add(b.b(name, "onResumed"));
                            b2.a(true);
                            b2.w = name;
                            b2.x = System.currentTimeMillis();
                            b2.A = b2.x - b.f8961i;
                            long j2 = b2.x - b.f8960h;
                            if (j2 > (b.f8958f > 0 ? b.f8958f : b.f8957e)) {
                                b2.d();
                                b.g();
                                an.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f8957e / 1000));
                                if (b.f8959g % b.f8955c == 0) {
                                    b.f8954b.a(4, b.f8965m, 0L);
                                    return;
                                }
                                b.f8954b.a(4, false, 0L);
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - b.f8962j > b.f8956d) {
                                    long unused = b.f8962j = currentTimeMillis;
                                    an.a("add a timer to upload hot start user info", new Object[0]);
                                    if (b.f8965m) {
                                        b.f8954b.a(b.f8956d);
                                    }
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                };
            }
            application.registerActivityLifecycleCallbacks(f8963k);
        } catch (Exception e2) {
            if (an.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        return aq.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        a aVar = f8954b;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!f8953a || context == null) {
            return;
        }
        d(context);
        f8953a = false;
    }
}
