package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11697b;

    /* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
    static final class a<T> extends AtomicBoolean implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 1015244841293359600L;
        final h.a.i0<? super T> actual;
        h.a.u0.c s;
        final h.a.j0 scheduler;

        /* JADX INFO: renamed from: h.a.y0.e.d.w3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
        final class RunnableC0220a implements Runnable {
            RunnableC0220a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.s.dispose();
            }
        }

        a(h.a.i0<? super T> i0Var, h.a.j0 j0Var) {
            this.actual = i0Var;
            this.scheduler = j0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.a(new RunnableC0220a());
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (get()) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public w3(h.a.g0<T> g0Var, h.a.j0 j0Var) {
        super(g0Var);
        this.f11697b = j0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11697b));
    }
}
