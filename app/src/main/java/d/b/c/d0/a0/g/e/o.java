package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: DecodedInformation.java */
/* JADX INFO: loaded from: classes.dex */
final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9595d;

    o(int i2, String str) {
        super(i2);
        this.f9593b = str;
        this.f9595d = false;
        this.f9594c = 0;
    }

    String b() {
        return this.f9593b;
    }

    int c() {
        return this.f9594c;
    }

    boolean d() {
        return this.f9595d;
    }

    o(int i2, String str, int i3) {
        super(i2);
        this.f9595d = true;
        this.f9594c = i3;
        this.f9593b = str;
    }
}
