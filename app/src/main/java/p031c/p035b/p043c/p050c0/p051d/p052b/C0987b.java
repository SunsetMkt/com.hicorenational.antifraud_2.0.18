package p031c.p035b.p043c.p050c0.p051d.p052b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p062f0.p064d.C1087d;
import p031c.p035b.p043c.p062f0.p064d.C1088e;
import p031c.p035b.p043c.p062f0.p064d.C1089f;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: MultiFinderPatternFinder.java */
/* renamed from: c.b.c.c0.d.b.b */
/* loaded from: classes.dex */
final class C0987b extends C1088e {

    /* renamed from: i */
    private static final C1089f[] f1768i = new C1089f[0];

    /* renamed from: j */
    private static final float f1769j = 180.0f;

    /* renamed from: k */
    private static final float f1770k = 9.0f;

    /* renamed from: l */
    private static final float f1771l = 0.05f;

    /* renamed from: m */
    private static final float f1772m = 0.5f;

    /* compiled from: MultiFinderPatternFinder.java */
    /* renamed from: c.b.c.c0.d.b.b$b */
    private static final class b implements Comparator<C1087d>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(C1087d c1087d, C1087d c1087d2) {
            double m1807d = c1087d2.m1807d() - c1087d.m1807d();
            if (m1807d < 0.0d) {
                return -1;
            }
            return m1807d > 0.0d ? 1 : 0;
        }
    }

    C0987b(C1163b c1163b) {
        super(c1163b);
    }

    /* renamed from: c */
    private C1087d[][] m1358c() throws C1102m {
        List<C1087d> m1820b = m1820b();
        int size = m1820b.size();
        int i2 = 3;
        if (size < 3) {
            throw C1102m.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new C1087d[][]{new C1087d[]{m1820b.get(0), m1820b.get(1), m1820b.get(2)}};
        }
        Collections.sort(m1820b, new b());
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < size - 2) {
            C1087d c1087d = m1820b.get(i3);
            if (c1087d != null) {
                int i4 = i3 + 1;
                while (i4 < size - 1) {
                    C1087d c1087d2 = m1820b.get(i4);
                    if (c1087d2 != null) {
                        float m1807d = (c1087d.m1807d() - c1087d2.m1807d()) / Math.min(c1087d.m1807d(), c1087d2.m1807d());
                        float abs = Math.abs(c1087d.m1807d() - c1087d2.m1807d());
                        float f2 = f1771l;
                        float f3 = f1772m;
                        if (abs > f1772m && m1807d >= f1771l) {
                            break;
                        }
                        int i5 = i4 + 1;
                        while (i5 < size) {
                            C1087d c1087d3 = m1820b.get(i5);
                            if (c1087d3 != null) {
                                float m1807d2 = (c1087d2.m1807d() - c1087d3.m1807d()) / Math.min(c1087d2.m1807d(), c1087d3.m1807d());
                                if (Math.abs(c1087d2.m1807d() - c1087d3.m1807d()) > f3 && m1807d2 >= f2) {
                                    break;
                                }
                                C1087d[] c1087dArr = new C1087d[i2];
                                c1087dArr[c2] = c1087d;
                                c1087dArr[1] = c1087d2;
                                c1087dArr[2] = c1087d3;
                                C1109t.m1921a(c1087dArr);
                                C1089f c1089f = new C1089f(c1087dArr);
                                float m1919a = C1109t.m1919a(c1089f.m1822b(), c1089f.m1821a());
                                float m1919a2 = C1109t.m1919a(c1089f.m1823c(), c1089f.m1821a());
                                float m1919a3 = C1109t.m1919a(c1089f.m1822b(), c1089f.m1823c());
                                float m1807d3 = (m1919a + m1919a3) / (c1087d.m1807d() * 2.0f);
                                if (m1807d3 <= f1769j && m1807d3 >= f1770k && Math.abs((m1919a - m1919a3) / Math.min(m1919a, m1919a3)) < 0.1f) {
                                    float sqrt = (float) Math.sqrt((m1919a * m1919a) + (m1919a3 * m1919a3));
                                    if (Math.abs((m1919a2 - sqrt) / Math.min(m1919a2, sqrt)) < 0.1f) {
                                        arrayList.add(c1087dArr);
                                    }
                                }
                            }
                            i5++;
                            i2 = 3;
                            c2 = 0;
                            f2 = f1771l;
                            f3 = f1772m;
                        }
                    }
                    i4++;
                    i2 = 3;
                    c2 = 0;
                }
            }
            i3++;
            i2 = 3;
            c2 = 0;
        }
        if (arrayList.isEmpty()) {
            throw C1102m.getNotFoundInstance();
        }
        return (C1087d[][]) arrayList.toArray(new C1087d[arrayList.size()][]);
    }

    /* renamed from: b */
    public C1089f[] m1359b(Map<EnumC1044e, ?> map) throws C1102m {
        boolean z = map != null && map.containsKey(EnumC1044e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(EnumC1044e.PURE_BARCODE);
        C1163b m1818a = m1818a();
        int m2177d = m1818a.m2177d();
        int m2181g = m1818a.m2181g();
        int i2 = (int) ((m2177d / 228.0f) * 3.0f);
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        for (int i3 = i2 - 1; i3 < m2177d; i3 += i2) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < m2181g; i5++) {
                if (m1818a.m2173b(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (C1088e.m1810a(iArr) && m1819a(iArr, i3, i5, z2)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i4 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
            }
            if (C1088e.m1810a(iArr)) {
                m1819a(iArr, i3, m2181g, z2);
            }
        }
        C1087d[][] m1358c = m1358c();
        ArrayList arrayList = new ArrayList();
        for (C1087d[] c1087dArr : m1358c) {
            C1109t.m1921a(c1087dArr);
            arrayList.add(new C1089f(c1087dArr));
        }
        return arrayList.isEmpty() ? f1768i : (C1089f[]) arrayList.toArray(new C1089f[arrayList.size()]);
    }

    C0987b(C1163b c1163b, InterfaceC1110u interfaceC1110u) {
        super(c1163b, interfaceC1110u);
    }
}
