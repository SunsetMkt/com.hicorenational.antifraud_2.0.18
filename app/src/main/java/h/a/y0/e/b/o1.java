package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableIgnoreElementsCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o1<T> extends h.a.c implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: compiled from: FlowableIgnoreElementsCompletable.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10852b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10852b.cancel();
            this.f10852b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10852b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10852b = h.a.y0.i.j.CANCELLED;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10852b = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10852b, dVar)) {
                this.f10852b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public o1(h.a.l<T> lVar) {
        this.a = lVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a((h.a.q) new a(fVar));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new n1(this.a));
    }
}
