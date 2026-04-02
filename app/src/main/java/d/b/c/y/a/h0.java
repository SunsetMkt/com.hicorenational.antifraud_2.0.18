package d.b.c.y.a;

/* JADX INFO: compiled from: VINParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final char f9951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9952j;

    public h0(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(r.VIN);
        this.f9944b = str;
        this.f9945c = str2;
        this.f9946d = str3;
        this.f9947e = str4;
        this.f9948f = str5;
        this.f9949g = str6;
        this.f9950h = i2;
        this.f9951i = c2;
        this.f9952j = str7;
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f9945c);
        sb.append(' ');
        sb.append(this.f9946d);
        sb.append(' ');
        sb.append(this.f9947e);
        sb.append('\n');
        String str = this.f9948f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f9950h);
        sb.append(' ');
        sb.append(this.f9951i);
        sb.append(' ');
        sb.append(this.f9952j);
        sb.append('\n');
        return sb.toString();
    }

    public String c() {
        return this.f9948f;
    }

    public int d() {
        return this.f9950h;
    }

    public char e() {
        return this.f9951i;
    }

    public String f() {
        return this.f9952j;
    }

    public String g() {
        return this.f9944b;
    }

    public String h() {
        return this.f9949g;
    }

    public String i() {
        return this.f9946d;
    }

    public String j() {
        return this.f9947e;
    }

    public String k() {
        return this.f9945c;
    }
}
