package h.a.y0.e.d;

import h.a.j0;

/* JADX INFO: compiled from: ObservableObserveOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y1<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11716d;

    /* JADX INFO: compiled from: ObservableObserveOn.java */
    static final class a<T> extends h.a.y0.d.b<T> implements h.a.i0<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final h.a.i0<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        h.a.y0.c.o<T> queue;
        h.a.u0.c s;
        int sourceMode;
        final j0.c worker;

        a(h.a.i0<? super T> i0Var, j0.c cVar, boolean z, int i2) {
            this.actual = i0Var;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        boolean checkTerminated(boolean z, boolean z2, h.a.i0<? super T> i0Var) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                if (th != null) {
                    i0Var.onError(th);
                } else {
                    i0Var.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.queue.clear();
                i0Var.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            i0Var.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drainFused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.actual.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.actual.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.actual.onError(th2);
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

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainNormal() {
            h.a.y0.c.o<T> oVar = this.queue;
            h.a.i0<? super T> i0Var = this.actual;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, oVar.isEmpty(), i0Var)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, i0Var)) {
                            return;
                        }
                        if (z2) {
                            break;
                        } else {
                            i0Var.onNext(tPoll);
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.s.dispose();
                        oVar.clear();
                        i0Var.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (cVar instanceof h.a.y0.c.j) {
                    h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    public y1(h.a.g0<T> g0Var, h.a.j0 j0Var, boolean z, int i2) {
        super(g0Var);
        this.f11714b = j0Var;
        this.f11715c = z;
        this.f11716d = i2;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        h.a.j0 j0Var = this.f11714b;
        if (j0Var instanceof h.a.y0.g.r) {
            this.a.subscribe(i0Var);
        } else {
            this.a.subscribe(new a(i0Var, j0Var.a(), this.f11715c, this.f11716d));
        }
    }
}
