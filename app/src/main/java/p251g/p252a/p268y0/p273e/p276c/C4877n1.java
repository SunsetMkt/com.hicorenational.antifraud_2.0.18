package p251g.p252a.p268y0.p273e.p276c;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: MaybeToSingle.java */
/* renamed from: g.a.y0.e.c.n1 */
/* loaded from: classes2.dex */
public final class C4877n1<T> extends AbstractC4518k0<T> implements InterfaceC4607f<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18662a;

    /* renamed from: b */
    final T f18663b;

    /* compiled from: MaybeToSingle.java */
    /* renamed from: g.a.y0.e.c.n1$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f18664a;

        /* renamed from: b */
        final T f18665b;

        /* renamed from: c */
        InterfaceC4552c f18666c;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, T t) {
            this.f18664a = interfaceC4524n0;
            this.f18665b = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18666c.dispose();
            this.f18666c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18666c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18666c = EnumC4592d.DISPOSED;
            T t = this.f18665b;
            if (t != null) {
                this.f18664a.onSuccess(t);
            } else {
                this.f18664a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18666c = EnumC4592d.DISPOSED;
            this.f18664a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18666c, interfaceC4552c)) {
                this.f18666c = interfaceC4552c;
                this.f18664a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18666c = EnumC4592d.DISPOSED;
            this.f18664a.onSuccess(t);
        }
    }

    public C4877n1(InterfaceC4588y<T> interfaceC4588y, T t) {
        this.f18662a = interfaceC4588y;
        this.f18663b = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f18662a.mo18100a(new a(interfaceC4524n0, this.f18663b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18662a;
    }
}
