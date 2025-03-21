package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p282h.C5139j;
import p251g.p252a.p268y0.p282h.InterfaceC5140k;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableConcatMapEager.java */
/* renamed from: g.a.y0.e.b.x */
/* loaded from: classes2.dex */
public final class C4821x<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f18480c;

    /* renamed from: d */
    final int f18481d;

    /* renamed from: e */
    final int f18482e;

    /* renamed from: f */
    final EnumC5170j f18483f;

    /* compiled from: FlowableConcatMapEager.java */
    /* renamed from: g.a.y0.e.b.x$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC5140k<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        volatile C5139j<R> current;
        volatile boolean done;
        final EnumC5170j errorMode;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;

        /* renamed from: s */
        InterfaceC5823d f18484s;
        final C5111c<C5139j<R>> subscribers;
        final C5163c errors = new C5163c();
        final AtomicLong requested = new AtomicLong();

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, int i3, EnumC5170j enumC5170j) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = enumC5170j;
            this.subscribers = new C5111c<>(Math.min(i3, i2));
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f18484s.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            while (true) {
                C5139j<R> poll = this.subscribers.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.cancel();
                }
            }
        }

        @Override // p251g.p252a.p268y0.p282h.InterfaceC5140k
        public void drain() {
            C5139j<R> c5139j;
            int i2;
            long j2;
            boolean z;
            InterfaceC4616o<R> queue;
            if (getAndIncrement() != 0) {
                return;
            }
            C5139j<R> c5139j2 = this.current;
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            EnumC5170j enumC5170j = this.errorMode;
            int i3 = 1;
            while (true) {
                long j3 = this.requested.get();
                if (c5139j2 != null) {
                    c5139j = c5139j2;
                } else {
                    if (enumC5170j != EnumC5170j.END && this.errors.get() != null) {
                        cancelAll();
                        interfaceC5822c.onError(this.errors.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    c5139j = this.subscribers.poll();
                    if (z2 && c5139j == null) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            interfaceC5822c.onError(terminate);
                            return;
                        } else {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    }
                    if (c5139j != null) {
                        this.current = c5139j;
                    }
                }
                if (c5139j == null || (queue = c5139j.queue()) == null) {
                    i2 = i3;
                    c5139j2 = c5139j;
                    j2 = 0;
                    z = false;
                } else {
                    i2 = i3;
                    j2 = 0;
                    while (j2 != j3) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (enumC5170j == EnumC5170j.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            c5139j.cancel();
                            cancelAll();
                            interfaceC5822c.onError(this.errors.terminate());
                            return;
                        }
                        boolean isDone = c5139j.isDone();
                        try {
                            R poll = queue.poll();
                            boolean z3 = poll == null;
                            if (isDone && z3) {
                                this.current = null;
                                this.f18484s.request(1L);
                                c5139j = null;
                                z = true;
                                break;
                            }
                            if (z3) {
                                break;
                            }
                            interfaceC5822c.onNext(poll);
                            j2++;
                            c5139j.requestOne();
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            this.current = null;
                            c5139j.cancel();
                            cancelAll();
                            interfaceC5822c.onError(th);
                            return;
                        }
                    }
                    z = false;
                    if (j2 == j3) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        }
                        if (enumC5170j == EnumC5170j.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            c5139j.cancel();
                            cancelAll();
                            interfaceC5822c.onError(this.errors.terminate());
                            return;
                        }
                        boolean isDone2 = c5139j.isDone();
                        boolean isEmpty = queue.isEmpty();
                        if (isDone2 && isEmpty) {
                            this.current = null;
                            this.f18484s.request(1L);
                            c5139j2 = null;
                            z = true;
                        }
                    }
                    c5139j2 = c5139j;
                }
                if (j2 != 0 && j3 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j2);
                }
                if (z) {
                    i3 = i2;
                } else {
                    i3 = addAndGet(-i2);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // p251g.p252a.p268y0.p282h.InterfaceC5140k
        public void innerComplete(C5139j<R> c5139j) {
            c5139j.setDone();
            drain();
        }

        @Override // p251g.p252a.p268y0.p282h.InterfaceC5140k
        public void innerError(C5139j<R> c5139j, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            c5139j.setDone();
            if (this.errorMode != EnumC5170j.END) {
                this.f18484s.cancel();
            }
            drain();
        }

        @Override // p251g.p252a.p268y0.p282h.InterfaceC5140k
        public void innerNext(C5139j<R> c5139j, R r) {
            if (c5139j.queue().offer(r)) {
                drain();
            } else {
                c5139j.cancel();
                innerError(c5139j, new C4562c());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null Publisher");
                C5139j<R> c5139j = new C5139j<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(c5139j);
                if (this.cancelled) {
                    return;
                }
                interfaceC5821b.subscribe(c5139j);
                if (this.cancelled) {
                    c5139j.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18484s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18484s, interfaceC5823d)) {
                this.f18484s = interfaceC5823d;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                interfaceC5823d.request(i2 == Integer.MAX_VALUE ? C5556m0.f20396b : i2);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    public C4821x(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, int i3, EnumC5170j enumC5170j) {
        super(abstractC4519l);
        this.f18480c = interfaceC4584o;
        this.f18481d = i2;
        this.f18482e = i3;
        this.f18483f = enumC5170j;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18480c, this.f18481d, this.f18482e, this.f18483f));
    }
}
