package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends h.a.s<T> {
    final h.a.w<T> a;

    /* JADX INFO: compiled from: MaybeCreate.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.u<T>, h.a.u0.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final h.a.v<? super T> actual;

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u, h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.u
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

        @Override // h.a.u
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            h.a.u0.c andSet;
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                if (t == null) {
                    this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.actual.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // h.a.u
        public void setCancellable(h.a.x0.f fVar) {
            setDisposable(new h.a.y0.a.b(fVar));
        }

        @Override // h.a.u
        public void setDisposable(h.a.u0.c cVar) {
            h.a.y0.a.d.set(this, cVar);
        }

        @Override // h.a.u
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

    public j(h.a.w<T> wVar) {
        this.a = wVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
