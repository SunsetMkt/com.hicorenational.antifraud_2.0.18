package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableAll.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends h.a.y0.e.d.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11338b;

    /* JADX INFO: compiled from: ObservableAll.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11341d;

        a(h.a.i0<? super Boolean> i0Var, h.a.x0.r<? super T> rVar) {
            this.a = i0Var;
            this.f11339b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11340c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11340c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11341d) {
                return;
            }
            this.f11341d = true;
            this.a.onNext(true);
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11341d) {
                h.a.c1.a.b(th);
            } else {
                this.f11341d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11341d) {
                return;
            }
            try {
                if (this.f11339b.test(t)) {
                    return;
                }
                this.f11341d = true;
                this.f11340c.dispose();
                this.a.onNext(false);
                this.a.onComplete();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11340c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11340c, cVar)) {
                this.f11340c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11338b = rVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super Boolean> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11338b));
    }
}
