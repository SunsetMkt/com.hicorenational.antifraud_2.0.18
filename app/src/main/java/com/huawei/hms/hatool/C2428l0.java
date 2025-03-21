package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l0 */
/* loaded from: classes.dex */
public class C2428l0 {

    /* renamed from: a */
    private String f7565a;

    /* renamed from: b */
    private String f7566b;

    /* renamed from: c */
    private String f7567c;

    /* renamed from: d */
    private List<C2399b1> f7568d;

    /* renamed from: e */
    private String f7569e;

    public C2428l0(String str, String str2, String str3, List<C2399b1> list, String str4) {
        this.f7565a = str;
        this.f7566b = str2;
        this.f7567c = str3;
        this.f7568d = list;
        this.f7569e = str4;
    }

    /* renamed from: a */
    private String m7213a(String str, String str2) {
        String str3;
        String m7024f = AbstractC2396a1.m7024f(str, str2);
        if (TextUtils.isEmpty(m7024f)) {
            C2452v.m7380a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", m7024f);
    }

    /* renamed from: a */
    private byte[] m7214a(C2417h1 c2417h1) {
        String str;
        try {
            JSONObject mo7044a = c2417h1.mo7044a();
            if (mo7044a != null) {
                return C2426k1.m7206a(mo7044a.toString().getBytes("UTF-8"));
            }
            C2452v.m7389e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            C2452v.m7389e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            C2452v.m7389e("hmsSdk", str);
            return new byte[0];
        }
    }

    /* renamed from: b */
    private void m7215b() {
        if (C2401c0.m7059a(AbstractC2443q0.m7311i(), "backup_event", 5242880)) {
            C2452v.m7387d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray m7216c = m7216c();
        String m7254a = AbstractC2435n1.m7254a(this.f7565a, this.f7566b, this.f7569e);
        C2452v.m7385c("hmsSdk", "Update data cached into backup,spKey: " + m7254a);
        C2403d.m7074b(AbstractC2443q0.m7311i(), "backup_event", m7254a, m7216c.toString());
    }

    /* renamed from: c */
    private JSONArray m7216c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<C2399b1> it = this.f7568d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m7051d());
            } catch (JSONException unused) {
                C2452v.m7385c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    private C2417h1 m7217d() {
        return C2424k.m7190a(this.f7568d, this.f7565a, this.f7566b, this.f7569e, this.f7567c);
    }

    /* renamed from: a */
    public void m7218a() {
        InterfaceRunnableC2412g c2405d1;
        C2398b0 m7042c;
        String str;
        String m7213a = m7213a(this.f7565a, this.f7566b);
        if (!TextUtils.isEmpty(m7213a) || "preins".equals(this.f7566b)) {
            if (!"_hms_config_tag".equals(this.f7565a) && !"_openness_config_tag".equals(this.f7565a)) {
                m7215b();
            }
            C2417h1 m7217d = m7217d();
            if (m7217d != null) {
                byte[] m7214a = m7214a(m7217d);
                if (m7214a.length == 0) {
                    str = "request body is empty";
                } else {
                    c2405d1 = new C2409f(m7214a, m7213a, this.f7565a, this.f7566b, this.f7569e, this.f7568d);
                    m7042c = C2398b0.m7041b();
                }
            } else {
                c2405d1 = new C2405d1(this.f7568d, this.f7565a, this.f7569e, this.f7566b);
                m7042c = C2398b0.m7042c();
            }
            m7042c.m7043a(c2405d1);
            return;
        }
        str = "collectUrl is empty";
        C2452v.m7389e("hmsSdk", str);
    }
}
