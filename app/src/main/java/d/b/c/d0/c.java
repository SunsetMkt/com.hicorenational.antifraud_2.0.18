package d.b.c.d0;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: Code128Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends q {
    static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f9608b = 0.25f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f9609c = 0.7f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9610d = 98;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9611e = 99;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9612f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9613g = 101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9614h = 102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9615i = 97;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9616j = 96;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9617k = 101;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9618l = 100;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9619m = 103;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9620n = 104;
    private static final int o = 105;
    private static final int p = 106;

    private static int[] a(d.b.c.z.a aVar) throws d.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i2 = iC2;
        boolean z = false;
        int i3 = 0;
        while (iC2 < iC) {
            if (aVar.b(iC2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 == i4) {
                    float f2 = f9608b;
                    int i5 = -1;
                    for (int i6 = 103; i6 <= 105; i6++) {
                        float fA = q.a(iArr, a[i6], f9609c);
                        if (fA < f2) {
                            i5 = i6;
                            f2 = fA;
                        }
                    }
                    if (i5 >= 0 && aVar.a(Math.max(0, i2 - ((iC2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, iC2, i5};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i7 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i4] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            iC2++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private static int a(d.b.c.z.a aVar, int[] iArr, int i2) throws d.b.c.m {
        q.a(aVar, i2, iArr);
        float f2 = f9608b;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fA = q.a(iArr, iArr2[i4], f9609c);
            if (fA < f2) {
                i3 = i4;
                f2 = fA;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0149 A[PHI: r19
  0x0149: PHI (r19v7 boolean) = (r19v5 boolean), (r19v12 boolean) binds: [B:71:0x011b, B:44:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // d.b.c.d0.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        char c2;
        boolean z;
        boolean z2;
        char c3;
        boolean z3;
        boolean z4 = false;
        boolean z5 = map != null && map.containsKey(d.b.c.e.ASSUME_GS1);
        int[] iArrA = a(aVar);
        int i3 = iArrA[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i3));
        switch (i3) {
            case 103:
                c2 = 'e';
                break;
            case 104:
                c2 = 'd';
                break;
            case 105:
                c2 = 'c';
                break;
            default:
                throw d.b.c.h.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int[] iArr = new int[6];
        int i4 = i3;
        char c4 = c2;
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i6 = 0;
        int i7 = 0;
        boolean z8 = true;
        int i8 = iArrA[0];
        int i9 = iArrA[1];
        boolean z9 = false;
        while (!z7) {
            int iA = a(aVar, iArr, i9);
            arrayList.add(Byte.valueOf((byte) iA));
            if (iA != 106) {
                z8 = true;
            }
            if (iA != 106) {
                i7++;
                i4 += i7 * iA;
            }
            int i10 = i9;
            for (int i11 : iArr) {
                i10 += i11;
            }
            switch (iA) {
                case 103:
                case 104:
                case 105:
                    throw d.b.c.h.getFormatInstance();
                default:
                    switch (c4) {
                        case 'c':
                            if (iA >= 100) {
                                if (iA != 106) {
                                    z8 = false;
                                }
                                if (iA == 106) {
                                    z = z4;
                                    z2 = false;
                                    z7 = true;
                                    break;
                                } else {
                                    switch (iA) {
                                        case 100:
                                            z = z4;
                                            z2 = false;
                                            c4 = 'd';
                                            break;
                                        case 101:
                                            z = z4;
                                            z2 = false;
                                            c4 = 'e';
                                            break;
                                        case 102:
                                            if (z5) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                                break;
                                            }
                                        default:
                                            z = z4;
                                            z2 = false;
                                            break;
                                    }
                                }
                            } else {
                                if (iA < 10) {
                                    sb.append('0');
                                }
                                sb.append(iA);
                            }
                            z = z4;
                            z2 = false;
                            break;
                        case 'd':
                            if (iA < 96) {
                                if (z4 == z6) {
                                    sb.append((char) (iA + 32));
                                } else {
                                    sb.append((char) (iA + 32 + 128));
                                }
                                z2 = false;
                                z = false;
                            } else {
                                if (iA != 106) {
                                    z8 = false;
                                }
                                if (iA != 106) {
                                    switch (iA) {
                                        case 96:
                                        case 97:
                                        default:
                                            c3 = c4;
                                            break;
                                        case 98:
                                            z3 = z4;
                                            z2 = true;
                                            c3 = 'e';
                                            break;
                                        case 99:
                                            z3 = z4;
                                            z2 = false;
                                            c3 = 'c';
                                            break;
                                        case 100:
                                            if (z6 || !z4) {
                                                if (z6 && z4) {
                                                    c3 = c4;
                                                    z2 = false;
                                                    z6 = false;
                                                }
                                                c3 = c4;
                                                z2 = false;
                                                z3 = true;
                                            } else {
                                                c3 = c4;
                                                z2 = false;
                                                z6 = true;
                                            }
                                            z3 = false;
                                            break;
                                        case 101:
                                            z3 = z4;
                                            z2 = false;
                                            c3 = 'e';
                                            break;
                                        case 102:
                                            if (z5) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            c3 = c4;
                                            break;
                                    }
                                    z = z3;
                                    c4 = c3;
                                } else {
                                    c3 = c4;
                                    z7 = true;
                                }
                                z3 = z4;
                                z2 = false;
                                z = z3;
                                c4 = c3;
                            }
                            break;
                        case 'e':
                            if (iA >= 64) {
                                if (iA >= 96) {
                                    if (iA != 106) {
                                        z8 = false;
                                    }
                                    if (iA != 106) {
                                        switch (iA) {
                                            case 96:
                                            case 97:
                                            default:
                                                c3 = c4;
                                                break;
                                            case 98:
                                                z3 = z4;
                                                z2 = true;
                                                c3 = 'd';
                                                break;
                                            case 99:
                                                break;
                                            case 100:
                                                z3 = z4;
                                                z2 = false;
                                                c3 = 'd';
                                                break;
                                            case 101:
                                                if (z6 || !z4) {
                                                    if (z6 && z4) {
                                                        c3 = c4;
                                                        z2 = false;
                                                        z6 = false;
                                                    }
                                                    c3 = c4;
                                                    z2 = false;
                                                    z3 = true;
                                                } else {
                                                    c3 = c4;
                                                    z2 = false;
                                                    z6 = true;
                                                }
                                                z3 = false;
                                                break;
                                            case 102:
                                                if (z5) {
                                                    if (sb.length() == 0) {
                                                        sb.append("]C1");
                                                    } else {
                                                        sb.append((char) 29);
                                                    }
                                                }
                                                c3 = c4;
                                                break;
                                        }
                                        z = z3;
                                        c4 = c3;
                                    } else {
                                        c3 = c4;
                                        z7 = true;
                                    }
                                    z3 = z4;
                                    z2 = false;
                                    z = z3;
                                    c4 = c3;
                                    break;
                                } else if (z4 == z6) {
                                    sb.append((char) (iA - 64));
                                } else {
                                    sb.append((char) (iA + 64));
                                }
                            } else if (z4 == z6) {
                                sb.append((char) (iA + 32));
                            } else {
                                sb.append((char) (iA + 32 + 128));
                            }
                            z2 = false;
                            z = false;
                            break;
                        default:
                            z = z4;
                            z2 = false;
                            break;
                    }
                    if (z9) {
                        c4 = c4 == 'e' ? 'd' : 'e';
                    }
                    z9 = z2;
                    i8 = i9;
                    z4 = z;
                    i9 = i10;
                    int i12 = i6;
                    i6 = iA;
                    i5 = i12;
                    break;
            }
            while (!z7) {
            }
        }
        int i13 = i9 - i8;
        int iD = aVar.d(i9);
        if (aVar.a(iD, Math.min(aVar.c(), ((iD - i8) / 2) + iD), false)) {
            if ((i4 - (i7 * i5)) % 103 == i5) {
                int length = sb.length();
                if (length != 0) {
                    if (length > 0 && z8) {
                        if (c4 == 'c') {
                            sb.delete(length - 2, length);
                        } else {
                            sb.delete(length - 1, length);
                        }
                    }
                    float f2 = (iArrA[1] + iArrA[0]) / 2.0f;
                    float f3 = i8 + (i13 / 2.0f);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i14 = 0; i14 < size; i14++) {
                        bArr[i14] = ((Byte) arrayList.get(i14)).byteValue();
                    }
                    float f4 = i2;
                    return new d.b.c.r(sb.toString(), bArr, new d.b.c.t[]{new d.b.c.t(f2, f4), new d.b.c.t(f3, f4)}, d.b.c.a.CODE_128);
                }
                throw d.b.c.m.getNotFoundInstance();
            }
            throw d.b.c.d.getChecksumInstance();
        }
        throw d.b.c.m.getNotFoundInstance();
    }
}
