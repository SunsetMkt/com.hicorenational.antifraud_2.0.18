package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableHide.java */
/* renamed from: g.a.y0.e.b.m1 */
/* loaded from: classes2.dex */
public final class C4760m1<T> extends AbstractC4686a<T, T> {

    /* compiled from: FlowableHide.java */
    /* renamed from: g.a.y0.e.b.m1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18062a;

        /* renamed from: b */
        InterfaceC5823d f18063b;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f18062a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18063b.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18062a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18062a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f18062a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18063b, interfaceC5823d)) {
                this.f18063b = interfaceC5823d;
                this.f18062a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18063b.request(j2);
        }
    }

    public C4760m1(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
