package p251g.p252a.p264u0;

import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: ActionDisposable.java */
/* renamed from: g.a.u0.a */
/* loaded from: classes2.dex */
final class C4550a extends AbstractC4555f<InterfaceC4570a> {
    private static final long serialVersionUID = -8219729196779211169L;

    C4550a(InterfaceC4570a interfaceC4570a) {
        super(interfaceC4570a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p251g.p252a.p264u0.AbstractC4555f
    public void onDisposed(@InterfaceC4546f InterfaceC4570a interfaceC4570a) {
        try {
            interfaceC4570a.run();
        } catch (Throwable th) {
            throw C5171k.m18626c(th);
        }
    }
}
