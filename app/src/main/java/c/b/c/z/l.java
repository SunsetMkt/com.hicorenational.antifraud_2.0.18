package c.b.c.z;

import h.f1;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3045a = Charset.defaultCharset().name();

    /* renamed from: b, reason: collision with root package name */
    public static final String f3046b = "SJIS";

    /* renamed from: c, reason: collision with root package name */
    public static final String f3047c = "GB2312";

    /* renamed from: d, reason: collision with root package name */
    private static final String f3048d = "EUC_JP";

    /* renamed from: e, reason: collision with root package name */
    private static final String f3049e = "UTF8";

    /* renamed from: f, reason: collision with root package name */
    private static final String f3050f = "ISO8859_1";

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f3051g;

    static {
        f3051g = f3046b.equalsIgnoreCase(f3045a) || f3048d.equalsIgnoreCase(f3045a);
    }

    private l() {
    }

    public static String a(byte[] bArr, Map<c.b.c.e, ?> map) {
        String str;
        byte[] bArr2 = bArr;
        if (map != null && (str = (String) map.get(c.b.c.e.CHARACTER_SET)) != null) {
            return str;
        }
        int length = bArr2.length;
        int i2 = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z2 || z3 || z4)) {
            int i14 = bArr2[i4] & f1.f16099c;
            if (z4) {
                if (i5 > 0) {
                    if ((i14 & 128) != 0) {
                        i5--;
                    }
                    z4 = false;
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) != 0) {
                        i5++;
                        if ((i14 & 32) == 0) {
                            i7++;
                        } else {
                            i5++;
                            if ((i14 & 16) == 0) {
                                i8++;
                            } else {
                                i5++;
                                if ((i14 & 8) == 0) {
                                    i9++;
                                }
                            }
                        }
                    }
                    z4 = false;
                }
            }
            if (z2) {
                if (i14 > 127 && i14 < 160) {
                    z2 = false;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (i14 >= 64 && i14 != 127 && i14 <= 252) {
                        i6--;
                    }
                    z3 = false;
                } else {
                    if (i14 != 128 && i14 != 160 && i14 <= 239) {
                        if (i14 <= 160 || i14 >= 224) {
                            if (i14 > 127) {
                                i6++;
                                int i15 = i12 + 1;
                                if (i15 > i2) {
                                    i2 = i15;
                                    i12 = i2;
                                } else {
                                    i12 = i15;
                                }
                            } else {
                                i12 = 0;
                            }
                            i13 = 0;
                        } else {
                            i3++;
                            int i16 = i13 + 1;
                            if (i16 > i10) {
                                i10 = i16;
                                i13 = i10;
                            } else {
                                i13 = i16;
                            }
                            i12 = 0;
                        }
                    }
                    z3 = false;
                }
            }
            i4++;
            bArr2 = bArr;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        return (!z4 || (!z && (i7 + i8) + i9 <= 0)) ? (!z3 || (!f3051g && i10 < 3 && i2 < 3)) ? (z2 && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? f3050f : f3046b : z2 ? f3050f : z3 ? f3046b : z4 ? f3049e : f3045a : f3046b : f3049e;
    }
}
