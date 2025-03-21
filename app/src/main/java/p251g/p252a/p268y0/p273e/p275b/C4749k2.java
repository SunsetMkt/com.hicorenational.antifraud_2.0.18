package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.AbstractC5148s;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableOnErrorReturn.java */
/* renamed from: g.a.y0.e.b.k2 */
/* loaded from: classes2.dex */
public final class C4749k2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super Throwable, ? extends T> f18001c;

    /* compiled from: FlowableOnErrorReturn.java */
    /* renamed from: g.a.y0.e.b.k2$a */
    static final class a<T> extends AbstractC5148s<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final InterfaceC4584o<? super Throwable, ? extends T> valueSupplier;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
            super(interfaceC5822c);
            this.valueSupplier = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            try {
                complete(C4601b.m18284a((Object) this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.actual.onError(new C4560a(th, th2));
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }
    }

    public C4749k2(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
        super(abstractC4519l);
        this.f18001c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18001c));
    }
}
