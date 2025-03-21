package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;

/* compiled from: CompletableFromAction.java */
/* renamed from: g.a.y0.e.a.p */
/* loaded from: classes2.dex */
public final class C4675p extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4570a f17738a;

    public C4675p(InterfaceC4570a interfaceC4570a) {
        this.f17738a = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        InterfaceC4552c m18189b = C4553d.m18189b();
        interfaceC4491f.onSubscribe(m18189b);
        try {
            this.f17738a.run();
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
