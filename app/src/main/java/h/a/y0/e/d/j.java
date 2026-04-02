package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableAnySingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends h.a.k0<Boolean> implements h.a.y0.c.d<Boolean> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11427b;

    /* JADX INFO: compiled from: ObservableAnySingle.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11430d;

        a(h.a.n0<? super Boolean> n0Var, h.a.x0.r<? super T> rVar) {
            this.a = n0Var;
            this.f11428b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11429c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11429c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11430d) {
                return;
            }
            this.f11430d = true;
            this.a.onSuccess(false);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11430d) {
                h.a.c1.a.b(th);
            } else {
                this.f11430d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11430d) {
                return;
            }
            try {
                if (this.f11428b.test(t)) {
                    this.f11430d = true;
                    this.f11429c.dispose();
                    this.a.onSuccess(true);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11429c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11429c, cVar)) {
                this.f11429c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        this.a = g0Var;
        this.f11427b = rVar;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<Boolean> a() {
        return h.a.c1.a.a(new i(this.a, this.f11427b));
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11427b));
    }
}
