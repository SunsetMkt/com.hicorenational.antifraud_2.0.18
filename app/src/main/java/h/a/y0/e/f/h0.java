package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0<T, R> extends h.a.k0<R> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends R> f11844b;

    /* JADX INFO: compiled from: SingleMap.java */
    static final class a<T, R> implements h.a.n0<T> {
        final h.a.n0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends R> f11845b;

        a(h.a.n0<? super R> n0Var, h.a.x0.o<? super T, ? extends R> oVar) {
            this.a = n0Var;
            this.f11845b = oVar;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                this.a.onSuccess(h.a.y0.b.b.a(this.f11845b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public h0(h.a.q0<? extends T> q0Var, h.a.x0.o<? super T, ? extends R> oVar) {
        this.a = q0Var;
        this.f11844b = oVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        this.a.a(new a(n0Var, this.f11844b));
    }
}
