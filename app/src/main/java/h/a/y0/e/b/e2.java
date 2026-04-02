package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f10637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x0.a f10638f;

    /* JADX INFO: compiled from: FlowableOnBackpressureBuffer.java */
    static final class a<T> extends h.a.y0.i.c<T> implements h.a.q<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final h.a.x0.a onOverflow;
        boolean outputFused;
        final h.a.y0.c.n<T> queue;
        final AtomicLong requested = new AtomicLong();
        j.d.d s;

        a(j.d.c<? super T> cVar, int i2, boolean z, boolean z2, h.a.x0.a aVar) {
            this.actual = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            this.queue = z ? new h.a.y0.f.c<>(i2) : new h.a.y0.f.b<>(i2);
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

        boolean checkTerminated(boolean z, boolean z2, j.d.c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
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

        @Override // h.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                h.a.y0.c.n<T> nVar = this.queue;
                j.d.c<? super T> cVar = this.actual;
                int iAddAndGet = 1;
                while (!checkTerminated(this.done, nVar.isEmpty(), cVar)) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z = this.done;
                        T tPoll = nVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j3++;
                    }
                    if (j3 == j2 && checkTerminated(this.done, nVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j3 != 0 && j2 != i.q2.t.m0.f12222b) {
                        this.requested.addAndGet(-j3);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.actual.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.s.cancel();
            h.a.v0.c cVar = new h.a.v0.c("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // j.d.d
        public void request(long j2) {
            if (this.outputFused || !h.a.y0.i.j.validate(j2)) {
                return;
            }
            h.a.y0.j.d.a(this.requested, j2);
            drain();
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public e2(h.a.l<T> lVar, int i2, boolean z, boolean z2, h.a.x0.a aVar) {
        super(lVar);
        this.f10635c = i2;
        this.f10636d = z;
        this.f10637e = z2;
        this.f10638f = aVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10635c, this.f10636d, this.f10637e, this.f10638f));
    }
}
