package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableTakeWhile.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11541b;

    /* JADX INFO: compiled from: ObservableTakeWhile.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11544d;

        a(h.a.i0<? super T> i0Var, h.a.x0.r<? super T> rVar) {
            this.a = i0Var;
            this.f11542b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11543c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11543c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11544d) {
                return;
            }
            this.f11544d = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11544d) {
                h.a.c1.a.b(th);
            } else {
                this.f11544d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11544d) {
                return;
            }
            try {
                if (this.f11542b.test(t)) {
                    this.a.onNext(t);
                    return;
                }
                this.f11544d = true;
                this.f11543c.dispose();
                this.a.onComplete();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11543c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11543c, cVar)) {
                this.f11543c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public o3(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11541b = rVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11541b));
    }
}
