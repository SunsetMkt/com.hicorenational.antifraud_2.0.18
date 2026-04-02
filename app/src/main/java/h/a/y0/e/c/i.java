package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeCount.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> extends h.a.k0<Long> implements h.a.y0.c.f<T> {
    final h.a.y<T> a;

    /* JADX INFO: compiled from: MaybeCount.java */
    static final class a implements h.a.v<Object>, h.a.u0.c {
        final h.a.n0<? super Long> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11143b;

        a(h.a.n0<? super Long> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11143b.dispose();
            this.f11143b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11143b.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11143b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(0L);
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11143b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11143b, cVar)) {
                this.f11143b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(Object obj) {
            this.f11143b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(1L);
        }
    }

    public i(h.a.y<T> yVar) {
        this.a = yVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Long> n0Var) {
        this.a.a(new a(n0Var));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
