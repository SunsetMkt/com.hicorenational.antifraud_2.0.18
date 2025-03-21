package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: URLTOResultParser.java */
/* renamed from: c.b.c.y.a.e0 */
/* loaded from: classes.dex */
public final class C1134e0 extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1130c0 mo2004a(C1107r c1107r) {
        int indexOf;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if ((m2128b.startsWith("urlto:") || m2128b.startsWith("URLTO:")) && (indexOf = m2128b.indexOf(58, 6)) >= 0) {
            return new C1130c0(m2128b.substring(indexOf + 1), indexOf > 6 ? m2128b.substring(6, indexOf) : null);
        }
        return null;
    }
}
