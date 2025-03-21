package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableObserveOn.java */
/* renamed from: g.a.y0.e.a.e0 */
/* loaded from: classes2.dex */
public final class C4654e0 extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17653a;

    /* renamed from: b */
    final AbstractC4516j0 f17654b;

    /* compiled from: CompletableObserveOn.java */
    /* renamed from: g.a.y0.e.a.e0$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final InterfaceC4491f actual;
        Throwable error;
        final AbstractC4516j0 scheduler;

        a(InterfaceC4491f interfaceC4491f, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4491f;
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

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.error = th;
            EnumC4592d.replace(this, this.scheduler.mo17407a(this));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th == null) {
                this.actual.onComplete();
            } else {
                this.error = null;
                this.actual.onError(th);
            }
        }
    }

    public C4654e0(InterfaceC4513i interfaceC4513i, AbstractC4516j0 abstractC4516j0) {
        this.f17653a = interfaceC4513i;
        this.f17654b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17653a.mo17074a(new a(interfaceC4491f, this.f17654b));
    }
}
