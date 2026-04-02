package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleToObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> extends h.a.b0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: compiled from: SingleToObservable.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11881b;

        a(h.a.i0<? super T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11881b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11881b.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11881b, cVar)) {
                this.f11881b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onNext(t);
            this.a.onComplete();
        }
    }

    public r0(h.a.q0<? extends T> q0Var) {
        this.a = q0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.a(new a(i0Var));
    }
}
