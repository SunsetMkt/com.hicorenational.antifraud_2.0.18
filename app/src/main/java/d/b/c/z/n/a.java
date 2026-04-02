package d.b.c.z.n;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h */
    public static final a f10045h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i */
    public static final a f10046i = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: j */
    public static final a f10047j = new a(67, 64, 1);

    /* JADX INFO: renamed from: k */
    public static final a f10048k = new a(19, 16, 1);

    /* JADX INFO: renamed from: l */
    public static final a f10049l = new a(285, 256, 0);

    /* JADX INFO: renamed from: m */
    public static final a f10050m = new a(301, 256, 1);

    /* JADX INFO: renamed from: n */
    public static final a f10051n = f10050m;
    public static final a o = f10047j;
    private final int[] a;

    /* JADX INFO: renamed from: b */
    private final int[] f10052b;

    /* JADX INFO: renamed from: c */
    private final b f10053c;

    /* JADX INFO: renamed from: d */
    private final b f10054d;

    /* JADX INFO: renamed from: e */
    private final int f10055e;

    /* JADX INFO: renamed from: f */
    private final int f10056f;

    /* JADX INFO: renamed from: g */
    private final int f10057g;

    public a(int i2, int i3, int i4) {
        this.f10056f = i2;
        this.f10055e = i3;
        this.f10057g = i4;
        this.a = new int[i3];
        this.f10052b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f10052b[this.a[i7]] = i7;
        }
        this.f10053c = new b(this, new int[]{0});
        this.f10054d = new b(this, new int[]{1});
    }

    static int c(int i2, int i3) {
        return i2 ^ i3;
    }

    b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f10053c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    b b() {
        return this.f10054d;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.f10052b[i2];
        }
        throw new IllegalArgumentException();
    }

    b d() {
        return this.f10053c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f10056f) + ',' + this.f10055e + ')';
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.a[(this.f10055e - this.f10052b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c() {
        return this.f10055e;
    }

    int b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.f10052b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f10055e - 1)];
    }

    int a(int i2) {
        return this.a[i2];
    }

    public int a() {
        return this.f10057g;
    }
}
