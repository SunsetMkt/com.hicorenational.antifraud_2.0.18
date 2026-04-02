package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableCountSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0<T> extends h.a.k0<Long> implements h.a.y0.c.b<Long> {
    final h.a.l<T> a;

    /* JADX INFO: compiled from: FlowableCountSingle.java */
    static final class a implements h.a.q<Object>, h.a.u0.c {
        final h.a.n0<? super Long> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f10576c;

        a(h.a.n0<? super Long> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10575b.cancel();
            this.f10575b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10575b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10575b = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(Long.valueOf(this.f10576c));
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10575b = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            this.f10576c++;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10575b, dVar)) {
                this.f10575b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public b0(h.a.l<T> lVar) {
        this.a = lVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Long> n0Var) {
        this.a.a((h.a.q) new a(n0Var));
    }

    @Override // h.a.y0.c.b
    public h.a.l<Long> b() {
        return h.a.c1.a.a(new a0(this.a));
    }
}
