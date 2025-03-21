package p031c.p035b.p043c.p070y.p071a;

/* compiled from: WifiParsedResult.java */
/* renamed from: c.b.c.y.a.j0 */
/* loaded from: classes.dex */
public final class C1144j0 extends AbstractC1152q {

    /* renamed from: b */
    private final String f2343b;

    /* renamed from: c */
    private final String f2344c;

    /* renamed from: d */
    private final String f2345d;

    /* renamed from: e */
    private final boolean f2346e;

    public C1144j0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(80);
        AbstractC1152q.m2115a(this.f2343b, sb);
        AbstractC1152q.m2115a(this.f2344c, sb);
        AbstractC1152q.m2115a(this.f2345d, sb);
        AbstractC1152q.m2115a(Boolean.toString(this.f2346e), sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String m2086c() {
        return this.f2344c;
    }

    /* renamed from: d */
    public String m2087d() {
        return this.f2345d;
    }

    /* renamed from: e */
    public String m2088e() {
        return this.f2343b;
    }

    /* renamed from: f */
    public boolean m2089f() {
        return this.f2346e;
    }

    public C1144j0(String str, String str2, String str3, boolean z) {
        super(EnumC1153r.WIFI);
        this.f2343b = str2;
        this.f2344c = str;
        this.f2345d = str3;
        this.f2346e = z;
    }
}
