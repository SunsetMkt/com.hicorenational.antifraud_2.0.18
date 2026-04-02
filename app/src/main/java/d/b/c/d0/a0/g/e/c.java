package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: AI01392xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9573d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9574e = 2;

    c(d.b.c.z.a aVar) {
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
        sb.append("(392");
        sb.append(iA);
        sb.append(')');
        sb.append(a().a(50, (String) null).b());
        return sb.toString();
    }
}
