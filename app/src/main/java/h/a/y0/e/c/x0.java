package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeObserveOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x0<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11200b;

    /* JADX INFO: compiled from: MaybeObserveOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final h.a.v<? super T> actual;
        Throwable error;
        final h.a.j0 scheduler;
        T value;

        a(h.a.v<? super T> vVar, h.a.j0 j0Var) {
            this.actual = vVar;
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

        @Override // h.a.v
        public void onComplete() {
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.error = th;
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.value = t;
            h.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t == null) {
                this.actual.onComplete();
            } else {
                this.value = null;
                this.actual.onSuccess(t);
            }
        }
    }

    public x0(h.a.y<T> yVar, h.a.j0 j0Var) {
        super(yVar);
        this.f11200b = j0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11200b));
    }
}
