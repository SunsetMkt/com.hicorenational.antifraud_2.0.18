package p031c.p035b.p043c.p050c0;

import java.util.Map;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1105p;

/* compiled from: ByQuadrantReader.java */
/* renamed from: c.b.c.c0.a */
/* loaded from: classes.dex */
public final class C0982a implements InterfaceC1105p {

    /* renamed from: a */
    private final InterfaceC1105p f1761a;

    public C0982a(InterfaceC1105p interfaceC1105p) {
        this.f1761a = interfaceC1105p;
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C0988d, C1097h {
        return mo1186a(c0981c, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        this.f1761a.reset();
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        int m1346c = c0981c.m1346c() / 2;
        int m1345b = c0981c.m1345b() / 2;
        try {
            try {
                try {
                    try {
                        return this.f1761a.mo1186a(c0981c.m1342a(0, 0, m1346c, m1345b), map);
                    } catch (C1102m unused) {
                        C1107r mo1186a = this.f1761a.mo1186a(c0981c.m1342a(m1346c, 0, m1346c, m1345b), map);
                        m1351a(mo1186a.m1916d(), m1346c, 0);
                        return mo1186a;
                    }
                } catch (C1102m unused2) {
                    int i2 = m1346c / 2;
                    int i3 = m1345b / 2;
                    C1107r mo1186a2 = this.f1761a.mo1186a(c0981c.m1342a(i2, i3, m1346c, m1345b), map);
                    m1351a(mo1186a2.m1916d(), i2, i3);
                    return mo1186a2;
                }
            } catch (C1102m unused3) {
                C1107r mo1186a3 = this.f1761a.mo1186a(c0981c.m1342a(0, m1345b, m1346c, m1345b), map);
                m1351a(mo1186a3.m1916d(), 0, m1345b);
                return mo1186a3;
            }
        } catch (C1102m unused4) {
            C1107r mo1186a4 = this.f1761a.mo1186a(c0981c.m1342a(m1346c, m1345b, m1346c, m1345b), map);
            m1351a(mo1186a4.m1916d(), m1346c, m1345b);
            return mo1186a4;
        }
    }

    /* renamed from: a */
    private static void m1351a(C1109t[] c1109tArr, int i2, int i3) {
        if (c1109tArr != null) {
            for (int i4 = 0; i4 < c1109tArr.length; i4++) {
                C1109t c1109t = c1109tArr[i4];
                c1109tArr[i4] = new C1109t(c1109t.m1922a() + i2, c1109t.m1923b() + i3);
            }
        }
    }
}
