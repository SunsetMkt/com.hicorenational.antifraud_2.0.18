package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.C4618a0;

/* compiled from: SingleDelayWithSingle.java */
/* renamed from: g.a.y0.e.f.j */
/* loaded from: classes2.dex */
public final class C5079j<T, U> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19722a;

    /* renamed from: b */
    final InterfaceC4530q0<U> f19723b;

    /* compiled from: SingleDelayWithSingle.java */
    /* renamed from: g.a.y0.e.f.j$a */
    static final class a<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<U>, InterfaceC4552c {
        private static final long serialVersionUID = -8565274649390031272L;
        final InterfaceC4524n0<? super T> actual;
        final InterfaceC4530q0<T> source;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4530q0<T> interfaceC4530q0) {
            this.actual = interfaceC4524n0;
            this.source = interfaceC4530q0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.set(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(U u) {
            this.source.mo17490a(new C4618a0(this, this.actual));
        }
    }

    public C5079j(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4530q0<U> interfaceC4530q02) {
        this.f19722a = interfaceC4530q0;
        this.f19723b = interfaceC4530q02;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19723b.mo17490a(new a(interfaceC4524n0, this.f19722a));
    }
}
