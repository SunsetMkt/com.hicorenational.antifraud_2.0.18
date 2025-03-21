package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.w0 */
/* loaded from: classes.dex */
public class C2455w0 {
    /* renamed from: a */
    private static void m7397a(String str, String str2) {
        C2398b0.m7040a().m7043a(new C2423j1(str, str2));
    }

    /* renamed from: a */
    public static boolean m7398a() {
        String m7295a = AbstractC2443q0.m7295a();
        if (TextUtils.isEmpty(m7295a)) {
            m7295a = C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_time_interval", "");
            AbstractC2443q0.m7306f(m7295a);
        }
        String m7315m = AbstractC2443q0.m7315m();
        if (TextUtils.isEmpty(m7315m)) {
            m7315m = C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_time_last", "");
            AbstractC2443q0.m7300c(m7315m);
        }
        if (!TextUtils.isEmpty(m7295a) && !TextUtils.isEmpty(m7315m)) {
            try {
                return System.currentTimeMillis() - Long.parseLong(m7315m) > ((long) Integer.parseInt(m7295a));
            } catch (NumberFormatException e2) {
                C2452v.m7389e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e2.getMessage());
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m7399b(String str, String str2) {
        C2434n0 c2434n0;
        String str3;
        String replace = "{url}/getPublicKey?keytype=4".replace("{url}", AbstractC2396a1.m7024f(str, str2));
        String m7305f = AbstractC2443q0.m7305f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", m7305f);
        try {
            c2434n0 = AbstractC2454w.m7392a(replace, new byte[0], hashMap);
        } catch (Exception e2) {
            C2452v.m7389e("GetPublicKey", "get pubKey response Exception :" + e2.getMessage());
            c2434n0 = null;
        }
        if (c2434n0 == null) {
            str3 = "get pubKey response is null";
        } else if (c2434n0.m7249b() == 200) {
            if (TextUtils.isEmpty(c2434n0.m7248a())) {
                return;
            }
            m7401d(c2434n0.m7248a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + c2434n0.m7249b();
        }
        C2452v.m7389e("GetPublicKey", str3);
    }

    /* renamed from: c */
    public static String m7400c(String str, String str2) {
        String m7317o;
        String m7299c = AbstractC2443q0.m7299c();
        if (TextUtils.isEmpty(m7299c)) {
            m7299c = C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_version", "");
            AbstractC2443q0.m7308g(m7299c);
        }
        if (!"2.0".equals(m7299c)) {
            m7397a(str, str2);
            return null;
        }
        if ("maint".equals(str2)) {
            m7317o = AbstractC2443q0.m7316n();
            if (TextUtils.isEmpty(m7317o)) {
                m7317o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_maint", ""));
                AbstractC2443q0.m7302d(m7317o);
            }
        } else {
            m7317o = AbstractC2443q0.m7317o();
            if (TextUtils.isEmpty(m7317o)) {
                m7317o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_oper", ""));
                AbstractC2443q0.m7304e(m7317o);
            }
        }
        if (!TextUtils.isEmpty(m7317o) && !m7398a()) {
            return m7317o;
        }
        m7397a(str, str2);
        return null;
    }

    /* renamed from: d */
    private static void m7401d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_time_interval", optString4);
            C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_version", optString3);
            C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "public_key_time_last", str3);
            AbstractC2443q0.m7304e(optString);
            AbstractC2443q0.m7302d(optString2);
            AbstractC2443q0.m7308g(optString3);
            AbstractC2443q0.m7300c(str3);
            AbstractC2443q0.m7306f(optString4);
        } catch (JSONException e2) {
            C2452v.m7389e("GetPublicKey", "get pubKey parse json JSONException :" + e2.getMessage());
        }
    }
}
