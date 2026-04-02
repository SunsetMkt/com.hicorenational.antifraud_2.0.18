package h.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableSkipLastTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f10858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f10859g;

    /* JADX INFO: compiled from: FlowableSkipLastTimed.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -5677354903406201275L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final h.a.y0.f.c<Object> queue;
        final AtomicLong requested = new AtomicLong();
        j.d.d s;
        final h.a.j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
            this.actual = cVar;
            this.time = j2;
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

        boolean checkTerminated(boolean z, boolean z2, j.d.c<? super T> cVar, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
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
            if (!z2) {
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
            TimeUnit timeUnit = this.unit;
            h.a.j0 j0Var = this.scheduler;
            long j2 = this.time;
            int iAddAndGet = 1;
            do {
                long j3 = this.requested.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.done;
                    Long l2 = (Long) cVar2.a();
                    boolean z3 = l2 == null;
                    boolean z4 = (z3 || l2.longValue() <= j0Var.a(timeUnit) - j2) ? z3 : true;
                    if (checkTerminated(z2, z4, cVar, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    cVar2.poll();
                    cVar.onNext(cVar2.poll());
                    j4++;
                }
                if (j4 != 0) {
                    h.a.y0.j.d.c(this.requested, j4);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.a(this.unit)), t);
            drain();
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
    }

    public o3(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, boolean z) {
        super(lVar);
        this.f10855c = j2;
        this.f10856d = timeUnit;
        this.f10857e = j0Var;
        this.f10858f = i2;
        this.f10859g = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10855c, this.f10856d, this.f10857e, this.f10858f, this.f10859g));
    }
}
