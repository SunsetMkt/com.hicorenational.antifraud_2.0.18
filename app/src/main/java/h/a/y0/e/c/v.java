package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T> extends h.a.s<T> {
    final Throwable a;

    public v(Throwable th) {
        this.a = th;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        vVar.onSubscribe(h.a.u0.d.a());
        vVar.onError(this.a);
    }
}
