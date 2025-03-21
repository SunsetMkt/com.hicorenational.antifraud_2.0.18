package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.p053d0.C1043z;

/* compiled from: ProductResultParser.java */
/* renamed from: c.b.c.y.a.t */
/* loaded from: classes.dex */
public final class C1155t extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1154s mo2004a(C1107r c1107r) {
        EnumC0953a m1910a = c1107r.m1910a();
        if (m1910a != EnumC0953a.UPC_A && m1910a != EnumC0953a.UPC_E && m1910a != EnumC0953a.EAN_8 && m1910a != EnumC0953a.EAN_13) {
            return null;
        }
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (AbstractC1156u.m2131b(m2128b, m2128b.length())) {
            return new C1154s(m2128b, (m1910a == EnumC0953a.UPC_E && m2128b.length() == 8) ? C1043z.m1536b(m2128b) : m2128b);
        }
        return null;
    }
}
