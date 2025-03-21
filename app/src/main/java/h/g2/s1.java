package h.g2;

import h.b2;

/* compiled from: UArraySorting.kt */
/* loaded from: classes2.dex */
public final class s1 {
    @h.k
    private static final int a(byte[] bArr, int i2, int i3) {
        int i4;
        byte a2 = h.g1.a(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int a3 = h.g1.a(bArr, i2) & h.f1.f16099c;
                i4 = a2 & h.f1.f16099c;
                if (h.q2.t.i0.a(a3, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (h.q2.t.i0.a(h.g1.a(bArr, i3) & h.f1.f16099c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte a4 = h.g1.a(bArr, i2);
                h.g1.a(bArr, i2, h.g1.a(bArr, i3));
                h.g1.a(bArr, i3, a4);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final void b(byte[] bArr, int i2, int i3) {
        int a2 = a(bArr, i2, i3);
        int i4 = a2 - 1;
        if (i2 < i4) {
            b(bArr, i2, i4);
        }
        if (a2 < i3) {
            b(bArr, a2, i3);
        }
    }

    @h.k
    private static final void b(short[] sArr, int i2, int i3) {
        int a2 = a(sArr, i2, i3);
        int i4 = a2 - 1;
        if (i2 < i4) {
            b(sArr, i2, i4);
        }
        if (a2 < i3) {
            b(sArr, a2, i3);
        }
    }

    @h.k
    private static final int a(short[] sArr, int i2, int i3) {
        int i4;
        short a2 = h.u1.a(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int a3 = h.u1.a(sArr, i2) & h.t1.f16480c;
                i4 = a2 & h.t1.f16480c;
                if (h.q2.t.i0.a(a3, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (h.q2.t.i0.a(h.u1.a(sArr, i3) & h.t1.f16480c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short a4 = h.u1.a(sArr, i2);
                h.u1.a(sArr, i2, h.u1.a(sArr, i3));
                h.u1.a(sArr, i3, a4);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final void b(int[] iArr, int i2, int i3) {
        int a2 = a(iArr, i2, i3);
        int i4 = a2 - 1;
        if (i2 < i4) {
            b(iArr, i2, i4);
        }
        if (a2 < i3) {
            b(iArr, a2, i3);
        }
    }

    @h.k
    private static final void b(long[] jArr, int i2, int i3) {
        int a2 = a(jArr, i2, i3);
        int i4 = a2 - 1;
        if (i2 < i4) {
            b(jArr, i2, i4);
        }
        if (a2 < i3) {
            b(jArr, a2, i3);
        }
    }

    @h.k
    private static final int a(int[] iArr, int i2, int i3) {
        int b2 = h.k1.b(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(h.k1.b(iArr, i2), b2) < 0) {
                i2++;
            }
            while (b2.a(h.k1.b(iArr, i3), b2) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int b3 = h.k1.b(iArr, i2);
                h.k1.a(iArr, i2, h.k1.b(iArr, i3));
                h.k1.a(iArr, i3, b3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    private static final int a(long[] jArr, int i2, int i3) {
        long a2 = h.o1.a(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(h.o1.a(jArr, i2), a2) < 0) {
                i2++;
            }
            while (b2.a(h.o1.a(jArr, i3), a2) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long a3 = h.o1.a(jArr, i2);
                h.o1.a(jArr, i2, h.o1.a(jArr, i3));
                h.o1.a(jArr, i3, a3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @h.k
    public static final void a(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "array");
        b(bArr, 0, h.g1.c(bArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "array");
        b(sArr, 0, h.u1.c(sArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "array");
        b(iArr, 0, h.k1.c(iArr) - 1);
    }

    @h.k
    public static final void a(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "array");
        b(jArr, 0, h.o1.c(jArr) - 1);
    }
}
