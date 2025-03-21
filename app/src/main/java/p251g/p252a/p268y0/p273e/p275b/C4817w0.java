package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFlatMap.java */
/* renamed from: g.a.y0.e.b.w0 */
/* loaded from: classes2.dex */
public final class C4817w0<T, U> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> f18471c;

    /* renamed from: d */
    final boolean f18472d;

    /* renamed from: e */
    final int f18473e;

    /* renamed from: f */
    final int f18474f;

    /* compiled from: FlowableFlatMap.java */
    /* renamed from: g.a.y0.e.b.w0$a */
    static final class a<T, U> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<U>, InterfaceC4552c {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id */
        final long f18475id;
        final int limit;
        final b<T, U> parent;
        long produced;
        volatile InterfaceC4616o<U> queue;

        a(b<T, U> bVar, long j2) {
            this.f18475id = j2;
            this.parent = bVar;
            this.bufferSize = bVar.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            lazySet(EnumC5160j.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                    }
                }
                interfaceC5823d.request(this.bufferSize);
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
    /* renamed from: g.a.y0.e.b.w0$b */
    static final class b<T, U> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -2117620485640801370L;
        final InterfaceC5822c<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        long lastId;
        int lastIndex;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> mapper;
        final int maxConcurrency;
        volatile InterfaceC4615n<U> queue;

        /* renamed from: s */
        InterfaceC5823d f18476s;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];
        final C5163c errs = new C5163c();
        final AtomicReference<a<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(InterfaceC5822c<? super U> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
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

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            InterfaceC4615n<U> interfaceC4615n;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f18476s.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (interfaceC4615n = this.queue) == null) {
                return;
            }
            interfaceC4615n.clear();
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
            if (terminate != C5171k.f20031a) {
                this.actual.onError(terminate);
            }
            return true;
        }

        void clearScalarQueue() {
            InterfaceC4615n<U> interfaceC4615n = this.queue;
            if (interfaceC4615n != null) {
                interfaceC4615n.clear();
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
            if (terminate == null || terminate == C5171k.f20031a) {
                return;
            }
            C4476a.m17152b(terminate);
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
            InterfaceC5822c<? super U> interfaceC5822c = this.actual;
            int i3 = 1;
            while (!checkTerminate()) {
                InterfaceC4615n<U> interfaceC4615n = this.queue;
                long j5 = this.requested.get();
                boolean z2 = j5 == C5556m0.f20396b;
                long j6 = 0;
                long j7 = 0;
                if (interfaceC4615n != null) {
                    do {
                        long j8 = 0;
                        obj = null;
                        while (true) {
                            if (j5 == 0) {
                                break;
                            }
                            U poll = interfaceC4615n.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (poll == null) {
                                obj = poll;
                                break;
                            }
                            interfaceC5822c.onNext(poll);
                            j7++;
                            j8++;
                            j5--;
                            obj = poll;
                        }
                        if (j8 != 0) {
                            j5 = z2 ? C5556m0.f20396b : this.requested.addAndGet(-j8);
                        }
                        if (j5 == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z3 = this.done;
                InterfaceC4615n<U> interfaceC4615n2 = this.queue;
                a<?, ?>[] aVarArr2 = this.subscribers.get();
                int length = aVarArr2.length;
                if (z3 && ((interfaceC4615n2 == null || interfaceC4615n2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errs.terminate();
                    if (terminate != C5171k.f20031a) {
                        if (terminate == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                int i4 = i3;
                if (length != 0) {
                    long j9 = this.lastId;
                    int i5 = this.lastIndex;
                    if (length <= i5 || aVarArr2[i5].f18475id != j9) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        int i6 = i5;
                        for (int i7 = 0; i7 < length && aVarArr2[i6].f18475id != j9; i7++) {
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                        }
                        this.lastIndex = i6;
                        this.lastId = aVarArr2[i6].f18475id;
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
                            InterfaceC4616o<U> interfaceC4616o = aVar.queue;
                            if (interfaceC4616o == null) {
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
                                        U poll2 = interfaceC4616o.poll();
                                        if (poll2 == null) {
                                            obj3 = poll2;
                                            j6 = 0;
                                            break;
                                        }
                                        interfaceC5822c.onNext(poll2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j5--;
                                        j10++;
                                        obj3 = poll2;
                                        j6 = 0;
                                    } catch (Throwable th) {
                                        C4561b.m18199b(th);
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
                                    j5 = !z2 ? this.requested.addAndGet(-j10) : C5556m0.f20396b;
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
                            InterfaceC4616o<U> interfaceC4616o2 = aVar.queue;
                            if (z4 && (interfaceC4616o2 == null || interfaceC4616o2.isEmpty())) {
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
                    this.lastId = aVarArr[i8].f18475id;
                    j3 = j7;
                    j2 = 0;
                } else {
                    j2 = 0;
                    j3 = j7;
                    z = false;
                }
                if (j3 != j2 && !this.cancelled) {
                    this.f18476s.request(j3);
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

        InterfaceC4616o<U> getInnerQueue(a<T, U> aVar) {
            InterfaceC4616o<U> interfaceC4616o = aVar.queue;
            if (interfaceC4616o != null) {
                return interfaceC4616o;
            }
            C5110b c5110b = new C5110b(this.bufferSize);
            aVar.queue = c5110b;
            return c5110b;
        }

        InterfaceC4616o<U> getMainQueue() {
            InterfaceC4615n<U> interfaceC4615n = this.queue;
            if (interfaceC4615n == null) {
                int i2 = this.maxConcurrency;
                interfaceC4615n = i2 == Integer.MAX_VALUE ? new C5111c<>(this.bufferSize) : new C5110b(i2);
                this.queue = interfaceC4615n;
            }
            return interfaceC4615n;
        }

        void innerError(a<T, U> aVar, Throwable th) {
            if (!this.errs.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            aVar.done = true;
            if (!this.delayErrors) {
                this.f18476s.cancel();
                for (a<?, ?> aVar2 : this.subscribers.getAndSet(CANCELLED)) {
                    aVar2.dispose();
                }
            }
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else if (!this.errs.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (!(interfaceC5821b instanceof Callable)) {
                    long j2 = this.uniqueId;
                    this.uniqueId = 1 + j2;
                    a aVar = new a(this, j2);
                    if (addInner(aVar)) {
                        interfaceC5821b.subscribe(aVar);
                        return;
                    }
                    return;
                }
                try {
                    Object call = ((Callable) interfaceC5821b).call();
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
                        this.f18476s.request(i3);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f18476s.cancel();
                onError(th2);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18476s, interfaceC5823d)) {
                this.f18476s = interfaceC5823d;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    interfaceC5823d.request(C5556m0.f20396b);
                } else {
                    interfaceC5823d.request(i2);
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

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        void tryEmit(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested.get();
                InterfaceC4616o<U> interfaceC4616o = aVar.queue;
                if (j2 == 0 || !(interfaceC4616o == null || interfaceC4616o.isEmpty())) {
                    if (interfaceC4616o == null) {
                        interfaceC4616o = getInnerQueue(aVar);
                    }
                    if (!interfaceC4616o.offer(u)) {
                        onError(new C4562c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != C5556m0.f20396b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.requestMore(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                InterfaceC4616o interfaceC4616o2 = aVar.queue;
                if (interfaceC4616o2 == null) {
                    interfaceC4616o2 = new C5110b(this.bufferSize);
                    aVar.queue = interfaceC4616o2;
                }
                if (!interfaceC4616o2.offer(u)) {
                    onError(new C4562c("Inner queue full?!"));
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
                InterfaceC4616o<U> interfaceC4616o = this.queue;
                if (j2 == 0 || !(interfaceC4616o == null || interfaceC4616o.isEmpty())) {
                    if (interfaceC4616o == null) {
                        interfaceC4616o = getMainQueue();
                    }
                    if (!interfaceC4616o.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.actual.onNext(u);
                    if (j2 != C5556m0.f20396b) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i2 = this.scalarEmitted + 1;
                        this.scalarEmitted = i2;
                        int i3 = this.scalarLimit;
                        if (i2 == i3) {
                            this.scalarEmitted = 0;
                            this.f18476s.request(i3);
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

    public C4817w0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
        super(abstractC4519l);
        this.f18471c = interfaceC4584o;
        this.f18472d = z;
        this.f18473e = i2;
        this.f18474f = i3;
    }

    /* renamed from: a */
    public static <T, U> InterfaceC4529q<T> m18398a(InterfaceC5822c<? super U> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o, boolean z, int i2, int i3) {
        return new b(interfaceC5822c, interfaceC4584o, z, i2, i3);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        if (C4708d3.m18317a(this.f17759b, interfaceC5822c, this.f18471c)) {
            return;
        }
        this.f17759b.m17799a((InterfaceC4529q) m18398a(interfaceC5822c, this.f18471c, this.f18472d, this.f18473e, this.f18474f));
    }
}
