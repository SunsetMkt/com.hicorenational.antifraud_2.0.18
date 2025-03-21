package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableLastMaybe.java */
/* renamed from: g.a.y0.e.b.u1 */
/* loaded from: classes2.dex */
public final class C4808u1<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC5821b<T> f18441a;

    /* compiled from: FlowableLastMaybe.java */
    /* renamed from: g.a.y0.e.b.u1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18442a;

        /* renamed from: b */
        InterfaceC5823d f18443b;

        /* renamed from: c */
        T f18444c;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18442a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18443b.cancel();
            this.f18443b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18443b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18443b = EnumC5160j.CANCELLED;
            T t = this.f18444c;
            if (t == null) {
                this.f18442a.onComplete();
            } else {
                this.f18444c = null;
                this.f18442a.onSuccess(t);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18443b = EnumC5160j.CANCELLED;
            this.f18444c = null;
            this.f18442a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f18444c = t;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18443b, interfaceC5823d)) {
                this.f18443b = interfaceC5823d;
                this.f18442a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4808u1(InterfaceC5821b<T> interfaceC5821b) {
        this.f18441a = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18441a.subscribe(new a(interfaceC4559v));
    }
}
