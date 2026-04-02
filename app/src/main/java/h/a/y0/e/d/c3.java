package h.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableSkipLastTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f11277f;

    /* JADX INFO: compiled from: ObservableSkipLastTimed.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -5677354903406201275L;
        final h.a.i0<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final h.a.y0.f.c<Object> queue;
        h.a.u0.c s;
        final h.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
            this.actual = i0Var;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = j0Var;
            this.queue = new h.a.y0.f.c<>(i2);
            this.delayError = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.i0<? super T> i0Var = this.actual;
            h.a.y0.f.c<Object> cVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            h.a.j0 j0Var = this.scheduler;
            long j2 = this.time;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l2 = (Long) cVar.a();
                boolean z3 = l2 == null;
                long jA = j0Var.a(timeUnit);
                if (!z3 && l2.longValue() > jA - j2) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            i0Var.onError(th);
                            return;
                        } else if (z3) {
                            i0Var.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            i0Var.onError(th2);
                            return;
                        } else {
                            i0Var.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    cVar.poll();
                    i0Var.onNext(cVar.poll());
                }
            }
            this.queue.clear();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.a(this.unit)), t);
            drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public c3(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
        super(g0Var);
        this.f11273b = j2;
        this.f11274c = timeUnit;
        this.f11275d = j0Var;
        this.f11276e = i2;
        this.f11277f = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11273b, this.f11274c, this.f11275d, this.f11276e, this.f11277f));
    }
}
