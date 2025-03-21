package p031c.p035b.p043c.p057e0.p058e.p059k;

import p031c.p035b.p043c.p057e0.C1045a;

/* compiled from: ModulusGF.java */
/* renamed from: c.b.c.e0.e.k.b */
/* loaded from: classes.dex */
public final class C1060b {

    /* renamed from: f */
    public static final C1060b f2041f = new C1060b(C1045a.f1963a, 3);

    /* renamed from: a */
    private final int[] f2042a;

    /* renamed from: b */
    private final int[] f2043b;

    /* renamed from: c */
    private final C1061c f2044c;

    /* renamed from: d */
    private final C1061c f2045d;

    /* renamed from: e */
    private final int f2046e;

    private C1060b(int i2, int i3) {
        this.f2046e = i2;
        this.f2042a = new int[i2];
        this.f2043b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f2042a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f2043b[this.f2042a[i6]] = i6;
        }
        this.f2044c = new C1061c(this, new int[]{0});
        this.f2045d = new C1061c(this, new int[]{1});
    }

    /* renamed from: a */
    C1061c m1658a() {
        return this.f2045d;
    }

    /* renamed from: b */
    C1061c m1661b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2044c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new C1061c(this, iArr);
    }

    /* renamed from: c */
    C1061c m1664c() {
        return this.f2044c;
    }

    /* renamed from: d */
    int m1665d(int i2, int i3) {
        int i4 = this.f2046e;
        return ((i2 + i4) - i3) % i4;
    }

    /* renamed from: a */
    int m1657a(int i2, int i3) {
        return (i2 + i3) % this.f2046e;
    }

    /* renamed from: c */
    int m1662c(int i2) {
        if (i2 != 0) {
            return this.f2043b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int m1656a(int i2) {
        return this.f2042a[i2];
    }

    /* renamed from: c */
    int m1663c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f2042a;
        int[] iArr2 = this.f2043b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f2046e - 1)];
    }

    /* renamed from: b */
    int m1660b(int i2) {
        if (i2 != 0) {
            return this.f2042a[(this.f2046e - this.f2043b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: b */
    int m1659b() {
        return this.f2046e;
    }
}
