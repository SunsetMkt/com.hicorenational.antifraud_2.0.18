package com.umeng.message.proguard;

import com.umeng.analytics.pro.cw;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class as extends at {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f7999g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f8000h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cw.f7203k, cw.f7204l, cw.f7205m, cw.f7206n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8004l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8003k = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8002j = this.f8003k - 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f8001i = f7999g;

    private static byte[] f(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        as asVar = new as();
        long jC = super.c(bArr);
        if (jC <= 2147483647L) {
            return super.d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jC + ") than the specified maximum size of 2147483647");
    }

    @Override // com.umeng.message.proguard.at
    final void a(byte[] bArr, int i2, int i3) {
        if (this.f8007d) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                a(this.f8003k);
                this.f8009f = (this.f8009f + 1) % 3;
                int i5 = i2 + 1;
                int i6 = bArr[i2];
                if (i6 < 0) {
                    i6 += 256;
                }
                this.f8004l = (this.f8004l << 8) + i6;
                if (this.f8009f == 0) {
                    byte[] bArr2 = this.f8005b;
                    int i7 = this.f8006c;
                    this.f8006c = i7 + 1;
                    byte[] bArr3 = this.f8001i;
                    int i8 = this.f8004l;
                    bArr2[i7] = bArr3[(i8 >> 18) & 63];
                    int i9 = this.f8006c;
                    this.f8006c = i9 + 1;
                    bArr2[i9] = bArr3[(i8 >> 12) & 63];
                    int i10 = this.f8006c;
                    this.f8006c = i10 + 1;
                    bArr2[i10] = bArr3[(i8 >> 6) & 63];
                    int i11 = this.f8006c;
                    this.f8006c = i11 + 1;
                    bArr2[i11] = bArr3[i8 & 63];
                    this.f8008e += 4;
                }
                i4++;
                i2 = i5;
            }
            return;
        }
        this.f8007d = true;
        if (this.f8009f == 0) {
            return;
        }
        a(this.f8003k);
        int i12 = this.f8006c;
        int i13 = this.f8009f;
        if (i13 == 1) {
            byte[] bArr4 = this.f8005b;
            this.f8006c = i12 + 1;
            byte[] bArr5 = this.f8001i;
            int i14 = this.f8004l;
            bArr4[i12] = bArr5[(i14 >> 2) & 63];
            int i15 = this.f8006c;
            this.f8006c = i15 + 1;
            bArr4[i15] = bArr5[(i14 << 4) & 63];
            if (bArr5 == f7999g) {
                int i16 = this.f8006c;
                this.f8006c = i16 + 1;
                bArr4[i16] = 61;
                int i17 = this.f8006c;
                this.f8006c = i17 + 1;
                bArr4[i17] = 61;
            }
        } else if (i13 == 2) {
            byte[] bArr6 = this.f8005b;
            this.f8006c = i12 + 1;
            byte[] bArr7 = this.f8001i;
            int i18 = this.f8004l;
            bArr6[i12] = bArr7[(i18 >> 10) & 63];
            int i19 = this.f8006c;
            this.f8006c = i19 + 1;
            bArr6[i19] = bArr7[(i18 >> 4) & 63];
            int i20 = this.f8006c;
            this.f8006c = i20 + 1;
            bArr6[i20] = bArr7[(i18 << 2) & 63];
            if (bArr7 == f7999g) {
                int i21 = this.f8006c;
                this.f8006c = i21 + 1;
                bArr6[i21] = 61;
            }
        }
        this.f8008e += this.f8006c - i12;
    }

    @Override // com.umeng.message.proguard.at
    public final /* bridge */ /* synthetic */ byte[] b(String str) {
        return super.b(str);
    }

    @Override // com.umeng.message.proguard.at
    public final /* bridge */ /* synthetic */ long c(byte[] bArr) {
        return super.c(bArr);
    }

    @Override // com.umeng.message.proguard.at
    public final /* bridge */ /* synthetic */ byte[] d(byte[] bArr) {
        return super.d(bArr);
    }

    @Override // com.umeng.message.proguard.at
    public final /* bridge */ /* synthetic */ byte[] e(byte[] bArr) {
        return super.e(bArr);
    }

    @Override // com.umeng.message.proguard.at
    final void b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f8007d) {
            return;
        }
        if (i3 < 0) {
            this.f8007d = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            a(this.f8002j);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f8007d = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f8000h;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f8009f = (this.f8009f + 1) % 4;
                    this.f8004l = (this.f8004l << 6) + b2;
                    if (this.f8009f == 0) {
                        byte[] bArr3 = this.f8005b;
                        int i6 = this.f8006c;
                        this.f8006c = i6 + 1;
                        int i7 = this.f8004l;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f8006c;
                        this.f8006c = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f8006c;
                        this.f8006c = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f8007d || this.f8009f == 0) {
            return;
        }
        a(this.f8002j);
        int i10 = this.f8009f;
        if (i10 == 2) {
            this.f8004l >>= 4;
            byte[] bArr4 = this.f8005b;
            int i11 = this.f8006c;
            this.f8006c = i11 + 1;
            bArr4[i11] = (byte) (this.f8004l & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f8004l >>= 2;
        byte[] bArr5 = this.f8005b;
        int i12 = this.f8006c;
        this.f8006c = i12 + 1;
        int i13 = this.f8004l;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f8006c;
        this.f8006c = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    public static byte[] b(byte[] bArr) {
        return f(bArr);
    }

    public static String a(byte[] bArr) {
        return new String(f(bArr));
    }

    public static byte[] a(String str) {
        return super.b(str);
    }
}
