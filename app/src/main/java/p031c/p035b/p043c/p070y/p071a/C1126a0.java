package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: TelResultParser.java */
/* renamed from: c.b.c.y.a.a0 */
/* loaded from: classes.dex */
public final class C1126a0 extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1161z mo2004a(C1107r c1107r) {
        String str;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("tel:") && !m2128b.startsWith("TEL:")) {
            return null;
        }
        if (m2128b.startsWith("TEL:")) {
            str = "tel:" + m2128b.substring(4);
        } else {
            str = m2128b;
        }
        int indexOf = m2128b.indexOf(63, 4);
        return new C1161z(indexOf < 0 ? m2128b.substring(4) : m2128b.substring(4, indexOf), str, null);
    }
}
