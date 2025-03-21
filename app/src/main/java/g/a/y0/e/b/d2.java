package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableObserveOn.java */
/* loaded from: classes2.dex */
public final class d2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14171c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14172d;

    /* renamed from: e, reason: collision with root package name */
    final int f14173e;

    /* compiled from: FlowableObserveOn.java */
    static abstract class a<T> extends g.a.y0.i.c<T> implements g.a.q<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        g.a.y0.c.o<T> queue;
        final AtomicLong requested = new AtomicLong();
        i.d.d s;
        int sourceMode;
        final j0.c worker;

        a(j0.c cVar, boolean z, int i2) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // i.d.d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                clear();
                cVar.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // g.a.y0.c.o
        public final void clear() {
            this.queue.clear();
        }

        @Override // g.a.y0.c.o
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.d.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // i.d.c
        public final void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // i.d.c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.s.cancel();
                this.error = new g.a.v0.c("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // i.d.d
        public final void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                trySchedule();
            }
        }

        @Override // g.a.y0.c.k
        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.a(this);
        }
    }

    /* compiled from: FlowableObserveOn.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final g.a.y0.c.a<? super T> actual;
        long consumed;

        b(g.a.y0.c.a<? super T> aVar, j0.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.actual = aVar;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j2 = this.consumed + 1;
                if (j2 == this.limit) {
                    this.consumed = 0L;
                    this.s.request(j2);
                } else {
                    this.consumed = j2;
                }
            }
            return poll;
        }

        @Override // g.a.y0.e.b.d2.a
        void runAsync() {
            g.a.y0.c.a<? super T> aVar = this.actual;
            g.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            long j3 = this.consumed;
            int i2 = 1;
            while (true) {
                long j4 = this.requested.get();
                while (j2 != j4) {
                    boolean z = this.done;
                    try {
                        T poll = oVar.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, aVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (aVar.tryOnNext(poll)) {
                            j2++;
                        }
                        j3++;
                        if (j3 == this.limit) {
                            this.s.request(j3);
                            j3 = 0;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.s.cancel();
                        oVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 == j4 && checkTerminated(this.done, oVar.isEmpty(), aVar)) {
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    this.consumed = j3;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // g.a.y0.e.b.d2.a
        void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // g.a.y0.e.b.d2.a
        void runSync() {
            g.a.y0.c.a<? super T> aVar = this.actual;
            g.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T poll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (aVar.tryOnNext(poll)) {
                            j2++;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.s.cancel();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (oVar.isEmpty()) {
                    aVar.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }
    }

    /* compiled from: FlowableObserveOn.java */
    static final class c<T> extends a<T> implements g.a.q<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final i.d.c<? super T> actual;

        c(i.d.c<? super T> cVar, j0.c cVar2, boolean z, int i2) {
            super(cVar2, z, i2);
            this.actual = cVar;
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j2 = this.produced + 1;
                if (j2 == this.limit) {
                    this.produced = 0L;
                    this.s.request(j2);
                } else {
                    this.produced = j2;
                }
            }
            return poll;
        }

        @Override // g.a.y0.e.b.d2.a
        void runAsync() {
            i.d.c<? super T> cVar = this.actual;
            g.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    boolean z = this.done;
                    try {
                        T poll = oVar.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(poll);
                        j2++;
                        if (j2 == this.limit) {
                            if (j3 != h.q2.t.m0.f16408b) {
                                j3 = this.requested.addAndGet(-j2);
                            }
                            this.s.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.s.cancel();
                        oVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 == j3 && checkTerminated(this.done, oVar.isEmpty(), cVar)) {
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // g.a.y0.e.b.d2.a
        void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // g.a.y0.e.b.d2.a
        void runSync() {
            i.d.c<? super T> cVar = this.actual;
            g.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T poll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else {
                            cVar.onNext(poll);
                            j2++;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        this.s.cancel();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (oVar.isEmpty()) {
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }
    }

    public d2(g.a.l<T> lVar, g.a.j0 j0Var, boolean z, int i2) {
        super(lVar);
        this.f14171c = j0Var;
        this.f14172d = z;
        this.f14173e = i2;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        j0.c a2 = this.f14171c.a();
        if (cVar instanceof g.a.y0.c.a) {
            this.f14110b.a((g.a.q) new b((g.a.y0.c.a) cVar, a2, this.f14172d, this.f14173e));
        } else {
            this.f14110b.a((g.a.q) new c(cVar, a2, this.f14172d, this.f14173e));
        }
    }
}
