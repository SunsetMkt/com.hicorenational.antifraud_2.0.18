package d.b.c.d0;

import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;
import network.APICode;

/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9640c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f9641d = f9640c.toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9642e = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, FlowControl.STATUS_FLOW_CTRL_ALL, 418, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, 402, 394, 360, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, FlowControl.STATUS_FLOW_CTRL_BRUSH, 406, 410, 364, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, APICode.CODE_EXPRIE, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9643f = f9642e[47];
    private final StringBuilder a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f9644b = new int[6];

    private static String b(CharSequence charSequence) throws d.b.c.h {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i3 >= length - 1) {
                    throw d.b.c.h.getFormatInstance();
                }
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw d.b.c.h.getFormatInstance();
                        }
                        i2 = cCharAt2 - '@';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i2 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i2 = cCharAt2 - 11;
                        } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 + 16;
                        } else if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                            i2 = cCharAt2 + '+';
                        } else {
                            if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                throw d.b.c.h.getFormatInstance();
                            }
                            c2 = '\u007f';
                            sb.append(c2);
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw d.b.c.h.getFormatInstance();
                            }
                            c2 = ':';
                            sb.append(c2);
                        }
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw d.b.c.h.getFormatInstance();
                        }
                        i2 = cCharAt2 + ' ';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        int iC = aVar.c(a(aVar)[1]);
        int iC2 = aVar.c();
        int[] iArr = this.f9644b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.a;
        sb.setLength(0);
        while (true) {
            q.a(aVar, iC, iArr);
            int iA = a(iArr);
            if (iA < 0) {
                throw d.b.c.m.getNotFoundInstance();
            }
            char cA = a(iA);
            sb.append(cA);
            int i3 = iC;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int iC3 = aVar.c(i3);
            if (cA == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                if (iC3 == iC2 || !aVar.b(iC3)) {
                    throw d.b.c.m.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw d.b.c.m.getNotFoundInstance();
                }
                a(sb);
                sb.setLength(sb.length() - 2);
                float f2 = i2;
                return new d.b.c.r(b(sb), null, new d.b.c.t[]{new d.b.c.t((r14[1] + r14[0]) / 2.0f, f2), new d.b.c.t(iC + (i5 / 2.0f), f2)}, d.b.c.a.CODE_93);
            }
            iC = iC3;
        }
    }

    private int[] a(d.b.c.z.a aVar) throws d.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        Arrays.fill(this.f9644b, 0);
        int[] iArr = this.f9644b;
        int length = iArr.length;
        int i2 = iC2;
        boolean z = false;
        int i3 = 0;
        while (iC2 < iC) {
            if (aVar.b(iC2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (a(iArr) == f9643f) {
                        return new int[]{i2, iC2};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            iC2++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int iRound = Math.round((iArr[i5] * 9.0f) / i2);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                int i6 = i4;
                for (int i7 = 0; i7 < iRound; i7++) {
                    i6 = (i6 << 1) | 1;
                }
                i4 = i6;
            } else {
                i4 <<= iRound;
            }
        }
        return i4;
    }

    private static char a(int i2) throws d.b.c.m {
        int i3 = 0;
        while (true) {
            int[] iArr = f9642e;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f9641d[i3];
                }
                i3++;
            } else {
                throw d.b.c.m.getNotFoundInstance();
            }
        }
    }

    private static void a(CharSequence charSequence) throws d.b.c.d {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i2, int i3) throws d.b.c.d {
        int iIndexOf = 0;
        int i4 = 1;
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iIndexOf += f9640c.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i2) != f9641d[iIndexOf % 47]) {
            throw d.b.c.d.getChecksumInstance();
        }
    }
}
