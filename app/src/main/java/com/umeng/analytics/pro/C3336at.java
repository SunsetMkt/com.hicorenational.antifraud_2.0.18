package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: PathCenter.java */
/* renamed from: com.umeng.analytics.pro.at */
/* loaded from: classes2.dex */
public class C3336at {

    /* renamed from: A */
    public static final String f11482A = "rtd";

    /* renamed from: B */
    public static final String f11483B = "lepd";

    /* renamed from: C */
    public static final String f11484C = "ccfg";

    /* renamed from: D */
    private static Map<String, String> f11485D = new HashMap();

    /* renamed from: E */
    private static String f11486E = "";

    /* renamed from: a */
    public static final String f11487a = "env";

    /* renamed from: b */
    public static final String f11488b = "exp";

    /* renamed from: c */
    public static final String f11489c = "imp";

    /* renamed from: d */
    public static final String f11490d = "ua";

    /* renamed from: e */
    public static final String f11491e = "zc";

    /* renamed from: f */
    public static final String f11492f = "id";

    /* renamed from: g */
    public static final String f11493g = "zf";

    /* renamed from: h */
    public static final String f11494h = "exid";

    /* renamed from: i */
    public static final String f11495i = "ucc";

    /* renamed from: j */
    public static final String f11496j = "ugc";

    /* renamed from: k */
    public static final String f11497k = "usi";

    /* renamed from: l */
    public static final String f11498l = "uso";

    /* renamed from: m */
    public static final String f11499m = "user";

    /* renamed from: n */
    public static final String f11500n = "uspi";

    /* renamed from: o */
    public static final String f11501o = "dtfn";

    /* renamed from: p */
    public static final String f11502p = "pr";

    /* renamed from: q */
    public static final String f11503q = "upg";

    /* renamed from: r */
    public static final String f11504r = "pri";

    /* renamed from: s */
    public static final String f11505s = "probe";

    /* renamed from: t */
    public static final String f11506t = "bl";

    /* renamed from: u */
    public static final String f11507u = "wl";

    /* renamed from: v */
    public static final String f11508v = "subp";

    /* renamed from: w */
    public static final String f11509w = "subua";

    /* renamed from: x */
    public static final String f11510x = "sta";

    /* renamed from: y */
    public static final String f11511y = "emi";

    /* renamed from: z */
    public static final String f11512z = "sli";

    /* compiled from: PathCenter.java */
    /* renamed from: com.umeng.analytics.pro.at$a */
    private static class a {

        /* renamed from: a */
        private static final C3336at f11513a = new C3336at();

        private a() {
        }
    }

    static {
        f11485D.put(f11487a, "envelope");
        f11485D.put(f11488b, ".umeng");
        f11485D.put(f11489c, ".imprint");
        f11485D.put(f11490d, "ua.db");
        f11485D.put(f11491e, "umeng_zero_cache.db");
        f11485D.put("id", "umeng_it.cache");
        f11485D.put(f11493g, "umeng_zcfg_flag");
        f11485D.put(f11494h, "exid.dat");
        f11485D.put(f11495i, "umeng_common_config");
        f11485D.put(f11496j, "umeng_general_config");
        f11485D.put(f11497k, "um_session_id");
        f11485D.put(f11498l, "umeng_sp_oaid");
        f11485D.put(f11499m, "mobclick_agent_user_");
        f11485D.put(f11500n, "umeng_subprocess_info");
        f11485D.put(f11501o, "delayed_transmission_flag_new");
        f11485D.put("pr", "umeng_policy_result_flag");
        f11485D.put(f11503q, "um_policy_grant");
        f11485D.put(f11504r, "um_pri");
        f11485D.put(f11505s, "UM_PROBE_DATA");
        f11485D.put(f11506t, "ekv_bl");
        f11485D.put(f11507u, "ekv_wl");
        f11485D.put(f11508v, C3404e.f11973a);
        f11485D.put(f11509w, "ua_");
        f11485D.put(f11510x, "stateless");
        f11485D.put(f11511y, ".emitter");
        f11485D.put(f11512z, "um_slmode_sp");
        f11485D.put(f11482A, "um_rtd_conf");
        f11485D.put(f11483B, "");
        f11485D.put(f11484C, ".dmpvedpogjhejs.cfg");
    }

    /* renamed from: a */
    public void m10867a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(f11486E)) {
            if (str.length() > 3) {
                f11486E = str.substring(0, 3) + AbstractC1191a.f2606s1;
                return;
            }
            f11486E = str + AbstractC1191a.f2606s1;
        }
    }

    /* renamed from: b */
    public String m10868b(String str) {
        if (!f11485D.containsKey(str)) {
            return "";
        }
        String str2 = f11485D.get(str);
        if (!f11488b.equalsIgnoreCase(str) && !f11489c.equalsIgnoreCase(str) && !f11511y.equalsIgnoreCase(str)) {
            return f11486E + str2;
        }
        return "." + f11486E + str2.substring(1);
    }

    private C3336at() {
    }

    /* renamed from: a */
    public void m10866a() {
        f11486E = "";
    }

    /* renamed from: b */
    public static C3336at m10865b() {
        return a.f11513a;
    }
}
