package g.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMap.java */
/* loaded from: classes2.dex */
public final class u0<T, U> extends g.a.y0.e.d.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> f15501b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15502c;

    /* renamed from: d, reason: collision with root package name */
    final int f15503d;

    /* renamed from: e, reason: collision with root package name */
    final int f15504e;

    /* compiled from: ObservableFlatMap.java */
    static final class a<T, U> extends AtomicReference<g.a.u0.c> implements g.a.i0<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final b<T, U> parent;
        volatile g.a.y0.c.o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.id = j2;
            this.parent = bVar;
        }

        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.i0
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            b<T, U> bVar = this.parent;
            if (!bVar.delayErrors) {
                bVar.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // g.a.i0
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar) && (cVar instanceof g.a.y0.c.j)) {
                g.a.y0.c.j jVar = (g.a.y0.c.j) cVar;
                int requestFusion = jVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = jVar;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = jVar;
                }
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    static final class b<T, U> extends AtomicInteger implements g.a.u0.c, g.a.i0<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final g.a.i0<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        long lastId;
        int lastIndex;
        final g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile g.a.y0.c.n<U> queue;
        g.a.u0.c s;
        Queue<g.a.g0<? extends U>> sources;
        long uniqueId;
        int wip;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];

        b(g.a.i0<? super U> i0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar, boolean z, int i2, int i3) {
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

        /* JADX WARN: Multi-variable type inference failed */
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
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
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
            Throwable terminate = this.errors.terminate();
            if (terminate != g.a.y0.j.k.f16046a) {
                this.actual.onError(terminate);
            }
            return true;
        }

        @Override // g.a.u0.c
        public void dispose() {
            Throwable terminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == g.a.y0.j.k.f16046a) {
                return;
            }
            g.a.c1.a.b(terminate);
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
            g.a.i0<? super U> i0Var = this.actual;
            int i2 = 1;
            while (!checkTerminate()) {
                g.a.y0.c.n<U> nVar = this.queue;
                if (nVar != null) {
                    while (!checkTerminate()) {
                        U poll = nVar.poll();
                        if (poll != null) {
                            i0Var.onNext(poll);
                        } else if (poll == null) {
                        }
                    }
                    return;
                }
                boolean z = this.done;
                g.a.y0.c.n<U> nVar2 = this.queue;
                a<?, ?>[] aVarArr = this.observers.get();
                int length = aVarArr.length;
                if (z && ((nVar2 == null || nVar2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != g.a.y0.j.k.f16046a) {
                        if (terminate == null) {
                            i0Var.onComplete();
                            return;
                        } else {
                            i0Var.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                boolean z2 = false;
                if (length != 0) {
                    long j2 = this.lastId;
                    int i3 = this.lastIndex;
                    if (length <= i3 || aVarArr[i3].id != j2) {
                        if (length <= i3) {
                            i3 = 0;
                        }
                        int i4 = i3;
                        for (int i5 = 0; i5 < length && aVarArr[i4].id != j2; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = aVarArr[i4].id;
                        i3 = i4;
                    }
                    int i6 = i3;
                    int i7 = 0;
                    boolean z3 = false;
                    while (i7 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr[i6];
                        while (!checkTerminate()) {
                            g.a.y0.c.o<U> oVar = aVar.queue;
                            if (oVar != null) {
                                do {
                                    try {
                                        U poll2 = oVar.poll();
                                        if (poll2 != null) {
                                            i0Var.onNext(poll2);
                                        } else if (poll2 == null) {
                                        }
                                    } catch (Throwable th) {
                                        g.a.v0.b.b(th);
                                        aVar.dispose();
                                        this.errors.addThrowable(th);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(aVar);
                                        i7++;
                                        z3 = true;
                                    }
                                } while (!checkTerminate());
                                return;
                            }
                            boolean z4 = aVar.done;
                            g.a.y0.c.o<U> oVar2 = aVar.queue;
                            if (z4 && (oVar2 == null || oVar2.isEmpty())) {
                                removeInner(aVar);
                                if (checkTerminate()) {
                                    return;
                                } else {
                                    z3 = true;
                                }
                            }
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                            i7++;
                        }
                        return;
                    }
                    this.lastIndex = i6;
                    this.lastId = aVarArr[i6].id;
                    z2 = z3;
                }
                if (!z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        g.a.g0<? extends U> poll3 = this.sources.poll();
                        if (poll3 == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll3);
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                g.a.g0<? extends U> g0Var = (g.a.g0) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null ObservableSource");
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
                g.a.v0.b.b(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.s, cVar)) {
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

        void subscribeInner(g.a.g0<? extends U> g0Var) {
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
                g.a.y0.c.o oVar = aVar.queue;
                if (oVar == null) {
                    oVar = new g.a.y0.f.c(this.bufferSize);
                    aVar.queue = oVar;
                }
                oVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.actual.onNext(call);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    g.a.y0.c.n<U> nVar = this.queue;
                    if (nVar == null) {
                        int i2 = this.maxConcurrency;
                        nVar = i2 == Integer.MAX_VALUE ? new g.a.y0.f.c<>(this.bufferSize) : new g.a.y0.f.b(i2);
                        this.queue = nVar;
                    }
                    if (!nVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.errors.addThrowable(th);
                drain();
            }
        }
    }

    public u0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.g0<? extends U>> oVar, boolean z, int i2, int i3) {
        super(g0Var);
        this.f15501b = oVar;
        this.f15502c = z;
        this.f15503d = i2;
        this.f15504e = i3;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super U> i0Var) {
        if (s2.a(this.f14934a, i0Var, this.f15501b)) {
            return;
        }
        this.f14934a.subscribe(new b(i0Var, this.f15501b, this.f15502c, this.f15503d, this.f15504e));
    }
}
