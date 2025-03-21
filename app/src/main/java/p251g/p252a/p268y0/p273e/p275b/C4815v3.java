package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTakeLast.java */
/* renamed from: g.a.y0.e.b.v3 */
/* loaded from: classes2.dex */
public final class C4815v3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final int f18461c;

    /* compiled from: FlowableTakeLast.java */
    /* renamed from: g.a.y0.e.b.v3$a */
    static final class a<T> extends ArrayDeque<T> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 7240042530241604978L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;

        /* renamed from: s */
        InterfaceC5823d f18462s;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        a(InterfaceC5822c<? super T> interfaceC5822c, int i2) {
            this.actual = interfaceC5822c;
            this.count = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f18462s.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                InterfaceC5822c<? super T> interfaceC5822c = this.actual;
                long j2 = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j3 = 0;
                        while (j3 != j2) {
                            if (this.cancelled) {
                                return;
                            }
                            T poll = poll();
                            if (poll == null) {
                                interfaceC5822c.onComplete();
                                return;
                            } else {
                                interfaceC5822c.onNext(poll);
                                j3++;
                            }
                        }
                        if (j3 != 0 && j2 != C5556m0.f20396b) {
                            j2 = this.requested.addAndGet(-j3);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18462s, interfaceC5823d)) {
                this.f18462s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
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

    public C4815v3(AbstractC4519l<T> abstractC4519l, int i2) {
        super(abstractC4519l);
        this.f18461c = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18461c));
    }
}
