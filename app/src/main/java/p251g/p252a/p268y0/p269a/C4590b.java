package p251g.p252a.p268y0.p269a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4575f;

/* compiled from: CancellableDisposable.java */
/* renamed from: g.a.y0.a.b */
/* loaded from: classes2.dex */
public final class C4590b extends AtomicReference<InterfaceC4575f> implements InterfaceC4552c {
    private static final long serialVersionUID = 5718521705281392066L;

    public C4590b(InterfaceC4575f interfaceC4575f) {
        super(interfaceC4575f);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        InterfaceC4575f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            C4561b.m18199b(e2);
            C4476a.m17152b(e2);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == null;
    }
}
