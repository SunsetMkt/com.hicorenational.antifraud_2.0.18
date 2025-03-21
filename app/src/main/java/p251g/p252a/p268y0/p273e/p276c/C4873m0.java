package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4610i;

/* compiled from: MaybeFromSingle.java */
/* renamed from: g.a.y0.e.c.m0 */
/* loaded from: classes2.dex */
public final class C4873m0<T> extends AbstractC4533s<T> implements InterfaceC4610i<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f18652a;

    /* compiled from: MaybeFromSingle.java */
    /* renamed from: g.a.y0.e.c.m0$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18653a;

        /* renamed from: b */
        InterfaceC4552c f18654b;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18653a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18654b.dispose();
            this.f18654b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18654b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f18654b = EnumC4592d.DISPOSED;
            this.f18653a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18654b, interfaceC4552c)) {
                this.f18654b = interfaceC4552c;
                this.f18653a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18654b = EnumC4592d.DISPOSED;
            this.f18653a.onSuccess(t);
        }
    }

    public C4873m0(InterfaceC4530q0<T> interfaceC4530q0) {
        this.f18652a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18652a.mo17490a(new a(interfaceC4559v));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4610i
    public InterfaceC4530q0<T> source() {
        return this.f18652a;
    }
}
