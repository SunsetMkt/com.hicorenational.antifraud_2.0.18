package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableObserveOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f10612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f10614e;

    /* JADX INFO: compiled from: FlowableObserveOn.java */
    static abstract class a<T> extends h.a.y0.i.c<T> implements h.a.q<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        h.a.y0.c.o<T> queue;
        final AtomicLong requested = new AtomicLong();
        j.d.d s;
        int sourceMode;
        final j0.c worker;

        a(j0.c cVar, boolean z, int i2) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // j.d.d
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

        final boolean checkTerminated(boolean z, boolean z2, j.d.c<?> cVar) {
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

        @Override // h.a.y0.c.o
        public final void clear() {
            this.queue.clear();
        }

        @Override // h.a.y0.c.o
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // j.d.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // j.d.c
        public final void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // j.d.c
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
                this.error = new h.a.v0.c("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // j.d.d
        public final void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                trySchedule();
            }
        }

        @Override // h.a.y0.c.k
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

    /* JADX INFO: compiled from: FlowableObserveOn.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final h.a.y0.c.a<? super T> actual;
        long consumed;

        b(h.a.y0.c.a<? super T> aVar, j0.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.actual = aVar;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j2 = this.consumed + 1;
                if (j2 == this.limit) {
                    this.consumed = 0L;
                    this.s.request(j2);
                } else {
                    this.consumed = j2;
                }
            }
            return tPoll;
        }

        @Override // h.a.y0.e.b.d2.a
        void runAsync() {
            h.a.y0.c.a<? super T> aVar = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            long j3 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j4 = this.requested.get();
                while (j2 != j4) {
                    boolean z = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, aVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (aVar.tryOnNext(tPoll)) {
                            j2++;
                        }
                        j3++;
                        if (j3 == this.limit) {
                            this.s.request(j3);
                            j3 = 0;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
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
                int i2 = get();
                if (iAddAndGet == i2) {
                    this.produced = j2;
                    this.consumed = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i2;
                }
            }
        }

        @Override // h.a.y0.e.b.d2.a
        void runBackfused() {
            int iAddAndGet = 1;
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
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // h.a.y0.e.b.d2.a
        void runSync() {
            h.a.y0.c.a<? super T> aVar = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T tPoll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (aVar.tryOnNext(tPoll)) {
                            j2++;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
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
                int i2 = get();
                if (iAddAndGet == i2) {
                    this.produced = j2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlowableObserveOn.java */
    static final class c<T> extends a<T> implements h.a.q<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final j.d.c<? super T> actual;

        c(j.d.c<? super T> cVar, j0.c cVar2, boolean z, int i2) {
            super(cVar2, z, i2);
            this.actual = cVar;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j2 = this.produced + 1;
                if (j2 == this.limit) {
                    this.produced = 0L;
                    this.s.request(j2);
                } else {
                    this.produced = j2;
                }
            }
            return tPoll;
        }

        @Override // h.a.y0.e.b.d2.a
        void runAsync() {
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested.get();
                while (j2 != jAddAndGet) {
                    boolean z = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j2++;
                        if (j2 == this.limit) {
                            if (jAddAndGet != i.q2.t.m0.f12222b) {
                                jAddAndGet = this.requested.addAndGet(-j2);
                            }
                            this.s.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.s.cancel();
                        oVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 == jAddAndGet && checkTerminated(this.done, oVar.isEmpty(), cVar)) {
                    return;
                }
                int i2 = get();
                if (iAddAndGet == i2) {
                    this.produced = j2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i2;
                }
            }
        }

        @Override // h.a.y0.e.b.d2.a
        void runBackfused() {
            int iAddAndGet = 1;
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
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // h.a.y0.e.b.d2.a
        void runSync() {
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            long j2 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T tPoll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else {
                            cVar.onNext(tPoll);
                            j2++;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
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
                int i2 = get();
                if (iAddAndGet == i2) {
                    this.produced = j2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i2;
                }
            }
        }
    }

    public d2(h.a.l<T> lVar, h.a.j0 j0Var, boolean z, int i2) {
        super(lVar);
        this.f10612c = j0Var;
        this.f10613d = z;
        this.f10614e = i2;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        j0.c cVarA = this.f10612c.a();
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new b((h.a.y0.c.a) cVar, cVarA, this.f10613d, this.f10614e));
        } else {
            this.f10561b.a((h.a.q) new c(cVar, cVarA, this.f10613d, this.f10614e));
        }
    }
}
