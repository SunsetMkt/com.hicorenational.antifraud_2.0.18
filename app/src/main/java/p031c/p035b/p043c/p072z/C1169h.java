package p031c.p035b.p043c.p072z;

import p031c.p035b.p043c.AbstractC0976b;
import p031c.p035b.p043c.AbstractC1099j;
import p031c.p035b.p043c.C1102m;
import p286h.C5230f1;

/* compiled from: GlobalHistogramBinarizer.java */
/* renamed from: c.b.c.z.h */
/* loaded from: classes.dex */
public class C1169h extends AbstractC0976b {

    /* renamed from: d */
    private static final int f2409d = 5;

    /* renamed from: e */
    private static final int f2410e = 3;

    /* renamed from: f */
    private static final int f2411f = 32;

    /* renamed from: g */
    private static final byte[] f2412g = new byte[0];

    /* renamed from: b */
    private byte[] f2413b;

    /* renamed from: c */
    private final int[] f2414c;

    public C1169h(AbstractC1099j abstractC1099j) {
        super(abstractC1099j);
        this.f2413b = f2412g;
        this.f2414c = new int[32];
    }

    @Override // p031c.p035b.p043c.AbstractC0976b
    /* renamed from: a */
    public C1162a mo1323a(int i2, C1162a c1162a) throws C1102m {
        AbstractC1099j m1326c = m1326c();
        int m1902c = m1326c.m1902c();
        if (c1162a == null || c1162a.m2157c() < m1902c) {
            c1162a = new C1162a(m1902c);
        } else {
            c1162a.m2146a();
        }
        m2205a(m1902c);
        byte[] mo1894a = m1326c.mo1894a(i2, this.f2413b);
        int[] iArr = this.f2414c;
        for (int i3 = 0; i3 < m1902c; i3++) {
            int i4 = (mo1894a[i3] & C5230f1.f20085c) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int m2204a = m2204a(iArr);
        int i5 = mo1894a[0] & C5230f1.f20085c;
        int i6 = mo1894a[1] & C5230f1.f20085c;
        int i7 = i5;
        int i8 = 1;
        while (i8 < m1902c - 1) {
            int i9 = i8 + 1;
            int i10 = mo1894a[i9] & C5230f1.f20085c;
            if ((((i6 * 4) - i7) - i10) / 2 < m2204a) {
                c1162a.m2163e(i8);
            }
            i7 = i6;
            i8 = i9;
            i6 = i10;
        }
        return c1162a;
    }

    @Override // p031c.p035b.p043c.AbstractC0976b
    /* renamed from: a */
    public C1163b mo1324a() throws C1102m {
        AbstractC1099j m1326c = m1326c();
        int m1902c = m1326c.m1902c();
        int m1901a = m1326c.m1901a();
        C1163b c1163b = new C1163b(m1902c, m1901a);
        m2205a(m1902c);
        int[] iArr = this.f2414c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] mo1894a = m1326c.mo1894a((m1901a * i2) / 5, this.f2413b);
            int i3 = (m1902c * 4) / 5;
            for (int i4 = m1902c / 5; i4 < i3; i4++) {
                int i5 = (mo1894a[i4] & C5230f1.f20085c) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int m2204a = m2204a(iArr);
        byte[] mo1895b = m1326c.mo1895b();
        for (int i6 = 0; i6 < m1901a; i6++) {
            int i7 = i6 * m1902c;
            for (int i8 = 0; i8 < m1902c; i8++) {
                if ((mo1895b[i7 + i8] & C5230f1.f20085c) < m2204a) {
                    c1163b.m2175c(i8, i6);
                }
            }
        }
        return c1163b;
    }

    @Override // p031c.p035b.p043c.AbstractC0976b
    /* renamed from: a */
    public AbstractC0976b mo1322a(AbstractC1099j abstractC1099j) {
        return new C1169h(abstractC1099j);
    }

    /* renamed from: a */
    private void m2205a(int i2) {
        if (this.f2413b.length < i2) {
            this.f2413b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f2414c[i3] = 0;
        }
    }

    /* renamed from: a */
    private static int m2204a(int[] iArr) throws C1102m {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 > i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i6 - i4 <= length / 16) {
            throw C1102m.getNotFoundInstance();
        }
        int i12 = i6 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i4) {
            int i15 = i12 - i4;
            int i16 = i15 * i15 * (i6 - i12) * (i3 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }
}
