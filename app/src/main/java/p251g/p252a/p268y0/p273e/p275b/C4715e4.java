package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p275b.C4721f4;
import p251g.p252a.p268y0.p283i.C5159i;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTimeout.java */
/* renamed from: g.a.y0.e.b.e4 */
/* loaded from: classes2.dex */
public final class C4715e4<T, U, V> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC5821b<U> f17866c;

    /* renamed from: d */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<V>> f17867d;

    /* renamed from: e */
    final InterfaceC5821b<? extends T> f17868e;

    /* compiled from: FlowableTimeout.java */
    /* renamed from: g.a.y0.e.b.e4$a */
    static final class a extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object>, InterfaceC4552c {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final c parent;

        a(long j2, c cVar) {
            this.idx = j2;
            this.parent = cVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            Object obj = get();
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (obj != enumC5160j) {
                lazySet(enumC5160j);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            Object obj = get();
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (obj == enumC5160j) {
                C4476a.m17152b(th);
            } else {
                lazySet(enumC5160j);
                this.parent.onTimeoutError(this.idx, th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            InterfaceC5823d interfaceC5823d = (InterfaceC5823d) get();
            if (interfaceC5823d != EnumC5160j.CANCELLED) {
                interfaceC5823d.cancel();
                lazySet(EnumC5160j.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    /* compiled from: FlowableTimeout.java */
    /* renamed from: g.a.y0.e.b.e4$b */
    static final class b<T> extends C5159i implements InterfaceC4529q<T>, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final InterfaceC5822c<? super T> actual;
        long consumed;
        InterfaceC5821b<? extends T> fallback;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<?>> itemTimeoutIndicator;
        final C4599k task = new C4599k();
        final AtomicReference<InterfaceC5823d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<?>> interfaceC4584o, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.itemTimeoutIndicator = interfaceC4584o;
            this.fallback = interfaceC5821b;
        }

        @Override // p251g.p252a.p268y0.p283i.C5159i, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.index.getAndSet(C5556m0.f20396b) != C5556m0.f20396b) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.index.getAndSet(C5556m0.f20396b) == C5556m0.f20396b) {
                C4476a.m17152b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.task.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != C5556m0.f20396b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    InterfaceC4552c interfaceC4552c = this.task.get();
                    if (interfaceC4552c != null) {
                        interfaceC4552c.dispose();
                    }
                    this.consumed++;
                    this.actual.onNext(t);
                    try {
                        InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            interfaceC5821b.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(C5556m0.f20396b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this.upstream, interfaceC5823d)) {
                setSubscription(interfaceC5823d);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4721f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, C5556m0.f20396b)) {
                EnumC5160j.cancel(this.upstream);
                InterfaceC5821b<? extends T> interfaceC5821b = this.fallback;
                this.fallback = null;
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                interfaceC5821b.subscribe(new C4721f4.a(this.actual, this));
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4715e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!this.index.compareAndSet(j2, C5556m0.f20396b)) {
                C4476a.m17152b(th);
            } else {
                EnumC5160j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        void startFirstTimeout(InterfaceC5821b<?> interfaceC5821b) {
            if (interfaceC5821b != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    interfaceC5821b.subscribe(aVar);
                }
            }
        }
    }

    /* compiled from: FlowableTimeout.java */
    /* renamed from: g.a.y0.e.b.e4$c */
    interface c extends C4721f4.d {
        void onTimeoutError(long j2, Throwable th);
    }

    /* compiled from: FlowableTimeout.java */
    /* renamed from: g.a.y0.e.b.e4$d */
    static final class d<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<?>> itemTimeoutIndicator;
        final C4599k task = new C4599k();
        final AtomicReference<InterfaceC5823d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        d(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<?>> interfaceC4584o) {
            this.actual = interfaceC5822c;
            this.itemTimeoutIndicator = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (getAndSet(C5556m0.f20396b) != C5556m0.f20396b) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (getAndSet(C5556m0.f20396b) == C5556m0.f20396b) {
                C4476a.m17152b(th);
            } else {
                this.task.dispose();
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != C5556m0.f20396b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    InterfaceC4552c interfaceC4552c = this.task.get();
                    if (interfaceC4552c != null) {
                        interfaceC4552c.dispose();
                    }
                    this.actual.onNext(t);
                    try {
                        InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            interfaceC5821b.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.upstream.get().cancel();
                        getAndSet(C5556m0.f20396b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.upstream, this.requested, interfaceC5823d);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4721f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, C5556m0.f20396b)) {
                EnumC5160j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4715e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!compareAndSet(j2, C5556m0.f20396b)) {
                C4476a.m17152b(th);
            } else {
                EnumC5160j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startFirstTimeout(InterfaceC5821b<?> interfaceC5821b) {
            if (interfaceC5821b != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    interfaceC5821b.subscribe(aVar);
                }
            }
        }
    }

    public C4715e4(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<U> interfaceC5821b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<V>> interfaceC4584o, InterfaceC5821b<? extends T> interfaceC5821b2) {
        super(abstractC4519l);
        this.f17866c = interfaceC5821b;
        this.f17867d = interfaceC4584o;
        this.f17868e = interfaceC5821b2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        InterfaceC5821b<? extends T> interfaceC5821b = this.f17868e;
        if (interfaceC5821b == null) {
            d dVar = new d(interfaceC5822c, this.f17867d);
            interfaceC5822c.onSubscribe(dVar);
            dVar.startFirstTimeout(this.f17866c);
            this.f17759b.m17799a((InterfaceC4529q) dVar);
            return;
        }
        b bVar = new b(interfaceC5822c, this.f17867d, interfaceC5821b);
        interfaceC5822c.onSubscribe(bVar);
        bVar.startFirstTimeout(this.f17866c);
        this.f17759b.m17799a((InterfaceC4529q) bVar);
    }
}
