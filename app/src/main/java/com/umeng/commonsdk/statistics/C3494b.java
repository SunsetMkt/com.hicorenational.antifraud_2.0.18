package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3369bz;
import com.umeng.analytics.pro.C3397d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.C3472c;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.C3489a;
import com.umeng.commonsdk.stateless.C3490b;
import com.umeng.commonsdk.stateless.C3492d;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.C3505e;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C3530c;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: EnvelopeManager.java */
/* renamed from: com.umeng.commonsdk.statistics.b */
/* loaded from: classes2.dex */
public class C3494b {

    /* renamed from: a */
    public static String f12715a = null;

    /* renamed from: b */
    public static String f12716b = "";

    /* renamed from: c */
    private static final String f12717c = "EnvelopeManager";

    /* renamed from: d */
    private static final String f12718d = "debug.umeng.umTaskId";

    /* renamed from: e */
    private static final String f12719e = "debug.umeng.umCaseId";

    /* renamed from: f */
    private static final String f12720f = "empty";

    /* renamed from: g */
    private static String f12721g = "";

    /* renamed from: h */
    private static String f12722h = "";

    /* renamed from: i */
    private static String f12723i;

    /* renamed from: j */
    private static Map<String, String> f12724j = new HashMap();

    /* renamed from: l */
    private static boolean f12725l;

    /* renamed from: k */
    private int f12726k = 0;

    static {
        f12724j.put("header", "#h");
        f12724j.put("sdk_type", "#sdt");
        f12724j.put(C3351bh.f11565Q, "#ac");
        f12724j.put("device_model", "#dm");
        f12724j.put("umid", "#umid");
        f12724j.put("os", "os");
        f12724j.put(C3351bh.f11562N, "#lang");
        f12724j.put(C3351bh.f11610ai, "#dt");
        f12724j.put("resolution", "#rl");
        f12724j.put(C3351bh.f11556H, "#dmf");
        f12724j.put(C3351bh.f11558J, "#dn");
        f12724j.put("platform_version", "#pv");
        f12724j.put("font_size_setting", "#fss");
        f12724j.put("os_version", "#ov");
        f12724j.put(C3351bh.f11557I, "#did");
        f12724j.put("platform_sdk_version", "#psv");
        f12724j.put(C3351bh.f11554F, "#db");
        f12724j.put("appkey", "#ak");
        f12724j.put(C3351bh.f11573Y, "#itr");
        f12724j.put("id_type", "#it");
        f12724j.put("uuid", "#ud");
        f12724j.put("device_id", "#dd");
        f12724j.put(C3351bh.f11572X, "#imp");
        f12724j.put("sdk_version", "#sv");
        f12724j.put("st", "#st");
        f12724j.put("analytics", "#a");
        f12724j.put("package_name", "#pkg");
        f12724j.put(C3351bh.f11662p, "#sig");
        f12724j.put(C3351bh.f11663q, "#sis1");
        f12724j.put(C3351bh.f11664r, "#sis");
        f12724j.put("app_version", "#av");
        f12724j.put("version_code", "#vc");
        f12724j.put(C3351bh.f11668v, "#imd");
        f12724j.put(C3351bh.f11550B, "#mnc");
        f12724j.put(C3351bh.f11553E, "#boa");
        f12724j.put(C3351bh.f11555G, "#mant");
        f12724j.put(C3351bh.f11561M, "#tz");
        f12724j.put(C3351bh.f11563O, "#ct");
        f12724j.put("carrier", "#car");
        f12724j.put("display_name", "#disn");
        f12724j.put(C3351bh.f11568T, "#nt");
        f12724j.put(C3351bh.f11628b, "#cv");
        f12724j.put(C3351bh.f11650d, "#mv");
        f12724j.put(C3351bh.f11649c, "#cot");
        f12724j.put(C3351bh.f11651e, "#mod");
        f12724j.put(C3351bh.f11611aj, "#al");
        f12724j.put("session_id", "#sid");
        f12724j.put(C3351bh.f11567S, "#ip");
        f12724j.put(C3351bh.f11569U, "#sre");
        f12724j.put(C3351bh.f11570V, "#fre");
        f12724j.put(C3351bh.f11571W, "#ret");
        f12724j.put("channel", "#chn");
        f12724j.put("wrapper_type", "#wt");
        f12724j.put("wrapper_version", "#wv");
        f12724j.put(C3351bh.f11600aY, "#tsv");
        f12724j.put(C3351bh.f11601aZ, "#rps");
        f12724j.put(C3351bh.f11631bc, "#mov");
        f12724j.put(C3397d.f11943i, "#vt");
        f12724j.put("secret", "#sec");
        f12724j.put(C3397d.f11917ah, "#prv");
        f12724j.put(C3397d.f11946l, "#$prv");
        f12724j.put(C3397d.f11947m, "#uda");
        f12724j.put(C3351bh.f11575a, "#tok");
        f12724j.put(C3351bh.f11592aQ, "#iv");
        f12724j.put(C3351bh.f11566R, "#ast");
        f12724j.put("backstate", "#bst");
        f12724j.put("zdata_ver", "#zv");
        f12724j.put("zdata_req_ts", "#zrt");
        f12724j.put("app_b_v", "#bv");
        f12724j.put("zdata", "#zta");
        f12724j.put(C3351bh.f11617ap, "#mt");
        f12724j.put(C3351bh.f11614am, "#zsv");
        f12724j.put(C3351bh.f11616ao, "#oos");
    }

    /* renamed from: a */
    public static String m11723a(String str) {
        return f12724j.containsKey(str) ? f12724j.get(str) : str;
    }

    /* renamed from: b */
    private static boolean m11729b() {
        f12721g = UMUtils.getSystemProperty(f12718d, "");
        f12722h = UMUtils.getSystemProperty(f12719e, "");
        return (!TextUtils.isEmpty(f12721g) && !f12720f.equals(f12721g)) && (!TextUtils.isEmpty(f12722h) && !f12720f.equals(f12722h));
    }

    /* renamed from: a */
    public static void m11727a() {
        if (f12723i != null) {
            f12723i = null;
            C3505e.m11857a();
        }
    }

    /* renamed from: b */
    public JSONObject m11733b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m11723a("header"), new JSONObject());
            try {
                if (m11729b()) {
                    jSONObject.put("umTaskId", f12721g);
                    jSONObject.put("umCaseId", f12722h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = m11726a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return m11724a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = m11722a(context, jSONObject3.toString().getBytes())) == null) {
                return m11724a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m11724a(114, jSONObject3);
            }
            int m11720a = m11720a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (m11720a != 0) {
                return m11724a(m11720a, jSONObject3);
            }
            if (ULog.DEBUG) {
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return m11724a(110, new JSONObject());
        }
    }

    /* renamed from: a */
    public static long m11721a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            String str = "free size is " + j2;
        }
        return j2;
    }

    /* renamed from: a */
    private JSONObject m11724a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public JSONObject m11732a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        String str4;
        String str5;
        boolean z;
        String str6;
        Envelope envelope;
        String str7;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            String str8 = "headerJSONObject size is " + jSONObject.toString().getBytes().length;
            String str9 = "bodyJSONObject size is " + jSONObject2.toString().getBytes().length;
        }
        JSONObject jSONObject3 = null;
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(C3397d.f11948n)) {
                    str5 = str2;
                    z = true;
                } else {
                    str5 = str2;
                    z = false;
                }
                JSONObject m11725a = m11725a(context, str5, z);
                if (m11725a != null && jSONObject != null) {
                    m11725a = m11726a(m11725a, jSONObject);
                }
                JSONObject jSONObject4 = m11725a;
                if (jSONObject4 != null && jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String) && (str7 = next) != null && jSONObject2.opt(str7) != null) {
                            try {
                                jSONObject4.put(m11723a(str7), jSONObject2.opt(str7));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str5 = C3351bh.f11586aK;
                }
                String str10 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str11 = str5 + "==" + str10 + "&=";
                    if (TextUtils.isEmpty(str11)) {
                        return m11724a(101, jSONObject4);
                    }
                    str6 = str11.endsWith("&=") ? str11.substring(0, str11.length() - 2) : str11;
                } else {
                    str6 = null;
                }
                if (jSONObject4 != null) {
                    try {
                        C3505e m11856a = C3505e.m11856a(context);
                        if (m11856a != null) {
                            m11856a.m11864b();
                            String encodeToString = Base64.encodeToString(new C3369bz().m11073a(m11856a.m11865c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(m11723a("header"));
                                jSONObject5.put(m11723a(C3351bh.f11573Y), encodeToString);
                                jSONObject4.put(m11723a("header"), jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return m11724a(113, jSONObject4);
                }
                if (jSONObject4 != null) {
                    Envelope m11722a = m11722a(context, jSONObject4.toString().getBytes());
                    if (m11722a == null) {
                        return m11724a(111, jSONObject4);
                    }
                    envelope = m11722a;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return m11724a(114, jSONObject4);
                }
                int m11720a = m11720a(context, envelope, str6, jSONObject4 != null ? jSONObject4.optJSONObject(m11723a("header")).optString(m11723a("app_version")) : null, str);
                if (m11720a != 0) {
                    return m11724a(m11720a, jSONObject4);
                }
                if (ULog.DEBUG) {
                    String str12 = "constructHeader size is " + jSONObject4.toString().getBytes().length;
                }
                if (!str6.startsWith(C3351bh.f11582aG) && !str6.startsWith(C3351bh.f11581aF) && !str6.startsWith("t") && !str6.startsWith("a") && !C3490b.m11678a()) {
                    new C3490b(context);
                    C3490b.m11679b();
                }
                return jSONObject4;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("header", jSONObject);
                        } catch (JSONException unused3) {
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject3 = jSONObject6;
                            UMCrashManager.reportCrash(context, e);
                            return m11724a(110, jSONObject3);
                        }
                        jSONObject3 = jSONObject6;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (jSONObject2 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    if (jSONObject2 != null) {
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2 != null && (next2 instanceof String) && (str4 = next2) != null && jSONObject2.opt(str4) != null) {
                                try {
                                    jSONObject3.put(str4, jSONObject2.opt(str4));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return m11724a(110, jSONObject3);
            }
        }
        return m11724a(110, (JSONObject) null);
    }

    /* renamed from: b */
    private static int[] m11730b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(C3472c.f12616a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(C3472c.f12617b, 0);
                iArr[1] = sharedPreferences.getInt(C3472c.f12618c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    /* renamed from: a */
    public JSONObject m11731a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m11723a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = m11726a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return m11724a(113, jSONObject3);
            }
            Envelope envelope = null;
            if (jSONObject3 != null && (envelope = m11722a(context, jSONObject3.toString().getBytes())) == null) {
                return m11724a(111, jSONObject3);
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return m11724a(114, jSONObject3);
            }
            int m11720a = m11720a(context, envelope2, "h==1.2.0", "", str);
            if (m11720a != 0) {
                return m11724a(m11720a, jSONObject3);
            }
            if (ULog.DEBUG) {
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return m11724a(110, new JSONObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:94:0x03f2
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: a */
    private static org.json.JSONObject m11725a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.C3494b.m11725a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    /* renamed from: a */
    private JSONObject m11726a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(m11723a("header")) != null && (jSONObject.opt(m11723a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(m11723a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(m11723a(C3397d.f11943i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f12726k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private Envelope m11722a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f12725l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    /* renamed from: a */
    private int m11720a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String m11709b = C3492d.m11709b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append(AbstractC1191a.f2606s1);
        sb.append(System.currentTimeMillis());
        sb.append(AbstractC1191a.f2606s1);
        sb.append(m11709b);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (C3530c.m12099a()) {
            if (str.startsWith(C3351bh.f11585aJ)) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith(C3351bh.f11585aJ)) {
            return 122;
        }
        if (!str.startsWith(C3351bh.f11582aG) && !str.startsWith(C3351bh.f11581aF) && !str.startsWith("a") && !str.startsWith("t")) {
            return C3492d.m11699a(context, C3489a.f12686f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    /* renamed from: a */
    public static void m11728a(boolean z) {
        f12725l = z;
    }
}
