package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeUnsubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p1<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11173b;

    /* JADX INFO: compiled from: MaybeUnsubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final h.a.v<? super T> actual;
        h.a.u0.c ds;
        final h.a.j0 scheduler;

        a(h.a.v<? super T> vVar, h.a.j0 j0Var) {
            this.actual = vVar;
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

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
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

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public p1(h.a.y<T> yVar, h.a.j0 j0Var) {
        super(yVar);
        this.f11173b = j0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11173b));
    }
}
