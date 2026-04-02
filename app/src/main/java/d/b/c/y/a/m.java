package d.b.c.y.a;

/* JADX INFO: compiled from: GeoParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f9974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f9975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f9976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9977e;

    m(double d2, double d3, double d4, String str) {
        super(r.GEO);
        this.f9974b = d2;
        this.f9975c = d3;
        this.f9976d = d4;
        this.f9977e = str;
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f9974b);
        sb.append(", ");
        sb.append(this.f9975c);
        if (this.f9976d > 0.0d) {
            sb.append(", ");
            sb.append(this.f9976d);
            sb.append('m');
        }
        if (this.f9977e != null) {
            sb.append(" (");
            sb.append(this.f9977e);
            sb.append(')');
        }
        return sb.toString();
    }

    public double c() {
        return this.f9976d;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f9974b);
        sb.append(',');
        sb.append(this.f9975c);
        if (this.f9976d > 0.0d) {
            sb.append(',');
            sb.append(this.f9976d);
        }
        if (this.f9977e != null) {
            sb.append('?');
            sb.append(this.f9977e);
        }
        return sb.toString();
    }

    public double e() {
        return this.f9974b;
    }

    public double f() {
        return this.f9975c;
    }

    public String g() {
        return this.f9977e;
    }
}
