package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CoreProtocolImpl.java */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static Context f10460a = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f10461l = "first_activate_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f10462m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private static Class<?> y;
    private static Method z;

    /* renamed from: b, reason: collision with root package name */
    private c f10463b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f10464c;

    /* renamed from: d, reason: collision with root package name */
    private String f10465d;

    /* renamed from: e, reason: collision with root package name */
    private String f10466e;

    /* renamed from: f, reason: collision with root package name */
    private int f10467f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f10468g;

    /* renamed from: h, reason: collision with root package name */
    private final int f10469h;

    /* renamed from: i, reason: collision with root package name */
    private int f10470i;

    /* renamed from: j, reason: collision with root package name */
    private int f10471j;

    /* renamed from: k, reason: collision with root package name */
    private long f10472k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* compiled from: CoreProtocolImpl.java */
    public static class a {
        public static final int A = 8210;
        public static final int B = 8211;
        public static final int C = 8212;
        public static final int D = 8213;
        public static final int E = 8214;
        public static final int F = 8215;

        /* renamed from: a, reason: collision with root package name */
        public static final int f10473a = 4097;

        /* renamed from: b, reason: collision with root package name */
        public static final int f10474b = 4098;

        /* renamed from: c, reason: collision with root package name */
        public static final int f10475c = 4099;

        /* renamed from: d, reason: collision with root package name */
        public static final int f10476d = 4100;

        /* renamed from: e, reason: collision with root package name */
        public static final int f10477e = 4101;

        /* renamed from: f, reason: collision with root package name */
        public static final int f10478f = 4102;

        /* renamed from: g, reason: collision with root package name */
        public static final int f10479g = 4103;

        /* renamed from: h, reason: collision with root package name */
        public static final int f10480h = 4104;

        /* renamed from: i, reason: collision with root package name */
        public static final int f10481i = 4105;

        /* renamed from: j, reason: collision with root package name */
        public static final int f10482j = 4106;

        /* renamed from: k, reason: collision with root package name */
        public static final int f10483k = 4352;

        /* renamed from: l, reason: collision with root package name */
        public static final int f10484l = 4353;

        /* renamed from: m, reason: collision with root package name */
        public static final int f10485m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 4357;
        public static final int q = 8193;
        public static final int r = 8194;
        public static final int s = 8195;
        public static final int t = 8196;
        public static final int u = 8197;
        public static final int v = 8199;
        public static final int w = 8200;
        public static final int x = 8201;
        public static final int y = 8208;
        public static final int z = 8209;
    }

    /* compiled from: CoreProtocolImpl.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final o f10486a = new o();

        private b() {
        }
    }

    static {
        h();
    }

    public static o a(Context context) {
        if (f10460a == null && context != null) {
            f10460a = context.getApplicationContext();
        }
        return b.f10486a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject f2;
        if (i.a(UMGlobalContext.getAppContext(f10460a)).c() || (f2 = i.a(UMGlobalContext.getAppContext(f10460a)).f()) == null) {
            return;
        }
        String optString = f2.optString("__av");
        String optString2 = f2.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10460a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10460a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f10472k, this.f10470i)) {
                    return;
                } else {
                    this.f10470i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f10472k, this.f10471j)) {
                    return;
                } else {
                    this.f10471j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f10468g == null) {
                    this.f10468g = new JSONArray();
                }
                this.f10468g.put(jSONObject);
                i.a(f10460a).a(this.f10468g);
                this.f10468g = new JSONArray();
                return;
            }
            if (this.f10468g.length() >= this.f10467f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(f10460a).a(this.f10468g);
                this.f10468g = new JSONArray();
            }
            if (this.f10472k == 0) {
                this.f10472k = System.currentTimeMillis();
            }
            this.f10468g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(com.umeng.analytics.pro.d.n)) {
                    i.a(f10460a).a(true, false);
                }
                i.a(f10460a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(com.umeng.analytics.pro.d.n) && (optJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.d.n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        i.a(f10460a).b(optString);
                    }
                }
            }
            i.a(f10460a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(f10460a, a.f10484l, CoreProtocol.getInstance(f10460a), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(x);
            if (cls != null) {
                y = cls;
                Method declaredMethod = y.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    z = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject b2 = b(UMEnvelopeBuild.maxDataSpace(f10460a));
        if (b2 == null || b2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b2.opt("header");
        JSONObject jSONObject2 = (JSONObject) b2.opt("content");
        if (f10460a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f10460a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a2 = a(UMEnvelopeBuild.maxDataSpace(f10460a));
        if (a2 == null || a2.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a2.opt("header");
        JSONObject jSONObject2 = (JSONObject) a2.opt("content");
        Context context = f10460a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject l2 = l();
        if (l2 != null) {
            try {
                l2.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l2;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f10460a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f10312i), verticalType);
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f10460a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    gameSdkVersion = "9.6.4";
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), gameSdkVersion);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.6.4");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f10460a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f10460a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10460a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f10460a, com.umeng.analytics.pro.d.an, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f10460a, com.umeng.analytics.pro.d.ao, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ah), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f10462m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f10315l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f10316m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f10315l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f10316m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f10460a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f10460a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f10465d)) {
                return this.f10465d;
            }
            if (this.f10464c == null) {
                this.f10464c = PreferenceWrapper.getDefault(f10460a);
            }
            String string = this.f10464c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f10460a);
            if (TextUtils.isEmpty(string)) {
                this.f10464c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                str = "0";
            } else {
                str = this.f10464c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f10464c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f10465d = str;
            return str;
        }
        str = str2;
        this.f10465d = str;
        return str;
    }

    private String n() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f10460a, "ud_da", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f10466e)) {
                return this.f10466e;
            }
            if (this.f10464c == null) {
                this.f10464c = PreferenceWrapper.getDefault(f10460a);
            }
            str = this.f10464c.getString("pre_date", "");
            if (TextUtils.isEmpty(str)) {
                str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                this.f10464c.edit().putString("pre_date", str).commit();
            } else {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                if (!str.equals(format)) {
                    this.f10464c.edit().putString("pre_date", format).commit();
                    str = format;
                }
            }
            this.f10466e = str;
            return str;
        }
        str = str2;
        this.f10466e = str;
        return str;
    }

    private void o() {
        try {
            this.f10470i = 0;
            this.f10471j = 0;
            this.f10472k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f10460a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(f10460a);
            }
            if (this.f10468g.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f10468g.length(); i2++) {
                JSONObject optJSONObject = this.f10468g.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f10468g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f10468g.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f10468g.getJSONObject(i2);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || t.equals(optString)) {
                            String b2 = u.a().b();
                            if (TextUtils.isEmpty(b2)) {
                                b2 = t;
                            }
                            jSONObject.put("__i", b2);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f10468g = jSONArray;
        }
    }

    private void r() {
        SharedPreferences sharedPreferences;
        try {
            if (!s() || f10460a == null || (sharedPreferences = PreferenceWrapper.getDefault(f10460a)) == null || sharedPreferences.getLong(f10461l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f10461l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            if (f10460a == null || (sharedPreferences = PreferenceWrapper.getDefault(f10460a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f10462m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f10460a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f10468g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(f10460a).a(this.f10468g);
                this.f10468g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f10460a).edit().putLong(n, this.f10472k).putInt(q, this.f10470i).putInt(r, this.f10471j).commit();
        } catch (Throwable unused) {
        }
    }

    private o() {
        this.f10463b = null;
        this.f10464c = null;
        this.f10465d = null;
        this.f10466e = null;
        this.f10467f = 10;
        this.f10468g = new JSONArray();
        this.f10469h = 5000;
        this.f10470i = 0;
        this.f10471j = 0;
        this.f10472k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10460a);
            this.f10472k = sharedPreferences.getLong(n, 0L);
            this.f10470i = sharedPreferences.getInt(q, 0);
            this.f10471j = sharedPreferences.getInt(r, 0);
            this.f10463b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    i.a(f10460a).i();
                    i.a(f10460a).h();
                    i.a(f10460a).b(true, false);
                    i.a(f10460a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(com.umeng.analytics.pro.d.n)) {
                    i.a(f10460a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(com.umeng.analytics.pro.d.T)) {
                    i.a(f10460a).h();
                }
                if (optJSONObject.has("error")) {
                    i.a(f10460a).i();
                }
            }
            i.a(f10460a).a();
        } catch (Exception unused) {
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f10487a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f10488b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f10489c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f10490d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f10491e = -1;

        /* renamed from: f, reason: collision with root package name */
        private ABTest f10492f;

        public c() {
            this.f10492f = null;
            this.f10492f = ABTest.getService(o.f10460a);
        }

        public void a() {
            try {
                int[] a2 = a(-1, -1);
                this.f10488b = a2[0];
                this.f10489c = a2[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            int i2;
            Defcon service2 = Defcon.getService(o.f10460a);
            if (service2.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f10487a;
                this.f10487a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f10487a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.f10460a), service2);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f10460a, "integrated_test", o.t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f10487a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.f10460a));
                } else if (this.f10492f.isInTest() && "RPT".equals(this.f10492f.getTestName())) {
                    if (this.f10492f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f10460a, "test_report_interval", o.t)).intValue() != -1) {
                            i2 = a(90000);
                        } else {
                            i2 = this.f10489c;
                            if (i2 <= 0) {
                                i2 = this.f10491e;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    this.f10487a = b(this.f10492f.getTestPolicy(), i2);
                } else {
                    int i3 = this.f10490d;
                    int i4 = this.f10491e;
                    int i5 = this.f10488b;
                    if (i5 != -1) {
                        i4 = this.f10489c;
                        i3 = i5;
                    }
                    this.f10487a = b(i3, i4);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f10487a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (this.f10487a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f10487a).getReportInterval() / 1000)});
                    } else if (this.f10487a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (this.f10487a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.f10487a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = this.f10487a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f10487a;
        }

        public int[] a(int i2, int i3) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f10460a, "report_policy", o.t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f10460a, "report_interval", o.t)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i2, i3};
            }
            if (6 == intValue) {
                int i4 = 90;
                if (intValue2 != -1 && intValue2 >= 90 && intValue2 <= 86400) {
                    i4 = intValue2;
                }
                return new int[]{intValue, i4 * 1000};
            }
            if (11 != intValue) {
                return new int[]{i2, i3};
            }
            int i5 = 15;
            if (intValue2 != -1 && intValue2 >= 15 && intValue2 <= 3600) {
                i5 = intValue2;
            }
            return new int[]{intValue, i5 * 1000};
        }

        public int a(int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f10460a, "test_report_interval", o.t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i2 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i2, int i3) {
            if (i2 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f10487a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i2 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f10487a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i2 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f10487a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.f10460a));
            }
            if (i2 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f10487a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.f10460a);
            }
            if (i2 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f10487a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i3);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.f10460a), i3);
            }
            if (i2 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f10487a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.f10460a));
            }
            if (i2 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f10487a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f10487a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i3);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i3);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!i.a(f10460a).e()) {
                JSONObject g2 = i.a(f10460a).g();
                if (g2 != null) {
                    String optString = g2.optString("__av");
                    String optString2 = g2.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10460a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10460a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10460a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10460a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f10460a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f10460a, a.f10484l, CoreProtocol.getInstance(f10460a), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    UMWorkDispatch.sendEvent(f10460a, a.f10485m, CoreProtocol.getInstance(f10460a), null);
                }
            }
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, Object> f10493a;

        /* renamed from: b, reason: collision with root package name */
        private String f10494b;

        /* renamed from: c, reason: collision with root package name */
        private String f10495c;

        /* renamed from: d, reason: collision with root package name */
        private long f10496d;

        private d() {
            this.f10493a = null;
            this.f10494b = null;
            this.f10495c = null;
            this.f10496d = 0L;
        }

        public Map<String, Object> a() {
            return this.f10493a;
        }

        public String b() {
            return this.f10495c;
        }

        public String c() {
            return this.f10494b;
        }

        public long d() {
            return this.f10496d;
        }

        public d(String str, Map<String, Object> map, String str2, long j2) {
            this.f10493a = null;
            this.f10494b = null;
            this.f10495c = null;
            this.f10496d = 0L;
            this.f10493a = map;
            this.f10494b = str;
            this.f10496d = j2;
            this.f10495c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            i.a(f10460a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.T)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.T));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray3 = new JSONArray();
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i2);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            if (jSONObject5.has(com.umeng.analytics.pro.d.u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.d.u);
                            }
                            jSONArray3.put(jSONObject5);
                        }
                        i2++;
                        jSONArray2 = jSONArray;
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.n, jSONArray3);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j2) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(f10460a)))) {
            return null;
        }
        JSONObject b2 = i.a(UMGlobalContext.getAppContext(f10460a)).b(false);
        String[] a2 = com.umeng.analytics.c.a(f10460a);
        if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.d.M, a2[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, a2[1]);
                if (jSONObject.length() > 0) {
                    b2.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a3 = r.a().a(f10460a);
        if (b2.length() == 1 && b2.optJSONObject(com.umeng.analytics.pro.d.L) != null && a3 != 3) {
            return null;
        }
        r.a().b(b2, f10460a);
        if (b2.length() <= 0 && a3 != 3) {
            return null;
        }
        JSONObject k2 = k();
        if (k2 != null) {
            b(k2);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (a3 == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject3.put("analytics", b2);
            }
            if (k2 != null && k2.length() > 0) {
                jSONObject2.put("header", k2);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j2);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z2) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f10463b == null) {
            this.f10463b = new c();
        }
        this.f10463b.a();
        ReportPolicy.ReportStrategy c2 = this.f10463b.c();
        boolean shouldSendMessage = c2.shouldSendMessage(z2);
        if (shouldSendMessage) {
            if (((c2 instanceof ReportPolicy.ReportByInterval) || (c2 instanceof ReportPolicy.DebugPolicy) || (c2 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c2 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c2.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = y;
        if (cls == null || (method = z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i2) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i2 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                h.a(f10460a);
                com.umeng.commonsdk.utils.c.c(f10460a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                switch (i2) {
                    case 4097:
                        if (UMUtils.isMainProgress(f10460a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if (t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        }
                        UMProcessDBHelper.getInstance(f10460a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f10460a), new JSONArray().put(obj));
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if (t.equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4099:
                        v.a(f10460a);
                        return;
                    case 4100:
                        l.c(f10460a);
                        return;
                    case 4101:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case 4102:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case 4103:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        u.a().a(f10460a, obj);
                        synchronized (this.w) {
                            this.v = true;
                        }
                        return;
                    case a.f10480h /* 4104 */:
                        u.a().c(f10460a, obj);
                        return;
                    case 4105:
                        d();
                        return;
                    case 4106:
                        h(obj);
                        return;
                    default:
                        switch (i2) {
                            case a.f10483k /* 4352 */:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                u.a().b(f10460a, obj);
                                synchronized (this.w) {
                                    this.u = true;
                                }
                                return;
                            case a.f10484l /* 4353 */:
                                a(obj, true);
                                return;
                            case a.f10485m /* 4354 */:
                                c();
                                return;
                            case a.n /* 4355 */:
                                if (!UMUtils.isMainProgress(f10460a)) {
                                    UMProcessDBHelper.getInstance(f10460a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f10460a), new JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    }
                                    return;
                                }
                            case a.o /* 4356 */:
                                if (obj == null || y == null || z == null) {
                                    return;
                                }
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                String str = "";
                                String str2 = "";
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.d.M)) {
                                        str = jSONObject.getString(com.umeng.analytics.pro.d.M);
                                        str2 = jSONObject.getString("uid");
                                    }
                                    a(str2, str);
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case a.s /* 8195 */:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case a.t /* 8196 */:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case a.u /* 8197 */:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i2) {
                                            case a.v /* 8199 */:
                                            case 8200:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case a.x /* 8201 */:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case a.y /* 8208 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f10460a;
                                                        UMWorkDispatch.sendEvent(context, a.z, CoreProtocol.getInstance(context), null);
                                                        Context context2 = f10460a;
                                                        UMWorkDispatch.sendEvent(context2, a.f10485m, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case a.z /* 8209 */:
                                                        a(obj, false);
                                                        return;
                                                    case a.A /* 8210 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(f10460a) || (this.f10463b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        switch (i2) {
                                                            case a.D /* 8213 */:
                                                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (DeviceConfig.getGlobleActivity(f10460a) != null) {
                                                                        u.b(f10460a);
                                                                    }
                                                                    Context context3 = f10460a;
                                                                    UMWorkDispatch.sendEventEx(context3, a.D, CoreProtocol.getInstance(context3), null, com.heytap.mcssdk.constant.a.r);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.E /* 8214 */:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                    String optString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                    String optString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                        return;
                                                                    }
                                                                    com.umeng.common.b.a(f10460a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME, optString);
                                                                    com.umeng.common.b.a(f10460a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD, optString2);
                                                                    com.umeng.common.b.a(f10460a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.DEBUG_KEY, optString3);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.F /* 8215 */:
                                                                com.umeng.common.b.a(f10460a, AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f10460a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                String string2 = jSONObject.getString("uid");
                long j2 = jSONObject.getLong("ts");
                String[] a2 = com.umeng.analytics.c.a(f10460a);
                if (a2 != null && string.equals(a2[0]) && string2.equals(a2[1])) {
                    return;
                }
                u.a().a(f10460a, j2);
                String c2 = y.a().c(f10460a);
                boolean b2 = u.a().b(f10460a, j2, false);
                com.umeng.analytics.c.a(f10460a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c2);
                u.a().a(f10460a, j2, true);
                if (b2) {
                    u.a().b(f10460a, j2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j2 = 0;
        try {
            if (f10460a == null || (sharedPreferences = PreferenceWrapper.getDefault(f10460a)) == null) {
                return 0L;
            }
            long j3 = sharedPreferences.getLong(f10461l, 0L);
            if (j3 == 0) {
                try {
                    j2 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f10461l, j2).commit();
                    return j2;
                } catch (Throwable unused) {
                }
            }
            return j3;
        } catch (Throwable unused2) {
            return j2;
        }
    }

    public void c(Object obj) {
        b(f10460a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j2 = jSONObject.getLong("ts");
                b(f10460a);
                d();
                String[] a2 = com.umeng.analytics.c.a(f10460a);
                if (a2 == null || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                    return;
                }
                u.a().a(f10460a, j2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + y.a().c(f10460a));
                boolean b2 = u.a().b(f10460a, j2, false);
                com.umeng.analytics.c.b(f10460a);
                u.a().a(f10460a, j2, true);
                if (b2) {
                    u.a().b(f10460a, j2);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j2) {
        try {
            if (q.a(jSONObject) <= j2) {
                return jSONObject;
            }
            jSONObject = null;
            i.a(f10460a).a(true, false);
            i.a(f10460a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = i.a(f10460a).a(z2);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(com.umeng.analytics.pro.d.n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(com.umeng.analytics.pro.d.n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i2);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(com.umeng.analytics.pro.d.t, optJSONArray2);
                                jSONObject2.remove(com.umeng.analytics.pro.d.u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i3));
                                }
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i4));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(com.umeng.analytics.pro.d.t, jSONArray5);
                                jSONObject2.remove(com.umeng.analytics.pro.d.u);
                            }
                            if (jSONObject2.has(com.umeng.analytics.pro.d.t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.t);
                                int i5 = 0;
                                while (i5 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i5);
                                    if (jSONObject3.has(com.umeng.analytics.pro.d.x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(com.umeng.analytics.pro.d.x));
                                        jSONObject3.remove(com.umeng.analytics.pro.d.x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.d.t, optJSONArray3);
                                jSONObject2.put(com.umeng.analytics.pro.d.z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.d.z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(com.umeng.analytics.pro.d.n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10460a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a2 = com.umeng.analytics.c.a(f10460a);
            if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(com.umeng.analytics.pro.d.M, a2[0]);
                jSONObject4.put(com.umeng.analytics.pro.d.N, a2[1]);
                if (jSONObject4.length() > 0) {
                    jSONObject.put(com.umeng.analytics.pro.d.L, jSONObject4);
                }
            }
            if (ABTest.getService(f10460a).isInTest()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(ABTest.getService(f10460a).getTestName(), ABTest.getService(f10460a).getGroupInfo());
                jSONObject.put(com.umeng.analytics.pro.d.K, jSONObject5);
            }
            r.a().a(jSONObject, f10460a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.f10463b == null) {
            this.f10463b = new c();
        }
        ReportPolicy.ReportStrategy c2 = this.f10463b.c();
        if (!(c2 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z2) {
            return ((ReportPolicy.DefconPolicy) c2).shouldSendMessageByInstant();
        }
        return c2.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            f(jSONObject);
                        }
                    } else {
                        f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.f10463b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f10460a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z2) {
                if (UMEnvelopeBuild.isOnline(f10460a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f10460a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i2++;
                }
            } catch (Throwable unused) {
            }
        }
        return i2 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        if (optJSONArray != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                        if (optJSONArray2 != null && a(optJSONArray2)) {
                            i2++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (i2 >= length) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a(long j2) {
        if (TextUtils.isEmpty(y.a().d(f10460a))) {
            return null;
        }
        JSONObject b2 = b(false);
        int a2 = r.a().a(f10460a);
        if (b2.length() > 0) {
            if (b2.length() == 1) {
                if (b2.optJSONObject(com.umeng.analytics.pro.d.L) != null && a2 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                    return null;
                }
            } else if (b2.length() == 2 && b2.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
            String optString = b2.optString(com.umeng.analytics.pro.d.n);
            String optString2 = b2.optString(com.umeng.analytics.pro.d.T);
            String optString3 = b2.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b2)) {
                return null;
            }
        } else if (a2 != 3) {
            return null;
        }
        JSONObject l2 = l();
        if (l2 != null) {
            c(l2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (l2 != null && l2.length() > 0) {
                jSONObject.put("header", l2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j2) {
        try {
            if (q.a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.d.aB, q.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return q.a(f10460a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 <= 28800000) {
            return i2 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            g(jSONObject);
                        }
                    } else {
                        g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f10460a) && d(true)) {
            i();
        }
    }
}
