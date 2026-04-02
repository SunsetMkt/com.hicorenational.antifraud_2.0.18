package h.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0<T, U> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> f11645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11648e;

    /* JADX INFO: compiled from: ObservableFlatMap.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.i0<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final b<T, U> parent;
        volatile h.a.y0.c.o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.id = j2;
            this.parent = bVar;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.i0
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            b<T, U> bVar = this.parent;
            if (!bVar.delayErrors) {
                bVar.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // h.a.i0
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar) && (cVar instanceof h.a.y0.c.j)) {
                h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                int iRequestFusion = jVar.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                }
            }
        }
    }

    /* JADX INFO: compiled from: ObservableFlatMap.java */
    static final class b<T, U> extends AtomicInteger implements h.a.u0.c, h.a.i0<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final h.a.i0<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        long lastId;
        int lastIndex;
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile h.a.y0.c.n<U> queue;
        h.a.u0.c s;
        Queue<h.a.g0<? extends U>> sources;
        long uniqueId;
        int wip;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];

        b(h.a.i0<? super U> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar, boolean z, int i2, int i3) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            this.bufferSize = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i2);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        boolean addInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.observers.get();
                if (aVarArr == CANCELLED) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.observers.compareAndSet(aVarArr, (a<?, ?>[]) aVarArr2));
            return true;
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            Throwable thTerminate = this.errors.terminate();
            if (thTerminate != h.a.y0.j.k.a) {
                this.actual.onError(thTerminate);
            }
            return true;
        }

        @Override // h.a.u0.c
        public void dispose() {
            Throwable thTerminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (thTerminate = this.errors.terminate()) == null || thTerminate == h.a.y0.j.k.a) {
                return;
            }
            h.a.c1.a.b(thTerminate);
        }

        boolean disposeAll() {
            a<?, ?>[] andSet;
            this.s.dispose();
            a<?, ?>[] aVarArr = this.observers.get();
            a<?, ?>[] aVarArr2 = CANCELLED;
            if (aVarArr == aVarArr2 || (andSet = this.observers.getAndSet(aVarArr2)) == CANCELLED) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.dispose();
            }
            return true;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            h.a.i0<? super U> i0Var = this.actual;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                h.a.y0.c.n<U> nVar = this.queue;
                if (nVar != null) {
                    while (!checkTerminate()) {
                        U uPoll = nVar.poll();
                        if (uPoll != null) {
                            i0Var.onNext(uPoll);
                        } else if (uPoll == null) {
                        }
                    }
                    return;
                }
                boolean z = this.done;
                h.a.y0.c.n<U> nVar2 = this.queue;
                a<?, ?>[] aVarArr = this.observers.get();
                int length = aVarArr.length;
                if (z && ((nVar2 == null || nVar2.isEmpty()) && length == 0)) {
                    Throwable thTerminate = this.errors.terminate();
                    if (thTerminate != h.a.y0.j.k.a) {
                        if (thTerminate == null) {
                            i0Var.onComplete();
                            return;
                        } else {
                            i0Var.onError(thTerminate);
                            return;
                        }
                    }
                    return;
                }
                boolean z2 = false;
                if (length != 0) {
                    long j2 = this.lastId;
                    int i2 = this.lastIndex;
                    if (length <= i2 || aVarArr[i2].id != j2) {
                        if (length <= i2) {
                            i2 = 0;
                        }
                        int i3 = i2;
                        for (int i4 = 0; i4 < length && aVarArr[i3].id != j2; i4++) {
                            i3++;
                            if (i3 == length) {
                                i3 = 0;
                            }
                        }
                        this.lastIndex = i3;
                        this.lastId = aVarArr[i3].id;
                        i2 = i3;
                    }
                    int i5 = i2;
                    int i6 = 0;
                    boolean z3 = false;
                    while (i6 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr[i5];
                        while (!checkTerminate()) {
                            h.a.y0.c.o<U> oVar = aVar.queue;
                            if (oVar != null) {
                                do {
                                    try {
                                        U uPoll2 = oVar.poll();
                                        if (uPoll2 != null) {
                                            i0Var.onNext(uPoll2);
                                        } else if (uPoll2 == null) {
                                        }
                                    } catch (Throwable th) {
                                        h.a.v0.b.b(th);
                                        aVar.dispose();
                                        this.errors.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(aVar);
                                        i6++;
                                        z3 = true;
                                    }
                                } while (!checkTerminate());
                                return;
                            }
                            boolean z4 = aVar.done;
                            h.a.y0.c.o<U> oVar2 = aVar.queue;
                            if (z4 && (oVar2 == null || oVar2.isEmpty())) {
                                removeInner(aVar);
                                if (checkTerminate()) {
                                    return;
                                } else {
                                    z3 = true;
                                }
                            }
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                            i6++;
                        }
                        return;
                    }
                    this.lastIndex = i5;
                    this.lastId = aVarArr[i5].id;
                    z2 = z3;
                }
                if (!z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        h.a.g0<? extends U> g0VarPoll = this.sources.poll();
                        if (g0VarPoll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(g0VarPoll);
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                h.a.g0<? extends U> g0Var = (h.a.g0) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(g0Var);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(g0Var);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.observers.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
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
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
        }

        void subscribeInner(h.a.g0<? extends U> g0Var) {
            while (g0Var instanceof Callable) {
                tryEmitScalar((Callable) g0Var);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    g0Var = this.sources.poll();
                    if (g0Var == null) {
                        this.wip--;
                        return;
                    }
                }
            }
            long j2 = this.uniqueId;
            this.uniqueId = 1 + j2;
            a<T, U> aVar = new a<>(this, j2);
            if (addInner(aVar)) {
                g0Var.subscribe(aVar);
            }
        }

        void tryEmit(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.a.y0.c.o cVar = aVar.queue;
                if (cVar == null) {
                    cVar = new h.a.y0.f.c(this.bufferSize);
                    aVar.queue = cVar;
                }
                cVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.actual.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    h.a.y0.c.n<U> cVar = this.queue;
                    if (cVar == null) {
                        int i2 = this.maxConcurrency;
                        cVar = i2 == Integer.MAX_VALUE ? new h.a.y0.f.c<>(this.bufferSize) : new h.a.y0.f.b(i2);
                        this.queue = cVar;
                    }
                    if (!cVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.errors.addThrowable(th);
                drain();
            }
        }
    }

    public u0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar, boolean z, int i2, int i3) {
        super(g0Var);
        this.f11645b = oVar;
        this.f11646c = z;
        this.f11647d = i2;
        this.f11648e = i3;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super U> i0Var) {
        if (s2.a(this.a, i0Var, this.f11645b)) {
            return;
        }
        this.a.subscribe(new b(i0Var, this.f11645b, this.f11646c, this.f11647d, this.f11648e));
    }
}
