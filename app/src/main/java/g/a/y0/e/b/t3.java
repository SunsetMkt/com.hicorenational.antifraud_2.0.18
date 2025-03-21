package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSwitchMap.java */
/* loaded from: classes2.dex */
public final class t3<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f14632c;

    /* renamed from: d, reason: collision with root package name */
    final int f14633d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14634e;

    /* compiled from: FlowableSwitchMap.java */
    static final class a<T, R> extends AtomicReference<i.d.d> implements g.a.q<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final b<T, R> parent;
        volatile g.a.y0.c.o<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.bufferSize = i2;
        }

        public void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                this.done = true;
                bVar.drain();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            b<T, R> bVar = this.parent;
            if (this.index != bVar.unique || !bVar.error.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!bVar.delayErrors) {
                bVar.s.cancel();
            }
            this.done = true;
            bVar.drain();
        }

        @Override // i.d.c
        public void onNext(R r) {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r)) {
                    bVar.drain();
                } else {
                    onError(new g.a.v0.c("Queue full?!"));
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = lVar;
                        dVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.bufferSize);
                dVar.request(this.bufferSize);
            }
        }
    }

    /* compiled from: FlowableSwitchMap.java */
    static final class b<T, R> extends AtomicInteger implements g.a.q<T>, i.d.d {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final i.d.c<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> mapper;
        i.d.d s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final g.a.y0.j.c error = new g.a.y0.j.c();

        static {
            CANCELLED.cancel();
        }

        b(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
            this.actual = cVar;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            disposeInner();
        }

        void disposeInner() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.active.get();
            a<Object, Object> aVar3 = CANCELLED;
            if (aVar2 == aVar3 || (aVar = (a) this.active.getAndSet(aVar3)) == CANCELLED || aVar == null) {
                return;
            }
            aVar.cancel();
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x011d, code lost:
        
            if (r12 == 0) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0121, code lost:
        
            if (r17.cancelled != false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x012a, code lost:
        
            if (r8 == h.q2.t.m0.f16408b) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x012c, code lost:
        
            r17.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0132, code lost:
        
            r6.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x013b, code lost:
        
            if (r14 == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x000c, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.t3.b.drain():void");
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            a<T, R> aVar;
            if (this.done) {
                return;
            }
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.mapper.apply(t), "The publisher returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                bVar.subscribe(aVar3);
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
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                if (this.unique == 0) {
                    this.s.request(h.q2.t.m0.f16408b);
                } else {
                    drain();
                }
            }
        }
    }

    public t3(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, boolean z) {
        super(lVar);
        this.f14632c = oVar;
        this.f14633d = i2;
        this.f14634e = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        if (d3.a(this.f14110b, cVar, this.f14632c)) {
            return;
        }
        this.f14110b.a((g.a.q) new b(cVar, this.f14632c, this.f14633d, this.f14634e));
    }
}
