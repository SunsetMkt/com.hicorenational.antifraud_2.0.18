package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDetach.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableDetach.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10714b;

        a(j.d.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            j.d.d dVar = this.f10714b;
            this.f10714b = h.a.y0.j.h.INSTANCE;
            this.a = h.a.y0.j.h.asSubscriber();
            dVar.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            j.d.c<? super T> cVar = this.a;
            this.f10714b = h.a.y0.j.h.INSTANCE;
            this.a = h.a.y0.j.h.asSubscriber();
            cVar.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            j.d.c<? super T> cVar = this.a;
            this.f10714b = h.a.y0.j.h.INSTANCE;
            this.a = h.a.y0.j.h.asSubscriber();
            cVar.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10714b, dVar)) {
                this.f10714b = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10714b.request(j2);
        }
    }

    public j0(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
