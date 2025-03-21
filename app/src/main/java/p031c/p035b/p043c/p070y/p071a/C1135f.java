package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: BookmarkDoCoMoResultParser.java */
/* renamed from: c.b.c.y.a.f */
/* loaded from: classes.dex */
public final class C1135f extends AbstractC1125a {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1130c0 mo2004a(C1107r c1107r) {
        String m1917e = c1107r.m1917e();
        if (!m1917e.startsWith("MEBKM:")) {
            return null;
        }
        String m2003b = AbstractC1125a.m2003b("TITLE:", m1917e, true);
        String[] m2002a = AbstractC1125a.m2002a("URL:", m1917e, true);
        if (m2002a == null) {
            return null;
        }
        String str = m2002a[0];
        if (C1132d0.m2031e(str)) {
            return new C1130c0(str, m2003b);
        }
        return null;
    }
}
