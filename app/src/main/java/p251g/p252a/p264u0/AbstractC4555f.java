package p251g.p252a.p264u0;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ReferenceDisposable.java */
/* renamed from: g.a.u0.f */
/* loaded from: classes2.dex */
abstract class AbstractC4555f<T> extends AtomicReference<T> implements InterfaceC4552c {
    private static final long serialVersionUID = 6537757548749041217L;

    AbstractC4555f(T t) {
        super(C4601b.m18284a((Object) t, "value is null"));
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return get() == null;
    }

    protected abstract void onDisposed(@InterfaceC4546f T t);
}
