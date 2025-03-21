package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCount.java */
/* renamed from: g.a.y0.e.b.a0 */
/* loaded from: classes2.dex */
public final class C4687a0<T> extends AbstractC4686a<T, Long> {

    /* compiled from: FlowableCount.java */
    /* renamed from: g.a.y0.e.b.a0$a */
    static final class a extends C5156f<Long> implements InterfaceC4529q<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;

        /* renamed from: s */
        InterfaceC5823d f17760s;

        a(InterfaceC5822c<? super Long> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f17760s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17760s, interfaceC5823d)) {
                this.f17760s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4687a0(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super Long> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
