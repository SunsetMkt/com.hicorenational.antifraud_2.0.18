package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends h.a.c {
    final Throwable a;

    public n(Throwable th) {
        this.a = th;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        h.a.y0.a.e.error(this.a, fVar);
    }
}
