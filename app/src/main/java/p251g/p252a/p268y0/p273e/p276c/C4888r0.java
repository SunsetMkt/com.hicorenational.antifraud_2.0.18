package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4604c;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: MaybeIsEmptySingle.java */
/* renamed from: g.a.y0.e.c.r0 */
/* loaded from: classes2.dex */
public final class C4888r0<T> extends AbstractC4518k0<Boolean> implements InterfaceC4607f<T>, InterfaceC4604c<Boolean> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18693a;

    /* compiled from: MaybeIsEmptySingle.java */
    /* renamed from: g.a.y0.e.c.r0$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Boolean> f18694a;

        /* renamed from: b */
        InterfaceC4552c f18695b;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
            this.f18694a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18695b.dispose();
            this.f18695b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18695b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18695b = EnumC4592d.DISPOSED;
            this.f18694a.onSuccess(true);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18695b = EnumC4592d.DISPOSED;
            this.f18694a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18695b, interfaceC4552c)) {
                this.f18695b = interfaceC4552c;
                this.f18694a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18695b = EnumC4592d.DISPOSED;
            this.f18694a.onSuccess(false);
        }
    }

    public C4888r0(InterfaceC4588y<T> interfaceC4588y) {
        this.f18693a = interfaceC4588y;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f18693a.mo18100a(new a(interfaceC4524n0));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4604c
    /* renamed from: c */
    public AbstractC4533s<Boolean> mo18287c() {
        return C4476a.m17131a(new C4885q0(this.f18693a));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18693a;
    }
}
