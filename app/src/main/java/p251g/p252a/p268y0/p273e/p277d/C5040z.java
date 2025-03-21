package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableCountSingle.java */
/* renamed from: g.a.y0.e.d.z */
/* loaded from: classes2.dex */
public final class C5040z<T> extends AbstractC4518k0<Long> implements InterfaceC4605d<Long> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19526a;

    /* compiled from: ObservableCountSingle.java */
    /* renamed from: g.a.y0.e.d.z$a */
    static final class a implements InterfaceC4514i0<Object>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Long> f19527a;

        /* renamed from: b */
        InterfaceC4552c f19528b;

        /* renamed from: c */
        long f19529c;

        a(InterfaceC4524n0<? super Long> interfaceC4524n0) {
            this.f19527a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19528b.dispose();
            this.f19528b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19528b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19528b = EnumC4592d.DISPOSED;
            this.f19527a.onSuccess(Long.valueOf(this.f19529c));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19528b = EnumC4592d.DISPOSED;
            this.f19527a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            this.f19529c++;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19528b, interfaceC4552c)) {
                this.f19528b = interfaceC4552c;
                this.f19527a.onSubscribe(this);
            }
        }
    }

    public C5040z(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f19526a = interfaceC4504g0;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<Long> mo18288a() {
        return C4476a.m17119a(new C5035y(this.f19526a));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super Long> interfaceC4524n0) {
        this.f19526a.subscribe(new a(interfaceC4524n0));
    }
}
