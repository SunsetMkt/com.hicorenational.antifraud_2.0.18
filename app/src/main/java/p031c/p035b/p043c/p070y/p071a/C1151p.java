package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;

/* compiled from: ISBNResultParser.java */
/* renamed from: c.b.c.y.a.p */
/* loaded from: classes.dex */
public final class C1151p extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1150o mo2004a(C1107r c1107r) {
        if (c1107r.m1910a() != EnumC0953a.EAN_13) {
            return null;
        }
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (m2128b.length() != 13) {
            return null;
        }
        if (m2128b.startsWith("978") || m2128b.startsWith("979")) {
            return new C1150o(m2128b);
        }
        return null;
    }
}
