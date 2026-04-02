package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableHide.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends h.a.c {
    final h.a.i a;

    /* JADX INFO: compiled from: CompletableHide.java */
    static final class a implements h.a.f, h.a.u0.c {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        h.a.u0.c f10557b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10557b.dispose();
            this.f10557b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10557b.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f10557b, cVar)) {
                this.f10557b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public w(h.a.i iVar) {
        this.a = iVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
