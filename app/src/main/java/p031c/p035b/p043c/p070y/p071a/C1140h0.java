package p031c.p035b.p043c.p070y.p071a;

/* compiled from: VINParsedResult.java */
/* renamed from: c.b.c.y.a.h0 */
/* loaded from: classes.dex */
public final class C1140h0 extends AbstractC1152q {

    /* renamed from: b */
    private final String f2330b;

    /* renamed from: c */
    private final String f2331c;

    /* renamed from: d */
    private final String f2332d;

    /* renamed from: e */
    private final String f2333e;

    /* renamed from: f */
    private final String f2334f;

    /* renamed from: g */
    private final String f2335g;

    /* renamed from: h */
    private final int f2336h;

    /* renamed from: i */
    private final char f2337i;

    /* renamed from: j */
    private final String f2338j;

    public C1140h0(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(EnumC1153r.VIN);
        this.f2330b = str;
        this.f2331c = str2;
        this.f2332d = str3;
        this.f2333e = str4;
        this.f2334f = str5;
        this.f2335g = str6;
        this.f2336h = i2;
        this.f2337i = c2;
        this.f2338j = str7;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f2331c);
        sb.append(' ');
        sb.append(this.f2332d);
        sb.append(' ');
        sb.append(this.f2333e);
        sb.append('\n');
        String str = this.f2334f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f2336h);
        sb.append(' ');
        sb.append(this.f2337i);
        sb.append(' ');
        sb.append(this.f2338j);
        sb.append('\n');
        return sb.toString();
    }

    /* renamed from: c */
    public String m2070c() {
        return this.f2334f;
    }

    /* renamed from: d */
    public int m2071d() {
        return this.f2336h;
    }

    /* renamed from: e */
    public char m2072e() {
        return this.f2337i;
    }

    /* renamed from: f */
    public String m2073f() {
        return this.f2338j;
    }

    /* renamed from: g */
    public String m2074g() {
        return this.f2330b;
    }

    /* renamed from: h */
    public String m2075h() {
        return this.f2335g;
    }

    /* renamed from: i */
    public String m2076i() {
        return this.f2332d;
    }

    /* renamed from: j */
    public String m2077j() {
        return this.f2333e;
    }

    /* renamed from: k */
    public String m2078k() {
        return this.f2331c;
    }
}
