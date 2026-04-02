package h.a.y0.e.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CompletableDefer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends h.a.c {
    final Callable<? extends h.a.i> a;

    public g(Callable<? extends h.a.i> callable) {
        this.a = callable;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        try {
            ((h.a.i) h.a.y0.b.b.a(this.a.call(), "The completableSupplier returned a null CompletableSource")).a(fVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, fVar);
        }
    }
}
