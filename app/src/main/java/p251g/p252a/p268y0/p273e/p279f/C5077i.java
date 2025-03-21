package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.C4618a0;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SingleDelayWithPublisher.java */
/* renamed from: g.a.y0.e.f.i */
/* loaded from: classes2.dex */
public final class C5077i<T, U> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19718a;

    /* renamed from: b */
    final InterfaceC5821b<U> f19719b;

    /* compiled from: SingleDelayWithPublisher.java */
    /* renamed from: g.a.y0.e.f.i$a */
    static final class a<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4529q<U>, InterfaceC4552c {
        private static final long serialVersionUID = -8565274649390031272L;
        final InterfaceC4524n0<? super T> actual;
        boolean done;

        /* renamed from: s */
        InterfaceC5823d f19720s;
        final InterfaceC4530q0<T> source;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4530q0<T> interfaceC4530q0) {
            this.actual = interfaceC4524n0;
            this.source = interfaceC4530q0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19720s.cancel();
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.mo17490a(new C4618a0(this, this.actual));
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(U u) {
            this.f19720s.cancel();
            onComplete();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19720s, interfaceC5823d)) {
                this.f19720s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C5077i(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC5821b<U> interfaceC5821b) {
        this.f19718a = interfaceC4530q0;
        this.f19719b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19719b.subscribe(new a(interfaceC4524n0, this.f19718a));
    }
}
