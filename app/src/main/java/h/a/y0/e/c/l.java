package h.a.y0.e.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeDelay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11155d;

    /* JADX INFO: compiled from: MaybeDelay.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final h.a.v<? super T> actual;
        final long delay;
        Throwable error;
        final h.a.j0 scheduler;
        final TimeUnit unit;
        T value;

        a(h.a.v<? super T> vVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.actual = vVar;
            this.delay = j2;
            this.unit = timeUnit;
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
            schedule();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.error = th;
            schedule();
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
            schedule();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        void schedule() {
            h.a.y0.a.d.replace(this, this.scheduler.a(this, this.delay, this.unit));
        }
    }

    public l(h.a.y<T> yVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(yVar);
        this.f11153b = j2;
        this.f11154c = timeUnit;
        this.f11155d = j0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11153b, this.f11154c, this.f11155d));
    }
}
