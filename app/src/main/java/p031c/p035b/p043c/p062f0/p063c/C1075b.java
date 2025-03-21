package p031c.p035b.p043c.p062f0.p063c;

import p031c.p035b.p043c.p062f0.p063c.C1083j;

/* compiled from: DataBlock.java */
/* renamed from: c.b.c.f0.c.b */
/* loaded from: classes.dex */
final class C1075b {

    /* renamed from: a */
    private final int f2117a;

    /* renamed from: b */
    private final byte[] f2118b;

    private C1075b(int i2, byte[] bArr) {
        this.f2117a = i2;
        this.f2118b = bArr;
    }

    /* renamed from: a */
    static C1075b[] m1741a(byte[] bArr, C1083j c1083j, EnumC1079f enumC1079f) {
        if (bArr.length != c1083j.m1776d()) {
            throw new IllegalArgumentException();
        }
        C1083j.b m1772a = c1083j.m1772a(enumC1079f);
        C1083j.a[] m1780a = m1772a.m1780a();
        int i2 = 0;
        for (C1083j.a aVar : m1780a) {
            i2 += aVar.m1778a();
        }
        C1075b[] c1075bArr = new C1075b[i2];
        int length = m1780a.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C1083j.a aVar2 = m1780a[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < aVar2.m1778a()) {
                int m1779b = aVar2.m1779b();
                c1075bArr[i5] = new C1075b(m1779b, new byte[m1772a.m1781b() + m1779b]);
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        int length2 = c1075bArr[0].f2118b.length;
        int length3 = c1075bArr.length - 1;
        while (length3 >= 0 && c1075bArr[length3].f2118b.length != length2) {
            length3--;
        }
        int i7 = length3 + 1;
        int m1781b = length2 - m1772a.m1781b();
        int i8 = 0;
        int i9 = 0;
        while (i8 < m1781b) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i4) {
                c1075bArr[i11].f2118b[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        int i12 = i7;
        while (i12 < i4) {
            c1075bArr[i12].f2118b[m1781b] = bArr[i9];
            i12++;
            i9++;
        }
        int length4 = c1075bArr[0].f2118b.length;
        while (m1781b < length4) {
            int i13 = i9;
            int i14 = 0;
            while (i14 < i4) {
                c1075bArr[i14].f2118b[i14 < i7 ? m1781b : m1781b + 1] = bArr[i13];
                i14++;
                i13++;
            }
            m1781b++;
            i9 = i13;
        }
        return c1075bArr;
    }

    /* renamed from: b */
    int m1743b() {
        return this.f2117a;
    }

    /* renamed from: a */
    byte[] m1742a() {
        return this.f2118b;
    }
}
