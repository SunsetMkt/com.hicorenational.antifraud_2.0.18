package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleObserveOn.java */
/* renamed from: g.a.y0.e.f.j0 */
/* loaded from: classes2.dex */
public final class C5080j0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19724a;

    /* renamed from: b */
    final AbstractC4516j0 f19725b;

    /* compiled from: SingleObserveOn.java */
    /* renamed from: g.a.y0.e.f.j0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final InterfaceC4524n0<? super T> actual;
        Throwable error;
        final AbstractC4516j0 scheduler;
        T value;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4524n0;
            this.scheduler = abstractC4516j0;
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
            this.error = th;
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.value = t;
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onSuccess(this.value);
            }
        }
    }

    public C5080j0(InterfaceC4530q0<T> interfaceC4530q0, AbstractC4516j0 abstractC4516j0) {
        this.f19724a = interfaceC4530q0;
        this.f19725b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19724a.mo17490a(new a(interfaceC4524n0, this.f19725b));
    }
}
