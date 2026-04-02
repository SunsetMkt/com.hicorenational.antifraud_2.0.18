package d.b.c.y.a;

import java.util.Map;

/* JADX INFO: compiled from: ExpandedProductParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class k extends q {
    public static final String q = "KG";
    public static final String r = "LB";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f9971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f9972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f9973n;
    private final String o;
    private final Map<String, String> p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT);
        this.f9961b = str;
        this.f9962c = str2;
        this.f9963d = str3;
        this.f9964e = str4;
        this.f9965f = str5;
        this.f9966g = str6;
        this.f9967h = str7;
        this.f9968i = str8;
        this.f9969j = str9;
        this.f9970k = str10;
        this.f9971l = str11;
        this.f9972m = str12;
        this.f9973n = str13;
        this.o = str14;
        this.p = map;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public String c() {
        return this.f9967h;
    }

    public String d() {
        return this.f9968i;
    }

    public String e() {
        return this.f9964e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return a(this.f9962c, kVar.f9962c) && a(this.f9963d, kVar.f9963d) && a(this.f9964e, kVar.f9964e) && a(this.f9965f, kVar.f9965f) && a(this.f9967h, kVar.f9967h) && a(this.f9968i, kVar.f9968i) && a(this.f9969j, kVar.f9969j) && a(this.f9970k, kVar.f9970k) && a(this.f9971l, kVar.f9971l) && a(this.f9972m, kVar.f9972m) && a(this.f9973n, kVar.f9973n) && a(this.o, kVar.o) && a(this.p, kVar.p);
    }

    public String f() {
        return this.f9966g;
    }

    public String g() {
        return this.f9972m;
    }

    public String h() {
        return this.o;
    }

    public int hashCode() {
        return ((((((((((((a(this.f9962c) ^ 0) ^ a(this.f9963d)) ^ a(this.f9964e)) ^ a(this.f9965f)) ^ a(this.f9967h)) ^ a(this.f9968i)) ^ a(this.f9969j)) ^ a(this.f9970k)) ^ a(this.f9971l)) ^ a(this.f9972m)) ^ a(this.f9973n)) ^ a(this.o)) ^ a(this.p);
    }

    public String i() {
        return this.f9973n;
    }

    public String j() {
        return this.f9962c;
    }

    public String k() {
        return this.f9965f;
    }

    public String l() {
        return this.f9961b;
    }

    public String m() {
        return this.f9963d;
    }

    public Map<String, String> n() {
        return this.p;
    }

    public String o() {
        return this.f9969j;
    }

    public String p() {
        return this.f9971l;
    }

    public String q() {
        return this.f9970k;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // d.b.c.y.a.q
    public String a() {
        return String.valueOf(this.f9961b);
    }
}
