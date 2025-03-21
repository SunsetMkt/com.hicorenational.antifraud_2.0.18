package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C3310b;
import com.umeng.analytics.C3311c;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.common.C3443b;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.C3494b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.C3530c;
import com.umeng.commonsdk.utils.C3531d;
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
/* renamed from: com.umeng.analytics.pro.o */
/* loaded from: classes2.dex */
public class C3414o {

    /* renamed from: a */
    private static Context f12165a = null;

    /* renamed from: l */
    private static final String f12166l = "first_activate_time";

    /* renamed from: m */
    private static final String f12167m = "ana_is_f";

    /* renamed from: n */
    private static final String f12168n = "thtstart";

    /* renamed from: o */
    private static final String f12169o = "dstk_last_time";

    /* renamed from: p */
    private static final String f12170p = "dstk_cnt";

    /* renamed from: q */
    private static final String f12171q = "gkvc";

    /* renamed from: r */
    private static final String f12172r = "ekvc";

    /* renamed from: t */
    private static final String f12173t = "-1";

    /* renamed from: x */
    private static final String f12174x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y */
    private static Class<?> f12175y;

    /* renamed from: z */
    private static Method f12176z;

    /* renamed from: b */
    private c f12177b;

    /* renamed from: c */
    private SharedPreferences f12178c;

    /* renamed from: d */
    private String f12179d;

    /* renamed from: e */
    private String f12180e;

    /* renamed from: f */
    private int f12181f;

    /* renamed from: g */
    private JSONArray f12182g;

    /* renamed from: h */
    private final int f12183h;

    /* renamed from: i */
    private int f12184i;

    /* renamed from: j */
    private int f12185j;

    /* renamed from: k */
    private long f12186k;

    /* renamed from: s */
    private final long f12187s;

    /* renamed from: u */
    private boolean f12188u;

    /* renamed from: v */
    private boolean f12189v;

    /* renamed from: w */
    private Object f12190w;

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$a */
    public static class a {

        /* renamed from: A */
        public static final int f12191A = 8210;

        /* renamed from: B */
        public static final int f12192B = 8211;

        /* renamed from: C */
        public static final int f12193C = 8212;

        /* renamed from: D */
        public static final int f12194D = 8213;

        /* renamed from: E */
        public static final int f12195E = 8214;

        /* renamed from: F */
        public static final int f12196F = 8215;

        /* renamed from: a */
        public static final int f12197a = 4097;

        /* renamed from: b */
        public static final int f12198b = 4098;

        /* renamed from: c */
        public static final int f12199c = 4099;

        /* renamed from: d */
        public static final int f12200d = 4100;

        /* renamed from: e */
        public static final int f12201e = 4101;

        /* renamed from: f */
        public static final int f12202f = 4102;

        /* renamed from: g */
        public static final int f12203g = 4103;

        /* renamed from: h */
        public static final int f12204h = 4104;

        /* renamed from: i */
        public static final int f12205i = 4105;

        /* renamed from: j */
        public static final int f12206j = 4106;

        /* renamed from: k */
        public static final int f12207k = 4352;

        /* renamed from: l */
        public static final int f12208l = 4353;

        /* renamed from: m */
        public static final int f12209m = 4354;

        /* renamed from: n */
        public static final int f12210n = 4355;

        /* renamed from: o */
        public static final int f12211o = 4356;

        /* renamed from: p */
        public static final int f12212p = 4357;

        /* renamed from: q */
        public static final int f12213q = 8193;

        /* renamed from: r */
        public static final int f12214r = 8194;

        /* renamed from: s */
        public static final int f12215s = 8195;

        /* renamed from: t */
        public static final int f12216t = 8196;

        /* renamed from: u */
        public static final int f12217u = 8197;

        /* renamed from: v */
        public static final int f12218v = 8199;

        /* renamed from: w */
        public static final int f12219w = 8200;

        /* renamed from: x */
        public static final int f12220x = 8201;

        /* renamed from: y */
        public static final int f12221y = 8208;

        /* renamed from: z */
        public static final int f12222z = 8209;
    }

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$b */
    private static class b {

        /* renamed from: a */
        private static final C3414o f12223a = new C3414o();

        private b() {
        }
    }

    static {
        m11319h();
    }

    /* synthetic */ C3414o(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* renamed from: a */
    public static C3414o m11300a(Context context) {
        if (f12165a == null && context != null) {
            f12165a = context.getApplicationContext();
        }
        return b.f12223a;
    }

    /* renamed from: b */
    private void m11307b(JSONObject jSONObject) {
        JSONObject m11261f;
        if (C3408i.m11232a(UMGlobalContext.getAppContext(f12165a)).m11257c() || (m11261f = C3408i.m11232a(UMGlobalContext.getAppContext(f12165a)).m11261f()) == null) {
            return;
        }
        String optString = m11261f.optString("__av");
        String optString2 = m11261f.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(C3494b.m11723a("app_version"), UMUtils.getAppVersionName(f12165a));
            } else {
                jSONObject.put(C3494b.m11723a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(C3494b.m11723a("version_code"), UMUtils.getAppVersionCode(f12165a));
            } else {
                jSONObject.put(C3494b.m11723a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m11312e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!m11303a(this.f12186k, this.f12184i)) {
                    return;
                } else {
                    this.f12184i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!m11303a(this.f12186k, this.f12185j)) {
                    return;
                } else {
                    this.f12185j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f12182g == null) {
                    this.f12182g = new JSONArray();
                }
                this.f12182g.put(jSONObject);
                C3408i.m11232a(f12165a).m11247a(this.f12182g);
                this.f12182g = new JSONArray();
                return;
            }
            if (this.f12182g.length() >= this.f12181f) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                C3408i.m11232a(f12165a).m11247a(this.f12182g);
                this.f12182g = new JSONArray();
            }
            if (this.f12186k == 0) {
                this.f12186k = System.currentTimeMillis();
            }
            this.f12182g.put(jSONObject);
        } catch (Throwable th) {
            MLog.m11748e(th);
        }
    }

    /* renamed from: f */
    private void m11315f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(C3494b.m11723a("header")).has(C3397d.f11903aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(C3494b.m11723a("analytics")) && (optJSONObject = jSONObject.optJSONObject(C3494b.m11723a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(C3397d.f11948n)) {
                    C3408i.m11232a(f12165a).m11249a(true, false);
                }
                C3408i.m11232a(f12165a).m11253b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(C3494b.m11723a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(C3494b.m11723a("analytics"));
                if (jSONObject2.has(C3397d.f11948n) && (optJSONObject2 = jSONObject2.getJSONArray(C3397d.f11948n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        C3408i.m11232a(f12165a).m11254b(optString);
                    }
                }
            }
            C3408i.m11232a(f12165a).m11253b();
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(f12165a, a.f12208l, CoreProtocol.getInstance(f12165a), null);
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private static void m11319h() {
        try {
            Class<?> cls = Class.forName(f12174x);
            if (cls != null) {
                f12175y = cls;
                Method declaredMethod = f12175y.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    f12176z = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    private void m11321i() {
        JSONObject m11338b = m11338b(UMEnvelopeBuild.maxDataSpace(f12165a));
        if (m11338b == null || m11338b.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m11338b.opt("header");
        JSONObject jSONObject2 = (JSONObject) m11338b.opt("content");
        if (f12165a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f12165a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                m11313e(buildEnvelopeWithExtHeader);
            }
            m11342b((Object) buildEnvelopeWithExtHeader);
        }
    }

    /* renamed from: j */
    private void m11322j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject m11332a = m11332a(UMEnvelopeBuild.maxDataSpace(f12165a));
        if (m11332a == null || m11332a.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) m11332a.opt("header");
        JSONObject jSONObject2 = (JSONObject) m11332a.opt("content");
        Context context = f12165a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            m11310d(buildEnvelopeWithExtHeader);
        }
        m11334a((Object) buildEnvelopeWithExtHeader);
    }

    /* renamed from: k */
    private JSONObject m11323k() {
        JSONObject m11324l = m11324l();
        if (m11324l != null) {
            try {
                m11324l.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return m11324l;
    }

    /* renamed from: l */
    private JSONObject m11324l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(C3494b.m11723a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(C3494b.m11723a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f12165a);
            jSONObject.put(C3494b.m11723a(C3397d.f11943i), verticalType);
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f12165a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    gameSdkVersion = "9.6.4";
                }
                jSONObject.put(C3494b.m11723a("sdk_version"), gameSdkVersion);
            } else {
                jSONObject.put(C3494b.m11723a("sdk_version"), "9.6.4");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f12165a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(C3494b.m11723a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f12165a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12165a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f12165a, C3397d.f11923an, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(C3494b.m11723a(C3397d.f11925ap), "");
                } else {
                    jSONObject.put(C3494b.m11723a(C3397d.f11925ap), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f12165a, C3397d.f11924ao, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(C3494b.m11723a(C3397d.f11926aq), "");
                } else {
                    jSONObject.put(C3494b.m11723a(C3397d.f11926aq), imprintProperty3);
                }
            }
            jSONObject.put(C3494b.m11723a(C3397d.f11917ah), "1.0.0");
            if (m11331s()) {
                jSONObject.put(C3494b.m11723a(C3397d.f11919aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f12167m, 0L).commit();
                }
            }
            jSONObject.put(C3494b.m11723a(C3397d.f11946l), m11325m());
            jSONObject.put(C3494b.m11723a(C3397d.f11947m), m11326n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(C3494b.m11723a(C3397d.f11946l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(C3494b.m11723a(C3397d.f11947m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f12165a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: m */
    private String m11325m() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f12165a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f12179d)) {
                return this.f12179d;
            }
            if (this.f12178c == null) {
                this.f12178c = PreferenceWrapper.getDefault(f12165a);
            }
            String string = this.f12178c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f12165a);
            if (TextUtils.isEmpty(string)) {
                this.f12178c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                str = "0";
            } else {
                str = this.f12178c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f12178c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f12179d = str;
            return str;
        }
        str = str2;
        this.f12179d = str;
        return str;
    }

    /* renamed from: n */
    private String m11326n() {
        String str;
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f12165a, "ud_da", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f12180e)) {
                return this.f12180e;
            }
            if (this.f12178c == null) {
                this.f12178c = PreferenceWrapper.getDefault(f12165a);
            }
            str = this.f12178c.getString("pre_date", "");
            if (TextUtils.isEmpty(str)) {
                str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                this.f12178c.edit().putString("pre_date", str).commit();
            } else {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                if (!str.equals(format)) {
                    this.f12178c.edit().putString("pre_date", format).commit();
                    str = format;
                }
            }
            this.f12180e = str;
            return str;
        }
        str = str2;
        this.f12180e = str;
        return str;
    }

    /* renamed from: o */
    private void m11327o() {
        try {
            this.f12184i = 0;
            this.f12185j = 0;
            this.f12186k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f12165a).edit().putLong(f12169o, System.currentTimeMillis()).putInt(f12170p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: p */
    private boolean m11328p() {
        try {
            if (!TextUtils.isEmpty(C3420u.m11389a().m11401b())) {
                m11341b(f12165a);
            }
            if (this.f12182g.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f12182g.length(); i2++) {
                JSONObject optJSONObject = this.f12182g.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || f12173t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: q */
    private void m11329q() {
        if (this.f12182g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f12182g.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f12182g.getJSONObject(i2);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || f12173t.equals(optString)) {
                            String m11401b = C3420u.m11389a().m11401b();
                            if (TextUtils.isEmpty(m11401b)) {
                                m11401b = f12173t;
                            }
                            jSONObject.put("__i", m11401b);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f12182g = jSONArray;
        }
    }

    /* renamed from: r */
    private void m11330r() {
        SharedPreferences sharedPreferences;
        try {
            if (!m11331s() || f12165a == null || (sharedPreferences = PreferenceWrapper.getDefault(f12165a)) == null || sharedPreferences.getLong(f12166l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f12166l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    private boolean m11331s() {
        SharedPreferences sharedPreferences;
        try {
            if (f12165a == null || (sharedPreferences = PreferenceWrapper.getDefault(f12165a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f12167m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public void m11340b() {
    }

    /* renamed from: c */
    public void m11343c() {
        m11341b(f12165a);
        m11345d();
        m11337a(true);
    }

    /* renamed from: d */
    public void m11345d() {
        try {
            if (this.f12182g.length() > 0) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                C3408i.m11232a(f12165a).m11247a(this.f12182g);
                this.f12182g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f12165a).edit().putLong(f12168n, this.f12186k).putInt(f12171q, this.f12184i).putInt(f12172r, this.f12185j).commit();
        } catch (Throwable unused) {
        }
    }

    private C3414o() {
        this.f12177b = null;
        this.f12178c = null;
        this.f12179d = null;
        this.f12180e = null;
        this.f12181f = 10;
        this.f12182g = new JSONArray();
        this.f12183h = 5000;
        this.f12184i = 0;
        this.f12185j = 0;
        this.f12186k = 0L;
        this.f12187s = 28800000L;
        this.f12188u = false;
        this.f12189v = false;
        this.f12190w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12165a);
            this.f12186k = sharedPreferences.getLong(f12168n, 0L);
            this.f12184i = sharedPreferences.getInt(f12171q, 0);
            this.f12185j = sharedPreferences.getInt(f12172r, 0);
            this.f12177b = new c();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private void m11318g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(C3494b.m11723a("header")).has(C3397d.f11903aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(C3494b.m11723a("analytics"))) {
                    if (!jSONObject.getJSONObject(C3494b.m11723a("analytics")).has(C3397d.f11948n)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    C3408i.m11232a(f12165a).m11264i();
                    C3408i.m11232a(f12165a).m11263h();
                    C3408i.m11232a(f12165a).m11255b(true, false);
                    C3408i.m11232a(f12165a).m11246a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(C3494b.m11723a("analytics")) && (optJSONObject = jSONObject.optJSONObject(C3494b.m11723a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(C3397d.f11948n)) {
                    C3408i.m11232a(f12165a).m11255b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(C3397d.f11894T)) {
                    C3408i.m11232a(f12165a).m11263h();
                }
                if (optJSONObject.has("error")) {
                    C3408i.m11232a(f12165a).m11264i();
                }
            }
            C3408i.m11232a(f12165a).m11246a();
        } catch (Exception unused) {
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$c */
    public static class c {

        /* renamed from: a */
        private ReportPolicy.ReportStrategy f12224a = null;

        /* renamed from: b */
        private int f12225b = -1;

        /* renamed from: c */
        private int f12226c = -1;

        /* renamed from: d */
        private int f12227d = -1;

        /* renamed from: e */
        private int f12228e = -1;

        /* renamed from: f */
        private ABTest f12229f;

        public c() {
            this.f12229f = null;
            this.f12229f = ABTest.getService(C3414o.f12165a);
        }

        /* renamed from: a */
        public void m11352a() {
            try {
                int[] m11353a = m11353a(-1, -1);
                this.f12225b = m11353a[0];
                this.f12226c = m11353a[1];
            } catch (Throwable unused) {
            }
        }

        /* renamed from: b */
        protected void m11354b() {
            int i2;
            Defcon service2 = Defcon.getService(C3414o.f12165a);
            if (service2.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f12224a;
                this.f12224a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f12224a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(C3414o.f12165a), service2);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C3414o.f12165a, "integrated_test", C3414o.f12173t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(C3409j.f12078K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f12224a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(C3414o.f12165a));
                } else if (this.f12229f.isInTest() && "RPT".equals(this.f12229f.getTestName())) {
                    if (this.f12229f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(C3414o.f12165a, "test_report_interval", C3414o.f12173t)).intValue() != -1) {
                            i2 = m11351a(90000);
                        } else {
                            i2 = this.f12226c;
                            if (i2 <= 0) {
                                i2 = this.f12228e;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    this.f12224a = m11350b(this.f12229f.getTestPolicy(), i2);
                } else {
                    int i3 = this.f12227d;
                    int i4 = this.f12228e;
                    int i5 = this.f12225b;
                    if (i5 != -1) {
                        i4 = this.f12226c;
                        i3 = i5;
                    }
                    this.f12224a = m11350b(i3, i4);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f12224a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(C3409j.f12076I, 3, "", null, null);
                    } else if (this.f12224a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(C3409j.f12077J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f12224a).getReportInterval() / 1000)});
                    } else if (this.f12224a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(C3409j.f12079L, 3, "", null, null);
                    } else if (this.f12224a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.f12224a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(C3409j.f12080M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = this.f12224a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        /* renamed from: c */
        public ReportPolicy.ReportStrategy m11355c() {
            m11354b();
            return this.f12224a;
        }

        /* renamed from: a */
        public int[] m11353a(int i2, int i3) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C3414o.f12165a, "report_policy", C3414o.f12173t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C3414o.f12165a, "report_interval", C3414o.f12173t)).intValue();
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

        /* renamed from: a */
        public int m11351a(int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(C3414o.f12165a, "test_report_interval", C3414o.f12173t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i2 : intValue * 1000;
        }

        /* renamed from: b */
        private ReportPolicy.ReportStrategy m11350b(int i2, int i3) {
            if (i2 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f12224a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i2 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f12224a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i2 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f12224a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(C3414o.f12165a));
            }
            if (i2 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f12224a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(C3414o.f12165a);
            }
            if (i2 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f12224a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i3);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(C3414o.f12165a), i3);
            }
            if (i2 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f12224a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(C3414o.f12165a));
            }
            if (i2 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f12224a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f12224a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i3);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i3);
            return reportQuasiRealtime;
        }
    }

    /* renamed from: c */
    private void m11308c(JSONObject jSONObject) {
        try {
            if (!C3408i.m11232a(f12165a).m11260e()) {
                JSONObject m11262g = C3408i.m11232a(f12165a).m11262g();
                if (m11262g != null) {
                    String optString = m11262g.optString("__av");
                    String optString2 = m11262g.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(C3494b.m11723a("app_version"), UMUtils.getAppVersionName(f12165a));
                    } else {
                        jSONObject.put(C3494b.m11723a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(C3494b.m11723a("version_code"), UMUtils.getAppVersionCode(f12165a));
                        return;
                    } else {
                        jSONObject.put(C3494b.m11723a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(C3494b.m11723a("app_version"), UMUtils.getAppVersionName(f12165a));
            jSONObject.put(C3494b.m11723a("version_code"), UMUtils.getAppVersionCode(f12165a));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m11333a() {
        if (f12165a != null) {
            synchronized (this.f12190w) {
                if (this.f12188u) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f12165a, a.f12208l, CoreProtocol.getInstance(f12165a), null);
                }
            }
            synchronized (this.f12190w) {
                if (this.f12189v) {
                    UMWorkDispatch.sendEvent(f12165a, a.f12209m, CoreProtocol.getInstance(f12165a), null);
                }
            }
        }
    }

    /* compiled from: CoreProtocolImpl.java */
    /* renamed from: com.umeng.analytics.pro.o$d */
    public static class d {

        /* renamed from: a */
        private Map<String, Object> f12230a;

        /* renamed from: b */
        private String f12231b;

        /* renamed from: c */
        private String f12232c;

        /* renamed from: d */
        private long f12233d;

        private d() {
            this.f12230a = null;
            this.f12231b = null;
            this.f12232c = null;
            this.f12233d = 0L;
        }

        /* renamed from: a */
        public Map<String, Object> m11356a() {
            return this.f12230a;
        }

        /* renamed from: b */
        public String m11357b() {
            return this.f12232c;
        }

        /* renamed from: c */
        public String m11358c() {
            return this.f12231b;
        }

        /* renamed from: d */
        public long m11359d() {
            return this.f12233d;
        }

        public d(String str, Map<String, Object> map, String str2, long j2) {
            this.f12230a = null;
            this.f12231b = null;
            this.f12232c = null;
            this.f12233d = 0L;
            this.f12230a = map;
            this.f12231b = str;
            this.f12233d = j2;
            this.f12232c = str2;
        }
    }

    /* renamed from: h */
    private void m11320h(Object obj) {
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
            C3408i.m11232a(f12165a).m11250a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m11310d(JSONObject jSONObject) {
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
            if (jSONObject.has(C3494b.m11723a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(C3494b.m11723a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m11738d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.m11738d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C3397d.f11894T)) {
                    jSONObject3.put(C3397d.f11894T, jSONObject4.getJSONArray(C3397d.f11894T));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m11738d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.m11738d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m11738d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.m11738d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C3397d.f11948n)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(C3397d.f11948n);
                    JSONArray jSONArray3 = new JSONArray();
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i2);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            if (jSONObject5.has(C3397d.f11955u)) {
                                jSONObject5.remove(C3397d.f11955u);
                            }
                            jSONArray3.put(jSONObject5);
                        }
                        i2++;
                        jSONArray2 = jSONArray;
                    }
                    jSONObject3.put(C3397d.f11948n, jSONArray3);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m11738d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.m11738d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C3397d.f11883I)) {
                    jSONObject3.put(C3397d.f11883I, jSONObject4.getJSONObject(C3397d.f11883I));
                }
                if (jSONObject4.has(C3397d.f11886L)) {
                    jSONObject3.put(C3397d.f11886L, jSONObject4.getJSONObject(C3397d.f11886L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.m11738d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.m11738d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(C3494b.m11723a("header")) && (jSONObject2 = jSONObject.getJSONObject(C3494b.m11723a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(C3494b.m11723a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(C3494b.m11723a("sdk_version")));
                }
                if (jSONObject2.has(C3494b.m11723a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(C3494b.m11723a("device_id")));
                }
                if (jSONObject2.has(C3494b.m11723a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(C3494b.m11723a("device_model")));
                }
                if (jSONObject2.has(C3494b.m11723a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(C3494b.m11723a("version_code")));
                }
                if (jSONObject2.has(C3494b.m11723a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(C3494b.m11723a("appkey")));
                }
                if (jSONObject2.has(C3494b.m11723a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(C3494b.m11723a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m11738d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m11748e(th);
        }
    }

    /* renamed from: b */
    public JSONObject m11338b(long j2) {
        if (TextUtils.isEmpty(C3424y.m11419a().m11434d(UMGlobalContext.getAppContext(f12165a)))) {
            return null;
        }
        JSONObject m11252b = C3408i.m11232a(UMGlobalContext.getAppContext(f12165a)).m11252b(false);
        String[] m10792a = C3311c.m10792a(f12165a);
        if (m10792a != null && !TextUtils.isEmpty(m10792a[0]) && !TextUtils.isEmpty(m10792a[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(C3397d.f11887M, m10792a[0]);
                jSONObject.put(C3397d.f11888N, m10792a[1]);
                if (jSONObject.length() > 0) {
                    m11252b.put(C3397d.f11886L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int m11369a = C3417r.m11365a().m11369a(f12165a);
        if (m11252b.length() == 1 && m11252b.optJSONObject(C3397d.f11886L) != null && m11369a != 3) {
            return null;
        }
        C3417r.m11365a().m11371b(m11252b, f12165a);
        if (m11252b.length() <= 0 && m11369a != 3) {
            return null;
        }
        JSONObject m11323k = m11323k();
        if (m11323k != null) {
            m11307b(m11323k);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (m11369a == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (m11252b != null && m11252b.length() > 0) {
                jSONObject3.put("analytics", m11252b);
            }
            if (m11323k != null && m11323k.length() > 0) {
                jSONObject2.put("header", m11323k);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return m11306b(jSONObject2, j2);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    /* renamed from: c */
    private boolean m11309c(boolean z) {
        if (m11331s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f12177b == null) {
            this.f12177b = new c();
        }
        this.f12177b.m11352a();
        ReportPolicy.ReportStrategy m11355c = this.f12177b.m11355c();
        boolean shouldSendMessage = m11355c.shouldSendMessage(z);
        if (shouldSendMessage) {
            if (((m11355c instanceof ReportPolicy.ReportByInterval) || (m11355c instanceof ReportPolicy.DebugPolicy) || (m11355c instanceof ReportPolicy.ReportQuasiRealtime)) && m11328p()) {
                m11345d();
            }
            if ((m11355c instanceof ReportPolicy.DefconPolicy) && m11328p()) {
                m11345d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.m11738d("数据发送策略 : " + m11355c.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    /* renamed from: a */
    private void m11302a(String str, String str2) {
        Method method;
        Class<?> cls = f12175y;
        if (cls == null || (method = f12176z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    /* renamed from: e */
    private void m11313e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(C3494b.m11723a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(C3494b.m11723a("analytics"));
                if (jSONObject4.has(C3397d.f11948n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(C3397d.f11948n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(C3397d.f11948n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.m11738d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(C3397d.f11886L)) {
                    jSONObject3.put(C3397d.f11886L, jSONObject4.getJSONObject(C3397d.f11886L));
                    if (jSONObject3.length() > 0) {
                        MLog.m11738d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(C3494b.m11723a("header")) && jSONObject.has(C3494b.m11723a("header")) && (jSONObject2 = jSONObject.getJSONObject(C3494b.m11723a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(C3494b.m11723a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(C3494b.m11723a("sdk_version")));
                }
                if (jSONObject2.has(C3494b.m11723a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(C3494b.m11723a("device_id")));
                }
                if (jSONObject2.has(C3494b.m11723a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(C3494b.m11723a("device_model")));
                }
                if (jSONObject2.has(C3494b.m11723a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(C3494b.m11723a("version_code")));
                }
                if (jSONObject2.has(C3494b.m11723a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(C3494b.m11723a("appkey")));
                }
                if (jSONObject2.has(C3494b.m11723a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(C3494b.m11723a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.m11738d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.m11748e(th);
        }
    }

    /* renamed from: a */
    public void m11335a(Object obj, int i2) {
        if (C3530c.m12099a()) {
            if (i2 != 4357) {
                return;
            }
            try {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                C3407h.m11224a(f12165a);
                C3530c.m12102c(f12165a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                switch (i2) {
                    case 4097:
                        if (UMUtils.isMainProgress(f12165a)) {
                            if (obj != null) {
                                m11312e(obj);
                            }
                            if (f12173t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            m11337a(false);
                            return;
                        }
                        UMProcessDBHelper.getInstance(f12165a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f12165a), new JSONArray().put(obj));
                        return;
                    case 4098:
                        if (obj != null) {
                            m11312e(obj);
                        }
                        if (f12173t.equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        m11337a(false);
                        return;
                    case 4099:
                        C3421v.m11409a(f12165a);
                        return;
                    case 4100:
                        C3411l.m11279c(f12165a);
                        return;
                    case 4101:
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        m11336a((Object) null, true);
                        m11317g(obj);
                        return;
                    case 4102:
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        m11336a((Object) null, true);
                        m11314f(obj);
                        return;
                    case 4103:
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        C3420u.m11389a().m11398a(f12165a, obj);
                        synchronized (this.f12190w) {
                            this.f12189v = true;
                        }
                        return;
                    case a.f12204h /* 4104 */:
                        C3420u.m11389a().m11407c(f12165a, obj);
                        return;
                    case 4105:
                        m11345d();
                        return;
                    case 4106:
                        m11320h(obj);
                        return;
                    default:
                        switch (i2) {
                            case a.f12207k /* 4352 */:
                                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                C3420u.m11389a().m11403b(f12165a, obj);
                                synchronized (this.f12190w) {
                                    this.f12188u = true;
                                }
                                return;
                            case a.f12208l /* 4353 */:
                                m11336a(obj, true);
                                return;
                            case a.f12209m /* 4354 */:
                                m11343c();
                                return;
                            case a.f12210n /* 4355 */:
                                if (!UMUtils.isMainProgress(f12165a)) {
                                    UMProcessDBHelper.getInstance(f12165a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f12165a), new JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        m11312e(obj);
                                        m11345d();
                                        return;
                                    }
                                    return;
                                }
                            case a.f12211o /* 4356 */:
                                if (obj == null || f12175y == null || f12176z == null) {
                                    return;
                                }
                                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                String str = "";
                                String str2 = "";
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject.has("uid") && jSONObject.has(C3397d.f11887M)) {
                                        str = jSONObject.getString(C3397d.f11887M);
                                        str2 = jSONObject.getString("uid");
                                    }
                                    m11302a(str2, str);
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case a.f12215s /* 8195 */:
                                        C3310b.m10736a().m10757a(obj);
                                        return;
                                    case a.f12216t /* 8196 */:
                                        C3310b.m10736a().m10788m();
                                        return;
                                    case a.f12217u /* 8197 */:
                                        C3310b.m10736a().m10786k();
                                        return;
                                    default:
                                        switch (i2) {
                                            case a.f12218v /* 8199 */:
                                            case 8200:
                                                C3310b.m10736a().m10766b(obj);
                                                return;
                                            case a.f12220x /* 8201 */:
                                                C3310b.m10736a().m10766b((Object) null);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case a.f12221y /* 8208 */:
                                                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f12165a;
                                                        UMWorkDispatch.sendEvent(context, a.f12222z, CoreProtocol.getInstance(context), null);
                                                        Context context2 = f12165a;
                                                        UMWorkDispatch.sendEvent(context2, a.f12209m, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case a.f12222z /* 8209 */:
                                                        m11336a(obj, false);
                                                        return;
                                                    case a.f12191A /* 8210 */:
                                                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(f12165a) || (this.f12177b.m11355c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        m11337a(true);
                                                        return;
                                                    default:
                                                        switch (i2) {
                                                            case a.f12194D /* 8213 */:
                                                                if (FieldManager.allow(C3531d.f12957E)) {
                                                                    if (DeviceConfig.getGlobleActivity(f12165a) != null) {
                                                                        C3420u.m11392b(f12165a);
                                                                    }
                                                                    Context context3 = f12165a;
                                                                    UMWorkDispatch.sendEventEx(context3, a.f12194D, CoreProtocol.getInstance(context3), null, C2084a.f6136r);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.f12195E /* 8214 */:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                    String optString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                    String optString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                        return;
                                                                    }
                                                                    C3443b.m11506a(f12165a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME, optString);
                                                                    C3443b.m11506a(f12165a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD, optString2);
                                                                    C3443b.m11506a(f12165a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.DEBUG_KEY, optString3);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.f12196F /* 8215 */:
                                                                C3443b.m11505a(f12165a, AnalyticsConfig.RTD_SP_FILE);
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

    /* renamed from: g */
    private void m11317g(Object obj) {
        try {
            m11341b(f12165a);
            m11345d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(C3397d.f11887M);
                String string2 = jSONObject.getString("uid");
                long j2 = jSONObject.getLong("ts");
                String[] m10792a = C3311c.m10792a(f12165a);
                if (m10792a != null && string.equals(m10792a[0]) && string2.equals(m10792a[1])) {
                    return;
                }
                C3420u.m11389a().m11397a(f12165a, j2);
                String m11433c = C3424y.m11419a().m11433c(f12165a);
                boolean m11404b = C3420u.m11389a().m11404b(f12165a, j2, false);
                C3311c.m10791a(f12165a, string, string2);
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + m11433c);
                C3420u.m11389a().m11396a(f12165a, j2, true);
                if (m11404b) {
                    C3420u.m11389a().m11402b(f12165a, j2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public long m11348f() {
        SharedPreferences sharedPreferences;
        long j2 = 0;
        try {
            if (f12165a == null || (sharedPreferences = PreferenceWrapper.getDefault(f12165a)) == null) {
                return 0L;
            }
            long j3 = sharedPreferences.getLong(f12166l, 0L);
            if (j3 == 0) {
                try {
                    j2 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f12166l, j2).commit();
                    return j2;
                } catch (Throwable unused) {
                }
            }
            return j3;
        } catch (Throwable unused2) {
            return j2;
        }
    }

    /* renamed from: c */
    public void m11344c(Object obj) {
        m11341b(f12165a);
        m11345d();
        if (m11311d(false)) {
            m11322j();
        }
    }

    /* renamed from: f */
    private void m11314f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j2 = jSONObject.getLong("ts");
                m11341b(f12165a);
                m11345d();
                String[] m10792a = C3311c.m10792a(f12165a);
                if (m10792a == null || TextUtils.isEmpty(m10792a[0]) || TextUtils.isEmpty(m10792a[1])) {
                    return;
                }
                C3420u.m11389a().m11397a(f12165a, j2);
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + C3424y.m11419a().m11433c(f12165a));
                boolean m11404b = C3420u.m11389a().m11404b(f12165a, j2, false);
                C3311c.m10793b(f12165a);
                C3420u.m11389a().m11396a(f12165a, j2, true);
                if (m11404b) {
                    C3420u.m11389a().m11402b(f12165a, j2);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11746e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    /* renamed from: b */
    private JSONObject m11306b(JSONObject jSONObject, long j2) {
        try {
            if (C3416q.m11363a(jSONObject) <= j2) {
                return jSONObject;
            }
            jSONObject = null;
            C3408i.m11232a(f12165a).m11249a(true, false);
            C3408i.m11232a(f12165a).m11253b();
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: b */
    public JSONObject m11339b(boolean z) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = C3408i.m11232a(f12165a).m11245a(z);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(C3397d.f11948n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(C3397d.f11948n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i2);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(C3397d.f11954t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(C3397d.f11955u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(C3397d.f11954t, optJSONArray2);
                                jSONObject2.remove(C3397d.f11955u);
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
                                jSONArraySortUtil.setCompareKey(C3397d.f11958x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(C3397d.f11954t, jSONArray5);
                                jSONObject2.remove(C3397d.f11955u);
                            }
                            if (jSONObject2.has(C3397d.f11954t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(C3397d.f11954t);
                                int i5 = 0;
                                while (i5 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i5);
                                    if (jSONObject3.has(C3397d.f11958x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(C3397d.f11958x));
                                        jSONObject3.remove(C3397d.f11958x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(C3397d.f11954t, optJSONArray3);
                                jSONObject2.put(C3397d.f11960z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(C3397d.f11960z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(C3397d.f11948n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e2) {
                    MLog.m11744e("merge pages error");
                    e2.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12165a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] m10792a = C3311c.m10792a(f12165a);
            if (m10792a != null && !TextUtils.isEmpty(m10792a[0]) && !TextUtils.isEmpty(m10792a[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(C3397d.f11887M, m10792a[0]);
                jSONObject4.put(C3397d.f11888N, m10792a[1]);
                if (jSONObject4.length() > 0) {
                    jSONObject.put(C3397d.f11886L, jSONObject4);
                }
            }
            if (ABTest.getService(f12165a).isInTest()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(ABTest.getService(f12165a).getTestName(), ABTest.getService(f12165a).getGroupInfo());
                jSONObject.put(C3397d.f11885K, jSONObject5);
            }
            C3417r.m11365a().m11370a(jSONObject, f12165a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: e */
    public void m11347e() {
        if (m11311d(false)) {
            m11322j();
        }
    }

    /* renamed from: d */
    public void m11346d(Object obj) {
        m11330r();
        m11325m();
        m11326n();
        m11337a(true);
    }

    /* renamed from: d */
    private boolean m11311d(boolean z) {
        if (this.f12177b == null) {
            this.f12177b = new c();
        }
        ReportPolicy.ReportStrategy m11355c = this.f12177b.m11355c();
        if (!(m11355c instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z) {
            return ((ReportPolicy.DefconPolicy) m11355c).shouldSendMessageByInstant();
        }
        return m11355c.shouldSendMessage(false);
    }

    /* renamed from: b */
    public void m11342b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            m11315f(jSONObject);
                        }
                    } else {
                        m11315f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public void m11341b(Context context) {
        try {
            C3408i.m11232a(context).m11259d();
            m11329q();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m11337a(boolean z) {
        if (m11309c(z)) {
            if (!(this.f12177b.m11355c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f12165a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    m11322j();
                    return;
                }
                return;
            }
            if (z) {
                if (UMEnvelopeBuild.isOnline(f12165a)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    m11322j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f12165a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                m11322j();
            }
        }
    }

    /* renamed from: a */
    private boolean m11304a(JSONArray jSONArray) {
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

    /* renamed from: a */
    private boolean m11305a(JSONObject jSONObject) {
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
                        if (optJSONArray2 != null && m11304a(optJSONArray2)) {
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

    /* renamed from: a */
    public JSONObject m11332a(long j2) {
        if (TextUtils.isEmpty(C3424y.m11419a().m11434d(f12165a))) {
            return null;
        }
        JSONObject m11339b = m11339b(false);
        int m11369a = C3417r.m11365a().m11369a(f12165a);
        if (m11339b.length() > 0) {
            if (m11339b.length() == 1) {
                if (m11339b.optJSONObject(C3397d.f11886L) != null && m11369a != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(m11339b.optString("userlevel")) && m11369a != 3) {
                    return null;
                }
            } else if (m11339b.length() == 2 && m11339b.optJSONObject(C3397d.f11886L) != null && !TextUtils.isEmpty(m11339b.optString("userlevel")) && m11369a != 3) {
                return null;
            }
            String optString = m11339b.optString(C3397d.f11948n);
            String optString2 = m11339b.optString(C3397d.f11894T);
            String optString3 = m11339b.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && m11305a(m11339b)) {
                return null;
            }
        } else if (m11369a != 3) {
            return null;
        }
        JSONObject m11324l = m11324l();
        if (m11324l != null) {
            m11308c(m11324l);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (m11369a == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (m11339b != null && m11339b.length() > 0) {
                jSONObject2.put("analytics", m11339b);
            }
            if (m11324l != null && m11324l.length() > 0) {
                jSONObject.put("header", m11324l);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return m11301a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    private JSONObject m11301a(JSONObject jSONObject, long j2) {
        try {
            if (C3416q.m11363a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(C3397d.f11903aB, C3416q.m11363a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return C3416q.m11364a(f12165a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    /* renamed from: a */
    private boolean m11303a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 <= 28800000) {
            return i2 < 5000;
        }
        m11327o();
        return true;
    }

    /* renamed from: a */
    public void m11334a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            m11318g(jSONObject);
                        }
                    } else {
                        m11318g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public void m11336a(Object obj, boolean z) {
        if (z) {
            if (m11311d(true)) {
                m11321i();
            }
        } else if (UMEnvelopeBuild.isOnline(f12165a) && m11311d(true)) {
            m11321i();
        }
    }
}
