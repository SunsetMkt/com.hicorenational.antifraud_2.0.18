package h.a.y0.e.f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleTimeout.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.q0<? extends T> f11869e;

    /* JADX INFO: compiled from: SingleTimeout.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, Runnable, h.a.u0.c {
        private static final long serialVersionUID = 37497744973048446L;
        final h.a.n0<? super T> actual;
        final C0228a<T> fallback;
        h.a.q0<? extends T> other;
        final AtomicReference<h.a.u0.c> task = new AtomicReference<>();

        /* JADX INFO: renamed from: h.a.y0.e.f.o0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleTimeout.java */
        static final class C0228a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final h.a.n0<? super T> actual;

            C0228a(h.a.n0<? super T> n0Var) {
                this.actual = n0Var;
            }

            @Override // h.a.n0
            public void onError(Throwable th) {
                this.actual.onError(th);
            }

            @Override // h.a.n0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // h.a.n0
            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }
        }

        a(h.a.n0<? super T> n0Var, h.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.other = q0Var;
            if (q0Var != null) {
                this.fallback = new C0228a<>(n0Var);
            } else {
                this.fallback = null;
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            h.a.y0.a.d.dispose(this.task);
            C0228a<T> c0228a = this.fallback;
            if (c0228a != null) {
                h.a.y0.a.d.dispose(c0228a);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                h.a.c1.a.b(th);
            } else {
                h.a.y0.a.d.dispose(this.task);
                this.actual.onError(th);
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                return;
            }
            h.a.y0.a.d.dispose(this.task);
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || !compareAndSet(cVar, dVar)) {
                return;
            }
            if (cVar != null) {
                cVar.dispose();
            }
            h.a.q0<? extends T> q0Var = this.other;
            if (q0Var == null) {
                this.actual.onError(new TimeoutException());
            } else {
                this.other = null;
                q0Var.a(this.fallback);
            }
        }
    }

    public o0(h.a.q0<T> q0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, h.a.q0<? extends T> q0Var2) {
        this.a = q0Var;
        this.f11866b = j2;
        this.f11867c = timeUnit;
        this.f11868d = j0Var;
        this.f11869e = q0Var2;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var, this.f11869e);
        n0Var.onSubscribe(aVar);
        h.a.y0.a.d.replace(aVar.task, this.f11868d.a(aVar, this.f11866b, this.f11867c));
        this.a.a(aVar);
    }
}
