package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C3310b;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C3404e;
import com.umeng.analytics.pro.C3408i;
import com.umeng.analytics.pro.C3414o;
import com.umeng.analytics.pro.C3424y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C3531d;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: SessionTracker.java */
/* renamed from: com.umeng.analytics.pro.u */
/* loaded from: classes2.dex */
public class C3420u implements C3424y.a {

    /* renamed from: a */
    public static final String f12251a = "session_start_time";

    /* renamed from: b */
    public static final String f12252b = "session_end_time";

    /* renamed from: c */
    public static final String f12253c = "session_id";

    /* renamed from: d */
    public static final String f12254d = "pre_session_id";

    /* renamed from: e */
    public static final String f12255e = "a_start_time";

    /* renamed from: f */
    public static final String f12256f = "a_end_time";

    /* renamed from: g */
    public static final String f12257g = "fg_count";

    /* renamed from: h */
    private static String f12258h = null;

    /* renamed from: i */
    private static Context f12259i = null;

    /* renamed from: j */
    private static boolean f12260j = false;

    /* renamed from: k */
    private static long f12261k = 0;

    /* renamed from: l */
    private static boolean f12262l = true;

    /* renamed from: m */
    private static long f12263m;

    /* compiled from: SessionTracker.java */
    /* renamed from: com.umeng.analytics.pro.u$a */
    private static class a {

        /* renamed from: a */
        private static final C3420u f12264a = new C3420u();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3420u m11389a() {
        return a.f12264a;
    }

    /* renamed from: b */
    public static void m11392b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12259i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f12257g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f12257g, j2 + 1);
                edit.commit();
            }
        }
    }

    /* renamed from: d */
    private void m11393d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f12257g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private String m11394e(Context context) {
        if (f12259i == null && context != null) {
            f12259i = context.getApplicationContext();
        }
        String m11434d = C3424y.m11419a().m11434d(f12259i);
        try {
            m11395f(context);
            C3414o.m11300a(f12259i).m11346d((Object) null);
        } catch (Throwable unused) {
        }
        return m11434d;
    }

    /* renamed from: f */
    private void m11395f(Context context) {
        C3414o.m11300a(context).m11341b(context);
        C3414o.m11300a(context).m11345d();
    }

    /* renamed from: c */
    public void m11407c(Context context, Object obj) {
        try {
            if (f12259i == null && context != null) {
                f12259i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f12255e, 0L) == 0) {
                MLog.m11744e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f12256f, longValue);
            edit.putLong(f12252b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private C3420u() {
        C3424y.m11419a().m11429a(this);
    }

    /* renamed from: a */
    public static long m11388a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f12257g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: a */
    public void m11397a(Context context, long j2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12259i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f12251a, j2);
        edit.commit();
    }

    /* renamed from: b */
    public void m11403b(Context context, Object obj) {
        long longValue;
        try {
            if (f12259i == null) {
                f12259i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12259i);
            if (sharedPreferences == null) {
                return;
            }
            f12261k = sharedPreferences.getLong(f12256f, 0L);
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f12261k);
            String string = sharedPreferences.getString(C3397d.f11935az, "");
            String appVersionName = UMUtils.getAppVersionName(f12259i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f12251a, longValue);
                edit.commit();
                C3414o.m11300a(f12259i).m11336a((Object) null, true);
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + C3424y.m11419a().m11433c(f12259i));
                f12260j = true;
                m11396a(f12259i, longValue, true);
                return;
            }
            if (C3424y.m11419a().m11435e(f12259i)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f12260j = true;
                edit.putLong(f12251a, longValue);
                edit.commit();
                m11396a(f12259i, longValue, false);
                return;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f12260j = false;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m11398a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f12259i == null && context != null) {
                f12259i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12259i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(C3397d.f11935az, "");
            String appVersionName = UMUtils.getAppVersionName(f12259i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(C3397d.f11935az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(C3397d.f11935az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(C3397d.f11935az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (f12262l) {
                    f12262l = false;
                }
                if (f12260j) {
                    f12260j = false;
                    m11404b(f12259i, longValue, true);
                    m11402b(f12259i, longValue);
                    return;
                }
                return;
            }
            if (f12260j) {
                f12260j = false;
                if (f12262l) {
                    f12262l = false;
                }
                f12258h = m11394e(context);
                MLog.m11738d("创建新会话: " + f12258h);
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f12258h);
                return;
            }
            f12258h = sharedPreferences.getString("session_id", null);
            edit.putLong(f12255e, longValue);
            edit.putLong(f12256f, 0L);
            edit.commit();
            MLog.m11738d("延续上一个会话: " + f12258h);
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Extend current session: " + f12258h);
            if (f12262l) {
                f12262l = false;
                if (FieldManager.allow(C3531d.f12957E)) {
                    UMWorkDispatch.sendEventEx(f12259i, C3414o.a.f12194D, CoreProtocol.getInstance(f12259i), null, 0L);
                }
            }
            m11395f(context);
            C3414o.m11300a(f12259i).m11337a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    /* renamed from: c */
    public String m11406c(Context context) {
        try {
            if (f12258h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f12258h;
    }

    @Deprecated
    /* renamed from: c */
    public String m11405c() {
        return m11406c(f12259i);
    }

    /* renamed from: b */
    public boolean m11404b(Context context, long j2, boolean z) {
        SharedPreferences sharedPreferences;
        String m11426a;
        long j3;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (m11426a = C3424y.m11419a().m11426a(f12259i)) == null) {
            return false;
        }
        long j4 = sharedPreferences.getLong(f12255e, 0L);
        long j5 = sharedPreferences.getLong(f12256f, 0L);
        if (j4 > 0 && j5 == 0) {
            z2 = true;
            if (z) {
                if (f12261k == 0) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                    j3 = j2;
                } else {
                    j3 = f12261k;
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f12261k);
                }
                m11407c(f12259i, Long.valueOf(j3));
            } else {
                m11407c(f12259i, Long.valueOf(j2));
                j3 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(C3404e.d.a.f12022g, j3);
            } else {
                jSONObject.put(C3404e.d.a.f12022g, j2);
            }
            JSONObject m10763b = C3310b.m10736a().m10763b();
            if (m10763b != null && m10763b.length() > 0) {
                jSONObject.put("__sp", m10763b);
            }
            JSONObject m10768c = C3310b.m10736a().m10768c();
            if (m10768c != null && m10768c.length() > 0) {
                jSONObject.put("__pp", m10768c);
            }
            if (FieldManager.allow(C3531d.f12957E)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f12263m);
                jSONObject.put(C3404e.d.a.f12023h, f12263m);
                f12263m = 0L;
            } else {
                jSONObject.put(C3404e.d.a.f12023h, 0L);
            }
            C3408i.m11232a(context).m11251a(m11426a, jSONObject, C3408i.a.END);
            C3414o.m11300a(f12259i).m11347e();
        }
        return z2;
    }

    /* renamed from: a */
    public String m11396a(Context context, long j2, boolean z) {
        String m11431b = C3424y.m11419a().m11431b(context);
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + m11431b);
        if (TextUtils.isEmpty(m11431b)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject m10763b = C3310b.m10736a().m10763b();
            if (m10763b != null && m10763b.length() > 0) {
                jSONObject.put("__sp", m10763b);
            }
            JSONObject m10768c = C3310b.m10736a().m10768c();
            if (m10768c != null && m10768c.length() > 0) {
                jSONObject.put("__pp", m10768c);
            }
            C3408i.m11232a(context).m11251a(m11431b, jSONObject, C3408i.a.INSTANTSESSIONBEGIN);
            C3414o.m11300a(context).m11336a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return m11431b;
    }

    /* renamed from: b */
    public void m11402b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            C3414o.m11300a(f12259i).m11344c((Object) null);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    /* renamed from: b */
    public String m11401b() {
        return f12258h;
    }

    @Override // com.umeng.analytics.pro.C3424y.a
    /* renamed from: a */
    public void mo11400a(String str, String str2, long j2, long j3, long j4) {
        m11390a(f12259i, str2, j2, j3, j4);
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f12259i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.C3424y.a
    /* renamed from: a */
    public void mo11399a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m11391a(str, j2);
    }

    /* renamed from: a */
    private void m11390a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(f12258h)) {
            f12258h = C3424y.m11419a().m11426a(f12259i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f12258h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3404e.d.a.f12022g, j3);
            jSONObject.put(C3404e.d.a.f12023h, j4);
            JSONObject m10763b = C3310b.m10736a().m10763b();
            if (m10763b != null && m10763b.length() > 0) {
                jSONObject.put("__sp", m10763b);
            }
            JSONObject m10768c = C3310b.m10736a().m10768c();
            if (m10768c != null && m10768c.length() > 0) {
                jSONObject.put("__pp", m10768c);
            }
            C3408i.m11232a(context).m11251a(f12258h, jSONObject, C3408i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            C3408i.m11232a(context).m11251a(str, jSONObject2, C3408i.a.BEGIN);
            if (FieldManager.allow(C3531d.f12957E)) {
                f12263m = j4;
                m11393d(context);
                UMWorkDispatch.sendEventEx(f12259i, C3414o.a.f12194D, CoreProtocol.getInstance(f12259i), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f12258h = str;
    }

    /* renamed from: a */
    private void m11391a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12259i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f12252b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(C3404e.d.a.f12022g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(C3404e.d.a.f12020e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = f12259i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(C3397d.f11882H, longValue);
                jSONObject3.put(C3397d.f11881G, longValue2);
                jSONObject.put(C3404e.d.a.f12019d, jSONObject3);
            }
            C3408i.m11232a(f12259i).m11251a(str, jSONObject, C3408i.a.NEWSESSION);
            C3421v.m11409a(f12259i);
            C3411l.m11279c(f12259i);
        } catch (Throwable unused) {
        }
    }
}
