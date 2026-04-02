package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDetach.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class k<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: compiled from: SingleDetach.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11849b;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.a = null;
            this.f11849b.dispose();
            this.f11849b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11849b.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11849b = h.a.y0.a.d.DISPOSED;
            h.a.n0<? super T> n0Var = this.a;
            if (n0Var != null) {
                this.a = null;
                n0Var.onError(th);
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11849b, cVar)) {
                this.f11849b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.f11849b = h.a.y0.a.d.DISPOSED;
            h.a.n0<? super T> n0Var = this.a;
            if (n0Var != null) {
                this.a = null;
                n0Var.onSuccess(t);
            }
        }
    }

    public k(h.a.q0<T> q0Var) {
        this.a = q0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
