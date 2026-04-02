package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableSingleMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y2<T> extends h.a.s<T> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: ObservableSingleMaybe.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f11718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11719d;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11717b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11717b.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11719d) {
                return;
            }
            this.f11719d = true;
            T t = this.f11718c;
            this.f11718c = null;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11719d) {
                h.a.c1.a.b(th);
            } else {
                this.f11719d = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11719d) {
                return;
            }
            if (this.f11718c == null) {
                this.f11718c = t;
                return;
            }
            this.f11719d = true;
            this.f11717b.dispose();
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11717b, cVar)) {
                this.f11717b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public y2(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.s
    public void b(h.a.v<? super T> vVar) {
        this.a.subscribe(new a(vVar));
    }
}
