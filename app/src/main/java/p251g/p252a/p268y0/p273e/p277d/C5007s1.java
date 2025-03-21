package p251g.p252a.p268y0.p273e.p277d;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableLastSingle.java */
/* renamed from: g.a.y0.e.d.s1 */
/* loaded from: classes2.dex */
public final class C5007s1<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19373a;

    /* renamed from: b */
    final T f19374b;

    /* compiled from: ObservableLastSingle.java */
    /* renamed from: g.a.y0.e.d.s1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19375a;

        /* renamed from: b */
        final T f19376b;

        /* renamed from: c */
        InterfaceC4552c f19377c;

        /* renamed from: d */
        T f19378d;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, T t) {
            this.f19375a = interfaceC4524n0;
            this.f19376b = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19377c.dispose();
            this.f19377c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19377c == EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19377c = EnumC4592d.DISPOSED;
            T t = this.f19378d;
            if (t != null) {
                this.f19378d = null;
                this.f19375a.onSuccess(t);
                return;
            }
            T t2 = this.f19376b;
            if (t2 != null) {
                this.f19375a.onSuccess(t2);
            } else {
                this.f19375a.onError(new NoSuchElementException());
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19377c = EnumC4592d.DISPOSED;
            this.f19378d = null;
            this.f19375a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19378d = t;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19377c, interfaceC4552c)) {
                this.f19377c = interfaceC4552c;
                this.f19375a.onSubscribe(this);
            }
        }
    }

    public C5007s1(InterfaceC4504g0<T> interfaceC4504g0, T t) {
        this.f19373a = interfaceC4504g0;
        this.f19374b = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19373a.subscribe(new a(interfaceC4524n0, this.f19374b));
    }
}
