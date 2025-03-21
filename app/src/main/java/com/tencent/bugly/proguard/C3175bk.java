package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bk */
/* loaded from: classes2.dex */
public final class C3175bk extends AbstractC3188m implements Cloneable {

    /* renamed from: a */
    public boolean f10700a = true;

    /* renamed from: b */
    public boolean f10701b = true;

    /* renamed from: c */
    public boolean f10702c = true;

    /* renamed from: d */
    public String f10703d = "";

    /* renamed from: e */
    public String f10704e = "";

    /* renamed from: f */
    public C3174bj f10705f = null;

    /* renamed from: g */
    public Map<String, String> f10706g = null;

    /* renamed from: h */
    public long f10707h = 0;

    /* renamed from: i */
    public String f10708i = "";

    /* renamed from: j */
    public String f10709j = "";

    /* renamed from: k */
    public int f10710k = 0;

    /* renamed from: l */
    public int f10711l = 0;

    /* renamed from: o */
    static final /* synthetic */ boolean f10699o = !C3175bk.class.desiredAssertionStatus();

    /* renamed from: m */
    static C3174bj f10697m = new C3174bj();

    /* renamed from: n */
    static Map<String, String> f10698n = new HashMap();

    static {
        f10698n.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10110a(this.f10700a, 0);
        c3187l.m10110a(this.f10701b, 1);
        c3187l.m10110a(this.f10702c, 2);
        String str = this.f10703d;
        if (str != null) {
            c3187l.m10106a(str, 3);
        }
        String str2 = this.f10704e;
        if (str2 != null) {
            c3187l.m10106a(str2, 4);
        }
        C3174bj c3174bj = this.f10705f;
        if (c3174bj != null) {
            c3187l.m10104a((AbstractC3188m) c3174bj, 5);
        }
        Map<String, String> map = this.f10706g;
        if (map != null) {
            c3187l.m10108a((Map) map, 6);
        }
        c3187l.m10103a(this.f10707h, 7);
        String str3 = this.f10708i;
        if (str3 != null) {
            c3187l.m10106a(str3, 8);
        }
        String str4 = this.f10709j;
        if (str4 != null) {
            c3187l.m10106a(str4, 9);
        }
        c3187l.m10102a(this.f10710k, 10);
        c3187l.m10102a(this.f10711l, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10699o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3175bk c3175bk = (C3175bk) obj;
        return C3189n.m10124a(this.f10700a, c3175bk.f10700a) && C3189n.m10124a(this.f10701b, c3175bk.f10701b) && C3189n.m10124a(this.f10702c, c3175bk.f10702c) && C3189n.m10123a(this.f10703d, c3175bk.f10703d) && C3189n.m10123a(this.f10704e, c3175bk.f10704e) && C3189n.m10123a(this.f10705f, c3175bk.f10705f) && C3189n.m10123a(this.f10706g, c3175bk.f10706g) && C3189n.m10122a(this.f10707h, c3175bk.f10707h) && C3189n.m10123a(this.f10708i, c3175bk.f10708i) && C3189n.m10123a(this.f10709j, c3175bk.f10709j) && C3189n.m10121a(this.f10710k, c3175bk.f10710k) && C3189n.m10121a(this.f10711l, c3175bk.f10711l);
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
    public void mo9793a(C3186k c3186k) {
        this.f10700a = c3186k.m10086a(this.f10700a, 0, true);
        this.f10701b = c3186k.m10086a(this.f10701b, 1, true);
        this.f10702c = c3186k.m10086a(this.f10702c, 2, true);
        this.f10703d = c3186k.m10078a(3, false);
        this.f10704e = c3186k.m10078a(4, false);
        this.f10705f = (C3174bj) c3186k.m10076a((AbstractC3188m) f10697m, 5, false);
        this.f10706g = (Map) c3186k.m10077a((C3186k) f10698n, 6, false);
        this.f10707h = c3186k.m10075a(this.f10707h, 7, false);
        this.f10708i = c3186k.m10078a(8, false);
        this.f10709j = c3186k.m10078a(9, false);
        this.f10710k = c3186k.m10073a(this.f10710k, 10, false);
        this.f10711l = c3186k.m10073a(this.f10711l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10055a(this.f10700a, "enable");
        c3184i.m10055a(this.f10701b, "enableUserInfo");
        c3184i.m10055a(this.f10702c, "enableQuery");
        c3184i.m10051a(this.f10703d, "url");
        c3184i.m10051a(this.f10704e, "expUrl");
        c3184i.m10049a((AbstractC3188m) this.f10705f, "security");
        c3184i.m10053a((Map) this.f10706g, "valueMap");
        c3184i.m10048a(this.f10707h, "strategylastUpdateTime");
        c3184i.m10051a(this.f10708i, "httpsUrl");
        c3184i.m10051a(this.f10709j, "httpsExpUrl");
        c3184i.m10047a(this.f10710k, "eventRecordCount");
        c3184i.m10047a(this.f10711l, "eventTimeInterval");
    }
}
