package c.b.c.f0.c;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2744a;

    /* renamed from: b, reason: collision with root package name */
    private j f2745b;

    /* renamed from: c, reason: collision with root package name */
    private g f2746c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2747d;

    a(c.b.c.z.b bVar) throws c.b.c.h {
        int d2 = bVar.d();
        if (d2 < 21 || (d2 & 3) != 1) {
            throw c.b.c.h.getFormatInstance();
        }
        this.f2744a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.f2747d ? this.f2744a.b(i3, i2) : this.f2744a.b(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    byte[] b() throws c.b.c.h {
        g c2 = c();
        j d2 = d();
        c a2 = c.a(c2.a());
        int d3 = this.f2744a.d();
        a2.a(this.f2744a, d3);
        c.b.c.z.b a3 = d2.a();
        byte[] bArr = new byte[d2.d()];
        int i2 = d3 - 1;
        int i3 = i2;
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            int i7 = i6;
            int i8 = i5;
            int i9 = i4;
            int i10 = 0;
            while (i10 < d3) {
                int i11 = z ? i2 - i10 : i10;
                int i12 = i7;
                int i13 = i8;
                int i14 = i9;
                for (int i15 = 0; i15 < 2; i15++) {
                    int i16 = i3 - i15;
                    if (!a3.b(i16, i11)) {
                        i13++;
                        int i17 = i12 << 1;
                        int i18 = this.f2744a.b(i16, i11) ? i17 | 1 : i17;
                        if (i13 == 8) {
                            bArr[i14] = (byte) i18;
                            i14++;
                            i13 = 0;
                            i12 = 0;
                        } else {
                            i12 = i18;
                        }
                    }
                }
                i10++;
                i9 = i14;
                i8 = i13;
                i7 = i12;
            }
            z = !z;
            i3 -= 2;
            i4 = i9;
            i5 = i8;
            i6 = i7;
        }
        if (i4 == d2.d()) {
            return bArr;
        }
        throw c.b.c.h.getFormatInstance();
    }

    g c() throws c.b.c.h {
        g gVar = this.f2746c;
        if (gVar != null) {
            return gVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a2 = a(8, i5, a2);
        }
        int d2 = this.f2744a.d();
        int i6 = d2 - 7;
        for (int i7 = d2 - 1; i7 >= i6; i7--) {
            i2 = a(8, i7, i2);
        }
        for (int i8 = d2 - 8; i8 < d2; i8++) {
            i2 = a(i8, 8, i2);
        }
        this.f2746c = g.a(a2, i2);
        g gVar2 = this.f2746c;
        if (gVar2 != null) {
            return gVar2;
        }
        throw c.b.c.h.getFormatInstance();
    }

    j d() throws c.b.c.h {
        j jVar = this.f2745b;
        if (jVar != null) {
            return jVar;
        }
        int d2 = this.f2744a.d();
        int i2 = (d2 - 17) / 4;
        if (i2 <= 6) {
            return j.c(i2);
        }
        int i3 = d2 - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = d2 - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        j a2 = j.a(i5);
        if (a2 != null && a2.c() == d2) {
            this.f2745b = a2;
            return a2;
        }
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = d2 - 9; i9 >= i3; i9--) {
                i4 = a(i8, i9, i4);
            }
        }
        j a3 = j.a(i4);
        if (a3 == null || a3.c() != d2) {
            throw c.b.c.h.getFormatInstance();
        }
        this.f2745b = a3;
        return a3;
    }

    void e() {
        g gVar = this.f2746c;
        if (gVar == null) {
            return;
        }
        c.a(gVar.a()).a(this.f2744a, this.f2744a.d());
    }

    void a(boolean z) {
        this.f2745b = null;
        this.f2746c = null;
        this.f2747d = z;
    }

    void a() {
        int i2 = 0;
        while (i2 < this.f2744a.g()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f2744a.d(); i4++) {
                if (this.f2744a.b(i2, i4) != this.f2744a.b(i4, i2)) {
                    this.f2744a.a(i4, i2);
                    this.f2744a.a(i2, i4);
                }
            }
            i2 = i3;
        }
    }
}
