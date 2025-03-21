package p031c.p035b.p043c.p062f0.p063c;

import java.util.Map;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1179c;
import p031c.p035b.p043c.p072z.p074n.C1181e;
import p286h.C5230f1;

/* compiled from: Decoder.java */
/* renamed from: c.b.c.f0.c.e */
/* loaded from: classes.dex */
public final class C1078e {

    /* renamed from: a */
    private final C1179c f2122a = new C1179c(C1177a.f2453l);

    /* renamed from: a */
    public C1166e m1759a(boolean[][] zArr) throws C0988d, C1097h {
        return m1760a(zArr, (Map<EnumC1044e, ?>) null);
    }

    /* renamed from: a */
    public C1166e m1760a(boolean[][] zArr, Map<EnumC1044e, ?> map) throws C0988d, C1097h {
        int length = zArr.length;
        C1163b c1163b = new C1163b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    c1163b.m2175c(i3, i2);
                }
            }
        }
        return m1758a(c1163b, map);
    }

    /* renamed from: a */
    public C1166e m1757a(C1163b c1163b) throws C0988d, C1097h {
        return m1758a(c1163b, (Map<EnumC1044e, ?>) null);
    }

    /* renamed from: a */
    public C1166e m1758a(C1163b c1163b, Map<EnumC1044e, ?> map) throws C1097h, C0988d {
        C0988d e2;
        C1074a c1074a = new C1074a(c1163b);
        C1097h c1097h = null;
        try {
            return m1755a(c1074a, map);
        } catch (C0988d e3) {
            e2 = e3;
            try {
                c1074a.m1740e();
                c1074a.m1736a(true);
                c1074a.m1739d();
                c1074a.m1738c();
                c1074a.m1735a();
                C1166e m1755a = m1755a(c1074a, map);
                m1755a.m2189a(new C1082i(true));
                return m1755a;
            } catch (C0988d | C1097h e4) {
                if (c1097h != null) {
                    throw c1097h;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (C1097h e5) {
            e2 = null;
            c1097h = e5;
            c1074a.m1740e();
            c1074a.m1736a(true);
            c1074a.m1739d();
            c1074a.m1738c();
            c1074a.m1735a();
            C1166e m1755a2 = m1755a(c1074a, map);
            m1755a2.m2189a(new C1082i(true));
            return m1755a2;
        }
    }

    /* renamed from: a */
    private C1166e m1755a(C1074a c1074a, Map<EnumC1044e, ?> map) throws C1097h, C0988d {
        C1083j m1739d = c1074a.m1739d();
        EnumC1079f m1765b = c1074a.m1738c().m1765b();
        C1075b[] m1741a = C1075b.m1741a(c1074a.m1737b(), m1739d, m1765b);
        int i2 = 0;
        for (C1075b c1075b : m1741a) {
            i2 += c1075b.m1743b();
        }
        byte[] bArr = new byte[i2];
        int length = m1741a.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C1075b c1075b2 = m1741a[i3];
            byte[] m1742a = c1075b2.m1742a();
            int m1743b = c1075b2.m1743b();
            m1756a(m1742a, m1743b);
            int i5 = i4;
            int i6 = 0;
            while (i6 < m1743b) {
                bArr[i5] = m1742a[i6];
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        return C1077d.m1749a(bArr, m1739d, m1765b, map);
    }

    /* renamed from: a */
    private void m1756a(byte[] bArr, int i2) throws C0988d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & C5230f1.f20085c;
        }
        try {
            this.f2122a.m2254a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (C1181e unused) {
            throw C0988d.getChecksumInstance();
        }
    }
}
