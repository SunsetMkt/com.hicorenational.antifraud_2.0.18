package h.a.y0.e.b;

import h.a.y0.e.b.r2;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableReduceWithSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s2<T, R> extends h.a.k0<R> {
    final j.d.b<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<R> f10968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f10969c;

    public s2(j.d.b<T> bVar, Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        this.a = bVar;
        this.f10968b = callable;
        this.f10969c = cVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        try {
            this.a.subscribe(new r2.a(n0Var, this.f10969c, h.a.y0.b.b.a(this.f10968b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
