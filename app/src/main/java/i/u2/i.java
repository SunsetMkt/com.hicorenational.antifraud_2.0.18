package i.u2;

/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12294i;

    public i(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f12289d = i2;
        this.f12290e = i3;
        this.f12291f = i4;
        this.f12292g = i5;
        this.f12293h = i6;
        this.f12294i = i7;
        if (!(((((this.f12289d | this.f12290e) | this.f12291f) | this.f12292g) | this.f12293h) != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            d();
        }
    }

    @Override // i.u2.f
    public int a(int i2) {
        return g.b(d(), i2);
    }

    @Override // i.u2.f
    public int d() {
        int i2 = this.f12289d;
        int i3 = i2 ^ (i2 >>> 2);
        this.f12289d = this.f12290e;
        this.f12290e = this.f12291f;
        this.f12291f = this.f12292g;
        int i4 = this.f12293h;
        this.f12292g = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.f12293h = i5;
        this.f12294i += 362437;
        return i5 + this.f12294i;
    }

    public i(int i2, int i3) {
        this(i2, i3, 0, 0, ~i2, (i2 << 10) ^ (i3 >>> 4));
    }
}
