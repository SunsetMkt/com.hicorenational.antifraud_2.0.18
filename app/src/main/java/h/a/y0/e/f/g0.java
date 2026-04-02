package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleLift.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0<T, R> extends h.a.k0<R> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.p0<? extends R, ? super T> f11842b;

    public g0(h.a.q0<T> q0Var, h.a.p0<? extends R, ? super T> p0Var) {
        this.a = q0Var;
        this.f11842b = p0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        try {
            this.a.a((h.a.n0) h.a.y0.b.b.a(this.f11842b.a(n0Var), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
