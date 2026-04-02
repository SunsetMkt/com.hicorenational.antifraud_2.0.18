package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PathCenter.java */
/* JADX INFO: loaded from: classes2.dex */
public class at {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = new HashMap();
    private static String E = "";
    public static final String a = "env";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7016b = "exp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7017c = "imp";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7018d = "ua";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7019e = "zc";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7020f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7021g = "zf";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7022h = "exid";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7023i = "ucc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7024j = "ugc";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f7025k = "usi";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7026l = "uso";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7027m = "user";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7028n = "uspi";
    public static final String o = "dtfn";
    public static final String p = "pr";
    public static final String q = "upg";
    public static final String r = "pri";
    public static final String s = "probe";
    public static final String t = "bl";
    public static final String u = "wl";
    public static final String v = "subp";
    public static final String w = "subua";
    public static final String x = "sta";
    public static final String y = "emi";
    public static final String z = "sli";

    /* JADX INFO: compiled from: PathCenter.java */
    private static class a {
        private static final at a = new at();

        private a() {
        }
    }

    static {
        D.put(a, "envelope");
        D.put(f7016b, ".umeng");
        D.put(f7017c, ".imprint");
        D.put(f7018d, "ua.db");
        D.put(f7019e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f7021g, "umeng_zcfg_flag");
        D.put(f7022h, "exid.dat");
        D.put(f7023i, "umeng_common_config");
        D.put(f7024j, "umeng_general_config");
        D.put(f7025k, "um_session_id");
        D.put(f7026l, "umeng_sp_oaid");
        D.put(f7027m, "mobclick_agent_user_");
        D.put(f7028n, "umeng_subprocess_info");
        D.put(o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(q, "um_policy_grant");
        D.put(r, "um_pri");
        D.put(s, "UM_PROBE_DATA");
        D.put(t, "ekv_bl");
        D.put(u, "ekv_wl");
        D.put(v, e.a);
        D.put(w, "ua_");
        D.put(x, "stateless");
        D.put(y, ".emitter");
        D.put(z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + d.c.a.b.a.a.s1;
                return;
            }
            E = str + d.c.a.b.a.a.s1;
        }
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if (!f7016b.equalsIgnoreCase(str) && !f7017c.equalsIgnoreCase(str) && !y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return "." + E + str2.substring(1);
    }

    private at() {
    }

    public void a() {
        E = "";
    }

    public static at b() {
        return a.a;
    }
}
