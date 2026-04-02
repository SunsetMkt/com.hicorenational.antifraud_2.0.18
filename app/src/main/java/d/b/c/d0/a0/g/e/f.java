package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
abstract class f extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9583d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9584e = 15;

    f(d.b.c.z.a aVar) {
        super(aVar);
    }

    @Override // d.b.c.d0.a0.g.e.j
    public String c() throws d.b.c.m {
        if (b().c() != 60) {
            throw d.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 5);
        b(sb, 45, 15);
        return sb.toString();
    }
}
