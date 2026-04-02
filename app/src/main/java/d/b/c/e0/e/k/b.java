package d.b.c.e0.e.k;

/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: f */
    public static final b f9728f = new b(d.b.c.e0.a.a, 3);
    private final int[] a;

    /* JADX INFO: renamed from: b */
    private final int[] f9729b;

    /* JADX INFO: renamed from: c */
    private final c f9730c;

    /* JADX INFO: renamed from: d */
    private final c f9731d;

    /* JADX INFO: renamed from: e */
    private final int f9732e;

    private b(int i2, int i3) {
        this.f9732e = i2;
        this.a = new int[i2];
        this.f9729b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f9729b[this.a[i6]] = i6;
        }
        this.f9730c = new c(this, new int[]{0});
        this.f9731d = new c(this, new int[]{1});
    }

    c a() {
        return this.f9731d;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f9730c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    c c() {
        return this.f9730c;
    }

    int d(int i2, int i3) {
        int i4 = this.f9732e;
        return ((i2 + i4) - i3) % i4;
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.f9732e;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.f9729b[i2];
        }
        throw new IllegalArgumentException();
    }

    int a(int i2) {
        return this.a[i2];
    }

    int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.f9729b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f9732e - 1)];
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.a[(this.f9732e - this.f9729b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int b() {
        return this.f9732e;
    }
}
