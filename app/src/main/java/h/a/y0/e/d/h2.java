package h.a.y0.e.d;

import h.a.y0.e.d.g2;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableReduceWithSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h2<T, R> extends h.a.k0<R> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<R> f11399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f11400c;

    public h2(h.a.g0<T> g0Var, Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        this.a = g0Var;
        this.f11399b = callable;
        this.f11400c = cVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        try {
            this.a.subscribe(new g2.a(n0Var, this.f11400c, h.a.y0.b.b.a(this.f11399b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
