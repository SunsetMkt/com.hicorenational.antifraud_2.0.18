package h.a;

import h.a.y0.e.b.a1;
import h.a.y0.e.b.l3;
import h.a.y0.e.d.z2;
import h.a.y0.e.f.s0;
import h.a.y0.e.f.t0;
import h.a.y0.e.f.u0;
import h.a.y0.e.f.v0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k0<T> implements q0<T> {
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(Iterable<? extends q0<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.f.a(null, iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends q0<? extends T>> iterable) {
        return c((j.d.b) l.f((Iterable) iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends q0<? extends T>> bVar) {
        return a(bVar, 2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> d(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "publisher is null");
        return h.a.c1.a.a(new h.a.y0.e.f.b0(bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(j.d.b<? extends q0<? extends T>> bVar) {
        h.a.y0.b.b.a(bVar, "sources is null");
        return h.a.c1.a.a(new a1(bVar, h.a.y0.e.f.e0.b(), false, Integer.MAX_VALUE, l.Q()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> f(q0<? extends q0<? extends T>> q0Var) {
        h.a.y0.b.b.a(q0Var, "source is null");
        return h.a.c1.a.a(new h.a.y0.e.f.v(q0Var, h.a.y0.b.a.e()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> g(q0<T> q0Var) {
        h.a.y0.b.b.a(q0Var, "onSubscribe is null");
        if (q0Var instanceof k0) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return h.a.c1.a.a(new h.a.y0.e.f.c0(q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> h(q0<T> q0Var) {
        h.a.y0.b.b.a(q0Var, "source is null");
        return q0Var instanceof k0 ? h.a.c1.a.a((k0) q0Var) : h.a.c1.a.a(new h.a.y0.e.f.c0(q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> q() {
        return h.a.c1.a.a(h.a.y0.e.f.i0.a);
    }

    protected abstract void b(@h.a.t0.f n0<? super T> n0Var);

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> i(h.a.x0.o<? super Throwable, ? extends q0<? extends T>> oVar) {
        h.a.y0.b.b.a(oVar, "resumeFunctionInCaseOfError is null");
        return h.a.c1.a.a(new h.a.y0.e.f.l0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> j(h.a.x0.o<Throwable, ? extends T> oVar) {
        h.a.y0.b.b.a(oVar, "resumeFunction is null");
        return h.a.c1.a.a(new h.a.y0.e.f.k0(this, oVar, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> k(h.a.x0.o<? super l<Object>, ? extends j.d.b<?>> oVar) {
        return m().s(oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> l(h.a.x0.o<? super l<Throwable>, ? extends j.d.b<?>> oVar) {
        return a((l) m().u(oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> R m(h.a.x0.o<? super k0<T>, R> oVar) {
        try {
            return (R) ((h.a.x0.o) h.a.y0.b.b.a(oVar, "convert is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Future<T> n() {
        return (Future) c(new h.a.y0.d.s());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> o() {
        return this instanceof h.a.y0.c.c ? ((h.a.y0.c.c) this).c() : h.a.c1.a.a(new h.a.y0.e.c.m0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> p() {
        return this instanceof h.a.y0.c.d ? ((h.a.y0.c.d) this).a() : h.a.c1.a.a(new h.a.y0.e.f.r0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends q0<? extends T>> g0Var) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.d.v(g0Var, h.a.y0.e.f.e0.c(), 2, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> c(Callable<? extends T> callable) {
        h.a.y0.b.b.a(callable, "callable is null");
        return h.a.c1.a.a(new h.a.y0.e.f.a0(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> k() {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        a((n0) nVar);
        return nVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c l() {
        return h.a.c1.a.a(new h.a.y0.e.a.u(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(q0<? extends T>... q0VarArr) {
        if (q0VarArr.length == 0) {
            return b((Callable<? extends Throwable>) h.a.y0.e.f.e0.a());
        }
        if (q0VarArr.length == 1) {
            return h(q0VarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.f.a(q0VarArr, null));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static k0<Long> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> e() {
        return h.a.c1.a.a(new h.a.y0.e.f.b(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> f() {
        return h.a.c1.a.a(new h.a.y0.e.f.d0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> i() {
        return a((l) m().C());
    }

    @h.a.t0.h("none")
    public final h.a.u0.c j() {
        return a(h.a.y0.b.a.d(), h.a.y0.b.a.f10450f);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T>... q0VarArr) {
        return h.a.c1.a.a(new h.a.y0.e.b.w(l.b((Object[]) q0VarArr), h.a.y0.e.f.e0.b(), 2, h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> c(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "observableSource is null");
        return h.a.c1.a.a(new z2(g0Var, null));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static k0<Long> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.f.p0(j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> e(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return m().i((h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> f(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.x(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> m() {
        if (this instanceof h.a.y0.c.b) {
            return ((h.a.y0.c.b) this).b();
        }
        return h.a.c1.a.a(new h.a.y0.e.f.q0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> b(Callable<? extends Throwable> callable) {
        h.a.y0.b.b.a(callable, "errorSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.f.u(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c e(h.a.x0.g<? super T> gVar) {
        return a(gVar, h.a.y0.b.a.f10450f);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> g(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.y(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> h(h.a.x0.o<? super T, ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.h0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> c(T t) {
        h.a.y0.b.b.a((Object) t, "value is null");
        return h.a.c1.a.a(new h.a.y0.e.f.f0(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E> k0<T> e(q0<? extends E> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return b((j.d.b) new h.a.y0.e.f.q0(q0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3}));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> d(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onSuccess is null");
        return h.a.c1.a.a(new h.a.y0.e.f.s(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final k0<T> g() {
        return h.a.c1.a.a(new h.a.y0.e.f.k(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> h() {
        return m().A();
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends q0<? extends T>> bVar, int i2) {
        h.a.y0.b.b.a(bVar, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.z(bVar, h.a.y0.e.f.e0.b(), i2, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends q0<? extends T>> iterable) {
        return e(l.f((Iterable) iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2}));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> d(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return p().j((h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T d() {
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((n0) hVar);
        return (T) hVar.a();
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        return c((j.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2}));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3, q0<? extends T> q0Var4) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        return e(l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3, q0Var4}));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<T> c(q0<U> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.f.j(this, q0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> d(q0<? extends T> q0Var) {
        return c(this, q0Var);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        return c((j.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3}));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> c(h.a.x0.g<? super h.a.u0.c> gVar) {
        h.a.y0.b.b.a(gVar, "onSubscribe is null");
        return h.a.c1.a.a(new h.a.y0.e.f.r(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> b(q0<? extends T> q0Var, q0<? extends T> q0Var2) {
        h.a.y0.b.b.a(q0Var, "first is null");
        h.a.y0.b.b.a(q0Var2, "second is null");
        return h.a.c1.a.a(new h.a.y0.e.f.t(q0Var, q0Var2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> c(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onDispose is null");
        return h.a.c1.a.a(new h.a.y0.e.f.o(this, aVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(q0<? extends T> q0Var, q0<? extends T> q0Var2, q0<? extends T> q0Var3, q0<? extends T> q0Var4) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        return c((j.d.b) l.b((Object[]) new q0[]{q0Var, q0Var2, q0Var3, q0Var4}));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> c(h.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.z(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(q0<? extends T> q0Var) {
        return a(this, q0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final k0<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E extends n0<? super T>> E c(E e2) {
        a((n0) e2);
        return e2;
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a((g0) b0.q(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final k0<T> c(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a(), (q0) null);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return h.a.c1.a.a(new h.a.y0.e.f.n(this, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, (q0) null);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(o0<T> o0Var) {
        h.a.y0.b.b.a(o0Var, "source is null");
        return h.a.c1.a.a(new h.a.y0.e.f.d(o0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    @h.a.t0.e
    public final k0<T> c(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new s0(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(h.a.x0.g<? super Throwable> gVar) {
        h.a.y0.b.b.a(gVar, "onError is null");
        return h.a.c1.a.a(new h.a.y0.e.f.p(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(Callable<? extends q0<? extends T>> callable) {
        h.a.y0.b.b.a(callable, "singleSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.f.e(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.o<? super T, ? extends i> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.w(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(Throwable th) {
        h.a.y0.b.b.a(th, "error is null");
        return b((Callable<? extends Throwable>) h.a.y0.b.a.b(th));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(T t) {
        h.a.y0.b.b.a((Object) t, "value is null");
        return h.a.c1.a.a(new h.a.y0.e.f.k0(this, null, t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(Future<? extends T> future) {
        return a(l.a((Future) future));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return a(l.a(future, j2, timeUnit));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(long j2) {
        return a((l) m().e(j2));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> k0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(l.a(future, j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(h.a.x0.r<? super Throwable> rVar) {
        return a((l) m().e(rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> k0<T> a(Future<? extends T> future, j0 j0Var) {
        return a(l.a((Future) future, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c b(h.a.x0.b<? super T, ? super Throwable> bVar) {
        h.a.y0.b.b.a(bVar, "onCallback is null");
        h.a.y0.d.d dVar = new h.a.y0.d.d(bVar);
        a((n0) dVar);
        return dVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, U> k0<T> a(Callable<U> callable, h.a.x0.o<? super U, ? extends q0<? extends T>> oVar, h.a.x0.g<? super U> gVar) {
        return a((Callable) callable, (h.a.x0.o) oVar, (h.a.x0.g) gVar, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, U> k0<T> a(Callable<U> callable, h.a.x0.o<? super U, ? extends q0<? extends T>> oVar, h.a.x0.g<? super U> gVar, boolean z) {
        h.a.y0.b.b.a(callable, "resourceSupplier is null");
        h.a.y0.b.b.a(oVar, "singleFunction is null");
        h.a.y0.b.b.a(gVar, "disposer is null");
        return h.a.c1.a.a(new t0(callable, oVar, gVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> b(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.f.m0(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return b((j.d.b) new h.a.y0.e.a.l0(iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> k0<R> a(Iterable<? extends q0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new v0(iterable, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E> k0<T> b(j.d.b<E> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.f.n0(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), q0Var, q0Var2);
    }

    private k0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, q0<? extends T> q0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.f.o0(this, j2, timeUnit, j0Var, q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), q0Var, q0Var2, q0Var3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), q0Var, q0Var2, q0Var3, q0Var4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        h.a.y0.b.b.a(q0Var5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        h.a.y0.b.b.a(q0Var5, "source5 is null");
        h.a.y0.b.b.a(q0Var6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        h.a.y0.b.b.a(q0Var5, "source5 is null");
        h.a.y0.b.b.a(q0Var6, "source6 is null");
        h.a.y0.b.b.a(q0Var7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, q0<? extends T8> q0Var8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        h.a.y0.b.b.a(q0Var5, "source5 is null");
        h.a.y0.b.b.a(q0Var6, "source6 is null");
        h.a.y0.b.b.a(q0Var7, "source7 is null");
        h.a.y0.b.b.a(q0Var8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7, q0Var8);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k0<R> a(q0<? extends T1> q0Var, q0<? extends T2> q0Var2, q0<? extends T3> q0Var3, q0<? extends T4> q0Var4, q0<? extends T5> q0Var5, q0<? extends T6> q0Var6, q0<? extends T7> q0Var7, q0<? extends T8> q0Var8, q0<? extends T9> q0Var9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(q0Var, "source1 is null");
        h.a.y0.b.b.a(q0Var2, "source2 is null");
        h.a.y0.b.b.a(q0Var3, "source3 is null");
        h.a.y0.b.b.a(q0Var4, "source4 is null");
        h.a.y0.b.b.a(q0Var5, "source5 is null");
        h.a.y0.b.b.a(q0Var6, "source6 is null");
        h.a.y0.b.b.a(q0Var7, "source7 is null");
        h.a.y0.b.b.a(q0Var8, "source8 is null");
        h.a.y0.b.b.a(q0Var9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), q0Var, q0Var2, q0Var3, q0Var4, q0Var5, q0Var6, q0Var7, q0Var8, q0Var9);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> k0<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, q0<? extends T>... q0VarArr) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(q0VarArr, "sources is null");
        if (q0VarArr.length == 0) {
            return a((Throwable) new NoSuchElementException());
        }
        return h.a.c1.a.a(new u0(q0VarArr, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(q0<? extends T> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return a(this, q0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final <R> R a(@h.a.t0.f l0<T, ? extends R> l0Var) {
        return (R) ((l0) h.a.y0.b.b.a(l0Var, "converter is null")).a(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(r0<? super T, ? extends R> r0Var) {
        return h(((r0) h.a.y0.b.b.a(r0Var, "transformer is null")).a(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<U> a(Class<? extends U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return (k0<U>) h(h.a.y0.b.a.a((Class) cls));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final k0<T> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), false);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    @h.a.t0.e
    public final k0<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), z);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    @h.a.t0.e
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.f.f(this, j2, timeUnit, j0Var, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(i iVar) {
        h.a.y0.b.b.a(iVar, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.f.g(this, iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<T> a(g0<U> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.f.h(this, g0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<T> a(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.f.i(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "doAfterSuccess is null");
        return h.a.c1.a.a(new h.a.y0.e.f.l(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onAfterTerminate is null");
        return h.a.c1.a.a(new h.a.y0.e.f.m(this, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(h.a.x0.b<? super T, ? super Throwable> bVar) {
        h.a.y0.b.b.a(bVar, "onEvent is null");
        return h.a.c1.a.a(new h.a.y0.e.f.q(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.c.y(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.f.v(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(p0<? extends R, ? super T> p0Var) {
        h.a.y0.b.b.a(p0Var, "onLift is null");
        return h.a.c1.a.a(new h.a.y0.e.f.g0(this, p0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> a(Object obj) {
        return a(obj, h.a.y0.b.b.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> a(Object obj, h.a.x0.d<Object, Object> dVar) {
        h.a.y0.b.b.a(obj, "value is null");
        h.a.y0.b.b.a(dVar, "comparer is null");
        return h.a.c1.a.a(new h.a.y0.e.f.c(this, obj, dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> a(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.f.j0(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(k0<? extends T> k0Var) {
        h.a.y0.b.b.a(k0Var, "resumeSingleInCaseOfError is null");
        return i(h.a.y0.b.a.c(k0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(long j2) {
        return m().d(j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.e eVar) {
        return m().a(eVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return a((l) m().b(dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        h.a.y0.b.b.a(gVar, "onSuccess is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.d.k kVar = new h.a.y0.d.k(gVar, gVar2);
        a((n0) kVar);
        return kVar;
    }

    @Override // h.a.q0
    @h.a.t0.h("none")
    public final void a(n0<? super T> n0Var) {
        h.a.y0.b.b.a(n0Var, "subscriber is null");
        n0<? super T> n0VarA = h.a.c1.a.a(this, n0Var);
        h.a.y0.b.b.a(n0VarA, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b((n0) n0VarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final k0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, q0<? extends T> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return b(j2, timeUnit, j0Var, q0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final k0<T> a(long j2, TimeUnit timeUnit, q0<? extends T> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return b(j2, timeUnit, h.a.e1.a.a(), q0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> k0<R> a(q0<U> q0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a(this, q0Var, cVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> a(boolean z) {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((n0) nVar);
        return nVar;
    }

    private static <T> k0<T> a(l<T> lVar) {
        return h.a.c1.a.a(new l3(lVar, null));
    }
}
