package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p285z0.AbstractC5188b;

/* compiled from: ObservableGroupBy.java */
/* renamed from: g.a.y0.e.d.h1 */
/* loaded from: classes2.dex */
public final class C4951h1<T, K, V> extends AbstractC4907a<T, AbstractC5188b<K, V>> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends K> f19035b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends V> f19036c;

    /* renamed from: d */
    final int f19037d;

    /* renamed from: e */
    final boolean f19038e;

    /* compiled from: ObservableGroupBy.java */
    /* renamed from: g.a.y0.e.d.h1$a */
    public static final class a<T, K, V> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final InterfaceC4514i0<? super AbstractC5188b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        final InterfaceC4584o<? super T, ? extends K> keySelector;

        /* renamed from: s */
        InterfaceC4552c f19039s;
        final InterfaceC4584o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, b<K, V>> groups = new ConcurrentHashMap();

        public a(InterfaceC4514i0<? super AbstractC5188b<K, V>> interfaceC4514i0, InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.keySelector = interfaceC4584o;
            this.valueSelector = interfaceC4584o2;
            this.bufferSize = i2;
            this.delayError = z;
            lazySet(1);
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) NULL_KEY;
            }
            this.groups.remove(k2);
            if (decrementAndGet() == 0) {
                this.f19039s.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f19039s.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onComplete();
            }
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onError(th);
            }
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map, java.util.Map<java.lang.Object, g.a.y0.e.d.h1$b<K, V>>] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [g.a.y0.e.d.h1$b] */
        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            try {
                K apply = this.keySelector.apply(t);
                Object obj = apply != null ? apply : NULL_KEY;
                b<K, V> bVar = this.groups.get(obj);
                ?? r2 = bVar;
                if (bVar == false) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    Object m18451a = b.m18451a(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, m18451a);
                    getAndIncrement();
                    this.actual.onNext(m18451a);
                    r2 = m18451a;
                }
                try {
                    r2.onNext(C4601b.m18284a(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f19039s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19039s.dispose();
                onError(th2);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19039s, interfaceC4552c)) {
                this.f19039s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableGroupBy.java */
    /* renamed from: g.a.y0.e.d.h1$b */
    static final class b<K, T> extends AbstractC5188b<K, T> {

        /* renamed from: b */
        final c<T, K> f19040b;

        protected b(K k2, c<T, K> cVar) {
            super(k2);
            this.f19040b = cVar;
        }

        /* renamed from: a */
        public static <T, K> b<K, T> m18451a(K k2, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k2, new c(i2, aVar, k2, z));
        }

        @Override // p251g.p252a.AbstractC4469b0
        /* renamed from: d */
        protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19040b.subscribe(interfaceC4514i0);
        }

        public void onComplete() {
            this.f19040b.onComplete();
        }

        public void onError(Throwable th) {
            this.f19040b.onError(th);
        }

        public void onNext(T t) {
            this.f19040b.onNext(t);
        }
    }

    /* compiled from: ObservableGroupBy.java */
    /* renamed from: g.a.y0.e.d.h1$c */
    static final class c<T, K> extends AtomicInteger implements InterfaceC4552c, InterfaceC4504g0<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final a<?, K, T> parent;
        final C5111c<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<InterfaceC4514i0<? super T>> actual = new AtomicReference<>();

        c(int i2, a<?, K, T> aVar, K k2, boolean z) {
            this.queue = new C5111c<>(i2);
            this.parent = aVar;
            this.key = k2;
            this.delayError = z;
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC4514i0<? super T> interfaceC4514i0, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
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
                this.actual.lazySet(null);
                if (th != null) {
                    interfaceC4514i0.onError(th);
                } else {
                    interfaceC4514i0.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                interfaceC4514i0.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.actual.lazySet(null);
            interfaceC4514i0.onComplete();
            return true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            C5111c<T> c5111c = this.queue;
            boolean z = this.delayError;
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual.get();
            int i2 = 1;
            while (true) {
                if (interfaceC4514i0 != null) {
                    while (true) {
                        boolean z2 = this.done;
                        T poll = c5111c.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, interfaceC4514i0, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        } else {
                            interfaceC4514i0.onNext(poll);
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (interfaceC4514i0 == null) {
                    interfaceC4514i0 = this.actual.get();
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled.get();
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

        @Override // p251g.p252a.InterfaceC4504g0
        public void subscribe(InterfaceC4514i0<? super T> interfaceC4514i0) {
            if (!this.once.compareAndSet(false, true)) {
                EnumC4593e.error(new IllegalStateException("Only one Observer allowed!"), interfaceC4514i0);
                return;
            }
            interfaceC4514i0.onSubscribe(this);
            this.actual.lazySet(interfaceC4514i0);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }
    }

    public C4951h1(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f19035b = interfaceC4584o;
        this.f19036c = interfaceC4584o2;
        this.f19037d = i2;
        this.f19038e = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC5188b<K, V>> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19035b, this.f19036c, this.f19037d, this.f19038e));
    }
}
