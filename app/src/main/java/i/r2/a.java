package i.r2;

/* JADX INFO: compiled from: MathJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i.q2.c
    public static final double f12270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i.q2.c
    public static final double f12271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12272g = new a();

    @i.q2.c
    public static final double a = Math.log(2.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i.q2.c
    public static final double f12267b = Math.ulp(1.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @i.q2.c
    public static final double f12268c = Math.sqrt(f12267b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @i.q2.c
    public static final double f12269d = Math.sqrt(f12268c);

    static {
        double d2 = 1;
        f12270e = d2 / f12268c;
        f12271f = d2 / f12269d;
    }

    private a() {
    }
}
