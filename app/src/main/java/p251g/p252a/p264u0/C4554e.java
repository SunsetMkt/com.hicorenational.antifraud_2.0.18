package p251g.p252a.p264u0;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureDisposable.java */
/* renamed from: g.a.u0.e */
/* loaded from: classes2.dex */
final class C4554e extends AtomicReference<Future<?>> implements InterfaceC4552c {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    C4554e(Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
