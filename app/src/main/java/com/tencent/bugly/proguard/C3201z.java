package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.z */
/* loaded from: classes2.dex */
public final class C3201z extends AbstractC3188m implements Cloneable {

    /* renamed from: e */
    static Map<String, String> f10848e;

    /* renamed from: f */
    static final /* synthetic */ boolean f10849f = !C3201z.class.desiredAssertionStatus();

    /* renamed from: a */
    public int f10850a;

    /* renamed from: b */
    public String f10851b;

    /* renamed from: c */
    public long f10852c;

    /* renamed from: d */
    public Map<String, String> f10853d;

    public C3201z() {
        this.f10850a = 0;
        this.f10851b = "";
        this.f10852c = 0L;
        this.f10853d = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10102a(this.f10850a, 0);
        String str = this.f10851b;
        if (str != null) {
            c3187l.m10106a(str, 1);
        }
        c3187l.m10103a(this.f10852c, 2);
        Map<String, String> map = this.f10853d;
        if (map != null) {
            c3187l.m10108a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10849f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3201z c3201z = (C3201z) obj;
        return C3189n.m10121a(this.f10850a, c3201z.f10850a) && C3189n.m10123a(this.f10851b, c3201z.f10851b) && C3189n.m10122a(this.f10852c, c3201z.f10852c) && C3189n.m10123a(this.f10853d, c3201z.f10853d);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C3201z(int i2, String str, long j2, Map<String, String> map) {
        this.f10850a = 0;
        this.f10851b = "";
        this.f10852c = 0L;
        this.f10853d = null;
        this.f10850a = i2;
        this.f10851b = str;
        this.f10852c = j2;
        this.f10853d = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10850a = c3186k.m10073a(this.f10850a, 0, false);
        this.f10851b = c3186k.m10078a(1, false);
        this.f10852c = c3186k.m10075a(this.f10852c, 2, false);
        if (f10848e == null) {
            f10848e = new HashMap();
            f10848e.put("", "");
        }
        this.f10853d = (Map) c3186k.m10077a((C3186k) f10848e, 3, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10047a(this.f10850a, AgooConstants.MESSAGE_FLAG);
        c3184i.m10051a(this.f10851b, "localStrategyId");
        c3184i.m10048a(this.f10852c, "localStrategyTime");
        c3184i.m10053a((Map) this.f10853d, "reserved");
    }
}
