package h.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableTakeLastTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f11058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TimeUnit f11059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.j0 f11060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f11061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f11062h;

    /* JADX INFO: compiled from: FlowableTakeLastTimed.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -5677354903406201275L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final h.a.y0.f.c<Object> queue;
        final AtomicLong requested = new AtomicLong();
        j.d.d s;
        final h.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(j.d.c<? super T> cVar, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
            this.actual = cVar;
            this.count = j2;
            this.time = j3;
            this.unit = timeUnit;
            this.scheduler = j0Var;
            this.queue = new h.a.y0.f.c<>(i2);
            this.delayError = z;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, j.d.c<? super T> cVar, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (!z) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.f.c<Object> cVar2 = this.queue;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            do {
                if (this.done) {
                    if (checkTerminated(cVar2.isEmpty(), cVar, z)) {
                        return;
                    }
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        if (checkTerminated(cVar2.a() == null, cVar, z)) {
                            return;
                        }
                        if (j2 != j3) {
                            cVar2.poll();
                            cVar.onNext(cVar2.poll());
                            j3++;
                        } else if (j3 != 0) {
                            h.a.y0.j.d.c(this.requested, j3);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            trim(this.scheduler.a(this.unit), this.queue);
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.a(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            h.a.y0.f.c<Object> cVar = this.queue;
            long jA = this.scheduler.a(this.unit);
            cVar.offer(Long.valueOf(jA), t);
            trim(jA, cVar);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        void trim(long j2, h.a.y0.f.c<Object> cVar) {
            long j3 = this.time;
            long j4 = this.count;
            boolean z = j4 == i.q2.t.m0.f12222b;
            while (!cVar.isEmpty()) {
                if (((Long) cVar.a()).longValue() >= j2 - j3 && (z || (cVar.b() >> 1) <= j4)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }
    }

    public x3(h.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
        super(lVar);
        this.f11057c = j2;
        this.f11058d = j3;
        this.f11059e = timeUnit;
        this.f11060f = j0Var;
        this.f11061g = i2;
        this.f11062h = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11057c, this.f11058d, this.f11059e, this.f11060f, this.f11061g, this.f11062h));
    }
}
