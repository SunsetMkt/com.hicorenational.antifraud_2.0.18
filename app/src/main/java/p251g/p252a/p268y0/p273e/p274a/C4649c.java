package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: CompletableConcat.java */
/* renamed from: g.a.y0.e.a.c */
/* loaded from: classes2.dex */
public final class C4649c extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC5821b<? extends InterfaceC4513i> f17644a;

    /* renamed from: b */
    final int f17645b;

    /* compiled from: CompletableConcat.java */
    /* renamed from: g.a.y0.e.a.c$a */
    static final class a extends AtomicInteger implements InterfaceC4529q<InterfaceC4513i>, InterfaceC4552c {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        final InterfaceC4491f actual;
        int consumed;
        volatile boolean done;
        final int limit;
        final int prefetch;
        InterfaceC4616o<InterfaceC4513i> queue;

        /* renamed from: s */
        InterfaceC5823d f17646s;
        int sourceFused;
        final C7383a inner = new C7383a(this);
        final AtomicBoolean once = new AtomicBoolean();

        /* compiled from: CompletableConcat.java */
        /* renamed from: g.a.y0.e.a.c$a$a, reason: collision with other inner class name */
        static final class C7383a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f {
            private static final long serialVersionUID = -5454794857847146511L;
            final a parent;

            C7383a(a aVar) {
                this.parent = aVar;
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.replace(this, interfaceC4552c);
            }
        }

        a(InterfaceC4491f interfaceC4491f, int i2) {
            this.actual = interfaceC4491f;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17646s.cancel();
            EnumC4592d.dispose(this.inner);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        InterfaceC4513i poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            if (this.once.compareAndSet(false, true)) {
                                this.actual.onComplete();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.active = true;
                            poll.mo17074a(this.inner);
                            request();
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        innerError(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                this.f17646s.cancel();
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.inner.get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                EnumC4592d.dispose(this.inner);
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17646s, interfaceC5823d)) {
                this.f17646s = interfaceC5823d;
                int i2 = this.prefetch;
                long j2 = i2 == Integer.MAX_VALUE ? C5556m0.f20396b : i2;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceFused = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceFused = requestFusion;
                        this.queue = interfaceC4613l;
                        this.actual.onSubscribe(this);
                        interfaceC5823d.request(j2);
                        return;
                    }
                }
                int i3 = this.prefetch;
                if (i3 == Integer.MAX_VALUE) {
                    this.queue = new C5111c(AbstractC4519l.m17539Q());
                } else {
                    this.queue = new C5110b(i3);
                }
                this.actual.onSubscribe(this);
                interfaceC5823d.request(j2);
            }
        }

        void request() {
            if (this.sourceFused != 1) {
                int i2 = this.consumed + 1;
                if (i2 != this.limit) {
                    this.consumed = i2;
                } else {
                    this.consumed = 0;
                    this.f17646s.request(i2);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(InterfaceC4513i interfaceC4513i) {
            if (this.sourceFused != 0 || this.queue.offer(interfaceC4513i)) {
                drain();
            } else {
                onError(new C4562c());
            }
        }
    }

    public C4649c(InterfaceC5821b<? extends InterfaceC4513i> interfaceC5821b, int i2) {
        this.f17644a = interfaceC5821b;
        this.f17645b = i2;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17644a.subscribe(new a(interfaceC4491f, this.f17645b));
    }
}
