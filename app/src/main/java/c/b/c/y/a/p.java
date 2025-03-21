package c.b.c.y.a;

/* compiled from: ISBNResultParser.java */
/* loaded from: classes.dex */
public final class p extends u {
    @Override // c.b.c.y.a.u
    public o a(c.b.c.r rVar) {
        if (rVar.a() != c.b.c.a.EAN_13) {
            return null;
        }
        String b2 = u.b(rVar);
        if (b2.length() != 13) {
            return null;
        }
        if (b2.startsWith("978") || b2.startsWith("979")) {
            return new o(b2);
        }
        return null;
    }
}
