package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableLastMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r1<T> extends h.a.s<T> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: ObservableLastMaybe.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f11598c;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11597b.dispose();
            this.f11597b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11597b == h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11597b = h.a.y0.a.d.DISPOSED;
            T t = this.f11598c;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.f11598c = null;
                this.a.onSuccess(t);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11597b = h.a.y0.a.d.DISPOSED;
            this.f11598c = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11598c = t;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11597b, cVar)) {
                this.f11597b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public r1(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.subscribe(new a(vVar));
    }
}
