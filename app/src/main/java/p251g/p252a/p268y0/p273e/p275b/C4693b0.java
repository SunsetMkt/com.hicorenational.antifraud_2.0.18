package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCountSingle.java */
/* renamed from: g.a.y0.e.b.b0 */
/* loaded from: classes2.dex */
public final class C4693b0<T> extends AbstractC4518k0<Long> implements InterfaceC4603b<Long> {

    /* renamed from: a */
    final AbstractC4519l<T> f17776a;

    /* compiled from: FlowableCountSingle.java */
    /* renamed from: g.a.y0.e.b.b0$a */
    static final class a implements InterfaceC4529q<Object>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Long> f17777a;

        /* renamed from: b */
        InterfaceC5823d f17778b;

        /* renamed from: c */
        long f17779c;

        a(InterfaceC4524n0<? super Long> interfaceC4524n0) {
            this.f17777a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17778b.cancel();
            this.f17778b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17778b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17778b = EnumC5160j.CANCELLED;
            this.f17777a.onSuccess(Long.valueOf(this.f17779c));
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17778b = EnumC5160j.CANCELLED;
            this.f17777a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            this.f17779c++;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17778b, interfaceC5823d)) {
                this.f17778b = interfaceC5823d;
                this.f17777a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4693b0(AbstractC4519l<T> abstractC4519l) {
        this.f17776a = abstractC4519l;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Long> interfaceC4524n0) {
        this.f17776a.m17799a((InterfaceC4529q) new a(interfaceC4524n0));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<Long> mo18286b() {
        return C4476a.m17129a(new C4687a0(this.f17776a));
    }
}
