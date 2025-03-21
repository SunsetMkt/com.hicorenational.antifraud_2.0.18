package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p275b.C4828y1;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCombineLatest.java */
/* renamed from: g.a.y0.e.b.u */
/* loaded from: classes2.dex */
public final class C4806u<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    @InterfaceC4547g
    final InterfaceC5821b<? extends T>[] f18434b;

    /* renamed from: c */
    @InterfaceC4547g
    final Iterable<? extends InterfaceC5821b<? extends T>> f18435c;

    /* renamed from: d */
    final InterfaceC4584o<? super Object[], ? extends R> f18436d;

    /* renamed from: e */
    final int f18437e;

    /* renamed from: f */
    final boolean f18438f;

    /* compiled from: FlowableCombineLatest.java */
    /* renamed from: g.a.y0.e.b.u$a */
    static final class a<T, R> extends AbstractC5153c<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        final InterfaceC4584o<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final C5111c<Object> queue;
        final AtomicLong requested;
        final b<T>[] subscribers;

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, int i3, boolean z) {
            this.actual = interfaceC5822c;
            this.combiner = interfaceC4584o;
            b<T>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i4, i3);
            }
            this.subscribers = bVarArr;
            this.latest = new Object[i2];
            this.queue = new C5111c<>(i3);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (b<T> bVar : this.subscribers) {
                bVar.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, C5111c<?> c5111c) {
            if (this.cancelled) {
                cancelAll();
                c5111c.clear();
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
                Throwable m18622a = C5171k.m18622a(this.error);
                if (m18622a == null || m18622a == C5171k.f20031a) {
                    interfaceC5822c.onComplete();
                } else {
                    interfaceC5822c.onError(m18622a);
                }
                return true;
            }
            Throwable m18622a2 = C5171k.m18622a(this.error);
            if (m18622a2 != null && m18622a2 != C5171k.f20031a) {
                cancelAll();
                c5111c.clear();
                interfaceC5822c.onError(m18622a2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancelAll();
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
                drainOutput();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            C5111c<?> c5111c = this.queue;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    Object poll = c5111c.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, interfaceC5822c, c5111c)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        interfaceC5822c.onNext((Object) C4601b.m18284a(this.combiner.apply((Object[]) c5111c.poll()), "The combiner returned a null value"));
                        ((b) poll).requestOne();
                        j3++;
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        cancelAll();
                        C5171k.m18624a(this.error, th);
                        interfaceC5822c.onError(C5171k.m18622a(this.error));
                        return;
                    }
                }
                if (j3 == j2 && checkTerminated(this.done, c5111c.isEmpty(), interfaceC5822c, c5111c)) {
                    return;
                }
                if (j3 != 0 && j2 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j3);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        void drainOutput() {
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            C5111c<Object> c5111c = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    c5111c.clear();
                    interfaceC5822c.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean isEmpty = c5111c.isEmpty();
                if (!isEmpty) {
                    interfaceC5822c.onNext(null);
                }
                if (z && isEmpty) {
                    interfaceC5822c.onComplete();
                    return;
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            c5111c.clear();
        }

        void innerComplete(int i2) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i2] != null) {
                    int i3 = this.completedSources + 1;
                    if (i3 != objArr.length) {
                        this.completedSources = i3;
                        return;
                    }
                    this.done = true;
                } else {
                    this.done = true;
                }
                drain();
            }
        }

        void innerError(int i2, Throwable th) {
            if (!C5171k.m18624a(this.error, th)) {
                C4476a.m17152b(th);
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

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) C4601b.m18284a(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((b) poll).requestOne();
            return r;
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
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            this.outputFused = i3 != 0;
            return i3;
        }

        void subscribe(InterfaceC5821b<? extends T>[] interfaceC5821bArr, int i2) {
            b<T>[] bVarArr = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.done && !this.cancelled; i3++) {
                interfaceC5821bArr[i3].subscribe(bVarArr[i3]);
            }
        }
    }

    /* compiled from: FlowableCombineLatest.java */
    /* renamed from: g.a.y0.e.b.u$b */
    static final class b<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T> {
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
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(this.prefetch);
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

    /* compiled from: FlowableCombineLatest.java */
    /* renamed from: g.a.y0.e.b.u$c */
    final class c implements InterfaceC4584o<T, R> {
        c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return C4806u.this.f18436d.apply(new Object[]{t});
        }
    }

    public C4806u(@InterfaceC4546f InterfaceC5821b<? extends T>[] interfaceC5821bArr, @InterfaceC4546f InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
        this.f18434b = interfaceC5821bArr;
        this.f18435c = null;
        this.f18436d = interfaceC4584o;
        this.f18437e = i2;
        this.f18438f = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        int length;
        InterfaceC5821b<? extends T>[] interfaceC5821bArr = this.f18434b;
        if (interfaceC5821bArr == null) {
            interfaceC5821bArr = new InterfaceC5821b[8];
            try {
                Iterator it = (Iterator) C4601b.m18284a(this.f18435c.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            InterfaceC5821b<? extends T> interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(it.next(), "The publisher returned by the iterator is null");
                            if (length == interfaceC5821bArr.length) {
                                InterfaceC5821b<? extends T>[] interfaceC5821bArr2 = new InterfaceC5821b[(length >> 2) + length];
                                System.arraycopy(interfaceC5821bArr, 0, interfaceC5821bArr2, 0, length);
                                interfaceC5821bArr = interfaceC5821bArr2;
                            }
                            interfaceC5821bArr[length] = interfaceC5821b;
                            length++;
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            EnumC5157g.error(th, interfaceC5822c);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        EnumC5157g.error(th2, interfaceC5822c);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                EnumC5157g.error(th3, interfaceC5822c);
                return;
            }
        } else {
            length = interfaceC5821bArr.length;
        }
        if (length == 0) {
            EnumC5157g.complete(interfaceC5822c);
            return;
        }
        if (length == 1) {
            interfaceC5821bArr[0].subscribe(new C4828y1.b(interfaceC5822c, new c()));
            return;
        }
        a aVar = new a(interfaceC5822c, this.f18436d, length, this.f18437e, this.f18438f);
        interfaceC5822c.onSubscribe(aVar);
        aVar.subscribe(interfaceC5821bArr, length);
    }

    public C4806u(@InterfaceC4546f Iterable<? extends InterfaceC5821b<? extends T>> iterable, @InterfaceC4546f InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
        this.f18434b = null;
        this.f18435c = iterable;
        this.f18436d = interfaceC4584o;
        this.f18437e = i2;
        this.f18438f = z;
    }
}
