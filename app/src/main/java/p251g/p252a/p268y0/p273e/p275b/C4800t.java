package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCollectSingle.java */
/* renamed from: g.a.y0.e.b.t */
/* loaded from: classes2.dex */
public final class C4800t<T, U> extends AbstractC4518k0<U> implements InterfaceC4603b<U> {

    /* renamed from: a */
    final AbstractC4519l<T> f18404a;

    /* renamed from: b */
    final Callable<? extends U> f18405b;

    /* renamed from: c */
    final InterfaceC4571b<? super U, ? super T> f18406c;

    /* compiled from: FlowableCollectSingle.java */
    /* renamed from: g.a.y0.e.b.t$a */
    static final class a<T, U> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super U> f18407a;

        /* renamed from: b */
        final InterfaceC4571b<? super U, ? super T> f18408b;

        /* renamed from: c */
        final U f18409c;

        /* renamed from: d */
        InterfaceC5823d f18410d;

        /* renamed from: e */
        boolean f18411e;

        a(InterfaceC4524n0<? super U> interfaceC4524n0, U u, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
            this.f18407a = interfaceC4524n0;
            this.f18408b = interfaceC4571b;
            this.f18409c = u;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18410d.cancel();
            this.f18410d = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18410d == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18411e) {
                return;
            }
            this.f18411e = true;
            this.f18410d = EnumC5160j.CANCELLED;
            this.f18407a.onSuccess(this.f18409c);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18411e) {
                C4476a.m17152b(th);
                return;
            }
            this.f18411e = true;
            this.f18410d = EnumC5160j.CANCELLED;
            this.f18407a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18411e) {
                return;
            }
            try {
                this.f18408b.mo18209a(this.f18409c, t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18410d.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18410d, interfaceC5823d)) {
                this.f18410d = interfaceC5823d;
                this.f18407a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4800t(AbstractC4519l<T> abstractC4519l, Callable<? extends U> callable, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        this.f18404a = abstractC4519l;
        this.f18405b = callable;
        this.f18406c = interfaceC4571b;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super U> interfaceC4524n0) {
        try {
            this.f18404a.m17799a((InterfaceC4529q) new a(interfaceC4524n0, C4601b.m18284a(this.f18405b.call(), "The initialSupplier returned a null value"), this.f18406c));
        } catch (Throwable th) {
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<U> mo18286b() {
        return C4476a.m17129a(new C4794s(this.f18404a, this.f18405b, this.f18406c));
    }
}
