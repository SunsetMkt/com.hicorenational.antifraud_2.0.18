package h.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableSampleTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11581e;

    /* JADX INFO: compiled from: ObservableSampleTimed.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(i0Var, j2, timeUnit, j0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // h.a.y0.e.d.q2.c
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: ObservableSampleTimed.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(i0Var, j2, timeUnit, j0Var);
        }

        @Override // h.a.y0.e.d.q2.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* JADX INFO: compiled from: ObservableSampleTimed.java */
    static abstract class c<T> extends AtomicReference<T> implements h.a.i0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final h.a.i0<? super T> actual;
        final long period;
        h.a.u0.c s;
        final h.a.j0 scheduler;
        final AtomicReference<h.a.u0.c> timer = new AtomicReference<>();
        final TimeUnit unit;

        c(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.actual = i0Var;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
        }

        void cancelTimer() {
            h.a.y0.a.d.dispose(this.timer);
        }

        abstract void complete();

        @Override // h.a.u0.c
        public void dispose() {
            cancelTimer();
            this.s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                h.a.j0 j0Var = this.scheduler;
                long j2 = this.period;
                h.a.y0.a.d.replace(this.timer, j0Var.a(this, j2, j2, this.unit));
            }
        }
    }

    public q2(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        super(g0Var);
        this.f11578b = j2;
        this.f11579c = timeUnit;
        this.f11580d = j0Var;
        this.f11581e = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        if (this.f11581e) {
            this.a.subscribe(new a(mVar, this.f11578b, this.f11579c, this.f11580d));
        } else {
            this.a.subscribe(new b(mVar, this.f11578b, this.f11579c, this.f11580d));
        }
    }
}
