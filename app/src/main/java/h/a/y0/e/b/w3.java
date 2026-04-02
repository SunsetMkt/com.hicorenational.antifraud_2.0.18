package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableTakeLastOne.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableTakeLastOne.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.q<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        j.d.d s;

        a(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.value = t;
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

    public w3(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
