package p286h.p318u2;

/* compiled from: XorWowRandom.kt */
/* renamed from: h.u2.i */
/* loaded from: classes2.dex */
public final class C5628i extends AbstractC5625f {

    /* renamed from: d */
    private int f20488d;

    /* renamed from: e */
    private int f20489e;

    /* renamed from: f */
    private int f20490f;

    /* renamed from: g */
    private int f20491g;

    /* renamed from: h */
    private int f20492h;

    /* renamed from: i */
    private int f20493i;

    public C5628i(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f20488d = i2;
        this.f20489e = i3;
        this.f20490f = i4;
        this.f20491g = i5;
        this.f20492h = i6;
        this.f20493i = i7;
        if (!(((((this.f20488d | this.f20489e) | this.f20490f) | this.f20491g) | this.f20492h) != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            mo22949d();
        }
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: a */
    public int mo22943a(int i2) {
        return C5626g.m22975b(mo22949d(), i2);
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: d */
    public int mo22949d() {
        int i2 = this.f20488d;
        int i3 = i2 ^ (i2 >>> 2);
        this.f20488d = this.f20489e;
        this.f20489e = this.f20490f;
        this.f20490f = this.f20491g;
        int i4 = this.f20492h;
        this.f20491g = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.f20492h = i5;
        this.f20493i += 362437;
        return i5 + this.f20493i;
    }

    public C5628i(int i2, int i3) {
        this(i2, i3, 0, 0, ~i2, (i2 << 10) ^ (i3 >>> 4));
    }
}
