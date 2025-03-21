package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSingleMaybe.java */
/* renamed from: g.a.y0.e.b.k3 */
/* loaded from: classes2.dex */
public final class C4750k3<T> extends AbstractC4533s<T> implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18002a;

    /* compiled from: FlowableSingleMaybe.java */
    /* renamed from: g.a.y0.e.b.k3$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18003a;

        /* renamed from: b */
        InterfaceC5823d f18004b;

        /* renamed from: c */
        boolean f18005c;

        /* renamed from: d */
        T f18006d;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18003a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18004b.cancel();
            this.f18004b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18004b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18005c) {
                return;
            }
            this.f18005c = true;
            this.f18004b = EnumC5160j.CANCELLED;
            T t = this.f18006d;
            this.f18006d = null;
            if (t == null) {
                this.f18003a.onComplete();
            } else {
                this.f18003a.onSuccess(t);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18005c) {
                C4476a.m17152b(th);
                return;
            }
            this.f18005c = true;
            this.f18004b = EnumC5160j.CANCELLED;
            this.f18003a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18005c) {
                return;
            }
            if (this.f18006d == null) {
                this.f18006d = t;
                return;
            }
            this.f18005c = true;
            this.f18004b.cancel();
            this.f18004b = EnumC5160j.CANCELLED;
            this.f18003a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18004b, interfaceC5823d)) {
                this.f18004b = interfaceC5823d;
                this.f18003a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4750k3(AbstractC4519l<T> abstractC4519l) {
        this.f18002a = abstractC4519l;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18002a.m17799a((InterfaceC4529q) new a(interfaceC4559v));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4744j3(this.f18002a, null));
    }
}
