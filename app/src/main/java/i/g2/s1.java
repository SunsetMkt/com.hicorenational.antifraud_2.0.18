package i.g2;

import i.b2;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s1 {
    @i.k
    private static final int a(byte[] bArr, int i2, int i3) {
        int i4;
        byte bA = i.g1.a(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int iA = i.g1.a(bArr, i2) & i.f1.f12066c;
                i4 = bA & i.f1.f12066c;
                if (i.q2.t.i0.a(iA, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (i.q2.t.i0.a(i.g1.a(bArr, i3) & i.f1.f12066c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte bA2 = i.g1.a(bArr, i2);
                i.g1.a(bArr, i2, i.g1.a(bArr, i3));
                i.g1.a(bArr, i3, bA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @i.k
    private static final void b(byte[] bArr, int i2, int i3) {
        int iA = a(bArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(bArr, i2, i4);
        }
        if (iA < i3) {
            b(bArr, iA, i3);
        }
    }

    @i.k
    private static final void b(short[] sArr, int i2, int i3) {
        int iA = a(sArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(sArr, i2, i4);
        }
        if (iA < i3) {
            b(sArr, iA, i3);
        }
    }

    @i.k
    private static final int a(short[] sArr, int i2, int i3) {
        int i4;
        short sA = i.u1.a(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int iA = i.u1.a(sArr, i2) & i.t1.f12275c;
                i4 = sA & i.t1.f12275c;
                if (i.q2.t.i0.a(iA, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (i.q2.t.i0.a(i.u1.a(sArr, i3) & i.t1.f12275c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short sA2 = i.u1.a(sArr, i2);
                i.u1.a(sArr, i2, i.u1.a(sArr, i3));
                i.u1.a(sArr, i3, sA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @i.k
    private static final void b(int[] iArr, int i2, int i3) {
        int iA = a(iArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(iArr, i2, i4);
        }
        if (iA < i3) {
            b(iArr, iA, i3);
        }
    }

    @i.k
    private static final void b(long[] jArr, int i2, int i3) {
        int iA = a(jArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            b(jArr, i2, i4);
        }
        if (iA < i3) {
            b(jArr, iA, i3);
        }
    }

    @i.k
    private static final int a(int[] iArr, int i2, int i3) {
        int iB = i.k1.b(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(i.k1.b(iArr, i2), iB) < 0) {
                i2++;
            }
            while (b2.a(i.k1.b(iArr, i3), iB) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int iB2 = i.k1.b(iArr, i2);
                i.k1.a(iArr, i2, i.k1.b(iArr, i3));
                i.k1.a(iArr, i3, iB2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @i.k
    private static final int a(long[] jArr, int i2, int i3) {
        long jA = i.o1.a(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (b2.a(i.o1.a(jArr, i2), jA) < 0) {
                i2++;
            }
            while (b2.a(i.o1.a(jArr, i3), jA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long jA2 = i.o1.a(jArr, i2);
                i.o1.a(jArr, i2, i.o1.a(jArr, i3));
                i.o1.a(jArr, i3, jA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @i.k
    public static final void a(@j.c.a.d byte[] bArr) {
        i.q2.t.i0.f(bArr, "array");
        b(bArr, 0, i.g1.c(bArr) - 1);
    }

    @i.k
    public static final void a(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "array");
        b(sArr, 0, i.u1.c(sArr) - 1);
    }

    @i.k
    public static final void a(@j.c.a.d int[] iArr) {
        i.q2.t.i0.f(iArr, "array");
        b(iArr, 0, i.k1.c(iArr) - 1);
    }

    @i.k
    public static final void a(@j.c.a.d long[] jArr) {
        i.q2.t.i0.f(jArr, "array");
        b(jArr, 0, i.o1.c(jArr) - 1);
    }
}
