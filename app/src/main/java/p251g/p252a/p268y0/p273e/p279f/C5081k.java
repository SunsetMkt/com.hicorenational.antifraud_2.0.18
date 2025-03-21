package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleDetach.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.f.k */
/* loaded from: classes2.dex */
public final class C5081k<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19726a;

    /* compiled from: SingleDetach.java */
    /* renamed from: g.a.y0.e.f.k$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        InterfaceC4524n0<? super T> f19727a;

        /* renamed from: b */
        InterfaceC4552c f19728b;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19727a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19727a = null;
            this.f19728b.dispose();
            this.f19728b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19728b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19728b = EnumC4592d.DISPOSED;
            InterfaceC4524n0<? super T> interfaceC4524n0 = this.f19727a;
            if (interfaceC4524n0 != null) {
                this.f19727a = null;
                interfaceC4524n0.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19728b, interfaceC4552c)) {
                this.f19728b = interfaceC4552c;
                this.f19727a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19728b = EnumC4592d.DISPOSED;
            InterfaceC4524n0<? super T> interfaceC4524n0 = this.f19727a;
            if (interfaceC4524n0 != null) {
                this.f19727a = null;
                interfaceC4524n0.onSuccess(t);
            }
        }
    }

    public C5081k(InterfaceC4530q0<T> interfaceC4530q0) {
        this.f19726a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19726a.mo17490a(new a(interfaceC4524n0));
    }
}
