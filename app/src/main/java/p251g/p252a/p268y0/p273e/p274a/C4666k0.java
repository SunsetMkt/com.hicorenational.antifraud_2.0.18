package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableTimer.java */
/* renamed from: g.a.y0.e.a.k0 */
/* loaded from: classes2.dex */
public final class C4666k0 extends AbstractC4474c {

    /* renamed from: a */
    final long f17715a;

    /* renamed from: b */
    final TimeUnit f17716b;

    /* renamed from: c */
    final AbstractC4516j0 f17717c;

    /* compiled from: CompletableTimer.java */
    /* renamed from: g.a.y0.e.a.k0$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final InterfaceC4491f actual;

        a(InterfaceC4491f interfaceC4491f) {
            this.actual = interfaceC4491f;
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
            this.actual.onComplete();
        }

        void setFuture(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this, interfaceC4552c);
        }
    }

    public C4666k0(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        this.f17715a = j2;
        this.f17716b = timeUnit;
        this.f17717c = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f);
        interfaceC4491f.onSubscribe(aVar);
        aVar.setFuture(this.f17717c.mo17409a(aVar, this.f17715a, this.f17716b));
    }
}
