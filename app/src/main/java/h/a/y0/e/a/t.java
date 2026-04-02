package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableFromRunnable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends h.a.c {
    final Runnable a;

    public t(Runnable runnable) {
        this.a = runnable;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        fVar.onSubscribe(cVarB);
        try {
            this.a.run();
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onComplete();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onError(th);
        }
    }
}
