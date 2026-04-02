package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11517b;

    /* JADX INFO: compiled from: ObservableTakeUntilPredicate.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11520d;

        a(h.a.i0<? super T> i0Var, h.a.x0.r<? super T> rVar) {
            this.a = i0Var;
            this.f11518b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11519c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11519c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11520d) {
                return;
            }
            this.f11520d = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11520d) {
                h.a.c1.a.b(th);
            } else {
                this.f11520d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11520d) {
                return;
            }
            this.a.onNext(t);
            try {
                if (this.f11518b.test(t)) {
                    this.f11520d = true;
                    this.f11519c.dispose();
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11519c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11519c, cVar)) {
                this.f11519c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public n3(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11517b = rVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11517b));
    }
}
