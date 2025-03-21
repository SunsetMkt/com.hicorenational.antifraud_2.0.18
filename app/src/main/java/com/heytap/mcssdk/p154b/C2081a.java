package com.heytap.mcssdk.p154b;

import com.umeng.analytics.pro.C3393cw;
import java.math.BigInteger;
import okio.Utf8;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* renamed from: com.heytap.mcssdk.b.a */
/* loaded from: classes.dex */
public class C2081a extends AbstractC2082b {

    /* renamed from: A */
    static final byte[] f6081A = {C3393cw.f11871k, 10};

    /* renamed from: B */
    private static final byte[] f6082B = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: C */
    private static final byte[] f6083C = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: D */
    private static final byte[] f6084D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: E */
    private static final int f6085E = 63;

    /* renamed from: x */
    private static final int f6086x = 6;

    /* renamed from: y */
    private static final int f6087y = 3;

    /* renamed from: z */
    private static final int f6088z = 4;

    /* renamed from: r */
    private final byte[] f6089r;

    /* renamed from: s */
    private final byte[] f6090s;

    /* renamed from: t */
    private final byte[] f6091t;

    /* renamed from: u */
    private final int f6092u;

    /* renamed from: v */
    private final int f6093v;

    /* renamed from: w */
    private int f6094w;

    public C2081a() {
        this(0);
    }

    public C2081a(int i2) {
        this(i2, f6081A);
    }

    public C2081a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2081a(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 4
            r3 = 3
            r4.<init>(r3, r2, r5, r1)
            byte[] r1 = com.heytap.mcssdk.p154b.C2081a.f6084D
            r4.f6090s = r1
            r1 = 0
            if (r6 == 0) goto L4a
            boolean r3 = r4.m5786c(r6)
            if (r3 != 0) goto L2a
            if (r5 <= 0) goto L4a
            int r5 = r6.length
            int r5 = r5 + r2
            r4.f6093v = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.f6091t = r5
            byte[] r5 = r4.f6091t
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4e
        L2a:
            java.lang.String r5 = p324i.p325a.p326a.p327a.p328k.C5777l.m24217f(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L4a:
            r4.f6093v = r2
            r4.f6091t = r1
        L4e:
            int r5 = r4.f6093v
            int r5 = r5 + (-1)
            r4.f6092u = r5
            if (r7 == 0) goto L59
            byte[] r5 = com.heytap.mcssdk.p154b.C2081a.f6083C
            goto L5b
        L59:
            byte[] r5 = com.heytap.mcssdk.p154b.C2081a.f6082B
        L5b:
            r4.f6089r = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.mcssdk.p154b.C2081a.<init>(int, byte[], boolean):void");
    }

    public C2081a(boolean z) {
        this(76, f6081A, z);
    }

    /* renamed from: a */
    public static byte[] m5752a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return m5756b(m5755b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    /* renamed from: a */
    public static byte[] m5753a(byte[] bArr, boolean z, boolean z2) {
        return m5754a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m5754a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C2081a c2081a = z ? new C2081a(z2) : new C2081a(0, f6081A, z2);
        long m5787d = c2081a.m5787d(bArr);
        if (m5787d <= i2) {
            return c2081a.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m5787d + ") than the specified maximum size of " + i2);
    }

    /* renamed from: b */
    static byte[] m5755b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int i2 = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i2 = 1;
        }
        int i3 = bitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m5756b(byte[] bArr, boolean z) {
        return m5753a(bArr, z, false);
    }

    /* renamed from: c */
    public static boolean m5757c(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = f6084D;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m5758c(String str) {
        return m5761f(C5777l.m24218f(str));
    }

    /* renamed from: d */
    public static byte[] m5759d(String str) {
        return new C2081a().m5780a(str);
    }

    /* renamed from: e */
    public static boolean m5760e(byte[] bArr) {
        return m5761f(bArr);
    }

    /* renamed from: f */
    public static boolean m5761f(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!m5757c(bArr[i2]) && !AbstractC2082b.m5773b(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static byte[] m5762g(byte[] bArr) {
        return m5756b(bArr, false);
    }

    /* renamed from: h */
    public static String m5763h(byte[] bArr) {
        return C5777l.m24217f(m5756b(bArr, false));
    }

    /* renamed from: i */
    public static byte[] m5764i(byte[] bArr) {
        return m5753a(bArr, false, true);
    }

    /* renamed from: j */
    public static String m5765j(byte[] bArr) {
        return C5777l.m24217f(m5753a(bArr, false, true));
    }

    /* renamed from: k */
    public static byte[] m5766k(byte[] bArr) {
        return m5756b(bArr, true);
    }

    /* renamed from: l */
    public static byte[] m5767l(byte[] bArr) {
        return new C2081a().decode(bArr);
    }

    /* renamed from: m */
    public static BigInteger m5768m(byte[] bArr) {
        return new BigInteger(1, m5767l(bArr));
    }

    @Override // com.heytap.mcssdk.p154b.AbstractC2082b
    /* renamed from: a */
    void mo5769a(byte[] bArr, int i2, int i3) {
        if (this.f6109i) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                m5777a(this.f6093v);
                this.f6111k = (this.f6111k + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.f6094w = (this.f6094w << 8) + i7;
                if (this.f6111k == 0) {
                    byte[] bArr2 = this.f6106f;
                    int i8 = this.f6107g;
                    this.f6107g = i8 + 1;
                    byte[] bArr3 = this.f6089r;
                    int i9 = this.f6094w;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f6107g;
                    this.f6107g = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f6107g;
                    this.f6107g = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f6107g;
                    this.f6107g = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f6110j += 4;
                    int i13 = this.f6104d;
                    if (i13 > 0 && i13 <= this.f6110j) {
                        byte[] bArr4 = this.f6091t;
                        System.arraycopy(bArr4, 0, bArr2, this.f6107g, bArr4.length);
                        this.f6107g += this.f6091t.length;
                        this.f6110j = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f6109i = true;
        if (this.f6111k == 0 && this.f6104d == 0) {
            return;
        }
        m5777a(this.f6093v);
        int i14 = this.f6107g;
        int i15 = this.f6111k;
        if (i15 == 1) {
            byte[] bArr5 = this.f6106f;
            this.f6107g = i14 + 1;
            byte[] bArr6 = this.f6089r;
            int i16 = this.f6094w;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f6107g;
            this.f6107g = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == f6082B) {
                int i18 = this.f6107g;
                this.f6107g = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f6107g;
                this.f6107g = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f6106f;
            this.f6107g = i14 + 1;
            byte[] bArr8 = this.f6089r;
            int i20 = this.f6094w;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f6107g;
            this.f6107g = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f6107g;
            this.f6107g = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == f6082B) {
                int i23 = this.f6107g;
                this.f6107g = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f6110j;
        int i25 = this.f6107g;
        this.f6110j = i24 + (i25 - i14);
        if (this.f6104d <= 0 || this.f6110j <= 0) {
            return;
        }
        byte[] bArr9 = this.f6091t;
        System.arraycopy(bArr9, 0, this.f6106f, i25, bArr9.length);
        this.f6107g += this.f6091t.length;
    }

    @Override // com.heytap.mcssdk.p154b.AbstractC2082b
    /* renamed from: a */
    protected boolean mo5770a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f6090s;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.heytap.mcssdk.p154b.AbstractC2082b
    /* renamed from: b */
    void mo5771b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f6109i) {
            return;
        }
        if (i3 < 0) {
            this.f6109i = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            m5777a(this.f6092u);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f6109i = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f6084D;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f6111k = (this.f6111k + 1) % 4;
                    this.f6094w = (this.f6094w << 6) + b2;
                    if (this.f6111k == 0) {
                        byte[] bArr3 = this.f6106f;
                        int i6 = this.f6107g;
                        this.f6107g = i6 + 1;
                        int i7 = this.f6094w;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f6107g;
                        this.f6107g = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f6107g;
                        this.f6107g = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f6109i || this.f6111k == 0) {
            return;
        }
        m5777a(this.f6092u);
        int i10 = this.f6111k;
        if (i10 == 2) {
            this.f6094w >>= 4;
            byte[] bArr4 = this.f6106f;
            int i11 = this.f6107g;
            this.f6107g = i11 + 1;
            bArr4[i11] = (byte) (this.f6094w & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f6094w >>= 2;
        byte[] bArr5 = this.f6106f;
        int i12 = this.f6107g;
        this.f6107g = i12 + 1;
        int i13 = this.f6094w;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f6107g;
        this.f6107g = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    /* renamed from: d */
    public boolean m5772d() {
        return this.f6089r == f6083C;
    }
}
