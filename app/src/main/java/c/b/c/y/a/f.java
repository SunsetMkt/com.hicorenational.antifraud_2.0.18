package c.b.c.y.a;

/* compiled from: BookmarkDoCoMoResultParser.java */
/* loaded from: classes.dex */
public final class f extends a {
    @Override // c.b.c.y.a.u
    public c0 a(c.b.c.r rVar) {
        String e2 = rVar.e();
        if (!e2.startsWith("MEBKM:")) {
            return null;
        }
        String b2 = a.b("TITLE:", e2, true);
        String[] a2 = a.a("URL:", e2, true);
        if (a2 == null) {
            return null;
        }
        String str = a2[0];
        if (d0.e(str)) {
            return new c0(str, b2);
        }
        return null;
    }
}
