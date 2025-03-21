package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.C5159i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRepeat.java */
/* renamed from: g.a.y0.e.b.u2 */
/* loaded from: classes2.dex */
public final class C4809u2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18445c;

    /* compiled from: FlowableRepeat.java */
    /* renamed from: g.a.y0.e.b.u2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC5822c<? super T> actual;
        long remaining;

        /* renamed from: sa */
        final C5159i f18446sa;
        final InterfaceC5821b<? extends T> source;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, C5159i c5159i, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.actual = interfaceC5822c;
            this.f18446sa = c5159i;
            this.source = interfaceC5821b;
            this.remaining = j2;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            long j2 = this.remaining;
            if (j2 != C5556m0.f20396b) {
                this.remaining = j2 - 1;
            }
            if (j2 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
            this.f18446sa.produced(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f18446sa.setSubscription(interfaceC5823d);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f18446sa.isCancelled()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4809u2(AbstractC4519l<T> abstractC4519l, long j2) {
        super(abstractC4519l);
        this.f18445c = j2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5159i c5159i = new C5159i();
        interfaceC5822c.onSubscribe(c5159i);
        long j2 = this.f18445c;
        long j3 = C5556m0.f20396b;
        if (j2 != C5556m0.f20396b) {
            j3 = j2 - 1;
        }
        new a(interfaceC5822c, j3, c5159i, this.f17759b).subscribeNext();
    }
}
