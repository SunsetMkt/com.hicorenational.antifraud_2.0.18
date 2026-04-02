package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w0<T, U> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends U>> f11029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f11032f;

    /* JADX INFO: compiled from: FlowableFlatMap.java */
    static final class a<T, U> extends AtomicReference<j.d.d> implements h.a.q<U>, h.a.u0.c {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final b<T, U> parent;
        long produced;
        volatile h.a.y0.c.o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.id = j2;
            this.parent = bVar;
            this.bufferSize = bVar.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            lazySet(h.a.y0.i.j.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // j.d.c
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                    }
                }
                dVar.request(this.bufferSize);
            }
        }

        void requestMore(long j2) {
            if (this.fusionMode != 1) {
                long j3 = this.produced + j2;
                if (j3 < this.limit) {
                    this.produced = j3;
                } else {
                    this.produced = 0L;
                    get().request(j3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlowableFlatMap.java */
    static final class b<T, U> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -2117620485640801370L;
        final j.d.c<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        long lastId;
        int lastIndex;
        final h.a.x0.o<? super T, ? extends j.d.b<? extends U>> mapper;
        final int maxConcurrency;
        volatile h.a.y0.c.n<U> queue;
        j.d.d s;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];
        final h.a.y0.j.c errs = new h.a.y0.j.c();
        final AtomicReference<a<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(j.d.c<? super U> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            this.bufferSize = i3;
            this.scalarLimit = Math.max(1, i2 >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        boolean addInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.subscribers.get();
                if (aVarArr == CANCELLED) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.subscribers.compareAndSet(aVarArr, (a<?, ?>[]) aVarArr2));
            return true;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.c.n<U> nVar;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (nVar = this.queue) == null) {
                return;
            }
            nVar.clear();
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            clearScalarQueue();
            Throwable thTerminate = this.errs.terminate();
            if (thTerminate != h.a.y0.j.k.a) {
                this.actual.onError(thTerminate);
            }
            return true;
        }

        void clearScalarQueue() {
            h.a.y0.c.n<U> nVar = this.queue;
            if (nVar != null) {
                nVar.clear();
            }
        }

        void disposeAll() {
            a<?, ?>[] andSet;
            a<?, ?>[] aVarArr = this.subscribers.get();
            a<?, ?>[] aVarArr2 = CANCELLED;
            if (aVarArr == aVarArr2 || (andSet = this.subscribers.getAndSet(aVarArr2)) == CANCELLED) {
                return;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.dispose();
            }
            Throwable thTerminate = this.errs.terminate();
            if (thTerminate == null || thTerminate == h.a.y0.j.k.a) {
                return;
            }
            h.a.c1.a.b(thTerminate);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            long j2;
            long j3;
            boolean z;
            a<T, U>[] aVarArr;
            int i2;
            long j4;
            Object obj;
            j.d.c<? super U> cVar = this.actual;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                h.a.y0.c.n<U> nVar = this.queue;
                long jAddAndGet = this.requested.get();
                boolean z2 = jAddAndGet == i.q2.t.m0.f12222b;
                long j5 = 0;
                long j6 = 0;
                if (nVar != null) {
                    do {
                        long j7 = 0;
                        obj = null;
                        while (true) {
                            if (jAddAndGet == 0) {
                                break;
                            }
                            U uPoll = nVar.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (uPoll == null) {
                                obj = uPoll;
                                break;
                            }
                            cVar.onNext(uPoll);
                            j6++;
                            j7++;
                            jAddAndGet--;
                            obj = uPoll;
                        }
                        if (j7 != 0) {
                            jAddAndGet = z2 ? i.q2.t.m0.f12222b : this.requested.addAndGet(-j7);
                        }
                        if (jAddAndGet == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z3 = this.done;
                h.a.y0.c.n<U> nVar2 = this.queue;
                a<?, ?>[] aVarArr2 = this.subscribers.get();
                int length = aVarArr2.length;
                if (z3 && ((nVar2 == null || nVar2.isEmpty()) && length == 0)) {
                    Throwable thTerminate = this.errs.terminate();
                    if (thTerminate != h.a.y0.j.k.a) {
                        if (thTerminate == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onError(thTerminate);
                            return;
                        }
                    }
                    return;
                }
                int i3 = iAddAndGet;
                if (length != 0) {
                    long j8 = this.lastId;
                    int i4 = this.lastIndex;
                    if (length <= i4 || aVarArr2[i4].id != j8) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        int i5 = i4;
                        for (int i6 = 0; i6 < length && aVarArr2[i5].id != j8; i6++) {
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.lastIndex = i5;
                        this.lastId = aVarArr2[i5].id;
                        i4 = i5;
                    }
                    int i7 = i4;
                    z = false;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            aVarArr = aVarArr2;
                            break;
                        }
                        if (checkTerminate()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr2[i7];
                        Object obj2 = null;
                        while (!checkTerminate()) {
                            h.a.y0.c.o<U> oVar = aVar.queue;
                            if (oVar == null) {
                                aVarArr = aVarArr2;
                                i2 = length;
                            } else {
                                i2 = length;
                                Object obj3 = obj2;
                                aVarArr = aVarArr2;
                                long j9 = j5;
                                while (true) {
                                    if (jAddAndGet == j5) {
                                        break;
                                    }
                                    try {
                                        U uPoll2 = oVar.poll();
                                        if (uPoll2 == null) {
                                            obj3 = uPoll2;
                                            j5 = 0;
                                            break;
                                        }
                                        cVar.onNext(uPoll2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        jAddAndGet--;
                                        j9++;
                                        obj3 = uPoll2;
                                        j5 = 0;
                                    } catch (Throwable th) {
                                        h.a.v0.b.b(th);
                                        aVar.dispose();
                                        this.errs.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(aVar);
                                        i8++;
                                        z = true;
                                    }
                                }
                                if (j9 != j5) {
                                    jAddAndGet = !z2 ? this.requested.addAndGet(-j9) : i.q2.t.m0.f12222b;
                                    aVar.requestMore(j9);
                                    j4 = 0;
                                } else {
                                    j4 = j5;
                                }
                                if (jAddAndGet != j4 && obj3 != null) {
                                    aVarArr2 = aVarArr;
                                    length = i2;
                                    obj2 = obj3;
                                    j5 = 0;
                                }
                            }
                            boolean z4 = aVar.done;
                            h.a.y0.c.o<U> oVar2 = aVar.queue;
                            if (z4 && (oVar2 == null || oVar2.isEmpty())) {
                                removeInner(aVar);
                                if (checkTerminate()) {
                                    return;
                                }
                                j6++;
                                z = true;
                            }
                            if (jAddAndGet == 0) {
                                break;
                            }
                            int i9 = i7 + 1;
                            i7 = i9 == i2 ? 0 : i9;
                            i8++;
                            aVarArr2 = aVarArr;
                            length = i2;
                            j5 = 0;
                        }
                        return;
                    }
                    this.lastIndex = i7;
                    this.lastId = aVarArr[i7].id;
                    j3 = j6;
                    j2 = 0;
                } else {
                    j2 = 0;
                    j3 = j6;
                    z = false;
                }
                if (j3 != j2 && !this.cancelled) {
                    this.s.request(j3);
                }
                if (z) {
                    iAddAndGet = i3;
                } else {
                    iAddAndGet = addAndGet(-i3);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        h.a.y0.c.o<U> getInnerQueue(a<T, U> aVar) {
            h.a.y0.c.o<U> oVar = aVar.queue;
            if (oVar != null) {
                return oVar;
            }
            h.a.y0.f.b bVar = new h.a.y0.f.b(this.bufferSize);
            aVar.queue = bVar;
            return bVar;
        }

        h.a.y0.c.o<U> getMainQueue() {
            h.a.y0.c.n<U> cVar = this.queue;
            if (cVar == null) {
                int i2 = this.maxConcurrency;
                cVar = i2 == Integer.MAX_VALUE ? new h.a.y0.f.c<>(this.bufferSize) : new h.a.y0.f.b(i2);
                this.queue = cVar;
            }
            return cVar;
        }

        void innerError(a<T, U> aVar, Throwable th) {
            if (!this.errs.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            aVar.done = true;
            if (!this.delayErrors) {
                this.s.cancel();
                for (a<?, ?> aVar2 : this.subscribers.getAndSet(CANCELLED)) {
                    aVar2.dispose();
                }
            }
            drain();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else if (!this.errs.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (!(bVar instanceof Callable)) {
                    long j2 = this.uniqueId;
                    this.uniqueId = 1 + j2;
                    a aVar = new a(this, j2);
                    if (addInner(aVar)) {
                        bVar.subscribe(aVar);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall != null) {
                        tryEmitScalar(objCall);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i2 = this.scalarEmitted + 1;
                    this.scalarEmitted = i2;
                    int i3 = this.scalarLimit;
                    if (i2 == i3) {
                        this.scalarEmitted = 0;
                        this.s.request(i3);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.s.cancel();
                onError(th2);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(i.q2.t.m0.f12222b);
                } else {
                    dVar.request(i2);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.subscribers.get();
                if (aVarArr == CANCELLED || aVarArr == EMPTY) {
                    return;
                }
                int length = aVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = EMPTY;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.subscribers.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        void tryEmit(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested.get();
                h.a.y0.c.o<U> innerQueue = aVar.queue;
                if (j2 == 0 || !(innerQueue == null || innerQueue.isEmpty())) {
                    if (innerQueue == null) {
                        innerQueue = getInnerQueue(aVar);
                    }
                    if (!innerQueue.offer(u)) {
                        onError(new h.a.v0.c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != i.q2.t.m0.f12222b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.requestMore(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.a.y0.c.o bVar = aVar.queue;
                if (bVar == null) {
                    bVar = new h.a.y0.f.b(this.bufferSize);
                    aVar.queue = bVar;
                }
                if (!bVar.offer(u)) {
                    onError(new h.a.v0.c("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested.get();
                h.a.y0.c.o<U> mainQueue = this.queue;
                if (j2 == 0 || !(mainQueue == null || mainQueue.isEmpty())) {
                    if (mainQueue == null) {
                        mainQueue = getMainQueue();
                    }
                    if (!mainQueue.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != i.q2.t.m0.f12222b) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i2 = this.scalarEmitted + 1;
                        this.scalarEmitted = i2;
                        int i3 = this.scalarLimit;
                        if (i2 == i3) {
                            this.scalarEmitted = 0;
                            this.s.request(i3);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    public w0(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        super(lVar);
        this.f11029c = oVar;
        this.f11030d = z;
        this.f11031e = i2;
        this.f11032f = i3;
    }

    public static <T, U> h.a.q<T> a(j.d.c<? super U> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        return new b(cVar, oVar, z, i2, i3);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        if (d3.a(this.f10561b, cVar, this.f11029c)) {
            return;
        }
        this.f10561b.a((h.a.q) a(cVar, this.f11029c, this.f11030d, this.f11031e, this.f11032f));
    }
}
