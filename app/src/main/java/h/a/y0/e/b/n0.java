package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDoFinally.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class n0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.a f10822c;

    /* JADX INFO: compiled from: FlowableDoFinally.java */
    static final class a<T> extends h.a.y0.i.c<T> implements h.a.y0.c.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final h.a.y0.c.a<? super T> actual;
        final h.a.x0.a onFinally;
        h.a.y0.c.l<T> qs;
        j.d.d s;
        boolean syncFused;

        a(h.a.y0.c.a<? super T> aVar, h.a.x0.a aVar2) {
            this.actual = aVar;
            this.onFinally = aVar2;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.qs.clear();
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    this.qs = (h.a.y0.c.l) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // j.d.d
        public void request(long j2) {
            this.s.request(j2);
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            h.a.y0.c.l<T> lVar = this.qs;
            if (lVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i2);
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

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            return this.actual.tryOnNext(t);
        }
    }

    /* JADX INFO: compiled from: FlowableDoFinally.java */
    static final class b<T> extends h.a.y0.i.c<T> implements h.a.q<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final j.d.c<? super T> actual;
        final h.a.x0.a onFinally;
        h.a.y0.c.l<T> qs;
        j.d.d s;
        boolean syncFused;

        b(j.d.c<? super T> cVar, h.a.x0.a aVar) {
            this.actual = cVar;
            this.onFinally = aVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.qs.clear();
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    this.qs = (h.a.y0.c.l) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // j.d.d
        public void request(long j2) {
            this.s.request(j2);
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            h.a.y0.c.l<T> lVar = this.qs;
            if (lVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i2);
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

    public n0(h.a.l<T> lVar, h.a.x0.a aVar) {
        super(lVar);
        this.f10822c = aVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f10822c));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f10822c));
        }
    }
}
