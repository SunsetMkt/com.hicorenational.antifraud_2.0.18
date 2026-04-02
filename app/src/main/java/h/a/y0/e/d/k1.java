package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableIgnoreElements.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k1<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: compiled from: ObservableIgnoreElements.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11445b;

        a(h.a.i0<? super T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11445b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11445b.isDisposed();
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
            this.f11445b = cVar;
            this.a.onSubscribe(this);
        }
    }

    public k1(h.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
