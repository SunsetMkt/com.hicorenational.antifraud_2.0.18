package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableDetach.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class i extends h.a.c {
    final h.a.i a;

    /* JADX INFO: compiled from: CompletableDetach.java */
    static final class a implements h.a.f, h.a.u0.c {
        h.a.f a;

        /* JADX INFO: renamed from: b */
        h.a.u0.c f10527b;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.a = null;
            this.f10527b.dispose();
            this.f10527b = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10527b.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            this.f10527b = h.a.y0.a.d.DISPOSED;
            h.a.f fVar = this.a;
            if (fVar != null) {
                this.a = null;
                fVar.onComplete();
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.f10527b = h.a.y0.a.d.DISPOSED;
            h.a.f fVar = this.a;
            if (fVar != null) {
                this.a = null;
                fVar.onError(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f10527b, cVar)) {
                this.f10527b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i(h.a.i iVar) {
        this.a = iVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
