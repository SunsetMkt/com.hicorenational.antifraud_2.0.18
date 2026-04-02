package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeIsEmptySingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> extends h.a.k0<Boolean> implements h.a.y0.c.f<T>, h.a.y0.c.c<Boolean> {
    final h.a.y<T> a;

    /* JADX INFO: compiled from: MaybeIsEmptySingle.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.n0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11184b;

        a(h.a.n0<? super Boolean> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11184b.dispose();
            this.f11184b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11184b.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11184b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(true);
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11184b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11184b, cVar)) {
                this.f11184b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11184b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(false);
        }
    }

    public r0(h.a.y<T> yVar) {
        this.a = yVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.a(new a(n0Var));
    }

    @Override // h.a.y0.c.c
    public h.a.s<Boolean> c() {
        return h.a.c1.a.a(new q0(this.a));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
