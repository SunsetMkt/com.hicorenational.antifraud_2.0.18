package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: MaybeCount.java */
/* renamed from: g.a.y0.e.c.i */
/* loaded from: classes2.dex */
public final class C4860i<T> extends AbstractC4518k0<Long> implements InterfaceC4607f<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18623a;

    /* compiled from: MaybeCount.java */
    /* renamed from: g.a.y0.e.c.i$a */
    static final class a implements InterfaceC4559v<Object>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Long> f18624a;

        /* renamed from: b */
        InterfaceC4552c f18625b;

        a(InterfaceC4524n0<? super Long> interfaceC4524n0) {
            this.f18624a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18625b.dispose();
            this.f18625b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18625b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18625b = EnumC4592d.DISPOSED;
            this.f18624a.onSuccess(0L);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18625b = EnumC4592d.DISPOSED;
            this.f18624a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18625b, interfaceC4552c)) {
                this.f18625b = interfaceC4552c;
                this.f18624a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(Object obj) {
            this.f18625b = EnumC4592d.DISPOSED;
            this.f18624a.onSuccess(1L);
        }
    }

    public C4860i(InterfaceC4588y<T> interfaceC4588y) {
        this.f18623a = interfaceC4588y;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Long> interfaceC4524n0) {
        this.f18623a.mo18100a(new a(interfaceC4524n0));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18623a;
    }
}
