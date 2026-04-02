package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableFlatMapMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z0<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> f11081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11083e;

    /* JADX INFO: compiled from: FlowableFlatMapMaybe.java */
    static final class a<T, R> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 8600231336733376951L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> mapper;
        final int maxConcurrency;
        j.d.d s;
        final AtomicLong requested = new AtomicLong();
        final h.a.u0.b set = new h.a.u0.b();
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<h.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* JADX INFO: renamed from: h.a.y0.e.b.z0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableFlatMapMaybe.java */
        final class C0199a extends AtomicReference<h.a.u0.c> implements h.a.v<R>, h.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0199a() {
            }

            @Override // h.a.u0.c
            public void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.u0.c
            public boolean isDisposed() {
                return h.a.y0.a.d.isDisposed(get());
            }

            @Override // h.a.v
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar, boolean z, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        void clear() {
            h.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        
            r2 = r17.errors.terminate();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        
            if (r12 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
        
            r2 = r17.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
        
            h.a.y0.j.d.c(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
        
            r17.s.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            j.d.c<? super R> cVar = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<h.a.y0.f.c<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (true) {
                    boolean z = false;
                    if (j3 == j2) {
                        break;
                    }
                    if (this.cancelled) {
                        clear();
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        Throwable thTerminate = this.errors.terminate();
                        clear();
                        cVar.onError(thTerminate);
                        return;
                    }
                    boolean z2 = atomicInteger.get() == 0;
                    h.a.y0.f.c<R> cVar2 = atomicReference.get();
                    defpackage.a aVarPoll = cVar2 != null ? cVar2.poll() : null;
                    boolean z3 = aVarPoll == null;
                    if (z2 && z3) {
                        Throwable thTerminate2 = this.errors.terminate();
                        if (thTerminate2 != null) {
                            cVar.onError(thTerminate2);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    cVar.onNext(aVarPoll);
                    j3++;
                }
            } while (iAddAndGet != 0);
        }

        h.a.y0.f.c<R> getOrCreateQueue() {
            h.a.y0.f.c<R> cVar;
            do {
                h.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.a.y0.f.c<>(h.a.l.Q());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerComplete(a<T, R>.C0199a c0199a) {
            this.set.c(c0199a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    h.a.y0.f.c<R> cVar = this.queue.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable thTerminate = this.errors.terminate();
                        if (thTerminate != null) {
                            this.actual.onError(thTerminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
            drain();
        }

        void innerError(a<T, R>.C0199a c0199a, Throwable th) {
            this.set.c(c0199a);
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
            this.active.decrementAndGet();
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerSuccess(a<T, R>.C0199a c0199a, R r) {
            this.set.c(c0199a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.actual.onNext(r);
                        h.a.y0.f.c<R> cVar = this.queue.get();
                        if (z && (cVar == null || cVar.isEmpty())) {
                            Throwable thTerminate = this.errors.terminate();
                            if (thTerminate != null) {
                                this.actual.onError(thTerminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        }
                        h.a.y0.j.d.c(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.s.request(1L);
                        }
                    } else {
                        h.a.y0.f.c<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    h.a.y0.f.c<R> orCreateQueue2 = getOrCreateQueue();
                    synchronized (orCreateQueue2) {
                        orCreateQueue2.offer(r);
                    }
                    this.active.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            drainLoop();
        }

        @Override // j.d.c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            try {
                h.a.y yVar = (h.a.y) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0199a c0199a = new C0199a();
                if (this.cancelled || !this.set.b(c0199a)) {
                    return;
                }
                yVar.a(c0199a);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(i.q2.t.m0.f12222b);
                } else {
                    dVar.request(i2);
                }
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

    public z0(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar, boolean z, int i2) {
        super(lVar);
        this.f11081c = oVar;
        this.f11082d = z;
        this.f11083e = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11081c, this.f11082d, this.f11083e));
    }
}
