package d.b.c.y.a;

/* JADX INFO: compiled from: BookmarkDoCoMoResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a {
    @Override // d.b.c.y.a.u
    public c0 a(d.b.c.r rVar) {
        String strE = rVar.e();
        if (!strE.startsWith("MEBKM:")) {
            return null;
        }
        String strB = a.b("TITLE:", strE, true);
        String[] strArrA = a.a("URL:", strE, true);
        if (strArrA == null) {
            return null;
        }
        String str = strArrA[0];
        if (d0.e(str)) {
            return new c0(str, strB);
        }
        return null;
    }
}
