package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeFromSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0<T> extends h.a.s<T> implements h.a.y0.c.i<T> {
    final h.a.q0<T> a;

    /* JADX INFO: compiled from: MaybeFromSingle.java */
    static final class a<T> implements h.a.n0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11160b;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11160b.dispose();
            this.f11160b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11160b.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11160b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11160b, cVar)) {
                this.f11160b = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.f11160b = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(t);
        }
    }

    public m0(h.a.q0<T> q0Var) {
        this.a = q0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar));
    }

    @Override // h.a.y0.c.i
    public h.a.q0<T> source() {
        return this.a;
    }
}
