package h.a.y0.e.f;

import java.util.Iterator;

/* JADX INFO: compiled from: SingleFlatMapIterableObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y<T, R> extends h.a.b0<R> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11902b;

    /* JADX INFO: compiled from: SingleFlatMapIterableObservable.java */
    static final class a<T, R> extends h.a.y0.d.b<R> implements h.a.n0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11903d;
        volatile Iterator<? extends R> it;
        final h.a.x0.o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.actual = i0Var;
            this.mapper = oVar;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.it = null;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f11903d.dispose();
            this.f11903d = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11903d = h.a.y0.a.d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11903d, cVar)) {
                this.f11903d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            h.a.i0<? super R> i0Var = this.actual;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    i0Var.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    i0Var.onNext(null);
                    i0Var.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        i0Var.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                i0Var.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            i0Var.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        i0Var.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                this.actual.onError(th3);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) h.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public y(h.a.q0<T> q0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.a = q0Var;
        this.f11902b = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        this.a.a(new a(i0Var, this.f11902b));
    }
}
