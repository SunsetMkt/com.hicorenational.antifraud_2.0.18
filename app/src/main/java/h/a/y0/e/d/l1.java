package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableIgnoreElementsCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l1<T> extends h.a.c implements h.a.y0.c.d<T> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: ObservableIgnoreElementsCompletable.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11451b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11451b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11451b.isDisposed();
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
            this.f11451b = cVar;
            this.a.onSubscribe(this);
        }
    }

    public l1(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<T> a() {
        return h.a.c1.a.a(new k1(this.a));
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar));
    }
}
