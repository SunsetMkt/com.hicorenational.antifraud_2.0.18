package h.a.y0.e.c;

import java.util.Iterator;

/* JADX INFO: compiled from: MaybeFlatMapIterableObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0<T, R> extends h.a.b0<R> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11111b;

    /* JADX INFO: compiled from: MaybeFlatMapIterableObservable.java */
    static final class a<T, R> extends h.a.y0.d.c<R> implements h.a.v<T> {
        final h.a.i0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile Iterator<? extends R> f11114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11115e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11116f;

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.a = i0Var;
            this.f11112b = oVar;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.f11114d = null;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11115e = true;
            this.f11113c.dispose();
            this.f11113c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11115e;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.f11114d == null;
        }

        @Override // h.a.v
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11113c = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11113c, cVar)) {
                this.f11113c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            h.a.i0<? super R> i0Var = this.a;
            try {
                Iterator<? extends R> it = this.f11112b.apply(t).iterator();
                if (!it.hasNext()) {
                    i0Var.onComplete();
                    return;
                }
                this.f11114d = it;
                if (this.f11116f) {
                    i0Var.onNext(null);
                    i0Var.onComplete();
                    return;
                }
                while (!this.f11115e) {
                    try {
                        i0Var.onNext(it.next());
                        if (this.f11115e) {
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
                i0Var.onError(th3);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f11114d;
            if (it == null) {
                return null;
            }
            R r = (R) h.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f11114d = null;
            }
            return r;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f11116f = true;
            return 2;
        }
    }

    public c0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.a = yVar;
        this.f11111b = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        this.a.a(new a(i0Var, this.f11111b));
    }
}
