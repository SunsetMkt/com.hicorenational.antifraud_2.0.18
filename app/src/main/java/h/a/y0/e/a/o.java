package h.a.y0.e.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CompletableErrorSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends h.a.c {
    final Callable<? extends Throwable> a;

    public o(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        try {
            th = (Throwable) h.a.y0.b.b.a(this.a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            h.a.v0.b.b(th);
        }
        h.a.y0.a.e.error(th, fVar);
    }
}
