package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableFromObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> extends h.a.c {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: CompletableFromObservable.java */
    static final class a<T> implements h.a.i0<T> {
        final h.a.f a;

        a(h.a.f fVar) {
            this.a = fVar;
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
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    public r(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar));
    }
}
