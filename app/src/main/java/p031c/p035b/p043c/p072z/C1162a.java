package p031c.p035b.p043c.p072z;

import java.util.Arrays;

/* compiled from: BitArray.java */
/* renamed from: c.b.c.z.a */
/* loaded from: classes.dex */
public final class C1162a implements Cloneable {

    /* renamed from: a */
    private int[] f2386a;

    /* renamed from: b */
    private int f2387b;

    public C1162a() {
        this.f2387b = 0;
        this.f2386a = new int[1];
    }

    /* renamed from: f */
    private void m2144f(int i2) {
        if (i2 > this.f2386a.length * 32) {
            int[] m2145g = m2145g(i2);
            int[] iArr = this.f2386a;
            System.arraycopy(iArr, 0, m2145g, 0, iArr.length);
            this.f2386a = m2145g;
        }
    }

    /* renamed from: g */
    private static int[] m2145g(int i2) {
        return new int[(i2 + 31) / 32];
    }

    /* renamed from: a */
    public void m2147a(int i2) {
        int[] iArr = this.f2386a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    /* renamed from: b */
    public boolean m2155b(int i2) {
        return ((1 << (i2 & 31)) & this.f2386a[i2 / 32]) != 0;
    }

    /* renamed from: c */
    public int m2157c() {
        return this.f2387b;
    }

    /* renamed from: d */
    public int m2160d() {
        return (this.f2387b + 7) / 8;
    }

    /* renamed from: e */
    public void m2163e(int i2) {
        int[] iArr = this.f2386a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1162a)) {
            return false;
        }
        C1162a c1162a = (C1162a) obj;
        return this.f2387b == c1162a.f2387b && Arrays.equals(this.f2386a, c1162a.f2386a);
    }

    public int hashCode() {
        return (this.f2387b * 31) + Arrays.hashCode(this.f2386a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f2387b);
        for (int i2 = 0; i2 < this.f2387b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(m2155b(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m2146a() {
        int length = this.f2386a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f2386a[i2] = 0;
        }
    }

    /* renamed from: b */
    public void m2153b(int i2, int i3) {
        this.f2386a[i2 / 32] = i3;
    }

    /* renamed from: c */
    public int m2158c(int i2) {
        int i3 = this.f2387b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.f2386a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f2386a;
            if (i4 == iArr.length) {
                return this.f2387b;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f2387b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C1162a m26848clone() {
        return new C1162a((int[]) this.f2386a.clone(), this.f2387b);
    }

    /* renamed from: d */
    public int m2161d(int i2) {
        int i3 = this.f2387b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.f2386a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f2386a;
            if (i4 == iArr.length) {
                return this.f2387b;
            }
            i5 = ~iArr[i4];
        }
        int numberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f2387b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    /* renamed from: e */
    public void m2162e() {
        int[] iArr = new int[this.f2386a.length];
        int i2 = (this.f2387b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f2386a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & 65535) << 16) | ((j6 >> 16) & 65535));
        }
        int i5 = this.f2387b;
        int i6 = i3 * 32;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = 1;
            for (int i9 = 0; i9 < 31 - i7; i9++) {
                i8 = (i8 << 1) | 1;
            }
            int i10 = (iArr[0] >> i7) & i8;
            for (int i11 = 1; i11 < i3; i11++) {
                int i12 = iArr[i11];
                iArr[i11 - 1] = i10 | (i12 << (32 - i7));
                i10 = (i12 >> i7) & i8;
            }
            iArr[i3 - 1] = i10;
        }
        this.f2386a = iArr;
    }

    /* renamed from: b */
    public void m2154b(C1162a c1162a) {
        if (this.f2386a.length != c1162a.f2386a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2386a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ c1162a.f2386a[i2];
            i2++;
        }
    }

    public C1162a(int i2) {
        this.f2387b = i2;
        this.f2386a = m2145g(i2);
    }

    /* renamed from: a */
    public boolean m2152a(int i2, int i3, boolean z) {
        int i4;
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i5 = i3 - 1;
        int i6 = i2 / 32;
        int i7 = i5 / 32;
        int i8 = i6;
        while (i8 <= i7) {
            int i9 = i8 > i6 ? 0 : i2 & 31;
            int i10 = i8 < i7 ? 31 : i5 & 31;
            if (i9 == 0 && i10 == 31) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i9 <= i10) {
                    i4 |= 1 << i9;
                    i9++;
                }
            }
            int i11 = this.f2386a[i8] & i4;
            if (!z) {
                i4 = 0;
            }
            if (i11 != i4) {
                return false;
            }
            i8++;
        }
        return true;
    }

    C1162a(int[] iArr, int i2) {
        this.f2386a = iArr;
        this.f2387b = i2;
    }

    /* renamed from: b */
    public int[] m2156b() {
        return this.f2386a;
    }

    /* renamed from: a */
    public void m2151a(boolean z) {
        m2144f(this.f2387b + 1);
        if (z) {
            int[] iArr = this.f2386a;
            int i2 = this.f2387b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f2387b++;
    }

    /* renamed from: c */
    public void m2159c(int i2, int i3) {
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 0;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            int i10 = i7 < i6 ? 31 : i4 & 31;
            if (i9 == 0 && i10 == 31) {
                i8 = -1;
            } else {
                while (i9 <= i10) {
                    i8 |= 1 << i9;
                    i9++;
                }
            }
            int[] iArr = this.f2386a;
            iArr[i7] = i8 | iArr[i7];
            i7++;
        }
    }

    /* renamed from: a */
    public void m2148a(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            m2144f(this.f2387b + i3);
            while (i3 > 0) {
                boolean z = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z = false;
                }
                m2151a(z);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    /* renamed from: a */
    public void m2150a(C1162a c1162a) {
        int i2 = c1162a.f2387b;
        m2144f(this.f2387b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            m2151a(c1162a.m2155b(i3));
        }
    }

    /* renamed from: a */
    public void m2149a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = i2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            int i8 = 0;
            for (int i9 = 0; i9 < 8; i9++) {
                if (m2155b(i7)) {
                    i8 |= 1 << (7 - i9);
                }
                i7++;
            }
            bArr[i3 + i6] = (byte) i8;
            i6++;
            i5 = i7;
        }
    }
}
