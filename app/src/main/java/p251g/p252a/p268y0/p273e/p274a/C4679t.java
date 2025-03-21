package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;

/* compiled from: CompletableFromRunnable.java */
/* renamed from: g.a.y0.e.a.t */
/* loaded from: classes2.dex */
public final class C4679t extends AbstractC4474c {

    /* renamed from: a */
    final Runnable f17745a;

    public C4679t(Runnable runnable) {
        this.f17745a = runnable;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        InterfaceC4552c m18189b = C4553d.m18189b();
        interfaceC4491f.onSubscribe(m18189b);
        try {
            this.f17745a.run();
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
