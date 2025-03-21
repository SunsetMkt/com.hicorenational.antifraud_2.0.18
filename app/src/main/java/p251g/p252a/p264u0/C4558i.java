package p251g.p252a.p264u0;

import p251g.p252a.p263t0.InterfaceC4546f;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SubscriptionDisposable.java */
/* renamed from: g.a.u0.i */
/* loaded from: classes2.dex */
final class C4558i extends AbstractC4555f<InterfaceC5823d> {
    private static final long serialVersionUID = -707001650852963139L;

    C4558i(InterfaceC5823d interfaceC5823d) {
        super(interfaceC5823d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p251g.p252a.p264u0.AbstractC4555f
    public void onDisposed(@InterfaceC4546f InterfaceC5823d interfaceC5823d) {
        interfaceC5823d.cancel();
    }
}
