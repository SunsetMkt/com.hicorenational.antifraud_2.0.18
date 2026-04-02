package d.b.c.y.a;

/* JADX INFO: compiled from: EmailAddressParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f9939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f9940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f9941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9943f;

    h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.a(this.f9939b, sb);
        q.a(this.f9940c, sb);
        q.a(this.f9941d, sb);
        q.a(this.f9942e, sb);
        q.a(this.f9943f, sb);
        return sb.toString();
    }

    public String[] c() {
        return this.f9941d;
    }

    public String d() {
        return this.f9943f;
    }

    public String[] e() {
        return this.f9940c;
    }

    @Deprecated
    public String f() {
        String[] strArr = this.f9939b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String g() {
        return "mailto:";
    }

    public String h() {
        return this.f9942e;
    }

    public String[] i() {
        return this.f9939b;
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS);
        this.f9939b = strArr;
        this.f9940c = strArr2;
        this.f9941d = strArr3;
        this.f9942e = str;
        this.f9943f = str2;
    }
}
