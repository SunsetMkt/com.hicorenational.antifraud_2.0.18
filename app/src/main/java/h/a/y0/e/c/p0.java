package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeIgnoreElementCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0<T> extends h.a.c implements h.a.y0.c.c<T> {
    final h.a.y<T> a;

    /* JADX INFO: compiled from: MaybeIgnoreElementCompletable.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11172b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11172b.dispose();
            this.f11172b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11172b.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11172b = h.a.y0.a.d.DISPOSED;
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11172b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11172b, cVar)) {
                this.f11172b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11172b = h.a.y0.a.d.DISPOSED;
            this.a.onComplete();
        }
    }

    public p0(h.a.y<T> yVar) {
        this.a = yVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }

    @Override // h.a.y0.c.c
    public h.a.s<T> c() {
        return h.a.c1.a.a(new o0(this.a));
    }
}
