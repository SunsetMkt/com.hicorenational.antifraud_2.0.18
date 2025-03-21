package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleUnsubscribeOn.java */
/* renamed from: g.a.y0.e.f.s0 */
/* loaded from: classes2.dex */
public final class C5098s0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19786a;

    /* renamed from: b */
    final AbstractC4516j0 f19787b;

    /* compiled from: SingleUnsubscribeOn.java */
    /* renamed from: g.a.y0.e.f.s0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final InterfaceC4524n0<? super T> actual;

        /* renamed from: ds */
        InterfaceC4552c f19788ds;
        final AbstractC4516j0 scheduler;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4524n0;
            this.scheduler = abstractC4516j0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c andSet = getAndSet(EnumC4592d.DISPOSED);
            if (andSet != EnumC4592d.DISPOSED) {
                this.f19788ds = andSet;
                this.scheduler.mo17407a(this);
            }
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
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19788ds.dispose();
        }
    }

    public C5098s0(InterfaceC4530q0<T> interfaceC4530q0, AbstractC4516j0 abstractC4516j0) {
        this.f19786a = interfaceC4530q0;
        this.f19787b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19786a.mo17490a(new a(interfaceC4524n0, this.f19787b));
    }
}
