package h.a.y0.e.c;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MaybeDefer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T> extends h.a.s<T> {
    final Callable<? extends h.a.y<? extends T>> a;

    public k(Callable<? extends h.a.y<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        try {
            ((h.a.y) h.a.y0.b.b.a(this.a.call(), "The maybeSupplier returned a null MaybeSource")).a(vVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, vVar);
        }
    }
}
