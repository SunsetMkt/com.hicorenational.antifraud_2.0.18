package d.b.c.z;

import i.f1;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    private static final String a = Charset.defaultCharset().name();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10030b = "SJIS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10031c = "GB2312";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10032d = "EUC_JP";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10033e = "UTF8";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10034f = "ISO8859_1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f10035g;

    static {
        f10035g = f10030b.equalsIgnoreCase(a) || f10032d.equalsIgnoreCase(a);
    }

    private l() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053 A[PHI: r10
  0x0053: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:32:0x005e, B:41:0x0077, B:26:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(byte[] bArr, Map<d.b.c.e, ?> map) {
        String str;
        byte[] bArr2 = bArr;
        if (map != null && (str = (String) map.get(d.b.c.e.CHARACTER_SET)) != null) {
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
            int i14 = bArr2[i4] & f1.f12066c;
            if (z4) {
                if (i5 > 0) {
                    if ((i14 & 128) == 0) {
                        z4 = false;
                    } else {
                        i5--;
                    }
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
                    if (i14 < 64 || i14 == 127 || i14 > 252) {
                        z3 = false;
                    } else {
                        i6--;
                    }
                } else if (i14 != 128 && i14 != 160 && i14 <= 239) {
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
        return (!z4 || (!z && (i7 + i8) + i9 <= 0)) ? (!z3 || (!f10035g && i10 < 3 && i2 < 3)) ? (z2 && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? f10034f : f10030b : z2 ? f10034f : z3 ? f10030b : z4 ? f10033e : a : f10030b : f10033e;
    }
}
