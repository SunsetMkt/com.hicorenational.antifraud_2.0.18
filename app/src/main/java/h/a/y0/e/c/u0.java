package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0<T, R> extends h.a.y0.e.c.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends R> f11193b;

    /* JADX INFO: compiled from: MaybeMap.java */
    static final class a<T, R> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends R> f11194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11195c;

        a(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends R> oVar) {
            this.a = vVar;
            this.f11194b = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.u0.c cVar = this.f11195c;
            this.f11195c = h.a.y0.a.d.DISPOSED;
            cVar.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11195c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11195c, cVar)) {
                this.f11195c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                this.a.onSuccess(h.a.y0.b.b.a(this.f11194b.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }
    }

    public u0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends R> oVar) {
        super(yVar);
        this.f11193b = oVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new a(vVar, this.f11193b));
    }
}
