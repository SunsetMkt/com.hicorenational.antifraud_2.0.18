package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableReduceSeedSingle.java */
/* renamed from: g.a.y0.e.b.r2 */
/* loaded from: classes2.dex */
public final class C4791r2<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC5821b<T> f18357a;

    /* renamed from: b */
    final R f18358b;

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f18359c;

    /* compiled from: FlowableReduceSeedSingle.java */
    /* renamed from: g.a.y0.e.b.r2$a */
    static final class a<T, R> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super R> f18360a;

        /* renamed from: b */
        final InterfaceC4572c<R, ? super T, R> f18361b;

        /* renamed from: c */
        R f18362c;

        /* renamed from: d */
        InterfaceC5823d f18363d;

        a(InterfaceC4524n0<? super R> interfaceC4524n0, InterfaceC4572c<R, ? super T, R> interfaceC4572c, R r) {
            this.f18360a = interfaceC4524n0;
            this.f18362c = r;
            this.f18361b = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18363d.cancel();
            this.f18363d = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18363d == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            R r = this.f18362c;
            this.f18362c = null;
            this.f18363d = EnumC5160j.CANCELLED;
            this.f18360a.onSuccess(r);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18362c = null;
            this.f18363d = EnumC5160j.CANCELLED;
            this.f18360a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                this.f18362c = (R) C4601b.m18284a(this.f18361b.apply(this.f18362c, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18363d.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18363d, interfaceC5823d)) {
                this.f18363d = interfaceC5823d;
                this.f18360a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4791r2(InterfaceC5821b<T> interfaceC5821b, R r, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        this.f18357a = interfaceC5821b;
        this.f18358b = r;
        this.f18359c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        this.f18357a.subscribe(new a(interfaceC4524n0, this.f18359c, this.f18358b));
    }
}
