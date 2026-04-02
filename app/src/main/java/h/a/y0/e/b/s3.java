package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableSwitchIfEmpty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<? extends T> f10970c;

    /* JADX INFO: compiled from: FlowableSwitchIfEmpty.java */
    static final class a<T> implements h.a.q<T> {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j.d.b<? extends T> f10971b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10973d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.y0.i.i f10972c = new h.a.y0.i.i();

        a(j.d.c<? super T> cVar, j.d.b<? extends T> bVar) {
            this.a = cVar;
            this.f10971b = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (!this.f10973d) {
                this.a.onComplete();
            } else {
                this.f10973d = false;
                this.f10971b.subscribe(this);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10973d) {
                this.f10973d = false;
            }
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            this.f10972c.setSubscription(dVar);
        }
    }

    public s3(h.a.l<T> lVar, j.d.b<? extends T> bVar) {
        super(lVar);
        this.f10970c = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f10970c);
        cVar.onSubscribe(aVar.f10972c);
        this.f10561b.a((h.a.q) aVar);
    }
}
