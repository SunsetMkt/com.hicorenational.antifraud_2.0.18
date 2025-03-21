package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;

/* compiled from: CompletableFromCallable.java */
/* renamed from: g.a.y0.e.a.q */
/* loaded from: classes2.dex */
public final class C4676q extends AbstractC4474c {

    /* renamed from: a */
    final Callable<?> f17739a;

    public C4676q(Callable<?> callable) {
        this.f17739a = callable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        InterfaceC4552c m18189b = C4553d.m18189b();
        interfaceC4491f.onSubscribe(m18189b);
        try {
            this.f17739a.call();
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4491f.onComplete();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4491f.onError(th);
        }
    }
}
