package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.v0 */
/* loaded from: classes.dex */
public class C2453v0 implements InterfaceRunnableC2412g {

    /* renamed from: a */
    private Context f7639a = AbstractC2443q0.m7311i();

    /* renamed from: b */
    private String f7640b;

    /* renamed from: c */
    private String f7641c;

    /* renamed from: d */
    private String f7642d;

    public C2453v0(String str, String str2, String str3) {
        this.f7640b = str;
        this.f7641c = str2;
        this.f7642d = str3;
    }

    /* renamed from: a */
    private void m7391a(String str, List<C2399b1> list) {
        Pair<String, String> m7251a = AbstractC2435n1.m7251a(str);
        new C2450u(list, (String) m7251a.first, (String) m7251a.second, this.f7642d).m7372a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<C2399b1>> m7062a;
        C2452v.m7385c("hmsSdk", "eventReportTask is running");
        boolean m7057a = C2401c0.m7057a(this.f7639a);
        if (m7057a) {
            C2452v.m7385c("hmsSdk", "workKey is refresh,begin report all data");
            this.f7641c = "alltype";
        }
        try {
            try {
                m7062a = C2402c1.m7062a(this.f7639a, this.f7640b, this.f7641c);
            } catch (IllegalArgumentException e2) {
                C2452v.m7389e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e2.getMessage());
                if ("alltype".equals(this.f7641c)) {
                    C2403d.m7071a(this.f7639a, "stat_v2_1", new String[0]);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", new String[0]);
                } else {
                    String m7253a = AbstractC2435n1.m7253a(this.f7640b, this.f7641c);
                    C2403d.m7071a(this.f7639a, "stat_v2_1", m7253a);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", m7253a);
                }
            } catch (Exception e3) {
                C2452v.m7389e("hmsSdk", "readEventRecords handData Exception:" + e3.getMessage());
                if ("alltype".equals(this.f7641c)) {
                    C2403d.m7071a(this.f7639a, "stat_v2_1", new String[0]);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", new String[0]);
                } else {
                    String m7253a2 = AbstractC2435n1.m7253a(this.f7640b, this.f7641c);
                    C2403d.m7071a(this.f7639a, "stat_v2_1", m7253a2);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", m7253a2);
                }
            }
            if (m7062a.size() == 0) {
                C2452v.m7383b("hmsSdk", "no have events to report: tag:%s : type:%s", this.f7640b, this.f7641c);
                if ("alltype".equals(this.f7641c)) {
                    C2403d.m7071a(this.f7639a, "stat_v2_1", new String[0]);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String m7253a3 = AbstractC2435n1.m7253a(this.f7640b, this.f7641c);
                    C2403d.m7071a(this.f7639a, "stat_v2_1", m7253a3);
                    C2403d.m7071a(this.f7639a, "cached_v2_1", m7253a3);
                    return;
                }
            }
            for (Map.Entry<String, List<C2399b1>> entry : m7062a.entrySet()) {
                m7391a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f7641c)) {
                C2403d.m7071a(this.f7639a, "stat_v2_1", new String[0]);
                C2403d.m7071a(this.f7639a, "cached_v2_1", new String[0]);
            } else {
                String m7253a4 = AbstractC2435n1.m7253a(this.f7640b, this.f7641c);
                C2403d.m7071a(this.f7639a, "stat_v2_1", m7253a4);
                C2403d.m7071a(this.f7639a, "cached_v2_1", m7253a4);
            }
            if (m7057a) {
                C2452v.m7385c("hmsSdk", "refresh local key");
                C2437o0.m7270d().m7275b();
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f7641c)) {
                C2403d.m7071a(this.f7639a, "stat_v2_1", new String[0]);
                C2403d.m7071a(this.f7639a, "cached_v2_1", new String[0]);
            } else {
                String m7253a5 = AbstractC2435n1.m7253a(this.f7640b, this.f7641c);
                C2403d.m7071a(this.f7639a, "stat_v2_1", m7253a5);
                C2403d.m7071a(this.f7639a, "cached_v2_1", m7253a5);
            }
            throw th;
        }
    }
}
