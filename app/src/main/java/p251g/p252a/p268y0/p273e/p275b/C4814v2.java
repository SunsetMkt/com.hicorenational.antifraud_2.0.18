package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4574e;
import p251g.p252a.p268y0.p283i.C5159i;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRepeatUntil.java */
/* renamed from: g.a.y0.e.b.v2 */
/* loaded from: classes2.dex */
public final class C4814v2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4574e f18459c;

    /* compiled from: FlowableRepeatUntil.java */
    /* renamed from: g.a.y0.e.b.v2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC5822c<? super T> actual;

        /* renamed from: sa */
        final C5159i f18460sa;
        final InterfaceC5821b<? extends T> source;
        final InterfaceC4574e stop;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4574e interfaceC4574e, C5159i c5159i, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.f18460sa = c5159i;
            this.source = interfaceC5821b;
            this.stop = interfaceC4574e;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
            this.f18460sa.produced(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f18460sa.setSubscription(interfaceC5823d);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    public C4814v2(AbstractC4519l<T> abstractC4519l, InterfaceC4574e interfaceC4574e) {
        super(abstractC4519l);
        this.f18459c = interfaceC4574e;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5159i c5159i = new C5159i();
        interfaceC5822c.onSubscribe(c5159i);
        new a(interfaceC5822c, this.f18459c, c5159i, this.f17759b).subscribeNext();
    }
}
