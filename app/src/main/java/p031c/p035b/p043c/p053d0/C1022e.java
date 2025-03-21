package p031c.p035b.p043c.p053d0;

import com.luck.picture.lib.camera.CustomCameraView;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: Code39Reader.java */
/* renamed from: c.b.c.d0.e */
/* loaded from: classes.dex */
public final class C1022e extends AbstractC1034q {

    /* renamed from: e */
    static final String f1906e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    /* renamed from: f */
    private static final char[] f1907f = f1906e.toCharArray();

    /* renamed from: g */
    static final int[] f1908g = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, CustomCameraView.BUTTON_STATE_BOTH, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 133, 388, 196, 148, 168, 162, 138, 42};

    /* renamed from: h */
    private static final int f1909h = f1908g[39];

    /* renamed from: a */
    private final boolean f1910a;

    /* renamed from: b */
    private final boolean f1911b;

    /* renamed from: c */
    private final StringBuilder f1912c;

    /* renamed from: d */
    private final int[] f1913d;

    public C1022e() {
        this(false);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        int[] iArr = this.f1913d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f1912c;
        sb.setLength(0);
        int m2158c = c1162a.m2158c(m1487a(c1162a, iArr)[1]);
        int m2157c = c1162a.m2157c();
        while (true) {
            AbstractC1034q.m1509a(c1162a, m2158c, iArr);
            int m1485a = m1485a(iArr);
            if (m1485a < 0) {
                throw C1102m.getNotFoundInstance();
            }
            char m1484a = m1484a(m1485a);
            sb.append(m1484a);
            int i3 = m2158c;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int m2158c2 = c1162a.m2158c(i3);
            if (m1484a == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (m2158c2 - m2158c) - i5;
                if (m2158c2 != m2157c && i7 * 2 < i5) {
                    throw C1102m.getNotFoundInstance();
                }
                if (this.f1910a) {
                    int length = sb.length() - 1;
                    int i8 = 0;
                    for (int i9 = 0; i9 < length; i9++) {
                        i8 += f1906e.indexOf(this.f1912c.charAt(i9));
                    }
                    if (sb.charAt(length) != f1907f[i8 % 43]) {
                        throw C0988d.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw C1102m.getNotFoundInstance();
                }
                float f2 = i2;
                return new C1107r(this.f1911b ? m1486a(sb) : sb.toString(), null, new C1109t[]{new C1109t((r2[1] + r2[0]) / 2.0f, f2), new C1109t(m2158c + (i5 / 2.0f), f2)}, EnumC0953a.CODE_39);
            }
            m2158c = m2158c2;
        }
    }

    public C1022e(boolean z) {
        this(z, false);
    }

    public C1022e(boolean z, boolean z2) {
        this.f1910a = z;
        this.f1911b = z2;
        this.f1912c = new StringBuilder(20);
        this.f1913d = new int[9];
    }

    /* renamed from: a */
    private static int[] m1487a(C1162a c1162a, int[] iArr) throws C1102m {
        int m2157c = c1162a.m2157c();
        int m2158c = c1162a.m2158c(0);
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
                    if (m1485a(iArr) == f1909h && c1162a.m2152a(Math.max(0, i2 - ((m2158c - i2) / 2)), i2, false)) {
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
    private static int m1485a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if (i11 * 2 >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    /* renamed from: a */
    private static char m1484a(int i2) throws C1102m {
        int i3 = 0;
        while (true) {
            int[] iArr = f1908g;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f1907f[i3];
                }
                i3++;
            } else {
                throw C1102m.getNotFoundInstance();
            }
        }
    }

    /* renamed from: a */
    private static String m1486a(CharSequence charSequence) throws C1097h {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c2 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i2 = charAt2 - ' ';
                            } else {
                                if (charAt2 != 'Z') {
                                    throw C1097h.getFormatInstance();
                                }
                                c2 = ':';
                            }
                            sb.append(c2);
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw C1097h.getFormatInstance();
                            }
                            i2 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i2 = charAt2 - '&';
                    } else {
                        if (charAt2 < 'F' || charAt2 > 'W') {
                            throw C1097h.getFormatInstance();
                        }
                        i2 = charAt2 - 11;
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw C1097h.getFormatInstance();
                    }
                    i2 = charAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            }
            i3++;
        }
        return sb.toString();
    }
}
