package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p266w0.AbstractC4568b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableGroupBy.java */
/* renamed from: g.a.y0.e.b.k1 */
/* loaded from: classes2.dex */
public final class C4748k1<T, K, V> extends AbstractC4686a<T, AbstractC4568b<K, V>> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends K> f17995c;

    /* renamed from: d */
    final InterfaceC4584o<? super T, ? extends V> f17996d;

    /* renamed from: e */
    final int f17997e;

    /* renamed from: f */
    final boolean f17998f;

    /* compiled from: FlowableGroupBy.java */
    /* renamed from: g.a.y0.e.b.k1$a */
    public static final class a<T, K, V> extends AbstractC5153c<AbstractC4568b<K, V>> implements InterfaceC4529q<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final InterfaceC5822c<? super AbstractC4568b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final InterfaceC4584o<? super T, ? extends K> keySelector;
        boolean outputFused;
        final C5111c<AbstractC4568b<K, V>> queue;

        /* renamed from: s */
        InterfaceC5823d f17999s;
        final InterfaceC4584o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, b<K, V>> groups = new ConcurrentHashMap();

        public a(InterfaceC5822c<? super AbstractC4568b<K, V>> interfaceC5822c, InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, int i2, boolean z) {
            this.actual = interfaceC5822c;
            this.keySelector = interfaceC4584o;
            this.valueSelector = interfaceC4584o2;
            this.bufferSize = i2;
            this.delayError = z;
            this.queue = new C5111c<>(i2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                this.f17999s.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, C5111c<?> c5111c) {
            if (this.cancelled.get()) {
                c5111c.clear();
                return true;
            }
            if (this.delayError) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    interfaceC5822c.onError(th);
                } else {
                    interfaceC5822c.onComplete();
                }
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                c5111c.clear();
                interfaceC5822c.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            interfaceC5822c.onComplete();
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            C5111c<AbstractC4568b<K, V>> c5111c = this.queue;
            InterfaceC5822c<? super AbstractC4568b<K, V>> interfaceC5822c = this.actual;
            int i2 = 1;
            while (!this.cancelled.get()) {
                boolean z = this.done;
                if (z && !this.delayError && (th = this.error) != null) {
                    c5111c.clear();
                    interfaceC5822c.onError(th);
                    return;
                }
                interfaceC5822c.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        interfaceC5822c.onError(th2);
                        return;
                    } else {
                        interfaceC5822c.onComplete();
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            c5111c.clear();
        }

        void drainNormal() {
            C5111c<AbstractC4568b<K, V>> c5111c = this.queue;
            InterfaceC5822c<? super AbstractC4568b<K, V>> interfaceC5822c = this.actual;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    AbstractC4568b<K, V> poll = c5111c.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, interfaceC5822c, c5111c)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(poll);
                    j3++;
                }
                if (j3 == j2 && checkTerminated(this.done, c5111c.isEmpty(), interfaceC5822c, c5111c)) {
                    return;
                }
                if (j3 != 0) {
                    if (j2 != C5556m0.f20396b) {
                        this.requested.addAndGet(-j3);
                    }
                    this.f17999s.request(j3);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<b<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            Iterator<b<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.groups.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C5111c<AbstractC4568b<K, V>> c5111c = this.queue;
            try {
                K apply = this.keySelector.apply(t);
                boolean z = false;
                Object obj = apply != null ? apply : NULL_KEY;
                b<K, V> bVar = this.groups.get(obj);
                b bVar2 = bVar;
                if (bVar == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    b m18327a = b.m18327a(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, m18327a);
                    this.groupCount.getAndIncrement();
                    z = true;
                    bVar2 = m18327a;
                }
                try {
                    bVar2.onNext(C4601b.m18284a(this.valueSelector.apply(t), "The valueSelector returned null"));
                    if (z) {
                        c5111c.offer(bVar2);
                        drain();
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17999s.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f17999s.cancel();
                onError(th2);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17999s, interfaceC5823d)) {
                this.f17999s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.bufferSize);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public AbstractC4568b<K, V> poll() {
            return this.queue.poll();
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) NULL_KEY;
            }
            this.groups.remove(k2);
            if (this.groupCount.decrementAndGet() == 0) {
                this.f17999s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }
    }

    /* compiled from: FlowableGroupBy.java */
    /* renamed from: g.a.y0.e.b.k1$b */
    static final class b<K, T> extends AbstractC4568b<K, T> {

        /* renamed from: c */
        final c<T, K> f18000c;

        protected b(K k2, c<T, K> cVar) {
            super(k2);
            this.f18000c = cVar;
        }

        /* renamed from: a */
        public static <T, K> b<K, T> m18327a(K k2, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k2, new c(i2, aVar, k2, z));
        }

        @Override // p251g.p252a.AbstractC4519l
        /* renamed from: d */
        protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f18000c.subscribe(interfaceC5822c);
        }

        public void onComplete() {
            this.f18000c.onComplete();
        }

        public void onError(Throwable th) {
            this.f18000c.onError(th);
        }

        public void onNext(T t) {
            this.f18000c.onNext(t);
        }
    }

    /* compiled from: FlowableGroupBy.java */
    /* renamed from: g.a.y0.e.b.k1$c */
    static final class c<T, K> extends AbstractC5153c<T> implements InterfaceC5821b<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final a<?, K, T> parent;
        int produced;
        final C5111c<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<InterfaceC5822c<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();

        c(int i2, a<?, K, T> aVar, K k2, boolean z) {
            this.queue = new C5111c<>(i2);
            this.parent = aVar;
            this.key = k2;
            this.delayError = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<? super T> interfaceC5822c, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    interfaceC5822c.onError(th);
                } else {
                    interfaceC5822c.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                interfaceC5822c.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            interfaceC5822c.onComplete();
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            C5111c<T> c5111c = this.queue;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual.get();
            int i2 = 1;
            while (true) {
                if (interfaceC5822c != null) {
                    if (this.cancelled.get()) {
                        c5111c.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        c5111c.clear();
                        interfaceC5822c.onError(th);
                        return;
                    }
                    interfaceC5822c.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            interfaceC5822c.onError(th2);
                            return;
                        } else {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (interfaceC5822c == null) {
                    interfaceC5822c = this.actual.get();
                }
            }
        }

        void drainNormal() {
            C5111c<T> c5111c = this.queue;
            boolean z = this.delayError;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual.get();
            int i2 = 1;
            while (true) {
                if (interfaceC5822c != null) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z2 = this.done;
                        T poll = c5111c.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, interfaceC5822c, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        interfaceC5822c.onNext(poll);
                        j3++;
                    }
                    if (j3 == j2 && checkTerminated(this.done, c5111c.isEmpty(), interfaceC5822c, z)) {
                        return;
                    }
                    if (j3 != 0) {
                        if (j2 != C5556m0.f20396b) {
                            this.requested.addAndGet(-j3);
                        }
                        this.parent.f17999s.request(j3);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (interfaceC5822c == null) {
                    interfaceC5822c = this.actual.get();
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i2 = this.produced;
            if (i2 == 0) {
                return null;
            }
            this.produced = 0;
            this.parent.f17999s.request(i2);
            return null;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // p324i.p338d.InterfaceC5821b
        public void subscribe(InterfaceC5822c<? super T> interfaceC5822c) {
            if (!this.once.compareAndSet(false, true)) {
                EnumC5157g.error(new IllegalStateException("Only one Subscriber allowed!"), interfaceC5822c);
                return;
            }
            interfaceC5822c.onSubscribe(this);
            this.actual.lazySet(interfaceC5822c);
            drain();
        }
    }

    public C4748k1(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, int i2, boolean z) {
        super(abstractC4519l);
        this.f17995c = interfaceC4584o;
        this.f17996d = interfaceC4584o2;
        this.f17997e = i2;
        this.f17998f = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super AbstractC4568b<K, V>> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17995c, this.f17996d, this.f17997e, this.f17998f));
    }
}
