package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableFromObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h1<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h.a.b0<T> f10697b;

    /* JADX INFO: compiled from: FlowableFromObservable.java */
    static class a<T> implements h.a.i0<T>, j.d.d {
        private final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h.a.u0.c f10698b;

        a(j.d.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10698b.dispose();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f10698b = cVar;
            this.a.onSubscribe(this);
        }

        @Override // j.d.d
        public void request(long j2) {
        }
    }

    public h1(h.a.b0<T> b0Var) {
        this.f10697b = b0Var;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10697b.subscribe(new a(cVar));
    }
}
