package c.b.c.y.a;

/* compiled from: WifiResultParser.java */
/* loaded from: classes.dex */
public final class k0 extends u {
    @Override // c.b.c.y.a.u
    public j0 a(c.b.c.r rVar) {
        String b2;
        String b3 = u.b(rVar);
        if (!b3.startsWith("WIFI:") || (b2 = u.b("S:", b3, ';', false)) == null || b2.isEmpty()) {
            return null;
        }
        String b4 = u.b("P:", b3, ';', false);
        String b5 = u.b("T:", b3, ';', false);
        if (b5 == null) {
            b5 = "nopass";
        }
        return new j0(b5, b2, b4, Boolean.parseBoolean(u.b("H:", b3, ';', false)));
    }
}
