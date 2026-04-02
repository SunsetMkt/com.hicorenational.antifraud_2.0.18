package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDoOnLifecycle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h.a.x0.g<? super h.a.u0.c> f11511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a.x0.a f11512c;

    public n0(h.a.b0<T> b0Var, h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.a aVar) {
        super(b0Var);
        this.f11511b = gVar;
        this.f11512c = aVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new h.a.y0.d.n(i0Var, this.f11511b, this.f11512c));
    }
}
