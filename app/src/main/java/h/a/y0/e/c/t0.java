package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeLift.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t0<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x<? extends R, ? super T> f11190b;

    public t0(h.a.y<T> yVar, h.a.x<? extends R, ? super T> xVar) {
        super(yVar);
        this.f11190b = xVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        try {
            this.a.a((h.a.v) h.a.y0.b.b.a(this.f11190b.a(vVar), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, vVar);
        }
    }
}
