package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeIgnoreElement.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: compiled from: MaybeIgnoreElement.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11170b;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11170b.dispose();
            this.f11170b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11170b.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11170b = h.a.y0.a.d.DISPOSED;
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11170b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11170b, cVar)) {
                this.f11170b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11170b = h.a.y0.a.d.DISPOSED;
            this.a.onComplete();
        }
    }

    public o0(h.a.y<T> yVar) {
        super(yVar);
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar));
    }
}
