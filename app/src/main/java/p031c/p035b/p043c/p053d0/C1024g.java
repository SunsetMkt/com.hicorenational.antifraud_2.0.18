package p031c.p035b.p043c.p053d0;

import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;
import network.APICode;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: Code93Reader.java */
/* renamed from: c.b.c.d0.g */
/* loaded from: classes.dex */
public final class C1024g extends AbstractC1034q {

    /* renamed from: c */
    private static final String f1914c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* renamed from: d */
    private static final char[] f1915d = f1914c.toCharArray();

    /* renamed from: e */
    private static final int[] f1916e = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, FlowControl.STATUS_FLOW_CTRL_ALL, 418, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, 402, 394, 360, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, FlowControl.STATUS_FLOW_CTRL_BRUSH, 406, 410, 364, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, APICode.CODE_EXPRIE, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE};

    /* renamed from: f */
    private static final int f1917f = f1916e[47];

    /* renamed from: a */
    private final StringBuilder f1918a = new StringBuilder(20);

    /* renamed from: b */
    private final int[] f1919b = new int[6];

    /* renamed from: b */
    private static String m1494b(CharSequence charSequence) throws C1097h {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else {
                if (i3 >= length - 1) {
                    throw C1097h.getFormatInstance();
                }
                i3++;
                char charAt2 = charSequence.charAt(i3);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 - '@';
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw C1097h.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i2 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i2 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i2 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i2 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c2 = 127;
                            sb.append(c2);
                            break;
                        } else {
                            throw C1097h.getFormatInstance();
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i2 = charAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (charAt2 != 'Z') {
                                throw C1097h.getFormatInstance();
                            }
                            c2 = ':';
                            sb.append(c2);
                            break;
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 + ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                            break;
                        } else {
                            throw C1097h.getFormatInstance();
                        }
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            }
            i3++;
        }
        return sb.toString();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        int m2158c = c1162a.m2158c(m1493a(c1162a)[1]);
        int m2157c = c1162a.m2157c();
        int[] iArr = this.f1919b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f1918a;
        sb.setLength(0);
        while (true) {
            AbstractC1034q.m1509a(c1162a, m2158c, iArr);
            int m1490a = m1490a(iArr);
            if (m1490a < 0) {
                throw C1102m.getNotFoundInstance();
            }
            char m1489a = m1489a(m1490a);
            sb.append(m1489a);
            int i3 = m2158c;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int m2158c2 = c1162a.m2158c(i3);
            if (m1489a == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                if (m2158c2 == m2157c || !c1162a.m2155b(m2158c2)) {
                    throw C1102m.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw C1102m.getNotFoundInstance();
                }
                m1491a(sb);
                sb.setLength(sb.length() - 2);
                float f2 = i2;
                return new C1107r(m1494b(sb), null, new C1109t[]{new C1109t((r14[1] + r14[0]) / 2.0f, f2), new C1109t(m2158c + (i5 / 2.0f), f2)}, EnumC0953a.CODE_93);
            }
            m2158c = m2158c2;
        }
    }

    /* renamed from: a */
    private int[] m1493a(C1162a c1162a) throws C1102m {
        int m2157c = c1162a.m2157c();
        int m2158c = c1162a.m2158c(0);
        Arrays.fill(this.f1919b, 0);
        int[] iArr = this.f1919b;
        int length = iArr.length;
        int i2 = m2158c;
        boolean z = false;
        int i3 = 0;
        while (m2158c < m2157c) {
            if (c1162a.m2155b(m2158c) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (m1490a(iArr) == f1917f) {
                        return new int[]{i2, m2158c};
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
            m2158c++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1490a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int round = Math.round((iArr[i5] * 9.0f) / i2);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                int i6 = i4;
                for (int i7 = 0; i7 < round; i7++) {
                    i6 = (i6 << 1) | 1;
                }
                i4 = i6;
            } else {
                i4 <<= round;
            }
        }
        return i4;
    }

    /* renamed from: a */
    private static char m1489a(int i2) throws C1102m {
        int i3 = 0;
        while (true) {
            int[] iArr = f1916e;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f1915d[i3];
                }
                i3++;
            } else {
                throw C1102m.getNotFoundInstance();
            }
        }
    }

    /* renamed from: a */
    private static void m1491a(CharSequence charSequence) throws C0988d {
        int length = charSequence.length();
        m1492a(charSequence, length - 2, 20);
        m1492a(charSequence, length - 1, 15);
    }

    /* renamed from: a */
    private static void m1492a(CharSequence charSequence, int i2, int i3) throws C0988d {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i2 - 1; i6 >= 0; i6--) {
            i4 += f1914c.indexOf(charSequence.charAt(i6)) * i5;
            i5++;
            if (i5 > i3) {
                i5 = 1;
            }
        }
        if (charSequence.charAt(i2) != f1915d[i4 % 47]) {
            throw C0988d.getChecksumInstance();
        }
    }
}
