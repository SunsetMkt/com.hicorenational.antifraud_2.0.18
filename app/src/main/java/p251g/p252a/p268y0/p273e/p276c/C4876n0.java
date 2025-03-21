package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeHide.java */
/* renamed from: g.a.y0.e.c.n0 */
/* loaded from: classes2.dex */
public final class C4876n0<T> extends AbstractC4836a<T, T> {

    /* compiled from: MaybeHide.java */
    /* renamed from: g.a.y0.e.c.n0$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18660a;

        /* renamed from: b */
        InterfaceC4552c f18661b;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18660a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18661b.dispose();
            this.f18661b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18661b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18660a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18660a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18661b, interfaceC4552c)) {
                this.f18661b = interfaceC4552c;
                this.f18660a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18660a.onSuccess(t);
        }
    }

    public C4876n0(InterfaceC4588y<T> interfaceC4588y) {
        super(interfaceC4588y);
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v));
    }
}
