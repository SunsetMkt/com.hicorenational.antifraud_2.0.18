package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableIgnoreElementsCompletable.java */
/* renamed from: g.a.y0.e.b.o1 */
/* loaded from: classes2.dex */
public final class C4772o1<T> extends AbstractC4474c implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18163a;

    /* compiled from: FlowableIgnoreElementsCompletable.java */
    /* renamed from: g.a.y0.e.b.o1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f18164a;

        /* renamed from: b */
        InterfaceC5823d f18165b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f18164a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18165b.cancel();
            this.f18165b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18165b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18165b = EnumC5160j.CANCELLED;
            this.f18164a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18165b = EnumC5160j.CANCELLED;
            this.f18164a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18165b, interfaceC5823d)) {
                this.f18165b = interfaceC5823d;
                this.f18164a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4772o1(AbstractC4519l<T> abstractC4519l) {
        this.f18163a = abstractC4519l;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f18163a.m17799a((InterfaceC4529q) new a(interfaceC4491f));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4766n1(this.f18163a));
    }
}
