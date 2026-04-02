package d.b.c.b0.b;

import com.umeng.analytics.pro.cw;
import d.b.c.z.e;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final char a = '\ufff0';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f9510b = '\ufff1';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char f9511c = '\ufff2';

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f9512d = '\ufff3';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f9513e = '\ufff4';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f9514f = '\ufff5';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f9515g = '\ufff6';

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f9516h = '\ufff7';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f9517i = '\ufff8';

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char f9518j = '\ufff9';

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char f9519k = '\ufffa';

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char f9520l = '\ufffb';

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final char f9521m = '\ufffc';

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final char f9522n = 28;
    private static final char o = 29;
    private static final char p = 30;
    private static final NumberFormat q = new DecimalFormat("000000000");
    private static final NumberFormat r = new DecimalFormat("000");
    private static final String[] s = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb \ufffc\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{\ufffc}~\u007f;<=>?[\\]^_ ,./:@!|\ufffc\ufff5\ufff6\ufffc\ufff0\ufff2\ufff3\ufff4\ufff7", "\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\ufffa\u001c\u001d\u001e\u00db\u00dc\u00dd\u00de\u00df\u00aa\u00ac\u00b1\u00b2\u00b3\u00b5\u00b9\u00ba\u00bc\u00bd\u00be\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\ufffa\u001c\u001d\u001e\ufffb\u00fb\u00fc\u00fd\u00fe\u00ff\u00a1\u00a8\u00ab\u00af\u00b0\u00b4\u00b7\u00b8\u00bb\u00bf\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa\ufffc\ufffc\u001b\ufffb\u001c\u001d\u001e\u001f\u009f\u00a0\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a9\u00ad\u00ae\u00b6\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private b() {
    }

    static e a(byte[] bArr, int i2) {
        String strD;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                strD = new DecimalFormat("0000000000".substring(0, c(bArr))).format(b(bArr));
            } else {
                strD = d(bArr);
            }
            String str = r.format(a(bArr));
            String str2 = r.format(e(bArr));
            sb.append(a(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strD + o + str + o + str2 + o);
            } else {
                sb.insert(0, strD + o + str + o + str2 + o);
            }
        } else if (i2 == 4) {
            sb.append(a(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(a(bArr, 1, 77));
        }
        return new e(bArr, sb.toString(), null, String.valueOf(i2));
    }

    private static int b(byte[] bArr) {
        return a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, cw.f7203k, cw.f7204l, cw.f7205m, cw.f7206n, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static int c(byte[] bArr) {
        return a(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static String d(byte[] bArr) {
        return String.valueOf(new char[]{s[0].charAt(a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), s[0].charAt(a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), s[0].charAt(a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), s[0].charAt(a(bArr, new byte[]{21, 22, 23, 24, cw.f7203k, cw.f7204l})), s[0].charAt(a(bArr, new byte[]{cw.f7205m, cw.f7206n, 17, 18, 7, 8})), s[0].charAt(a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    private static int e(byte[] bArr) {
        return a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int a(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int iA = 0;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                iA += a(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
            }
            return iA;
        }
        throw new IllegalArgumentException();
    }

    private static int a(byte[] bArr) {
        return a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char cCharAt = s[i5].charAt(bArr[i4]);
            switch (cCharAt) {
                case '\ufff0':
                case '\ufff1':
                case '\ufff2':
                case '\ufff3':
                case '\ufff4':
                    i7 = i5;
                    i5 = cCharAt - a;
                    i6 = 1;
                    break;
                case '\ufff5':
                    i6 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case '\ufff6':
                    i6 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case '\ufff7':
                    i5 = 0;
                    i6 = -1;
                    break;
                case '\ufff8':
                    i5 = 1;
                    i6 = -1;
                    break;
                case '\ufff9':
                    i6 = -1;
                    break;
                case '\ufffa':
                default:
                    sb.append(cCharAt);
                    break;
                case '\ufffb':
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << 24;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << 18);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(q.format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i6 - 1;
            if (i6 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\ufffc') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
