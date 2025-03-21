package p031c.p035b.p043c.p050c0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1105p;

/* compiled from: GenericMultipleBarcodeReader.java */
/* renamed from: c.b.c.c0.b */
/* loaded from: classes.dex */
public final class C0983b implements InterfaceC0984c {

    /* renamed from: b */
    private static final int f1762b = 100;

    /* renamed from: c */
    private static final int f1763c = 4;

    /* renamed from: a */
    private final InterfaceC1105p f1764a;

    public C0983b(InterfaceC1105p interfaceC1105p) {
        this.f1764a = interfaceC1105p;
    }

    /* renamed from: a */
    private void m1353a(C0981c c0981c, Map<EnumC1044e, ?> map, List<C1107r> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        int i5;
        int i6;
        if (i4 > 4) {
            return;
        }
        try {
            C1107r mo1186a = this.f1764a.mo1186a(c0981c, map);
            Iterator<C1107r> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().m1917e().equals(mo1186a.m1917e())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(m1352a(mo1186a, i2, i3));
            }
            C1109t[] m1916d = mo1186a.m1916d();
            if (m1916d == null || m1916d.length == 0) {
                return;
            }
            int m1346c = c0981c.m1346c();
            int m1345b = c0981c.m1345b();
            float f3 = m1345b;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = m1346c;
            for (C1109t c1109t : m1916d) {
                if (c1109t != null) {
                    float m1922a = c1109t.m1922a();
                    float m1923b = c1109t.m1923b();
                    if (m1922a < f6) {
                        f6 = m1922a;
                    }
                    if (m1923b < f3) {
                        f3 = m1923b;
                    }
                    if (m1922a > f4) {
                        f4 = m1922a;
                    }
                    if (m1923b > f5) {
                        f5 = m1923b;
                    }
                }
            }
            if (f6 > 100.0f) {
                f2 = f3;
                i5 = m1345b;
                i6 = m1346c;
                m1353a(c0981c.m1342a(0, 0, (int) f6, m1345b), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f3;
                i5 = m1345b;
                i6 = m1346c;
            }
            if (f2 > 100.0f) {
                m1353a(c0981c.m1342a(0, 0, i6, (int) f2), map, list, i2, i3, i4 + 1);
            }
            if (f4 < i6 - 100) {
                int i7 = (int) f4;
                m1353a(c0981c.m1342a(i7, 0, i6 - i7, i5), map, list, i2 + i7, i3, i4 + 1);
            }
            if (f5 < i5 - 100) {
                int i8 = (int) f5;
                m1353a(c0981c.m1342a(0, i8, i6, i5 - i8), map, list, i2, i3 + i8, i4 + 1);
            }
        } catch (AbstractC1106q unused) {
        }
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1354b(C0981c c0981c) throws C1102m {
        return mo1355b(c0981c, null);
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1355b(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m {
        ArrayList arrayList = new ArrayList();
        m1353a(c0981c, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw C1102m.getNotFoundInstance();
        }
        return (C1107r[]) arrayList.toArray(new C1107r[arrayList.size()]);
    }

    /* renamed from: a */
    private static C1107r m1352a(C1107r c1107r, int i2, int i3) {
        C1109t[] m1916d = c1107r.m1916d();
        if (m1916d == null) {
            return c1107r;
        }
        C1109t[] c1109tArr = new C1109t[m1916d.length];
        for (int i4 = 0; i4 < m1916d.length; i4++) {
            C1109t c1109t = m1916d[i4];
            if (c1109t != null) {
                c1109tArr[i4] = new C1109t(c1109t.m1922a() + i2, c1109t.m1923b() + i3);
            }
        }
        C1107r c1107r2 = new C1107r(c1107r.m1917e(), c1107r.m1914b(), c1109tArr, c1107r.m1910a());
        c1107r2.m1912a(c1107r.m1915c());
        return c1107r2;
    }
}
