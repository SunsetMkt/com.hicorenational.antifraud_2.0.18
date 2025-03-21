package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p256d1.AbstractC4481c;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5159i;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRepeatWhen.java */
/* renamed from: g.a.y0.e.b.w2 */
/* loaded from: classes2.dex */
public final class C4819w2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super AbstractC4519l<Object>, ? extends InterfaceC5821b<?>> f18478c;

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: g.a.y0.e.b.w2$a */
    static final class a<T> extends c<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4481c<Object> abstractC4481c, InterfaceC5823d interfaceC5823d) {
            super(interfaceC5822c, abstractC4481c, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            again(0);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f25900receiver.cancel();
            ((c) this).actual.onError(th);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: g.a.y0.e.b.w2$b */
    static final class b<T, U> extends AtomicInteger implements InterfaceC4529q<Object>, InterfaceC5823d {
        private static final long serialVersionUID = 2827772011130406689L;
        final InterfaceC5821b<T> source;
        c<T, U> subscriber;
        final AtomicReference<InterfaceC5823d> subscription = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(InterfaceC5821b<T> interfaceC5821b) {
            this.source = interfaceC5821b;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.subscription);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (!EnumC5160j.isCancelled(this.subscription.get())) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.subscription, this.requested, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.subscription, this.requested, j2);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: g.a.y0.e.b.w2$c */
    static abstract class c<T, U> extends C5159i implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final InterfaceC5822c<? super T> actual;
        protected final AbstractC4481c<U> processor;
        private long produced;

        /* renamed from: receiver, reason: collision with root package name */
        protected final InterfaceC5823d f25900receiver;

        c(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4481c<U> abstractC4481c, InterfaceC5823d interfaceC5823d) {
            this.actual = interfaceC5822c;
            this.processor = abstractC4481c;
            this.f25900receiver = interfaceC5823d;
        }

        protected final void again(U u) {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.f25900receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // p251g.p252a.p268y0.p283i.C5159i, p324i.p338d.InterfaceC5823d
        public final void cancel() {
            super.cancel();
            this.f25900receiver.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
            setSubscription(interfaceC5823d);
        }
    }

    public C4819w2(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super AbstractC4519l<Object>, ? extends InterfaceC5821b<?>> interfaceC4584o) {
        super(abstractC4519l);
        this.f18478c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        AbstractC4481c<T> m17229X = C4485g.m17260m(8).m17229X();
        try {
            InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18478c.apply(m17229X), "handler returned a null Publisher");
            b bVar = new b(this.f17759b);
            a aVar = new a(c4509e, m17229X, bVar);
            bVar.subscriber = aVar;
            interfaceC5822c.onSubscribe(aVar);
            interfaceC5821b.subscribe(bVar);
            bVar.onNext(0);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
