package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: classes2.dex */
public final class C3198w extends AbstractC3188m implements Cloneable {

    /* renamed from: i */
    static C3197v f10813i;

    /* renamed from: j */
    static Map<String, String> f10814j;

    /* renamed from: k */
    static final /* synthetic */ boolean f10815k = !C3198w.class.desiredAssertionStatus();

    /* renamed from: a */
    public String f10816a;

    /* renamed from: b */
    public long f10817b;

    /* renamed from: c */
    public byte f10818c;

    /* renamed from: d */
    public long f10819d;

    /* renamed from: e */
    public C3197v f10820e;

    /* renamed from: f */
    public String f10821f;

    /* renamed from: g */
    public int f10822g;

    /* renamed from: h */
    public Map<String, String> f10823h;

    public C3198w() {
        this.f10816a = "";
        this.f10817b = 0L;
        this.f10818c = (byte) 0;
        this.f10819d = 0L;
        this.f10820e = null;
        this.f10821f = "";
        this.f10822g = 0;
        this.f10823h = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10816a, 0);
        c3187l.m10103a(this.f10817b, 1);
        c3187l.m10118b(this.f10818c, 2);
        c3187l.m10103a(this.f10819d, 3);
        C3197v c3197v = this.f10820e;
        if (c3197v != null) {
            c3187l.m10104a((AbstractC3188m) c3197v, 4);
        }
        String str = this.f10821f;
        if (str != null) {
            c3187l.m10106a(str, 5);
        }
        c3187l.m10102a(this.f10822g, 6);
        Map<String, String> map = this.f10823h;
        if (map != null) {
            c3187l.m10108a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10815k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3198w c3198w = (C3198w) obj;
        return C3189n.m10123a(this.f10816a, c3198w.f10816a) && C3189n.m10122a(this.f10817b, c3198w.f10817b) && C3189n.m10120a(this.f10818c, c3198w.f10818c) && C3189n.m10122a(this.f10819d, c3198w.f10819d) && C3189n.m10123a(this.f10820e, c3198w.f10820e) && C3189n.m10123a(this.f10821f, c3198w.f10821f) && C3189n.m10121a(this.f10822g, c3198w.f10822g) && C3189n.m10123a(this.f10823h, c3198w.f10823h);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C3198w(String str, long j2, byte b2, long j3, C3197v c3197v, String str2, int i2, Map<String, String> map) {
        this.f10816a = "";
        this.f10817b = 0L;
        this.f10818c = (byte) 0;
        this.f10819d = 0L;
        this.f10820e = null;
        this.f10821f = "";
        this.f10822g = 0;
        this.f10823h = null;
        this.f10816a = str;
        this.f10817b = j2;
        this.f10818c = b2;
        this.f10819d = j3;
        this.f10820e = c3197v;
        this.f10821f = str2;
        this.f10822g = i2;
        this.f10823h = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10816a = c3186k.m10078a(0, true);
        this.f10817b = c3186k.m10075a(this.f10817b, 1, true);
        this.f10818c = c3186k.m10070a(this.f10818c, 2, true);
        this.f10819d = c3186k.m10075a(this.f10819d, 3, false);
        if (f10813i == null) {
            f10813i = new C3197v();
        }
        this.f10820e = (C3197v) c3186k.m10076a((AbstractC3188m) f10813i, 4, false);
        this.f10821f = c3186k.m10078a(5, false);
        this.f10822g = c3186k.m10073a(this.f10822g, 6, false);
        if (f10814j == null) {
            f10814j = new HashMap();
            f10814j.put("", "");
        }
        this.f10823h = (Map) c3186k.m10077a((C3186k) f10814j, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10051a(this.f10816a, "eventType");
        c3184i.m10048a(this.f10817b, "eventTime");
        c3184i.m10043a(this.f10818c, "eventResult");
        c3184i.m10048a(this.f10819d, "eventElapse");
        c3184i.m10049a((AbstractC3188m) this.f10820e, "destAppInfo");
        c3184i.m10051a(this.f10821f, "strategyId");
        c3184i.m10047a(this.f10822g, "updateType");
        c3184i.m10053a((Map) this.f10823h, "reserved");
    }
}
