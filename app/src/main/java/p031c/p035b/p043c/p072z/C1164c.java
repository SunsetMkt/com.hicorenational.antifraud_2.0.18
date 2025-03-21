package p031c.p035b.p043c.p072z;

import p286h.C5230f1;

/* compiled from: BitSource.java */
/* renamed from: c.b.c.z.c */
/* loaded from: classes.dex */
public final class C1164c {

    /* renamed from: a */
    private final byte[] f2392a;

    /* renamed from: b */
    private int f2393b;

    /* renamed from: c */
    private int f2394c;

    public C1164c(byte[] bArr) {
        this.f2392a = bArr;
    }

    /* renamed from: a */
    public int m2184a(int i2) {
        int i3;
        if (i2 < 1 || i2 > 32 || i2 > m2183a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i4 = this.f2394c;
        if (i4 > 0) {
            int i5 = 8 - i4;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.f2392a;
            int i8 = this.f2393b;
            i3 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            this.f2394c += i6;
            if (this.f2394c == 8) {
                this.f2394c = 0;
                this.f2393b = i8 + 1;
            }
        } else {
            i3 = 0;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            byte[] bArr2 = this.f2392a;
            int i9 = this.f2393b;
            i3 = (i3 << 8) | (bArr2[i9] & C5230f1.f20085c);
            this.f2393b = i9 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i10 = 8 - i2;
        int i11 = (i3 << i2) | ((((255 >> i10) << i10) & this.f2392a[this.f2393b]) >> i10);
        this.f2394c += i2;
        return i11;
    }

    /* renamed from: b */
    public int m2185b() {
        return this.f2394c;
    }

    /* renamed from: c */
    public int m2186c() {
        return this.f2393b;
    }

    /* renamed from: a */
    public int m2183a() {
        return ((this.f2392a.length - this.f2393b) * 8) - this.f2394c;
    }
}
