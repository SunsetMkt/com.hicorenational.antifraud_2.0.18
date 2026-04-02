package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableSkipUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d3<T, U> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<U> f11297b;

    /* JADX INFO: compiled from: ObservableSkipUntil.java */
    final class a implements h.a.i0<U> {
        private final h.a.y0.a.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b<T> f11298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h.a.a1.m<T> f11299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11300d;

        a(h.a.y0.a.a aVar, b<T> bVar, h.a.a1.m<T> mVar) {
            this.a = aVar;
            this.f11298b = bVar;
            this.f11299c = mVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11298b.f11304d = true;
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.dispose();
            this.f11299c.onError(th);
        }

        @Override // h.a.i0
        public void onNext(U u) {
            this.f11300d.dispose();
            this.f11298b.f11304d = true;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11300d, cVar)) {
                this.f11300d = cVar;
                this.a.setResource(1, cVar);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableSkipUntil.java */
    static final class b<T> implements h.a.i0<T> {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y0.a.a f11302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f11304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11305e;

        b(h.a.i0<? super T> i0Var, h.a.y0.a.a aVar) {
            this.a = i0Var;
            this.f11302b = aVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11302b.dispose();
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11302b.dispose();
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11305e) {
                this.a.onNext(t);
            } else if (this.f11304d) {
                this.f11305e = true;
                this.a.onNext(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11303c, cVar)) {
                this.f11303c = cVar;
                this.f11302b.setResource(0, cVar);
            }
        }
    }

    public d3(h.a.g0<T> g0Var, h.a.g0<U> g0Var2) {
        super(g0Var);
        this.f11297b = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        h.a.y0.a.a aVar = new h.a.y0.a.a(2);
        mVar.onSubscribe(aVar);
        b bVar = new b(mVar, aVar);
        this.f11297b.subscribe(new a(aVar, bVar, mVar));
        this.a.subscribe(bVar);
    }
}
