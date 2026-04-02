package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableCount.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0<T> extends h.a.y0.e.b.a<T, Long> {

    /* JADX INFO: compiled from: FlowableCount.java */
    static final class a extends h.a.y0.i.f<Long> implements h.a.q<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        j.d.d s;

        a(j.d.c<? super Long> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public a0(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super Long> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
