package p324i.p325a.p326a.p327a.p328k;

import com.umeng.analytics.pro.C3393cw;
import java.math.BigInteger;
import okio.Utf8;

/* compiled from: Base64.java */
/* renamed from: i.a.a.a.k.d */
/* loaded from: classes2.dex */
public class C5769d extends AbstractC5772g {

    /* renamed from: A */
    static final byte[] f20772A = {C3393cw.f11871k, 10};

    /* renamed from: B */
    private static final byte[] f20773B = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: C */
    private static final byte[] f20774C = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: D */
    private static final byte[] f20775D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: E */
    private static final int f20776E = 63;

    /* renamed from: x */
    private static final int f20777x = 6;

    /* renamed from: y */
    private static final int f20778y = 3;

    /* renamed from: z */
    private static final int f20779z = 4;

    /* renamed from: r */
    private final byte[] f20780r;

    /* renamed from: s */
    private final byte[] f20781s;

    /* renamed from: t */
    private final byte[] f20782t;

    /* renamed from: u */
    private final int f20783u;

    /* renamed from: v */
    private final int f20784v;

    /* renamed from: w */
    private int f20785w;

    public C5769d() {
        this(0);
    }

    /* renamed from: c */
    public static boolean m24161c(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = f20775D;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static byte[] m24164e(byte[] bArr) {
        return new C5769d().decode(bArr);
    }

    /* renamed from: f */
    public static BigInteger m24165f(byte[] bArr) {
        return new BigInteger(1, m24164e(bArr));
    }

    /* renamed from: g */
    public static byte[] m24166g(byte[] bArr) {
        return m24160b(bArr, false);
    }

    /* renamed from: h */
    public static byte[] m24167h(byte[] bArr) {
        return m24160b(bArr, true);
    }

    /* renamed from: i */
    public static String m24168i(byte[] bArr) {
        return C5777l.m24217f(m24160b(bArr, false));
    }

    /* renamed from: j */
    public static byte[] m24169j(byte[] bArr) {
        return m24157a(bArr, false, true);
    }

    /* renamed from: k */
    public static String m24170k(byte[] bArr) {
        return C5777l.m24217f(m24157a(bArr, false, true));
    }

    /* renamed from: l */
    public static boolean m24171l(byte[] bArr) {
        return m24172m(bArr);
    }

    /* renamed from: m */
    public static boolean m24172m(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!m24161c(bArr[i2]) && !AbstractC5772g.m24174b(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // p324i.p325a.p326a.p327a.p328k.AbstractC5772g
    /* renamed from: a */
    void mo24153a(byte[] bArr, int i2, int i3) {
        byte b2;
        if (this.f20800i) {
            return;
        }
        if (i3 < 0) {
            this.f20800i = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            m24178a(this.f20783u);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                this.f20800i = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f20775D;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.f20802k = (this.f20802k + 1) % 4;
                    this.f20785w = (this.f20785w << 6) + b2;
                    if (this.f20802k == 0) {
                        byte[] bArr3 = this.f20797f;
                        int i6 = this.f20798g;
                        this.f20798g = i6 + 1;
                        int i7 = this.f20785w;
                        bArr3[i6] = (byte) ((i7 >> 16) & 255);
                        int i8 = this.f20798g;
                        this.f20798g = i8 + 1;
                        bArr3[i8] = (byte) ((i7 >> 8) & 255);
                        int i9 = this.f20798g;
                        this.f20798g = i9 + 1;
                        bArr3[i9] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f20800i || this.f20802k == 0) {
            return;
        }
        m24178a(this.f20783u);
        int i10 = this.f20802k;
        if (i10 == 2) {
            this.f20785w >>= 4;
            byte[] bArr4 = this.f20797f;
            int i11 = this.f20798g;
            this.f20798g = i11 + 1;
            bArr4[i11] = (byte) (this.f20785w & 255);
            return;
        }
        if (i10 != 3) {
            return;
        }
        this.f20785w >>= 2;
        byte[] bArr5 = this.f20797f;
        int i12 = this.f20798g;
        this.f20798g = i12 + 1;
        int i13 = this.f20785w;
        bArr5[i12] = (byte) ((i13 >> 8) & 255);
        int i14 = this.f20798g;
        this.f20798g = i14 + 1;
        bArr5[i14] = (byte) (i13 & 255);
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
                m24178a(this.f20784v);
                this.f20802k = (this.f20802k + 1) % 3;
                int i6 = i4 + 1;
                int i7 = bArr[i4];
                if (i7 < 0) {
                    i7 += 256;
                }
                this.f20785w = (this.f20785w << 8) + i7;
                if (this.f20802k == 0) {
                    byte[] bArr2 = this.f20797f;
                    int i8 = this.f20798g;
                    this.f20798g = i8 + 1;
                    byte[] bArr3 = this.f20780r;
                    int i9 = this.f20785w;
                    bArr2[i8] = bArr3[(i9 >> 18) & 63];
                    int i10 = this.f20798g;
                    this.f20798g = i10 + 1;
                    bArr2[i10] = bArr3[(i9 >> 12) & 63];
                    int i11 = this.f20798g;
                    this.f20798g = i11 + 1;
                    bArr2[i11] = bArr3[(i9 >> 6) & 63];
                    int i12 = this.f20798g;
                    this.f20798g = i12 + 1;
                    bArr2[i12] = bArr3[i9 & 63];
                    this.f20801j += 4;
                    int i13 = this.f20795d;
                    if (i13 > 0 && i13 <= this.f20801j) {
                        byte[] bArr4 = this.f20782t;
                        System.arraycopy(bArr4, 0, bArr2, this.f20798g, bArr4.length);
                        this.f20798g += this.f20782t.length;
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
        m24178a(this.f20784v);
        int i14 = this.f20798g;
        int i15 = this.f20802k;
        if (i15 == 1) {
            byte[] bArr5 = this.f20797f;
            this.f20798g = i14 + 1;
            byte[] bArr6 = this.f20780r;
            int i16 = this.f20785w;
            bArr5[i14] = bArr6[(i16 >> 2) & 63];
            int i17 = this.f20798g;
            this.f20798g = i17 + 1;
            bArr5[i17] = bArr6[(i16 << 4) & 63];
            if (bArr6 == f20773B) {
                int i18 = this.f20798g;
                this.f20798g = i18 + 1;
                bArr5[i18] = 61;
                int i19 = this.f20798g;
                this.f20798g = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.f20797f;
            this.f20798g = i14 + 1;
            byte[] bArr8 = this.f20780r;
            int i20 = this.f20785w;
            bArr7[i14] = bArr8[(i20 >> 10) & 63];
            int i21 = this.f20798g;
            this.f20798g = i21 + 1;
            bArr7[i21] = bArr8[(i20 >> 4) & 63];
            int i22 = this.f20798g;
            this.f20798g = i22 + 1;
            bArr7[i22] = bArr8[(i20 << 2) & 63];
            if (bArr8 == f20773B) {
                int i23 = this.f20798g;
                this.f20798g = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.f20801j;
        int i25 = this.f20798g;
        this.f20801j = i24 + (i25 - i14);
        if (this.f20795d <= 0 || this.f20801j <= 0) {
            return;
        }
        byte[] bArr9 = this.f20782t;
        System.arraycopy(bArr9, 0, this.f20797f, i25, bArr9.length);
        this.f20798g += this.f20782t.length;
    }

    /* renamed from: d */
    public boolean m24173d() {
        return this.f20780r == f20774C;
    }

    public C5769d(boolean z) {
        this(76, f20772A, z);
    }

    /* renamed from: c */
    public static byte[] m24162c(String str) {
        return new C5769d().m24181a(str);
    }

    /* renamed from: d */
    public static boolean m24163d(String str) {
        return m24172m(C5777l.m24218f(str));
    }

    public C5769d(int i2) {
        this(i2, f20772A);
    }

    public C5769d(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public C5769d(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.f20781s = f20775D;
        if (bArr != null) {
            if (m24179a(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + C5777l.m24217f(bArr) + "]");
            }
            if (i2 > 0) {
                this.f20784v = bArr.length + 4;
                this.f20782t = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.f20782t, 0, bArr.length);
            } else {
                this.f20784v = 4;
                this.f20782t = null;
            }
        } else {
            this.f20784v = 4;
            this.f20782t = null;
        }
        this.f20783u = this.f20784v - 1;
        this.f20780r = z ? f20774C : f20773B;
    }

    /* renamed from: a */
    public static byte[] m24157a(byte[] bArr, boolean z, boolean z2) {
        return m24158a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m24158a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5769d c5769d = z ? new C5769d(z2) : new C5769d(0, f20772A, z2);
        long m24188d = c5769d.m24188d(bArr);
        if (m24188d <= i2) {
            return c5769d.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m24188d + ") than the specified maximum size of " + i2);
    }

    /* renamed from: a */
    public static byte[] m24156a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return m24160b(m24159b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Override // p324i.p325a.p326a.p327a.p328k.AbstractC5772g
    /* renamed from: a */
    protected boolean mo24154a(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f20781s;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static byte[] m24160b(byte[] bArr, boolean z) {
        return m24157a(bArr, z, false);
    }

    /* renamed from: b */
    static byte[] m24159b(BigInteger bigInteger) {
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
}
