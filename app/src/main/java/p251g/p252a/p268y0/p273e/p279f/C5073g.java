package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.C4618a0;

/* compiled from: SingleDelayWithCompletable.java */
/* renamed from: g.a.y0.e.f.g */
/* loaded from: classes2.dex */
public final class C5073g<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19708a;

    /* renamed from: b */
    final InterfaceC4513i f19709b;

    /* compiled from: SingleDelayWithCompletable.java */
    /* renamed from: g.a.y0.e.f.g$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
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

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.source.mo17490a(new C4618a0(this, this.actual));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5073g(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4513i interfaceC4513i) {
        this.f19708a = interfaceC4530q0;
        this.f19709b = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19709b.mo17074a(new a(interfaceC4524n0, this.f19708a));
    }
}
