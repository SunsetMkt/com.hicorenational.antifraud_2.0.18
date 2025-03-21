package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelFromPublisher.java */
/* renamed from: g.a.y0.e.e.h */
/* loaded from: classes2.dex */
public final class C5052h<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f19604a;

    /* renamed from: b */
    final int f19605b;

    /* renamed from: c */
    final int f19606c;

    /* compiled from: ParallelFromPublisher.java */
    /* renamed from: g.a.y0.e.e.h$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        InterfaceC4616o<T> queue;
        final AtomicLongArray requests;

        /* renamed from: s */
        InterfaceC5823d f19607s;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final InterfaceC5822c<? super T>[] subscribers;

        /* compiled from: ParallelFromPublisher.java */
        /* renamed from: g.a.y0.e.e.h$a$a, reason: collision with other inner class name */
        final class C7423a implements InterfaceC5823d {

            /* renamed from: a */
            final int f19608a;

            /* renamed from: b */
            final int f19609b;

            C7423a(int i2, int i3) {
                this.f19608a = i2;
                this.f19609b = i3;
            }

            @Override // p324i.p338d.InterfaceC5823d
            public void cancel() {
                if (a.this.requests.compareAndSet(this.f19608a + this.f19609b, 0L, 1L)) {
                    a aVar = a.this;
                    int i2 = this.f19609b;
                    aVar.cancel(i2 + i2);
                }
            }

            @Override // p324i.p338d.InterfaceC5823d
            public void request(long j2) {
                long j3;
                if (EnumC5160j.validate(j2)) {
                    AtomicLongArray atomicLongArray = a.this.requests;
                    do {
                        j3 = atomicLongArray.get(this.f19608a);
                        if (j3 == C5556m0.f20396b) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f19608a, j3, C5164d.m18606a(j3, j2)));
                    if (a.this.subscriberCount.get() == this.f19609b) {
                        a.this.drain();
                    }
                }
            }
        }

        a(InterfaceC5822c<? super T>[] interfaceC5822cArr, int i2) {
            this.subscribers = interfaceC5822cArr;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            int length = interfaceC5822cArr.length;
            int i3 = length + length;
            this.requests = new AtomicLongArray(i3 + 1);
            this.requests.lazySet(i3, length);
            this.emissions = new long[length];
        }

        void cancel(int i2) {
            if (this.requests.decrementAndGet(i2) == 0) {
                this.cancelled = true;
                this.f19607s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            Throwable th;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            InterfaceC5822c<? super T>[] interfaceC5822cArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int i3 = this.produced;
            int i4 = 1;
            while (true) {
                int i5 = 0;
                int i6 = i3;
                int i7 = 0;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        interfaceC4616o.clear();
                        int length2 = interfaceC5822cArr.length;
                        while (i5 < length2) {
                            interfaceC5822cArr[i5].onError(th);
                            i5++;
                        }
                        return;
                    }
                    boolean isEmpty = interfaceC4616o.isEmpty();
                    if (z && isEmpty) {
                        int length3 = interfaceC5822cArr.length;
                        while (i5 < length3) {
                            interfaceC5822cArr[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                    if (!isEmpty) {
                        long j2 = atomicLongArray.get(i2);
                        long j3 = jArr[i2];
                        if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                            i7++;
                        } else {
                            try {
                                T poll = interfaceC4616o.poll();
                                if (poll != null) {
                                    interfaceC5822cArr[i2].onNext(poll);
                                    jArr[i2] = j3 + 1;
                                    int i8 = i6 + 1;
                                    if (i8 == this.limit) {
                                        this.f19607s.request(i8);
                                        i8 = 0;
                                    }
                                    i6 = i8;
                                    i7 = 0;
                                }
                            } catch (Throwable th2) {
                                C4561b.m18199b(th2);
                                this.f19607s.cancel();
                                int length4 = interfaceC5822cArr.length;
                                while (i5 < length4) {
                                    interfaceC5822cArr[i5].onError(th2);
                                    i5++;
                                }
                                return;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                        if (i7 == length) {
                        }
                    }
                    i3 = i6;
                    int i9 = get();
                    if (i9 == i4) {
                        this.index = i2;
                        this.produced = i3;
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    } else {
                        i4 = i9;
                    }
                }
                interfaceC4616o.clear();
                return;
            }
        }

        void drainSync() {
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            InterfaceC5822c<? super T>[] interfaceC5822cArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                int i5 = 0;
                while (!this.cancelled) {
                    if (interfaceC4616o.isEmpty()) {
                        int length2 = interfaceC5822cArr.length;
                        while (i4 < length2) {
                            interfaceC5822cArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    long j2 = atomicLongArray.get(i2);
                    long j3 = jArr[i2];
                    if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                        i5++;
                    } else {
                        try {
                            T poll = interfaceC4616o.poll();
                            if (poll == null) {
                                int length3 = interfaceC5822cArr.length;
                                while (i4 < length3) {
                                    interfaceC5822cArr[i4].onComplete();
                                    i4++;
                                }
                                return;
                            }
                            interfaceC5822cArr[i2].onNext(poll);
                            jArr[i2] = j3 + 1;
                            i5 = 0;
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            this.f19607s.cancel();
                            int length4 = interfaceC5822cArr.length;
                            while (i4 < length4) {
                                interfaceC5822cArr[i4].onError(th);
                                i4++;
                            }
                            return;
                        }
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                    }
                    if (i5 == length) {
                        int i6 = get();
                        if (i6 == i3) {
                            this.index = i2;
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else {
                            i3 = i6;
                        }
                    }
                }
                interfaceC4616o.clear();
                return;
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                this.f19607s.cancel();
                onError(new C4562c("Queue is full?"));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19607s, interfaceC5823d)) {
                this.f19607s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        setupSubscribers();
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                setupSubscribers();
                interfaceC5823d.request(this.prefetch);
            }
        }

        void setupSubscribers() {
            InterfaceC5822c<? super T>[] interfaceC5822cArr = this.subscribers;
            int length = interfaceC5822cArr.length;
            int i2 = 0;
            while (i2 < length && !this.cancelled) {
                int i3 = i2 + 1;
                this.subscriberCount.lazySet(i3);
                interfaceC5822cArr[i2].onSubscribe(new C7423a(i2, length));
                i2 = i3;
            }
        }
    }

    public C5052h(InterfaceC5821b<? extends T> interfaceC5821b, int i2, int i3) {
        this.f19604a = interfaceC5821b;
        this.f19605b = i2;
        this.f19606c = i3;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19605b;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super T>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            this.f19604a.subscribe(new a(interfaceC5822cArr, this.f19606c));
        }
    }
}
