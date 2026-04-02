package h.a.y0.e.b;

import h.a.y0.e.b.y1;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableCombineLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T, R> extends h.a.l<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h.a.t0.g
    final j.d.b<? extends T>[] f11003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h.a.t0.g
    final Iterable<? extends j.d.b<? extends T>> f11004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super Object[], ? extends R> f11005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f11007f;

    /* JADX INFO: compiled from: FlowableCombineLatest.java */
    static final class a<T, R> extends h.a.y0.i.c<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        final h.a.x0.o<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final h.a.y0.f.c<Object> queue;
        final AtomicLong requested;
        final b<T>[] subscribers;

        a(j.d.c<? super R> cVar, h.a.x0.o<? super Object[], ? extends R> oVar, int i2, int i3, boolean z) {
            this.actual = cVar;
            this.combiner = oVar;
            b<T>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i4, i3);
            }
            this.subscribers = bVarArr;
            this.latest = new Object[i2];
            this.queue = new h.a.y0.f.c<>(i3);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (b<T> bVar : this.subscribers) {
                bVar.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, j.d.c<?> cVar, h.a.y0.f.c<?> cVar2) {
            if (this.cancelled) {
                cancelAll();
                cVar2.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayErrors) {
                if (!z2) {
                    return false;
                }
                cancelAll();
                Throwable thA = h.a.y0.j.k.a(this.error);
                if (thA == null || thA == h.a.y0.j.k.a) {
                    cVar.onComplete();
                } else {
                    cVar.onError(thA);
                }
                return true;
            }
            Throwable thA2 = h.a.y0.j.k.a(this.error);
            if (thA2 != null && thA2 != h.a.y0.j.k.a) {
                cancelAll();
                cVar2.clear();
                cVar.onError(thA2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancelAll();
            cVar.onComplete();
            return true;
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            j.d.c<? super R> cVar = this.actual;
            h.a.y0.f.c<?> cVar2 = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    Object objPoll = cVar2.poll();
                    boolean z2 = objPoll == null;
                    if (checkTerminated(z, z2, cVar, cVar2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        cVar.onNext((Object) h.a.y0.b.b.a(this.combiner.apply((Object[]) cVar2.poll()), "The combiner returned a null value"));
                        ((b) objPoll).requestOne();
                        j3++;
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        cancelAll();
                        h.a.y0.j.k.a(this.error, th);
                        cVar.onError(h.a.y0.j.k.a(this.error));
                        return;
                    }
                }
                if (j3 == j2 && checkTerminated(this.done, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
                if (j3 != 0 && j2 != i.q2.t.m0.f12222b) {
                    this.requested.addAndGet(-j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void drainOutput() {
            j.d.c<? super R> cVar = this.actual;
            h.a.y0.f.c<Object> cVar2 = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    cVar2.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean zIsEmpty = cVar2.isEmpty();
                if (!zIsEmpty) {
                    cVar.onNext(null);
                }
                if (z && zIsEmpty) {
                    cVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar2.clear();
        }

        void innerComplete(int i2) {
            int i3;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i2] != null && (i3 = this.completedSources + 1) != objArr.length) {
                    this.completedSources = i3;
                } else {
                    this.done = true;
                    drain();
                }
            }
        }

        void innerError(int i2, Throwable th) {
            if (!h.a.y0.j.k.a(this.error, th)) {
                h.a.c1.a.b(th);
            } else {
                if (this.delayErrors) {
                    innerComplete(i2);
                    return;
                }
                cancelAll();
                this.done = true;
                drain();
            }
        }

        void innerValue(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i3 = this.nonEmptySources;
                if (objArr[i2] == null) {
                    i3++;
                    this.nonEmptySources = i3;
                }
                objArr[i2] = t;
                if (objArr.length == i3) {
                    this.queue.offer(this.subscribers[i2], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i2].requestOne();
            } else {
                drain();
            }
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public R poll() throws Exception {
            Object objPoll = this.queue.poll();
            if (objPoll == null) {
                return null;
            }
            R r = (R) h.a.y0.b.b.a(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((b) objPoll).requestOne();
            return r;
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            this.outputFused = i3 != 0;
            return i3;
        }

        void subscribe(j.d.b<? extends T>[] bVarArr, int i2) {
            b<T>[] bVarArr2 = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.done && !this.cancelled; i3++) {
                bVarArr[i3].subscribe(bVarArr2[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableCombineLatest.java */
    static final class b<T> extends AtomicReference<j.d.d> implements h.a.q<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final a<T, ?> parent;
        final int prefetch;
        int produced;

        b(a<T, ?> aVar, int i2, int i3) {
            this.parent = aVar;
            this.index = i2;
            this.prefetch = i3;
            this.limit = i3 - (i3 >> 2);
        }

        public void cancel() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        public void requestOne() {
            int i2 = this.produced + 1;
            if (i2 != this.limit) {
                this.produced = i2;
            } else {
                this.produced = 0;
                get().request(i2);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableCombineLatest.java */
    final class c implements h.a.x0.o<T, R> {
        c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // h.a.x0.o
        public R apply(T t) throws Exception {
            return u.this.f11005d.apply(new Object[]{t});
        }
    }

    public u(@h.a.t0.f j.d.b<? extends T>[] bVarArr, @h.a.t0.f h.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f11003b = bVarArr;
        this.f11004c = null;
        this.f11005d = oVar;
        this.f11006e = i2;
        this.f11007f = z;
    }

    @Override // h.a.l
    public void d(j.d.c<? super R> cVar) {
        int length;
        j.d.b<? extends T>[] bVarArr = this.f11003b;
        if (bVarArr == null) {
            bVarArr = new j.d.b[8];
            try {
                Iterator it = (Iterator) h.a.y0.b.b.a(this.f11004c.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            j.d.b<? extends T> bVar = (j.d.b) h.a.y0.b.b.a(it.next(), "The publisher returned by the iterator is null");
                            if (length == bVarArr.length) {
                                j.d.b<? extends T>[] bVarArr2 = new j.d.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = bVar;
                            length++;
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            h.a.y0.i.g.error(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        h.a.y0.i.g.error(th2, cVar);
                        return;
                    }
                }
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.y0.i.g.error(th3, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            h.a.y0.i.g.complete(cVar);
            return;
        }
        if (length == 1) {
            bVarArr[0].subscribe(new y1.b(cVar, new c()));
            return;
        }
        a aVar = new a(cVar, this.f11005d, length, this.f11006e, this.f11007f);
        cVar.onSubscribe(aVar);
        aVar.subscribe(bVarArr, length);
    }

    public u(@h.a.t0.f Iterable<? extends j.d.b<? extends T>> iterable, @h.a.t0.f h.a.x0.o<? super Object[], ? extends R> oVar, int i2, boolean z) {
        this.f11003b = null;
        this.f11004c = iterable;
        this.f11005d = oVar;
        this.f11006e = i2;
        this.f11007f = z;
    }
}
