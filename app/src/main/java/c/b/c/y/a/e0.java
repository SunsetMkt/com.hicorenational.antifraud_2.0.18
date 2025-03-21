package c.b.c.y.a;

/* compiled from: URLTOResultParser.java */
/* loaded from: classes.dex */
public final class e0 extends u {
    @Override // c.b.c.y.a.u
    public c0 a(c.b.c.r rVar) {
        int indexOf;
        String b2 = u.b(rVar);
        if ((b2.startsWith("urlto:") || b2.startsWith("URLTO:")) && (indexOf = b2.indexOf(58, 6)) >= 0) {
            return new c0(b2.substring(indexOf + 1), indexOf > 6 ? b2.substring(6, indexOf) : null);
        }
        return null;
    }
}
