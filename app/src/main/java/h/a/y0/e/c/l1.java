package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeToObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l1<T> extends h.a.b0<T> implements h.a.y0.c.f<T> {
    final h.a.y<T> a;

    /* JADX INFO: compiled from: MaybeToObservable.java */
    static final class a<T> extends h.a.y0.d.l<T> implements h.a.v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11156d;

        a(h.a.i0<? super T> i0Var) {
            super(i0Var);
        }

        @Override // h.a.y0.d.l, h.a.u0.c
        public void dispose() {
            super.dispose();
            this.f11156d.dispose();
        }

        @Override // h.a.v
        public void onComplete() {
            complete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            error(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11156d, cVar)) {
                this.f11156d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public l1(h.a.y<T> yVar) {
        this.a = yVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.a(new a(i0Var));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
