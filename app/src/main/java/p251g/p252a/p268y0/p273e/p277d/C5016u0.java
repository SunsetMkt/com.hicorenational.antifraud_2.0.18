package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: ObservableFlatMap.java */
/* renamed from: g.a.y0.e.d.u0 */
/* loaded from: classes2.dex */
public final class C5016u0<T, U> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> f19417b;

    /* renamed from: c */
    final boolean f19418c;

    /* renamed from: d */
    final int f19419d;

    /* renamed from: e */
    final int f19420e;

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: g.a.y0.e.d.u0$a */
    static final class a<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id */
        final long f19421id;
        final b<T, U> parent;
        volatile InterfaceC4616o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.f19421id = j2;
            this.parent = bVar;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            b<T, U> bVar = this.parent;
            if (!bVar.delayErrors) {
                bVar.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c) && (interfaceC4552c instanceof InterfaceC4611j)) {
                InterfaceC4611j interfaceC4611j = (InterfaceC4611j) interfaceC4552c;
                int requestFusion = interfaceC4611j.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4611j;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = interfaceC4611j;
                }
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: g.a.y0.e.d.u0$b */
    static final class b<T, U> extends AtomicInteger implements InterfaceC4552c, InterfaceC4514i0<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final InterfaceC4514i0<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final C5163c errors = new C5163c();
        long lastId;
        int lastIndex;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile InterfaceC4615n<U> queue;

        /* renamed from: s */
        InterfaceC4552c f19422s;
        Queue<InterfaceC4504g0<? extends U>> sources;
        long uniqueId;
        int wip;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];

        b(InterfaceC4514i0<? super U> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
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
            if (terminate != C5171k.f20031a) {
                this.actual.onError(terminate);
            }
            return true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            Throwable terminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == C5171k.f20031a) {
                return;
            }
            C4476a.m17152b(terminate);
        }

        boolean disposeAll() {
            a<?, ?>[] andSet;
            this.f19422s.dispose();
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
            InterfaceC4514i0<? super U> interfaceC4514i0 = this.actual;
            int i2 = 1;
            while (!checkTerminate()) {
                InterfaceC4615n<U> interfaceC4615n = this.queue;
                if (interfaceC4615n != null) {
                    while (!checkTerminate()) {
                        U poll = interfaceC4615n.poll();
                        if (poll != null) {
                            interfaceC4514i0.onNext(poll);
                        } else if (poll == null) {
                        }
                    }
                    return;
                }
                boolean z = this.done;
                InterfaceC4615n<U> interfaceC4615n2 = this.queue;
                a<?, ?>[] aVarArr = this.observers.get();
                int length = aVarArr.length;
                if (z && ((interfaceC4615n2 == null || interfaceC4615n2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != C5171k.f20031a) {
                        if (terminate == null) {
                            interfaceC4514i0.onComplete();
                            return;
                        } else {
                            interfaceC4514i0.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                boolean z2 = false;
                if (length != 0) {
                    long j2 = this.lastId;
                    int i3 = this.lastIndex;
                    if (length <= i3 || aVarArr[i3].f19421id != j2) {
                        if (length <= i3) {
                            i3 = 0;
                        }
                        int i4 = i3;
                        for (int i5 = 0; i5 < length && aVarArr[i4].f19421id != j2; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = aVarArr[i4].f19421id;
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
                            InterfaceC4616o<U> interfaceC4616o = aVar.queue;
                            if (interfaceC4616o != null) {
                                do {
                                    try {
                                        U poll2 = interfaceC4616o.poll();
                                        if (poll2 != null) {
                                            interfaceC4514i0.onNext(poll2);
                                        } else if (poll2 == null) {
                                        }
                                    } catch (Throwable th) {
                                        C4561b.m18199b(th);
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
                            InterfaceC4616o<U> interfaceC4616o2 = aVar.queue;
                            if (z4 && (interfaceC4616o2 == null || interfaceC4616o2.isEmpty())) {
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
                    this.lastId = aVarArr[i6].f19421id;
                    z2 = z3;
                }
                if (!z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        InterfaceC4504g0<? extends U> poll3 = this.sources.poll();
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

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                InterfaceC4504g0<? extends U> interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(interfaceC4504g0);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(interfaceC4504g0);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19422s.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19422s, interfaceC4552c)) {
                this.f19422s = interfaceC4552c;
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

        void subscribeInner(InterfaceC4504g0<? extends U> interfaceC4504g0) {
            while (interfaceC4504g0 instanceof Callable) {
                tryEmitScalar((Callable) interfaceC4504g0);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    interfaceC4504g0 = this.sources.poll();
                    if (interfaceC4504g0 == null) {
                        this.wip--;
                        return;
                    }
                }
            }
            long j2 = this.uniqueId;
            this.uniqueId = 1 + j2;
            a<T, U> aVar = new a<>(this, j2);
            if (addInner(aVar)) {
                interfaceC4504g0.subscribe(aVar);
            }
        }

        void tryEmit(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                InterfaceC4616o interfaceC4616o = aVar.queue;
                if (interfaceC4616o == null) {
                    interfaceC4616o = new C5111c(this.bufferSize);
                    aVar.queue = interfaceC4616o;
                }
                interfaceC4616o.offer(u);
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
                    InterfaceC4615n<U> interfaceC4615n = this.queue;
                    if (interfaceC4615n == null) {
                        int i2 = this.maxConcurrency;
                        interfaceC4615n = i2 == Integer.MAX_VALUE ? new C5111c<>(this.bufferSize) : new C5110b(i2);
                        this.queue = interfaceC4615n;
                    }
                    if (!interfaceC4615n.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.errors.addThrowable(th);
                drain();
            }
        }
    }

    public C5016u0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
        super(interfaceC4504g0);
        this.f19417b = interfaceC4584o;
        this.f19418c = z;
        this.f19419d = i2;
        this.f19420e = i3;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        if (C5008s2.m18520a(this.f18742a, interfaceC4514i0, this.f19417b)) {
            return;
        }
        this.f18742a.subscribe(new b(interfaceC4514i0, this.f19417b, this.f19418c, this.f19419d, this.f19420e));
    }
}
