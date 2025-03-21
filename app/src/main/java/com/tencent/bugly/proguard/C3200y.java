package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes2.dex */
public final class C3200y extends AbstractC3188m implements Cloneable {

    /* renamed from: q */
    static C3197v f10827q;

    /* renamed from: r */
    static C3196u f10828r;

    /* renamed from: s */
    static C3196u f10829s;

    /* renamed from: t */
    static Map<String, String> f10830t;

    /* renamed from: u */
    static final /* synthetic */ boolean f10831u = !C3200y.class.desiredAssertionStatus();

    /* renamed from: a */
    public String f10832a;

    /* renamed from: b */
    public String f10833b;

    /* renamed from: c */
    public long f10834c;

    /* renamed from: d */
    public int f10835d;

    /* renamed from: e */
    public C3197v f10836e;

    /* renamed from: f */
    public C3196u f10837f;

    /* renamed from: g */
    public byte f10838g;

    /* renamed from: h */
    public int f10839h;

    /* renamed from: i */
    public long f10840i;

    /* renamed from: j */
    public C3196u f10841j;

    /* renamed from: k */
    public String f10842k;

    /* renamed from: l */
    public Map<String, String> f10843l;

    /* renamed from: m */
    public String f10844m;

    /* renamed from: n */
    public int f10845n;

    /* renamed from: o */
    public long f10846o;

    /* renamed from: p */
    public int f10847p;

    public C3200y() {
        this.f10832a = "";
        this.f10833b = "";
        this.f10834c = 0L;
        this.f10835d = 0;
        this.f10836e = null;
        this.f10837f = null;
        this.f10838g = (byte) 0;
        this.f10839h = 0;
        this.f10840i = 0L;
        this.f10841j = null;
        this.f10842k = "";
        this.f10843l = null;
        this.f10844m = "";
        this.f10845n = 0;
        this.f10846o = 0L;
        this.f10847p = 0;
    }

    /* renamed from: a */
    public long m10150a() {
        return this.f10834c;
    }

    /* renamed from: b */
    public C3196u m10151b() {
        return this.f10837f;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10831u) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3200y c3200y = (C3200y) obj;
        return C3189n.m10123a(this.f10832a, c3200y.f10832a) && C3189n.m10123a(this.f10833b, c3200y.f10833b) && C3189n.m10122a(this.f10834c, c3200y.f10834c) && C3189n.m10121a(this.f10835d, c3200y.f10835d) && C3189n.m10123a(this.f10836e, c3200y.f10836e) && C3189n.m10123a(this.f10837f, c3200y.f10837f) && C3189n.m10120a(this.f10838g, c3200y.f10838g) && C3189n.m10121a(this.f10839h, c3200y.f10839h) && C3189n.m10122a(this.f10840i, c3200y.f10840i) && C3189n.m10123a(this.f10841j, c3200y.f10841j) && C3189n.m10123a(this.f10842k, c3200y.f10842k) && C3189n.m10123a(this.f10843l, c3200y.f10843l) && C3189n.m10123a(this.f10844m, c3200y.f10844m) && C3189n.m10121a(this.f10845n, c3200y.f10845n) && C3189n.m10122a(this.f10846o, c3200y.f10846o) && C3189n.m10121a(this.f10847p, c3200y.f10847p);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10832a, 0);
        c3187l.m10106a(this.f10833b, 1);
        c3187l.m10103a(this.f10834c, 2);
        c3187l.m10102a(this.f10835d, 3);
        c3187l.m10104a((AbstractC3188m) this.f10836e, 4);
        c3187l.m10104a((AbstractC3188m) this.f10837f, 5);
        c3187l.m10118b(this.f10838g, 6);
        c3187l.m10102a(this.f10839h, 7);
        c3187l.m10103a(this.f10840i, 8);
        C3196u c3196u = this.f10841j;
        if (c3196u != null) {
            c3187l.m10104a((AbstractC3188m) c3196u, 9);
        }
        String str = this.f10842k;
        if (str != null) {
            c3187l.m10106a(str, 10);
        }
        Map<String, String> map = this.f10843l;
        if (map != null) {
            c3187l.m10108a((Map) map, 11);
        }
        String str2 = this.f10844m;
        if (str2 != null) {
            c3187l.m10106a(str2, 12);
        }
        c3187l.m10102a(this.f10845n, 13);
        c3187l.m10103a(this.f10846o, 14);
        c3187l.m10102a(this.f10847p, 15);
    }

    public C3200y(String str, String str2, long j2, int i2, C3197v c3197v, C3196u c3196u, byte b2, int i3, long j3, C3196u c3196u2, String str3, Map<String, String> map, String str4, int i4, long j4, int i5) {
        this.f10832a = "";
        this.f10833b = "";
        this.f10834c = 0L;
        this.f10835d = 0;
        this.f10836e = null;
        this.f10837f = null;
        this.f10838g = (byte) 0;
        this.f10839h = 0;
        this.f10840i = 0L;
        this.f10841j = null;
        this.f10842k = "";
        this.f10843l = null;
        this.f10844m = "";
        this.f10845n = 0;
        this.f10846o = 0L;
        this.f10847p = 0;
        this.f10832a = str;
        this.f10833b = str2;
        this.f10834c = j2;
        this.f10835d = i2;
        this.f10836e = c3197v;
        this.f10837f = c3196u;
        this.f10838g = b2;
        this.f10839h = i3;
        this.f10840i = j3;
        this.f10841j = c3196u2;
        this.f10842k = str3;
        this.f10843l = map;
        this.f10844m = str4;
        this.f10845n = i4;
        this.f10846o = j4;
        this.f10847p = i5;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10832a = c3186k.m10078a(0, true);
        this.f10833b = c3186k.m10078a(1, true);
        this.f10834c = c3186k.m10075a(this.f10834c, 2, true);
        this.f10835d = c3186k.m10073a(this.f10835d, 3, true);
        if (f10827q == null) {
            f10827q = new C3197v();
        }
        this.f10836e = (C3197v) c3186k.m10076a((AbstractC3188m) f10827q, 4, true);
        if (f10828r == null) {
            f10828r = new C3196u();
        }
        this.f10837f = (C3196u) c3186k.m10076a((AbstractC3188m) f10828r, 5, true);
        this.f10838g = c3186k.m10070a(this.f10838g, 6, true);
        this.f10839h = c3186k.m10073a(this.f10839h, 7, false);
        this.f10840i = c3186k.m10075a(this.f10840i, 8, false);
        if (f10829s == null) {
            f10829s = new C3196u();
        }
        this.f10841j = (C3196u) c3186k.m10076a((AbstractC3188m) f10829s, 9, false);
        this.f10842k = c3186k.m10078a(10, false);
        if (f10830t == null) {
            f10830t = new HashMap();
            f10830t.put("", "");
        }
        this.f10843l = (Map) c3186k.m10077a((C3186k) f10830t, 11, false);
        this.f10844m = c3186k.m10078a(12, false);
        this.f10845n = c3186k.m10073a(this.f10845n, 13, false);
        this.f10846o = c3186k.m10075a(this.f10846o, 14, false);
        this.f10847p = c3186k.m10073a(this.f10847p, 15, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10051a(this.f10832a, "title");
        c3184i.m10051a(this.f10833b, "newFeature");
        c3184i.m10048a(this.f10834c, "publishTime");
        c3184i.m10047a(this.f10835d, "publishType");
        c3184i.m10049a((AbstractC3188m) this.f10836e, "appBasicInfo");
        c3184i.m10049a((AbstractC3188m) this.f10837f, "apkBaseInfo");
        c3184i.m10043a(this.f10838g, "updateStrategy");
        c3184i.m10047a(this.f10839h, "popTimes");
        c3184i.m10048a(this.f10840i, "popInterval");
        c3184i.m10049a((AbstractC3188m) this.f10841j, "diffApkInfo");
        c3184i.m10051a(this.f10842k, "netType");
        c3184i.m10053a((Map) this.f10843l, "reserved");
        c3184i.m10051a(this.f10844m, "strategyId");
        c3184i.m10047a(this.f10845n, NotificationCompat.CATEGORY_STATUS);
        c3184i.m10048a(this.f10846o, "updateTime");
        c3184i.m10047a(this.f10847p, "updateType");
    }
}
