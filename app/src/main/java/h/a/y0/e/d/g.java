package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableAllSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.k0<Boolean> implements h.a.y0.c.d<Boolean> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11361b;

    /* JADX INFO: compiled from: ObservableAllSingle.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11364d;

        a(h.a.n0<? super Boolean> n0Var, h.a.x0.r<? super T> rVar) {
            this.a = n0Var;
            this.f11362b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11363c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11363c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11364d) {
                return;
            }
            this.f11364d = true;
            this.a.onSuccess(true);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11364d) {
                h.a.c1.a.b(th);
            } else {
                this.f11364d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11364d) {
                return;
            }
            try {
                if (this.f11362b.test(t)) {
                    return;
                }
                this.f11364d = true;
                this.f11363c.dispose();
                this.a.onSuccess(false);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11363c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11363c, cVar)) {
                this.f11363c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        this.a = g0Var;
        this.f11361b = rVar;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<Boolean> a() {
        return h.a.c1.a.a(new f(this.a, this.f11361b));
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11361b));
    }
}
