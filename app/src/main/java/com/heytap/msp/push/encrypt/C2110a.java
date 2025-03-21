package com.heytap.msp.push.encrypt;

import com.umeng.analytics.pro.C3393cw;
import java.math.BigInteger;
import okio.Utf8;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* renamed from: com.heytap.msp.push.encrypt.a */
/* loaded from: classes.dex */
public class C2110a extends AbstractC2111b {

    /* renamed from: m */
    private static final int f6268m = 6;

    /* renamed from: n */
    private static final int f6269n = 3;

    /* renamed from: o */
    private static final int f6270o = 4;

    /* renamed from: s */
    private static final int f6274s = 63;

    /* renamed from: t */
    private final byte[] f6275t;

    /* renamed from: u */
    private final byte[] f6276u;

    /* renamed from: v */
    private final byte[] f6277v;

    /* renamed from: w */
    private final int f6278w;

    /* renamed from: x */
    private final int f6279x;

    /* renamed from: y */
    private int f6280y;

    /* renamed from: a */
    static final byte[] f6267a = {C3393cw.f11871k, 10};

    /* renamed from: p */
    private static final byte[] f6271p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: q */
    private static final byte[] f6272q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: r */
    private static final byte[] f6273r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public C2110a() {
        this(0);
    }

    public C2110a(int i2) {
        this(i2, f6267a);
    }

    public C2110a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2110a(int r5, byte[] r6, boolean r7) {
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
            byte[] r1 = com.heytap.msp.push.encrypt.C2110a.f6273r
            r4.f6276u = r1
            r1 = 0
            if (r6 == 0) goto L4a
            boolean r3 = r4.m5949l(r6)
            if (r3 != 0) goto L2a
            if (r5 <= 0) goto L4a
            int r5 = r6.length
            int r5 = r5 + r2
            r4.f6279x = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.f6277v = r5
            byte[] r5 = r4.f6277v
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
            r4.f6279x = r2
            r4.f6277v = r1
        L4e:
            int r5 = r4.f6279x
            int r5 = r5 + (-1)
            r4.f6278w = r5
            if (r7 == 0) goto L59
            byte[] r5 = com.heytap.msp.push.encrypt.C2110a.f6272q
            goto L5b
        L59:
            byte[] r5 = com.heytap.msp.push.encrypt.C2110a.f6271p
        L5b:
            r4.f6275t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.msp.push.encrypt.C2110a.<init>(int, byte[], boolean):void");
    }

    public C2110a(boolean z) {
        this(76, f6267a, z);
    }

    /* renamed from: a */
    public static boolean m5915a(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = f6273r;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m5916a(String str) {
        return m5922b(C5777l.m24218f(str));
    }

    /* renamed from: a */
    public static boolean m5917a(byte[] bArr) {
        return m5922b(bArr);
    }

    /* renamed from: a */
    public static byte[] m5918a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return m5919a(m5924b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    /* renamed from: a */
    public static byte[] m5919a(byte[] bArr, boolean z) {
        return m5920a(bArr, z, false);
    }

    /* renamed from: a */
    public static byte[] m5920a(byte[] bArr, boolean z, boolean z2) {
        return m5921a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m5921a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C2110a c2110a = z ? new C2110a(z2) : new C2110a(0, f6267a, z2);
        long m5950m = c2110a.m5950m(bArr);
        if (m5950m <= i2) {
            return c2110a.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m5950m + ") than the specified maximum size of " + i2);
    }

    /* renamed from: b */
    public static boolean m5922b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!m5915a(bArr[i2]) && !AbstractC2111b.m5937c(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m5923b(String str) {
        return new C2110a().m5944c(str);
    }

    /* renamed from: b */
    static byte[] m5924b(BigInteger bigInteger) {
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

    /* renamed from: c */
    public static byte[] m5925c(byte[] bArr) {
        return m5919a(bArr, false);
    }

    /* renamed from: d */
    public static String m5926d(byte[] bArr) {
        return C5777l.m24217f(m5919a(bArr, false));
    }

    /* renamed from: e */
    public static byte[] m5927e(byte[] bArr) {
        return m5920a(bArr, false, true);
    }

    /* renamed from: f */
    public static String m5928f(byte[] bArr) {
        return C5777l.m24217f(m5920a(bArr, false, true));
    }

    /* renamed from: g */
    public static byte[] m5929g(byte[] bArr) {
        return m5919a(bArr, true);
    }

    /* renamed from: h */
    public static byte[] m5930h(byte[] bArr) {
        return new C2110a().decode(bArr);
    }

    /* renamed from: i */
    public static BigInteger m5931i(byte[] bArr) {
        return new BigInteger(1, m5930h(bArr));
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC2111b
    /* renamed from: a */
    void mo5932a(byte[] bArr, int i2, int i3) {
        if (this.f6291j) {
            return;
        }
        if (i3 >= 0) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < i3) {
                m5939a(this.f6279x);
                this.f6293l = (this.f6293l + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.f6280y = (this.f6280y << 8) + i7;
                if (this.f6293l == 0) {
                    byte[] bArr2 = this.f6289h;
                    int i8 = this.f6290i;
                    this.f6290i = i8 + 1;
                    byte[] bArr3 = this.f6275t;
                    int i9 = this.f6280y;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f6290i;
                    this.f6290i = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f6290i;
                    this.f6290i = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f6290i;
                    this.f6290i = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f6292k += 4;
                    int i13 = this.f6288g;
                    if (i13 > 0 && i13 <= this.f6292k) {
                        byte[] bArr4 = this.f6277v;
                        System.arraycopy(bArr4, 0, bArr2, this.f6290i, bArr4.length);
                        this.f6290i += this.f6277v.length;
                        this.f6292k = 0;
                    }
                }
                i5++;
                i4 = i6;
            }
            return;
        }
        this.f6291j = true;
        if (this.f6293l == 0 && this.f6288g == 0) {
            return;
        }
        m5939a(this.f6279x);
        int i14 = this.f6290i;
        int i15 = this.f6293l;
        if (i15 == 1) {
            byte[] bArr5 = this.f6289h;
            this.f6290i = i14 + 1;
            byte[] bArr6 = this.f6275t;
            int i16 = this.f6280y;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f6290i;
            this.f6290i = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == f6271p) {
                int i18 = this.f6290i;
                this.f6290i = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f6290i;
                this.f6290i = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f6289h;
            this.f6290i = i14 + 1;
            byte[] bArr8 = this.f6275t;
            int i20 = this.f6280y;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f6290i;
            this.f6290i = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f6290i;
            this.f6290i = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == f6271p) {
                int i23 = this.f6290i;
                this.f6290i = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f6292k;
        int i25 = this.f6290i;
        this.f6292k = i24 + (i25 - i14);
        if (this.f6288g <= 0 || this.f6292k <= 0) {
            return;
        }
        byte[] bArr9 = this.f6277v;
        System.arraycopy(bArr9, 0, this.f6289h, i25, bArr9.length);
        this.f6290i += this.f6277v.length;
    }

    /* renamed from: a */
    public boolean m5933a() {
        return this.f6275t == f6272q;
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC2111b
    /* renamed from: b */
    void mo5934b(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f6291j) {
            return;
        }
        if (i3 < 0) {
            this.f6291j = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            m5939a(this.f6278w);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f6291j = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f6273r;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f6293l = (this.f6293l + 1) % 4;
                    this.f6280y = (this.f6280y << 6) + b2;
                    if (this.f6293l == 0) {
                        byte[] bArr3 = this.f6289h;
                        int i6 = this.f6290i;
                        this.f6290i = i6 + 1;
                        int i7 = this.f6280y;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f6290i;
                        this.f6290i = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f6290i;
                        this.f6290i = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f6291j || this.f6293l == 0) {
            return;
        }
        m5939a(this.f6278w);
        int i10 = this.f6293l;
        if (i10 == 2) {
            this.f6280y >>= 4;
            byte[] bArr4 = this.f6289h;
            int i11 = this.f6290i;
            this.f6290i = i11 + 1;
            bArr4[i11] = (byte) (this.f6280y & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f6280y >>= 2;
        byte[] bArr5 = this.f6289h;
        int i12 = this.f6290i;
        this.f6290i = i12 + 1;
        int i13 = this.f6280y;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f6290i;
        this.f6290i = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
    }

    @Override // com.heytap.msp.push.encrypt.AbstractC2111b
    /* renamed from: b */
    protected boolean mo5935b(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f6276u;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}
