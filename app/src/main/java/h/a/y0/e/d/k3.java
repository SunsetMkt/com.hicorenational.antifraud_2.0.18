package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableTakeLastOne.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: compiled from: ObservableTakeLastOne.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f11448c;

        a(h.a.i0<? super T> i0Var) {
            this.a = i0Var;
        }

        void a() {
            T t = this.f11448c;
            if (t != null) {
                this.f11448c = null;
                this.a.onNext(t);
            }
            this.a.onComplete();
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11448c = null;
            this.f11447b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11447b.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            a();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11448c = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11448c = t;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11447b, cVar)) {
                this.f11447b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public k3(h.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
