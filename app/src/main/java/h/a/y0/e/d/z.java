package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableCountSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z<T> extends h.a.k0<Long> implements h.a.y0.c.d<Long> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: ObservableCountSingle.java */
    static final class a implements h.a.i0<Object>, h.a.u0.c {
        final h.a.n0<? super Long> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f11724c;

        a(h.a.n0<? super Long> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11723b.dispose();
            this.f11723b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11723b.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11723b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(Long.valueOf(this.f11724c));
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11723b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            this.f11724c++;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11723b, cVar)) {
                this.f11723b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<Long> a() {
        return h.a.c1.a.a(new y(this.a));
    }

    @Override // h.a.k0
    public void b(h.a.n0<? super Long> n0Var) {
        this.a.subscribe(new a(n0Var));
    }
}
