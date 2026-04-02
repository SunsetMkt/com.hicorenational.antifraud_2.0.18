package d.b.c.y.a;

/* JADX INFO: compiled from: WifiParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9960e;

    public j0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        q.a(this.f9957b, sb);
        q.a(this.f9958c, sb);
        q.a(this.f9959d, sb);
        q.a(Boolean.toString(this.f9960e), sb);
        return sb.toString();
    }

    public String c() {
        return this.f9958c;
    }

    public String d() {
        return this.f9959d;
    }

    public String e() {
        return this.f9957b;
    }

    public boolean f() {
        return this.f9960e;
    }

    public j0(String str, String str2, String str3, boolean z) {
        super(r.WIFI);
        this.f9957b = str2;
        this.f9958c = str;
        this.f9959d = str3;
        this.f9960e = z;
    }
}
