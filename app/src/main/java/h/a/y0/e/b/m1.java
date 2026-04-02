package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableHide.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m1<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableHide.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10788b;

        a(j.d.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10788b.cancel();
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
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10788b, dVar)) {
                this.f10788b = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10788b.request(j2);
        }
    }

    public m1(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
