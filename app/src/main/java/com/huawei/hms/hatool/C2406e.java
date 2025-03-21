package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.e */
/* loaded from: classes.dex */
public class C2406e {

    /* renamed from: b */
    private static C2406e f7493b;

    /* renamed from: c */
    private static Map<String, Long> f7494c = new HashMap();

    /* renamed from: a */
    private Context f7495a;

    /* renamed from: a */
    public static C2406e m7077a() {
        return m7078b();
    }

    /* renamed from: b */
    private static synchronized C2406e m7078b() {
        C2406e c2406e;
        synchronized (C2406e.class) {
            if (f7493b == null) {
                f7493b = new C2406e();
            }
            c2406e = f7493b;
        }
        return c2406e;
    }

    /* renamed from: b */
    private void m7079b(Context context) {
        String str;
        String m7265d = AbstractC2436o.m7265d(context);
        AbstractC2443q0.m7296a(m7265d);
        if (C2444q1.m7318b().m7319a()) {
            String m7069a = C2403d.m7069a(context, "global_v2", Constants.PARAM_APP_VER, "");
            C2403d.m7074b(context, "global_v2", Constants.PARAM_APP_VER, m7265d);
            AbstractC2443q0.m7298b(m7069a);
            if (!TextUtils.isEmpty(m7069a)) {
                if (m7069a.equals(m7265d)) {
                    return;
                }
                C2452v.m7385c("hmsSdk", "the appVers are different!");
                m7077a().m7085a("", "alltype", m7069a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        C2452v.m7385c("hmsSdk", str);
    }

    /* renamed from: a */
    public void m7080a(Context context) {
        this.f7495a = context;
        m7079b(context);
        C2446s.m7326c().m7331b().m7131h(AbstractC2436o.m7258a());
    }

    /* renamed from: a */
    public void m7081a(String str, int i2) {
        if (this.f7495a == null) {
            C2452v.m7389e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            C2452v.m7385c("hmsSdk", "onReport: Before calling runtaskhandler()");
            m7085a(str, AbstractC2435n1.m7252a(i2), AbstractC2443q0.m7307g());
        }
    }

    /* renamed from: a */
    public void m7082a(String str, int i2, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i2) {
            currentTimeMillis = AbstractC2435n1.m7250a("yyyy-MM-dd", currentTimeMillis);
        }
        C2398b0.m7042c().m7043a(new C2395a0(str2, jSONObject, str, AbstractC2435n1.m7252a(i2), currentTimeMillis));
    }

    /* renamed from: a */
    public void m7083a(String str, int i2, String str2, JSONObject jSONObject, long j2) {
        new C2420i1(str, AbstractC2435n1.m7252a(i2), str2, jSONObject.toString(), j2).m7168a();
    }

    /* renamed from: a */
    public void m7084a(String str, String str2) {
        if (!AbstractC2396a1.m7019a(str, str2)) {
            C2452v.m7385c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long m7028j = AbstractC2396a1.m7028j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m7028j <= 30000) {
            C2452v.m7390f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        C2452v.m7379a("hmsSdk", "begin to call onReport!");
        AbstractC2396a1.m7018a(str, str2, currentTimeMillis);
        m7085a(str, str2, AbstractC2443q0.m7307g());
    }

    /* renamed from: a */
    public void m7085a(String str, String str2, String str3) {
        Context context = this.f7495a;
        if (context == null) {
            C2452v.m7389e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String m7323b = C2445r0.m7323b(context);
        if (AbstractC2396a1.m7023e(str, str2) && !"WIFI".equals(m7323b)) {
            C2452v.m7385c("hmsSdk", "strNetworkType is :" + m7323b);
            return;
        }
        if ("unknown".equals(m7323b) || "none".equals(m7323b) || "2G".equals(m7323b)) {
            C2452v.m7389e("hmsSdk", "The network is bad.");
        } else {
            C2398b0.m7042c().m7043a(new C2453v0(str, str2, str3));
        }
    }
}
