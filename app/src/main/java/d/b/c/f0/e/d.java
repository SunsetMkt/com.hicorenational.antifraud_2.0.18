package d.b.c.f0.e;

/* JADX INFO: compiled from: MaskUtil.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    private static final int a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9822b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9823c = 40;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9824d = 10;

    private d() {
    }

    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int b(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB - 1) {
            int i4 = i3;
            int i5 = 0;
            while (i5 < iC - 1) {
                byte b2 = bArrA[i2][i5];
                int i6 = i5 + 1;
                if (b2 == bArrA[i2][i6]) {
                    int i7 = i2 + 1;
                    if (b2 == bArrA[i7][i5] && b2 == bArrA[i7][i6]) {
                        i4++;
                    }
                }
                i5 = i6;
            }
            i2++;
            i3 = i4;
        }
        return i3 * 3;
    }

    static int c(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB) {
            int i4 = i3;
            for (int i5 = 0; i5 < iC; i5++) {
                byte[] bArr = bArrA[i2];
                int i6 = i5 + 6;
                if (i6 < iC && bArr[i5] == 1 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 1 && bArr[i5 + 3] == 1 && bArr[i5 + 4] == 1 && bArr[i5 + 5] == 0 && bArr[i6] == 1 && (a(bArr, i5 - 4, i5) || a(bArr, i5 + 7, i5 + 11))) {
                    i4++;
                }
                int i7 = i2 + 6;
                if (i7 < iB && bArrA[i2][i5] == 1 && bArrA[i2 + 1][i5] == 0 && bArrA[i2 + 2][i5] == 1 && bArrA[i2 + 3][i5] == 1 && bArrA[i2 + 4][i5] == 1 && bArrA[i2 + 5][i5] == 0 && bArrA[i7][i5] == 1 && (a(bArrA, i5, i2 - 4, i2) || a(bArrA, i5, i2 + 7, i2 + 11))) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        return i3 * 40;
    }

    static int d(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iB) {
            byte[] bArr = bArrA[i2];
            int i4 = i3;
            for (int i5 = 0; i5 < iC; i5++) {
                if (bArr[i5] == 1) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        int iB2 = bVar.b() * bVar.c();
        return ((Math.abs((i3 * 2) - iB2) * 10) / iB2) * 10;
    }

    private static boolean a(byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (i3 >= 0 && i3 < bArr.length && bArr[i3][i2] == 1) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean a(int i2, int i3, int i4) {
        int i5;
        int i6;
        switch (i2) {
            case 0:
                i4 += i3;
                i5 = i4 & 1;
                return i5 != 0;
            case 1:
                i5 = i4 & 1;
                if (i5 != 0) {
                }
                break;
            case 2:
                i5 = i3 % 3;
                if (i5 != 0) {
                }
                break;
            case 3:
                i5 = (i4 + i3) % 3;
                if (i5 != 0) {
                }
                break;
            case 4:
                i4 /= 2;
                i3 /= 3;
                i4 += i3;
                i5 = i4 & 1;
                if (i5 != 0) {
                }
                break;
            case 5:
                int i7 = i4 * i3;
                i5 = (i7 & 1) + (i7 % 3);
                if (i5 != 0) {
                }
                break;
            case 6:
                int i8 = i4 * i3;
                i6 = (i8 & 1) + (i8 % 3);
                i5 = i6 & 1;
                if (i5 != 0) {
                }
                break;
            case 7:
                i6 = ((i4 * i3) % 3) + ((i4 + i3) & 1);
                i5 = i6 & 1;
                if (i5 != 0) {
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i2);
        }
    }

    private static int a(b bVar, boolean z) {
        int iB = z ? bVar.b() : bVar.c();
        int iC = z ? bVar.c() : bVar.b();
        byte[][] bArrA = bVar.a();
        int i2 = 0;
        for (int i3 = 0; i3 < iB; i3++) {
            int i4 = i2;
            int i5 = 0;
            byte b2 = -1;
            for (int i6 = 0; i6 < iC; i6++) {
                byte b3 = z ? bArrA[i3][i6] : bArrA[i6][i3];
                if (b3 == b2) {
                    i5++;
                } else {
                    if (i5 >= 5) {
                        i4 += (i5 - 5) + 3;
                    }
                    i5 = 1;
                    b2 = b3;
                }
            }
            if (i5 >= 5) {
                i4 += (i5 - 5) + 3;
            }
            i2 = i4;
        }
        return i2;
    }
}
