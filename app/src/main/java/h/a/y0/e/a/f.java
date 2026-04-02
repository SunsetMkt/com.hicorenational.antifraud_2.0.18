package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends h.a.c {
    final h.a.g a;

    /* JADX INFO: compiled from: CompletableCreate.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.e, h.a.u0.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final h.a.f actual;

        a(h.a.f fVar) {
            this.actual = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.e, h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.e
        public void onComplete() {
            h.a.u0.c andSet;
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // h.a.e
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        @Override // h.a.e
        public void setCancellable(h.a.x0.f fVar) {
            setDisposable(new h.a.y0.a.b(fVar));
        }

        @Override // h.a.e
        public void setDisposable(h.a.u0.c cVar) {
            h.a.y0.a.d.set(this, cVar);
        }

        @Override // h.a.e
        public boolean tryOnError(Throwable th) {
            h.a.u0.c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == h.a.y0.a.d.DISPOSED) {
                return false;
            }
            try {
                this.actual.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public f(h.a.g gVar) {
        this.a = gVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
