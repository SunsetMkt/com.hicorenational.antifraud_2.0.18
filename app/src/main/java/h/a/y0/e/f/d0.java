package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleHide.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0<T> extends h.a.k0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: compiled from: SingleHide.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11832b;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11832b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11832b.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11832b, cVar)) {
                this.f11832b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public d0(h.a.q0<? extends T> q0Var) {
        this.a = q0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
