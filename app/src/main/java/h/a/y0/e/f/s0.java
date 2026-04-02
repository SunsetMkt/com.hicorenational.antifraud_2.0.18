package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleUnsubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11884b;

    /* JADX INFO: compiled from: SingleUnsubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final h.a.n0<? super T> actual;
        h.a.u0.c ds;
        final h.a.j0 scheduler;

        a(h.a.n0<? super T> n0Var, h.a.j0 j0Var) {
            this.actual = n0Var;
            this.scheduler = j0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.u0.c andSet = getAndSet(h.a.y0.a.d.DISPOSED);
            if (andSet != h.a.y0.a.d.DISPOSED) {
                this.ds = andSet;
                this.scheduler.a(this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
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

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public s0(h.a.q0<T> q0Var, h.a.j0 j0Var) {
        this.a = q0Var;
        this.f11884b = j0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11884b));
    }
}
