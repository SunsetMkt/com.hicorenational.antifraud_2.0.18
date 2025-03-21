package p031c.p035b.p043c.p070y.p071a;

import java.util.Map;

/* compiled from: ExpandedProductParsedResult.java */
/* renamed from: c.b.c.y.a.k */
/* loaded from: classes.dex */
public final class C1145k extends AbstractC1152q {

    /* renamed from: q */
    public static final String f2347q = "KG";

    /* renamed from: r */
    public static final String f2348r = "LB";

    /* renamed from: b */
    private final String f2349b;

    /* renamed from: c */
    private final String f2350c;

    /* renamed from: d */
    private final String f2351d;

    /* renamed from: e */
    private final String f2352e;

    /* renamed from: f */
    private final String f2353f;

    /* renamed from: g */
    private final String f2354g;

    /* renamed from: h */
    private final String f2355h;

    /* renamed from: i */
    private final String f2356i;

    /* renamed from: j */
    private final String f2357j;

    /* renamed from: k */
    private final String f2358k;

    /* renamed from: l */
    private final String f2359l;

    /* renamed from: m */
    private final String f2360m;

    /* renamed from: n */
    private final String f2361n;

    /* renamed from: o */
    private final String f2362o;

    /* renamed from: p */
    private final Map<String, String> f2363p;

    public C1145k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(EnumC1153r.PRODUCT);
        this.f2349b = str;
        this.f2350c = str2;
        this.f2351d = str3;
        this.f2352e = str4;
        this.f2353f = str5;
        this.f2354g = str6;
        this.f2355h = str7;
        this.f2356i = str8;
        this.f2357j = str9;
        this.f2358k = str10;
        this.f2359l = str11;
        this.f2360m = str12;
        this.f2361n = str13;
        this.f2362o = str14;
        this.f2363p = map;
    }

    /* renamed from: a */
    private static boolean m2091a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: c */
    public String m2092c() {
        return this.f2355h;
    }

    /* renamed from: d */
    public String m2093d() {
        return this.f2356i;
    }

    /* renamed from: e */
    public String m2094e() {
        return this.f2352e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1145k)) {
            return false;
        }
        C1145k c1145k = (C1145k) obj;
        return m2091a(this.f2350c, c1145k.f2350c) && m2091a(this.f2351d, c1145k.f2351d) && m2091a(this.f2352e, c1145k.f2352e) && m2091a(this.f2353f, c1145k.f2353f) && m2091a(this.f2355h, c1145k.f2355h) && m2091a(this.f2356i, c1145k.f2356i) && m2091a(this.f2357j, c1145k.f2357j) && m2091a(this.f2358k, c1145k.f2358k) && m2091a(this.f2359l, c1145k.f2359l) && m2091a(this.f2360m, c1145k.f2360m) && m2091a(this.f2361n, c1145k.f2361n) && m2091a(this.f2362o, c1145k.f2362o) && m2091a(this.f2363p, c1145k.f2363p);
    }

    /* renamed from: f */
    public String m2095f() {
        return this.f2354g;
    }

    /* renamed from: g */
    public String m2096g() {
        return this.f2360m;
    }

    /* renamed from: h */
    public String m2097h() {
        return this.f2362o;
    }

    public int hashCode() {
        return ((((((((((((m2090a(this.f2350c) ^ 0) ^ m2090a(this.f2351d)) ^ m2090a(this.f2352e)) ^ m2090a(this.f2353f)) ^ m2090a(this.f2355h)) ^ m2090a(this.f2356i)) ^ m2090a(this.f2357j)) ^ m2090a(this.f2358k)) ^ m2090a(this.f2359l)) ^ m2090a(this.f2360m)) ^ m2090a(this.f2361n)) ^ m2090a(this.f2362o)) ^ m2090a(this.f2363p);
    }

    /* renamed from: i */
    public String m2098i() {
        return this.f2361n;
    }

    /* renamed from: j */
    public String m2099j() {
        return this.f2350c;
    }

    /* renamed from: k */
    public String m2100k() {
        return this.f2353f;
    }

    /* renamed from: l */
    public String m2101l() {
        return this.f2349b;
    }

    /* renamed from: m */
    public String m2102m() {
        return this.f2351d;
    }

    /* renamed from: n */
    public Map<String, String> m2103n() {
        return this.f2363p;
    }

    /* renamed from: o */
    public String m2104o() {
        return this.f2357j;
    }

    /* renamed from: p */
    public String m2105p() {
        return this.f2359l;
    }

    /* renamed from: q */
    public String m2106q() {
        return this.f2358k;
    }

    /* renamed from: a */
    private static int m2090a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        return String.valueOf(this.f2349b);
    }
}
