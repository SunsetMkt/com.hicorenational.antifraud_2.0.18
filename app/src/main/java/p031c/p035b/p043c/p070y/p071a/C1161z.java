package p031c.p035b.p043c.p070y.p071a;

/* compiled from: TelParsedResult.java */
/* renamed from: c.b.c.y.a.z */
/* loaded from: classes.dex */
public final class C1161z extends AbstractC1152q {

    /* renamed from: b */
    private final String f2383b;

    /* renamed from: c */
    private final String f2384c;

    /* renamed from: d */
    private final String f2385d;

    public C1161z(String str, String str2, String str3) {
        super(EnumC1153r.TEL);
        this.f2383b = str;
        this.f2384c = str2;
        this.f2385d = str3;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(20);
        AbstractC1152q.m2115a(this.f2383b, sb);
        AbstractC1152q.m2115a(this.f2385d, sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String m2141c() {
        return this.f2383b;
    }

    /* renamed from: d */
    public String m2142d() {
        return this.f2384c;
    }

    /* renamed from: e */
    public String m2143e() {
        return this.f2385d;
    }
}
