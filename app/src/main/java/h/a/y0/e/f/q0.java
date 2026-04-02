package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleToFlowable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.q0<? extends T> f11876b;

    /* JADX INFO: compiled from: SingleToFlowable.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.n0<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11877d;

        a(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.f11877d.dispose();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11877d, cVar)) {
                this.f11877d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public q0(h.a.q0<? extends T> q0Var) {
        this.f11876b = q0Var;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        this.f11876b.a(new a(cVar));
    }
}
