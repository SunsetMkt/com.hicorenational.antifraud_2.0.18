package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: ObservableTimer.java */
/* renamed from: g.a.y0.e.d.t3 */
/* loaded from: classes2.dex */
public final class C5014t3 extends AbstractC4469b0<Long> {

    /* renamed from: a */
    final AbstractC4516j0 f19409a;

    /* renamed from: b */
    final long f19410b;

    /* renamed from: c */
    final TimeUnit f19411c;

    /* compiled from: ObservableTimer.java */
    /* renamed from: g.a.y0.e.d.t3$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final InterfaceC4514i0<? super Long> actual;

        a(InterfaceC4514i0<? super Long> interfaceC4514i0) {
            this.actual = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == EnumC4592d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.actual.onNext(0L);
            lazySet(EnumC4593e.INSTANCE);
            this.actual.onComplete();
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.trySet(this, interfaceC4552c);
        }
    }

    public C5014t3(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f19410b = j2;
        this.f19411c = timeUnit;
        this.f19409a = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super Long> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.setResource(this.f19409a.mo17409a(aVar, this.f19410b, this.f19411c));
    }
}
