package h.a;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements i {
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(i... iVarArr) {
        h.a.y0.b.b.a(iVarArr, "sources is null");
        return iVarArr.length == 0 ? q() : iVarArr.length == 1 ? g(iVarArr[0]) : h.a.c1.a.a(new h.a.y0.e.a.a(iVarArr, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c b(i... iVarArr) {
        h.a.y0.b.b.a(iVarArr, "sources is null");
        return iVarArr.length == 0 ? q() : iVarArr.length == 1 ? g(iVarArr[0]) : h.a.c1.a.a(new h.a.y0.e.a.d(iVarArr));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c c(j.d.b<? extends i> bVar) {
        return a(bVar, 2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c d(Callable<?> callable) {
        h.a.y0.b.b.a(callable, "callable is null");
        return h.a.c1.a.a(new h.a.y0.e.a.q(callable));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c e(j.d.b<? extends i> bVar) {
        return a(bVar, Integer.MAX_VALUE, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c f(i iVar) {
        h.a.y0.b.b.a(iVar, "source is null");
        if (iVar instanceof c) {
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return h.a.c1.a.a(new h.a.y0.e.a.v(iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c g(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "run is null");
        return h.a.c1.a.a(new h.a.y0.e.a.p(aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c q() {
        return h.a.c1.a.a(h.a.y0.e.a.m.a);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c r() {
        return h.a.c1.a.a(h.a.y0.e.a.d0.a);
    }

    protected abstract void b(f fVar);

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c h() {
        return a(h.a.y0.b.a.b());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final c i() {
        return h.a.c1.a.a(new h.a.y0.e.a.i(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c j() {
        return d(n().A());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c k() {
        return d(n().C());
    }

    @h.a.t0.h("none")
    public final h.a.u0.c l() {
        h.a.y0.d.o oVar = new h.a.y0.d.o();
        a((f) oVar);
        return oVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<Void> m() {
        h.a.a1.n<Void> nVar = new h.a.a1.n<>();
        a((f) nVar);
        return nVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> l<T> n() {
        return this instanceof h.a.y0.c.b ? ((h.a.y0.c.b) this).b() : h.a.c1.a.a(new h.a.y0.e.a.l0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> s<T> o() {
        return this instanceof h.a.y0.c.c ? ((h.a.y0.c.c) this).c() : h.a.c1.a.a(new h.a.y0.e.c.j0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> b0<T> p() {
        return this instanceof h.a.y0.c.d ? ((h.a.y0.c.d) this).a() : h.a.c1.a.a(new h.a.y0.e.a.m0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c c(Callable<? extends Throwable> callable) {
        h.a.y0.b.b.a(callable, "errorSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.a.o(callable));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static c e(long j2, TimeUnit timeUnit) {
        return c(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> c d(j.d.b<T> bVar) {
        h.a.y0.b.b.a(bVar, "publisher is null");
        return h.a.c1.a.a(new h.a.y0.e.a.s(bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c g(i iVar) {
        h.a.y0.b.b.a(iVar, "source is null");
        if (iVar instanceof c) {
            return h.a.c1.a.a((c) iVar);
        }
        return h.a.c1.a.a(new h.a.y0.e.a.v(iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Throwable e() {
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((f) hVar);
        return hVar.b();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c c(i... iVarArr) {
        h.a.y0.b.b.a(iVarArr, "sources is null");
        if (iVarArr.length == 0) {
            return q();
        }
        if (iVarArr.length == 1) {
            return g(iVarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.a.z(iVarArr));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c d(i... iVarArr) {
        h.a.y0.b.b.a(iVarArr, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.a.a0(iVarArr));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c f(j.d.b<? extends i> bVar) {
        return a(bVar, Integer.MAX_VALUE, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c e(h.a.x0.a aVar) {
        h.a.x0.g<? super h.a.u0.c> gVarD = h.a.y0.b.a.d();
        h.a.x0.g<? super Throwable> gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return a(gVarD, gVarD2, aVar2, aVar, aVar2, aVar2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c f() {
        return h.a.c1.a.a(new h.a.y0.e.a.b(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(Iterable<? extends i> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.a.a(null, iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c b(Iterable<? extends i> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.a.e(iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c d(Iterable<? extends i> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.a.b0(iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c e(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return b(iVar, this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c f(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.d.j jVar = new h.a.y0.d.j(aVar);
        a((f) jVar);
        return jVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c g() {
        return h.a.c1.a.a(new h.a.y0.e.a.w(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(j.d.b<? extends i> bVar, int i2) {
        h.a.y0.b.b.a(bVar, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.a.c(bVar, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c b(Callable<? extends i> callable) {
        h.a.y0.b.b.a(callable, "completableSupplier");
        return h.a.c1.a.a(new h.a.y0.e.a.g(callable));
    }

    @h.a.t0.h("none")
    public final void d() {
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((f) hVar);
        hVar.a();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c c(Iterable<? extends i> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.a.c0(iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> c b(g0<T> g0Var) {
        h.a.y0.b.b.a(g0Var, "observable is null");
        return h.a.c1.a.a(new h.a.y0.e.a.r(g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(g gVar) {
        h.a.y0.b.b.a(gVar, "source is null");
        return h.a.c1.a.a(new h.a.y0.e.a.f(gVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c c(j.d.b<? extends i> bVar, int i2) {
        return a(bVar, i2, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c d(h.a.x0.a aVar) {
        h.a.x0.g<? super h.a.u0.c> gVarD = h.a.y0.b.a.d();
        h.a.x0.g<? super Throwable> gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return a(gVarD, gVarD2, aVar2, aVar2, aVar2, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> c b(q0<T> q0Var) {
        h.a.y0.b.b.a(q0Var, "single is null");
        return h.a.c1.a.a(new h.a.y0.e.a.u(q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static c c(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.k0(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c d(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return c(this, iVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(Throwable th) {
        h.a.y0.b.b.a(th, "error is null");
        return h.a.c1.a.a(new h.a.y0.e.a.n(th));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static c b(j.d.b<? extends i> bVar, int i2) {
        return a(bVar, i2, false);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final c d(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a(), null);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(Future<?> future) {
        h.a.y0.b.b.a(future, "future is null");
        return g(h.a.y0.b.a.a(future));
    }

    private static NullPointerException b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return b(this, iVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> U d(h.a.x0.o<? super c, U> oVar) {
        try {
            return (U) ((h.a.x0.o) h.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static c a(Runnable runnable) {
        h.a.y0.b.b.a(runnable, "run is null");
        return h.a.c1.a.a(new h.a.y0.e.a.t(runnable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(i iVar) {
        return c(iVar);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final c c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Throwable b(long j2, TimeUnit timeUnit) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((f) hVar);
        return hVar.b(j2, timeUnit);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(h.a.x0.a aVar) {
        h.a.x0.g<? super h.a.u0.c> gVarD = h.a.y0.b.a.d();
        h.a.x0.g<? super Throwable> gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return a(gVarD, gVarD2, aVar, aVar2, aVar2, aVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    private static c a(j.d.b<? extends i> bVar, int i2, boolean z) {
        h.a.y0.b.b.a(bVar, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new h.a.y0.e.a.y(bVar, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(h.a.x0.g<? super h.a.u0.c> gVar) {
        h.a.x0.g<? super Throwable> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a(gVar, gVarD, aVar, aVar, aVar, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(h.a.x0.o<? super l<Throwable>, ? extends j.d.b<?>> oVar) {
        return d(n().u(oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E extends f> E c(E e2) {
        a((f) e2);
        return e2;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <R> c a(Callable<R> callable, h.a.x0.o<? super R, ? extends i> oVar, h.a.x0.g<? super R> gVar) {
        return a((Callable) callable, (h.a.x0.o) oVar, (h.a.x0.g) gVar, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.g<? super Throwable> gVar) {
        h.a.y0.b.b.a(gVar, "onEvent is null");
        return h.a.c1.a.a(new h.a.y0.e.a.l(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c c(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.j(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <R> c a(Callable<R> callable, h.a.x0.o<? super R, ? extends i> oVar, h.a.x0.g<? super R> gVar, boolean z) {
        h.a.y0.b.b.a(callable, "resourceSupplier is null");
        h.a.y0.b.b.a(oVar, "completableFunction is null");
        h.a.y0.b.b.a(gVar, "disposer is null");
        return h.a.c1.a.a(new h.a.y0.e.a.o0(callable, oVar, gVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return h.a.c1.a.a(new h.a.y0.e.a.k(this, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.o<? super l<Object>, ? extends j.d.b<?>> oVar) {
        return d(n().s(oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return a(this, iVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(long j2) {
        return d(n().e(j2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.r<? super Throwable> rVar) {
        return d(n().e(rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> b0<T> a(g0<T> g0Var) {
        h.a.y0.b.b.a(g0Var, "next is null");
        return h.a.c1.a.a(new h.a.y0.e.d.f0(g0Var, p()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> l<T> b(j.d.b<T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return n().j((j.d.b) bVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> l<T> a(j.d.b<T> bVar) {
        h.a.y0.b.b.a(bVar, "next is null");
        return h.a.c1.a.a(new h.a.y0.e.b.h0(bVar, n()));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c b(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.i0(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> k0<T> a(q0<T> q0Var) {
        h.a.y0.b.b.a(q0Var, "next is null");
        return h.a.c1.a.a(new h.a.y0.e.f.g(q0Var, this));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, null);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    private c b(long j2, TimeUnit timeUnit, j0 j0Var, i iVar) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.j0(this, j2, timeUnit, j0Var, iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> s<T> a(y<T> yVar) {
        h.a.y0.b.b.a(yVar, "next is null");
        return h.a.c1.a.a(new h.a.y0.e.c.o(yVar, this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final <R> R a(@h.a.t0.f d<? extends R> dVar) {
        return (R) ((d) h.a.y0.b.b.a(dVar, "converter is null")).a(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final boolean a(long j2, TimeUnit timeUnit) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((f) hVar);
        return hVar.a(j2, timeUnit);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(j jVar) {
        return g(((j) h.a.y0.b.b.a(jVar, "transformer is null")).a(this));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.h(this, j2, timeUnit, j0Var, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.g<? super Throwable> gVar) {
        h.a.x0.g<? super h.a.u0.c> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a(gVarD, gVar, aVar, aVar, aVar, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    private c a(h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2, h.a.x0.a aVar3, h.a.x0.a aVar4) {
        h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.b.b.a(aVar2, "onTerminate is null");
        h.a.y0.b.b.a(aVar3, "onAfterTerminate is null");
        h.a.y0.b.b.a(aVar4, "onDispose is null");
        return h.a.c1.a.a(new h.a.y0.e.a.g0(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.a aVar) {
        h.a.x0.g<? super h.a.u0.c> gVarD = h.a.y0.b.a.d();
        h.a.x0.g<? super Throwable> gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return a(gVarD, gVarD2, aVar2, aVar2, aVar, aVar2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h hVar) {
        h.a.y0.b.b.a(hVar, "onLift is null");
        return h.a.c1.a.a(new h.a.y0.e.a.x(this, hVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c a(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.a.e0(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.r<? super Throwable> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.a.f0(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.o<? super Throwable, ? extends i> oVar) {
        h.a.y0.b.b.a(oVar, "errorMapper is null");
        return h.a.c1.a.a(new h.a.y0.e.a.h0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(long j2) {
        return d(n().d(j2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.e eVar) {
        return d(n().a(eVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c a(h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return d(n().b(dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> b0<T> a(b0<T> b0Var) {
        h.a.y0.b.b.a(b0Var, "other is null");
        return b0Var.c((g0) p());
    }

    @Override // h.a.i
    @h.a.t0.h("none")
    public final void a(f fVar) {
        h.a.y0.b.b.a(fVar, "s is null");
        try {
            b(h.a.c1.a.a(this, fVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
            throw b(th);
        }
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.a aVar, h.a.x0.g<? super Throwable> gVar) {
        h.a.y0.b.b.a(gVar, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.d.j jVar = new h.a.y0.d.j(gVar, aVar);
        a((f) jVar);
        return jVar;
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final c a(long j2, TimeUnit timeUnit, i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return b(j2, timeUnit, h.a.e1.a.a(), iVar);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final c a(long j2, TimeUnit timeUnit, j0 j0Var, i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return b(j2, timeUnit, j0Var, iVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> k0<T> a(Callable<? extends T> callable) {
        h.a.y0.b.b.a(callable, "completionValueSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.a.n0(this, callable, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T> k0<T> a(T t) {
        h.a.y0.b.b.a((Object) t, "completionValue is null");
        return h.a.c1.a.a(new h.a.y0.e.a.n0(this, null, t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<Void> a(boolean z) {
        h.a.a1.n<Void> nVar = new h.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((f) nVar);
        return nVar;
    }
}
