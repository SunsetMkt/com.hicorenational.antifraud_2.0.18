package d.b.c.y.a;

/* JADX INFO: compiled from: ProductResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class t extends u {
    @Override // d.b.c.y.a.u
    public s a(d.b.c.r rVar) {
        d.b.c.a aVarA = rVar.a();
        if (aVarA != d.b.c.a.UPC_A && aVarA != d.b.c.a.UPC_E && aVarA != d.b.c.a.EAN_8 && aVarA != d.b.c.a.EAN_13) {
            return null;
        }
        String strB = u.b(rVar);
        if (u.b(strB, strB.length())) {
            return new s(strB, (aVarA == d.b.c.a.UPC_E && strB.length() == 8) ? d.b.c.d0.z.b(strB) : strB);
        }
        return null;
    }
}
