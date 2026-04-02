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

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a = false;

    /* JADX INFO: renamed from: b */
    public static a f6156b = null;

    /* JADX INFO: renamed from: c */
    private static int f6157c = 10;

    /* JADX INFO: renamed from: d */
    private static long f6158d = 300000;

    /* JADX INFO: renamed from: e */
    private static long f6159e = 30000;

    /* JADX INFO: renamed from: f */
    private static long f6160f = 0;

    /* JADX INFO: renamed from: g */
    private static int f6161g = 0;

    /* JADX INFO: renamed from: h */
    private static long f6162h = 0;

    /* JADX INFO: renamed from: i */
    private static long f6163i = 0;

    /* JADX INFO: renamed from: j */
    private static long f6164j = 0;

    /* JADX INFO: renamed from: k */
    private static Application.ActivityLifecycleCallbacks f6165k = null;

    /* JADX INFO: renamed from: l */
    private static Class<?> f6166l = null;

    /* JADX INFO: renamed from: m */
    private static boolean f6167m = true;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.b$1 */
    /* JADX INFO: compiled from: BUGLY */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ BuglyStrategy f6168b;

        AnonymousClass1(Context context, BuglyStrategy buglyStrategy) {
            context = context;
            buglyStrategy = buglyStrategy;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c(context, buglyStrategy);
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.b$2 */
    /* JADX INFO: compiled from: BUGLY */
    static class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass2() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                an.c(">>> %s onCreated <<<", name);
                com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                if (aVarB != null) {
                    aVarB.M.add(b.b(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                an.c(">>> %s onDestroyed <<<", name);
                com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                if (aVarB != null) {
                    aVarB.M.add(b.b(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                an.c(">>> %s onPaused <<<", name);
                com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                if (aVarB == null) {
                    return;
                }
                aVarB.M.add(b.b(name, "onPaused"));
                aVarB.a(false);
                aVarB.y = System.currentTimeMillis();
                long j2 = aVarB.y;
                aVarB.z = j2 - aVarB.x;
                long unused = b.f6162h = j2;
                if (aVarB.z < 0) {
                    aVarB.z = 0L;
                }
                if (activity != null) {
                    aVarB.w = "background";
                } else {
                    aVarB.w = "unknown";
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                an.c(">>> %s onResumed <<<", name);
                com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                if (aVarB == null) {
                    return;
                }
                aVarB.M.add(b.b(name, "onResumed"));
                aVarB.a(true);
                aVarB.w = name;
                aVarB.x = System.currentTimeMillis();
                aVarB.A = aVarB.x - b.f6163i;
                long j2 = aVarB.x - b.f6162h;
                if (j2 > (b.f6160f > 0 ? b.f6160f : b.f6159e)) {
                    aVarB.d();
                    b.g();
                    an.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f6159e / 1000));
                    if (b.f6161g % b.f6157c == 0) {
                        b.f6156b.a(4, b.f6167m, 0L);
                        return;
                    }
                    b.f6156b.a(4, false, 0L);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - b.f6164j > b.f6158d) {
                        long unused = b.f6164j = jCurrentTimeMillis;
                        an.a("add a timer to upload hot start user info", new Object[0]);
                        if (b.f6167m) {
                            b.f6156b.a(b.f6158d);
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

    static /* synthetic */ int g() {
        int i2 = f6161g;
        f6161g = i2 + 1;
        return i2;
    }

    private static void m() {
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return;
        }
        String className = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                className = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (className == null) {
            className = "unknown";
        } else if (z) {
            aVarB.a(true);
        } else {
            className = "background";
        }
        aVarB.w = className;
    }

    private static void n() {
        f6163i = System.currentTimeMillis();
        f6156b.a(1, false, 0L);
        an.a("[session] launch app, new start", new Object[0]);
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (a) {
            return;
        }
        f6167m = com.tencent.bugly.crashreport.common.info.a.a(context).f6179h;
        f6156b = new a(context, f6167m);
        a = true;
        if (buglyStrategy != null) {
            f6166l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            c(context, buglyStrategy);
        } else {
            am.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                final /* synthetic */ Context a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ BuglyStrategy f6168b;

                AnonymousClass1(Context context2, BuglyStrategy buglyStrategy2) {
                    context = context2;
                    buglyStrategy = buglyStrategy2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.c(context, buglyStrategy);
                }
            }, appReportDelay);
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
            if (f6165k != null) {
                application.unregisterActivityLifecycleCallbacks(f6165k);
            }
        } catch (Exception e2) {
            if (an.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (zRecordUserInfoOnceADay) {
            if (!b(context)) {
                return;
            } else {
                zIsEnableUserInfo = false;
            }
        }
        m();
        if (zIsEnableUserInfo) {
            c(context);
        }
        if (f6167m) {
            n();
            f6156b.a();
            f6156b.b(21600000L);
        }
    }

    private static boolean b(Context context) {
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        List<UserInfoBean> listA = f6156b.a(aVarA.f6176e);
        if (listA == null) {
            return true;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            UserInfoBean userInfoBean = listA.get(i2);
            if (userInfoBean.f6148n.equals(aVarA.p) && userInfoBean.f6136b == 1) {
                long jB = aq.b();
                if (jB <= 0) {
                    return true;
                }
                if (userInfoBean.f6139e >= jB) {
                    if (userInfoBean.f6140f <= 0) {
                        f6156b.b();
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
        f6160f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        a aVar = f6156b;
        if (aVar != null && !z) {
            aVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.q;
        if (j2 > 0) {
            f6159e = j2;
        }
        int i2 = strategyBean.w;
        if (i2 > 0) {
            f6157c = i2;
        }
        long j3 = strategyBean.x;
        if (j3 > 0) {
            f6158d = j3;
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
            if (f6165k == null) {
                f6165k = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.crashreport.biz.b.2
                    AnonymousClass2() {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                            an.c(">>> %s onCreated <<<", name);
                            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                            if (aVarB != null) {
                                aVarB.M.add(b.b(name, "onCreated"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                            an.c(">>> %s onDestroyed <<<", name);
                            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                            if (aVarB != null) {
                                aVarB.M.add(b.b(name, "onDestroyed"));
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                            an.c(">>> %s onPaused <<<", name);
                            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                            if (aVarB == null) {
                                return;
                            }
                            aVarB.M.add(b.b(name, "onPaused"));
                            aVarB.a(false);
                            aVarB.y = System.currentTimeMillis();
                            long j2 = aVarB.y;
                            aVarB.z = j2 - aVarB.x;
                            long unused = b.f6162h = j2;
                            if (aVarB.z < 0) {
                                aVarB.z = 0L;
                            }
                            if (activity != null) {
                                aVarB.w = "background";
                            } else {
                                aVarB.w = "unknown";
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        String name = activity != null ? activity.getClass().getName() : "unknown";
                        if (b.f6166l == null || b.f6166l.getName().equals(name)) {
                            an.c(">>> %s onResumed <<<", name);
                            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
                            if (aVarB == null) {
                                return;
                            }
                            aVarB.M.add(b.b(name, "onResumed"));
                            aVarB.a(true);
                            aVarB.w = name;
                            aVarB.x = System.currentTimeMillis();
                            aVarB.A = aVarB.x - b.f6163i;
                            long j2 = aVarB.x - b.f6162h;
                            if (j2 > (b.f6160f > 0 ? b.f6160f : b.f6159e)) {
                                aVarB.d();
                                b.g();
                                an.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f6159e / 1000));
                                if (b.f6161g % b.f6157c == 0) {
                                    b.f6156b.a(4, b.f6167m, 0L);
                                    return;
                                }
                                b.f6156b.a(4, false, 0L);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - b.f6164j > b.f6158d) {
                                    long unused = b.f6164j = jCurrentTimeMillis;
                                    an.a("add a timer to upload hot start user info", new Object[0]);
                                    if (b.f6167m) {
                                        b.f6156b.a(b.f6158d);
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
            application.registerActivityLifecycleCallbacks(f6165k);
        } catch (Exception e2) {
            if (an.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static String b(String str, String str2) {
        return aq.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        a aVar = f6156b;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!a || context == null) {
            return;
        }
        d(context);
        a = false;
    }
}
