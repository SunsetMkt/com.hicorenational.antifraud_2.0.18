package p031c.p035b.p043c.p072z;

import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* renamed from: c.b.c.z.b */
/* loaded from: classes.dex */
public final class C1163b implements Cloneable {

    /* renamed from: a */
    private final int f2388a;

    /* renamed from: b */
    private final int f2389b;

    /* renamed from: c */
    private final int f2390c;

    /* renamed from: d */
    private final int[] f2391d;

    public C1163b(int i2) {
        this(i2, i2);
    }

    /* renamed from: b */
    public static C1163b m2164b(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i2 < str.length()) {
            if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                if (i3 > i4) {
                    if (i5 == -1) {
                        i5 = i3 - i4;
                    } else if (i3 - i4 != i5) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i6++;
                    i4 = i3;
                }
                i2++;
            } else {
                if (str.substring(i2, str2.length() + i2).equals(str2)) {
                    i2 += str2.length();
                    zArr[i3] = true;
                } else {
                    if (!str.substring(i2, str3.length() + i2).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i2));
                    }
                    i2 += str3.length();
                    zArr[i3] = false;
                }
                i3++;
            }
        }
        if (i3 > i4) {
            if (i5 == -1) {
                i5 = i3 - i4;
            } else if (i3 - i4 != i5) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i6++;
        }
        C1163b c1163b = new C1163b(i5, i6);
        for (int i7 = 0; i7 < i3; i7++) {
            if (zArr[i7]) {
                c1163b.m2175c(i7 % i5, i7 / i5);
            }
        }
        return c1163b;
    }

    /* renamed from: a */
    public void m2169a(int i2, int i3) {
        int i4 = (i3 * this.f2390c) + (i2 / 32);
        int[] iArr = this.f2391d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    /* renamed from: c */
    public void m2175c(int i2, int i3) {
        int i4 = (i3 * this.f2390c) + (i2 / 32);
        int[] iArr = this.f2391d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    /* renamed from: d */
    public void m2178d(int i2, int i3) {
        int i4 = (i3 * this.f2390c) + (i2 / 32);
        int[] iArr = this.f2391d;
        iArr[i4] = (~(1 << (i2 & 31))) & iArr[i4];
    }

    /* renamed from: e */
    public int m2179e() {
        return this.f2390c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1163b)) {
            return false;
        }
        C1163b c1163b = (C1163b) obj;
        return this.f2388a == c1163b.f2388a && this.f2389b == c1163b.f2389b && this.f2390c == c1163b.f2390c && Arrays.equals(this.f2391d, c1163b.f2391d);
    }

    /* renamed from: f */
    public int[] m2180f() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2391d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        int[] iArr2 = this.f2391d;
        if (i2 == iArr2.length) {
            return null;
        }
        int i3 = this.f2390c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) * 32;
        int i6 = iArr2[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    /* renamed from: g */
    public int m2181g() {
        return this.f2388a;
    }

    /* renamed from: h */
    public void m2182h() {
        int m2181g = m2181g();
        int m2177d = m2177d();
        C1162a c1162a = new C1162a(m2181g);
        C1162a c1162a2 = new C1162a(m2181g);
        for (int i2 = 0; i2 < (m2177d + 1) / 2; i2++) {
            c1162a = m2165a(i2, c1162a);
            int i3 = (m2177d - 1) - i2;
            c1162a2 = m2165a(i3, c1162a2);
            c1162a.m2162e();
            c1162a2.m2162e();
            m2172b(i2, c1162a2);
            m2172b(i3, c1162a);
        }
    }

    public int hashCode() {
        int i2 = this.f2388a;
        return (((((((i2 * 31) + i2) * 31) + this.f2389b) * 31) + this.f2390c) * 31) + Arrays.hashCode(this.f2391d);
    }

    public String toString() {
        return m2166a("X ", "  ");
    }

    public C1163b(int i2, int i3) {
        if (i2 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2388a = i2;
        this.f2389b = i3;
        this.f2390c = (i2 + 31) / 32;
        this.f2391d = new int[this.f2390c * i3];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C1163b m26849clone() {
        return new C1163b(this.f2388a, this.f2389b, this.f2390c, (int[]) this.f2391d.clone());
    }

    /* renamed from: a */
    public void m2171a(C1163b c1163b) {
        if (this.f2388a == c1163b.m2181g() && this.f2389b == c1163b.m2177d() && this.f2390c == c1163b.m2179e()) {
            C1162a c1162a = new C1162a((this.f2388a / 32) + 1);
            for (int i2 = 0; i2 < this.f2389b; i2++) {
                int i3 = this.f2390c * i2;
                int[] m2156b = c1163b.m2165a(i2, c1162a).m2156b();
                for (int i4 = 0; i4 < this.f2390c; i4++) {
                    int[] iArr = this.f2391d;
                    int i5 = i3 + i4;
                    iArr[i5] = iArr[i5] ^ m2156b[i4];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    /* renamed from: c */
    public int[] m2176c() {
        int i2 = this.f2388a;
        int i3 = -1;
        int i4 = this.f2389b;
        int i5 = -1;
        int i6 = i2;
        int i7 = 0;
        while (i7 < this.f2389b) {
            int i8 = i5;
            int i9 = i3;
            int i10 = i6;
            int i11 = 0;
            while (true) {
                int i12 = this.f2390c;
                if (i11 < i12) {
                    int i13 = this.f2391d[(i12 * i7) + i11];
                    if (i13 != 0) {
                        if (i7 < i4) {
                            i4 = i7;
                        }
                        if (i7 > i8) {
                            i8 = i7;
                        }
                        int i14 = i11 * 32;
                        int i15 = 31;
                        if (i14 < i10) {
                            int i16 = 0;
                            while ((i13 << (31 - i16)) == 0) {
                                i16++;
                            }
                            int i17 = i16 + i14;
                            if (i17 < i10) {
                                i10 = i17;
                            }
                        }
                        if (i14 + 31 > i9) {
                            while ((i13 >>> i15) == 0) {
                                i15--;
                            }
                            int i18 = i14 + i15;
                            if (i18 > i9) {
                                i9 = i18;
                            }
                        }
                    }
                    i11++;
                }
            }
            i7++;
            i6 = i10;
            i3 = i9;
            i5 = i8;
        }
        int i19 = i3 - i6;
        int i20 = i5 - i4;
        if (i19 < 0 || i20 < 0) {
            return null;
        }
        return new int[]{i6, i4, i19, i20};
    }

    /* renamed from: d */
    public int m2177d() {
        return this.f2389b;
    }

    private C1163b(int i2, int i3, int i4, int[] iArr) {
        this.f2388a = i2;
        this.f2389b = i3;
        this.f2390c = i4;
        this.f2391d = iArr;
    }

    /* renamed from: a */
    public void m2168a() {
        int length = this.f2391d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f2391d[i2] = 0;
        }
    }

    /* renamed from: a */
    public void m2170a(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 >= 1 && i4 >= 1) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f2389b || i6 > this.f2388a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f2390c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f2391d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    /* renamed from: b */
    public boolean m2173b(int i2, int i3) {
        return ((this.f2391d[(i3 * this.f2390c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    /* renamed from: a */
    public C1162a m2165a(int i2, C1162a c1162a) {
        if (c1162a != null && c1162a.m2157c() >= this.f2388a) {
            c1162a.m2146a();
        } else {
            c1162a = new C1162a(this.f2388a);
        }
        int i3 = i2 * this.f2390c;
        for (int i4 = 0; i4 < this.f2390c; i4++) {
            c1162a.m2153b(i4 * 32, this.f2391d[i3 + i4]);
        }
        return c1162a;
    }

    /* renamed from: b */
    public void m2172b(int i2, C1162a c1162a) {
        int[] m2156b = c1162a.m2156b();
        int[] iArr = this.f2391d;
        int i3 = this.f2390c;
        System.arraycopy(m2156b, 0, iArr, i2 * i3, i3);
    }

    /* renamed from: b */
    public int[] m2174b() {
        int length = this.f2391d.length - 1;
        while (length >= 0 && this.f2391d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f2390c;
        int i3 = length / i2;
        int i4 = (length % i2) * 32;
        int i5 = 31;
        while ((this.f2391d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    /* renamed from: a */
    public String m2166a(String str, String str2) {
        return m2167a(str, str2, "\n");
    }

    @Deprecated
    /* renamed from: a */
    public String m2167a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f2389b * (this.f2388a + 1));
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            for (int i3 = 0; i3 < this.f2388a; i3++) {
                sb.append(m2173b(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
