package c.b.c.y.a;

/* compiled from: ProductResultParser.java */
/* loaded from: classes.dex */
public final class t extends u {
    @Override // c.b.c.y.a.u
    public s a(c.b.c.r rVar) {
        c.b.c.a a2 = rVar.a();
        if (a2 != c.b.c.a.UPC_A && a2 != c.b.c.a.UPC_E && a2 != c.b.c.a.EAN_8 && a2 != c.b.c.a.EAN_13) {
            return null;
        }
        String b2 = u.b(rVar);
        if (u.b(b2, b2.length())) {
            return new s(b2, (a2 == c.b.c.a.UPC_E && b2.length() == 8) ? c.b.c.d0.z.b(b2) : b2);
        }
        return null;
    }
}
