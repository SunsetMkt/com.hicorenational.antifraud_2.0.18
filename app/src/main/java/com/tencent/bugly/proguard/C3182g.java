package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.C3397d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.g */
/* loaded from: classes2.dex */
public final class C3182g extends AbstractC3188m {

    /* renamed from: g */
    public byte[] f10751g;

    /* renamed from: i */
    public Map<String, String> f10753i;

    /* renamed from: j */
    public Map<String, String> f10754j;

    /* renamed from: m */
    static final /* synthetic */ boolean f10744m = !C3182g.class.desiredAssertionStatus();

    /* renamed from: k */
    static byte[] f10742k = null;

    /* renamed from: l */
    static Map<String, String> f10743l = null;

    /* renamed from: a */
    public short f10745a = 0;

    /* renamed from: b */
    public byte f10746b = 0;

    /* renamed from: c */
    public int f10747c = 0;

    /* renamed from: d */
    public int f10748d = 0;

    /* renamed from: e */
    public String f10749e = null;

    /* renamed from: f */
    public String f10750f = null;

    /* renamed from: h */
    public int f10752h = 0;

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10109a(this.f10745a, 1);
        c3187l.m10118b(this.f10746b, 2);
        c3187l.m10102a(this.f10747c, 3);
        c3187l.m10102a(this.f10748d, 4);
        c3187l.m10106a(this.f10749e, 5);
        c3187l.m10106a(this.f10750f, 6);
        c3187l.m10111a(this.f10751g, 7);
        c3187l.m10102a(this.f10752h, 8);
        c3187l.m10108a((Map) this.f10753i, 9);
        c3187l.m10108a((Map) this.f10754j, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10744m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        C3182g c3182g = (C3182g) obj;
        return C3189n.m10121a(1, (int) c3182g.f10745a) && C3189n.m10121a(1, (int) c3182g.f10746b) && C3189n.m10121a(1, c3182g.f10747c) && C3189n.m10121a(1, c3182g.f10748d) && C3189n.m10123a((Object) 1, (Object) c3182g.f10749e) && C3189n.m10123a((Object) 1, (Object) c3182g.f10750f) && C3189n.m10123a((Object) 1, (Object) c3182g.f10751g) && C3189n.m10121a(1, c3182g.f10752h) && C3189n.m10123a((Object) 1, (Object) c3182g.f10753i) && C3189n.m10123a((Object) 1, (Object) c3182g.f10754j);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        try {
            this.f10745a = c3186k.m10081a(this.f10745a, 1, true);
            this.f10746b = c3186k.m10070a(this.f10746b, 2, true);
            this.f10747c = c3186k.m10073a(this.f10747c, 3, true);
            this.f10748d = c3186k.m10073a(this.f10748d, 4, true);
            this.f10749e = c3186k.m10078a(5, true);
            this.f10750f = c3186k.m10078a(6, true);
            if (f10742k == null) {
                f10742k = new byte[]{0};
            }
            this.f10751g = c3186k.m10087a(f10742k, 7, true);
            this.f10752h = c3186k.m10073a(this.f10752h, 8, true);
            if (f10743l == null) {
                f10743l = new HashMap();
                f10743l.put("", "");
            }
            this.f10753i = (Map) c3186k.m10077a((C3186k) f10743l, 9, true);
            if (f10743l == null) {
                f10743l = new HashMap();
                f10743l.put("", "");
            }
            this.f10754j = (Map) c3186k.m10077a((C3186k) f10743l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + C3181f.m10041a(this.f10751g));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10054a(this.f10745a, "iVersion");
        c3184i.m10043a(this.f10746b, "cPacketType");
        c3184i.m10047a(this.f10747c, "iMessageType");
        c3184i.m10047a(this.f10748d, "iRequestId");
        c3184i.m10051a(this.f10749e, "sServantName");
        c3184i.m10051a(this.f10750f, "sFuncName");
        c3184i.m10056a(this.f10751g, "sBuffer");
        c3184i.m10047a(this.f10752h, "iTimeout");
        c3184i.m10053a((Map) this.f10753i, C3397d.f11892R);
        c3184i.m10053a((Map) this.f10754j, NotificationCompat.CATEGORY_STATUS);
    }
}
