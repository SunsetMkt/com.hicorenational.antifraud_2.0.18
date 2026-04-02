package h.a.u0;

/* JADX INFO: compiled from: SubscriptionDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
final class i extends f<j.d.d> {
    private static final long serialVersionUID = -707001650852963139L;

    i(j.d.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.u0.f
    public void onDisposed(@h.a.t0.f j.d.d dVar) {
        dVar.cancel();
    }
}
