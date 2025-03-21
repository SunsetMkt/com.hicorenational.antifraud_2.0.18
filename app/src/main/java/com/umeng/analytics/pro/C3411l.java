package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.C3310b;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.C3404e;
import com.umeng.analytics.pro.C3408i;
import com.umeng.analytics.vshelper.C3437b;
import com.umeng.analytics.vshelper.InterfaceC3436a;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.C3531d;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoViewPageTracker.java */
@TargetApi(14)
/* renamed from: com.umeng.analytics.pro.l */
/* loaded from: classes2.dex */
public class C3411l {

    /* renamed from: a */
    public static String f12138a;

    /* renamed from: b */
    boolean f12147b;

    /* renamed from: c */
    boolean f12148c;

    /* renamed from: f */
    InterfaceC3436a f12149f;

    /* renamed from: g */
    Application.ActivityLifecycleCallbacks f12150g;

    /* renamed from: h */
    private final Map<String, Long> f12151h;

    /* renamed from: l */
    private boolean f12152l;

    /* renamed from: m */
    private int f12153m;

    /* renamed from: n */
    private int f12154n;

    /* renamed from: i */
    private static JSONArray f12141i = new JSONArray();

    /* renamed from: j */
    private static Object f12142j = new Object();

    /* renamed from: k */
    private static Application f12143k = null;

    /* renamed from: d */
    static String f12139d = null;

    /* renamed from: e */
    static int f12140e = -1;

    /* renamed from: o */
    private static boolean f12144o = true;

    /* renamed from: p */
    private static Object f12145p = new Object();

    /* renamed from: q */
    private static InterfaceC3356bm f12146q = new C3437b();

    /* compiled from: AutoViewPageTracker.java */
    /* renamed from: com.umeng.analytics.pro.l$a */
    private static class a {

        /* renamed from: a */
        private static final C3411l f12156a = new C3411l();

        private a() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m11268a(C3411l c3411l) {
        int i2 = c3411l.f12154n;
        c3411l.f12154n = i2 - 1;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m11274b(C3411l c3411l) {
        int i2 = c3411l.f12153m;
        c3411l.f12153m = i2 - 1;
        return i2;
    }

    /* renamed from: e */
    static /* synthetic */ int m11282e(C3411l c3411l) {
        int i2 = c3411l.f12154n;
        c3411l.f12154n = i2 + 1;
        return i2;
    }

    /* renamed from: f */
    static /* synthetic */ int m11284f(C3411l c3411l) {
        int i2 = c3411l.f12153m;
        c3411l.f12153m = i2 + 1;
        return i2;
    }

    /* renamed from: g */
    private void m11286g() {
        if (this.f12152l) {
            return;
        }
        this.f12152l = true;
        if (f12143k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        f12143k.registerActivityLifecycleCallbacks(this.f12150g);
    }

    private C3411l() {
        this.f12151h = new HashMap();
        this.f12152l = false;
        this.f12147b = false;
        this.f12148c = false;
        this.f12153m = 0;
        this.f12154n = 0;
        this.f12149f = PageNameMonitor.getInstance();
        this.f12150g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                C3411l.f12146q.mo11001a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(C3531d.f12958F)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (C3411l.f12145p) {
                        if (C3411l.f12144o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        C3310b.m10736a().m10784i();
                    }
                } else {
                    C3411l.this.m11278c(activity);
                    C3310b.m10736a().m10784i();
                    C3411l.this.f12147b = false;
                    C3411l.f12146q.mo11007d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(C3531d.f12958F)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (C3411l.f12145p) {
                        if (C3411l.f12144o) {
                            boolean unused = C3411l.f12144o = false;
                        }
                    }
                    C3411l.this.m11270a(activity);
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    C3411l.this.m11270a(activity);
                }
                C3411l.f12146q.mo11006c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (C3411l.this.f12153m <= 0) {
                        if (C3411l.f12139d == null) {
                            C3411l.f12139d = UUID.randomUUID().toString();
                        }
                        if (C3411l.f12140e == -1) {
                            C3411l.f12140e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (C3411l.f12140e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            C3310b m10736a = C3310b.m10736a();
                            if (m10736a != null) {
                                m10736a.m10751a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            C3411l.f12140e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, C3409j.f12112ar);
                            }
                        } else if (C3411l.f12140e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", C3411l.f12139d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (C3310b.m10736a() != null) {
                                C3310b.m10736a().m10751a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (C3411l.this.f12154n < 0) {
                        C3411l.m11282e(C3411l.this);
                    } else {
                        C3411l.m11284f(C3411l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        C3411l.m11268a(C3411l.this);
                        return;
                    }
                    C3411l.m11274b(C3411l.this);
                    if (C3411l.this.f12153m <= 0) {
                        if (C3411l.f12140e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = C3411l.f12140e;
                        if ((i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", C3411l.f12139d);
                            hashMap.put("reason", "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            C3310b m10736a = C3310b.m10736a();
                            if (m10736a != null) {
                                m10736a.m10751a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (C3411l.f12139d != null) {
                                C3411l.f12139d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f12143k != null) {
                m11286g();
            }
        }
    }

    /* renamed from: c */
    public void m11290c() {
        m11278c((Activity) null);
        m11288b();
    }

    /* renamed from: b */
    public void m11289b(Context context) {
        synchronized (f12145p) {
            if (f12144o) {
                f12144o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                m11270a(globleActivity);
                return;
            }
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    /* renamed from: c */
    public static void m11279c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f12142j) {
                    jSONArray = f12141i.toString();
                    f12141i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(C3404e.d.a.f12018c, new JSONArray(jSONArray));
                    C3408i.m11232a(context).m11251a(C3420u.m11389a().m11405c(), jSONObject, C3408i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public boolean m11287a() {
        return this.f12152l;
    }

    /* renamed from: a */
    public static synchronized C3411l m11269a(Context context) {
        C3411l c3411l;
        synchronized (C3411l.class) {
            if (f12143k == null && context != null) {
                if (context instanceof Activity) {
                    f12143k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f12143k = (Application) context;
                }
            }
            c3411l = a.f12156a;
        }
        return c3411l;
    }

    /* renamed from: a */
    public static void m11271a(Context context, String str) {
        if (f12140e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f12139d);
            hashMap.put("reason", str);
            if (f12139d != null) {
                f12139d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                C3310b.m10736a().m10751a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    /* renamed from: b */
    public void m11288b() {
        this.f12152l = false;
        if (f12143k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                f12143k.unregisterActivityLifecycleCallbacks(this.f12150g);
            }
            f12143k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11278c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f12151h) {
                if (f12138a == null && activity != null) {
                    f12138a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(f12138a) || !this.f12151h.containsKey(f12138a)) {
                    j3 = 0;
                } else {
                    long longValue = this.f12151h.get(f12138a).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    this.f12151h.remove(f12138a);
                    j2 = currentTimeMillis;
                    j3 = longValue;
                }
            }
            synchronized (f12142j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C3397d.f11956v, f12138a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(C3397d.f11958x, j3);
                    jSONObject.put("type", 0);
                    f12141i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    private void m11275b(Activity activity) {
        f12138a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f12151h) {
            this.f12151h.put(f12138a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11270a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f12145p) {
                    C3310b.m10736a().m10783h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f12149f.activityResume(str);
            if (this.f12147b) {
                this.f12147b = false;
                if (!TextUtils.isEmpty(f12138a)) {
                    if (f12138a.equals(str)) {
                        return;
                    }
                    m11275b(activity);
                    synchronized (f12145p) {
                        C3310b.m10736a().m10783h();
                    }
                    return;
                }
                f12138a = str;
                return;
            }
            m11275b(activity);
            synchronized (f12145p) {
                C3310b.m10736a().m10783h();
            }
        }
    }
}
