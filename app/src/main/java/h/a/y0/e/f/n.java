package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SingleDoFinally.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class n<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.a f11861b;

    /* JADX INFO: compiled from: SingleDoFinally.java */
    static final class a<T> extends AtomicInteger implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final h.a.n0<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11862d;
        final h.a.x0.a onFinally;

        a(h.a.n0<? super T> n0Var, h.a.x0.a aVar) {
            this.actual = n0Var;
            this.onFinally = aVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11862d.dispose();
            runFinally();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11862d.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11862d, cVar)) {
                this.f11862d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }
    }

    public n(h.a.q0<T> q0Var, h.a.x0.a aVar) {
        this.a = q0Var;
        this.f11861b = aVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11861b));
    }
}
