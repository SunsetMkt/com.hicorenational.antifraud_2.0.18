package d.b.c.z.m;

import d.b.c.m;
import d.b.c.t;

/* JADX INFO: compiled from: MonochromeRectangleDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f10036b = 32;
    private final d.b.c.z.b a;

    public b(d.b.c.z.b bVar) {
        this.a = bVar;
    }

    public t[] a() throws m {
        int iD = this.a.d();
        int iG = this.a.g();
        int i2 = iD / 2;
        int i3 = iG / 2;
        int iMax = Math.max(1, iD / 256);
        int iMax2 = Math.max(1, iG / 256);
        int i4 = -iMax;
        int i5 = i3 / 2;
        int iB = ((int) a(i3, 0, 0, iG, i2, i4, 0, iD, i5).b()) - 1;
        int i6 = i2 / 2;
        t tVarA = a(i3, -iMax2, 0, iG, i2, 0, iB, iD, i6);
        int iA = ((int) tVarA.a()) - 1;
        t tVarA2 = a(i3, iMax2, iA, iG, i2, 0, iB, iD, i6);
        int iA2 = ((int) tVarA2.a()) + 1;
        t tVarA3 = a(i3, 0, iA, iA2, i2, iMax, iB, iD, i5);
        return new t[]{a(i3, 0, iA, iA2, i2, i4, iB, ((int) tVarA3.b()) + 1, i3 / 4), tVarA, tVarA2, tVarA3};
    }

    private t a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws m {
        int[] iArrA;
        int i11 = i2;
        int i12 = i6;
        int[] iArr = null;
        while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
            if (i3 == 0) {
                iArrA = a(i12, i10, i4, i5, true);
            } else {
                iArrA = a(i11, i10, i8, i9, false);
            }
            if (iArrA == null) {
                if (iArr == null) {
                    throw m.getNotFoundInstance();
                }
                if (i3 == 0) {
                    int i13 = i12 - i7;
                    if (iArr[0] < i2) {
                        if (iArr[1] > i2) {
                            return new t(i7 > 0 ? iArr[0] : iArr[1], i13);
                        }
                        return new t(iArr[0], i13);
                    }
                    return new t(iArr[1], i13);
                }
                int i14 = i11 - i3;
                if (iArr[0] < i6) {
                    if (iArr[1] > i6) {
                        return new t(i14, i3 < 0 ? iArr[0] : iArr[1]);
                    }
                    return new t(i14, iArr[0]);
                }
                return new t(i14, iArr[1]);
            }
            i12 += i7;
            i11 += i3;
            iArr = iArrA;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0067 A[EDGE_INSN: B:85:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] a(int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8 = (i4 + i5) / 2;
        int i9 = i8;
        while (i9 >= i4) {
            d.b.c.z.b bVar = this.a;
            if (!z) {
                if (!bVar.b(i2, i9)) {
                    i7 = i9;
                    while (true) {
                        i7--;
                        if (i7 >= i4) {
                        }
                    }
                    int i10 = i9 - i7;
                    if (i7 < i4) {
                        break;
                    }
                    break;
                    break;
                }
                i9--;
            } else if (bVar.b(i9, i2)) {
                i9--;
            } else {
                i7 = i9;
                while (true) {
                    i7--;
                    if (i7 >= i4) {
                        break;
                    }
                    d.b.c.z.b bVar2 = this.a;
                    if (z) {
                        if (bVar2.b(i7, i2)) {
                            break;
                        }
                    } else if (bVar2.b(i2, i7)) {
                        break;
                    }
                }
                int i102 = i9 - i7;
                if (i7 < i4 || i102 > i3) {
                    break;
                }
                i9 = i7;
            }
        }
        int i11 = i9 + 1;
        while (i8 < i5) {
            d.b.c.z.b bVar3 = this.a;
            if (!z) {
                if (!bVar3.b(i2, i8)) {
                    i6 = i8;
                    while (true) {
                        i6++;
                        if (i6 < i5) {
                        }
                    }
                    int i12 = i6 - i8;
                    if (i6 >= i5) {
                        break;
                    }
                    break;
                    break;
                }
                i8++;
            } else if (bVar3.b(i8, i2)) {
                i8++;
            } else {
                i6 = i8;
                while (true) {
                    i6++;
                    if (i6 < i5) {
                        break;
                    }
                    d.b.c.z.b bVar4 = this.a;
                    if (z) {
                        if (bVar4.b(i6, i2)) {
                            break;
                        }
                    } else if (bVar4.b(i2, i6)) {
                        break;
                    }
                }
                int i122 = i6 - i8;
                if (i6 >= i5 || i122 > i3) {
                    break;
                }
                i8 = i6;
            }
        }
        int i13 = i8 - 1;
        if (i13 > i11) {
            return new int[]{i11, i13};
        }
        return null;
    }
}
