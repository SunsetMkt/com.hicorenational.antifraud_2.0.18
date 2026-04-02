package d.b.c.y.a;

/* JADX INFO: compiled from: ISBNResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends u {
    @Override // d.b.c.y.a.u
    public o a(d.b.c.r rVar) {
        if (rVar.a() != d.b.c.a.EAN_13) {
            return null;
        }
        String strB = u.b(rVar);
        if (strB.length() != 13) {
            return null;
        }
        if (strB.startsWith("978") || strB.startsWith("979")) {
            return new o(strB);
        }
        return null;
    }
}
