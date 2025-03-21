package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleHide.java */
/* renamed from: g.a.y0.e.f.d0 */
/* loaded from: classes2.dex */
public final class C5068d0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19686a;

    /* compiled from: SingleHide.java */
    /* renamed from: g.a.y0.e.f.d0$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19687a;

        /* renamed from: b */
        InterfaceC4552c f19688b;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19687a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19688b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19688b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19687a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19688b, interfaceC4552c)) {
                this.f19688b = interfaceC4552c;
                this.f19687a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19687a.onSuccess(t);
        }
    }

    public C5068d0(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        this.f19686a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19686a.mo17490a(new a(interfaceC4524n0));
    }
}
