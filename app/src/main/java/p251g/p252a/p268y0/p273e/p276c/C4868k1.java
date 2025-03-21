package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;
import p251g.p252a.p268y0.p283i.C5156f;
import p324i.p338d.InterfaceC5822c;

/* compiled from: MaybeToFlowable.java */
/* renamed from: g.a.y0.e.c.k1 */
/* loaded from: classes2.dex */
public final class C4868k1<T> extends AbstractC4519l<T> implements InterfaceC4607f<T> {

    /* renamed from: b */
    final InterfaceC4588y<T> f18640b;

    /* compiled from: MaybeToFlowable.java */
    /* renamed from: g.a.y0.e.c.k1$a */
    static final class a<T> extends C5156f<T> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d */
        InterfaceC4552c f18641d;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f18641d.dispose();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18641d, interfaceC4552c)) {
                this.f18641d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public C4868k1(InterfaceC4588y<T> interfaceC4588y) {
        this.f18640b = interfaceC4588y;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f18640b.mo18100a(new a(interfaceC5822c));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18640b;
    }
}
