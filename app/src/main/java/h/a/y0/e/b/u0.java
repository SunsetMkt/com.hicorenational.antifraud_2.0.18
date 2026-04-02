package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends Throwable> f11008b;

    public u0(Callable<? extends Throwable> callable) {
        this.f11008b = callable;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        try {
            th = (Throwable) h.a.y0.b.b.a(this.f11008b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            h.a.v0.b.b(th);
        }
        h.a.y0.i.g.error(th, cVar);
    }
}
