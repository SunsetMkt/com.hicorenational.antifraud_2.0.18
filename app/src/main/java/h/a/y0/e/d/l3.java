package h.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableTakeLastTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f11457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f11458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f11459g;

    /* JADX INFO: compiled from: ObservableTakeLastTimed.java */
    static final class a<T> extends AtomicBoolean implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -5677354903406201275L;
        final h.a.i0<? super T> actual;
        volatile boolean cancelled;
        final long count;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11460d;
        final boolean delayError;
        Throwable error;
        final h.a.y0.f.c<Object> queue;
        final h.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(h.a.i0<? super T> i0Var, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
            this.actual = i0Var;
            this.count = j2;
            this.time = j3;
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
            this.f11460d.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                h.a.i0<? super T> i0Var = this.actual;
                h.a.y0.f.c<Object> cVar = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        cVar.clear();
                        i0Var.onError(th);
                        return;
                    }
                    Object objPoll = cVar.poll();
                    if (objPoll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            i0Var.onError(th2);
                            return;
                        } else {
                            i0Var.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = cVar.poll();
                    if (((Long) objPoll).longValue() >= this.scheduler.a(this.unit) - this.time) {
                        i0Var.onNext(objPoll2);
                    }
                }
                cVar.clear();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            h.a.y0.f.c<Object> cVar = this.queue;
            long jA = this.scheduler.a(this.unit);
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == i.q2.t.m0.f12222b;
            cVar.offer(Long.valueOf(jA), t);
            while (!cVar.isEmpty()) {
                if (((Long) cVar.a()).longValue() > jA - j2 && (z || (cVar.b() >> 1) <= j3)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11460d, cVar)) {
                this.f11460d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public l3(h.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
        super(g0Var);
        this.f11454b = j2;
        this.f11455c = j3;
        this.f11456d = timeUnit;
        this.f11457e = j0Var;
        this.f11458f = i2;
        this.f11459g = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11454b, this.f11455c, this.f11456d, this.f11457e, this.f11458f, this.f11459g));
    }
}
