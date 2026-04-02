package h.a.y0.e.c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeUsing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q1<T, D> extends h.a.s<T> {
    final Callable<? extends D> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super D, ? extends h.a.y<? extends T>> f11178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super D> f11179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11180d;

    /* JADX INFO: compiled from: MaybeUsing.java */
    static final class a<T, D> extends AtomicReference<Object> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -674404550052917487L;
        final h.a.v<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11181d;
        final h.a.x0.g<? super D> disposer;
        final boolean eager;

        a(h.a.v<? super T> vVar, D d2, h.a.x0.g<? super D> gVar, boolean z) {
            super(d2);
            this.actual = vVar;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11181d.dispose();
            this.f11181d = h.a.y0.a.d.DISPOSED;
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
            return this.f11181d.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11181d = h.a.y0.a.d.DISPOSED;
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

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11181d = h.a.y0.a.d.DISPOSED;
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

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11181d, cVar)) {
                this.f11181d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11181d = h.a.y0.a.d.DISPOSED;
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
            disposeResourceAfter();
        }
    }

    public q1(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends h.a.y<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        this.a = callable;
        this.f11178b = oVar;
        this.f11179c = gVar;
        this.f11180d = z;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        try {
            D dCall = this.a.call();
            try {
                ((h.a.y) h.a.y0.b.b.a(this.f11178b.apply(dCall), "The sourceSupplier returned a null MaybeSource")).a(new a(vVar, dCall, this.f11179c, this.f11180d));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                if (this.f11180d) {
                    try {
                        this.f11179c.accept(dCall);
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        h.a.y0.a.e.error(new h.a.v0.a(th, th2), vVar);
                        return;
                    }
                }
                h.a.y0.a.e.error(th, vVar);
                if (this.f11180d) {
                    return;
                }
                try {
                    this.f11179c.accept(dCall);
                } catch (Throwable th3) {
                    h.a.v0.b.b(th3);
                    h.a.c1.a.b(th3);
                }
            }
        } catch (Throwable th4) {
            h.a.v0.b.b(th4);
            h.a.y0.a.e.error(th4, vVar);
        }
    }
}
