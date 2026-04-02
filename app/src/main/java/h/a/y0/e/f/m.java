package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleDoAfterTerminate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.a f11857b;

    /* JADX INFO: compiled from: SingleDoAfterTerminate.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.a f11858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11859c;

        a(h.a.n0<? super T> n0Var, h.a.x0.a aVar) {
            this.a = n0Var;
            this.f11858b = aVar;
        }

        private void a() {
            try {
                this.f11858b.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11859c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11859c.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
            a();
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11859c, cVar)) {
                this.f11859c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
            a();
        }
    }

    public m(h.a.q0<T> q0Var, h.a.x0.a aVar) {
        this.a = q0Var;
        this.f11857b = aVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11857b));
    }
}
