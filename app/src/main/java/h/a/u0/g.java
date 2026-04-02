package h.a.u0;

/* JADX INFO: compiled from: RunnableDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends f<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.u0.f
    public void onDisposed(@h.a.t0.f Runnable runnable) {
        runnable.run();
    }
}
