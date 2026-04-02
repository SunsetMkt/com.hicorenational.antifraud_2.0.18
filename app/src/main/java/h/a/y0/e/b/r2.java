package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableReduceSeedSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r2<T, R> extends h.a.k0<R> {
    final j.d.b<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final R f10944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f10945c;

    /* JADX INFO: compiled from: FlowableReduceSeedSingle.java */
    static final class a<T, R> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<R, ? super T, R> f10946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        R f10947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f10948d;

        a(h.a.n0<? super R> n0Var, h.a.x0.c<R, ? super T, R> cVar, R r) {
            this.a = n0Var;
            this.f10947c = r;
            this.f10946b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10948d.cancel();
            this.f10948d = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10948d == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            R r = this.f10947c;
            this.f10947c = null;
            this.f10948d = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(r);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10947c = null;
            this.f10948d = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            try {
                this.f10947c = (R) h.a.y0.b.b.a(this.f10946b.apply(this.f10947c, t), "The reducer returned a null value");
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10948d.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10948d, dVar)) {
                this.f10948d = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public r2(j.d.b<T> bVar, R r, h.a.x0.c<R, ? super T, R> cVar) {
        this.a = bVar;
        this.f10944b = r;
        this.f10945c = cVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        this.a.subscribe(new a(n0Var, this.f10945c, this.f10944b));
    }
}
