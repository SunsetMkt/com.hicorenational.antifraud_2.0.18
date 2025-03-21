package p031c.p035b.p043c.p070y.p071a;

/* compiled from: GeoParsedResult.java */
/* renamed from: c.b.c.y.a.m */
/* loaded from: classes.dex */
public final class C1148m extends AbstractC1152q {

    /* renamed from: b */
    private final double f2364b;

    /* renamed from: c */
    private final double f2365c;

    /* renamed from: d */
    private final double f2366d;

    /* renamed from: e */
    private final String f2367e;

    C1148m(double d2, double d3, double d4, String str) {
        super(EnumC1153r.GEO);
        this.f2364b = d2;
        this.f2365c = d3;
        this.f2366d = d4;
        this.f2367e = str;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f2364b);
        sb.append(", ");
        sb.append(this.f2365c);
        if (this.f2366d > 0.0d) {
            sb.append(", ");
            sb.append(this.f2366d);
            sb.append('m');
        }
        if (this.f2367e != null) {
            sb.append(" (");
            sb.append(this.f2367e);
            sb.append(')');
        }
        return sb.toString();
    }

    /* renamed from: c */
    public double m2109c() {
        return this.f2366d;
    }

    /* renamed from: d */
    public String m2110d() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f2364b);
        sb.append(',');
        sb.append(this.f2365c);
        if (this.f2366d > 0.0d) {
            sb.append(',');
            sb.append(this.f2366d);
        }
        if (this.f2367e != null) {
            sb.append('?');
            sb.append(this.f2367e);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public double m2111e() {
        return this.f2364b;
    }

    /* renamed from: f */
    public double m2112f() {
        return this.f2365c;
    }

    /* renamed from: g */
    public String m2113g() {
        return this.f2367e;
    }
}
