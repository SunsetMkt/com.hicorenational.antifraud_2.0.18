package p286h.p294k2.p301n.p302a;

import p286h.InterfaceC5610t0;
import p286h.p294k2.C5363i;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContinuationImpl.kt */
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.k2.n.a.j */
/* loaded from: classes2.dex */
public abstract class AbstractC5407j extends AbstractC5398a {
    public AbstractC5407j(@InterfaceC5817e InterfaceC5358d<Object> interfaceC5358d) {
        super(interfaceC5358d);
        if (interfaceC5358d != null) {
            if (!(interfaceC5358d.getContext() == C5363i.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        return C5363i.INSTANCE;
    }
}
