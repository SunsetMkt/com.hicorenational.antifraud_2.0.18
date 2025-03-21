package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p283i.C5159i;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRetryBiPredicate.java */
/* renamed from: g.a.y0.e.b.y2 */
/* loaded from: classes2.dex */
public final class C4829y2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4573d<? super Integer, ? super Throwable> f18528c;

    /* compiled from: FlowableRetryBiPredicate.java */
    /* renamed from: g.a.y0.e.b.y2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4573d<? super Integer, ? super Throwable> predicate;
        int retries;

        /* renamed from: sa */
        final C5159i f18529sa;
        final InterfaceC5821b<? extends T> source;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d, C5159i c5159i, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.f18529sa = c5159i;
            this.source = interfaceC5821b;
            this.predicate = interfaceC4573d;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            try {
                InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (interfaceC4573d.mo18210a(Integer.valueOf(i2), th)) {
                    subscribeNext();
                } else {
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.actual.onError(new C4560a(th, th2));
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
            this.f18529sa.produced(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f18529sa.setSubscription(interfaceC5823d);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f18529sa.isCancelled()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4829y2(AbstractC4519l<T> abstractC4519l, InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d) {
        super(abstractC4519l);
        this.f18528c = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5159i c5159i = new C5159i();
        interfaceC5822c.onSubscribe(c5159i);
        new a(interfaceC5822c, this.f18528c, c5159i, this.f17759b).subscribeNext();
    }
}
