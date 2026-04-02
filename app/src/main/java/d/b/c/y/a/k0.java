package d.b.c.y.a;

/* JADX INFO: compiled from: WifiResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends u {
    @Override // d.b.c.y.a.u
    public j0 a(d.b.c.r rVar) {
        String strB;
        String strB2 = u.b(rVar);
        if (!strB2.startsWith("WIFI:") || (strB = u.b("S:", strB2, ';', false)) == null || strB.isEmpty()) {
            return null;
        }
        String strB3 = u.b("P:", strB2, ';', false);
        String strB4 = u.b("T:", strB2, ';', false);
        if (strB4 == null) {
            strB4 = "nopass";
        }
        return new j0(strB4, strB, strB3, Boolean.parseBoolean(u.b("H:", strB2, ';', false)));
    }
}
