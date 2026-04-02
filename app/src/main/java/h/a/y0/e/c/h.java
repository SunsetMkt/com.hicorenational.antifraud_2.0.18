package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeContains.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends h.a.k0<Boolean> implements h.a.y0.c.f<T> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f11138b;

    /* JADX INFO: compiled from: MaybeContains.java */
    static final class a implements h.a.v<Object>, h.a.u0.c {
        final h.a.n0<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f11139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11140c;

        a(h.a.n0<? super Boolean> n0Var, Object obj) {
            this.a = n0Var;
            this.f11139b = obj;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11140c.dispose();
            this.f11140c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11140c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11140c = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(false);
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11140c = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11140c, cVar)) {
                this.f11140c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(Object obj) {
            this.f11140c = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(Boolean.valueOf(h.a.y0.b.b.a(obj, this.f11139b)));
        }
    }

    public h(h.a.y<T> yVar, Object obj) {
        this.a = yVar;
        this.f11138b = obj;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        this.a.a(new a(n0Var, this.f11138b));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
