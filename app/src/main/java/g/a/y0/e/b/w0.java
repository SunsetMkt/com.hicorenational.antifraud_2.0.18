package g.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMap.java */
/* loaded from: classes2.dex */
public final class w0<T, U> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends U>> f14675c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14676d;

    /* renamed from: e, reason: collision with root package name */
    final int f14677e;

    /* renamed from: f, reason: collision with root package name */
    final int f14678f;

    /* compiled from: FlowableFlatMap.java */
    static final class a<T, U> extends AtomicReference<i.d.d> implements g.a.q<U>, g.a.u0.c {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final b<T, U> parent;
        long produced;
        volatile g.a.y0.c.o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.id = j2;
            this.parent = bVar;
            this.bufferSize = bVar.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            lazySet(g.a.y0.i.j.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // i.d.c
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(7);
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

    /* compiled from: FlowableFlatMap.java */
    static final class b<T, U> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -2117620485640801370L;
        final i.d.c<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        long lastId;
        int lastIndex;
        final g.a.x0.o<? super T, ? extends i.d.b<? extends U>> mapper;
        final int maxConcurrency;
        volatile g.a.y0.c.n<U> queue;
        i.d.d s;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];
        final g.a.y0.j.c errs = new g.a.y0.j.c();
        final AtomicReference<a<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(i.d.c<? super U> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            this.bufferSize = i3;
            this.scalarLimit = Math.max(1, i2 >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        /* JADX WARN: Multi-variable type inference failed */
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
            } while (!this.subscribers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.c.n<U> nVar;
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
            Throwable terminate = this.errs.terminate();
            if (terminate != g.a.y0.j.k.f16046a) {
                this.actual.onError(terminate);
            }
            return true;
        }

        void clearScalarQueue() {
            g.a.y0.c.n<U> nVar = this.queue;
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
            Throwable terminate = this.errs.terminate();
            if (terminate == null || terminate == g.a.y0.j.k.f16046a) {
                return;
            }
            g.a.c1.a.b(terminate);
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
            i.d.c<? super U> cVar = this.actual;
            int i3 = 1;
            while (!checkTerminate()) {
                g.a.y0.c.n<U> nVar = this.queue;
                long j5 = this.requested.get();
                boolean z2 = j5 == h.q2.t.m0.f16408b;
                long j6 = 0;
                long j7 = 0;
                if (nVar != null) {
                    do {
                        long j8 = 0;
                        obj = null;
                        while (true) {
                            if (j5 == 0) {
                                break;
                            }
                            U poll = nVar.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (poll == null) {
                                obj = poll;
                                break;
                            }
                            cVar.onNext(poll);
                            j7++;
                            j8++;
                            j5--;
                            obj = poll;
                        }
                        if (j8 != 0) {
                            j5 = z2 ? h.q2.t.m0.f16408b : this.requested.addAndGet(-j8);
                        }
                        if (j5 == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z3 = this.done;
                g.a.y0.c.n<U> nVar2 = this.queue;
                a<?, ?>[] aVarArr2 = this.subscribers.get();
                int length = aVarArr2.length;
                if (z3 && ((nVar2 == null || nVar2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errs.terminate();
                    if (terminate != g.a.y0.j.k.f16046a) {
                        if (terminate == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                int i4 = i3;
                if (length != 0) {
                    long j9 = this.lastId;
                    int i5 = this.lastIndex;
                    if (length <= i5 || aVarArr2[i5].id != j9) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        int i6 = i5;
                        for (int i7 = 0; i7 < length && aVarArr2[i6].id != j9; i7++) {
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                        }
                        this.lastIndex = i6;
                        this.lastId = aVarArr2[i6].id;
                        i5 = i6;
                    }
                    int i8 = i5;
                    z = false;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length) {
                            aVarArr = aVarArr2;
                            break;
                        }
                        if (checkTerminate()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr2[i8];
                        Object obj2 = null;
                        while (!checkTerminate()) {
                            g.a.y0.c.o<U> oVar = aVar.queue;
                            if (oVar == null) {
                                aVarArr = aVarArr2;
                                i2 = length;
                            } else {
                                i2 = length;
                                Object obj3 = obj2;
                                aVarArr = aVarArr2;
                                long j10 = j6;
                                while (true) {
                                    if (j5 == j6) {
                                        break;
                                    }
                                    try {
                                        U poll2 = oVar.poll();
                                        if (poll2 == null) {
                                            obj3 = poll2;
                                            j6 = 0;
                                            break;
                                        }
                                        cVar.onNext(poll2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j5--;
                                        j10++;
                                        obj3 = poll2;
                                        j6 = 0;
                                    } catch (Throwable th) {
                                        g.a.v0.b.b(th);
                                        aVar.dispose();
                                        this.errs.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(aVar);
                                        i9++;
                                        z = true;
                                    }
                                }
                                if (j10 != j6) {
                                    j5 = !z2 ? this.requested.addAndGet(-j10) : h.q2.t.m0.f16408b;
                                    aVar.requestMore(j10);
                                    j4 = 0;
                                } else {
                                    j4 = j6;
                                }
                                if (j5 != j4 && obj3 != null) {
                                    aVarArr2 = aVarArr;
                                    length = i2;
                                    obj2 = obj3;
                                    j6 = 0;
                                }
                            }
                            boolean z4 = aVar.done;
                            g.a.y0.c.o<U> oVar2 = aVar.queue;
                            if (z4 && (oVar2 == null || oVar2.isEmpty())) {
                                removeInner(aVar);
                                if (checkTerminate()) {
                                    return;
                                }
                                j7++;
                                z = true;
                            }
                            if (j5 == 0) {
                                break;
                            }
                            int i10 = i8 + 1;
                            i8 = i10 == i2 ? 0 : i10;
                            i9++;
                            aVarArr2 = aVarArr;
                            length = i2;
                            j6 = 0;
                        }
                        return;
                    }
                    this.lastIndex = i8;
                    this.lastId = aVarArr[i8].id;
                    j3 = j7;
                    j2 = 0;
                } else {
                    j2 = 0;
                    j3 = j7;
                    z = false;
                }
                if (j3 != j2 && !this.cancelled) {
                    this.s.request(j3);
                }
                if (z) {
                    i3 = i4;
                } else {
                    i3 = addAndGet(-i4);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        g.a.y0.c.o<U> getInnerQueue(a<T, U> aVar) {
            g.a.y0.c.o<U> oVar = aVar.queue;
            if (oVar != null) {
                return oVar;
            }
            g.a.y0.f.b bVar = new g.a.y0.f.b(this.bufferSize);
            aVar.queue = bVar;
            return bVar;
        }

        g.a.y0.c.o<U> getMainQueue() {
            g.a.y0.c.n<U> nVar = this.queue;
            if (nVar == null) {
                int i2 = this.maxConcurrency;
                nVar = i2 == Integer.MAX_VALUE ? new g.a.y0.f.c<>(this.bufferSize) : new g.a.y0.f.b(i2);
                this.queue = nVar;
            }
            return nVar;
        }

        void innerError(a<T, U> aVar, Throwable th) {
            if (!this.errs.addThrowable(th)) {
                g.a.c1.a.b(th);
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
            if (this.done) {
                g.a.c1.a.b(th);
            } else if (!this.errs.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null Publisher");
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
                    Object call = ((Callable) bVar).call();
                    if (call != null) {
                        tryEmitScalar(call);
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
                    g.a.v0.b.b(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.s.cancel();
                onError(th2);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(h.q2.t.m0.f16408b);
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

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }

        void tryEmit(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested.get();
                g.a.y0.c.o<U> oVar = aVar.queue;
                if (j2 == 0 || !(oVar == null || oVar.isEmpty())) {
                    if (oVar == null) {
                        oVar = getInnerQueue(aVar);
                    }
                    if (!oVar.offer(u)) {
                        onError(new g.a.v0.c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != h.q2.t.m0.f16408b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.requestMore(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                g.a.y0.c.o oVar2 = aVar.queue;
                if (oVar2 == null) {
                    oVar2 = new g.a.y0.f.b(this.bufferSize);
                    aVar.queue = oVar2;
                }
                if (!oVar2.offer(u)) {
                    onError(new g.a.v0.c("Inner queue full?!"));
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
                g.a.y0.c.o<U> oVar = this.queue;
                if (j2 == 0 || !(oVar == null || oVar.isEmpty())) {
                    if (oVar == null) {
                        oVar = getMainQueue();
                    }
                    if (!oVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != h.q2.t.m0.f16408b) {
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

    public w0(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        super(lVar);
        this.f14675c = oVar;
        this.f14676d = z;
        this.f14677e = i2;
        this.f14678f = i3;
    }

    public static <T, U> g.a.q<T> a(i.d.c<? super U> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        return new b(cVar, oVar, z, i2, i3);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        if (d3.a(this.f14110b, cVar, this.f14675c)) {
            return;
        }
        this.f14110b.a((g.a.q) a(cVar, this.f14675c, this.f14676d, this.f14677e, this.f14678f));
    }
}
