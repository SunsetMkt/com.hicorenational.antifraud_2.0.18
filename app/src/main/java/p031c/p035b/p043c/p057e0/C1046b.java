package p031c.p035b.p043c.p057e0;

import java.util.ArrayList;
import java.util.Map;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.InterfaceC1105p;
import p031c.p035b.p043c.p050c0.InterfaceC0984c;
import p031c.p035b.p043c.p057e0.p058e.C1058j;
import p031c.p035b.p043c.p057e0.p060f.C1062a;
import p031c.p035b.p043c.p057e0.p060f.C1063b;
import p031c.p035b.p043c.p072z.C1166e;

/* compiled from: PDF417Reader.java */
/* renamed from: c.b.c.e0.b */
/* loaded from: classes.dex */
public final class C1046b implements InterfaceC1105p, InterfaceC0984c {
    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C1097h, C0988d {
        return mo1186a(c0981c, (Map<EnumC1044e, ?>) null);
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1354b(C0981c c0981c) throws C1102m {
        return mo1355b(c0981c, (Map<EnumC1044e, ?>) null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C1097h, C0988d {
        C1107r[] m1542a = m1542a(c0981c, map, false);
        if (m1542a == null || m1542a.length == 0 || m1542a[0] == null) {
            throw C1102m.getNotFoundInstance();
        }
        return m1542a[0];
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1355b(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m {
        try {
            return m1542a(c0981c, map, true);
        } catch (C0988d | C1097h unused) {
            throw C1102m.getNotFoundInstance();
        }
    }

    /* renamed from: b */
    private static int m1543b(C1109t c1109t, C1109t c1109t2) {
        if (c1109t == null || c1109t2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(c1109t.m1922a() - c1109t2.m1922a());
    }

    /* renamed from: b */
    private static int m1544b(C1109t[] c1109tArr) {
        return Math.min(Math.min(m1543b(c1109tArr[0], c1109tArr[4]), (m1543b(c1109tArr[6], c1109tArr[2]) * 17) / 18), Math.min(m1543b(c1109tArr[1], c1109tArr[5]), (m1543b(c1109tArr[7], c1109tArr[3]) * 17) / 18));
    }

    /* renamed from: a */
    private static C1107r[] m1542a(C0981c c0981c, Map<EnumC1044e, ?> map, boolean z) throws C1102m, C1097h, C0988d {
        ArrayList arrayList = new ArrayList();
        C1063b m1679a = C1062a.m1679a(c0981c, map, z);
        for (C1109t[] c1109tArr : m1679a.m1686b()) {
            C1166e m1637a = C1058j.m1637a(m1679a.m1685a(), c1109tArr[4], c1109tArr[5], c1109tArr[6], c1109tArr[7], m1544b(c1109tArr), m1541a(c1109tArr));
            C1107r c1107r = new C1107r(m1637a.m2198i(), m1637a.m2195f(), c1109tArr, EnumC0953a.PDF_417);
            c1107r.m1911a(EnumC1108s.ERROR_CORRECTION_LEVEL, m1637a.m2190b());
            C1047c c1047c = (C1047c) m1637a.m2194e();
            if (c1047c != null) {
                c1107r.m1911a(EnumC1108s.PDF417_EXTRA_METADATA, c1047c);
            }
            arrayList.add(c1107r);
        }
        return (C1107r[]) arrayList.toArray(new C1107r[arrayList.size()]);
    }

    /* renamed from: a */
    private static int m1540a(C1109t c1109t, C1109t c1109t2) {
        if (c1109t == null || c1109t2 == null) {
            return 0;
        }
        return (int) Math.abs(c1109t.m1922a() - c1109t2.m1922a());
    }

    /* renamed from: a */
    private static int m1541a(C1109t[] c1109tArr) {
        return Math.max(Math.max(m1540a(c1109tArr[0], c1109tArr[4]), (m1540a(c1109tArr[6], c1109tArr[2]) * 17) / 18), Math.max(m1540a(c1109tArr[1], c1109tArr[5]), (m1540a(c1109tArr[7], c1109tArr[3]) * 17) / 18));
    }
}
