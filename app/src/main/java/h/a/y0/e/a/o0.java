package h.a.y0.e.a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableUsing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0<R> extends h.a.c {
    final Callable<R> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super R, ? extends h.a.i> f10552b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.g<? super R> f10553c;

    /* JADX INFO: renamed from: d */
    final boolean f10554d;

    /* JADX INFO: compiled from: CompletableUsing.java */
    static final class a<R> extends AtomicReference<Object> implements h.a.f, h.a.u0.c {
        private static final long serialVersionUID = -674404550052917487L;
        final h.a.f actual;

        /* JADX INFO: renamed from: d */
        h.a.u0.c f10555d;
        final h.a.x0.g<? super R> disposer;
        final boolean eager;

        a(h.a.f fVar, R r, h.a.x0.g<? super R> gVar, boolean z) {
            super(r);
            this.actual = fVar;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10555d.dispose();
            this.f10555d = h.a.y0.a.d.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10555d.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            this.f10555d = h.a.y0.a.d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onComplete();
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.f10555d = h.a.y0.a.d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    th = new h.a.v0.a(th, th2);
                }
            }
            this.actual.onError(th);
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f10555d, cVar)) {
                this.f10555d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public o0(Callable<R> callable, h.a.x0.o<? super R, ? extends h.a.i> oVar, h.a.x0.g<? super R> gVar, boolean z) {
        this.a = callable;
        this.f10552b = oVar;
        this.f10553c = gVar;
        this.f10554d = z;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        try {
            R rCall = this.a.call();
            try {
                ((h.a.i) h.a.y0.b.b.a(this.f10552b.apply(rCall), "The completableFunction returned a null CompletableSource")).a(new a(fVar, rCall, this.f10553c, this.f10554d));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                if (this.f10554d) {
                    try {
                        this.f10553c.accept(rCall);
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        h.a.y0.a.e.error(new h.a.v0.a(th, th2), fVar);
                        return;
                    }
                }
                h.a.y0.a.e.error(th, fVar);
                if (this.f10554d) {
                    return;
                }
                try {
                    this.f10553c.accept(rCall);
                } catch (Throwable th3) {
                    h.a.v0.b.b(th3);
                    h.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            h.a.v0.b.b(th4);
            h.a.y0.a.e.error(th4, fVar);
        }
    }
}
