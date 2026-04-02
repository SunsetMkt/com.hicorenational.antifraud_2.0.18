package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeIsEmpty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0<T> extends h.a.y0.e.c.a<T, Boolean> {

    /* JADX INFO: compiled from: MaybeIsEmpty.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.v<? super Boolean> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11177b;

        a(h.a.v<? super Boolean> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11177b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11177b.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.a.onSuccess(true);
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11177b, cVar)) {
                this.f11177b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.a.onSuccess(false);
        }
    }

    public q0(h.a.y<T> yVar) {
        super(yVar);
    }

    @Override // h.a.s
    protected void b(h.a.v<? super Boolean> vVar) {
        this.a.a(new a(vVar));
    }
}
