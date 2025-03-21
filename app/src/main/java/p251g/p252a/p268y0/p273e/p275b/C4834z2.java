package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p283i.C5159i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRetryPredicate.java */
/* renamed from: g.a.y0.e.b.z2 */
/* loaded from: classes2.dex */
public final class C4834z2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4587r<? super Throwable> f18543c;

    /* renamed from: d */
    final long f18544d;

    /* compiled from: FlowableRetryPredicate.java */
    /* renamed from: g.a.y0.e.b.z2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4587r<? super Throwable> predicate;
        long remaining;

        /* renamed from: sa */
        final C5159i f18545sa;
        final InterfaceC5821b<? extends T> source;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, InterfaceC4587r<? super Throwable> interfaceC4587r, C5159i c5159i, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.f18545sa = c5159i;
            this.source = interfaceC5821b;
            this.predicate = interfaceC4587r;
            this.remaining = j2;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            long j2 = this.remaining;
            if (j2 != C5556m0.f20396b) {
                this.remaining = j2 - 1;
            }
            if (j2 == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
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
            this.f18545sa.produced(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f18545sa.setSubscription(interfaceC5823d);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f18545sa.isCancelled()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4834z2(AbstractC4519l<T> abstractC4519l, long j2, InterfaceC4587r<? super Throwable> interfaceC4587r) {
        super(abstractC4519l);
        this.f18543c = interfaceC4587r;
        this.f18544d = j2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5159i c5159i = new C5159i();
        interfaceC5822c.onSubscribe(c5159i);
        new a(interfaceC5822c, this.f18544d, this.f18543c, c5159i, this.f17759b).subscribeNext();
    }
}
