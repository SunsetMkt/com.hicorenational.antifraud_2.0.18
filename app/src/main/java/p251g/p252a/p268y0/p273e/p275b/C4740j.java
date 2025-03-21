package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableAnySingle.java */
/* renamed from: g.a.y0.e.b.j */
/* loaded from: classes2.dex */
public final class C4740j<T> extends AbstractC4518k0<Boolean> implements InterfaceC4603b<Boolean> {

    /* renamed from: a */
    final AbstractC4519l<T> f17963a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f17964b;

    /* compiled from: FlowableAnySingle.java */
    /* renamed from: g.a.y0.e.b.j$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Boolean> f17965a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f17966b;

        /* renamed from: c */
        InterfaceC5823d f17967c;

        /* renamed from: d */
        boolean f17968d;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f17965a = interfaceC4524n0;
            this.f17966b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17967c.cancel();
            this.f17967c = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17967c == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17968d) {
                return;
            }
            this.f17968d = true;
            this.f17967c = EnumC5160j.CANCELLED;
            this.f17965a.onSuccess(false);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17968d) {
                C4476a.m17152b(th);
                return;
            }
            this.f17968d = true;
            this.f17967c = EnumC5160j.CANCELLED;
            this.f17965a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f17968d) {
                return;
            }
            try {
                if (this.f17966b.test(t)) {
                    this.f17968d = true;
                    this.f17967c.cancel();
                    this.f17967c = EnumC5160j.CANCELLED;
                    this.f17965a.onSuccess(true);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17967c.cancel();
                this.f17967c = EnumC5160j.CANCELLED;
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17967c, interfaceC5823d)) {
                this.f17967c = interfaceC5823d;
                this.f17965a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4740j(AbstractC4519l<T> abstractC4519l, InterfaceC4587r<? super T> interfaceC4587r) {
        this.f17963a = abstractC4519l;
        this.f17964b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f17963a.m17799a((InterfaceC4529q) new a(interfaceC4524n0, this.f17964b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<Boolean> mo18286b() {
        return C4476a.m17129a(new C4734i(this.f17963a, this.f17964b));
    }
}
