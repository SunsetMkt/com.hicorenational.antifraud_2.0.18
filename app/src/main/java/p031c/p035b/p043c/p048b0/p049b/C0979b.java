package p031c.p035b.p043c.p048b0.p049b;

import com.umeng.analytics.pro.C3393cw;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import p031c.p035b.p043c.p072z.C1166e;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: c.b.c.b0.b.b */
/* loaded from: classes.dex */
final class C0979b {

    /* renamed from: a */
    private static final char f1736a = 65520;

    /* renamed from: b */
    private static final char f1737b = 65521;

    /* renamed from: c */
    private static final char f1738c = 65522;

    /* renamed from: d */
    private static final char f1739d = 65523;

    /* renamed from: e */
    private static final char f1740e = 65524;

    /* renamed from: f */
    private static final char f1741f = 65525;

    /* renamed from: g */
    private static final char f1742g = 65526;

    /* renamed from: h */
    private static final char f1743h = 65527;

    /* renamed from: i */
    private static final char f1744i = 65528;

    /* renamed from: j */
    private static final char f1745j = 65529;

    /* renamed from: k */
    private static final char f1746k = 65530;

    /* renamed from: l */
    private static final char f1747l = 65531;

    /* renamed from: m */
    private static final char f1748m = 65532;

    /* renamed from: n */
    private static final char f1749n = 28;

    /* renamed from: o */
    private static final char f1750o = 29;

    /* renamed from: p */
    private static final char f1751p = 30;

    /* renamed from: q */
    private static final NumberFormat f1752q = new DecimalFormat("000000000");

    /* renamed from: r */
    private static final NumberFormat f1753r = new DecimalFormat("000");

    /* renamed from: s */
    private static final String[] f1754s = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private C0979b() {
    }

    /* renamed from: a */
    static C1166e m1333a(byte[] bArr, int i2) {
        String m1337d;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                m1337d = new DecimalFormat("0000000000".substring(0, m1336c(bArr))).format(m1335b(bArr));
            } else {
                m1337d = m1337d(bArr);
            }
            String format = f1753r.format(m1331a(bArr));
            String format2 = f1753r.format(m1338e(bArr));
            sb.append(m1334a(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, m1337d + f1750o + format + f1750o + format2 + f1750o);
            } else {
                sb.insert(0, m1337d + f1750o + format + f1750o + format2 + f1750o);
            }
        } else if (i2 == 4) {
            sb.append(m1334a(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(m1334a(bArr, 1, 77));
        }
        return new C1166e(bArr, sb.toString(), null, String.valueOf(i2));
    }

    /* renamed from: b */
    private static int m1335b(byte[] bArr) {
        return m1332a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, C3393cw.f11871k, C3393cw.f11872l, C3393cw.f11873m, C3393cw.f11874n, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    /* renamed from: c */
    private static int m1336c(byte[] bArr) {
        return m1332a(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    /* renamed from: d */
    private static String m1337d(byte[] bArr) {
        return String.valueOf(new char[]{f1754s[0].charAt(m1332a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), f1754s[0].charAt(m1332a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), f1754s[0].charAt(m1332a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), f1754s[0].charAt(m1332a(bArr, new byte[]{21, 22, 23, 24, C3393cw.f11871k, C3393cw.f11872l})), f1754s[0].charAt(m1332a(bArr, new byte[]{C3393cw.f11873m, C3393cw.f11874n, 17, 18, 7, 8})), f1754s[0].charAt(m1332a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    /* renamed from: e */
    private static int m1338e(byte[] bArr) {
        return m1332a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    /* renamed from: a */
    private static int m1330a(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    /* renamed from: a */
    private static int m1332a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                i2 += m1330a(bArr2[i3], bArr) << ((bArr2.length - i3) - 1);
            }
            return i2;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m1331a(byte[] bArr) {
        return m1332a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private static String m1334a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char charAt = f1754s[i5].charAt(bArr[i4]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i5;
                    i5 = charAt - f1736a;
                    i6 = 1;
                    break;
                case 65525:
                    i6 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i6 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i5 = 0;
                    i6 = -1;
                    break;
                case 65528:
                    i5 = 1;
                    i6 = -1;
                    break;
                case 65529:
                    i6 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << 24;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << 18);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(f1752q.format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i6 - 1;
            if (i6 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
