package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableAny.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> extends h.a.y0.e.d.a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f11404b;

    /* JADX INFO: compiled from: ObservableAny.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f11405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11407d;

        a(h.a.i0<? super Boolean> i0Var, h.a.x0.r<? super T> rVar) {
            this.a = i0Var;
            this.f11405b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11406c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11406c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11407d) {
                return;
            }
            this.f11407d = true;
            this.a.onNext(false);
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11407d) {
                h.a.c1.a.b(th);
            } else {
                this.f11407d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11407d) {
                return;
            }
            try {
                if (this.f11405b.test(t)) {
                    this.f11407d = true;
                    this.f11406c.dispose();
                    this.a.onNext(true);
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11406c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11406c, cVar)) {
                this.f11406c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i(h.a.g0<T> g0Var, h.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f11404b = rVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super Boolean> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11404b));
    }
}
