package p031c.p035b.p043c.p053d0.p054a0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p053d0.AbstractC1034q;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: RSS14Reader.java */
/* renamed from: c.b.c.d0.a0.e */
/* loaded from: classes.dex */
public final class C0994e extends AbstractC0990a {

    /* renamed from: m */
    private static final int[] f1801m = {1, 10, 34, 70, 126};

    /* renamed from: n */
    private static final int[] f1802n = {4, 20, 48, 81};

    /* renamed from: o */
    private static final int[] f1803o = {0, 161, 961, 2015, 2715};

    /* renamed from: p */
    private static final int[] f1804p = {0, 336, 1036, 1516};

    /* renamed from: q */
    private static final int[] f1805q = {8, 6, 4, 3, 1};

    /* renamed from: r */
    private static final int[] f1806r = {2, 4, 6, 8};

    /* renamed from: s */
    private static final int[][] f1807s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: k */
    private final List<C0993d> f1808k = new ArrayList();

    /* renamed from: l */
    private final List<C0993d> f1809l = new ArrayList();

    /* renamed from: b */
    private static C1107r m1393b(C0993d c0993d, C0993d c0993d2) {
        String valueOf = String.valueOf((c0993d.m1379b() * 4537077) + c0993d2.m1379b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        C1109t[] m1380a = c0993d.m1384d().m1380a();
        C1109t[] m1380a2 = c0993d2.m1384d().m1380a();
        return new C1107r(String.valueOf(sb.toString()), null, new C1109t[]{m1380a[0], m1380a[1], m1380a2[0], m1380a2[1]}, EnumC0953a.RSS_14);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m {
        m1389a(this.f1808k, m1388a(c1162a, false, i2, map));
        c1162a.m2162e();
        m1389a(this.f1809l, m1388a(c1162a, true, i2, map));
        c1162a.m2162e();
        int size = this.f1808k.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0993d c0993d = this.f1808k.get(i3);
            if (c0993d.m1383c() > 1) {
                int size2 = this.f1809l.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    C0993d c0993d2 = this.f1809l.get(i4);
                    if (c0993d2.m1383c() > 1 && m1391a(c0993d, c0993d2)) {
                        return m1393b(c0993d, c0993d2);
                    }
                }
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        this.f1808k.clear();
        this.f1809l.clear();
    }

    /* renamed from: a */
    private static void m1389a(Collection<C0993d> collection, C0993d c0993d) {
        if (c0993d == null) {
            return;
        }
        boolean z = false;
        Iterator<C0993d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0993d next = it.next();
            if (next.m1379b() == c0993d.m1379b()) {
                next.m1385e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(c0993d);
    }

    /* renamed from: a */
    private static boolean m1391a(C0993d c0993d, C0993d c0993d2) {
        int m1378a = (c0993d.m1378a() + (c0993d2.m1378a() * 16)) % 79;
        int m1382c = (c0993d.m1384d().m1382c() * 9) + c0993d2.m1384d().m1382c();
        if (m1382c > 72) {
            m1382c--;
        }
        if (m1382c > 8) {
            m1382c--;
        }
        return m1378a == m1382c;
    }

    /* renamed from: a */
    private C0993d m1388a(C1162a c1162a, boolean z, int i2, Map<EnumC1044e, ?> map) {
        try {
            C0992c m1387a = m1387a(c1162a, i2, z, m1392a(c1162a, 0, z));
            InterfaceC1110u interfaceC1110u = map == null ? null : (InterfaceC1110u) map.get(EnumC1044e.NEED_RESULT_POINT_CALLBACK);
            if (interfaceC1110u != null) {
                float f2 = (r2[0] + r2[1]) / 2.0f;
                if (z) {
                    f2 = (c1162a.m2157c() - 1) - f2;
                }
                interfaceC1110u.mo1924a(new C1109t(f2, i2));
            }
            C0991b m1386a = m1386a(c1162a, m1387a, true);
            C0991b m1386a2 = m1386a(c1162a, m1387a, false);
            return new C0993d((m1386a.m1379b() * 1597) + m1386a2.m1379b(), m1386a.m1378a() + (m1386a2.m1378a() * 4), m1387a);
        } catch (C1102m unused) {
            return null;
        }
    }

    /* renamed from: a */
    private C0991b m1386a(C1162a c1162a, C0992c c0992c, boolean z) throws C1102m {
        int[] m1372a = m1372a();
        m1372a[0] = 0;
        m1372a[1] = 0;
        m1372a[2] = 0;
        m1372a[3] = 0;
        m1372a[4] = 0;
        m1372a[5] = 0;
        m1372a[6] = 0;
        m1372a[7] = 0;
        if (z) {
            AbstractC1034q.m1511b(c1162a, c0992c.m1381b()[0], m1372a);
        } else {
            AbstractC1034q.m1509a(c1162a, c0992c.m1381b()[1] + 1, m1372a);
            int i2 = 0;
            for (int length = m1372a.length - 1; i2 < length; length--) {
                int i3 = m1372a[i2];
                m1372a[i2] = m1372a[length];
                m1372a[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float m1367a = AbstractC0990a.m1367a(m1372a) / i4;
        int[] m1376e = m1376e();
        int[] m1374c = m1374c();
        float[] m1377f = m1377f();
        float[] m1375d = m1375d();
        for (int i5 = 0; i5 < m1372a.length; i5++) {
            float f2 = m1372a[i5] / m1367a;
            int i6 = (int) (0.5f + f2);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                m1376e[i7] = i6;
                m1377f[i7] = f2 - i6;
            } else {
                m1374c[i7] = i6;
                m1375d[i7] = f2 - i6;
            }
        }
        m1390a(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = m1376e.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + m1376e[length2];
            i9 += m1376e[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = m1374c.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + m1374c[length3];
            i11 += m1374c[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) == 0 && i11 <= 10 && i11 >= 4) {
                int i13 = (10 - i11) / 2;
                int i14 = f1806r[i13];
                return new C0991b((C0995f.m1395a(m1374c, 9 - i14, false) * f1802n[i13]) + C0995f.m1395a(m1376e, i14, true) + f1804p[i13], i12);
            }
            throw C1102m.getNotFoundInstance();
        }
        if ((i9 & 1) == 0 && i9 <= 12 && i9 >= 4) {
            int i15 = (12 - i9) / 2;
            int i16 = f1805q[i15];
            return new C0991b((C0995f.m1395a(m1376e, i16, false) * f1801m[i15]) + C0995f.m1395a(m1374c, 9 - i16, true) + f1803o[i15], i12);
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private int[] m1392a(C1162a c1162a, int i2, boolean z) throws C1102m {
        int[] m1373b = m1373b();
        m1373b[0] = 0;
        m1373b[1] = 0;
        m1373b[2] = 0;
        m1373b[3] = 0;
        int m2157c = c1162a.m2157c();
        boolean z2 = false;
        while (i2 < m2157c) {
            z2 = !c1162a.m2155b(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < m2157c) {
            if (c1162a.m2155b(i2) ^ z2) {
                m1373b[i4] = m1373b[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (AbstractC0990a.m1371b(m1373b)) {
                        return new int[]{i3, i2};
                    }
                    i3 += m1373b[0] + m1373b[1];
                    m1373b[0] = m1373b[2];
                    m1373b[1] = m1373b[3];
                    m1373b[2] = 0;
                    m1373b[3] = 0;
                    i4--;
                }
                m1373b[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private C0992c m1387a(C1162a c1162a, int i2, boolean z, int[] iArr) throws C1102m {
        int i3;
        int i4;
        boolean m2155b = c1162a.m2155b(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (c1162a.m2155b(i5) ^ m2155b)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] m1373b = m1373b();
        System.arraycopy(m1373b, 0, m1373b, 1, m1373b.length - 1);
        m1373b[0] = i7;
        int m1368a = AbstractC0990a.m1368a(m1373b, f1807s);
        int i8 = iArr[1];
        if (z) {
            int m2157c = (c1162a.m2157c() - 1) - i6;
            i3 = (c1162a.m2157c() - 1) - i8;
            i4 = m2157c;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new C0992c(m1368a, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x003a, code lost:
    
        if (r1 < 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0054, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0053, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0051, code lost:
    
        if (r1 < 4) goto L36;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1390a(boolean r10, int r11) throws p031c.p035b.p043c.C1102m {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p053d0.p054a0.C0994e.m1390a(boolean, int):void");
    }
}
