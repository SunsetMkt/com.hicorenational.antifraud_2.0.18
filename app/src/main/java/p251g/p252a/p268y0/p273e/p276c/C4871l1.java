package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;
import p251g.p252a.p268y0.p272d.C4630l;

/* compiled from: MaybeToObservable.java */
/* renamed from: g.a.y0.e.c.l1 */
/* loaded from: classes2.dex */
public final class C4871l1<T> extends AbstractC4469b0<T> implements InterfaceC4607f<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18646a;

    /* compiled from: MaybeToObservable.java */
    /* renamed from: g.a.y0.e.c.l1$a */
    static final class a<T> extends C4630l<T> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d */
        InterfaceC4552c f18647d;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            super(interfaceC4514i0);
        }

        @Override // p251g.p252a.p268y0.p272d.C4630l, p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            super.dispose();
            this.f18647d.dispose();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            complete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            error(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18647d, interfaceC4552c)) {
                this.f18647d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public C4871l1(InterfaceC4588y<T> interfaceC4588y) {
        this.f18646a = interfaceC4588y;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18646a.mo18100a(new a(interfaceC4514i0));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18646a;
    }
}
