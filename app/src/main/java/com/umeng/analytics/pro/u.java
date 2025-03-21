package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: SessionTracker.java */
/* loaded from: classes2.dex */
public class u implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10514a = "session_start_time";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10515b = "session_end_time";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10516c = "session_id";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10517d = "pre_session_id";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10518e = "a_start_time";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10519f = "a_end_time";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10520g = "fg_count";

    /* renamed from: h, reason: collision with root package name */
    private static String f10521h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Context f10522i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f10523j = false;

    /* renamed from: k, reason: collision with root package name */
    private static long f10524k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f10525l = true;

    /* renamed from: m, reason: collision with root package name */
    private static long f10526m;

    /* compiled from: SessionTracker.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final u f10527a = new u();

        private a() {
        }
    }

    public static u a() {
        return a.f10527a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f10520g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f10520g, j2 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f10520g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f10522i == null && context != null) {
            f10522i = context.getApplicationContext();
        }
        String d2 = y.a().d(f10522i);
        try {
            f(context);
            o.a(f10522i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d2;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f10522i == null && context != null) {
                f10522i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f10518e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f10519f, longValue);
            edit.putLong(f10515b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f10520g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f10514a, j2);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f10522i == null) {
                f10522i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
            if (sharedPreferences == null) {
                return;
            }
            f10524k = sharedPreferences.getLong(f10519f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f10524k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f10522i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f10514a, longValue);
                edit.commit();
                o.a(f10522i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + y.a().c(f10522i));
                f10523j = true;
                a(f10522i, longValue, true);
                return;
            }
            if (y.a().e(f10522i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f10523j = true;
                edit.putLong(f10514a, longValue);
                edit.commit();
                a(f10522i, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f10523j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f10522i == null && context != null) {
                f10522i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f10522i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (f10525l) {
                    f10525l = false;
                }
                if (f10523j) {
                    f10523j = false;
                    b(f10522i, longValue, true);
                    b(f10522i, longValue);
                    return;
                }
                return;
            }
            if (f10523j) {
                f10523j = false;
                if (f10525l) {
                    f10525l = false;
                }
                f10521h = e(context);
                MLog.d("创建新会话: " + f10521h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f10521h);
                return;
            }
            f10521h = sharedPreferences.getString("session_id", null);
            edit.putLong(f10518e, longValue);
            edit.putLong(f10519f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + f10521h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f10521h);
            if (f10525l) {
                f10525l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMWorkDispatch.sendEventEx(f10522i, o.a.D, CoreProtocol.getInstance(f10522i), null, 0L);
                }
            }
            f(context);
            o.a(f10522i).a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f10521h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f10521h;
    }

    @Deprecated
    public String c() {
        return c(f10522i);
    }

    public boolean b(Context context, long j2, boolean z) {
        SharedPreferences sharedPreferences;
        String a2;
        long j3;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (a2 = y.a().a(f10522i)) == null) {
            return false;
        }
        long j4 = sharedPreferences.getLong(f10518e, 0L);
        long j5 = sharedPreferences.getLong(f10519f, 0L);
        if (j4 > 0 && j5 == 0) {
            z2 = true;
            if (z) {
                if (f10524k == 0) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                    j3 = j2;
                } else {
                    j3 = f10524k;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f10524k);
                }
                c(f10522i, Long.valueOf(j3));
            } else {
                c(f10522i, Long.valueOf(j2));
                j3 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(e.d.a.f10378g, j3);
            } else {
                jSONObject.put(e.d.a.f10378g, j2);
            }
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f10526m);
                jSONObject.put(e.d.a.f10379h, f10526m);
                f10526m = 0L;
            } else {
                jSONObject.put(e.d.a.f10379h, 0L);
            }
            i.a(context).a(a2, jSONObject, i.a.END);
            o.a(f10522i).e();
        }
        return z2;
    }

    public String a(Context context, long j2, boolean z) {
        String b2 = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(b2, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return b2;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f10522i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String b() {
        return f10521h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j2, long j3, long j4) {
        a(f10522i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f10522i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(f10521h)) {
            f10521h = y.a().a(f10522i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f10521h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f10378g, j3);
            jSONObject.put(e.d.a.f10379h, j4);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(f10521h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f10526m = j4;
                d(context);
                UMWorkDispatch.sendEventEx(f10522i, o.a.D, CoreProtocol.getInstance(f10522i), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f10521h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10522i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f10515b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(e.d.a.f10378g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f10376e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = f10522i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, longValue);
                jSONObject3.put(d.G, longValue2);
                jSONObject.put(e.d.a.f10375d, jSONObject3);
            }
            i.a(f10522i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f10522i);
            l.c(f10522i);
        } catch (Throwable unused) {
        }
    }
}
