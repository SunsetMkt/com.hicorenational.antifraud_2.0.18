package com.tencent.bugly.beta.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final Map<Integer, b> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, com.tencent.bugly.beta.global.d> f6066b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, com.tencent.bugly.beta.global.d> f6067c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.tencent.bugly.beta.global.d f6068d;

    public static synchronized void a(b bVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            a(bVar, z, false, com.heytap.mcssdk.constant.a.r);
        } else {
            try {
                ActivityManager activityManager = (ActivityManager) com.tencent.bugly.beta.global.e.G.u.getSystemService("activity");
                if (activityManager != null) {
                    activityManager.getRunningTasks(1);
                    a(bVar, z, false, com.heytap.mcssdk.constant.a.r);
                }
            } catch (SecurityException unused) {
                if (z) {
                    a(bVar, z, true, 0L);
                    return;
                }
                an.e("\u65e0\u6cd5\u83b7\u53d6GET_TASK\u6743\u9650\uff0c\u5c06\u5728\u901a\u77e5\u680f\u63d0\u9192\u5347\u7ea7\uff0c\u5982\u9700\u5f39\u7a97\u63d0\u9192\uff0c\u8bf7\u5728AndroidManifest.xml\u4e2d\u6dfb\u52a0GET_TASKS\u6743\u9650\uff1a\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
                if (com.tencent.bugly.beta.upgrade.c.a.f6078b != null && com.tencent.bugly.beta.upgrade.c.a.f6078b.a != null) {
                    c.a.a(com.tencent.bugly.beta.upgrade.c.a.f6078b.a, bVar);
                }
            }
        }
    }

    public static synchronized boolean b() {
        String strA = a();
        if (strA == null || strA.equals("background") || strA.equals("unknown")) {
            return false;
        }
        Class<?> cls = null;
        try {
            cls = Class.forName(strA);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        if (!com.tencent.bugly.beta.global.e.G.o.isEmpty()) {
            for (Class<? extends Activity> cls2 : com.tencent.bugly.beta.global.e.G.o) {
                if (TextUtils.equals(cls2.getName(), strA) || (cls != null && cls2.isAssignableFrom(cls))) {
                    return true;
                }
            }
            return false;
        }
        if (com.tencent.bugly.beta.global.e.G.p.isEmpty()) {
            return true;
        }
        for (Class<? extends Activity> cls3 : com.tencent.bugly.beta.global.e.G.p) {
            if (TextUtils.equals(cls3.getName(), strA) || (cls != null && cls3.isAssignableFrom(cls))) {
                return false;
            }
        }
        return true;
    }

    public static synchronized void a(b bVar, boolean z, boolean z2, long j2) {
        if (bVar != null) {
            if (!bVar.b()) {
                int iHashCode = bVar.hashCode();
                if (bVar instanceof h) {
                    com.tencent.bugly.beta.utils.e.b(f6068d);
                    if (((h) bVar).p.f6600g == 2) {
                        f6068d = new com.tencent.bugly.beta.global.d(15, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                        com.tencent.bugly.beta.utils.e.a(f6068d, 3000L);
                    }
                    if (!z && !b()) {
                        com.tencent.bugly.beta.global.d dVar = f6066b.get(Integer.valueOf(iHashCode));
                        if (dVar == null) {
                            dVar = new com.tencent.bugly.beta.global.d(11, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            f6066b.put(Integer.valueOf(iHashCode), dVar);
                        }
                        com.tencent.bugly.beta.utils.e.b(dVar);
                        com.tencent.bugly.beta.utils.e.a(dVar, j2);
                        return;
                    }
                    com.tencent.bugly.beta.utils.e.b(f6066b.remove(Integer.valueOf(iHashCode)));
                }
                if (!z2 && !aq.b(com.tencent.bugly.beta.global.e.G.u)) {
                    com.tencent.bugly.beta.global.d dVar2 = f6067c.get(Integer.valueOf(iHashCode));
                    if (dVar2 == null) {
                        dVar2 = new com.tencent.bugly.beta.global.d(11, bVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                        f6067c.put(Integer.valueOf(iHashCode), dVar2);
                    }
                    com.tencent.bugly.beta.utils.e.b(dVar2);
                    com.tencent.bugly.beta.utils.e.a(dVar2, j2);
                    return;
                }
                com.tencent.bugly.beta.utils.e.b(f6067c.remove(Integer.valueOf(iHashCode)));
                com.tencent.bugly.beta.global.d dVar3 = new com.tencent.bugly.beta.global.d(17, a, Integer.valueOf(iHashCode), bVar);
                FragmentActivity activity = bVar.getActivity();
                if (activity != null) {
                    if (activity instanceof BetaActivity) {
                        ((BetaActivity) activity).onDestroyRunnable = dVar3;
                    } else {
                        com.tencent.bugly.beta.utils.e.a(dVar3, 400L);
                    }
                    activity.finish();
                } else {
                    dVar3.run();
                }
            }
        }
    }

    public static String a() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                return com.tencent.bugly.crashreport.common.info.a.b().w;
            }
            ActivityManager activityManager = (ActivityManager) com.tencent.bugly.beta.global.e.G.u.getSystemService("activity");
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
                return null;
            }
            return runningTasks.get(0).topActivity.getClassName();
        } catch (SecurityException unused) {
            an.e("\u65e0\u6cd5\u83b7\u53d6Activity\u4fe1\u606f\uff0c\u8bf7\u5728AndroidManifest.xml\u4e2d\u6dfb\u52a0GET_TASKS\u6743\u9650\uff1a\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e2) {
            if (an.b(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
