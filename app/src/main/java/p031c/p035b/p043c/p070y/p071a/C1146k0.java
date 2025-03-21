package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: WifiResultParser.java */
/* renamed from: c.b.c.y.a.k0 */
/* loaded from: classes.dex */
public final class C1146k0 extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1144j0 mo2004a(C1107r c1107r) {
        String m2129b;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("WIFI:") || (m2129b = AbstractC1156u.m2129b("S:", m2128b, ';', false)) == null || m2129b.isEmpty()) {
            return null;
        }
        String m2129b2 = AbstractC1156u.m2129b("P:", m2128b, ';', false);
        String m2129b3 = AbstractC1156u.m2129b("T:", m2128b, ';', false);
        if (m2129b3 == null) {
            m2129b3 = "nopass";
        }
        return new C1144j0(m2129b3, m2129b, m2129b2, Boolean.parseBoolean(AbstractC1156u.m2129b("H:", m2128b, ';', false)));
    }
}
