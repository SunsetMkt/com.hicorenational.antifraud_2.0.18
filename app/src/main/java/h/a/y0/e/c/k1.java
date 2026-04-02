package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeToFlowable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k1<T> extends h.a.l<T> implements h.a.y0.c.f<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y<T> f11151b;

    /* JADX INFO: compiled from: MaybeToFlowable.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11152d;

        a(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.f11152d.dispose();
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11152d, cVar)) {
                this.f11152d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public k1(h.a.y<T> yVar) {
        this.f11151b = yVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f11151b.a(new a(cVar));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.f11151b;
    }
}
