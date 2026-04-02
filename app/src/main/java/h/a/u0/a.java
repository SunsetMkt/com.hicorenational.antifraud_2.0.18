package h.a.u0;

import h.a.y0.j.k;

/* JADX INFO: compiled from: ActionDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends f<h.a.x0.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    a(h.a.x0.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.u0.f
    public void onDisposed(@h.a.t0.f h.a.x0.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw k.c(th);
        }
    }
}
