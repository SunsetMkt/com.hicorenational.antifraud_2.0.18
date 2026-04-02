package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoAfterSuccess.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class l<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super T> f11853b;

    /* JADX INFO: compiled from: SingleDoAfterSuccess.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.g<? super T> f11854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11855c;

        a(h.a.n0<? super T> n0Var, h.a.x0.g<? super T> gVar) {
            this.a = n0Var;
            this.f11854b = gVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11855c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11855c.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11855c, cVar)) {
                this.f11855c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
            try {
                this.f11854b.accept(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }
    }

    public l(h.a.q0<T> q0Var, h.a.x0.g<? super T> gVar) {
        this.a = q0Var;
        this.f11853b = gVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11853b));
    }
}
