package p031c.p035b.p043c.p072z;

import java.nio.charset.Charset;
import java.util.Map;
import p031c.p035b.p043c.EnumC1044e;
import p286h.C5230f1;

/* compiled from: StringUtils.java */
/* renamed from: c.b.c.z.l */
/* loaded from: classes.dex */
public final class C1173l {

    /* renamed from: a */
    private static final String f2431a = Charset.defaultCharset().name();

    /* renamed from: b */
    public static final String f2432b = "SJIS";

    /* renamed from: c */
    public static final String f2433c = "GB2312";

    /* renamed from: d */
    private static final String f2434d = "EUC_JP";

    /* renamed from: e */
    private static final String f2435e = "UTF8";

    /* renamed from: f */
    private static final String f2436f = "ISO8859_1";

    /* renamed from: g */
    private static final boolean f2437g;

    static {
        f2437g = f2432b.equalsIgnoreCase(f2431a) || f2434d.equalsIgnoreCase(f2431a);
    }

    private C1173l() {
    }

    /* renamed from: a */
    public static String m2220a(byte[] bArr, Map<EnumC1044e, ?> map) {
        String str;
        byte[] bArr2 = bArr;
        if (map != null && (str = (String) map.get(EnumC1044e.CHARACTER_SET)) != null) {
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
            int i14 = bArr2[i4] & C5230f1.f20085c;
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
        return (!z4 || (!z && (i7 + i8) + i9 <= 0)) ? (!z3 || (!f2437g && i10 < 3 && i2 < 3)) ? (z2 && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? f2436f : f2432b : z2 ? f2436f : z3 ? f2432b : z4 ? f2435e : f2431a : f2432b : f2435e;
    }
}
