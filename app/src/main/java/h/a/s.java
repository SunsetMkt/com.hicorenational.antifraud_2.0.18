package h.a;

import h.a.y0.e.c.a1;
import h.a.y0.e.c.b1;
import h.a.y0.e.c.c1;
import h.a.y0.e.c.d1;
import h.a.y0.e.c.e1;
import h.a.y0.e.c.f1;
import h.a.y0.e.c.g1;
import h.a.y0.e.c.h1;
import h.a.y0.e.c.i1;
import h.a.y0.e.c.j1;
import h.a.y0.e.c.k1;
import h.a.y0.e.c.l1;
import h.a.y0.e.c.m1;
import h.a.y0.e.c.n1;
import h.a.y0.e.c.o1;
import h.a.y0.e.c.p1;
import h.a.y0.e.c.q1;
import h.a.y0.e.c.r1;
import h.a.y0.e.c.s0;
import h.a.y0.e.c.s1;
import h.a.y0.e.c.t0;
import h.a.y0.e.c.u0;
import h.a.y0.e.c.v0;
import h.a.y0.e.c.w0;
import h.a.y0.e.c.x0;
import h.a.y0.e.c.y0;
import h.a.y0.e.c.z0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Maybe.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s<T> implements y<T> {
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Iterable<? extends y<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.c.b(null, iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends y<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.c.g(iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(y<? extends T>... yVarArr) {
        return yVarArr.length == 0 ? l.R() : yVarArr.length == 1 ? h.a.c1.a.a(new k1(yVarArr[0])) : h.a.c1.a.a(new h.a.y0.e.c.f(yVarArr));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(y<? extends T>... yVarArr) {
        return l.b((Object[]) yVarArr).c(m1.instance());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(j.d.b<? extends y<? extends T>> bVar) {
        return a(bVar, 2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(j.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).b(m1.instance());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> g(j.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).c(m1.instance());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> h(j.d.b<? extends y<? extends T>> bVar) {
        return b(bVar, Integer.MAX_VALUE);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> i(y<? extends y<? extends T>> yVar) {
        h.a.y0.b.b.a(yVar, "source is null");
        return h.a.c1.a.a(new h.a.y0.e.c.g0(yVar, h.a.y0.b.a.e()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> j(y<T> yVar) {
        if (yVar instanceof s) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        h.a.y0.b.b.a(yVar, "onSubscribe is null");
        return h.a.c1.a.a(new o1(yVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> k(y<T> yVar) {
        if (yVar instanceof s) {
            return h.a.c1.a.a((s) yVar);
        }
        h.a.y0.b.b.a(yVar, "onSubscribe is null");
        return h.a.c1.a.a(new o1(yVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> r() {
        return h.a.c1.a.a((s) h.a.y0.e.c.t.a);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> s() {
        return h.a.c1.a.a(w0.a);
    }

    protected abstract void b(v<? super T> vVar);

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> l(h.a.x0.o<? super Throwable, ? extends T> oVar) {
        h.a.y0.b.b.a(oVar, "valueSupplier is null");
        return h.a.c1.a.a(new a1(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> m(h.a.x0.o<? super l<Object>, ? extends j.d.b<?>> oVar) {
        return o().s(oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> n(h.a.x0.o<? super l<Throwable>, ? extends j.d.b<?>> oVar) {
        return o().u(oVar).F();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> R o(h.a.x0.o<? super s<T>, R> oVar) {
        try {
            return (R) ((h.a.x0.o) h.a.y0.b.b.a(oVar, "convert is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> p() {
        return this instanceof h.a.y0.c.d ? ((h.a.y0.c.d) this).a() : h.a.c1.a.a(new l1(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> q() {
        return h.a.c1.a.a(new n1(this, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(Iterable<? extends y<? extends T>> iterable) {
        return l.f((Iterable) iterable).c(m1.instance());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> e(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "run is null");
        return h.a.c1.a.a((s) new h.a.y0.e.c.h0(aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> f(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return h.a.c1.a.a((s) new s0(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> g(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.f0(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> h(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.b0(this, oVar));
    }

    @h.a.t0.h("none")
    public final h.a.u0.c m() {
        return a(h.a.y0.b.a.d(), h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> n() {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        a((v) nVar);
        return nVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(y<? extends T>... yVarArr) {
        if (yVarArr.length == 0) {
            return r();
        }
        if (yVarArr.length == 1) {
            return k(yVarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.c.b(yVarArr, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        return b(yVar, yVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(y<? extends T> yVar, y<? extends T> yVar2) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        return f(yVar, yVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> i(j.d.b<? extends y<? extends T>> bVar) {
        return l.q(bVar).b(m1.instance(), true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> l() {
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.b());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(Iterable<? extends y<? extends T>> iterable) {
        return h(l.f((Iterable) iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(y<? extends T>... yVarArr) {
        if (yVarArr.length == 0) {
            return l.R();
        }
        return l.b((Object[]) yVarArr).a(m1.instance(), true, yVarArr.length);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c g() {
        return h.a.c1.a.a(new h.a.y0.e.c.p0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> h() {
        return h.a.c1.a.a(new h.a.y0.e.c.r0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> i(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.c0(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> o() {
        if (this instanceof h.a.y0.c.b) {
            return ((h.a.y0.c.b) this).b();
        }
        return h.a.c1.a.a(new k1(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(y<? extends T>... yVarArr) {
        h.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return l.R();
        }
        if (yVarArr.length == 1) {
            return h.a.c1.a.a(new k1(yVarArr[0]));
        }
        return h.a.c1.a.a(new v0(yVarArr));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> g(y<U> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return h.a.c1.a.a(new f1(this, yVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> h(y<U> yVar) {
        h.a.y0.b.b.a(yVar, "timeoutIndicator is null");
        return h.a.c1.a.a(new h1(this, yVar, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> j(h.a.x0.o<? super T, ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new u0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> k(h.a.x0.o<? super Throwable, ? extends y<? extends T>> oVar) {
        h.a.y0.b.b.a(oVar, "resumeFunction is null");
        return h.a.c1.a.a(new z0(this, oVar, true));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(y<? extends T>... yVarArr) {
        h.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return l.R();
        }
        if (yVarArr.length == 1) {
            return h.a.c1.a.a(new k1(yVarArr[0]));
        }
        return h.a.c1.a.a(new h.a.y0.e.c.e(yVarArr));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends y<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return l.f((Iterable) iterable).b(m1.instance());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static s<Long> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> i() {
        return b(h.a.y0.b.a.b());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static s<Long> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new j1(Math.max(0L, j2), timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(Iterable<? extends y<? extends T>> iterable) {
        return l.f((Iterable) iterable).b(m1.instance(), true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> j() {
        return h.a.c1.a.a(new h.a.y0.e.c.p(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> k() {
        return a(i.q2.t.m0.f12222b);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        return b(yVar, yVar2, yVar3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> c(Callable<? extends T> callable) {
        h.a.y0.b.b.a(callable, "callable is null");
        return h.a.c1.a.a((s) new h.a.y0.e.c.i0(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> f(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.e0(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        return e(yVar, yVar2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> d() {
        return h.a.c1.a.a(new h.a.y0.e.c.c(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> f() {
        return h.a.c1.a.a(new h.a.y0.e.c.n0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> e(y<? extends T> yVar, y<? extends T> yVar2) {
        return a(yVar, yVar2, h.a.y0.b.b.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> d(h.a.x0.a aVar) {
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVarD3 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new b1(this, gVarD, gVarD2, gVarD3, aVar2, aVar2, (h.a.x0.a) h.a.y0.b.b.a(aVar, "onDispose is null")));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> f(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return h.a.c1.a.a(new d1(this, yVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        return b(yVar, yVar2, yVar3, yVar4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> b(Callable<? extends Throwable> callable) {
        h.a.y0.b.b.a(callable, "errorSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.c.w(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Long> e() {
        return h.a.c1.a.a(new h.a.y0.e.c.i(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        return f(yVar, yVar2, yVar3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> e(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return o().i((h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> b(q0<T> q0Var) {
        h.a.y0.b.b.a(q0Var, "singleSource is null");
        return h.a.c1.a.a(new h.a.y0.e.c.m0(q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> e(T t) {
        h.a.y0.b.b.a((Object) t, "defaultValue is null");
        return h.a.c1.a.a(new n1(this, t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(j.d.b<? extends y<? extends T>> bVar, int i2) {
        h.a.y0.b.b.a(bVar, "source is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new h.a.y0.e.b.a1(bVar, m1.instance(), false, i2, l.Q()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> e(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "next is null");
        return h.a.c1.a.a(new z0(this, h.a.y0.b.a.c(yVar), false));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends y<? extends T>> bVar, int i2) {
        h.a.y0.b.b.a(bVar, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.z(bVar, m1.instance(), i2, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        return f(yVar, yVar2, yVar3, yVar4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> d(h.a.x0.g<? super T> gVar) {
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVar2 = (h.a.x0.g) h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new b1(this, gVarD, gVar2, gVarD2, aVar, aVar, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c e(h.a.x0.g<? super T> gVar) {
        return a(gVar, h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        return e(yVar, yVar2, yVar3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(w<T> wVar) {
        h.a.y0.b.b.a(wVar, "onSubscribe is null");
        return h.a.c1.a.a(new h.a.y0.e.c.j(wVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Callable<? extends y<? extends T>> callable) {
        h.a.y0.b.b.a(callable, "maybeSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.c.k(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T c() {
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((v) hVar);
        return (T) hVar.a();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> d(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return p().j((h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(y<? extends T> yVar, y<? extends T> yVar2, y<? extends T> yVar3, y<? extends T> yVar4) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        return e(yVar, yVar2, yVar3, yVar4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> d(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "next is null");
        return k(h.a.y0.b.a.c(yVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Throwable th) {
        h.a.y0.b.b.a(th, "exception is null");
        return h.a.c1.a.a(new h.a.y0.e.c.v(th));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> c(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return f((y) f(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> d(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return l(h.a.y0.b.a.c(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(i iVar) {
        h.a.y0.b.b.a(iVar, "completableSource is null");
        return h.a.c1.a.a(new h.a.y0.e.c.j0(iVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> c(h.a.x0.a aVar) {
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVarD3 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = (h.a.x0.a) h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.x0.a aVar3 = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new b1(this, gVarD, gVarD2, gVarD3, aVar2, aVar3, aVar3));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> d(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "timeoutIndicator is null");
        return h.a.c1.a.a(new i1(this, bVar, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Future<? extends T> future) {
        h.a.y0.b.b.a(future, "future is null");
        return h.a.c1.a.a(new h.a.y0.e.c.k0(future, 0L, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return b(this, yVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        h.a.y0.b.b.a(future, "future is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        return h.a.c1.a.a(new h.a.y0.e.c.k0(future, j2, timeUnit));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> b(Object obj) {
        h.a.y0.b.b.a(obj, "item is null");
        return h.a.c1.a.a(new h.a.y0.e.c.h(this, obj));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> b(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "subscriptionIndicator is null");
        return h.a.c1.a.a(new h.a.y0.e.c.n(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> s<T> a(Runnable runnable) {
        h.a.y0.b.b.a(runnable, "run is null");
        return h.a.c1.a.a((s) new h.a.y0.e.c.l0(runnable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> c(h.a.x0.g<? super h.a.u0.c> gVar) {
        h.a.x0.g gVar2 = (h.a.x0.g) h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new b1(this, gVar2, gVarD, gVarD2, aVar, aVar, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final s<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(y<? extends T> yVar, y<? extends T> yVar2, h.a.x0.d<? super T, ? super T> dVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(dVar, "isEqual is null");
        return h.a.c1.a.a(new h.a.y0.e.c.u(yVar, yVar2, dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b((j.d.b) l.q(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> b(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return h.a.c1.a.a(new h.a.y0.e.c.r(this, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> b(h.a.x0.g<? super Throwable> gVar) {
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVar2 = (h.a.x0.g) h.a.y0.b.b.a(gVar, "onError is null");
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new b1(this, gVarD, gVarD2, gVar2, aVar, aVar, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(h.a.x0.o<? super T, ? extends i> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.a0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> s<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends y<? extends T>> oVar, h.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (h.a.x0.o) oVar, (h.a.x0.g) gVar, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> s<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends y<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        h.a.y0.b.b.a(callable, "resourceSupplier is null");
        h.a.y0.b.b.a(oVar, "sourceSupplier is null");
        h.a.y0.b.b.a(gVar, "disposer is null");
        return h.a.c1.a.a(new q1(callable, oVar, gVar, z));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return c(this, yVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> c(h.a.x0.r<? super Throwable> rVar) {
        return a(i.q2.t.m0.f12222b, rVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> b(h.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.g0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E extends v<? super T>> E c(E e2) {
        a((v) e2);
        return e2;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> s<R> a(Iterable<? extends y<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new s1(iterable, oVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> c(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new g1(this, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<U> b(Class<U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return a((h.a.x0.r) h.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final s<T> c(long j2, TimeUnit timeUnit) {
        return c(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), yVar, yVar2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> b(h.a.x0.r<? super Throwable> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new y0(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return h(d(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> c(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new p1(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> b(long j2) {
        return a(j2, h.a.y0.b.a.b());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), yVar, yVar2, yVar3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> b(h.a.x0.e eVar) {
        h.a.y0.b.b.a(eVar, "stop is null");
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.a(eVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> b(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new c1(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), yVar, yVar2, yVar3, yVar4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        h.a.y0.b.b.a(yVar5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), yVar, yVar2, yVar3, yVar4, yVar5);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        h.a.y0.b.b.a(yVar5, "source5 is null");
        h.a.y0.b.b.a(yVar6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        h.a.y0.b.b.a(yVar5, "source5 is null");
        h.a.y0.b.b.a(yVar6, "source6 is null");
        h.a.y0.b.b.a(yVar7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, y<? extends T8> yVar8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        h.a.y0.b.b.a(yVar5, "source5 is null");
        h.a.y0.b.b.a(yVar6, "source6 is null");
        h.a.y0.b.b.a(yVar7, "source7 is null");
        h.a.y0.b.b.a(yVar8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7, yVar8);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> s<R> a(y<? extends T1> yVar, y<? extends T2> yVar2, y<? extends T3> yVar3, y<? extends T4> yVar4, y<? extends T5> yVar5, y<? extends T6> yVar6, y<? extends T7> yVar7, y<? extends T8> yVar8, y<? extends T9> yVar9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(yVar, "source1 is null");
        h.a.y0.b.b.a(yVar2, "source2 is null");
        h.a.y0.b.b.a(yVar3, "source3 is null");
        h.a.y0.b.b.a(yVar4, "source4 is null");
        h.a.y0.b.b.a(yVar5, "source5 is null");
        h.a.y0.b.b.a(yVar6, "source6 is null");
        h.a.y0.b.b.a(yVar7, "source7 is null");
        h.a.y0.b.b.a(yVar8, "source8 is null");
        h.a.y0.b.b.a(yVar9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), yVar, yVar2, yVar3, yVar4, yVar5, yVar6, yVar7, yVar8, yVar9);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> s<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, y<? extends T>... yVarArr) {
        h.a.y0.b.b.a(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return r();
        }
        h.a.y0.b.b.a(oVar, "zipper is null");
        return h.a.c1.a.a(new r1(yVarArr, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return a(this, yVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final <R> R a(@h.a.t0.f t<T, ? extends R> tVar) {
        return (R) ((t) h.a.y0.b.b.a(tVar, "converter is null")).a(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T a(T t) {
        h.a.y0.b.b.a((Object) t, "defaultValue is null");
        h.a.y0.d.h hVar = new h.a.y0.d.h();
        a((v) hVar);
        return (T) hVar.a(t);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<U> a(Class<? extends U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return (s<U>) j(h.a.y0.b.a.a((Class) cls));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> a(z<? super T, ? extends R> zVar) {
        return k(((z) h.a.y0.b.b.a(zVar, "transformer is null")).a(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> a(h.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new h.a.y0.e.c.g0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final s<T> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.c.l(this, Math.max(0L, j2), timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> s<T> a(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "delayIndicator is null");
        return h.a.c1.a.a(new h.a.y0.e.c.m(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "doAfterSuccess is null");
        return h.a.c1.a.a(new h.a.y0.e.c.q(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.a aVar) {
        return h.a.c1.a.a(new b1(this, h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.f10447c, (h.a.x0.a) h.a.y0.b.b.a(aVar, "onAfterTerminate is null"), h.a.y0.b.a.f10447c));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.b<? super T, ? super Throwable> bVar) {
        h.a.y0.b.b.a(bVar, "onEvent is null");
        return h.a.c1.a.a(new h.a.y0.e.c.s(this, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.c.x(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> a(h.a.x0.o<? super T, ? extends y<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends y<? extends R>> oVar2, Callable<? extends y<? extends R>> callable) {
        h.a.y0.b.b.a(oVar, "onSuccessMapper is null");
        h.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        h.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.c.d0(this, oVar, oVar2, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> s<R> a(h.a.x0.o<? super T, ? extends y<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return h.a.c1.a.a(new h.a.y0.e.c.z(this, oVar, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> s<R> a(x<? extends R, ? super T> xVar) {
        h.a.y0.b.b.a(xVar, "onLift is null");
        return h.a.c1.a.a(new t0(this, xVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> a(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new x0(this, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(long j2) {
        return o().d(j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.e eVar) {
        return o().a(eVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        return o().b(dVar).F();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(long j2, h.a.x0.r<? super Throwable> rVar) {
        return o().a(j2, rVar).F();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        return a(gVar, gVar2, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        h.a.y0.b.b.a(gVar, "onSuccess is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        return (h.a.u0.c) c(new h.a.y0.e.c.d(gVar, gVar2, aVar));
    }

    @Override // h.a.y
    @h.a.t0.h("none")
    public final void a(v<? super T> vVar) {
        h.a.y0.b.b.a(vVar, "observer is null");
        v<? super T> vVarA = h.a.c1.a.a(this, vVar);
        h.a.y0.b.b.a(vVarA, "observer returned by the RxJavaPlugins hook is null");
        try {
            b((v) vVarA);
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
    @h.a.t0.h("none")
    @h.a.t0.e
    public final k0<T> a(q0<? extends T> q0Var) {
        h.a.y0.b.b.a(q0Var, "other is null");
        return h.a.c1.a.a(new e1(this, q0Var));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final s<T> a(long j2, TimeUnit timeUnit, y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return a(j2, timeUnit, h.a.e1.a.a(), yVar);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final s<T> a(long j2, TimeUnit timeUnit, j0 j0Var, y<? extends T> yVar) {
        h.a.y0.b.b.a(yVar, "fallback is null");
        return a(d(j2, timeUnit, j0Var), yVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> a(y<U> yVar, y<? extends T> yVar2) {
        h.a.y0.b.b.a(yVar, "timeoutIndicator is null");
        h.a.y0.b.b.a(yVar2, "fallback is null");
        return h.a.c1.a.a(new h1(this, yVar, yVar2));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> s<T> a(j.d.b<U> bVar, y<? extends T> yVar) {
        h.a.y0.b.b.a(bVar, "timeoutIndicator is null");
        h.a.y0.b.b.a(yVar, "fallback is null");
        return h.a.c1.a.a(new i1(this, bVar, yVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> s<R> a(y<? extends U> yVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(yVar, "other is null");
        return a(this, yVar, cVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> a(boolean z) {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        if (z) {
            nVar.cancel();
        }
        a((v) nVar);
        return nVar;
    }
}
