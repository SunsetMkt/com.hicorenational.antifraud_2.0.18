package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableIgnoreElements.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n1<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableIgnoreElements.java */
    static final class a<T> implements h.a.q<T>, h.a.y0.c.l<T> {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10823b;

        a(j.d.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10823b.cancel();
        }

        @Override // h.a.y0.c.o
        public void clear() {
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return true;
        }

        @Override // h.a.y0.c.o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10823b, dVar)) {
                this.f10823b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() {
            return null;
        }

        @Override // j.d.d
        public void request(long j2) {
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }

        @Override // h.a.y0.c.o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public n1(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
