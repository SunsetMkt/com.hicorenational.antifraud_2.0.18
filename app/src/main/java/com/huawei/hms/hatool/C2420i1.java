package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.i1 */
/* loaded from: classes.dex */
public class C2420i1 {

    /* renamed from: a */
    private String f7533a;

    /* renamed from: b */
    private String f7534b;

    /* renamed from: c */
    private String f7535c;

    /* renamed from: d */
    private String f7536d;

    /* renamed from: e */
    private long f7537e;

    public C2420i1(String str, String str2, String str3, String str4, long j2) {
        this.f7533a = str;
        this.f7534b = str2;
        this.f7535c = str3;
        this.f7536d = str4;
        this.f7537e = j2;
    }

    /* renamed from: a */
    public void m7168a() {
        C2452v.m7385c("StreamEventHandler", "Begin to handle stream events...");
        C2399b1 c2399b1 = new C2399b1();
        c2399b1.m7048b(this.f7535c);
        c2399b1.m7052d(this.f7534b);
        c2399b1.m7045a(this.f7536d);
        c2399b1.m7050c(String.valueOf(this.f7537e));
        if ("oper".equals(this.f7534b) && AbstractC2460z.m7429i(this.f7533a, "oper")) {
            C2440p0 m7417a = C2458y.m7415a().m7417a(this.f7533a, this.f7537e);
            String m7280a = m7417a.m7280a();
            Boolean valueOf = Boolean.valueOf(m7417a.m7282b());
            c2399b1.m7054f(m7280a);
            c2399b1.m7053e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c2399b1);
        new C2428l0(this.f7533a, this.f7534b, AbstractC2443q0.m7307g(), arrayList, replace).m7218a();
    }
}
