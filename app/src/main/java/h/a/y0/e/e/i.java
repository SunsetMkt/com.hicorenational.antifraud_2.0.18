package h.a.y0.e.e;

import h.a.q;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ParallelJoin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b */
    final h.a.b1.b<? extends T> f11779b;

    /* JADX INFO: renamed from: c */
    final int f11780c;

    /* JADX INFO: renamed from: d */
    final boolean f11781d;

    /* JADX INFO: compiled from: ParallelJoin.java */
    static final class a<T> extends AtomicReference<j.d.d> implements q<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final c<T> parent;
        final int prefetch;
        long produced;
        volatile h.a.y0.c.n<T> queue;

        a(c<T> cVar, int i2) {
            this.parent = cVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public boolean cancel() {
            return h.a.y0.i.j.cancel(this);
        }

        h.a.y0.c.n<T> getQueue() {
            h.a.y0.c.n<T> nVar = this.queue;
            if (nVar != null) {
                return nVar;
            }
            h.a.y0.f.b bVar = new h.a.y0.f.b(this.prefetch);
            this.queue = bVar;
            return bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        public void request(long j2) {
            long j3 = this.produced + j2;
            if (j3 < this.limit) {
                this.produced = j3;
            } else {
                this.produced = 0L;
                get().request(j3);
            }
        }

        public void requestOne() {
            long j2 = this.produced + 1;
            if (j2 != this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    /* JADX INFO: compiled from: ParallelJoin.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        b(j.d.c<? super T> cVar, int i2, int i3) {
            super(cVar, i2, i3);
        }

        @Override // h.a.y0.e.e.i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:125:0x005f, code lost:
        
            if (r13 == false) goto L129;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x0061, code lost:
        
            if (r11 == false) goto L129;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x0063, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0066, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0067, code lost:
        
            if (r11 == false) goto L131;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0069, code lost:
        
            r10 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x006f, code lost:
        
            if (r10 != r6) goto L159;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x0073, code lost:
        
            if (r17.cancelled == false) goto L138;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0075, code lost:
        
            cleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x0078, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0079, code lost:
        
            r4 = r17.errors.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x0081, code lost:
        
            if (r4 == null) goto L142;
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0083, code lost:
        
            cleanup();
            r3.onError(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0089, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0090, code lost:
        
            if (r17.done.get() != 0) goto L145;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x0092, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0094, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0095, code lost:
        
            r12 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0096, code lost:
        
            if (r12 >= r2) goto L186;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0098, code lost:
        
            r13 = r1[r12].queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x009c, code lost:
        
            if (r13 == null) goto L188;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x00a2, code lost:
        
            if (r13.isEmpty() != false) goto L189;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x00a4, code lost:
        
            r16 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x00a7, code lost:
        
            r12 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x00aa, code lost:
        
            r16 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x00ac, code lost:
        
            if (r4 == false) goto L159;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x00ae, code lost:
        
            if (r16 == false) goto L159;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x00b0, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x00b3, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x00b6, code lost:
        
            if (r10 == 0) goto L164;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x00bf, code lost:
        
            if (r6 == i.q2.t.m0.f12222b) goto L164;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x00c1, code lost:
        
            r17.requested.addAndGet(-r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x00c7, code lost:
        
            r4 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x00cb, code lost:
        
            if (r4 != r5) goto L177;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x00cd, code lost:
        
            r4 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x00d2, code lost:
        
            if (r4 != 0) goto L178;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x00d4, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            int iAddAndGet;
            long j2;
            T tPoll;
            a<T>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            j.d.c<? super T> cVar = this.actual;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                long j4 = 0;
                while (true) {
                    if (j4 != j3) {
                        if (!this.cancelled) {
                            Throwable th = this.errors.get();
                            if (th == null) {
                                boolean z = this.done.get() == 0;
                                j2 = j4;
                                int i3 = 0;
                                boolean z2 = true;
                                while (true) {
                                    if (i3 >= aVarArr.length) {
                                        break;
                                    }
                                    a<T> aVar = aVarArr[i3];
                                    h.a.y0.c.n<T> nVar = aVar.queue;
                                    if (nVar != null && (tPoll = nVar.poll()) != null) {
                                        cVar.onNext(tPoll);
                                        aVar.requestOne();
                                        long j5 = 1 + j2;
                                        if (j5 == j3) {
                                            j4 = j5;
                                            break;
                                        } else {
                                            j2 = j5;
                                            z2 = false;
                                        }
                                    }
                                    i3++;
                                }
                            } else {
                                cleanup();
                                cVar.onError(th);
                                return;
                            }
                        } else {
                            cleanup();
                            return;
                        }
                    } else {
                        break;
                    }
                    j4 = j2;
                }
                i2 = iAddAndGet;
            }
        }

        @Override // h.a.y0.e.e.i.c
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // h.a.y0.e.e.i.c
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.y0.e.e.i.c
        public void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != m0.f12222b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    cancelAll();
                    h.a.v0.c cVar = new h.a.v0.c("Queue full?!");
                    if (this.errors.compareAndSet(null, cVar)) {
                        this.actual.onError(cVar);
                        return;
                    } else {
                        h.a.c1.a.b(cVar);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!aVar.getQueue().offer(t)) {
                cancelAll();
                onError(new h.a.v0.c("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* JADX INFO: compiled from: ParallelJoin.java */
    static abstract class c<T> extends AtomicInteger implements j.d.d {
        private static final long serialVersionUID = 3100232009247827843L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final a<T>[] subscribers;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        c(j.d.c<? super T> cVar, int i2, int i3) {
            this.actual = cVar;
            a<T>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i3);
            }
            this.subscribers = aVarArr;
            this.done.lazySet(i2);
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].cancel();
                i2++;
            }
        }

        void cleanup() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].queue = null;
                i2++;
            }
        }

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(a<T> aVar, T t);

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    /* JADX INFO: compiled from: ParallelJoin.java */
    static final class d<T> extends c<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        d(j.d.c<? super T> cVar, int i2, int i3) {
            super(cVar, i2, i3);
        }

        @Override // h.a.y0.e.e.i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:117:0x004d, code lost:
        
            if (r13 == false) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x004f, code lost:
        
            if (r11 == false) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0059, code lost:
        
            if (r17.errors.get() == null) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x005b, code lost:
        
            r3.onError(r17.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0065, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0069, code lost:
        
            if (r11 == false) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x006b, code lost:
        
            r10 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean z;
            long j2;
            T tPoll;
            a<T>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            j.d.c<? super T> cVar = this.actual;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                long j4 = 0;
                while (true) {
                    if (j4 != j3) {
                        if (!this.cancelled) {
                            boolean z2 = this.done.get() == 0;
                            j2 = j4;
                            int i3 = 0;
                            boolean z3 = true;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                a<T> aVar = aVarArr[i3];
                                h.a.y0.c.n<T> nVar = aVar.queue;
                                if (nVar != null && (tPoll = nVar.poll()) != null) {
                                    cVar.onNext(tPoll);
                                    aVar.requestOne();
                                    long j5 = 1 + j2;
                                    if (j5 == j3) {
                                        j4 = j5;
                                        break;
                                    } else {
                                        j2 = j5;
                                        z3 = false;
                                    }
                                }
                                i3++;
                            }
                        } else {
                            cleanup();
                            return;
                        }
                    } else {
                        break;
                    }
                    j4 = j2;
                }
                if (j4 == j3) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            h.a.y0.c.n<T> nVar2 = aVarArr[i4].queue;
                            if (nVar2 != null && !nVar2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i4++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        if (this.errors.get() != null) {
                            cVar.onError(this.errors.terminate());
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                if (j4 != 0 && j3 != m0.f12222b) {
                    this.requested.addAndGet(-j4);
                }
                int iAddAndGet = get();
                if (iAddAndGet == i2 && (iAddAndGet = addAndGet(-i2)) == 0) {
                    return;
                } else {
                    i2 = iAddAndGet;
                }
            }
        }

        @Override // h.a.y0.e.e.i.c
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // h.a.y0.e.e.i.c
        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // h.a.y0.e.e.i.c
        void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != m0.f12222b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    aVar.cancel();
                    this.errors.addThrowable(new h.a.v0.c("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!aVar.getQueue().offer(t) && aVar.cancel()) {
                    this.errors.addThrowable(new h.a.v0.c("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public i(h.a.b1.b<? extends T> bVar, int i2, boolean z) {
        this.f11779b = bVar;
        this.f11780c = i2;
        this.f11781d = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        c dVar = this.f11781d ? new d(cVar, this.f11779b.a(), this.f11780c) : new b(cVar, this.f11779b.a(), this.f11780c);
        cVar.onSubscribe(dVar);
        this.f11779b.a(dVar.subscribers);
    }
}
