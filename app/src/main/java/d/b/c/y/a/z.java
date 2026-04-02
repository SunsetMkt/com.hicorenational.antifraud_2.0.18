package d.b.c.y.a;

/* JADX INFO: compiled from: TelParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class z extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9992d;

    public z(String str, String str2, String str3) {
        super(r.TEL);
        this.f9990b = str;
        this.f9991c = str2;
        this.f9992d = str3;
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        q.a(this.f9990b, sb);
        q.a(this.f9992d, sb);
        return sb.toString();
    }

    public String c() {
        return this.f9990b;
    }

    public String d() {
        return this.f9991c;
    }

    public String e() {
        return this.f9992d;
    }
}
