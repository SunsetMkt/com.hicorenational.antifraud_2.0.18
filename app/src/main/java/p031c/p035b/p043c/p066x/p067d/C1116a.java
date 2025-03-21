package p031c.p035b.p043c.p066x.p067d;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p066x.C1113a;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1179c;
import p031c.p035b.p043c.p072z.p074n.C1181e;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Decoder.java */
/* renamed from: c.b.c.x.d.a */
/* loaded from: classes.dex */
public final class C1116a {

    /* renamed from: b */
    private static final String[] f2229b = {"CTRL_PS", AbstractC1191a.f2568g, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c */
    private static final String[] f2230c = {"CTRL_PS", AbstractC1191a.f2568g, "a", "b", C3351bh.f11584aI, "d", "e", "f", "g", C3351bh.f11585aJ, C3351bh.f11581aF, "j", "k", "l", "m", "n", "o", C3351bh.f11576aA, "q", "r", C3351bh.f11580aE, "t", C3351bh.f11586aK, "v", "w", "x", "y", C3351bh.f11582aG, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d */
    private static final String[] f2231d = {"CTRL_PS", AbstractC1191a.f2568g, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", AbstractC1191a.f2606s1, "`", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.WAVE_SEPARATOR, "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e */
    private static final String[] f2232e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".", "/", Constants.COLON_SEPARATOR, ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f */
    private static final String[] f2233f = {"CTRL_PS", AbstractC1191a.f2568g, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", Constants.ACCEPT_TIME_SEPARATOR_SP, ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a */
    private C1113a f2234a;

    /* compiled from: Decoder.java */
    /* renamed from: c.b.c.x.d.a$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2235a = new int[b.values().length];

        static {
            try {
                f2235a[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2235a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2235a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2235a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2235a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Decoder.java */
    /* renamed from: c.b.c.x.d.a$b */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* renamed from: a */
    private static int m1930a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    /* renamed from: b */
    private static String m1935b(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        b bVar3 = bVar2;
        int i2 = 0;
        while (i2 < length) {
            if (bVar2 != b.BINARY) {
                int i3 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int m1931a = m1931a(zArr, i2, i3);
                i2 += i3;
                String m1933a = m1933a(bVar2, m1931a);
                if (m1933a.startsWith("CTRL_")) {
                    b m1932a = m1932a(m1933a.charAt(5));
                    if (m1933a.charAt(6) == 'L') {
                        bVar2 = m1932a;
                        bVar3 = bVar2;
                    } else {
                        bVar2 = m1932a;
                    }
                } else {
                    sb.append(m1933a);
                    bVar2 = bVar3;
                }
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int m1931a2 = m1931a(zArr, i2, 5);
                int i4 = i2 + 5;
                if (m1931a2 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    m1931a2 = m1931a(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i5 = i4;
                int i6 = 0;
                while (true) {
                    if (i6 >= m1931a2) {
                        i2 = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) m1931a(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                bVar2 = bVar3;
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m1936c(boolean[] zArr) {
        return m1935b(zArr);
    }

    /* renamed from: a */
    public C1166e m1937a(C1113a c1113a) throws C1097h {
        this.f2234a = c1113a;
        return new C1166e(null, m1935b(m1934a(m1938a(c1113a.m2202a()))), null, null);
    }

    /* renamed from: a */
    private static b m1932a(char c2) {
        if (c2 == 'B') {
            return b.BINARY;
        }
        if (c2 == 'D') {
            return b.DIGIT;
        }
        if (c2 == 'P') {
            return b.PUNCT;
        }
        if (c2 == 'L') {
            return b.LOWER;
        }
        if (c2 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    /* renamed from: a */
    private static String m1933a(b bVar, int i2) {
        int i3 = a.f2235a[bVar.ordinal()];
        if (i3 == 1) {
            return f2229b[i2];
        }
        if (i3 == 2) {
            return f2230c[i2];
        }
        if (i3 == 3) {
            return f2231d[i2];
        }
        if (i3 == 4) {
            return f2232e[i2];
        }
        if (i3 == 5) {
            return f2233f[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    /* renamed from: a */
    private boolean[] m1934a(boolean[] zArr) throws C1097h {
        C1177a c1177a;
        int i2 = 8;
        if (this.f2234a.m1926d() <= 2) {
            i2 = 6;
            c1177a = C1177a.f2451j;
        } else if (this.f2234a.m1926d() <= 8) {
            c1177a = C1177a.f2455n;
        } else if (this.f2234a.m1926d() <= 22) {
            i2 = 10;
            c1177a = C1177a.f2450i;
        } else {
            i2 = 12;
            c1177a = C1177a.f2449h;
        }
        int m1925c = this.f2234a.m1925c();
        int length = zArr.length / i2;
        if (length >= m1925c) {
            int i3 = length - m1925c;
            int[] iArr = new int[length];
            int length2 = zArr.length % i2;
            int i4 = 0;
            while (i4 < length) {
                iArr[i4] = m1931a(zArr, length2, i2);
                i4++;
                length2 += i2;
            }
            try {
                new C1179c(c1177a).m2254a(iArr, i3);
                int i5 = (1 << i2) - 1;
                int i6 = 0;
                for (int i7 = 0; i7 < m1925c; i7++) {
                    int i8 = iArr[i7];
                    if (i8 == 0 || i8 == i5) {
                        throw C1097h.getFormatInstance();
                    }
                    if (i8 == 1 || i8 == i5 - 1) {
                        i6++;
                    }
                }
                boolean[] zArr2 = new boolean[(m1925c * i2) - i6];
                int i9 = 0;
                for (int i10 = 0; i10 < m1925c; i10++) {
                    int i11 = iArr[i10];
                    if (i11 == 1 || i11 == i5 - 1) {
                        Arrays.fill(zArr2, i9, (i9 + i2) - 1, i11 > 1);
                        i9 += i2 - 1;
                    } else {
                        int i12 = i2 - 1;
                        while (i12 >= 0) {
                            int i13 = i9 + 1;
                            zArr2[i9] = ((1 << i12) & i11) != 0;
                            i12--;
                            i9 = i13;
                        }
                    }
                }
                return zArr2;
            } catch (C1181e e2) {
                throw C1097h.getFormatInstance(e2);
            }
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    boolean[] m1938a(C1163b c1163b) {
        boolean m1927e = this.f2234a.m1927e();
        int m1926d = this.f2234a.m1926d();
        int i2 = m1927e ? (m1926d * 4) + 11 : (m1926d * 4) + 14;
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[m1930a(m1926d, m1927e)];
        int i3 = 2;
        if (m1927e) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[(i5 - i7) - 1] = (i6 - r12) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < m1926d) {
            int i10 = (m1926d - i8) * 4;
            int i11 = m1927e ? i10 + 9 : i10 + 12;
            int i12 = i8 * 2;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 * 2;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i9 + i15 + i16] = c1163b.m2173b(iArr[i17], iArr[i18]);
                    int i19 = iArr[i18];
                    int i20 = i13 - i16;
                    zArr[(i11 * 2) + i9 + i15 + i16] = c1163b.m2173b(i19, iArr[i20]);
                    int i21 = i13 - i14;
                    zArr[(i11 * 4) + i9 + i15 + i16] = c1163b.m2173b(iArr[i20], iArr[i21]);
                    zArr[(i11 * 6) + i9 + i15 + i16] = c1163b.m2173b(iArr[i21], iArr[i17]);
                    i16++;
                    i3 = 2;
                    m1926d = m1926d;
                    m1927e = m1927e;
                }
                i14++;
                i3 = 2;
            }
            i9 += i11 * 8;
            i8++;
            i3 = 2;
        }
        return zArr;
    }

    /* renamed from: a */
    private static int m1931a(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }
}
