package h.a.y0.e.c;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MaybeErrorCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T> extends h.a.s<T> {
    final Callable<? extends Throwable> a;

    public w(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        vVar.onSubscribe(h.a.u0.d.a());
        try {
            th = (Throwable) h.a.y0.b.b.a(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            h.a.v0.b.b(th);
        }
        vVar.onError(th);
    }
}
