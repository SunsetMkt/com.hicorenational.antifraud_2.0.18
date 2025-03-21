package com.umeng.message.proguard;

import com.umeng.analytics.pro.C3393cw;
import okio.Utf8;

/* renamed from: com.umeng.message.proguard.as */
/* loaded from: classes2.dex */
public final class C3570as extends AbstractC3571at {

    /* renamed from: g */
    private static final byte[] f13227g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: h */
    private static final byte[] f13228h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: l */
    private int f13232l;

    /* renamed from: k */
    private final int f13231k = 4;

    /* renamed from: j */
    private final int f13230j = this.f13231k - 1;

    /* renamed from: i */
    private final byte[] f13229i = f13227g;

    /* renamed from: f */
    private static byte[] m12296f(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C3570as c3570as = new C3570as();
        long mo12300c = super.mo12300c(bArr);
        if (mo12300c <= 2147483647L) {
            return super.mo12301d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + mo12300c + ") than the specified maximum size of 2147483647");
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: a */
    final void mo12297a(byte[] bArr, int i2, int i3) {
        if (this.f13236d) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                m12305a(this.f13231k);
                this.f13238f = (this.f13238f + 1) % 3;
                int i5 = i2 + 1;
                int i6 = bArr[i2];
                if (i6 < 0) {
                    i6 += 256;
                }
                this.f13232l = (this.f13232l << 8) + i6;
                if (this.f13238f == 0) {
                    byte[] bArr2 = this.f13234b;
                    int i7 = this.f13235c;
                    this.f13235c = i7 + 1;
                    byte[] bArr3 = this.f13229i;
                    int i8 = this.f13232l;
                    bArr2[i7] = bArr3[(i8 >> 18) & 63];
                    int i9 = this.f13235c;
                    this.f13235c = i9 + 1;
                    bArr2[i9] = bArr3[(i8 >> 12) & 63];
                    int i10 = this.f13235c;
                    this.f13235c = i10 + 1;
                    bArr2[i10] = bArr3[(i8 >> 6) & 63];
                    int i11 = this.f13235c;
                    this.f13235c = i11 + 1;
                    bArr2[i11] = bArr3[i8 & 63];
                    this.f13237e += 4;
                }
                i4++;
                i2 = i5;
            }
            return;
        }
        this.f13236d = true;
        if (this.f13238f == 0) {
            return;
        }
        m12305a(this.f13231k);
        int i12 = this.f13235c;
        int i13 = this.f13238f;
        if (i13 == 1) {
            byte[] bArr4 = this.f13234b;
            this.f13235c = i12 + 1;
            byte[] bArr5 = this.f13229i;
            int i14 = this.f13232l;
            bArr4[i12] = bArr5[(i14 >> 2) & 63];
            int i15 = this.f13235c;
            this.f13235c = i15 + 1;
            bArr4[i15] = bArr5[(i14 << 4) & 63];
            if (bArr5 == f13227g) {
                int i16 = this.f13235c;
                this.f13235c = i16 + 1;
                bArr4[i16] = 61;
                int i17 = this.f13235c;
                this.f13235c = i17 + 1;
                bArr4[i17] = 61;
            }
        } else if (i13 == 2) {
            byte[] bArr6 = this.f13234b;
            this.f13235c = i12 + 1;
            byte[] bArr7 = this.f13229i;
            int i18 = this.f13232l;
            bArr6[i12] = bArr7[(i18 >> 10) & 63];
            int i19 = this.f13235c;
            this.f13235c = i19 + 1;
            bArr6[i19] = bArr7[(i18 >> 4) & 63];
            int i20 = this.f13235c;
            this.f13235c = i20 + 1;
            bArr6[i20] = bArr7[(i18 << 2) & 63];
            if (bArr7 == f13227g) {
                int i21 = this.f13235c;
                this.f13235c = i21 + 1;
                bArr6[i21] = 61;
            }
        }
        this.f13237e += this.f13235c - i12;
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ byte[] mo12299b(String str) {
        return super.mo12299b(str);
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ long mo12300c(byte[] bArr) {
        return super.mo12300c(bArr);
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ byte[] mo12301d(byte[] bArr) {
        return super.mo12301d(bArr);
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ byte[] mo12302e(byte[] bArr) {
        return super.mo12302e(bArr);
    }

    @Override // com.umeng.message.proguard.AbstractC3571at
    /* renamed from: b */
    final void mo12298b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f13236d) {
            return;
        }
        if (i3 < 0) {
            this.f13236d = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            m12305a(this.f13230j);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f13236d = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f13228h;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f13238f = (this.f13238f + 1) % 4;
                    this.f13232l = (this.f13232l << 6) + b2;
                    if (this.f13238f == 0) {
                        byte[] bArr3 = this.f13234b;
                        int i6 = this.f13235c;
                        this.f13235c = i6 + 1;
                        int i7 = this.f13232l;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f13235c;
                        this.f13235c = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f13235c;
                        this.f13235c = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f13236d || this.f13238f == 0) {
            return;
        }
        m12305a(this.f13230j);
        int i10 = this.f13238f;
        if (i10 == 2) {
            this.f13232l >>= 4;
            byte[] bArr4 = this.f13234b;
            int i11 = this.f13235c;
            this.f13235c = i11 + 1;
            bArr4[i11] = (byte) (this.f13232l & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f13232l >>= 2;
        byte[] bArr5 = this.f13234b;
        int i12 = this.f13235c;
        this.f13235c = i12 + 1;
        int i13 = this.f13232l;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f13235c;
        this.f13235c = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    /* renamed from: b */
    public static byte[] m12295b(byte[] bArr) {
        return m12296f(bArr);
    }

    /* renamed from: a */
    public static String m12293a(byte[] bArr) {
        return new String(m12296f(bArr));
    }

    /* renamed from: a */
    public static byte[] m12294a(String str) {
        return super.mo12299b(str);
    }
}
