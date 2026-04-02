package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableTimeoutTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final h.a.u0.c f11618f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.g0<? extends T> f11622e;

    /* JADX INFO: compiled from: ObservableTimeoutTimed.java */
    static final class a implements h.a.u0.c {
        a() {
        }

        @Override // h.a.u0.c
        public void dispose() {
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return true;
        }
    }

    /* JADX INFO: compiled from: ObservableTimeoutTimed.java */
    static final class b<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -8387234228317808253L;
        final h.a.i0<? super T> actual;
        volatile boolean done;
        volatile long index;
        h.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        /* JADX INFO: compiled from: ObservableTimeoutTimed.java */
        final class a implements Runnable {
            private final long a;

            a(long j2) {
                this.a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a == b.this.index) {
                    b bVar = b.this;
                    bVar.done = true;
                    bVar.s.dispose();
                    h.a.y0.a.d.dispose(b.this);
                    b.this.actual.onError(new TimeoutException());
                    b.this.worker.dispose();
                }
            }
        }

        b(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
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
            dispose();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            scheduleTimeout(j2);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        void scheduleTimeout(long j2) {
            h.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            if (compareAndSet(cVar, s3.f11618f)) {
                h.a.y0.a.d.replace(this, this.worker.a(new a(j2), this.timeout, this.unit));
            }
        }
    }

    /* JADX INFO: compiled from: ObservableTimeoutTimed.java */
    static final class c<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -4619702551964128179L;
        final h.a.i0<? super T> actual;
        final h.a.y0.a.j<T> arbiter;
        volatile boolean done;
        volatile long index;
        final h.a.g0<? extends T> other;
        h.a.u0.c s;
        final long timeout;
        final TimeUnit unit;
        final j0.c worker;

        /* JADX INFO: compiled from: ObservableTimeoutTimed.java */
        final class a implements Runnable {
            private final long a;

            a(long j2) {
                this.a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a == c.this.index) {
                    c cVar = c.this;
                    cVar.done = true;
                    cVar.s.dispose();
                    h.a.y0.a.d.dispose(c.this);
                    c.this.subscribeNext();
                    c.this.worker.dispose();
                }
            }
        }

        c(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar, h.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
            this.other = g0Var;
            this.arbiter = new h.a.y0.a.j<>(i0Var, this, 8);
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
            this.arbiter.a(this.s);
            this.worker.dispose();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.arbiter.a(th, this.s);
            this.worker.dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.a(t, this.s)) {
                scheduleTimeout(j2);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (this.arbiter.b(cVar)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(long j2) {
            h.a.u0.c cVar = get();
            if (cVar != null) {
                cVar.dispose();
            }
            if (compareAndSet(cVar, s3.f11618f)) {
                h.a.y0.a.d.replace(this, this.worker.a(new a(j2), this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new h.a.y0.d.q(this.arbiter));
        }
    }

    public s3(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, h.a.g0<? extends T> g0Var2) {
        super(g0Var);
        this.f11619b = j2;
        this.f11620c = timeUnit;
        this.f11621d = j0Var;
        this.f11622e = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        if (this.f11622e == null) {
            this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11619b, this.f11620c, this.f11621d.a()));
        } else {
            this.a.subscribe(new c(i0Var, this.f11619b, this.f11620c, this.f11621d.a(), this.f11622e));
        }
    }
}
