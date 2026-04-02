package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleObserveOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11848b;

    /* JADX INFO: compiled from: SingleObserveOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final h.a.n0<? super T> actual;
        Throwable error;
        final h.a.j0 scheduler;
        T value;

        a(h.a.n0<? super T> n0Var, h.a.j0 j0Var) {
            this.actual = n0Var;
            this.scheduler = j0Var;
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
            this.error = th;
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.value = t;
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onSuccess(this.value);
            }
        }
    }

    public j0(h.a.q0<T> q0Var, h.a.j0 j0Var) {
        this.a = q0Var;
        this.f11848b = j0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11848b));
    }
}
