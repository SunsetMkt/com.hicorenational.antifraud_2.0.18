package p031c.p035b.p043c.p044a0.p045c;

import p031c.p035b.p043c.p044a0.p045c.C0960e;

/* compiled from: DataBlock.java */
/* renamed from: c.b.c.a0.c.b */
/* loaded from: classes.dex */
final class C0957b {

    /* renamed from: a */
    private final int f1653a;

    /* renamed from: b */
    private final byte[] f1654b;

    private C0957b(int i2, byte[] bArr) {
        this.f1653a = i2;
        this.f1654b = bArr;
    }

    /* renamed from: a */
    static C0957b[] m1201a(byte[] bArr, C0960e c0960e) {
        C0960e.c m1220c = c0960e.m1220c();
        C0960e.b[] m1227a = m1220c.m1227a();
        int i2 = 0;
        for (C0960e.b bVar : m1227a) {
            i2 += bVar.m1225a();
        }
        C0957b[] c0957bArr = new C0957b[i2];
        int length = m1227a.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C0960e.b bVar2 = m1227a[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < bVar2.m1225a()) {
                int m1226b = bVar2.m1226b();
                c0957bArr[i5] = new C0957b(m1226b, new byte[m1220c.m1228b() + m1226b]);
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        int length2 = c0957bArr[0].f1654b.length - m1220c.m1228b();
        int i7 = length2 - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i4) {
                c0957bArr[i11].f1654b[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        boolean z = c0960e.m1224g() == 24;
        int i12 = z ? 8 : i4;
        int i13 = i9;
        int i14 = 0;
        while (i14 < i12) {
            c0957bArr[i14].f1654b[i7] = bArr[i13];
            i14++;
            i13++;
        }
        int length3 = c0957bArr[0].f1654b.length;
        while (length2 < length3) {
            int i15 = 0;
            while (i15 < i4) {
                int i16 = z ? (i15 + 8) % i4 : i15;
                c0957bArr[i16].f1654b[(!z || i16 <= 7) ? length2 : length2 - 1] = bArr[i13];
                i15++;
                i13++;
            }
            length2++;
        }
        if (i13 == bArr.length) {
            return c0957bArr;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    int m1203b() {
        return this.f1653a;
    }

    /* renamed from: a */
    byte[] m1202a() {
        return this.f1654b;
    }
}
