package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: AI01393xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9575d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9576e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9577f = 10;

    d(d.b.c.z.a aVar) {
        super(aVar);
    }

    @Override // d.b.c.d0.a0.g.e.j
    public String c() throws d.b.c.m, d.b.c.h {
        if (b().c() < 48) {
            throw d.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 8);
        int iA = a().a(48, 2);
        sb.append("(393");
        sb.append(iA);
        sb.append(')');
        int iA2 = a().a(50, 10);
        if (iA2 / 100 == 0) {
            sb.append('0');
        }
        if (iA2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iA2);
        sb.append(a().a(60, (String) null).b());
        return sb.toString();
    }
}
