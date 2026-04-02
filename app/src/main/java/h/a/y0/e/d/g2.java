package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableReduceSeedSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g2<T, R> extends h.a.k0<R> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final R f11375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f11376c;

    /* JADX INFO: compiled from: ObservableReduceSeedSingle.java */
    static final class a<T, R> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<R, ? super T, R> f11377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        R f11378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11379d;

        a(h.a.n0<? super R> n0Var, h.a.x0.c<R, ? super T, R> cVar, R r) {
            this.a = n0Var;
            this.f11378c = r;
            this.f11377b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11379d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11379d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            R r = this.f11378c;
            this.f11378c = null;
            if (r != null) {
                this.a.onSuccess(r);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            R r = this.f11378c;
            this.f11378c = null;
            if (r != null) {
                this.a.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            R r = this.f11378c;
            if (r != null) {
                try {
                    this.f11378c = (R) h.a.y0.b.b.a(this.f11377b.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.f11379d.dispose();
                    onError(th);
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11379d, cVar)) {
                this.f11379d = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g2(h.a.g0<T> g0Var, R r, h.a.x0.c<R, ? super T, R> cVar) {
        this.a = g0Var;
        this.f11375b = r;
        this.f11376c = cVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11376c, this.f11375b));
    }
}
