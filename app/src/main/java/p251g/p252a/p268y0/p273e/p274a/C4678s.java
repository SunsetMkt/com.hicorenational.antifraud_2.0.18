package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: CompletableFromPublisher.java */
/* renamed from: g.a.y0.e.a.s */
/* loaded from: classes2.dex */
public final class C4678s<T> extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC5821b<T> f17742a;

    /* compiled from: CompletableFromPublisher.java */
    /* renamed from: g.a.y0.e.a.s$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f17743a;

        /* renamed from: b */
        InterfaceC5823d f17744b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17743a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17744b.cancel();
            this.f17744b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17744b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17743a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17743a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17744b, interfaceC5823d)) {
                this.f17744b = interfaceC5823d;
                this.f17743a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4678s(InterfaceC5821b<T> interfaceC5821b) {
        this.f17742a = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17742a.subscribe(new a(interfaceC4491f));
    }
}
