package p031c.p035b.p043c.p053d0;

import java.util.Arrays;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: UPCEANReader.java */
/* renamed from: c.b.c.d0.x */
/* loaded from: classes.dex */
public abstract class AbstractC1041x extends AbstractC1034q {

    /* renamed from: d */
    private static final float f1950d = 0.48f;

    /* renamed from: e */
    private static final float f1951e = 0.7f;

    /* renamed from: f */
    static final int[] f1952f = {1, 1, 1};

    /* renamed from: g */
    static final int[] f1953g = {1, 1, 1, 1, 1};

    /* renamed from: h */
    static final int[][] f1954h = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: i */
    static final int[][] f1955i = new int[20][];

    /* renamed from: a */
    private final StringBuilder f1956a = new StringBuilder(20);

    /* renamed from: b */
    private final C1040w f1957b = new C1040w();

    /* renamed from: c */
    private final C1029l f1958c = new C1029l();

    static {
        System.arraycopy(f1954h, 0, f1955i, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = f1954h[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f1955i[i2] = iArr2;
        }
    }

    protected AbstractC1041x() {
    }

    /* renamed from: a */
    static int[] m1530a(C1162a c1162a) throws C1102m {
        int[] iArr = new int[f1952f.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f1952f.length, 0);
            iArr2 = m1532a(c1162a, i2, false, f1952f, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = c1162a.m2152a(i5, i3, false);
            }
            i2 = i4;
        }
        return iArr2;
    }

    /* renamed from: a */
    protected abstract int mo1496a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m;

    /* renamed from: a */
    abstract EnumC0953a mo1497a();

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        return mo1516a(i2, c1162a, m1530a(c1162a), map);
    }

    /* renamed from: a */
    public C1107r mo1516a(int i2, C1162a c1162a, int[] iArr, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        int i3;
        String m1500a;
        InterfaceC1110u interfaceC1110u = map == null ? null : (InterfaceC1110u) map.get(EnumC1044e.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (interfaceC1110u != null) {
            interfaceC1110u.mo1924a(new C1109t((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f1956a;
        sb.setLength(0);
        int mo1496a = mo1496a(c1162a, iArr, sb);
        if (interfaceC1110u != null) {
            interfaceC1110u.mo1924a(new C1109t(mo1496a, i2));
        }
        int[] mo1534a = mo1534a(c1162a, mo1496a);
        if (interfaceC1110u != null) {
            interfaceC1110u.mo1924a(new C1109t((mo1534a[0] + mo1534a[1]) / 2.0f, i2));
        }
        int i4 = mo1534a[1];
        int i5 = (i4 - mo1534a[0]) + i4;
        if (i5 < c1162a.m2157c() && c1162a.m2152a(i4, i5, false)) {
            String sb2 = sb.toString();
            if (sb2.length() >= 8) {
                if (mo1533a(sb2)) {
                    EnumC0953a mo1497a = mo1497a();
                    float f2 = i2;
                    C1107r c1107r = new C1107r(sb2, null, new C1109t[]{new C1109t((iArr[1] + iArr[0]) / 2.0f, f2), new C1109t((mo1534a[1] + mo1534a[0]) / 2.0f, f2)}, mo1497a);
                    try {
                        C1107r m1527a = this.f1957b.m1527a(i2, c1162a, mo1534a[1]);
                        c1107r.m1911a(EnumC1108s.UPC_EAN_EXTENSION, m1527a.m1917e());
                        c1107r.m1912a(m1527a.m1915c());
                        c1107r.m1913a(m1527a.m1916d());
                        i3 = m1527a.m1917e().length();
                    } catch (AbstractC1106q unused) {
                        i3 = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(EnumC1044e.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length = iArr2.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                z = false;
                                break;
                            }
                            if (i3 == iArr2[i6]) {
                                break;
                            }
                            i6++;
                        }
                        if (!z) {
                            throw C1102m.getNotFoundInstance();
                        }
                    }
                    if ((mo1497a == EnumC0953a.EAN_13 || mo1497a == EnumC0953a.UPC_A) && (m1500a = this.f1958c.m1500a(sb2)) != null) {
                        c1107r.m1911a(EnumC1108s.POSSIBLE_COUNTRY, m1500a);
                    }
                    return c1107r;
                }
                throw C0988d.getChecksumInstance();
            }
            throw C1097h.getFormatInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    boolean mo1533a(String str) throws C1097h {
        return m1529a((CharSequence) str);
    }

    /* renamed from: a */
    static boolean m1529a(CharSequence charSequence) throws C1097h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw C1097h.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw C1097h.getFormatInstance();
            }
            i4 += charAt2;
        }
        return i4 % 10 == 0;
    }

    /* renamed from: a */
    int[] mo1534a(C1162a c1162a, int i2) throws C1102m {
        return m1531a(c1162a, i2, false, f1952f);
    }

    /* renamed from: a */
    static int[] m1531a(C1162a c1162a, int i2, boolean z, int[] iArr) throws C1102m {
        return m1532a(c1162a, i2, z, iArr, new int[iArr.length]);
    }

    /* renamed from: a */
    private static int[] m1532a(C1162a c1162a, int i2, boolean z, int[] iArr, int[] iArr2) throws C1102m {
        int length = iArr.length;
        int m2157c = c1162a.m2157c();
        int m2161d = z ? c1162a.m2161d(i2) : c1162a.m2158c(i2);
        int i3 = m2161d;
        int i4 = 0;
        while (m2161d < m2157c) {
            if (c1162a.m2155b(m2161d) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (AbstractC1034q.m1508a(iArr2, iArr, f1951e) < f1950d) {
                        return new int[]{i3, m2161d};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            m2161d++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    static int m1528a(C1162a c1162a, int[] iArr, int i2, int[][] iArr2) throws C1102m {
        AbstractC1034q.m1509a(c1162a, i2, iArr);
        int length = iArr2.length;
        float f2 = f1950d;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float m1508a = AbstractC1034q.m1508a(iArr, iArr2[i4], f1951e);
            if (m1508a < f2) {
                i3 = i4;
                f2 = m1508a;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C1102m.getNotFoundInstance();
    }
}
