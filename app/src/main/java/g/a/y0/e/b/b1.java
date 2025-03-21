package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapSingle.java */
/* loaded from: classes2.dex */
public final class b1<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f14130c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14131d;

    /* renamed from: e, reason: collision with root package name */
    final int f14132e;

    /* compiled from: FlowableFlatMapSingle.java */
    static final class a<T, R> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 8600231336733376951L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> mapper;
        final int maxConcurrency;
        i.d.d s;
        final AtomicLong requested = new AtomicLong();
        final g.a.u0.b set = new g.a.u0.b();
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<g.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* compiled from: FlowableFlatMapSingle.java */
        /* renamed from: g.a.y0.e.b.b1$a$a, reason: collision with other inner class name */
        final class C0187a extends AtomicReference<g.a.u0.c> implements g.a.n0<R>, g.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0187a() {
            }

            @Override // g.a.u0.c
            public void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.u0.c
            public boolean isDisposed() {
                return g.a.y0.a.d.isDisposed(get());
            }

            @Override // g.a.n0
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // g.a.n0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar, boolean z, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        void clear() {
            g.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
        
            r2 = r17.errors.terminate();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
        
            if (r12 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b8, code lost:
        
            r2 = r17.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        
            g.a.y0.j.d.c(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        
            r17.s.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.b1.a.drainLoop():void");
        }

        g.a.y0.f.c<R> getOrCreateQueue() {
            g.a.y0.f.c<R> cVar;
            do {
                g.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new g.a.y0.f.c<>(g.a.l.Q());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerError(a<T, R>.C0187a c0187a, Throwable th) {
            this.set.c(c0187a);
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
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

        void innerSuccess(a<T, R>.C0187a c0187a, R r) {
            this.set.c(c0187a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.actual.onNext(r);
                        g.a.y0.f.c<R> cVar = this.queue.get();
                        if (z && (cVar == null || cVar.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.actual.onError(terminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        }
                        g.a.y0.j.d.c(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.s.request(1L);
                        }
                    } else {
                        g.a.y0.f.c<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            g.a.y0.f.c<R> orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // i.d.c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                g.a.q0 q0Var = (g.a.q0) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                C0187a c0187a = new C0187a();
                if (this.cancelled || !this.set.b(c0187a)) {
                    return;
                }
                q0Var.a(c0187a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(h.q2.t.m0.f16408b);
                } else {
                    dVar.request(i2);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public b1(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar, boolean z, int i2) {
        super(lVar);
        this.f14130c = oVar;
        this.f14131d = z;
        this.f14132e = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14130c, this.f14131d, this.f14132e));
    }
}
