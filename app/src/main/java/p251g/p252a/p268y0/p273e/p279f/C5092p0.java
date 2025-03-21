package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleTimer.java */
/* renamed from: g.a.y0.e.f.p0 */
/* loaded from: classes2.dex */
public final class C5092p0 extends AbstractC4518k0<Long> {

    /* renamed from: a */
    final long f19765a;

    /* renamed from: b */
    final TimeUnit f19766b;

    /* renamed from: c */
    final AbstractC4516j0 f19767c;

    /* compiled from: SingleTimer.java */
    /* renamed from: g.a.y0.e.f.p0$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final InterfaceC4524n0<? super Long> actual;

        a(InterfaceC4524n0<? super Long> interfaceC4524n0) {
            this.actual = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.actual.onSuccess(0L);
        }

        void setFuture(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this, interfaceC4552c);
        }
    }

    public C5092p0(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f19765a = j2;
        this.f19766b = timeUnit;
        this.f19767c = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Long> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0);
        interfaceC4524n0.onSubscribe(aVar);
        aVar.setFuture(this.f19767c.mo17409a(aVar, this.f19765a, this.f19766b));
    }
}
