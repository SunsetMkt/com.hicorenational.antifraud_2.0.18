package p324i.p325a.p326a.p327a.p328k;

import com.umeng.analytics.pro.C3393cw;
import okio.Utf8;

/* compiled from: Base32.java */
/* renamed from: i.a.a.a.k.a */
/* loaded from: classes2.dex */
public class C5766a extends AbstractC5772g {

    /* renamed from: A */
    private static final byte[] f20757A = {C3393cw.f11871k, 10};

    /* renamed from: B */
    private static final byte[] f20758B = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    /* renamed from: C */
    private static final byte[] f20759C = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};

    /* renamed from: D */
    private static final byte[] f20760D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};

    /* renamed from: E */
    private static final byte[] f20761E = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};

    /* renamed from: F */
    private static final int f20762F = 31;

    /* renamed from: x */
    private static final int f20763x = 5;

    /* renamed from: y */
    private static final int f20764y = 8;

    /* renamed from: z */
    private static final int f20765z = 5;

    /* renamed from: r */
    private long f20766r;

    /* renamed from: s */
    private final int f20767s;

    /* renamed from: t */
    private final byte[] f20768t;

    /* renamed from: u */
    private final int f20769u;

    /* renamed from: v */
    private final byte[] f20770v;

    /* renamed from: w */
    private final byte[] f20771w;

    public C5766a() {
        this(false);
    }

    @Override // p324i.p325a.p326a.p327a.p328k.AbstractC5772g
    /* renamed from: a */
    void mo24153a(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f20800i) {
        }
        if (i3 < 0) {
            this.f20800i = true;
        }
        int i4 = 0;
        int i5 = i2;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            if (b3 == 61) {
                this.f20800i = true;
                break;
            }
            m24178a(this.f20767s);
            if (b3 >= 0) {
                byte[] bArr2 = this.f20768t;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f20802k = (this.f20802k + 1) % 8;
                    this.f20766r = (this.f20766r << 5) + b2;
                    if (this.f20802k == 0) {
                        byte[] bArr3 = this.f20797f;
                        int i7 = this.f20798g;
                        this.f20798g = i7 + 1;
                        long j2 = this.f20766r;
                        bArr3[i7] = (byte) ((j2 >> 32) & 255);
                        int i8 = this.f20798g;
                        this.f20798g = i8 + 1;
                        bArr3[i8] = (byte) ((j2 >> 24) & 255);
                        int i9 = this.f20798g;
                        this.f20798g = i9 + 1;
                        bArr3[i9] = (byte) ((j2 >> 16) & 255);
                        int i10 = this.f20798g;
                        this.f20798g = i10 + 1;
                        bArr3[i10] = (byte) ((j2 >> 8) & 255);
                        int i11 = this.f20798g;
                        this.f20798g = i11 + 1;
                        bArr3[i11] = (byte) (j2 & 255);
                    }
                }
            }
            i4++;
            i5 = i6;
        }
        if (!this.f20800i || this.f20802k < 2) {
            return;
        }
        m24178a(this.f20767s);
        switch (this.f20802k) {
            case 2:
                byte[] bArr4 = this.f20797f;
                int i12 = this.f20798g;
                this.f20798g = i12 + 1;
                bArr4[i12] = (byte) ((this.f20766r >> 2) & 255);
                break;
            case 3:
                byte[] bArr5 = this.f20797f;
                int i13 = this.f20798g;
                this.f20798g = i13 + 1;
                bArr5[i13] = (byte) ((this.f20766r >> 7) & 255);
                break;
            case 4:
                this.f20766r >>= 4;
                byte[] bArr6 = this.f20797f;
                int i14 = this.f20798g;
                this.f20798g = i14 + 1;
                long j3 = this.f20766r;
                bArr6[i14] = (byte) ((j3 >> 8) & 255);
                int i15 = this.f20798g;
                this.f20798g = i15 + 1;
                bArr6[i15] = (byte) (j3 & 255);
                break;
            case 5:
                this.f20766r >>= 1;
                byte[] bArr7 = this.f20797f;
                int i16 = this.f20798g;
                this.f20798g = i16 + 1;
                long j4 = this.f20766r;
                bArr7[i16] = (byte) ((j4 >> 16) & 255);
                int i17 = this.f20798g;
                this.f20798g = i17 + 1;
                bArr7[i17] = (byte) ((j4 >> 8) & 255);
                int i18 = this.f20798g;
                this.f20798g = i18 + 1;
                bArr7[i18] = (byte) (j4 & 255);
                break;
            case 6:
                this.f20766r >>= 6;
                byte[] bArr8 = this.f20797f;
                int i19 = this.f20798g;
                this.f20798g = i19 + 1;
                long j5 = this.f20766r;
                bArr8[i19] = (byte) ((j5 >> 16) & 255);
                int i20 = this.f20798g;
                this.f20798g = i20 + 1;
                bArr8[i20] = (byte) ((j5 >> 8) & 255);
                int i21 = this.f20798g;
                this.f20798g = i21 + 1;
                bArr8[i21] = (byte) (j5 & 255);
                break;
            case 7:
                this.f20766r >>= 3;
                byte[] bArr9 = this.f20797f;
                int i22 = this.f20798g;
                this.f20798g = i22 + 1;
                long j6 = this.f20766r;
                bArr9[i22] = (byte) ((j6 >> 24) & 255);
                int i23 = this.f20798g;
                this.f20798g = i23 + 1;
                bArr9[i23] = (byte) ((j6 >> 16) & 255);
                int i24 = this.f20798g;
                this.f20798g = i24 + 1;
                bArr9[i24] = (byte) ((j6 >> 8) & 255);
                int i25 = this.f20798g;
                this.f20798g = i25 + 1;
                bArr9[i25] = (byte) (j6 & 255);
                break;
        }
    }

    @Override // p324i.p325a.p326a.p327a.p328k.AbstractC5772g
    /* renamed from: b */
    void mo24155b(byte[] bArr, int i2, int i3) {
        if (this.f20800i) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                m24178a(this.f20769u);
                this.f20802k = (this.f20802k + 1) % 5;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.f20766r = (this.f20766r << 8) + i7;
                if (this.f20802k == 0) {
                    byte[] bArr2 = this.f20797f;
                    int i8 = this.f20798g;
                    this.f20798g = i8 + 1;
                    byte[] bArr3 = this.f20770v;
                    long j2 = this.f20766r;
                    bArr2[i8] = bArr3[((int) (j2 >> 35)) & 31];
                    int i9 = this.f20798g;
                    this.f20798g = i9 + 1;
                    bArr2[i9] = bArr3[((int) (j2 >> 30)) & 31];
                    int i10 = this.f20798g;
                    this.f20798g = i10 + 1;
                    bArr2[i10] = bArr3[((int) (j2 >> 25)) & 31];
                    int i11 = this.f20798g;
                    this.f20798g = i11 + 1;
                    bArr2[i11] = bArr3[((int) (j2 >> 20)) & 31];
                    int i12 = this.f20798g;
                    this.f20798g = i12 + 1;
                    bArr2[i12] = bArr3[((int) (j2 >> 15)) & 31];
                    int i13 = this.f20798g;
                    this.f20798g = i13 + 1;
                    bArr2[i13] = bArr3[((int) (j2 >> 10)) & 31];
                    int i14 = this.f20798g;
                    this.f20798g = i14 + 1;
                    bArr2[i14] = bArr3[((int) (j2 >> 5)) & 31];
                    int i15 = this.f20798g;
                    this.f20798g = i15 + 1;
                    bArr2[i15] = bArr3[((int) j2) & 31];
                    this.f20801j += 8;
                    int i16 = this.f20795d;
                    if (i16 > 0 && i16 <= this.f20801j) {
                        byte[] bArr4 = this.f20771w;
                        System.arraycopy(bArr4, 0, bArr2, this.f20798g, bArr4.length);
                        this.f20798g += this.f20771w.length;
                        this.f20801j = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f20800i = true;
        if (this.f20802k == 0 && this.f20795d == 0) {
            return;
        }
        m24178a(this.f20769u);
        int i17 = this.f20798g;
        int i18 = this.f20802k;
        if (i18 == 1) {
            byte[] bArr5 = this.f20797f;
            this.f20798g = i17 + 1;
            byte[] bArr6 = this.f20770v;
            long j3 = this.f20766r;
            bArr5[i17] = bArr6[((int) (j3 >> 3)) & 31];
            int i19 = this.f20798g;
            this.f20798g = i19 + 1;
            bArr5[i19] = bArr6[((int) (j3 << 2)) & 31];
            int i20 = this.f20798g;
            this.f20798g = i20 + 1;
            bArr5[i20] = 61;
            int i21 = this.f20798g;
            this.f20798g = i21 + 1;
            bArr5[i21] = 61;
            int i22 = this.f20798g;
            this.f20798g = i22 + 1;
            bArr5[i22] = 61;
            int i23 = this.f20798g;
            this.f20798g = i23 + 1;
            bArr5[i23] = 61;
            int i24 = this.f20798g;
            this.f20798g = i24 + 1;
            bArr5[i24] = 61;
            int i25 = this.f20798g;
            this.f20798g = i25 + 1;
            bArr5[i25] = 61;
        } else if (i18 == 2) {
            byte[] bArr7 = this.f20797f;
            this.f20798g = i17 + 1;
            byte[] bArr8 = this.f20770v;
            long j4 = this.f20766r;
            bArr7[i17] = bArr8[((int) (j4 >> 11)) & 31];
            int i26 = this.f20798g;
            this.f20798g = i26 + 1;
            bArr7[i26] = bArr8[((int) (j4 >> 6)) & 31];
            int i27 = this.f20798g;
            this.f20798g = i27 + 1;
            bArr7[i27] = bArr8[((int) (j4 >> 1)) & 31];
            int i28 = this.f20798g;
            this.f20798g = i28 + 1;
            bArr7[i28] = bArr8[((int) (j4 << 4)) & 31];
            int i29 = this.f20798g;
            this.f20798g = i29 + 1;
            bArr7[i29] = 61;
            int i30 = this.f20798g;
            this.f20798g = i30 + 1;
            bArr7[i30] = 61;
            int i31 = this.f20798g;
            this.f20798g = i31 + 1;
            bArr7[i31] = 61;
            int i32 = this.f20798g;
            this.f20798g = i32 + 1;
            bArr7[i32] = 61;
        } else if (i18 == 3) {
            byte[] bArr9 = this.f20797f;
            this.f20798g = i17 + 1;
            byte[] bArr10 = this.f20770v;
            long j5 = this.f20766r;
            bArr9[i17] = bArr10[((int) (j5 >> 19)) & 31];
            int i33 = this.f20798g;
            this.f20798g = i33 + 1;
            bArr9[i33] = bArr10[((int) (j5 >> 14)) & 31];
            int i34 = this.f20798g;
            this.f20798g = i34 + 1;
            bArr9[i34] = bArr10[((int) (j5 >> 9)) & 31];
            int i35 = this.f20798g;
            this.f20798g = i35 + 1;
            bArr9[i35] = bArr10[((int) (j5 >> 4)) & 31];
            int i36 = this.f20798g;
            this.f20798g = i36 + 1;
            bArr9[i36] = bArr10[((int) (j5 << 1)) & 31];
            int i37 = this.f20798g;
            this.f20798g = i37 + 1;
            bArr9[i37] = 61;
            int i38 = this.f20798g;
            this.f20798g = i38 + 1;
            bArr9[i38] = 61;
            int i39 = this.f20798g;
            this.f20798g = i39 + 1;
            bArr9[i39] = 61;
        } else if (i18 == 4) {
            byte[] bArr11 = this.f20797f;
            this.f20798g = i17 + 1;
            byte[] bArr12 = this.f20770v;
            long j6 = this.f20766r;
            bArr11[i17] = bArr12[((int) (j6 >> 27)) & 31];
            int i40 = this.f20798g;
            this.f20798g = i40 + 1;
            bArr11[i40] = bArr12[((int) (j6 >> 22)) & 31];
            int i41 = this.f20798g;
            this.f20798g = i41 + 1;
            bArr11[i41] = bArr12[((int) (j6 >> 17)) & 31];
            int i42 = this.f20798g;
            this.f20798g = i42 + 1;
            bArr11[i42] = bArr12[((int) (j6 >> 12)) & 31];
            int i43 = this.f20798g;
            this.f20798g = i43 + 1;
            bArr11[i43] = bArr12[((int) (j6 >> 7)) & 31];
            int i44 = this.f20798g;
            this.f20798g = i44 + 1;
            bArr11[i44] = bArr12[((int) (j6 >> 2)) & 31];
            int i45 = this.f20798g;
            this.f20798g = i45 + 1;
            bArr11[i45] = bArr12[((int) (j6 << 3)) & 31];
            int i46 = this.f20798g;
            this.f20798g = i46 + 1;
            bArr11[i46] = 61;
        }
        int i47 = this.f20801j;
        int i48 = this.f20798g;
        this.f20801j = i47 + (i48 - i17);
        if (this.f20795d <= 0 || this.f20801j <= 0) {
            return;
        }
        byte[] bArr13 = this.f20771w;
        System.arraycopy(bArr13, 0, this.f20797f, i48, bArr13.length);
        this.f20798g += this.f20771w.length;
    }

    public C5766a(boolean z) {
        this(0, null, z);
    }

    public C5766a(int i2) {
        this(i2, f20757A);
    }

    public C5766a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public C5766a(int i2, byte[] bArr, boolean z) {
        super(5, 8, i2, bArr == null ? 0 : bArr.length);
        if (z) {
            this.f20770v = f20761E;
            this.f20768t = f20760D;
        } else {
            this.f20770v = f20759C;
            this.f20768t = f20758B;
        }
        if (i2 <= 0) {
            this.f20769u = 8;
            this.f20771w = null;
        } else if (bArr != null) {
            if (!m24179a(bArr)) {
                this.f20769u = bArr.length + 8;
                this.f20771w = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.f20771w, 0, bArr.length);
            } else {
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + C5777l.m24217f(bArr) + "]");
            }
        } else {
            throw new IllegalArgumentException("lineLength " + i2 + " > 0, but lineSeparator is null");
        }
        this.f20767s = this.f20769u - 1;
    }

    @Override // p324i.p325a.p326a.p327a.p328k.AbstractC5772g
    /* renamed from: a */
    public boolean mo24154a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f20768t;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
