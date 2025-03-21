package c.b.c.x.e;

import c.b.c.m;
import c.b.c.t;
import c.b.c.z.b;
import c.b.c.z.i;
import c.b.c.z.m.c;
import c.b.c.z.n.e;
import h.z2.h0;

/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f2864g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final b f2865a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2866b;

    /* renamed from: c, reason: collision with root package name */
    private int f2867c;

    /* renamed from: d, reason: collision with root package name */
    private int f2868d;

    /* renamed from: e, reason: collision with root package name */
    private int f2869e;

    /* renamed from: f, reason: collision with root package name */
    private int f2870f;

    /* compiled from: Detector.java */
    /* renamed from: c.b.c.x.e.a$a, reason: collision with other inner class name */
    static final class C0038a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2871a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2872b;

        C0038a(int i2, int i3) {
            this.f2871a = i2;
            this.f2872b = i3;
        }

        int a() {
            return this.f2871a;
        }

        int b() {
            return this.f2872b;
        }

        t c() {
            return new t(a(), b());
        }

        public String toString() {
            return "<" + this.f2871a + ' ' + this.f2872b + h0.f16708e;
        }
    }

    public a(b bVar) {
        this.f2865a = bVar;
    }

    private t[] b(t[] tVarArr) {
        return a(tVarArr, this.f2869e * 2, b());
    }

    private C0038a c() {
        t c2;
        t tVar;
        t tVar2;
        t tVar3;
        t c3;
        t c4;
        t c5;
        t c6;
        try {
            t[] a2 = new c(this.f2865a).a();
            tVar2 = a2[0];
            tVar3 = a2[1];
            tVar = a2[2];
            c2 = a2[3];
        } catch (m unused) {
            int g2 = this.f2865a.g() / 2;
            int d2 = this.f2865a.d() / 2;
            int i2 = g2 + 7;
            int i3 = d2 - 7;
            t c7 = a(new C0038a(i2, i3), false, 1, -1).c();
            int i4 = d2 + 7;
            t c8 = a(new C0038a(i2, i4), false, 1, 1).c();
            int i5 = g2 - 7;
            t c9 = a(new C0038a(i5, i4), false, -1, 1).c();
            c2 = a(new C0038a(i5, i3), false, -1, -1).c();
            tVar = c9;
            tVar2 = c7;
            tVar3 = c8;
        }
        int a3 = c.b.c.z.m.a.a((((tVar2.a() + c2.a()) + tVar3.a()) + tVar.a()) / 4.0f);
        int a4 = c.b.c.z.m.a.a((((tVar2.b() + c2.b()) + tVar3.b()) + tVar.b()) / 4.0f);
        try {
            t[] a5 = new c(this.f2865a, 15, a3, a4).a();
            c3 = a5[0];
            c4 = a5[1];
            c5 = a5[2];
            c6 = a5[3];
        } catch (m unused2) {
            int i6 = a3 + 7;
            int i7 = a4 - 7;
            c3 = a(new C0038a(i6, i7), false, 1, -1).c();
            int i8 = a4 + 7;
            c4 = a(new C0038a(i6, i8), false, 1, 1).c();
            int i9 = a3 - 7;
            c5 = a(new C0038a(i9, i8), false, -1, 1).c();
            c6 = a(new C0038a(i9, i7), false, -1, -1).c();
        }
        return new C0038a(c.b.c.z.m.a.a((((c3.a() + c6.a()) + c4.a()) + c5.a()) / 4.0f), c.b.c.z.m.a.a((((c3.b() + c6.b()) + c4.b()) + c5.b()) / 4.0f));
    }

    public c.b.c.x.a a() throws m {
        return a(false);
    }

    private int b(C0038a c0038a, C0038a c0038a2) {
        float a2 = a(c0038a, c0038a2);
        float a3 = (c0038a2.a() - c0038a.a()) / a2;
        float b2 = (c0038a2.b() - c0038a.b()) / a2;
        float a4 = c0038a.a();
        float b3 = c0038a.b();
        boolean b4 = this.f2865a.b(c0038a.a(), c0038a.b());
        float f2 = a4;
        float f3 = b3;
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            f2 += a3;
            f3 += b2;
            if (this.f2865a.b(c.b.c.z.m.a.a(f2), c.b.c.z.m.a.a(f3)) != b4) {
                i2++;
            }
        }
        float f4 = i2 / a2;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return (f4 <= 0.1f) == b4 ? 1 : -1;
        }
        return 0;
    }

    public c.b.c.x.a a(boolean z) throws m {
        t[] a2 = a(c());
        if (z) {
            t tVar = a2[0];
            a2[0] = a2[2];
            a2[2] = tVar;
        }
        a(a2);
        b bVar = this.f2865a;
        int i2 = this.f2870f;
        return new c.b.c.x.a(a(bVar, a2[i2 % 4], a2[(i2 + 1) % 4], a2[(i2 + 2) % 4], a2[(i2 + 3) % 4]), b(a2), this.f2866b, this.f2868d, this.f2867c);
    }

    private int b() {
        if (this.f2866b) {
            return (this.f2867c * 4) + 11;
        }
        int i2 = this.f2867c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private void a(t[] tVarArr) throws m {
        long j2;
        long j3;
        if (a(tVarArr[0]) && a(tVarArr[1]) && a(tVarArr[2]) && a(tVarArr[3])) {
            int i2 = this.f2869e * 2;
            int[] iArr = {a(tVarArr[0], tVarArr[1], i2), a(tVarArr[1], tVarArr[2], i2), a(tVarArr[2], tVarArr[3], i2), a(tVarArr[3], tVarArr[0], i2)};
            this.f2870f = a(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f2870f + i3) % 4];
                if (this.f2866b) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int a2 = a(j4, this.f2866b);
            if (this.f2866b) {
                this.f2867c = (a2 >> 6) + 1;
                this.f2868d = (a2 & 63) + 1;
                return;
            } else {
                this.f2867c = (a2 >> 11) + 1;
                this.f2868d = (a2 & 2047) + 1;
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
            if (Integer.bitCount(f2864g[i6] ^ i5) <= 2) {
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
            new c.b.c.z.n.c(c.b.c.z.n.a.f3066k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (e unused) {
            throw m.getNotFoundInstance();
        }
    }

    private t[] a(C0038a c0038a) throws m {
        this.f2869e = 1;
        C0038a c0038a2 = c0038a;
        C0038a c0038a3 = c0038a2;
        C0038a c0038a4 = c0038a3;
        C0038a c0038a5 = c0038a4;
        boolean z = true;
        while (this.f2869e < 9) {
            C0038a a2 = a(c0038a2, z, 1, -1);
            C0038a a3 = a(c0038a3, z, 1, 1);
            C0038a a4 = a(c0038a4, z, -1, 1);
            C0038a a5 = a(c0038a5, z, -1, -1);
            if (this.f2869e > 2) {
                double a6 = (a(a5, a2) * this.f2869e) / (a(c0038a5, c0038a2) * (this.f2869e + 2));
                if (a6 < 0.75d || a6 > 1.25d || !a(a2, a3, a4, a5)) {
                    break;
                }
            }
            z = !z;
            this.f2869e++;
            c0038a5 = a5;
            c0038a2 = a2;
            c0038a3 = a3;
            c0038a4 = a4;
        }
        int i2 = this.f2869e;
        if (i2 != 5 && i2 != 7) {
            throw m.getNotFoundInstance();
        }
        this.f2866b = this.f2869e == 5;
        t[] tVarArr = {new t(c0038a2.a() + 0.5f, c0038a2.b() - 0.5f), new t(c0038a3.a() + 0.5f, c0038a3.b() + 0.5f), new t(c0038a4.a() - 0.5f, c0038a4.b() + 0.5f), new t(c0038a5.a() - 0.5f, c0038a5.b() - 0.5f)};
        int i3 = this.f2869e;
        return a(tVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private b a(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        i a2 = i.a();
        int b2 = b();
        float f2 = b2 / 2.0f;
        int i2 = this.f2869e;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return a2.a(bVar, b2, b2, f3, f3, f4, f3, f4, f4, f3, f4, tVar.a(), tVar.b(), tVar2.a(), tVar2.b(), tVar3.a(), tVar3.b(), tVar4.a(), tVar4.b());
    }

    private int a(t tVar, t tVar2, int i2) {
        float a2 = a(tVar, tVar2);
        float f2 = a2 / i2;
        float a3 = tVar.a();
        float b2 = tVar.b();
        float a4 = ((tVar2.a() - tVar.a()) * f2) / a2;
        float b3 = (f2 * (tVar2.b() - tVar.b())) / a2;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.f2865a.b(c.b.c.z.m.a.a((f3 * a4) + a3), c.b.c.z.m.a.a((f3 * b3) + b2))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean a(C0038a c0038a, C0038a c0038a2, C0038a c0038a3, C0038a c0038a4) {
        C0038a c0038a5 = new C0038a(c0038a.a() - 3, c0038a.b() + 3);
        C0038a c0038a6 = new C0038a(c0038a2.a() - 3, c0038a2.b() - 3);
        C0038a c0038a7 = new C0038a(c0038a3.a() + 3, c0038a3.b() - 3);
        C0038a c0038a8 = new C0038a(c0038a4.a() + 3, c0038a4.b() + 3);
        int b2 = b(c0038a8, c0038a5);
        return b2 != 0 && b(c0038a5, c0038a6) == b2 && b(c0038a6, c0038a7) == b2 && b(c0038a7, c0038a8) == b2;
    }

    private C0038a a(C0038a c0038a, boolean z, int i2, int i3) {
        int a2 = c0038a.a() + i2;
        int b2 = c0038a.b();
        while (true) {
            b2 += i3;
            if (!a(a2, b2) || this.f2865a.b(a2, b2) != z) {
                break;
            }
            a2 += i2;
        }
        int i4 = a2 - i2;
        int i5 = b2 - i3;
        while (a(i4, i5) && this.f2865a.b(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (a(i6, i5) && this.f2865a.b(i6, i5) == z) {
            i5 += i3;
        }
        return new C0038a(i6, i5 - i3);
    }

    private static t[] a(t[] tVarArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float a2 = tVarArr[0].a() - tVarArr[2].a();
        float b2 = tVarArr[0].b() - tVarArr[2].b();
        float a3 = (tVarArr[0].a() + tVarArr[2].a()) / 2.0f;
        float b3 = (tVarArr[0].b() + tVarArr[2].b()) / 2.0f;
        float f5 = a2 * f4;
        float f6 = b2 * f4;
        t tVar = new t(a3 + f5, b3 + f6);
        t tVar2 = new t(a3 - f5, b3 - f6);
        float a4 = tVarArr[1].a() - tVarArr[3].a();
        float b4 = tVarArr[1].b() - tVarArr[3].b();
        float a5 = (tVarArr[1].a() + tVarArr[3].a()) / 2.0f;
        float b5 = (tVarArr[1].b() + tVarArr[3].b()) / 2.0f;
        float f7 = a4 * f4;
        float f8 = f4 * b4;
        return new t[]{tVar, new t(a5 + f7, b5 + f8), tVar2, new t(a5 - f7, b5 - f8)};
    }

    private boolean a(int i2, int i3) {
        return i2 >= 0 && i2 < this.f2865a.g() && i3 > 0 && i3 < this.f2865a.d();
    }

    private boolean a(t tVar) {
        return a(c.b.c.z.m.a.a(tVar.a()), c.b.c.z.m.a.a(tVar.b()));
    }

    private static float a(C0038a c0038a, C0038a c0038a2) {
        return c.b.c.z.m.a.a(c0038a.a(), c0038a.b(), c0038a2.a(), c0038a2.b());
    }

    private static float a(t tVar, t tVar2) {
        return c.b.c.z.m.a.a(tVar.a(), tVar.b(), tVar2.a(), tVar2.b());
    }
}
