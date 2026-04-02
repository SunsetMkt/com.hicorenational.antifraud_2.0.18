package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableFromPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T> extends h.a.c {
    final j.d.b<T> a;

    /* JADX INFO: compiled from: CompletableFromPublisher.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        j.d.d f10556b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10556b.cancel();
            this.f10556b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10556b == h.a.y0.i.j.CANCELLED;
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
            if (h.a.y0.i.j.validate(this.f10556b, dVar)) {
                this.f10556b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public s(j.d.b<T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar));
    }
}
