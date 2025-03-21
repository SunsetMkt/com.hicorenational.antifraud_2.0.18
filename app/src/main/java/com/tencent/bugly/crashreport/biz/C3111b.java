package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.b */
/* loaded from: classes2.dex */
public class C3111b {

    /* renamed from: a */
    public static boolean f10112a = false;

    /* renamed from: b */
    public static C3110a f10113b = null;

    /* renamed from: c */
    private static int f10114c = 10;

    /* renamed from: d */
    private static long f10115d = 300000;

    /* renamed from: e */
    private static long f10116e = 30000;

    /* renamed from: f */
    private static long f10117f = 0;

    /* renamed from: g */
    private static int f10118g = 0;

    /* renamed from: h */
    private static long f10119h = 0;

    /* renamed from: i */
    private static long f10120i = 0;

    /* renamed from: j */
    private static long f10121j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f10122k = null;

    /* renamed from: l */
    private static Class<?> f10123l = null;

    /* renamed from: m */
    private static boolean f10124m = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.b$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f10125a;

        /* renamed from: b */
        final /* synthetic */ BuglyStrategy f10126b;

        AnonymousClass1(Context context, BuglyStrategy buglyStrategy) {
            r1 = context;
            r2 = buglyStrategy;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3111b.m9503c(r1, r2);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.b$2 */
    static class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass2() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                C3151an.m9921c(">>> %s onCreated <<<", name);
                C3113a m9532b = C3113a.m9532b();
                if (m9532b != null) {
                    m9532b.f10146M.add(C3111b.m9497b(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                C3151an.m9921c(">>> %s onDestroyed <<<", name);
                C3113a m9532b = C3113a.m9532b();
                if (m9532b != null) {
                    m9532b.f10146M.add(C3111b.m9497b(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                C3151an.m9921c(">>> %s onPaused <<<", name);
                C3113a m9532b = C3113a.m9532b();
                if (m9532b == null) {
                    return;
                }
                m9532b.f10146M.add(C3111b.m9497b(name, "onPaused"));
                m9532b.m9558a(false);
                m9532b.f10217y = System.currentTimeMillis();
                long j2 = m9532b.f10217y;
                m9532b.f10218z = j2 - m9532b.f10216x;
                long unused = C3111b.f10119h = j2;
                if (m9532b.f10218z < 0) {
                    m9532b.f10218z = 0L;
                }
                if (activity != null) {
                    m9532b.f10215w = "background";
                } else {
                    m9532b.f10215w = "unknown";
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                C3151an.m9921c(">>> %s onResumed <<<", name);
                C3113a m9532b = C3113a.m9532b();
                if (m9532b == null) {
                    return;
                }
                m9532b.f10146M.add(C3111b.m9497b(name, "onResumed"));
                m9532b.m9558a(true);
                m9532b.f10215w = name;
                m9532b.f10216x = System.currentTimeMillis();
                m9532b.f10134A = m9532b.f10216x - C3111b.f10120i;
                long j2 = m9532b.f10216x - C3111b.f10119h;
                if (j2 > (C3111b.f10117f > 0 ? C3111b.f10117f : C3111b.f10116e)) {
                    m9532b.m9567d();
                    C3111b.m9508g();
                    C3151an.m9915a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(C3111b.f10116e / 1000));
                    if (C3111b.f10118g % C3111b.f10114c == 0) {
                        C3111b.f10113b.m9483a(4, C3111b.f10124m, 0L);
                        return;
                    }
                    C3111b.f10113b.m9483a(4, false, 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - C3111b.f10121j > C3111b.f10115d) {
                        long unused = C3111b.f10121j = currentTimeMillis;
                        C3151an.m9915a("add a timer to upload hot start user info", new Object[0]);
                        if (C3111b.f10124m) {
                            C3111b.f10113b.m9484a(C3111b.f10115d);
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
    }

    /* renamed from: g */
    static /* synthetic */ int m9508g() {
        int i2 = f10118g;
        f10118g = i2 + 1;
        return i2;
    }

    /* renamed from: m */
    private static void m9514m() {
        C3113a m9532b = C3113a.m9532b();
        if (m9532b == null) {
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
            m9532b.m9558a(true);
        } else {
            str = "background";
        }
        m9532b.f10215w = str;
    }

    /* renamed from: n */
    private static void m9515n() {
        f10120i = System.currentTimeMillis();
        f10113b.m9483a(1, false, 0L);
        C3151an.m9915a("[session] launch app, new start", new Object[0]);
    }

    /* renamed from: a */
    public static void m9493a(Context context, BuglyStrategy buglyStrategy) {
        long j2;
        if (f10112a) {
            return;
        }
        f10124m = C3113a.m9531a(context).f10200h;
        f10113b = new C3110a(context, f10124m);
        f10112a = true;
        if (buglyStrategy != null) {
            f10123l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            m9503c(context, buglyStrategy);
        } else {
            C3150am.m9906a().m9909a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1

                /* renamed from: a */
                final /* synthetic */ Context f10125a;

                /* renamed from: b */
                final /* synthetic */ BuglyStrategy f10126b;

                AnonymousClass1(Context context2, BuglyStrategy buglyStrategy2) {
                    r1 = context2;
                    r2 = buglyStrategy2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3111b.m9503c(r1, r2);
                }
            }, j2);
        }
    }

    @TargetApi(14)
    /* renamed from: d */
    private static void m9505d(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f10122k != null) {
                application.unregisterActivityLifecycleCallbacks(f10122k);
            }
        } catch (Exception e2) {
            if (C3151an.m9916a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m9503c(Context context, BuglyStrategy buglyStrategy) {
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
            if (!m9499b(context)) {
                return;
            } else {
                z = false;
            }
        }
        m9514m();
        if (z) {
            m9502c(context);
        }
        if (f10124m) {
            m9515n();
            f10113b.m9482a();
            f10113b.m9487b(21600000L);
        }
    }

    /* renamed from: b */
    private static boolean m9499b(Context context) {
        C3113a m9531a = C3113a.m9531a(context);
        List<UserInfoBean> m9481a = f10113b.m9481a(m9531a.f10197e);
        if (m9481a == null) {
            return true;
        }
        for (int i2 = 0; i2 < m9481a.size(); i2++) {
            UserInfoBean userInfoBean = m9481a.get(i2);
            if (userInfoBean.f10093n.equals(m9531a.f10208p) && userInfoBean.f10081b == 1) {
                long m9978b = C3154aq.m9978b();
                if (m9978b <= 0) {
                    return true;
                }
                if (userInfoBean.f10084e >= m9978b) {
                    if (userInfoBean.f10085f <= 0) {
                        f10113b.m9486b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m9491a(long j2) {
        if (j2 < 0) {
            j2 = C3116a.m9635a().m9644c().f10240q;
        }
        f10117f = j2;
    }

    /* renamed from: a */
    public static void m9494a(StrategyBean strategyBean, boolean z) {
        C3110a c3110a = f10113b;
        if (c3110a != null && !z) {
            c3110a.m9486b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.f10240q;
        if (j2 > 0) {
            f10116e = j2;
        }
        int i2 = strategyBean.f10246w;
        if (i2 > 0) {
            f10114c = i2;
        }
        long j3 = strategyBean.f10247x;
        if (j3 > 0) {
            f10115d = j3;
        }
    }

    @TargetApi(14)
    /* renamed from: c */
    private static void m9502c(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f10122k == null) {
                f10122k = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.crashreport.biz.b.2
                    AnonymousClass2() {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                            C3151an.m9921c(">>> %s onCreated <<<", name);
                            C3113a m9532b = C3113a.m9532b();
                            if (m9532b != null) {
                                m9532b.f10146M.add(C3111b.m9497b(name, "onCreated"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                            C3151an.m9921c(">>> %s onDestroyed <<<", name);
                            C3113a m9532b = C3113a.m9532b();
                            if (m9532b != null) {
                                m9532b.f10146M.add(C3111b.m9497b(name, "onDestroyed"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                            C3151an.m9921c(">>> %s onPaused <<<", name);
                            C3113a m9532b = C3113a.m9532b();
                            if (m9532b == null) {
                                return;
                            }
                            m9532b.f10146M.add(C3111b.m9497b(name, "onPaused"));
                            m9532b.m9558a(false);
                            m9532b.f10217y = System.currentTimeMillis();
                            long j2 = m9532b.f10217y;
                            m9532b.f10218z = j2 - m9532b.f10216x;
                            long unused = C3111b.f10119h = j2;
                            if (m9532b.f10218z < 0) {
                                m9532b.f10218z = 0L;
                            }
                            if (activity != null) {
                                m9532b.f10215w = "background";
                            } else {
                                m9532b.f10215w = "unknown";
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (C3111b.f10123l == null || C3111b.f10123l.getName().equals(name)) {
                            C3151an.m9921c(">>> %s onResumed <<<", name);
                            C3113a m9532b = C3113a.m9532b();
                            if (m9532b == null) {
                                return;
                            }
                            m9532b.f10146M.add(C3111b.m9497b(name, "onResumed"));
                            m9532b.m9558a(true);
                            m9532b.f10215w = name;
                            m9532b.f10216x = System.currentTimeMillis();
                            m9532b.f10134A = m9532b.f10216x - C3111b.f10120i;
                            long j2 = m9532b.f10216x - C3111b.f10119h;
                            if (j2 > (C3111b.f10117f > 0 ? C3111b.f10117f : C3111b.f10116e)) {
                                m9532b.m9567d();
                                C3111b.m9508g();
                                C3151an.m9915a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(C3111b.f10116e / 1000));
                                if (C3111b.f10118g % C3111b.f10114c == 0) {
                                    C3111b.f10113b.m9483a(4, C3111b.f10124m, 0L);
                                    return;
                                }
                                C3111b.f10113b.m9483a(4, false, 0L);
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - C3111b.f10121j > C3111b.f10115d) {
                                    long unused = C3111b.f10121j = currentTimeMillis;
                                    C3151an.m9915a("add a timer to upload hot start user info", new Object[0]);
                                    if (C3111b.f10124m) {
                                        C3111b.f10113b.m9484a(C3111b.f10115d);
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
            application.registerActivityLifecycleCallbacks(f10122k);
        } catch (Exception e2) {
            if (C3151an.m9916a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static String m9497b(String str, String str2) {
        return C3154aq.m9952a() + "  " + str + "  " + str2 + "\n";
    }

    /* renamed from: a */
    public static void m9490a() {
        C3110a c3110a = f10113b;
        if (c3110a != null) {
            c3110a.m9483a(2, false, 0L);
        }
    }

    /* renamed from: a */
    public static void m9492a(Context context) {
        if (!f10112a || context == null) {
            return;
        }
        m9505d(context);
        f10112a = false;
    }
}
