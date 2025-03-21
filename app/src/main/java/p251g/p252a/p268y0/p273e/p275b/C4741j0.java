package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5168h;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDetach.java */
/* renamed from: g.a.y0.e.b.j0 */
/* loaded from: classes2.dex */
public final class C4741j0<T> extends AbstractC4686a<T, T> {

    /* compiled from: FlowableDetach.java */
    /* renamed from: g.a.y0.e.b.j0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        InterfaceC5822c<? super T> f17969a;

        /* renamed from: b */
        InterfaceC5823d f17970b;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f17969a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            InterfaceC5823d interfaceC5823d = this.f17970b;
            this.f17970b = EnumC5168h.INSTANCE;
            this.f17969a = EnumC5168h.asSubscriber();
            interfaceC5823d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            InterfaceC5822c<? super T> interfaceC5822c = this.f17969a;
            this.f17970b = EnumC5168h.INSTANCE;
            this.f17969a = EnumC5168h.asSubscriber();
            interfaceC5822c.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            InterfaceC5822c<? super T> interfaceC5822c = this.f17969a;
            this.f17970b = EnumC5168h.INSTANCE;
            this.f17969a = EnumC5168h.asSubscriber();
            interfaceC5822c.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f17969a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17970b, interfaceC5823d)) {
                this.f17970b = interfaceC5823d;
                this.f17969a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17970b.request(j2);
        }
    }

    public C4741j0(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
