package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeSwitchIfEmptySingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e1<T> extends h.a.k0<T> implements h.a.y0.c.f<T> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.q0<? extends T> f11128b;

    /* JADX INFO: compiled from: MaybeSwitchIfEmptySingle.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4603919676453758899L;
        final h.a.n0<? super T> actual;
        final h.a.q0<? extends T> other;

        /* JADX INFO: renamed from: h.a.y0.e.c.e1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeSwitchIfEmptySingle.java */
        static final class C0203a<T> implements h.a.n0<T> {
            final h.a.n0<? super T> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<h.a.u0.c> f11129b;

            C0203a(h.a.n0<? super T> n0Var, AtomicReference<h.a.u0.c> atomicReference) {
                this.a = n0Var;
                this.f11129b = atomicReference;
            }

            @Override // h.a.n0
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // h.a.n0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this.f11129b, cVar);
            }

            @Override // h.a.n0
            public void onSuccess(T t) {
                this.a.onSuccess(t);
            }
        }

        a(h.a.n0<? super T> n0Var, h.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.other = q0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            h.a.u0.c cVar = get();
            if (cVar == h.a.y0.a.d.DISPOSED || !compareAndSet(cVar, null)) {
                return;
            }
            this.other.a(new C0203a(this.actual, this));
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public e1(h.a.y<T> yVar, h.a.q0<? extends T> q0Var) {
        this.a = yVar;
        this.f11128b = q0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11128b));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
