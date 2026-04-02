package d.b.c.y.a;

/* JADX INFO: compiled from: ProductParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class s extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9981c;

    s(String str) {
        this(str, str);
    }

    @Override // d.b.c.y.a.q
    public String a() {
        return this.f9980b;
    }

    public String c() {
        return this.f9981c;
    }

    public String d() {
        return this.f9980b;
    }

    s(String str, String str2) {
        super(r.PRODUCT);
        this.f9980b = str;
        this.f9981c = str2;
    }
}
