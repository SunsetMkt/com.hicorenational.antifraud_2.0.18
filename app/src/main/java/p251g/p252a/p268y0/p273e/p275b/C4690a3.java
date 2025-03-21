package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p256d1.AbstractC4481c;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p275b.C4819w2;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRetryWhen.java */
/* renamed from: g.a.y0.e.b.a3 */
/* loaded from: classes2.dex */
public final class C4690a3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super AbstractC4519l<Throwable>, ? extends InterfaceC5821b<?>> f17768c;

    /* compiled from: FlowableRetryWhen.java */
    /* renamed from: g.a.y0.e.b.a3$a */
    static final class a<T> extends C4819w2.c<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4481c<Throwable> abstractC4481c, InterfaceC5823d interfaceC5823d) {
            super(interfaceC5822c, abstractC4481c, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f25900receiver.cancel();
            ((C4819w2.c) this).actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            again(th);
        }
    }

    public C4690a3(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super AbstractC4519l<Throwable>, ? extends InterfaceC5821b<?>> interfaceC4584o) {
        super(abstractC4519l);
        this.f17768c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        AbstractC4481c<T> m17229X = C4485g.m17260m(8).m17229X();
        try {
            InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f17768c.apply(m17229X), "handler returned a null Publisher");
            C4819w2.b bVar = new C4819w2.b(this.f17759b);
            a aVar = new a(c4509e, m17229X, bVar);
            bVar.subscriber = aVar;
            interfaceC5822c.onSubscribe(aVar);
            interfaceC5821b.subscribe(bVar);
            bVar.onNext(0);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
