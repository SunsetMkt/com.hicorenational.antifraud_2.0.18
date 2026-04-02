package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableDoFinally.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class l0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.a f11449b;

    /* JADX INFO: compiled from: ObservableDoFinally.java */
    static final class a<T> extends h.a.y0.d.b<T> implements h.a.i0<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final h.a.i0<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11450d;
        final h.a.x0.a onFinally;
        h.a.y0.c.j<T> qd;
        boolean syncFused;

        a(h.a.i0<? super T> i0Var, h.a.x0.a aVar) {
            this.actual = i0Var;
            this.onFinally = aVar;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.qd.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11450d.dispose();
            runFinally();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11450d.isDisposed();
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11450d, cVar)) {
                this.f11450d = cVar;
                if (cVar instanceof h.a.y0.c.j) {
                    this.qd = (h.a.y0.c.j) cVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qd.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            h.a.y0.c.j<T> jVar = this.qd;
            if (jVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = jVar.requestFusion(i2);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }
    }

    public l0(h.a.g0<T> g0Var, h.a.x0.a aVar) {
        super(g0Var);
        this.f11449b = aVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11449b));
    }
}
