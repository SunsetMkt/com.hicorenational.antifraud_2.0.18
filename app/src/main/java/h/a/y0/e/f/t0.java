package h.a.y0.e.f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleUsing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t0<T, U> extends h.a.k0<T> {
    final Callable<U> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super U, ? extends h.a.q0<? extends T>> f11890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super U> f11891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11892d;

    /* JADX INFO: compiled from: SingleUsing.java */
    static final class a<T, U> extends AtomicReference<Object> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = -5331524057054083935L;
        final h.a.n0<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11893d;
        final h.a.x0.g<? super U> disposer;
        final boolean eager;

        a(h.a.n0<? super T> n0Var, U u, boolean z, h.a.x0.g<? super U> gVar) {
            super(u);
            this.actual = n0Var;
            this.eager = z;
            this.disposer = gVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11893d.dispose();
            this.f11893d = h.a.y0.a.d.DISPOSED;
            disposeAfter();
        }

        void disposeAfter() {
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
            return this.f11893d.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11893d = h.a.y0.a.d.DISPOSED;
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
            disposeAfter();
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11893d, cVar)) {
                this.f11893d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.f11893d = h.a.y0.a.d.DISPOSED;
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
            this.actual.onSuccess(t);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }
    }

    public t0(Callable<U> callable, h.a.x0.o<? super U, ? extends h.a.q0<? extends T>> oVar, h.a.x0.g<? super U> gVar, boolean z) {
        this.a = callable;
        this.f11890b = oVar;
        this.f11891c = gVar;
        this.f11892d = z;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        try {
            U uCall = this.a.call();
            try {
                ((h.a.q0) h.a.y0.b.b.a(this.f11890b.apply(uCall), "The singleFunction returned a null SingleSource")).a(new a(n0Var, uCall, this.f11892d, this.f11891c));
            } catch (Throwable th) {
                th = th;
                h.a.v0.b.b(th);
                if (this.f11892d) {
                    try {
                        this.f11891c.accept(uCall);
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        th = new h.a.v0.a(th, th2);
                    }
                }
                h.a.y0.a.e.error(th, n0Var);
                if (this.f11892d) {
                    return;
                }
                try {
                    this.f11891c.accept(uCall);
                } catch (Throwable th3) {
                    h.a.v0.b.b(th3);
                    h.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            h.a.v0.b.b(th4);
            h.a.y0.a.e.error(th4, n0Var);
        }
    }
}
