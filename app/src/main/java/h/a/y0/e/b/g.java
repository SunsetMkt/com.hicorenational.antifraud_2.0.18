package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableAllSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.k0<Boolean> implements h.a.y0.c.b<Boolean> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super T> f10663b;

    /* JADX INFO: compiled from: FlowableAllSingle.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.r<? super T> f10664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10666d;

        a(h.a.n0<? super Boolean> n0Var, h.a.x0.r<? super T> rVar) {
            this.a = n0Var;
            this.f10664b = rVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10665c.cancel();
            this.f10665c = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10665c == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10666d) {
                return;
            }
            this.f10666d = true;
            this.f10665c = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(true);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10666d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10666d = true;
            this.f10665c = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10666d) {
                return;
            }
            try {
                if (this.f10664b.test(t)) {
                    return;
                }
                this.f10666d = true;
                this.f10665c.cancel();
                this.f10665c = h.a.y0.i.j.CANCELLED;
                this.a.onSuccess(false);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10665c.cancel();
                this.f10665c = h.a.y0.i.j.CANCELLED;
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10665c, dVar)) {
                this.f10665c = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public g(h.a.l<T> lVar, h.a.x0.r<? super T> rVar) {
        this.a = lVar;
        this.f10663b = rVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.a((h.a.q) new a(n0Var, this.f10663b));
    }

    @Override // h.a.y0.c.b
    public h.a.l<Boolean> b() {
        return h.a.c1.a.a(new f(this.a, this.f10663b));
    }
}
