package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleResumeNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0<T> extends h.a.k0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends h.a.q0<? extends T>> f11856b;

    /* JADX INFO: compiled from: SingleResumeNext.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = -5314538511045349925L;
        final h.a.n0<? super T> actual;
        final h.a.x0.o<? super Throwable, ? extends h.a.q0<? extends T>> nextFunction;

        a(h.a.n0<? super T> n0Var, h.a.x0.o<? super Throwable, ? extends h.a.q0<? extends T>> oVar) {
            this.actual = n0Var;
            this.nextFunction = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            try {
                ((h.a.q0) h.a.y0.b.b.a(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).a(new h.a.y0.d.a0(this, this.actual));
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.actual.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public l0(h.a.q0<? extends T> q0Var, h.a.x0.o<? super Throwable, ? extends h.a.q0<? extends T>> oVar) {
        this.a = q0Var;
        this.f11856b = oVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11856b));
    }
}
