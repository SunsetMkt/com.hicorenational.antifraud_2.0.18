package h.a;

import h.a.y0.e.b.a3;
import h.a.y0.e.b.a4;
import h.a.y0.e.b.b1;
import h.a.y0.e.b.b2;
import h.a.y0.e.b.b3;
import h.a.y0.e.b.b4;
import h.a.y0.e.b.c1;
import h.a.y0.e.b.c2;
import h.a.y0.e.b.c3;
import h.a.y0.e.b.c4;
import h.a.y0.e.b.d1;
import h.a.y0.e.b.d2;
import h.a.y0.e.b.d3;
import h.a.y0.e.b.d4;
import h.a.y0.e.b.e1;
import h.a.y0.e.b.e2;
import h.a.y0.e.b.e3;
import h.a.y0.e.b.e4;
import h.a.y0.e.b.f1;
import h.a.y0.e.b.f2;
import h.a.y0.e.b.f3;
import h.a.y0.e.b.f4;
import h.a.y0.e.b.g1;
import h.a.y0.e.b.g2;
import h.a.y0.e.b.g4;
import h.a.y0.e.b.h3;
import h.a.y0.e.b.i1;
import h.a.y0.e.b.i2;
import h.a.y0.e.b.i3;
import h.a.y0.e.b.i4;
import h.a.y0.e.b.j1;
import h.a.y0.e.b.j2;
import h.a.y0.e.b.j4;
import h.a.y0.e.b.k1;
import h.a.y0.e.b.k2;
import h.a.y0.e.b.k3;
import h.a.y0.e.b.k4;
import h.a.y0.e.b.l1;
import h.a.y0.e.b.l2;
import h.a.y0.e.b.l3;
import h.a.y0.e.b.l4;
import h.a.y0.e.b.m1;
import h.a.y0.e.b.m2;
import h.a.y0.e.b.m3;
import h.a.y0.e.b.m4;
import h.a.y0.e.b.n1;
import h.a.y0.e.b.n2;
import h.a.y0.e.b.n3;
import h.a.y0.e.b.n4;
import h.a.y0.e.b.o1;
import h.a.y0.e.b.o2;
import h.a.y0.e.b.o3;
import h.a.y0.e.b.o4;
import h.a.y0.e.b.p1;
import h.a.y0.e.b.p3;
import h.a.y0.e.b.p4;
import h.a.y0.e.b.q1;
import h.a.y0.e.b.q2;
import h.a.y0.e.b.q3;
import h.a.y0.e.b.q4;
import h.a.y0.e.b.r1;
import h.a.y0.e.b.r2;
import h.a.y0.e.b.r3;
import h.a.y0.e.b.r4;
import h.a.y0.e.b.s0;
import h.a.y0.e.b.s1;
import h.a.y0.e.b.s2;
import h.a.y0.e.b.s3;
import h.a.y0.e.b.s4;
import h.a.y0.e.b.t0;
import h.a.y0.e.b.t1;
import h.a.y0.e.b.t3;
import h.a.y0.e.b.t4;
import h.a.y0.e.b.u0;
import h.a.y0.e.b.u1;
import h.a.y0.e.b.u2;
import h.a.y0.e.b.u3;
import h.a.y0.e.b.v0;
import h.a.y0.e.b.v1;
import h.a.y0.e.b.v2;
import h.a.y0.e.b.v3;
import h.a.y0.e.b.w0;
import h.a.y0.e.b.w1;
import h.a.y0.e.b.w2;
import h.a.y0.e.b.w3;
import h.a.y0.e.b.x1;
import h.a.y0.e.b.x2;
import h.a.y0.e.b.x3;
import h.a.y0.e.b.y0;
import h.a.y0.e.b.y1;
import h.a.y0.e.b.y2;
import h.a.y0.e.b.z0;
import h.a.y0.e.b.z1;
import h.a.y0.e.b.z2;
import h.a.y0.e.b.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Flowable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> implements j.d.b<T> {
    static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int Q() {
        return a;
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> R() {
        return h.a.c1.a.a(t0.f10985b);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> S() {
        return h.a.c1.a.a(c2.f10594b);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends T>... bVarArr) {
        h.a.y0.b.b.a(bVarArr, "sources is null");
        int length = bVarArr.length;
        return length == 0 ? R() : length == 1 ? q(bVarArr[0]) : h.a.c1.a.a(new h.a.y0.e.b.h(bVarArr, null));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends j.d.b<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.b.h(null, iterable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> c(j.d.b<? extends T>[] bVarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(bVarArr, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(j.d.b<? extends T>... bVarArr) {
        return a(Q(), Q(), bVarArr);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(Iterable<? extends j.d.b<? extends T>> iterable) {
        return a(iterable, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(Callable<? extends T> callable) {
        h.a.y0.b.b.a(callable, "supplier is null");
        return h.a.c1.a.a((l) new e1(callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> g(Iterable<? extends j.d.b<? extends T>> iterable) {
        return f((Iterable) iterable).i(h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> h(Iterable<? extends j.d.b<? extends T>> iterable) {
        return f((Iterable) iterable).b(h.a.y0.b.a.e(), true);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> k(h.a.x0.g<k<T>> gVar) {
        h.a.y0.b.b.a(gVar, "generator is null");
        return a(h.a.y0.b.a.h(), p1.a(gVar), h.a.y0.b.a.d());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> l(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return h.a.c1.a.a((l) new t1(t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> n(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return c(bVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> o(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return a((j.d.b) bVar, Q(), true);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> p(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return a(bVar, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> q(j.d.b<? extends T> bVar) {
        if (bVar instanceof l) {
            return h.a.c1.a.a((l) bVar);
        }
        h.a.y0.b.b.a(bVar, "publisher is null");
        return h.a.c1.a.a(new i1(bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> r(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return d(bVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> s(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return e(bVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> t(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return q(bVar).v(h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> u(j.d.b<? extends j.d.b<? extends T>> bVar) {
        return g(bVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> v(j.d.b<T> bVar) {
        h.a.y0.b.b.a(bVar, "onSubscribe is null");
        if (bVar instanceof l) {
            throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return h.a.c1.a.a(new i1(bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> A() {
        return d(i.q2.t.m0.f12222b);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.w0.a<T> B() {
        return x2.a((l) this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> C() {
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.b());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> D() {
        return h.a.c1.a.a(new i3(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> E() {
        return z().V();
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> F() {
        return h.a.c1.a.a(new k3(this));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> G() {
        return h.a.c1.a.a(new l3(this, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> H() {
        return N().m().o(h.a.y0.b.a.a(h.a.y0.b.a.f())).k((h.a.x0.o<? super R, ? extends Iterable<? extends U>>) h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final h.a.u0.c I() {
        return a((h.a.x0.g) h.a.y0.b.a.d(), (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c, (h.a.x0.g<? super j.d.d>) p1.i.INSTANCE);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.g1.f<T> J() {
        h.a.g1.f<T> fVar = new h.a.g1.f<>();
        a((q) fVar);
        return fVar;
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> K() {
        return a(TimeUnit.MILLISECONDS, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> L() {
        return b(TimeUnit.MILLISECONDS, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Future<T> M() {
        return (Future) e(new h.a.y0.h.i());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> N() {
        return h.a.c1.a.a(new i4(this));
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> O() {
        return h.a.c1.a.a(new h.a.y0.e.d.e1(this));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> P() {
        return b((Comparator) h.a.y0.b.a.f());
    }

    protected abstract void d(j.d.c<? super T> cVar);

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Long> i() {
        return h.a.c1.a.a(new h.a.y0.e.b.b0(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T2> l<T2> j() {
        return h.a.c1.a.a(new h.a.y0.e.b.i0(this));
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> m() {
        return a(0L);
    }

    @Override // j.d.b
    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.h("none")
    public final void subscribe(j.d.c<? super T> cVar) {
        if (cVar instanceof q) {
            a((q) cVar);
        } else {
            h.a.y0.b.b.a(cVar, "s is null");
            a((q) new h.a.y0.h.t(cVar));
        }
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> w() {
        return h.a.c1.a.a(new i2(this));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> x() {
        return h.a.c1.a.a(new h.a.y0.e.b.j0(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.c
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.b1.b<T> y() {
        return h.a.b1.b.a(this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.w0.a<T> z() {
        return f(Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> c(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(iterable, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(Iterable<? extends j.d.b<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).b(h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(Callable<? extends Throwable> callable) {
        h.a.y0.b.b.a(callable, "errorSupplier is null");
        return h.a.c1.a.a(new u0(callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> g(j.d.b<? extends j.d.b<? extends T>> bVar, int i2) {
        return q(bVar).h(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static l<Long> p(long j2, TimeUnit timeUnit) {
        return d(j2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> k0<Map<K, Collection<T>>> A(h.a.x0.o<? super T, ? extends K> oVar) {
        return (k0<Map<K, Collection<T>>>) a((h.a.x0.o) oVar, (h.a.x0.o) h.a.y0.b.a.e(), (Callable) h.a.y0.j.m.asCallable(), (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> h() {
        return c(16);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> i(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a((h.a.x0.o) oVar, false, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final c j(h.a.x0.o<? super T, ? extends i> oVar) {
        return b((h.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> m(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return d((h.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> n() {
        return b(0L);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> o() {
        return h.a.c1.a.a(new m1(this));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> r() {
        return h.a.c1.a.a(new u1(this));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> s() {
        return h.a.c1.a.a(new v1(this, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<a0<T>> t() {
        return h.a.c1.a.a(new b2(this));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> u() {
        return a(Q(), false, true);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> w(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return h(oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <V> l<T> x(h.a.x0.o<? super T, ? extends j.d.b<V>> oVar) {
        return b((j.d.b) null, oVar, (j.d.b) null);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> R y(h.a.x0.o<? super l<T>, R> oVar) {
        try {
            return (R) ((h.a.x0.o) h.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> k0<Map<K, T>> z(h.a.x0.o<? super T, ? extends K> oVar) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        return (k0<Map<K, T>>) a((Callable) h.a.y0.j.m.asCallable(), (h.a.x0.b) h.a.y0.b.a.a((h.a.x0.o) oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> b(j.d.b<? extends T>[] bVarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(bVarArr, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends j.d.b<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), 2, false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(Iterable<? extends T> iterable) {
        h.a.y0.b.b.a(iterable, "source is null");
        return h.a.c1.a.a(new g1(iterable));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static l<Long> p(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d(j2, j2, timeUnit, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final void g() {
        h.a.y0.e.b.l.a(this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> l<T> h(h.a.x0.o<? super T, K> oVar) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        return h.a.c1.a.a(new h.a.y0.e.b.l0(this, oVar, h.a.y0.b.b.a()));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> i(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onDrop is null");
        return h.a.c1.a.a((l) new g2(this, gVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> j(T t) {
        h.a.y0.b.b.a((Object) t, "defaultItem is null");
        return h.a.c1.a.a(new l3(this, t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> l() {
        return h((h.a.x0.o) h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> m(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> l<h.a.w0.b<K, T>> n(h.a.x0.o<? super T, ? extends K> oVar) {
        return (l<h.a.w0.b<K, T>>) a((h.a.x0.o) oVar, (h.a.x0.o) h.a.y0.b.a.e(), false, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> o(h.a.x0.o<? super T, ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new y1(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> r(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar) {
        return e(oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> s(h.a.x0.o<? super l<Object>, ? extends j.d.b<?>> oVar) {
        h.a.y0.b.b.a(oVar, "handler is null");
        return h.a.c1.a.a(new w2(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> t(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar) {
        h.a.y0.b.b.a(oVar, "selector is null");
        return x2.a(p1.a(this), (h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> u(h.a.x0.o<? super l<Throwable>, ? extends j.d.b<?>> oVar) {
        h.a.y0.b.b.a(oVar, "handler is null");
        return h.a.c1.a.a(new a3(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> b(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(iterable, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(Callable<? extends j.d.b<? extends T>> callable) {
        h.a.y0.b.b.a(callable, "supplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.f0(callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(j.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).c(h.a.y0.b.a.e(), bVarArr.length);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> l<T> g(h.a.x0.o<? super T, K> oVar) {
        return a((h.a.x0.o) oVar, (Callable) h.a.y0.b.a.c());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> l(h.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        return c((h.a.x0.o) oVar, false, Integer.MAX_VALUE);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> m(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> n(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, (j.d.b) null, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final c p() {
        return h.a.c1.a.a(new o1(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> b(h.a.x0.o<? super Object[], ? extends R> oVar, j.d.b<? extends T>... bVarArr) {
        return b(bVarArr, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends j.d.b<? extends T>> bVar, int i2) {
        return q(bVar).a(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> e(j.d.b<? extends j.d.b<? extends T>> bVar, int i2) {
        return q(bVar).a(h.a.y0.b.a.e(), true, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(j.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(h.a.y0.b.a.e(), true, bVarArr.length);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static l<Long> q(long j2, TimeUnit timeUnit) {
        return q(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(h.a.x0.g<? super j.d.d> gVar) {
        return a(gVar, h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c h(h.a.x0.g<? super T> gVar) {
        return j((h.a.x0.g) gVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> i(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return q(h.a.y0.b.a.c(t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> j(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return b(bVar, this);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> l(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new z3(this, bVar));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<l<T>> m(j.d.b<B> bVar) {
        return b(bVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> n(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, (j.d.b) null, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<l<T>> o(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), i.q2.t.m0.f12222b, false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> p(h.a.x0.o<? super Throwable, ? extends j.d.b<? extends T>> oVar) {
        h.a.y0.b.b.a(oVar, "resumeFunction is null");
        return h.a.c1.a.a(new j2(this, oVar, false));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> v() {
        return h.a.c1.a.a((l) new g2(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, j.d.b<? extends T>... bVarArr) {
        return a(bVarArr, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> b(j.d.b<? extends T>[] bVarArr, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(bVarArr, "sources is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (bVarArr.length == 0) {
            return R();
        }
        return h.a.c1.a.a(new h.a.y0.e.b.u((j.d.b[]) bVarArr, (h.a.x0.o) oVar, i2, true));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        if (bVarArr.length == 1) {
            return q(bVarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.b.v(bVarArr, true));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static l<Long> d(long j2, long j3, TimeUnit timeUnit) {
        return d(j2, j3, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> f(j.d.b<? extends j.d.b<? extends T>> bVar, int i2) {
        return q(bVar).g(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static l<Long> q(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new g4(Math.max(0L, j2), timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> e() {
        return new h.a.y0.e.b.e(this);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> g(T t) {
        return a(0L, t);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> h(T t) {
        h.a.y0.b.b.a((Object) t, "defaultItem");
        return h.a.c1.a.a(new v1(this, t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> k() {
        return a((h.a.x0.o) h.a.y0.b.a.e(), (Callable) h.a.y0.b.a.c());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> o(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, i.q2.t.m0.f12222b, false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> v(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return g(oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(j.d.b<? extends T>[] bVarArr, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(bVarArr, "sources is null");
        if (bVarArr.length == 0) {
            return R();
        }
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.b.u((j.d.b[]) bVarArr, (h.a.x0.o) oVar, i2, false));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static l<Long> d(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new q1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> e(Object obj) {
        h.a.y0.b.b.a(obj, "item is null");
        return b((h.a.x0.r) h.a.y0.b.a.a(obj));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T f() {
        return G().d();
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "next is null");
        return h.a.c1.a.a(new j2(this, h.a.y0.b.a.c(bVar), true));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> i(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return h.a.c1.a.a(this);
            }
            return h.a.c1.a.a(new n3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c j(h.a.x0.g<? super T> gVar) {
        return a((h.a.x0.g) gVar, (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c, (h.a.x0.g<? super j.d.d>) p1.i.INSTANCE);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> k(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return d(oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> l(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> f(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return k((j.d.b) l(t));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.w0.a<T> h(int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return x2.a((l) this, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> j(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return h.a.c1.a.a(new n1(this));
        }
        if (i2 == 1) {
            return h.a.c1.a.a(new w3(this));
        }
        return h.a.c1.a.a(new v3(this, i2));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> k(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return b(l(t), this);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> l(long j2, TimeUnit timeUnit, j0 j0Var) {
        return f(j2, timeUnit, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> e(h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
        h.a.y0.b.b.a(oVar, "debounceIndicator is null");
        return h.a.c1.a.a(new h.a.y0.e.b.d0(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(int i2) {
        return a(h.a.y0.g.e.f11940b, true, i2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> l(int i2) {
        return a(h.a.y0.b.a.f(), i2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> q() {
        return a((h.a.x0.r) h.a.y0.b.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> d(j.d.b<? extends j.d.b<? extends T>> bVar, int i2) {
        return q(bVar).c(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> f(h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
        h.a.y0.b.b.a(oVar, "itemDelayIndicator is null");
        return (l<T>) i((h.a.x0.o) p1.b(oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(long j2, TimeUnit timeUnit) {
        return i((j.d.b) q(j2, timeUnit));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> h(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "sampler is null");
        return h.a.c1.a.a(new b3(this, bVar, false));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> i(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new p3(this, bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> k(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return h.a.c1.a.a(new s3(this, bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> q(h.a.x0.o<? super Throwable, ? extends T> oVar) {
        h.a.y0.b.b.a(oVar, "valueSupplier is null");
        return h.a.c1.a.a(new k2(this, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> l<T> c(Callable<S> callable, h.a.x0.c<S, k<T>, S> cVar) {
        return a((Callable) callable, (h.a.x0.c) cVar, h.a.y0.b.a.d());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> d(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2) {
        return a(bVar, bVar2, h.a.y0.b.b.a(), Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> e(h.a.x0.g<? super Throwable> gVar) {
        h.a.x0.g<? super T> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a((h.a.x0.g) gVarD, gVar, aVar, aVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> g(long j2, TimeUnit timeUnit, j0 j0Var) {
        return i((j.d.b) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> b(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.b.u((Iterable) iterable, (h.a.x0.o) oVar, i2, true));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(Iterable<? extends j.d.b<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), true, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> d(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new s4(null, iterable, oVar, Q(), false));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> e(h.a.x0.a aVar) {
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.a(aVar), aVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> f(h.a.x0.g<? super T> gVar) {
        h.a.x0.g<? super Throwable> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a((h.a.x0.g) gVar, gVarD, aVar, aVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> g(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
        return b((h.a.x0.o) oVar, i2, false);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> h(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), false, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> i(long j2, TimeUnit timeUnit) {
        return l((j.d.b) q(j2, timeUnit));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> j(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a(), false, Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> k(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.b.u((Iterable) iterable, (h.a.x0.o) oVar, i2, false));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(int i2, int i3, j.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(h.a.y0.b.a.e(), true, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> e(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return b(this, bVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> f(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "next is null");
        return p(h.a.y0.b.a.c(bVar));
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new u3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> h(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> i(long j2, TimeUnit timeUnit, j0 j0Var) {
        return l((j.d.b) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> j(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, false, Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> k(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new c4(this, j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2}).a(h.a.y0.b.a.e(), true, 2);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> h(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
        return b((h.a.x0.o) oVar, i2, true);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<l<T>> i(long j2) {
        return a(j2, j2, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> d(j.d.b<? extends j.d.b<? extends T>> bVar, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        return q(bVar).N().e(p1.c(oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.c
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.b1.b<T> e(int i2) {
        h.a.y0.b.b.a(i2, "parallelism");
        return h.a.b1.b.a(this, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.w0.a<T> f(int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return l2.a((l) this, i2);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> g(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "stopPredicate is null");
        return h.a.c1.a.a(new a4(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> h(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new b4(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(j.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        if (bVarArr.length == 1) {
            return q(bVarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.b.v(bVarArr, false));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> k(int i2) {
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(new i4(this, h.a.y0.b.a.a(i2)));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, int i2, j.d.b<? extends T>... bVarArr) {
        return b(bVarArr, oVar, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2, bVar3}).a(h.a.y0.b.a.e(), true, 3);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> d() {
        return new h.a.y0.e.b.c(this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> e(h.a.x0.o<? super l<T>, ? extends j.d.b<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new m2(this, oVar, i2, false));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> f(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(p1.a(this, i2), (h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.g1.f<T> h(long j2) {
        h.a.g1.f<T> fVar = new h.a.g1.f<>(j2);
        a((q) fVar);
        return fVar;
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), bVar, bVar2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T d(T t) {
        return j(t).d();
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> d(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return b(oVar, 2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> d(j.d.b<U> bVar) {
        h.a.y0.b.b.a(bVar, "subscriptionIndicator is null");
        return h.a.c1.a.a(new h.a.y0.e.b.h0(this, bVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final h.a.w0.a<T> e(long j2, TimeUnit timeUnit) {
        return e(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> f(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(T... tArr) {
        h.a.y0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return R();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return h.a.c1.a.a(new d1(tArr));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> c(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3, j.d.b<? extends T> bVar4) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2, bVar3, bVar4}).a(h.a.y0.b.a.e(), true, 4);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.w0.a<T> e(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(this, j2, timeUnit, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> f(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, false));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), bVar, bVar2, bVar3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d((j.d.b) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> d(h.a.x0.a aVar) {
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.d(), aVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> e(long j2) {
        return a(j2, h.a.y0.b.a.b());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> f(long j2) {
        if (j2 <= 0) {
            return h.a.c1.a.a(this);
        }
        return h.a.c1.a.a(new m3(this, j2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> d(h.a.x0.g<? super a0<T>> gVar) {
        h.a.y0.b.b.a(gVar, "consumer is null");
        return a((h.a.x0.g) h.a.y0.b.a.c((h.a.x0.g) gVar), (h.a.x0.g<? super Throwable>) h.a.y0.b.a.b((h.a.x0.g) gVar), h.a.y0.b.a.a((h.a.x0.g) gVar), h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> e(h.a.x0.r<? super Throwable> rVar) {
        return a(i.q2.t.m0.f12222b, rVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), bVar, bVar2, bVar3, bVar4);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static l<Integer> c(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        }
        if (i3 == 0) {
            return R();
        }
        if (i3 == 1) {
            return l(Integer.valueOf(i2));
        }
        if (((long) i2) + ((long) (i3 - 1)) <= 2147483647L) {
            return h.a.c1.a.a(new n2(i2, i3));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E extends j.d.c<? super T>> E e(E e2) {
        subscribe(e2);
        return e2;
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> f(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new q3(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> l<T> b(Callable<S> callable, h.a.x0.b<S, k<T>> bVar) {
        h.a.y0.b.b.a(bVar, "generator is null");
        return a((Callable) callable, p1.a(bVar), h.a.y0.b.a.d());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> e(j0 j0Var) {
        return b(TimeUnit.MILLISECONDS, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> f(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new j4(this, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> d(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new c1(this, oVar, i2));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends j.d.b<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), false, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T c() {
        h.a.y0.h.e eVar = new h.a.y0.h.e();
        a((q) eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(int i2, int i3, j.d.b<? extends T>... bVarArr) {
        return b((Object[]) bVarArr).a(h.a.y0.b.a.e(), false, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2}).a(h.a.y0.b.a.e(), false, 2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> d(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new b1(this, oVar, z, i2));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> c(T t) {
        return new h.a.y0.e.b.d(this, t);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2, bVar3}).a(h.a.y0.b.a.e(), false, 3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(int i2) {
        h.a.y0.b.b.a(i2, "initialCapacity");
        return h.a.c1.a.a(new h.a.y0.e.b.r(this, i2));
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c d(h.a.x0.r<? super T> rVar) {
        return a((h.a.x0.r) rVar, (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> d(int i2) {
        return a(i2, false, false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> c(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a(oVar, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> d(long j2) {
        if (j2 >= 0) {
            if (j2 == 0) {
                return R();
            }
            return h.a.c1.a.a(new u2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return a((j.d.b) this, (j.d.b) bVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3, j.d.b<? extends T> bVar4) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return b((Object[]) new j.d.b[]{bVar, bVar2, bVar3, bVar4}).a(h.a.y0.b.a.e(), false, 4);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> d(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, h.a.e1.a.a(), z, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> d(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return b(j2, timeUnit, j0Var, z, Q());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onAfterNext is null");
        return h.a.c1.a.a(new h.a.y0.e.b.m0(this, gVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> d(j0 j0Var) {
        return a(TimeUnit.MILLISECONDS, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> b(Iterable<? extends j.d.b<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), true, i2);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(h.a.x0.a aVar) {
        return a(h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, aVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static l<Long> b(long j2, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return R();
        }
        if (j3 == 1) {
            return l(Long.valueOf(j2));
        }
        long j4 = (j3 - 1) + j2;
        if (j2 > 0 && j4 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        return h.a.c1.a.a(new o2(j2, j3));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new v0(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> c(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
        return a((h.a.x0.o) oVar, false, i2, Q());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> c(h.a.x0.o<? super T, ? extends y<? extends R>> oVar, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new z0(this, oVar, z, i2));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), false, Q(), bVar, bVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, j.d.b<? extends T8> bVar8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        h.a.y0.b.b.a(bVar8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> l<h.a.w0.b<K, T>> c(h.a.x0.o<? super T, ? extends K> oVar, boolean z) {
        return (l<h.a.w0.b<K, T>>) a(oVar, h.a.y0.b.a.e(), z, Q());
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.e
    @h.a.t0.h("none")
    public final l<T> c(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new x1(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), false, Q(), bVar, bVar2, bVar3);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.h("none")
    public final void c(j.d.c<? super T> cVar) {
        h.a.y0.b.b.a(cVar, "s is null");
        if (cVar instanceof h.a.g1.d) {
            a((q) cVar);
        } else {
            a((q) new h.a.g1.d(cVar));
        }
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), false, Q(), bVar, bVar2, bVar3, bVar4);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> c(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), z, Q());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> c(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return a(j2, timeUnit, j0Var, z, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, j.d.b<? extends T8> bVar8, j.d.b<? extends T9> bVar9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        h.a.y0.b.b.a(bVar8, "source8 is null");
        h.a.y0.b.b.a(bVar9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> c(@h.a.t0.f j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return b(j0Var, !(this instanceof h.a.y0.e.b.c0));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, (Callable) h.a.y0.j.m.asCallable(), (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, (Callable) callable, (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<l<T>> c(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, h.a.e1.a.a(), Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> c(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<l<T>> c(j.d.b<U> bVar, h.a.x0.o<? super U, ? extends j.d.b<V>> oVar) {
        return a(bVar, oVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<l<T>> c(Callable<? extends j.d.b<B>> callable) {
        return a(callable, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return b(bVar, bVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return b(bVar, bVar2, bVar3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, j.d.b<? extends T> bVar3, j.d.b<? extends T> bVar4) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return b(bVar, bVar2, bVar3, bVar4);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(int i2, int i3, j.d.b<? extends T>... bVarArr) {
        h.a.y0.b.b.a(bVarArr, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.x(new d1(bVarArr), h.a.y0.b.a.e(), i2, i3, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, j.d.b<? extends T8> bVar8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        h.a.y0.b.b.a(bVar8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends j.d.b<? extends T>> bVar, int i2, boolean z) {
        return q(bVar).a(h.a.y0.b.a.e(), i2, z);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(j.d.b<? extends j.d.b<? extends T>> bVar, int i2, int i3) {
        h.a.y0.b.b.a(bVar, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.y(bVar, h.a.y0.b.a.e(), i2, i3, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(Iterable<? extends j.d.b<? extends T>> iterable, int i2, int i3) {
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.x(new g1(iterable), h.a.y0.b.a.e(), i2, i3, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> b(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, j.d.b<? extends T3> bVar3, j.d.b<? extends T4> bVar4, j.d.b<? extends T5> bVar5, j.d.b<? extends T6> bVar6, j.d.b<? extends T7> bVar7, j.d.b<? extends T8> bVar8, j.d.b<? extends T9> bVar9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        h.a.y0.b.b.a(bVar5, "source5 is null");
        h.a.y0.b.b.a(bVar6, "source6 is null");
        h.a.y0.b.b.a(bVar7, "source7 is null");
        h.a.y0.b.b.a(bVar8, "source8 is null");
        h.a.y0.b.b.a(bVar9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), false, Q(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(o<T> oVar, b bVar) {
        h.a.y0.b.b.a(oVar, "source is null");
        h.a.y0.b.b.a(bVar, "mode is null");
        return h.a.c1.a.a(new h.a.y0.e.b.c0(oVar, bVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(Throwable th) {
        h.a.y0.b.b.a(th, "throwable is null");
        return e((Callable<? extends Throwable>) h.a.y0.b.a.b(th));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(Future<? extends T> future) {
        h.a.y0.b.b.a(future, "future is null");
        return h.a.c1.a.a(new f1(future, 0L, null));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        h.a.y0.b.b.a(future, "future is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        return h.a.c1.a.a(new f1(future, j2, timeUnit));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> b(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.b.j(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> b() {
        return a(Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> l<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return a(future, j2, timeUnit).c(j0Var);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T b(T t) {
        h.a.y0.h.e eVar = new h.a.y0.h.e();
        a((q) eVar);
        T tA = eVar.a();
        return tA != null ? tA : t;
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> l<T> a(Future<? extends T> future, j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return a((Future) future).c(j0Var);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final void b(h.a.x0.g<? super T> gVar) {
        h.a.y0.e.b.l.a(this, gVar, h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> l<T> a(Callable<S> callable, h.a.x0.b<S, k<T>> bVar, h.a.x0.g<? super S> gVar) {
        h.a.y0.b.b.a(bVar, "generator is null");
        return a((Callable) callable, p1.a(bVar), (h.a.x0.g) gVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<List<T>> b(int i2) {
        return a(i2, i2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<List<T>> b(j.d.b<B> bVar) {
        return (l<List<T>>) a((j.d.b) bVar, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> l<T> a(Callable<S> callable, h.a.x0.c<S, k<T>, S> cVar, h.a.x0.g<? super S> gVar) {
        h.a.y0.b.b.a(callable, "initialState is null");
        h.a.y0.b.b.a(cVar, "generator is null");
        h.a.y0.b.b.a(gVar, "disposeState is null");
        return h.a.c1.a.a(new j1(callable, cVar, gVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> b(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a((h.a.x0.o) oVar, 2, true);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> b(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new c1(this, oVar, i2));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static l<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return a(j2, j3, j4, j5, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public static l<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit, j0 j0Var) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return R().c(j4, timeUnit, j0Var);
        }
        long j6 = j2 + (j3 - 1);
        if (j2 > 0 && j6 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new r1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.b.e0(this, j2, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return h.a.c1.a.a(new h.a.y0.e.b.n0(this, aVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(j.d.c<? super T> cVar) {
        h.a.y0.b.b.a(cVar, "subscriber is null");
        return a((h.a.x0.g) p1.c(cVar), (h.a.x0.g<? super Throwable>) p1.b(cVar), p1.a(cVar), h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        return b(t, t2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        return b(t, t2, t3);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new s0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> b(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, z, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        return b(t, t2, t3, t4);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final c b(h.a.x0.o<? super T, ? extends i> oVar, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new y0(this, oVar, z, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<V> b(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return (l<V>) a((h.a.x0.o) p1.a(oVar), (h.a.x0.c) cVar, false, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        return b(t, t2, t3, t4, t5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<V> b(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends V> cVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return (l<V>) a((h.a.x0.o) p1.a(oVar), (h.a.x0.c) cVar, false, Q(), i2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> l<R> b(j.d.b<? extends TRight> bVar, h.a.x0.o<? super T, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super T, ? super TRight, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        h.a.y0.b.b.a(oVar, "leftEnd is null");
        h.a.y0.b.b.a(oVar2, "rightEnd is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return h.a.c1.a.a(new s1(this, bVar, oVar, oVar2, cVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        return b(t, t2, t3, t4, t5, t6);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> b(Class<U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return c((h.a.x0.r) h.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.c
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.b1.b<T> b(int i2, int i3) {
        h.a.y0.b.b.a(i2, "parallelism");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.b1.b.a(this, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        return b(t, t2, t3, t4, t5, t6, t7);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.w0.a<T> b(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a((h.a.w0.a) B(), j0Var);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        h.a.y0.b.b.a(dVar, "predicate is null");
        return h.a.c1.a.a(new y2(this, dVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(h.a.x0.e eVar) {
        h.a.y0.b.b.a(eVar, "stop is null");
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.a(eVar));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> b(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, h.a.e1.a.a(), z);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        h.a.y0.b.b.a((Object) t8, "The eighth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, z));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(h.a.x0.c<T, T, T> cVar) {
        h.a.y0.b.b.a(cVar, "accumulator is null");
        return h.a.c1.a.a(new e3(this, cVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> b(R r, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(r, "seed is null");
        return b((Callable) h.a.y0.b.a.b(r), (h.a.x0.c) cVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> b(Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(callable, "seedSupplier is null");
        h.a.y0.b.b.a(cVar, "accumulator is null");
        return h.a.c1.a.a(new f3(this, callable, cVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        h.a.y0.b.b.a((Object) t8, "The eighth item is null");
        h.a.y0.b.b.a((Object) t9, "The ninth is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c b(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        return a((h.a.x0.g) gVar, gVar2, h.a.y0.b.a.f10447c, (h.a.x0.g<? super j.d.d>) p1.i.INSTANCE);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c b(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        return a((h.a.x0.g) gVar, gVar2, aVar, (h.a.x0.g<? super j.d.d>) p1.i.INSTANCE);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.e
    @h.a.t0.h("custom")
    public final l<T> b(@h.a.t0.f j0 j0Var, boolean z) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new r3(this, j0Var, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> l<R> b(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return h.a.c1.a.a(new t3(this, oVar, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        h.a.y0.b.b.a((Object) t8, "The eighth item is null");
        h.a.y0.b.b.a((Object) t9, "The ninth item is null");
        h.a.y0.b.b.a((Object) t10, "The tenth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, h.a.e1.a.a(), false, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> b(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, false, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        return a(i.q2.t.m0.f12222b, j2, timeUnit, j0Var, z, i2);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<T> b(j.d.b<U> bVar, h.a.x0.o<? super T, ? extends j.d.b<V>> oVar) {
        h.a.y0.b.b.a(bVar, "firstTimeoutIndicator is null");
        return b(bVar, oVar, (j.d.b) null);
    }

    private <U, V> l<T> b(j.d.b<U> bVar, h.a.x0.o<? super T, ? extends j.d.b<V>> oVar, j.d.b<? extends T> bVar2) {
        h.a.y0.b.b.a(oVar, "itemTimeoutIndicator is null");
        return h.a.c1.a.a(new e4(this, bVar, oVar, bVar2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> b(TimeUnit timeUnit) {
        return b(timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> b(TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return (l<h.a.e1.c<T>>) o(h.a.y0.b.a.a(timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> l<T> a(Iterable<? extends j.d.b<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).c(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, h.a.x0.d<? super T, ? super T> dVar) {
        return a(bVar, bVar2, dVar, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, h.a.x0.d<? super T, ? super T> dVar, int i2) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(dVar, "isEqual is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h3(bVar, bVar2, dVar, i2));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> k0<U> b(Callable<U> callable) {
        h.a.y0.b.b.a(callable, "collectionSupplier is null");
        return h.a.c1.a.a(new i4(this, callable));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) h.a.y0.j.m.asCallable(), (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(j.d.b<? extends T> bVar, j.d.b<? extends T> bVar2, int i2) {
        return a(bVar, bVar2, h.a.y0.b.b.a(), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) callable, (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> l<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends j.d.b<? extends T>> oVar, h.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (h.a.x0.o) oVar, (h.a.x0.g) gVar, true);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> l<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends j.d.b<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        h.a.y0.b.b.a(callable, "resourceSupplier is null");
        h.a.y0.b.b.a(oVar, "sourceSupplier is null");
        h.a.y0.b.b.a(gVar, "disposer is null");
        return h.a.c1.a.a(new k4(callable, oVar, gVar, z));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> b(Comparator<? super T> comparator) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) N().h(h.a.y0.b.a.a((Comparator) comparator));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<l<T>> b(j.d.b<B> bVar, int i2) {
        h.a.y0.b.b.a(bVar, "boundaryIndicator is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new m4(this, bVar, i2));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), z, Q(), bVar, bVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> b(j.d.b<? extends U> bVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return b(this, bVar, cVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> l<R> a(j.d.b<? extends T1> bVar, j.d.b<? extends T2> bVar2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), z, i2, bVar, bVar2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2, j.d.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return R();
        }
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new s4(bVarArr, null, oVar, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> l<R> a(Iterable<? extends j.d.b<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new s4(null, iterable, oVar, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> a(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.b.g(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return a(this, bVar);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.e
    @h.a.t0.h("none")
    public final <R> R a(@h.a.t0.f m<T, ? extends R> mVar) {
        return (R) ((m) h.a.y0.b.b.a(mVar, "converter is null")).a(this);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T a() {
        h.a.y0.h.d dVar = new h.a.y0.h.d();
        a((q) dVar);
        T tA = dVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final T a(T t) {
        h.a.y0.h.d dVar = new h.a.y0.h.d();
        a((q) dVar);
        T tA = dVar.a();
        return tA != null ? tA : t;
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final void a(h.a.x0.g<? super T> gVar) {
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                ((h.a.u0.c) it).dispose();
                throw h.a.y0.j.k.c(th);
            }
        }
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> a(int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return new h.a.y0.e.b.b(this, i2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final void a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        h.a.y0.e.b.l.a(this, gVar, gVar2, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.h("none")
    public final void a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        h.a.y0.e.b.l.a(this, gVar, gVar2, aVar);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.h("none")
    public final void a(j.d.c<? super T> cVar) {
        h.a.y0.e.b.l.a(this, cVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<List<T>> a(int i2, int i3) {
        return (l<List<T>>) a(i2, i3, h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> l<U> a(int i2, int i3, Callable<U> callable) {
        h.a.y0.b.b.a(i2, "count");
        h.a.y0.b.b.a(i3, "skip");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.m(this, i2, i3, callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> l<U> a(int i2, Callable<U> callable) {
        return a(i2, i2, callable);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<List<T>> a(long j2, long j3, TimeUnit timeUnit) {
        return (l<List<T>>) a(j2, j3, timeUnit, h.a.e1.a.a(), h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<List<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return (l<List<T>>) a(j2, j3, timeUnit, j0Var, h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <U extends Collection<? super T>> l<U> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, Callable<U> callable) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.q(this, j2, j3, timeUnit, j0Var, callable, Integer.MAX_VALUE, false));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<List<T>> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), Integer.MAX_VALUE);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<List<T>> a(long j2, TimeUnit timeUnit, int i2) {
        return a(j2, timeUnit, h.a.e1.a.a(), i2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return (l<List<T>>) a(j2, timeUnit, j0Var, i2, (Callable) h.a.y0.j.b.asCallable(), false);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <U extends Collection<? super T>> l<U> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2, Callable<U> callable, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        h.a.y0.b.b.a(i2, "count");
        return h.a.c1.a.a(new h.a.y0.e.b.q(this, j2, j2, timeUnit, j0Var, callable, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return (l<List<T>>) a(j2, timeUnit, j0Var, Integer.MAX_VALUE, (Callable) h.a.y0.j.b.asCallable(), false);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TOpening, TClosing> l<List<T>> a(l<? extends TOpening> lVar, h.a.x0.o<? super TOpening, ? extends j.d.b<? extends TClosing>> oVar) {
        return (l<List<T>>) a((l) lVar, (h.a.x0.o) oVar, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> l<U> a(l<? extends TOpening> lVar, h.a.x0.o<? super TOpening, ? extends j.d.b<? extends TClosing>> oVar, Callable<U> callable) {
        h.a.y0.b.b.a(lVar, "openingIndicator is null");
        h.a.y0.b.b.a(oVar, "closingIndicator is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.n(this, lVar, oVar, callable));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<List<T>> a(j.d.b<B> bVar, int i2) {
        h.a.y0.b.b.a(i2, "initialCapacity");
        return (l<List<T>>) a((j.d.b) bVar, (Callable) h.a.y0.b.a.a(i2));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B, U extends Collection<? super T>> l<U> a(j.d.b<B> bVar, Callable<U> callable) {
        h.a.y0.b.b.a(bVar, "boundaryIndicator is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.p(this, bVar, callable));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<List<T>> a(Callable<? extends j.d.b<B>> callable) {
        return (l<List<T>>) a((Callable) callable, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B, U extends Collection<? super T>> l<U> a(Callable<? extends j.d.b<B>> callable, Callable<U> callable2) {
        h.a.y0.b.b.a(callable, "boundaryIndicatorSupplier is null");
        h.a.y0.b.b.a(callable2, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.o(this, callable, callable2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<U> a(Class<U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return (l<U>) o(h.a.y0.b.a.a((Class) cls));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<U> a(Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        h.a.y0.b.b.a(callable, "initialItemSupplier is null");
        h.a.y0.b.b.a(bVar, "collector is null");
        return h.a.c1.a.a(new h.a.y0.e.b.t(this, callable, bVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<U> a(U u, h.a.x0.b<? super U, ? super T> bVar) {
        h.a.y0.b.b.a(u, "initialItem is null");
        return a((Callable) h.a.y0.b.a.b(u), (h.a.x0.b) bVar);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(r<? super T, ? extends R> rVar) {
        return q(((r) h.a.y0.b.b.a(rVar, "composer is null")).a(this));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a(oVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h.a.y0.e.b.w(this, oVar, i2, h.a.y0.j.j.IMMEDIATE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h.a.y0.e.b.w(this, oVar, i2, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.x(this, oVar, i2, i3, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, Q(), Q(), z);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, int i3, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.b.x(this, oVar, i2, i3, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), z);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.b.g0(this, Math.max(0L, j2), timeUnit, j0Var, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<T> a(j.d.b<U> bVar, h.a.x0.o<? super T, ? extends j.d.b<V>> oVar) {
        return d((j.d.b) bVar).f((h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> l<T> a(h.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(callable, "collectionSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.b.k0(this, oVar, callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.d<? super T, ? super T> dVar) {
        h.a.y0.b.b.a(dVar, "comparer is null");
        return h.a.c1.a.a(new h.a.y0.e.b.l0(this, h.a.y0.b.a.e(), dVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.a aVar) {
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.f10447c, aVar);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    private l<T> a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.b.b.a(aVar2, "onAfterTerminate is null");
        return h.a.c1.a.a(new h.a.y0.e.b.o0(this, gVar, gVar2, aVar, aVar2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.g<? super j.d.d> gVar, h.a.x0.q qVar, h.a.x0.a aVar) {
        h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.y0.b.b.a(qVar, "onRequest is null");
        h.a.y0.b.b.a(aVar, "onCancel is null");
        return h.a.c1.a.a(new h.a.y0.e.b.p0(this, gVar, qVar, aVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.q qVar) {
        return a(h.a.y0.b.a.d(), qVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new h.a.y0.e.b.r0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(long j2, T t) {
        if (j2 >= 0) {
            h.a.y0.b.b.a((Object) t, "defaultItem is null");
            return h.a.c1.a.a(new s0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, Q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "bufferSize");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return R();
            }
            return d3.a(objCall, oVar);
        }
        return h.a.c1.a.a(new w0(this, oVar, z, i2, i3));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends j.d.b<? extends R>> oVar2, Callable<? extends j.d.b<? extends R>> callable) {
        h.a.y0.b.b.a(oVar, "onNextMapper is null");
        h.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        h.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return r(new z1(this, oVar, oVar2, callable));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, h.a.x0.o<Throwable, ? extends j.d.b<? extends R>> oVar2, Callable<? extends j.d.b<? extends R>> callable, int i2) {
        h.a.y0.b.b.a(oVar, "onNextMapper is null");
        h.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        h.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return d(new z1(this, oVar, oVar2, callable), i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a((h.a.x0.o) oVar, (h.a.x0.c) cVar, false, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(oVar, cVar, z, Q(), Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(oVar, cVar, z, i2, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "combiner is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "bufferSize");
        return a(p1.a(oVar, cVar), z, i2, i3);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return a((h.a.x0.o) oVar, (h.a.x0.c) cVar, false, i2, Q());
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar) {
        return a((h.a.x0.r) rVar, gVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.b(h.a.t0.a.NONE)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar, h.a.x0.a aVar) {
        h.a.y0.b.b.a(rVar, "onNext is null");
        h.a.y0.b.b.a(gVar, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.h.h hVar = new h.a.y0.h.h(rVar, gVar, aVar);
        a((q) hVar);
        return hVar;
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> l<h.a.w0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, false, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> l<h.a.w0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, boolean z) {
        return a(oVar, oVar2, z, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> l<h.a.w0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new k1(this, oVar, oVar2, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> l<R> a(j.d.b<? extends TRight> bVar, h.a.x0.o<? super T, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super T, ? super l<TRight>, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        h.a.y0.b.b.a(oVar, "leftEnd is null");
        h.a.y0.b.b.a(oVar2, "rightEnd is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return h.a.c1.a.a(new l1(this, bVar, oVar, oVar2, cVar));
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(p<? extends R, ? super T> pVar) {
        h.a.y0.b.b.a(pVar, "lifter is null");
        return h.a.c1.a.a(new w1(this, pVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(j0 j0Var) {
        return a(j0Var, false, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(j0 j0Var, boolean z) {
        return a(j0Var, z, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new d2(this, j0Var, z, i2));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(boolean z) {
        return a(Q(), z, true);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(int i2, boolean z) {
        return a(i2, z, false);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(int i2, boolean z, boolean z2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new e2(this, i2, z2, z, h.a.y0.b.a.f10447c));
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(int i2, boolean z, boolean z2, h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onOverflow is null");
        h.a.y0.b.b.a(i2, "capacity");
        return h.a.c1.a.a(new e2(this, i2, z2, z, aVar));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(int i2, h.a.x0.a aVar) {
        return a(i2, false, false, aVar);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(long j2, h.a.x0.a aVar, a aVar2) {
        h.a.y0.b.b.a(aVar2, "strategy is null");
        h.a.y0.b.b.a(j2, "capacity");
        return h.a.c1.a.a(new f2(this, j2, aVar, aVar2));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.c<T, T, T> cVar) {
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new q2(this, cVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(R r, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(r, "seed is null");
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new r2(this, r, cVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(callable, "seedSupplier is null");
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new s2(this, callable, cVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(h.a.x0.e eVar) {
        h.a.y0.b.b.a(eVar, "stop is null");
        return h.a.c1.a.a(new v2(this, eVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, int i2, long j2, TimeUnit timeUnit) {
        return a(oVar, i2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this, i2, j2, timeUnit, j0Var), (h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, int i2, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(p1.a(this, i2), p1.a(oVar, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, long j2, TimeUnit timeUnit) {
        return a(oVar, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this, j2, timeUnit, j0Var), (h.a.x0.o) oVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> l<R> a(h.a.x0.o<? super l<T>, ? extends j.d.b<R>> oVar, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a(p1.a(this), p1.a(oVar, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final h.a.w0.a<T> a(int i2, long j2, TimeUnit timeUnit) {
        return a(i2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.w0.a<T> a(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return x2.a(this, j2, timeUnit, j0Var, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.w0.a<T> a(int i2, j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return x2.a((h.a.w0.a) h(i2), j0Var);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(long j2, h.a.x0.r<? super Throwable> rVar) {
        if (j2 >= 0) {
            h.a.y0.b.b.a(rVar, "predicate is null");
            return h.a.c1.a.a(new z2(this, j2, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> l<T> a(j.d.b<U> bVar, boolean z) {
        h.a.y0.b.b.a(bVar, "sampler is null");
        return h.a.c1.a.a(new b3(this, bVar, z));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new o3(this, j2, timeUnit, j0Var, i2 << 1, z));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(Comparator<? super T> comparator) {
        h.a.y0.b.b.a(comparator, "sortFunction");
        return N().m().o(h.a.y0.b.a.a((Comparator) comparator)).k((h.a.x0.o<? super R, ? extends Iterable<? extends U>>) h.a.y0.b.a.e());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(Iterable<? extends T> iterable) {
        return b(f((Iterable) iterable), this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(T... tArr) {
        l lVarB = b((Object[]) tArr);
        if (lVarB == R()) {
            return h.a.c1.a.a(this);
        }
        return b(lVarB, this);
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.g<? super j.d.d> gVar3) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.b.b.a(gVar3, "onSubscribe is null");
        h.a.y0.h.l lVar = new h.a.y0.h.l(gVar, gVar2, aVar, gVar3);
        a((q) lVar);
        return lVar;
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.c
    @h.a.t0.h("none")
    public final void a(q<? super T> qVar) {
        h.a.y0.b.b.a(qVar, "s is null");
        try {
            j.d.c<? super T> cVarA = h.a.c1.a.a(this, qVar);
            h.a.y0.b.b.a(cVarA, "Plugin returned null Subscriber");
            d((j.d.c) cVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (j2 >= 0) {
            return h.a.c1.a.a(new x3(this, j2, j3, timeUnit, j0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> a(TimeUnit timeUnit) {
        return a(timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<h.a.e1.c<T>> a(TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new d4(this, timeUnit, j0Var));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <V> l<T> a(h.a.x0.o<? super T, ? extends j.d.b<V>> oVar, l<? extends T> lVar) {
        h.a.y0.b.b.a(lVar, "other is null");
        return b((j.d.b) null, oVar, lVar);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<T> a(long j2, TimeUnit timeUnit, j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return a(j2, timeUnit, bVar, h.a.e1.a.a());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<T> a(long j2, TimeUnit timeUnit, j0 j0Var, j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        return a(j2, timeUnit, bVar, j0Var);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<T> a(j.d.b<U> bVar, h.a.x0.o<? super T, ? extends j.d.b<V>> oVar, j.d.b<? extends T> bVar2) {
        h.a.y0.b.b.a(bVar, "firstTimeoutSelector is null");
        h.a.y0.b.b.a(bVar2, "other is null");
        return b(bVar, oVar, bVar2);
    }

    private l<T> a(long j2, TimeUnit timeUnit, j.d.b<? extends T> bVar, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "timeUnit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new f4(this, j2, timeUnit, j0Var, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, h.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        h.a.y0.b.b.a(callable, "mapSupplier is null");
        h.a.y0.b.b.a(oVar3, "collectionFactory is null");
        return (k0<Map<K, Collection<V>>>) a((Callable) callable, (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2, oVar3));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> a(Comparator<? super T> comparator, int i2) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) k(i2).h(h.a.y0.b.a.a((Comparator) comparator));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<l<T>> a(long j2, long j3) {
        return a(j2, j3, Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<l<T>> a(long j2, long j3, int i2) {
        h.a.y0.b.b.a(j3, "skip");
        h.a.y0.b.b.a(j2, "count");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new l4(this, j2, j3, i2));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(j2, "timespan");
        h.a.y0.b.b.a(j3, "timeskip");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        return h.a.c1.a.a(new p4(this, j2, j3, timeUnit, j0Var, i.q2.t.m0.f12222b, i2, false));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<l<T>> a(long j2, TimeUnit timeUnit, long j3) {
        return a(j2, timeUnit, h.a.e1.a.a(), j3, false);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final l<l<T>> a(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), j3, z);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3) {
        return a(j2, timeUnit, j0Var, j3, false);
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z) {
        return a(j2, timeUnit, j0Var, j3, z, Q());
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("custom")
    public final l<l<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z, int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j3, "count");
        return h.a.c1.a.a(new p4(this, j2, j2, timeUnit, j0Var, j3, i2, z));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> l<l<T>> a(j.d.b<U> bVar, h.a.x0.o<? super U, ? extends j.d.b<V>> oVar, int i2) {
        h.a.y0.b.b.a(bVar, "openingIndicator is null");
        h.a.y0.b.b.a(oVar, "closingIndicator is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new n4(this, bVar, oVar, i2));
    }

    @h.a.t0.b(h.a.t0.a.ERROR)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> l<l<T>> a(Callable<? extends j.d.b<B>> callable, int i2) {
        h.a.y0.b.b.a(callable, "boundaryIndicatorSupplier is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new o4(this, callable, i2));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(j.d.b<? extends U> bVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(bVar, "other is null");
        h.a.y0.b.b.a(cVar, "combiner is null");
        return h.a.c1.a.a(new q4(this, cVar, bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, R> l<R> a(j.d.b<T1> bVar, j.d.b<T2> bVar2, h.a.x0.h<? super T, ? super T1, ? super T2, R> hVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        return a((j.d.b<?>[]) new j.d.b[]{bVar, bVar2}, h.a.y0.b.a.a((h.a.x0.h) hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, T3, R> l<R> a(j.d.b<T1> bVar, j.d.b<T2> bVar2, j.d.b<T3> bVar3, h.a.x0.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        return a((j.d.b<?>[]) new j.d.b[]{bVar, bVar2, bVar3}, h.a.y0.b.a.a((h.a.x0.i) iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, T3, T4, R> l<R> a(j.d.b<T1> bVar, j.d.b<T2> bVar2, j.d.b<T3> bVar3, j.d.b<T4> bVar4, h.a.x0.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        h.a.y0.b.b.a(bVar, "source1 is null");
        h.a.y0.b.b.a(bVar2, "source2 is null");
        h.a.y0.b.b.a(bVar3, "source3 is null");
        h.a.y0.b.b.a(bVar4, "source4 is null");
        return a((j.d.b<?>[]) new j.d.b[]{bVar, bVar2, bVar3, bVar4}, h.a.y0.b.a.a((h.a.x0.j) jVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(j.d.b<?>[] bVarArr, h.a.x0.o<? super Object[], R> oVar) {
        h.a.y0.b.b.a(bVarArr, "others is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        return h.a.c1.a.a(new r4(this, bVarArr, oVar));
    }

    @h.a.t0.b(h.a.t0.a.PASS_THROUGH)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> l<R> a(Iterable<? extends j.d.b<?>> iterable, h.a.x0.o<? super Object[], R> oVar) {
        h.a.y0.b.b.a(iterable, "others is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        return h.a.c1.a.a(new r4(this, iterable, oVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(Iterable<U> iterable, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(iterable, "other is null");
        h.a.y0.b.b.a(cVar, "zipper is null");
        return h.a.c1.a.a(new t4(this, iterable, cVar));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(j.d.b<? extends U> bVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(this, bVar, cVar, z);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> l<R> a(j.d.b<? extends U> bVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(this, bVar, cVar, z, i2);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.g1.f<T> a(long j2, boolean z) {
        h.a.g1.f<T> fVar = new h.a.g1.f<>(j2);
        if (z) {
            fVar.cancel();
        }
        a((q) fVar);
        return fVar;
    }
}
