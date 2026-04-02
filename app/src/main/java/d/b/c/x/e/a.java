package d.b.c.x.e;

import d.b.c.m;
import d.b.c.t;
import d.b.c.z.b;
import d.b.c.z.i;
import d.b.c.z.m.c;
import d.b.c.z.n.e;
import i.z2.h0;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f9864g = {3808, 476, 2107, 1799};
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9869f;

    /* JADX INFO: renamed from: d.b.c.x.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Detector.java */
    static final class C0161a {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9870b;

        C0161a(int i2, int i3) {
            this.a = i2;
            this.f9870b = i3;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.f9870b;
        }

        t c() {
            return new t(a(), b());
        }

        public String toString() {
            return "<" + this.a + ' ' + this.f9870b + h0.f12425e;
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    private t[] b(t[] tVarArr) {
        return a(tVarArr, this.f9868e * 2, b());
    }

    private C0161a c() {
        t tVarC;
        t tVar;
        t tVar2;
        t tVar3;
        t tVarC2;
        t tVarC3;
        t tVarC4;
        t tVarC5;
        try {
            t[] tVarArrA = new c(this.a).a();
            tVar2 = tVarArrA[0];
            tVar3 = tVarArrA[1];
            tVar = tVarArrA[2];
            tVarC = tVarArrA[3];
        } catch (m unused) {
            int iG = this.a.g() / 2;
            int iD = this.a.d() / 2;
            int i2 = iG + 7;
            int i3 = iD - 7;
            t tVarC6 = a(new C0161a(i2, i3), false, 1, -1).c();
            int i4 = iD + 7;
            t tVarC7 = a(new C0161a(i2, i4), false, 1, 1).c();
            int i5 = iG - 7;
            t tVarC8 = a(new C0161a(i5, i4), false, -1, 1).c();
            tVarC = a(new C0161a(i5, i3), false, -1, -1).c();
            tVar = tVarC8;
            tVar2 = tVarC6;
            tVar3 = tVarC7;
        }
        int iA = d.b.c.z.m.a.a((((tVar2.a() + tVarC.a()) + tVar3.a()) + tVar.a()) / 4.0f);
        int iA2 = d.b.c.z.m.a.a((((tVar2.b() + tVarC.b()) + tVar3.b()) + tVar.b()) / 4.0f);
        try {
            t[] tVarArrA2 = new c(this.a, 15, iA, iA2).a();
            tVarC2 = tVarArrA2[0];
            tVarC3 = tVarArrA2[1];
            tVarC4 = tVarArrA2[2];
            tVarC5 = tVarArrA2[3];
        } catch (m unused2) {
            int i6 = iA + 7;
            int i7 = iA2 - 7;
            tVarC2 = a(new C0161a(i6, i7), false, 1, -1).c();
            int i8 = iA2 + 7;
            tVarC3 = a(new C0161a(i6, i8), false, 1, 1).c();
            int i9 = iA - 7;
            tVarC4 = a(new C0161a(i9, i8), false, -1, 1).c();
            tVarC5 = a(new C0161a(i9, i7), false, -1, -1).c();
        }
        return new C0161a(d.b.c.z.m.a.a((((tVarC2.a() + tVarC5.a()) + tVarC3.a()) + tVarC4.a()) / 4.0f), d.b.c.z.m.a.a((((tVarC2.b() + tVarC5.b()) + tVarC3.b()) + tVarC4.b()) / 4.0f));
    }

    public d.b.c.x.a a() throws m {
        return a(false);
    }

    private int b(C0161a c0161a, C0161a c0161a2) {
        float fA = a(c0161a, c0161a2);
        float fA2 = (c0161a2.a() - c0161a.a()) / fA;
        float fB = (c0161a2.b() - c0161a.b()) / fA;
        float fA3 = c0161a.a();
        float fB2 = c0161a.b();
        boolean zB = this.a.b(c0161a.a(), c0161a.b());
        float f2 = fA3;
        float f3 = fB2;
        int i2 = 0;
        for (int i3 = 0; i3 < fA; i3++) {
            f2 += fA2;
            f3 += fB;
            if (this.a.b(d.b.c.z.m.a.a(f2), d.b.c.z.m.a.a(f3)) != zB) {
                i2++;
            }
        }
        float f4 = i2 / fA;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return (f4 <= 0.1f) == zB ? 1 : -1;
        }
        return 0;
    }

    public d.b.c.x.a a(boolean z) throws m {
        t[] tVarArrA = a(c());
        if (z) {
            t tVar = tVarArrA[0];
            tVarArrA[0] = tVarArrA[2];
            tVarArrA[2] = tVar;
        }
        a(tVarArrA);
        b bVar = this.a;
        int i2 = this.f9869f;
        return new d.b.c.x.a(a(bVar, tVarArrA[i2 % 4], tVarArrA[(i2 + 1) % 4], tVarArrA[(i2 + 2) % 4], tVarArrA[(i2 + 3) % 4]), b(tVarArrA), this.f9865b, this.f9867d, this.f9866c);
    }

    private int b() {
        if (this.f9865b) {
            return (this.f9866c * 4) + 11;
        }
        int i2 = this.f9866c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private void a(t[] tVarArr) throws m {
        long j2;
        long j3;
        if (a(tVarArr[0]) && a(tVarArr[1]) && a(tVarArr[2]) && a(tVarArr[3])) {
            int i2 = this.f9868e * 2;
            int[] iArr = {a(tVarArr[0], tVarArr[1], i2), a(tVarArr[1], tVarArr[2], i2), a(tVarArr[2], tVarArr[3], i2), a(tVarArr[3], tVarArr[0], i2)};
            this.f9869f = a(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f9869f + i3) % 4];
                if (this.f9865b) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int iA = a(j4, this.f9865b);
            if (this.f9865b) {
                this.f9866c = (iA >> 6) + 1;
                this.f9867d = (iA & 63) + 1;
                return;
            } else {
                this.f9866c = (iA >> 11) + 1;
                this.f9867d = (iA & 2047) + 1;
                return;
            }
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr, int i2) throws m {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f9864g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw m.getNotFoundInstance();
    }

    private static int a(long j2, boolean z) throws m {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new d.b.c.z.n.c(d.b.c.z.n.a.f10048k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (e unused) {
            throw m.getNotFoundInstance();
        }
    }

    private t[] a(C0161a c0161a) throws m {
        this.f9868e = 1;
        C0161a c0161a2 = c0161a;
        C0161a c0161a3 = c0161a2;
        C0161a c0161a4 = c0161a3;
        C0161a c0161a5 = c0161a4;
        boolean z = true;
        while (this.f9868e < 9) {
            C0161a c0161aA = a(c0161a2, z, 1, -1);
            C0161a c0161aA2 = a(c0161a3, z, 1, 1);
            C0161a c0161aA3 = a(c0161a4, z, -1, 1);
            C0161a c0161aA4 = a(c0161a5, z, -1, -1);
            if (this.f9868e > 2) {
                double dA = (a(c0161aA4, c0161aA) * this.f9868e) / (a(c0161a5, c0161a2) * (this.f9868e + 2));
                if (dA < 0.75d || dA > 1.25d || !a(c0161aA, c0161aA2, c0161aA3, c0161aA4)) {
                    break;
                }
            }
            z = !z;
            this.f9868e++;
            c0161a5 = c0161aA4;
            c0161a2 = c0161aA;
            c0161a3 = c0161aA2;
            c0161a4 = c0161aA3;
        }
        int i2 = this.f9868e;
        if (i2 != 5 && i2 != 7) {
            throw m.getNotFoundInstance();
        }
        this.f9865b = this.f9868e == 5;
        t[] tVarArr = {new t(c0161a2.a() + 0.5f, c0161a2.b() - 0.5f), new t(c0161a3.a() + 0.5f, c0161a3.b() + 0.5f), new t(c0161a4.a() - 0.5f, c0161a4.b() + 0.5f), new t(c0161a5.a() - 0.5f, c0161a5.b() - 0.5f)};
        int i3 = this.f9868e;
        return a(tVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private b a(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        i iVarA = i.a();
        int iB = b();
        float f2 = iB / 2.0f;
        int i2 = this.f9868e;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return iVarA.a(bVar, iB, iB, f3, f3, f4, f3, f4, f4, f3, f4, tVar.a(), tVar.b(), tVar2.a(), tVar2.b(), tVar3.a(), tVar3.b(), tVar4.a(), tVar4.b());
    }

    private int a(t tVar, t tVar2, int i2) {
        float fA = a(tVar, tVar2);
        float f2 = fA / i2;
        float fA2 = tVar.a();
        float fB = tVar.b();
        float fA3 = ((tVar2.a() - tVar.a()) * f2) / fA;
        float fB2 = (f2 * (tVar2.b() - tVar.b())) / fA;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.a.b(d.b.c.z.m.a.a((f3 * fA3) + fA2), d.b.c.z.m.a.a((f3 * fB2) + fB))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean a(C0161a c0161a, C0161a c0161a2, C0161a c0161a3, C0161a c0161a4) {
        C0161a c0161a5 = new C0161a(c0161a.a() - 3, c0161a.b() + 3);
        C0161a c0161a6 = new C0161a(c0161a2.a() - 3, c0161a2.b() - 3);
        C0161a c0161a7 = new C0161a(c0161a3.a() + 3, c0161a3.b() - 3);
        C0161a c0161a8 = new C0161a(c0161a4.a() + 3, c0161a4.b() + 3);
        int iB = b(c0161a8, c0161a5);
        return iB != 0 && b(c0161a5, c0161a6) == iB && b(c0161a6, c0161a7) == iB && b(c0161a7, c0161a8) == iB;
    }

    private C0161a a(C0161a c0161a, boolean z, int i2, int i3) {
        int iA = c0161a.a() + i2;
        int iB = c0161a.b();
        while (true) {
            iB += i3;
            if (!a(iA, iB) || this.a.b(iA, iB) != z) {
                break;
            }
            iA += i2;
        }
        int i4 = iA - i2;
        int i5 = iB - i3;
        while (a(i4, i5) && this.a.b(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (a(i6, i5) && this.a.b(i6, i5) == z) {
            i5 += i3;
        }
        return new C0161a(i6, i5 - i3);
    }

    private static t[] a(t[] tVarArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float fA = tVarArr[0].a() - tVarArr[2].a();
        float fB = tVarArr[0].b() - tVarArr[2].b();
        float fA2 = (tVarArr[0].a() + tVarArr[2].a()) / 2.0f;
        float fB2 = (tVarArr[0].b() + tVarArr[2].b()) / 2.0f;
        float f5 = fA * f4;
        float f6 = fB * f4;
        t tVar = new t(fA2 + f5, fB2 + f6);
        t tVar2 = new t(fA2 - f5, fB2 - f6);
        float fA3 = tVarArr[1].a() - tVarArr[3].a();
        float fB3 = tVarArr[1].b() - tVarArr[3].b();
        float fA4 = (tVarArr[1].a() + tVarArr[3].a()) / 2.0f;
        float fB4 = (tVarArr[1].b() + tVarArr[3].b()) / 2.0f;
        float f7 = fA3 * f4;
        float f8 = f4 * fB3;
        return new t[]{tVar, new t(fA4 + f7, fB4 + f8), tVar2, new t(fA4 - f7, fB4 - f8)};
    }

    private boolean a(int i2, int i3) {
        return i2 >= 0 && i2 < this.a.g() && i3 > 0 && i3 < this.a.d();
    }

    private boolean a(t tVar) {
        return a(d.b.c.z.m.a.a(tVar.a()), d.b.c.z.m.a.a(tVar.b()));
    }

    private static float a(C0161a c0161a, C0161a c0161a2) {
        return d.b.c.z.m.a.a(c0161a.a(), c0161a.b(), c0161a2.a(), c0161a2.b());
    }

    private static float a(t tVar, t tVar2) {
        return d.b.c.z.m.a.a(tVar.a(), tVar.b(), tVar2.a(), tVar2.b());
    }
}
