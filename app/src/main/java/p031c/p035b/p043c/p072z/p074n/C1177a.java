package p031c.p035b.p043c.p072z.p074n;

/* compiled from: GenericGF.java */
/* renamed from: c.b.c.z.n.a */
/* loaded from: classes.dex */
public final class C1177a {

    /* renamed from: h */
    public static final C1177a f2449h = new C1177a(4201, 4096, 1);

    /* renamed from: i */
    public static final C1177a f2450i = new C1177a(1033, 1024, 1);

    /* renamed from: j */
    public static final C1177a f2451j = new C1177a(67, 64, 1);

    /* renamed from: k */
    public static final C1177a f2452k = new C1177a(19, 16, 1);

    /* renamed from: l */
    public static final C1177a f2453l = new C1177a(285, 256, 0);

    /* renamed from: m */
    public static final C1177a f2454m = new C1177a(301, 256, 1);

    /* renamed from: n */
    public static final C1177a f2455n = f2454m;

    /* renamed from: o */
    public static final C1177a f2456o = f2451j;

    /* renamed from: a */
    private final int[] f2457a;

    /* renamed from: b */
    private final int[] f2458b;

    /* renamed from: c */
    private final C1178b f2459c;

    /* renamed from: d */
    private final C1178b f2460d;

    /* renamed from: e */
    private final int f2461e;

    /* renamed from: f */
    private final int f2462f;

    /* renamed from: g */
    private final int f2463g;

    public C1177a(int i2, int i3, int i4) {
        this.f2462f = i2;
        this.f2461e = i3;
        this.f2463g = i4;
        this.f2457a = new int[i3];
        this.f2458b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f2457a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f2458b[this.f2457a[i7]] = i7;
        }
        this.f2459c = new C1178b(this, new int[]{0});
        this.f2460d = new C1178b(this, new int[]{1});
    }

    /* renamed from: c */
    static int m2231c(int i2, int i3) {
        return i2 ^ i3;
    }

    /* renamed from: a */
    C1178b m2234a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2459c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new C1178b(this, iArr);
    }

    /* renamed from: b */
    C1178b m2237b() {
        return this.f2460d;
    }

    /* renamed from: c */
    int m2239c(int i2) {
        if (i2 != 0) {
            return this.f2458b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    C1178b m2240d() {
        return this.f2459c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f2462f) + ',' + this.f2461e + ')';
    }

    /* renamed from: b */
    int m2235b(int i2) {
        if (i2 != 0) {
            return this.f2457a[(this.f2461e - this.f2458b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: c */
    public int m2238c() {
        return this.f2461e;
    }

    /* renamed from: b */
    int m2236b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f2457a;
        int[] iArr2 = this.f2458b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f2461e - 1)];
    }

    /* renamed from: a */
    int m2233a(int i2) {
        return this.f2457a[i2];
    }

    /* renamed from: a */
    public int m2232a() {
        return this.f2463g;
    }
}
