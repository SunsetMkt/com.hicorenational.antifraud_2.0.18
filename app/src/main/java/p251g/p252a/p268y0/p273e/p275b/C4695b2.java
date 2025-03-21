package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p282h.AbstractC5148s;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableMaterialize.java */
/* renamed from: g.a.y0.e.b.b2 */
/* loaded from: classes2.dex */
public final class C4695b2<T> extends AbstractC4686a<T, C4453a0<T>> {

    /* compiled from: FlowableMaterialize.java */
    /* renamed from: g.a.y0.e.b.b2$a */
    static final class a<T> extends AbstractC5148s<T, C4453a0<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        a(InterfaceC5822c<? super C4453a0<T>> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            complete(C4453a0.m16437f());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            complete(C4453a0.m16436a(th));
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(C4453a0.m16435a(t));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5148s
        public void onDrop(C4453a0<T> c4453a0) {
            if (c4453a0.m16441d()) {
                C4476a.m17152b(c4453a0.m16438a());
            }
        }
    }

    public C4695b2(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super C4453a0<T>> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
