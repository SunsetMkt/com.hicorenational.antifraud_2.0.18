package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.C3475a;
import com.umeng.commonsdk.internal.utils.C3478d;
import com.umeng.commonsdk.internal.utils.C3484j;
import com.umeng.commonsdk.internal.utils.C3485k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.C3531d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMInternalManager.java */
/* renamed from: com.umeng.commonsdk.internal.d */
/* loaded from: classes2.dex */
public class C3474d {
    /* renamed from: a */
    public static void m11611a(Context context) {
        try {
            ULog.m11783i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3351bh.f11592aQ, C3470a.f12591e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, m11618d(context), UMServerURL.PATH_ANALYTICS, C3351bh.f11581aF, C3470a.f12591e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.m11783i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
    }

    /* renamed from: b */
    public static void m11615b(Context context) {
        ULog.m11783i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            m11624j(context);
        }
    }

    /* renamed from: c */
    public static void m11617c(Context context) {
        ULog.m11783i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        m11624j(context);
    }

    /* renamed from: d */
    public static JSONObject m11618d(Context context) {
        JSONObject m11614b;
        JSONArray m11622h;
        JSONObject m11610a;
        JSONArray m11626l;
        JSONArray m11625k;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(C3531d.f12962J) && (m11625k = m11625k(applicationContext)) != null && m11625k.length() > 0) {
                    jSONObject2.put("rs", m11625k);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                if (FieldManager.allow(C3531d.f12994ao) && (m11626l = m11626l(applicationContext)) != null && m11626l.length() > 0) {
                    jSONObject2.put("by", m11626l);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                m11612a(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                m11616b(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                if (FieldManager.allow(C3531d.f12995ap) && (m11610a = m11610a()) != null && m11610a.length() > 0) {
                    jSONObject2.put("build", m11610a);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject m11619e = m11619e(applicationContext);
                if (m11619e != null && m11619e.length() > 0) {
                    jSONObject2.put("scr", m11619e);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject m11620f = m11620f(applicationContext);
                if (m11620f != null && m11620f.length() > 0) {
                    jSONObject2.put("sinfo", m11620f);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONArray m11621g = m11621g(applicationContext);
                if (m11621g != null && m11621g.length() > 0) {
                    jSONObject2.put("input", m11621g);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                if (FieldManager.allow(C3531d.f12986ag) && (m11622h = m11622h(applicationContext)) != null && m11622h.length() > 0) {
                    jSONObject2.put("appls", m11622h);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                JSONObject m11623i = m11623i(applicationContext);
                if (m11623i != null && m11623i.length() > 0) {
                    jSONObject2.put("mem", m11623i);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                if (FieldManager.allow(C3531d.f12996aq) && (m11614b = m11614b()) != null && m11614b.length() > 0) {
                    jSONObject2.put(C3351bh.f11669w, m11614b);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(C3351bh.f11625ax, jSONObject2);
            } catch (JSONException e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static JSONObject m11619e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", C3475a.m11633c(context));
                jSONObject.put("a_nav_h", C3475a.m11636d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
        }
        return jSONObject;
    }

    /* renamed from: f */
    public static JSONObject m11620f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", C3475a.m11628a(applicationContext, packageName));
                jSONObject.put("a_alut", C3475a.m11630b(applicationContext, packageName));
                jSONObject.put("a_c", C3475a.m11635c(applicationContext, packageName));
                jSONObject.put("a_uid", C3475a.m11637d(applicationContext, packageName));
                if (C3475a.m11629a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", C3475a.m11631b());
                jSONObject.put("s_fs", C3475a.m11627a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", C3475a.m11634c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", C3475a.m11638d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    /* renamed from: g */
    public static JSONArray m11621g(Context context) {
        Context applicationContext;
        List<InputMethodInfo> m11641f;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m11641f = C3475a.m11641f((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : m11641f) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: h */
    public static JSONArray m11622h(Context context) {
        Context applicationContext;
        List<C3475a.a> m11642g;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (m11642g = C3475a.m11642g((applicationContext = context.getApplicationContext()))) != null && !m11642g.isEmpty()) {
            for (C3475a.a aVar : m11642g) {
                if (aVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", aVar.f12637a);
                        jSONObject.put("a_la", aVar.f12638b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(applicationContext, e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: i */
    public static JSONObject m11623i(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo m11643h;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (m11643h = C3475a.m11643h((applicationContext = context.getApplicationContext()))) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("t", m11643h.totalMem);
                }
                jSONObject.put("f", m11643h.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    /* renamed from: j */
    private static void m11624j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, C3470a.f12592f, C3471b.m11589a(context).m11590a(), null, C2084a.f6136r);
            }
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, C3470a.f12608v, C3471b.m11589a(context).m11590a(), null, C2084a.f6136r);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: k */
    private static JSONArray m11625k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (runningServices.get(i2) != null && runningServices.get(i2).service != null && runningServices.get(i2).service.getClassName() != null && runningServices.get(i2).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i2).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i2).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: l */
    private static JSONArray m11626l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String m11664a = C3484j.m11664a(context);
        if (!TextUtils.isEmpty(m11664a)) {
            try {
                jSONArray.put(new JSONObject(m11664a));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    private static JSONObject m11614b() {
        try {
            C3478d.a m11652a = C3478d.m11652a();
            if (m11652a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", m11652a.f12651a);
                jSONObject.put("pla", m11652a.f12652b);
                jSONObject.put("cpus", m11652a.f12653c);
                jSONObject.put("fea", m11652a.f12654d);
                jSONObject.put(C3336at.f11489c, m11652a.f12655e);
                jSONObject.put("arc", m11652a.f12656f);
                jSONObject.put("var", m11652a.f12657g);
                jSONObject.put("par", m11652a.f12658h);
                jSONObject.put("rev", m11652a.f12659i);
                jSONObject.put("har", m11652a.f12660j);
                jSONObject.put("rev", m11652a.f12661k);
                jSONObject.put("ser", m11652a.f12662l);
                jSONObject.put("cur_cpu", C3478d.m11655d());
                jSONObject.put("max_cpu", C3478d.m11653b());
                jSONObject.put("min_cpu", C3478d.m11654c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m11612a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m11613a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        m11613a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        m11613a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        m11613a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        m11613a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    /* renamed from: a */
    private static void m11613a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static JSONObject m11610a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < Build.SUPPORTED_32_BIT_ABIS.length; i2++) {
                    jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i2]);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < Build.SUPPORTED_64_BIT_ABIS.length; i3++) {
                    jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i3]);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < Build.SUPPORTED_ABIS.length; i4++) {
                    jSONArray3.put(Build.SUPPORTED_ABIS[i4]);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m11616b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String m11668a = C3485k.m11668a(context);
            if (TextUtils.isEmpty(m11668a)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(m11668a);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(C3485k.f12674d)) {
                    jSONObject.put(C3485k.f12674d, jSONObject2.opt(C3485k.f12674d));
                }
                if (jSONObject2.has(C3485k.f12673c)) {
                    jSONObject.put(C3485k.f12673c, jSONObject2.opt(C3485k.f12673c));
                }
                if (jSONObject2.has(C3485k.f12672b)) {
                    jSONObject.put(C3485k.f12672b, jSONObject2.opt(C3485k.f12672b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
