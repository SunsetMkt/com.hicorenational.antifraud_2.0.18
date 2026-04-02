package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableThrottleFirstTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11561d;

    /* JADX INFO: compiled from: ObservableThrottleFirstTimed.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final h.a.i0<? super T> actual;
        boolean done;
        volatile boolean gate;
        h.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        a(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
            this.actual = i0Var;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.actual.onNext(t);
            h.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            h.a.y0.a.d.replace(this, this.worker.a(this, this.timeout, this.unit));
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public p3(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(g0Var);
        this.f11559b = j2;
        this.f11560c = timeUnit;
        this.f11561d = j0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(new h.a.a1.m(i0Var), this.f11559b, this.f11560c, this.f11561d.a()));
    }
}
