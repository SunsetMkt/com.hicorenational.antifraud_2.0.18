package c.b.c.e0.e;

import c.b.c.m;
import c.b.c.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2675a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2676b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2677c = 512;

    /* renamed from: d, reason: collision with root package name */
    private static final c.b.c.e0.e.k.a f2678d = new c.b.c.e0.e.k.a();

    private j() {
    }

    public static c.b.c.z.e a(c.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) throws m, c.b.c.h, c.b.c.d {
        h hVar;
        int i4;
        int i5;
        int i6;
        h hVar2 = null;
        f fVar = null;
        h hVar3 = null;
        c cVar = new c(bVar, tVar, tVar2, tVar3, tVar4);
        int i7 = 0;
        while (i7 < 2) {
            if (tVar != null) {
                hVar2 = a(bVar, cVar, tVar, true, i2, i3);
            }
            hVar = hVar2;
            if (tVar3 != null) {
                hVar3 = a(bVar, cVar, tVar3, false, i2, i3);
            }
            fVar = b(hVar, hVar3);
            if (fVar == null) {
                throw m.getNotFoundInstance();
            }
            if (i7 != 0 || fVar.d() == null || (fVar.d().f() >= cVar.f() && fVar.d().d() <= cVar.d())) {
                fVar.a(cVar);
                break;
            }
            cVar = fVar.d();
            i7++;
            hVar2 = hVar;
        }
        hVar = hVar2;
        int a2 = fVar.a() + 1;
        fVar.a(0, hVar);
        fVar.a(a2, hVar3);
        boolean z = hVar != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= a2; i10++) {
            int i11 = z ? i10 : a2 - i10;
            if (fVar.a(i11) == null) {
                g hVar4 = (i11 == 0 || i11 == a2) ? new h(cVar, i11 == 0) : new g(cVar);
                fVar.a(i11, hVar4);
                int i12 = -1;
                int i13 = i9;
                int i14 = -1;
                int i15 = i8;
                int f2 = cVar.f();
                while (f2 <= cVar.d()) {
                    int a3 = a(fVar, i11, f2, z);
                    if (a3 >= 0 && a3 <= cVar.c()) {
                        i4 = a3;
                    } else if (i14 == i12) {
                        i5 = i14;
                        i6 = i13;
                        i13 = i6;
                        i14 = i5;
                        f2++;
                        i12 = -1;
                    } else {
                        i4 = i14;
                    }
                    i5 = i14;
                    int i16 = i13;
                    d a4 = a(bVar, cVar.e(), cVar.c(), z, i4, f2, i15, i16);
                    if (a4 != null) {
                        hVar4.a(f2, a4);
                        i15 = Math.min(i15, a4.f());
                        i13 = Math.max(i16, a4.f());
                        i14 = i4;
                        f2++;
                        i12 = -1;
                    } else {
                        i6 = i16;
                        i13 = i6;
                        i14 = i5;
                        f2++;
                        i12 = -1;
                    }
                }
                i8 = i15;
                i9 = i13;
            }
        }
        return b(fVar);
    }

    private static boolean a(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static f b(h hVar, h hVar2) throws m, c.b.c.h {
        a a2;
        if ((hVar == null && hVar2 == null) || (a2 = a(hVar, hVar2)) == null) {
            return null;
        }
        return new f(a2, c.a(a(hVar), a(hVar2)));
    }

    private static int c(int i2) {
        return 2 << i2;
    }

    private static int b(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    private static c.b.c.z.e b(f fVar) throws c.b.c.h, c.b.c.d, m {
        b[][] a2 = a(fVar);
        a(fVar, a2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.c() * fVar.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < fVar.c(); i2++) {
            int i3 = 0;
            while (i3 < fVar.a()) {
                int i4 = i3 + 1;
                int[] a3 = a2[i2][i4].a();
                int a4 = (fVar.a() * i2) + i3;
                if (a3.length == 0) {
                    arrayList.add(Integer.valueOf(a4));
                } else if (a3.length == 1) {
                    iArr[a4] = a3[0];
                } else {
                    arrayList3.add(Integer.valueOf(a4));
                    arrayList2.add(a3);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return a(fVar.b(), iArr, c.b.c.e0.a.a(arrayList), c.b.c.e0.a.a(arrayList3), iArr2);
    }

    private static c a(h hVar) throws m, c.b.c.h {
        int[] d2;
        if (hVar == null || (d2 = hVar.d()) == null) {
            return null;
        }
        int b2 = b(d2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : d2) {
            i3 += b2 - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] b3 = hVar.b();
        for (int i5 = 0; i3 > 0 && b3[i5] == null; i5++) {
            i3--;
        }
        for (int length = d2.length - 1; length >= 0; length--) {
            i2 += b2 - d2[length];
            if (d2[length] > 0) {
                break;
            }
        }
        for (int length2 = b3.length - 1; i2 > 0 && b3[length2] == null; length2--) {
            i2--;
        }
        return hVar.a().a(i3, i2, hVar.e());
    }

    private static int[] b(c.b.c.z.b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (((!z || i4 >= i3) && (z || i4 < i2)) || i7 >= iArr.length) {
                break;
            }
            if (bVar.b(i4, i5) == z2) {
                iArr[i7] = iArr[i7] + 1;
                i4 += i6;
            } else {
                i7++;
                z2 = !z2;
            }
        }
        if (i7 == iArr.length || (((z && i4 == i3) || (!z && i4 == i2)) && i7 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    private static int b(int i2) {
        return a(a(i2));
    }

    private static a a(h hVar, h hVar2) {
        a c2;
        a c3;
        if (hVar == null || (c2 = hVar.c()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.c();
        }
        if (hVar2 == null || (c3 = hVar2.c()) == null || c2.a() == c3.a() || c2.b() == c3.b() || c2.c() == c3.c()) {
            return c2;
        }
        return null;
    }

    private static h a(c.b.c.z.b bVar, c cVar, t tVar, boolean z, int i2, int i3) {
        h hVar = new h(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int a2 = (int) tVar.a();
            for (int b2 = (int) tVar.b(); b2 <= cVar.d() && b2 >= cVar.f(); b2 += i5) {
                d a3 = a(bVar, 0, bVar.g(), z, a2, b2, i2, i3);
                if (a3 != null) {
                    hVar.a(b2, a3);
                    if (z) {
                        a2 = a3.d();
                    } else {
                        a2 = a3.b();
                    }
                }
            }
            i4++;
        }
        return hVar;
    }

    private static void a(f fVar, b[][] bVarArr) throws m {
        int[] a2 = bVarArr[0][1].a();
        int a3 = (fVar.a() * fVar.c()) - c(fVar.b());
        if (a2.length != 0) {
            if (a2[0] != a3) {
                bVarArr[0][1].b(a3);
            }
        } else {
            if (a3 >= 1 && a3 <= 928) {
                bVarArr[0][1].b(a3);
                return;
            }
            throw m.getNotFoundInstance();
        }
    }

    private static c.b.c.z.e a(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws c.b.c.h, c.b.c.d {
        int[] iArr5 = new int[iArr3.length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < iArr5.length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return a(iArr, i2, iArr2);
                } catch (c.b.c.d unused) {
                    if (iArr5.length == 0) {
                        throw c.b.c.d.getChecksumInstance();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= iArr5.length) {
                            break;
                        }
                        if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        }
                        iArr5[i6] = 0;
                        if (i6 == iArr5.length - 1) {
                            throw c.b.c.d.getChecksumInstance();
                        }
                        i6++;
                    }
                    i3 = i4;
                }
            } else {
                throw c.b.c.d.getChecksumInstance();
            }
        }
    }

    private static b[][] a(f fVar) throws c.b.c.h {
        int c2;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.c(), fVar.a() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (g gVar : fVar.e()) {
            if (gVar != null) {
                for (d dVar : gVar.b()) {
                    if (dVar != null && (c2 = dVar.c()) >= 0) {
                        if (c2 < bVarArr.length) {
                            bVarArr[c2][i4].b(dVar.e());
                        } else {
                            throw c.b.c.h.getFormatInstance();
                        }
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static boolean a(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.a() + 1;
    }

    private static int a(f fVar, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        d a2 = a(fVar, i5) ? fVar.a(i5).a(i3) : null;
        if (a2 != null) {
            return z ? a2.b() : a2.d();
        }
        d b2 = fVar.a(i2).b(i3);
        if (b2 != null) {
            return z ? b2.d() : b2.b();
        }
        if (a(fVar, i5)) {
            b2 = fVar.a(i5).b(i3);
        }
        if (b2 != null) {
            return z ? b2.b() : b2.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (a(fVar, i2)) {
                for (d dVar : fVar.a(i2).b()) {
                    if (dVar != null) {
                        return (z ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                    }
                }
                i6++;
            } else {
                c d2 = fVar.d();
                return z ? d2.e() : d2.c();
            }
        }
    }

    private static d a(c.b.c.z.b bVar, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int d2;
        int a2;
        int a3 = a(bVar, i2, i3, z, i4, i5);
        int[] b2 = b(bVar, i2, i3, z, a3, i5);
        if (b2 == null) {
            return null;
        }
        int a4 = c.b.c.e0.a.a(b2);
        if (z) {
            a3 += a4;
            i8 = a3;
        } else {
            for (int i9 = 0; i9 < b2.length / 2; i9++) {
                int i10 = b2[i9];
                b2[i9] = b2[(b2.length - 1) - i9];
                b2[(b2.length - 1) - i9] = i10;
            }
            i8 = a3 - a4;
        }
        if (a(a4, i6, i7) && (a2 = c.b.c.e0.a.a((d2 = i.d(b2)))) != -1) {
            return new d(i8, a3, b(d2), a2);
        }
        return null;
    }

    private static int a(c.b.c.z.b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = z ? -1 : 1;
        boolean z2 = z;
        int i7 = i4;
        for (int i8 = 0; i8 < 2; i8++) {
            while (true) {
                if (((z2 && i7 >= i2) || (!z2 && i7 < i3)) && z2 == bVar.b(i7, i5)) {
                    if (Math.abs(i4 - i7) > 2) {
                        return i4;
                    }
                    i7 += i6;
                }
            }
            i6 = -i6;
            z2 = !z2;
        }
        return i7;
    }

    private static c.b.c.z.e a(int[] iArr, int i2, int[] iArr2) throws c.b.c.h, c.b.c.d {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int a2 = a(iArr, iArr2, i3);
            a(iArr, i3);
            c.b.c.z.e a3 = e.a(iArr, String.valueOf(i2));
            a3.b(Integer.valueOf(a2));
            a3.a(Integer.valueOf(iArr2.length));
            return a3;
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static int a(int[] iArr, int[] iArr2, int i2) throws c.b.c.d {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return f2678d.a(iArr, i2, iArr2);
        }
        throw c.b.c.d.getChecksumInstance();
    }

    private static void a(int[] iArr, int i2) throws c.b.c.h {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw c.b.c.h.getFormatInstance();
            }
            if (i3 == 0) {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw c.b.c.h.getFormatInstance();
            }
            return;
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static int[] a(int i2) {
        int[] iArr = new int[8];
        int length = iArr.length - 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 & 1;
            if (i4 != i3) {
                length--;
                if (length < 0) {
                    return iArr;
                }
                i3 = i4;
            }
            iArr[length] = iArr[length] + 1;
            i2 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static String a(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            formatter.format("Row %2d: ", Integer.valueOf(i2));
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar.a().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(bVar.a()[0]), bVar.a(bVar.a()[0]));
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
