package com.tencent.bugly.beta.p205ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.upgrade.C3100c;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.g */
/* loaded from: classes2.dex */
public class C3096g {

    /* renamed from: a */
    public static final Map<Integer, AbstractC3091b> f9968a = new ConcurrentHashMap();

    /* renamed from: b */
    public static final Map<Integer, RunnableC3081d> f9969b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final Map<Integer, RunnableC3081d> f9970c = new ConcurrentHashMap();

    /* renamed from: d */
    private static RunnableC3081d f9971d;

    /* renamed from: a */
    public static synchronized void m9360a(AbstractC3091b abstractC3091b, boolean z) {
        synchronized (C3096g.class) {
            if (Build.VERSION.SDK_INT >= 14) {
                m9361a(abstractC3091b, z, false, C2084a.f6136r);
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) C3082e.f9867G.f9919u.getSystemService("activity");
                    if (activityManager != null) {
                        activityManager.getRunningTasks(1);
                        m9361a(abstractC3091b, z, false, C2084a.f6136r);
                    }
                } catch (SecurityException unused) {
                    if (z) {
                        m9361a(abstractC3091b, z, true, 0L);
                        return;
                    }
                    C3151an.m9923e("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
                    if (C3100c.f10000a.f10001b != null && C3100c.f10000a.f10001b.f9988a != null) {
                        C3092c.f9950a.m9358a(C3100c.f10000a.f10001b.f9988a, abstractC3091b);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized boolean m9362b() {
        synchronized (C3096g.class) {
            String m9359a = m9359a();
            if (m9359a == null || m9359a.equals("background") || m9359a.equals("unknown")) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName(m9359a);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (!C3082e.f9867G.f9913o.isEmpty()) {
                for (Class<? extends Activity> cls2 : C3082e.f9867G.f9913o) {
                    if (TextUtils.equals(cls2.getName(), m9359a) || (cls != null && cls2.isAssignableFrom(cls))) {
                        return true;
                    }
                }
                return false;
            }
            if (C3082e.f9867G.f9914p.isEmpty()) {
                return true;
            }
            for (Class<? extends Activity> cls3 : C3082e.f9867G.f9914p) {
                if (TextUtils.equals(cls3.getName(), m9359a) || (cls != null && cls3.isAssignableFrom(cls))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public static synchronized void m9361a(AbstractC3091b abstractC3091b, boolean z, boolean z2, long j2) {
        synchronized (C3096g.class) {
            if (abstractC3091b != null) {
                if (!abstractC3091b.m9354b()) {
                    int hashCode = abstractC3091b.hashCode();
                    if (abstractC3091b instanceof C3097h) {
                        C3105e.m9463b(f9971d);
                        if (((C3097h) abstractC3091b).f9978p.f10838g == 2) {
                            f9971d = new RunnableC3081d(15, abstractC3091b, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            C3105e.m9462a(f9971d, 3000L);
                        }
                        if (!z && !m9362b()) {
                            RunnableC3081d runnableC3081d = f9969b.get(Integer.valueOf(hashCode));
                            if (runnableC3081d == null) {
                                runnableC3081d = new RunnableC3081d(11, abstractC3091b, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                                f9969b.put(Integer.valueOf(hashCode), runnableC3081d);
                            }
                            C3105e.m9463b(runnableC3081d);
                            C3105e.m9462a(runnableC3081d, j2);
                            return;
                        }
                        C3105e.m9463b(f9969b.remove(Integer.valueOf(hashCode)));
                    }
                    if (!z2 && !C3154aq.m9987b(C3082e.f9867G.f9919u)) {
                        RunnableC3081d runnableC3081d2 = f9970c.get(Integer.valueOf(hashCode));
                        if (runnableC3081d2 == null) {
                            runnableC3081d2 = new RunnableC3081d(11, abstractC3091b, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            f9970c.put(Integer.valueOf(hashCode), runnableC3081d2);
                        }
                        C3105e.m9463b(runnableC3081d2);
                        C3105e.m9462a(runnableC3081d2, j2);
                        return;
                    }
                    C3105e.m9463b(f9970c.remove(Integer.valueOf(hashCode)));
                    RunnableC3081d runnableC3081d3 = new RunnableC3081d(17, f9968a, Integer.valueOf(hashCode), abstractC3091b);
                    FragmentActivity activity = abstractC3091b.getActivity();
                    if (activity != null) {
                        if (activity instanceof BetaActivity) {
                            ((BetaActivity) activity).onDestroyRunnable = runnableC3081d3;
                        } else {
                            C3105e.m9462a(runnableC3081d3, 400L);
                        }
                        activity.finish();
                    } else {
                        runnableC3081d3.run();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static String m9359a() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                return C3113a.m9532b().f10215w;
            }
            ActivityManager activityManager = (ActivityManager) C3082e.f9867G.f9919u.getSystemService("activity");
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
                return null;
            }
            return runningTasks.get(0).topActivity.getClassName();
        } catch (SecurityException unused) {
            C3151an.m9923e("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e2) {
            if (C3151an.m9919b(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
