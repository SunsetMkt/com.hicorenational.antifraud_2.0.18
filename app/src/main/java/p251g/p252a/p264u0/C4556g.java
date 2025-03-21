package p251g.p252a.p264u0;

import p251g.p252a.p263t0.InterfaceC4546f;

/* compiled from: RunnableDisposable.java */
/* renamed from: g.a.u0.g */
/* loaded from: classes2.dex */
final class C4556g extends AbstractC4555f<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    C4556g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p251g.p252a.p264u0.AbstractC4555f
    public void onDisposed(@InterfaceC4546f Runnable runnable) {
        runnable.run();
    }
}
