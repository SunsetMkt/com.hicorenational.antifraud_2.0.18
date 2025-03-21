package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bf */
/* loaded from: classes2.dex */
public final class C3170bf extends AbstractC3188m {

    /* renamed from: A */
    static ArrayList<C3169be> f10628A;

    /* renamed from: B */
    static Map<String, String> f10629B;

    /* renamed from: C */
    static Map<String, String> f10630C;

    /* renamed from: v */
    static Map<String, String> f10631v = new HashMap();

    /* renamed from: w */
    static C3168bd f10632w;

    /* renamed from: x */
    static C3167bc f10633x;

    /* renamed from: y */
    static ArrayList<C3167bc> f10634y;

    /* renamed from: z */
    static ArrayList<C3167bc> f10635z;

    /* renamed from: a */
    public String f10636a = "";

    /* renamed from: b */
    public long f10637b = 0;

    /* renamed from: c */
    public String f10638c = "";

    /* renamed from: d */
    public String f10639d = "";

    /* renamed from: e */
    public String f10640e = "";

    /* renamed from: f */
    public String f10641f = "";

    /* renamed from: g */
    public String f10642g = "";

    /* renamed from: h */
    public Map<String, String> f10643h = null;

    /* renamed from: i */
    public String f10644i = "";

    /* renamed from: j */
    public C3168bd f10645j = null;

    /* renamed from: k */
    public int f10646k = 0;

    /* renamed from: l */
    public String f10647l = "";

    /* renamed from: m */
    public String f10648m = "";

    /* renamed from: n */
    public C3167bc f10649n = null;

    /* renamed from: o */
    public ArrayList<C3167bc> f10650o = null;

    /* renamed from: p */
    public ArrayList<C3167bc> f10651p = null;

    /* renamed from: q */
    public ArrayList<C3169be> f10652q = null;

    /* renamed from: r */
    public Map<String, String> f10653r = null;

    /* renamed from: s */
    public Map<String, String> f10654s = null;

    /* renamed from: t */
    public String f10655t = "";

    /* renamed from: u */
    public boolean f10656u = true;

    static {
        f10631v.put("", "");
        f10632w = new C3168bd();
        f10633x = new C3167bc();
        f10634y = new ArrayList<>();
        f10634y.add(new C3167bc());
        f10635z = new ArrayList<>();
        f10635z.add(new C3167bc());
        f10628A = new ArrayList<>();
        f10628A.add(new C3169be());
        f10629B = new HashMap();
        f10629B.put("", "");
        f10630C = new HashMap();
        f10630C.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10636a, 0);
        c3187l.m10103a(this.f10637b, 1);
        c3187l.m10106a(this.f10638c, 2);
        String str = this.f10639d;
        if (str != null) {
            c3187l.m10106a(str, 3);
        }
        String str2 = this.f10640e;
        if (str2 != null) {
            c3187l.m10106a(str2, 4);
        }
        String str3 = this.f10641f;
        if (str3 != null) {
            c3187l.m10106a(str3, 5);
        }
        String str4 = this.f10642g;
        if (str4 != null) {
            c3187l.m10106a(str4, 6);
        }
        Map<String, String> map = this.f10643h;
        if (map != null) {
            c3187l.m10108a((Map) map, 7);
        }
        String str5 = this.f10644i;
        if (str5 != null) {
            c3187l.m10106a(str5, 8);
        }
        C3168bd c3168bd = this.f10645j;
        if (c3168bd != null) {
            c3187l.m10104a((AbstractC3188m) c3168bd, 9);
        }
        c3187l.m10102a(this.f10646k, 10);
        String str6 = this.f10647l;
        if (str6 != null) {
            c3187l.m10106a(str6, 11);
        }
        String str7 = this.f10648m;
        if (str7 != null) {
            c3187l.m10106a(str7, 12);
        }
        C3167bc c3167bc = this.f10649n;
        if (c3167bc != null) {
            c3187l.m10104a((AbstractC3188m) c3167bc, 13);
        }
        ArrayList<C3167bc> arrayList = this.f10650o;
        if (arrayList != null) {
            c3187l.m10107a((Collection) arrayList, 14);
        }
        ArrayList<C3167bc> arrayList2 = this.f10651p;
        if (arrayList2 != null) {
            c3187l.m10107a((Collection) arrayList2, 15);
        }
        ArrayList<C3169be> arrayList3 = this.f10652q;
        if (arrayList3 != null) {
            c3187l.m10107a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f10653r;
        if (map2 != null) {
            c3187l.m10108a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f10654s;
        if (map3 != null) {
            c3187l.m10108a((Map) map3, 18);
        }
        String str8 = this.f10655t;
        if (str8 != null) {
            c3187l.m10106a(str8, 19);
        }
        c3187l.m10110a(this.f10656u, 20);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10636a = c3186k.m10078a(0, true);
        this.f10637b = c3186k.m10075a(this.f10637b, 1, true);
        this.f10638c = c3186k.m10078a(2, true);
        this.f10639d = c3186k.m10078a(3, false);
        this.f10640e = c3186k.m10078a(4, false);
        this.f10641f = c3186k.m10078a(5, false);
        this.f10642g = c3186k.m10078a(6, false);
        this.f10643h = (Map) c3186k.m10077a((C3186k) f10631v, 7, false);
        this.f10644i = c3186k.m10078a(8, false);
        this.f10645j = (C3168bd) c3186k.m10076a((AbstractC3188m) f10632w, 9, false);
        this.f10646k = c3186k.m10073a(this.f10646k, 10, false);
        this.f10647l = c3186k.m10078a(11, false);
        this.f10648m = c3186k.m10078a(12, false);
        this.f10649n = (C3167bc) c3186k.m10076a((AbstractC3188m) f10633x, 13, false);
        this.f10650o = (ArrayList) c3186k.m10077a((C3186k) f10634y, 14, false);
        this.f10651p = (ArrayList) c3186k.m10077a((C3186k) f10635z, 15, false);
        this.f10652q = (ArrayList) c3186k.m10077a((C3186k) f10628A, 16, false);
        this.f10653r = (Map) c3186k.m10077a((C3186k) f10629B, 17, false);
        this.f10654s = (Map) c3186k.m10077a((C3186k) f10630C, 18, false);
        this.f10655t = c3186k.m10078a(19, false);
        this.f10656u = c3186k.m10086a(this.f10656u, 20, false);
    }
}
