package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeFromCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0<T> extends h.a.s<T> implements h.a.y0.c.e {
    final h.a.i a;

    /* JADX INFO: compiled from: MaybeFromCompletable.java */
    static final class a<T> implements h.a.f, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b */
        h.a.u0.c f11146b;

        a(h.a.v<? super T> vVar) {
            this.a = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11146b.dispose();
            this.f11146b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11146b.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            this.f11146b = h.a.y0.a.d.DISPOSED;
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.f11146b = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11146b, cVar)) {
                this.f11146b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j0(h.a.i iVar) {
        this.a = iVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar));
    }

    @Override // h.a.y0.c.e
    public h.a.i source() {
        return this.a;
    }
}
