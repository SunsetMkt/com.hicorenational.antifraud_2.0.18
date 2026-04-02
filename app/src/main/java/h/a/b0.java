package h.a;

import h.a.y0.e.d.a1;
import h.a.y0.e.d.a2;
import h.a.y0.e.d.a3;
import h.a.y0.e.d.a4;
import h.a.y0.e.d.b1;
import h.a.y0.e.d.b2;
import h.a.y0.e.d.b3;
import h.a.y0.e.d.b4;
import h.a.y0.e.d.c1;
import h.a.y0.e.d.c2;
import h.a.y0.e.d.c3;
import h.a.y0.e.d.c4;
import h.a.y0.e.d.d1;
import h.a.y0.e.d.d2;
import h.a.y0.e.d.d3;
import h.a.y0.e.d.d4;
import h.a.y0.e.d.e1;
import h.a.y0.e.d.e2;
import h.a.y0.e.d.e3;
import h.a.y0.e.d.e4;
import h.a.y0.e.d.f1;
import h.a.y0.e.d.f2;
import h.a.y0.e.d.f3;
import h.a.y0.e.d.f4;
import h.a.y0.e.d.g1;
import h.a.y0.e.d.g2;
import h.a.y0.e.d.g3;
import h.a.y0.e.d.g4;
import h.a.y0.e.d.h1;
import h.a.y0.e.d.h2;
import h.a.y0.e.d.h3;
import h.a.y0.e.d.i1;
import h.a.y0.e.d.i3;
import h.a.y0.e.d.j1;
import h.a.y0.e.d.j2;
import h.a.y0.e.d.j3;
import h.a.y0.e.d.k1;
import h.a.y0.e.d.k2;
import h.a.y0.e.d.k3;
import h.a.y0.e.d.l1;
import h.a.y0.e.d.l2;
import h.a.y0.e.d.l3;
import h.a.y0.e.d.m1;
import h.a.y0.e.d.m2;
import h.a.y0.e.d.m3;
import h.a.y0.e.d.n1;
import h.a.y0.e.d.n2;
import h.a.y0.e.d.n3;
import h.a.y0.e.d.o1;
import h.a.y0.e.d.o2;
import h.a.y0.e.d.o3;
import h.a.y0.e.d.p1;
import h.a.y0.e.d.p2;
import h.a.y0.e.d.p3;
import h.a.y0.e.d.q1;
import h.a.y0.e.d.q2;
import h.a.y0.e.d.q3;
import h.a.y0.e.d.r1;
import h.a.y0.e.d.r2;
import h.a.y0.e.d.r3;
import h.a.y0.e.d.s0;
import h.a.y0.e.d.s1;
import h.a.y0.e.d.s2;
import h.a.y0.e.d.s3;
import h.a.y0.e.d.t0;
import h.a.y0.e.d.t1;
import h.a.y0.e.d.t2;
import h.a.y0.e.d.t3;
import h.a.y0.e.d.u0;
import h.a.y0.e.d.u1;
import h.a.y0.e.d.u2;
import h.a.y0.e.d.u3;
import h.a.y0.e.d.v1;
import h.a.y0.e.d.v3;
import h.a.y0.e.d.w0;
import h.a.y0.e.d.w1;
import h.a.y0.e.d.w2;
import h.a.y0.e.d.w3;
import h.a.y0.e.d.x0;
import h.a.y0.e.d.x1;
import h.a.y0.e.d.x2;
import h.a.y0.e.d.x3;
import h.a.y0.e.d.y0;
import h.a.y0.e.d.y1;
import h.a.y0.e.d.y2;
import h.a.y0.e.d.y3;
import h.a.y0.e.d.z0;
import h.a.y0.e.d.z1;
import h.a.y0.e.d.z2;
import h.a.y0.e.d.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Observable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0<T> implements g0<T> {

    /* JADX INFO: compiled from: Observable.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[b.values().length];

        static {
            try {
                a[b.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int L() {
        return l.Q();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> M() {
        return h.a.c1.a.a(h.a.y0.e.d.r0.a);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> N() {
        return h.a.c1.a.a(x1.a);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T>... g0VarArr) {
        h.a.y0.b.b.a(g0VarArr, "sources is null");
        int length = g0VarArr.length;
        return length == 0 ? M() : length == 1 ? v(g0VarArr[0]) : h.a.c1.a.a(new h.a.y0.e.d.h(g0VarArr, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new h.a.y0.e.d.h(null, iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> c(g0<? extends T>[] g0VarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(g0VarArr, oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> d(g0<? extends T>... g0VarArr) {
        return a(L(), L(), g0VarArr);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> e(Iterable<? extends g0<? extends T>> iterable) {
        return a(iterable, L(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> f(Callable<? extends T> callable) {
        h.a.y0.b.b.a(callable, "supplier is null");
        return h.a.c1.a.a((b0) new b1(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> g(Iterable<? extends g0<? extends T>> iterable) {
        return f((Iterable) iterable).j(h.a.y0.b.a.e());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> h(Iterable<? extends g0<? extends T>> iterable) {
        return f((Iterable) iterable).b(h.a.y0.b.a.e(), true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> j(h.a.x0.g<k<T>> gVar) {
        h.a.y0.b.b.a(gVar, "generator  is null");
        return a(h.a.y0.b.a.h(), m1.a(gVar), h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> l(T t) {
        h.a.y0.b.b.a((Object) t, "The item is null");
        return h.a.c1.a.a((b0) new q1(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> n(g0<? extends g0<? extends T>> g0Var) {
        return c(g0Var, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> o(g0<? extends g0<? extends T>> g0Var) {
        return a((g0) g0Var, L(), true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> p(g0<? extends g0<? extends T>> g0Var) {
        return a(g0Var, L(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> q(g0<? extends g0<? extends T>> g0Var) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        return h.a.c1.a.a(new u0(g0Var, h.a.y0.b.a.e(), false, Integer.MAX_VALUE, L()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> r(g0<? extends g0<? extends T>> g0Var) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        return h.a.c1.a.a(new u0(g0Var, h.a.y0.b.a.e(), true, Integer.MAX_VALUE, L()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> s(g0<? extends g0<? extends T>> g0Var) {
        return f(g0Var, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> t(g0<? extends g0<? extends T>> g0Var) {
        return g(g0Var, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> u(g0<T> g0Var) {
        h.a.y0.b.b.a(g0Var, "source is null");
        h.a.y0.b.b.a(g0Var, "onSubscribe is null");
        if (g0Var instanceof b0) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return h.a.c1.a.a(new f1(g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> v(g0<T> g0Var) {
        h.a.y0.b.b.a(g0Var, "source is null");
        return g0Var instanceof b0 ? h.a.c1.a.a((b0) g0Var) : h.a.c1.a.a(new f1(g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> A() {
        return v().Q();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> B() {
        return h.a.c1.a.a(new y2(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> C() {
        return h.a.c1.a.a(new z2(this, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> D() {
        return J().p().p(h.a.y0.b.a.a(h.a.y0.b.a.f())).l((h.a.x0.o<? super R, ? extends Iterable<? extends U>>) h.a.y0.b.a.e());
    }

    @h.a.t0.h("none")
    public final h.a.u0.c E() {
        return a((h.a.x0.g) h.a.y0.b.a.d(), (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c, h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> F() {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        subscribe(nVar);
        return nVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> G() {
        return a(TimeUnit.MILLISECONDS, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> H() {
        return b(TimeUnit.MILLISECONDS, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Future<T> I() {
        return (Future) e(new h.a.y0.d.r());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> J() {
        return g(16);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> K() {
        return b((Comparator) h.a.y0.b.a.g());
    }

    protected abstract void d(i0<? super T> i0Var);

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Long> i() {
        return h.a.c1.a.a(new h.a.y0.e.d.z(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> k() {
        return a((h.a.x0.o) h.a.y0.b.a.e(), (Callable) h.a.y0.b.a.c());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> m() {
        return a(0L);
    }

    @Override // h.a.g0
    @h.a.t0.h("none")
    public final void subscribe(i0<? super T> i0Var) {
        h.a.y0.b.b.a(i0Var, "observer is null");
        try {
            i0<? super T> i0VarA = h.a.c1.a.a(this, i0Var);
            h.a.y0.b.b.a(i0VarA, "Plugin returned null Observer");
            d((i0) i0VarA);
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

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> w() {
        return c(i.q2.t.m0.f12222b);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.z0.a<T> x() {
        return m2.w(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> y() {
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.b());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> z() {
        return h.a.c1.a.a(new x2(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> c(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return b(iterable, oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> d(Iterable<? extends g0<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return o(f((Iterable) iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> e(Callable<? extends Throwable> callable) {
        h.a.y0.b.b.a(callable, "errorSupplier is null");
        return h.a.c1.a.a(new s0(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> g(g0<? extends g0<? extends T>> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h3(g0Var, h.a.y0.b.a.e(), i2, true));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static b0<Long> p(long j2, TimeUnit timeUnit) {
        return d(j2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <V> b0<T> A(h.a.x0.o<? super T, ? extends g0<V>> oVar) {
        return b((g0) null, oVar, (g0) null);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> R B(h.a.x0.o<? super b0<T>, R> oVar) {
        try {
            return (R) ((h.a.x0.o) h.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> k0<Map<K, T>> C(h.a.x0.o<? super T, ? extends K> oVar) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        return (k0<Map<K, T>>) a((Callable) h.a.y0.j.m.asCallable(), (h.a.x0.b) h.a.y0.b.a.a((h.a.x0.o) oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> k0<Map<K, Collection<T>>> D(h.a.x0.o<? super T, ? extends K> oVar) {
        return (k0<Map<K, Collection<T>>>) a((h.a.x0.o) oVar, (h.a.x0.o) h.a.y0.b.a.e(), (Callable) h.a.y0.j.m.asCallable(), (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> h() {
        return h.a.y0.e.d.r.a((b0) this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> b0<T> i(h.a.x0.o<? super T, K> oVar) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        return h.a.c1.a.a(new h.a.y0.e.d.j0(this, oVar, h.a.y0.b.b.a()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c k(h.a.x0.o<? super T, ? extends i> oVar) {
        return c((h.a.x0.o) oVar, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> m(h.a.x0.o<? super T, ? extends y<? extends R>> oVar) {
        return d((h.a.x0.o) oVar, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> n() {
        return b(0L);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> b0<h.a.z0.b<K, T>> o(h.a.x0.o<? super T, ? extends K> oVar) {
        return (b0<h.a.z0.b<K, T>>) a((h.a.x0.o) oVar, (h.a.x0.o) h.a.y0.b.a.e(), false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> s() {
        return h.a.c1.a.a(new s1(this, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<a0<T>> t() {
        return h.a.c1.a.a(new w1(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> w(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return f(oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> x(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return g(oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.e
    @h.a.t0.f
    @h.a.t0.h("none")
    public final <R> b0<R> y(@h.a.t0.f h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return m1.a(this, oVar);
    }

    @h.a.t0.d
    @h.a.t0.e
    @h.a.t0.f
    @h.a.t0.h("none")
    public final <R> b0<R> z(@h.a.t0.f h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return m1.b(this, oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> b(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(iterable, oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(Iterable<? extends g0<? extends T>> iterable) {
        h.a.y0.b.b.a(iterable, "sources is null");
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), L(), false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> f(Iterable<? extends T> iterable) {
        h.a.y0.b.b.a(iterable, "source is null");
        return h.a.c1.a.a(new d1(iterable));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static b0<Long> p(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d(j2, j2, timeUnit, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static b0<Long> q(long j2, TimeUnit timeUnit) {
        return q(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> b0<T> h(h.a.x0.o<? super T, K> oVar) {
        return a((h.a.x0.o) oVar, (Callable) h.a.y0.b.a.c());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> k(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return b(l(t), this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> l() {
        return i((h.a.x0.o) h.a.y0.b.a.e());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> m(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> n(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar) {
        return e((h.a.x0.o) oVar, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> o() {
        return h.a.c1.a.a(new j1(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> r() {
        return h.a.c1.a.a(new r1(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> s(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar) {
        h.a.y0.b.b.a(oVar, "selector is null");
        return h.a.c1.a.a(new c2(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> t(h.a.x0.o<? super b0<Object>, ? extends g0<?>> oVar) {
        h.a.y0.b.b.a(oVar, "handler is null");
        return h.a.c1.a.a(new l2(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> b(g0<? extends T>[] g0VarArr, h.a.x0.o<? super Object[], ? extends R> oVar) {
        return a(g0VarArr, oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> d(Callable<? extends g0<? extends T>> callable) {
        h.a.y0.b.b.a(callable, "supplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.d0(callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> e(g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).d(h.a.y0.b.a.e(), g0VarArr.length);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static b0<Long> q(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new t3(Math.max(j2, 0L), timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c h(h.a.x0.g<? super T> gVar) {
        return i((h.a.x0.g) gVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> i(T t) {
        h.a.y0.b.b.a((Object) t, "item is null");
        return r(h.a.y0.b.a.c(t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> l(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new z0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> m(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> n(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, (g0) null, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<b0<T>> o(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), i.q2.t.m0.f12222b, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c p() {
        return h.a.c1.a.a(new l1(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> r(h.a.x0.o<? super Throwable, ? extends T> oVar) {
        h.a.y0.b.b.a(oVar, "valueSupplier is null");
        return h.a.c1.a.a(new a2(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> b(h.a.x0.o<? super Object[], ? extends R> oVar, int i2, g0<? extends T>... g0VarArr) {
        return b(g0VarArr, oVar, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends g0<? extends T>> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.d.v(g0Var, h.a.y0.b.a.e(), i2, h.a.y0.j.j.IMMEDIATE));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> e(g0<? extends g0<? extends T>> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new u0(g0Var, h.a.y0.b.a.e(), true, i2, L()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> f(g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(h.a.y0.b.a.e(), true, g0VarArr.length);
    }

    @h.a.t0.h("none")
    public final void g() {
        h.a.y0.e.d.l.a(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> h(T t) {
        h.a.y0.b.b.a((Object) t, "defaultItem is null");
        return h.a.c1.a.a(new s1(this, t));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T2> b0<T2> j() {
        return h.a.c1.a.a(new h.a.y0.e.d.g0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> k(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return h.a.c1.a.a(new g3(this, g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<b0<T>> m(g0<B> g0Var) {
        return b(g0Var, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> n(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, (g0) null, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> o(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, i.q2.t.m0.f12222b, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> p(h.a.x0.o<? super T, ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new u1(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.z0.a<T> v() {
        return b2.w(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, int i2, g0<? extends T>... g0VarArr) {
        return a(g0VarArr, oVar, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> b(g0<? extends T>[] g0VarArr, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(oVar, "combiner is null");
        if (g0VarArr.length == 0) {
            return M();
        }
        return h.a.c1.a.a(new h.a.y0.e.d.u(g0VarArr, null, oVar, i2 << 1, true));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static b0<Long> d(long j2, long j3, TimeUnit timeUnit) {
        return d(j2, j3, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> f(g0<? extends g0<? extends T>> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h3(g0Var, h.a.y0.b.a.e(), i2, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> g(h.a.x0.o<? super T, ? extends g0<U>> oVar) {
        h.a.y0.b.b.a(oVar, "itemDelay is null");
        return (b0<T>) j((h.a.x0.o) m1.c(oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> i(g0<U> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return h.a.c1.a.a(new d3(this, g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> j(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return b((h.a.x0.o) oVar, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> l(g0<U> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return h.a.c1.a.a(new m3(this, g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> u() {
        return h.a.c1.a.a(new h.a.y0.e.d.h0(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> v(h.a.x0.o<? super b0<Throwable>, ? extends g0<?>> oVar) {
        h.a.y0.b.b.a(oVar, "handler is null");
        return h.a.c1.a.a(new p2(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> a(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.d.u(null, iterable, oVar, i2 << 1, false));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static b0<Long> d(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new n1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> h(g0<U> g0Var) {
        h.a.y0.b.b.a(g0Var, "sampler is null");
        return h.a.c1.a.a(new r2(this, g0Var, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> j(T t) {
        h.a.y0.b.b.a((Object) t, "defaultItem is null");
        return h.a.c1.a.a(new z2(this, t));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> k(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> q() {
        return a((h.a.x0.r) h.a.y0.b.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> u(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar) {
        h.a.y0.b.b.a(oVar, "selector is null");
        return m2.a(m1.a(this), (h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        if (g0VarArr.length == 1) {
            return v(g0VarArr[0]);
        }
        return o(b((Object[]) g0VarArr));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> e(g0<? extends g0<? extends T>> g0Var, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(g0Var, "sources is null");
        return h.a.c1.a.a(new u3(g0Var, 16).j((h.a.x0.o) m1.f(oVar)));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> g(h.a.x0.g<? super h.a.u0.c> gVar) {
        return a(gVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c i(h.a.x0.g<? super T> gVar) {
        return a((h.a.x0.g) gVar, (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c, h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> k(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new p3(this, j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> l(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> q(h.a.x0.o<? super Throwable, ? extends g0<? extends T>> oVar) {
        h.a.y0.b.b.a(oVar, "resumeFunction is null");
        return h.a.c1.a.a(new z1(this, oVar, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T f() {
        T tC = B().c();
        if (tC != null) {
            return tC;
        }
        throw new NoSuchElementException();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> g(T t) {
        return a(0L, t);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10428m)
    public final b0<T> h(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.g(), false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> i(long j2, TimeUnit timeUnit) {
        return l((g0) q(j2, timeUnit));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> j(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return b(g0Var, this);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> l(long j2, TimeUnit timeUnit, j0 j0Var) {
        return f(j2, timeUnit, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> d(g0<? extends g0<? extends T>> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        return h.a.c1.a.a(new u0(g0Var, h.a.y0.b.a.e(), false, i2, L()));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> g(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "next is null");
        return h.a.c1.a.a(new z1(this, h.a.y0.b.a.c(g0Var), true));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> h(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> i(long j2, TimeUnit timeUnit, j0 j0Var) {
        return l((g0) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> a(g0<? extends T>[] g0VarArr, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(g0VarArr, "sources is null");
        if (g0VarArr.length == 0) {
            return M();
        }
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.d.u(g0VarArr, null, oVar, i2 << 1, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> b(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, int i2) {
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h.a.y0.e.d.u(null, iterable, oVar, i2 << 1, true));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> f(h.a.x0.o<? super T, ? extends g0<U>> oVar) {
        h.a.y0.b.b.a(oVar, "debounceSelector is null");
        return h.a.c1.a.a(new h.a.y0.e.d.b0(this, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> h(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new o3(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10428m)
    public final b0<T> j(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.g(), false, L());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> g(long j2, TimeUnit timeUnit) {
        return i((g0) q(j2, timeUnit));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> j(long j2, TimeUnit timeUnit, j0 j0Var) {
        return b(j2, timeUnit, j0Var, false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> b0<T> c(Callable<S> callable, h.a.x0.c<S, k<T>, S> cVar) {
        return a((Callable) callable, (h.a.x0.c) cVar, h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> d(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        return a(g0Var, g0Var2, h.a.y0.b.b.a(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> e() {
        return new h.a.y0.e.d.e(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(T t) {
        h.a.y0.b.b.a((Object) t, "defaultItem is null");
        return k((g0) l(t));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> g(long j2, TimeUnit timeUnit, j0 j0Var) {
        return i((g0) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> h(int i2) {
        return a(h.a.y0.b.a.g(), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), true, i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> d(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        return h.a.c1.a.a(new f4(null, iterable, oVar, L(), false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> e(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new z0(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> g(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h3(this, oVar, i2, true));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        if (g0VarArr.length == 1) {
            return v(g0VarArr[0]);
        }
        return h.a.c1.a.a(new h.a.y0.e.d.v(b((Object[]) g0VarArr), h.a.y0.b.a.e(), L(), h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(h.a.y0.b.a.e(), true, i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(h.a.x0.g<? super T> gVar) {
        h.a.x0.g<? super Throwable> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a((h.a.x0.g) gVar, gVarD, aVar, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2}).a(h.a.y0.b.a.e(), true, 2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> e(Object obj) {
        h.a.y0.b.b.a(obj, "element is null");
        return b((h.a.x0.r) h.a.y0.b.a.a(obj));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> b0<h.a.z0.b<K, T>> f(h.a.x0.o<? super T, ? extends K> oVar, boolean z) {
        return (b0<h.a.z0.b<K, T>>) a(oVar, h.a.y0.b.a.e(), z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), L(), g0Var, g0Var2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> d() {
        return new h.a.y0.e.d.c(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "next is null");
        return q(h.a.y0.b.a.c(g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T d(T t) {
        return j(t).d();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(h.a.x0.g<? super Throwable> gVar) {
        h.a.x0.g<? super T> gVarD = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return a((h.a.x0.g) gVarD, gVar, aVar, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3}).a(h.a.y0.b.a.e(), true, 3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> d(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a(oVar, Integer.MAX_VALUE, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onTerminate is null");
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.a(aVar), aVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> f(long j2, TimeUnit timeUnit) {
        return f(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), L(), g0Var, g0Var2, g0Var3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(T... tArr) {
        h.a.y0.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return M();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return h.a.c1.a.a(new a1(tArr));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> d(g0<U> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return h.a.c1.a.a(new h.a.y0.e.d.f0(this, g0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> f(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new q2(this, j2, timeUnit, j0Var, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> g(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new n3(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> d(long j2, TimeUnit timeUnit) {
        return d(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> c(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}).a(h.a.y0.b.a.e(), true, 4);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> d(long j2, TimeUnit timeUnit, j0 j0Var) {
        return d((g0) q(j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> e(h.a.x0.o<? super T, ? extends q0<? extends R>> oVar, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new y0(this, oVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new e3(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> g(int i2) {
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(new v3(this, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), L(), g0Var, g0Var2, g0Var3, g0Var4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> d(h.a.x0.a aVar) {
        return a(h.a.y0.b.a.d(), aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> d(h.a.x0.g<? super a0<T>> gVar) {
        h.a.y0.b.b.a(gVar, "consumer is null");
        return a((h.a.x0.g) h.a.y0.b.a.c((h.a.x0.g) gVar), (h.a.x0.g<? super Throwable>) h.a.y0.b.a.b((h.a.x0.g) gVar), h.a.y0.b.a.a((h.a.x0.g) gVar), h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return b(this, g0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> f(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h3(this, oVar, i2, false));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<b0<T>> g(long j2) {
        return a(j2, j2, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> b0<T> b(Callable<S> callable, h.a.x0.b<S, k<T>> bVar) {
        h.a.y0.b.b.a(bVar, "generator  is null");
        return a((Callable) callable, m1.a(bVar), h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> e(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return m2.a(m1.a(this, i2), (h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), false, i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T c() {
        h.a.y0.d.g gVar = new h.a.y0.d.g();
        subscribe(gVar);
        T tA = gVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(h.a.y0.b.a.e(), false, i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2}).a(h.a.y0.b.a.e(), false, 2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> d(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        return a((h.a.x0.o) oVar, false, i2, L());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final h.a.z0.a<T> e(long j2, TimeUnit timeUnit) {
        return e(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> d(h.a.x0.o<? super T, ? extends y<? extends R>> oVar, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new x0(this, oVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.z0.a<T> e(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(this, j2, timeUnit, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> c(T t) {
        return new h.a.y0.e.d.d(this, t);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new i3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3}).a(h.a.y0.b.a.e(), false, 3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(int i2) {
        return h.a.y0.e.d.r.a((b0) this, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c d(h.a.x0.r<? super T> rVar) {
        return a((h.a.x0.r) rVar, (h.a.x0.g<? super Throwable>) h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> c(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a((h.a.x0.o) oVar, L(), true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.z0.a<T> d(int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return m2.h(this, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(h.a.x0.r<? super Throwable> rVar) {
        return a(i.q2.t.m0.f12222b, rVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> f(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return h.a.c1.a.a(new k1(this));
        }
        if (i2 == 1) {
            return h.a.c1.a.a(new k3(this));
        }
        return h.a.c1.a.a(new j3(this, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> c(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return (b0<U>) a(m1.b(oVar), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(long j2) {
        if (j2 <= 0) {
            return h.a.c1.a.a(this);
        }
        return h.a.c1.a.a(new a3(this, j2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> d(long j2) {
        return a(j2, h.a.y0.b.a.b());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        return b((Object[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}).a(h.a.y0.b.a.e(), false, 4);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10428m)
    public final b0<T> d(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, h.a.e1.a.g(), z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> e(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return h.a.c1.a.a(this);
            }
            return h.a.c1.a.a(new b3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return a((g0) this, (g0) g0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> d(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return b(j2, timeUnit, j0Var, z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> f(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new w3(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> d(j0 j0Var) {
        return a(TimeUnit.MILLISECONDS, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> c(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<b0<T>> d(g0<U> g0Var, h.a.x0.o<? super U, ? extends g0<V>> oVar) {
        return a(g0Var, oVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <E extends i0<? super T>> E e(E e2) {
        subscribe(e2);
        return e2;
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> c(long j2, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, timeUnit, j0Var, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> e(j0 j0Var) {
        return b(TimeUnit.MILLISECONDS, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> b(Iterable<? extends g0<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), true, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onAfterNext is null");
        return h.a.c1.a.a(new h.a.y0.e.d.k0(this, gVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static b0<Integer> b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        }
        if (i3 == 0) {
            return M();
        }
        if (i3 == 1) {
            return l(Integer.valueOf(i2));
        }
        if (((long) i2) + ((long) (i3 - 1)) <= 2147483647L) {
            return h.a.c1.a.a(new d2(i2, i3));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(h.a.x0.a aVar) {
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.d(), aVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new t0(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final c c(h.a.x0.o<? super T, ? extends i> oVar, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return h.a.c1.a.a(new w0(this, oVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static b0<Long> b(long j2, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return M();
        }
        if (j3 == 1) {
            return l(Long.valueOf(j2));
        }
        long j4 = (j3 - 1) + j2;
        if (j2 > 0 && j4 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        return h.a.c1.a.a(new e2(j2, j3));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> c(long j2) {
        if (j2 >= 0) {
            if (j2 == 0) {
                return M();
            }
            return h.a.c1.a.a(new j2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        h.a.y0.b.b.a(g0Var8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8);
    }

    @h.a.t0.h("none")
    public final void c(i0<? super T> i0Var) {
        h.a.y0.b.b.a(i0Var, "s is null");
        if (i0Var instanceof h.a.a1.l) {
            subscribe(i0Var);
        } else {
            subscribe(new h.a.a1.l(i0Var));
        }
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), false, L(), g0Var, g0Var2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, h.a.x0.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        return a(h.a.y0.b.a.a((h.a.x0.h) hVar), false, L(), g0Var, g0Var2, g0Var3);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10428m)
    public final b0<T> c(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.g(), z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> c(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        return a(j2, timeUnit, j0Var, z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> c(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new f3(this, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g0<? extends T9> g0Var9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        h.a.y0.b.b.a(g0Var8, "source8 is null");
        h.a.y0.b.b.a(g0Var9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, h.a.x0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        return a(h.a.y0.b.a.a((h.a.x0.i) iVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<T> c(g0<U> g0Var, h.a.x0.o<? super T, ? extends g0<V>> oVar) {
        h.a.y0.b.b.a(g0Var, "firstTimeoutIndicator is null");
        return b(g0Var, oVar, (g0) null);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, (Callable) h.a.y0.j.m.asCallable(), (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, h.a.x0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        return a(h.a.y0.b.a.a((h.a.x0.j) jVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> c(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, (Callable) callable, (h.a.x0.o) h.a.y0.j.b.asFunction());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<b0<T>> c(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, h.a.e1.a.a(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> c(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<b0<T>> c(Callable<? extends g0<B>> callable) {
        return a(callable, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return b(g0Var, g0Var2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, h.a.x0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        return a(h.a.y0.b.a.a((h.a.x0.k) kVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        return b(g0Var, g0Var2, g0Var3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        return b(g0Var, g0Var2, g0Var3, g0Var4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, h.a.x0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        return a(h.a.y0.b.a.a((h.a.x0.l) lVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(int i2, int i3, g0<? extends T>... g0VarArr) {
        return b((Object[]) g0VarArr).a(h.a.y0.b.a.e(), i2, i3, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends g0<? extends T>> g0Var, int i2, boolean z) {
        h.a.y0.b.b.a(g0Var, "sources is null");
        h.a.y0.b.b.a(i2, "prefetch is null");
        return h.a.c1.a.a(new h.a.y0.e.d.v(g0Var, h.a.y0.b.a.e(), i2, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(g0<? extends g0<? extends T>> g0Var, int i2, int i3) {
        h.a.y0.b.b.a(Integer.valueOf(i2), "maxConcurrency is null");
        h.a.y0.b.b.a(Integer.valueOf(i3), "prefetch is null");
        return v(g0Var).a(h.a.y0.b.a.e(), i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, h.a.x0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        h.a.y0.b.b.a(g0Var8, "source8 is null");
        return a(h.a.y0.b.a.a((h.a.x0.m) mVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(Iterable<? extends g0<? extends T>> iterable, int i2, int i3) {
        h.a.y0.b.b.a(Integer.valueOf(i2), "maxConcurrency is null");
        h.a.y0.b.b.a(Integer.valueOf(i3), "prefetch is null");
        return f((Iterable) iterable).a(h.a.y0.b.a.e(), i2, i3, false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(e0<T> e0Var) {
        h.a.y0.b.b.a(e0Var, "source is null");
        return h.a.c1.a.a(new h.a.y0.e.d.a0(e0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(Throwable th) {
        h.a.y0.b.b.a(th, "e is null");
        return e((Callable<? extends Throwable>) h.a.y0.b.a.b(th));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(Future<? extends T> future) {
        h.a.y0.b.b.a(future, "future is null");
        return h.a.c1.a.a(new c1(future, 0L, null));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b0<R> b(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g0<? extends T9> g0Var9, h.a.x0.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(g0Var3, "source3 is null");
        h.a.y0.b.b.a(g0Var4, "source4 is null");
        h.a.y0.b.b.a(g0Var5, "source5 is null");
        h.a.y0.b.b.a(g0Var6, "source6 is null");
        h.a.y0.b.b.a(g0Var7, "source7 is null");
        h.a.y0.b.b.a(g0Var8, "source8 is null");
        h.a.y0.b.b.a(g0Var9, "source9 is null");
        return a(h.a.y0.b.a.a((h.a.x0.n) nVar), false, L(), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        h.a.y0.b.b.a(future, "future is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        return h.a.c1.a.a(new c1(future, j2, timeUnit));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> b0<T> a(Future<? extends T> future, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return a(future, j2, timeUnit).c(j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static <T> b0<T> a(Future<? extends T> future, j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return a((Future) future).c(j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> b(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.d.j(this, rVar));
    }

    @h.a.t0.b(h.a.t0.a.UNBOUNDED_IN)
    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(j.d.b<? extends T> bVar) {
        h.a.y0.b.b.a(bVar, "publisher is null");
        return h.a.c1.a.a(new e1(bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> b() {
        return a(L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> b0<T> a(Callable<S> callable, h.a.x0.b<S, k<T>> bVar, h.a.x0.g<? super S> gVar) {
        h.a.y0.b.b.a(bVar, "generator  is null");
        return a((Callable) callable, m1.a(bVar), (h.a.x0.g) gVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T b(T t) {
        h.a.y0.d.g gVar = new h.a.y0.d.g();
        subscribe(gVar);
        T tA = gVar.a();
        return tA != null ? tA : t;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, S> b0<T> a(Callable<S> callable, h.a.x0.c<S, k<T>, S> cVar, h.a.x0.g<? super S> gVar) {
        h.a.y0.b.b.a(callable, "initialState is null");
        h.a.y0.b.b.a(cVar, "generator  is null");
        h.a.y0.b.b.a(gVar, "disposeState is null");
        return h.a.c1.a.a(new g1(callable, cVar, gVar));
    }

    @h.a.t0.h("none")
    public final void b(h.a.x0.g<? super T> gVar) {
        h.a.y0.e.d.l.a(this, gVar, h.a.y0.b.a.f10450f, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<List<T>> b(int i2) {
        return a(i2, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<List<T>> b(g0<B> g0Var) {
        return (b0<List<T>>) a((g0) g0Var, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public static b0<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return a(j2, j3, j4, j5, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final c b(h.a.x0.o<? super T, ? extends i> oVar) {
        return b(oVar, 2);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public static b0<Long> a(long j2, long j3, long j4, long j5, TimeUnit timeUnit, j0 j0Var) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return M().c(j4, timeUnit, j0Var);
        }
        long j6 = j2 + (j3 - 1);
        if (j2 > 0 && j6 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new o1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final c b(h.a.x0.o<? super T, ? extends i> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(new h.a.y0.e.d.w(this, oVar, i2));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.d.c0(this, j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        return b(t, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<T> b(g0<U> g0Var, h.a.x0.o<? super T, ? extends g0<V>> oVar) {
        return d((g0) g0Var).g((h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> b(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return h.a.c1.a.a(new h.a.y0.e.d.l0(this, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        return b(t, t2, t3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> b(i0<? super T> i0Var) {
        h.a.y0.b.b.a(i0Var, "observer is null");
        return a((h.a.x0.g) m1.c(i0Var), (h.a.x0.g<? super Throwable>) m1.b(i0Var), m1.a(i0Var), h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        return b(t, t2, t3, t4);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> b(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new h.a.y0.e.d.q0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> b(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z) {
        return a(oVar, z, Integer.MAX_VALUE);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        return b(t, t2, t3, t4, t5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<V> b(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return (b0<V>) a((h.a.x0.o) m1.b(oVar), (h.a.x0.c) cVar, false, L(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> b0<R> b(g0<? extends TRight> g0Var, h.a.x0.o<? super T, ? extends g0<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends g0<TRightEnd>> oVar2, h.a.x0.c<? super T, ? super TRight, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "other is null");
        h.a.y0.b.b.a(oVar, "leftEnd is null");
        h.a.y0.b.b.a(oVar2, "rightEnd is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return h.a.c1.a.a(new p1(this, g0Var, oVar, oVar2, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        return b(t, t2, t3, t4, t5, t6);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> b(Class<U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return c((h.a.x0.r) h.a.y0.b.a.b((Class) cls)).a((Class) cls);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.z0.a<T> b(j0 j0Var) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a((h.a.z0.a) x(), j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> b(h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        h.a.y0.b.b.a(dVar, "predicate is null");
        return h.a.c1.a.a(new n2(this, dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        return b(t, t2, t3, t4, t5, t6, t7);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> b(h.a.x0.e eVar) {
        h.a.y0.b.b.a(eVar, "stop is null");
        return a(i.q2.t.m0.f12222b, h.a.y0.b.a.a(eVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> b(long j2, TimeUnit timeUnit, boolean z) {
        return b(j2, timeUnit, h.a.e1.a.a(), z);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new q2(this, j2, timeUnit, j0Var, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> b(h.a.x0.c<T, T, T> cVar) {
        h.a.y0.b.b.a(cVar, "accumulator is null");
        return h.a.c1.a.a(new t2(this, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> b(R r, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(r, "seed is null");
        return b((Callable) h.a.y0.b.a.b(r), (h.a.x0.c) cVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> b(Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(callable, "seedSupplier is null");
        h.a.y0.b.b.a(cVar, "accumulator is null");
        return h.a.c1.a.a(new u2(this, callable, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c b(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        return a((h.a.x0.g) gVar, gVar2, h.a.y0.b.a.f10447c, h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c b(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        return a((h.a.x0.g) gVar, gVar2, aVar, h.a.y0.b.a.d());
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10428m)
    public final b0<T> b(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, h.a.e1.a.g(), false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        h.a.y0.b.b.a((Object) t, "The first item is null");
        h.a.y0.b.b.a((Object) t2, "The second item is null");
        h.a.y0.b.b.a((Object) t3, "The third item is null");
        h.a.y0.b.b.a((Object) t4, "The fourth item is null");
        h.a.y0.b.b.a((Object) t5, "The fifth item is null");
        h.a.y0.b.b.a((Object) t6, "The sixth item is null");
        h.a.y0.b.b.a((Object) t7, "The seventh item is null");
        h.a.y0.b.b.a((Object) t8, "The eighth item is null");
        h.a.y0.b.b.a((Object) t9, "The ninth item is null");
        return b(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> b(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return a(j2, j3, timeUnit, j0Var, false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> b(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        return a(i.q2.t.m0.f12222b, j2, timeUnit, j0Var, z, i2);
    }

    private <U, V> b0<T> b(g0<U> g0Var, h.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var2) {
        h.a.y0.b.b.a(oVar, "itemTimeoutIndicator is null");
        return h.a.c1.a.a(new r3(this, g0Var, oVar, g0Var2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> b(TimeUnit timeUnit) {
        return b(timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> b(TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return (b0<h.a.e1.c<T>>) p(h.a.y0.b.a.a(timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> k0<U> b(Callable<U> callable) {
        h.a.y0.b.b.a(callable, "collectionSupplier is null");
        return h.a.c1.a.a(new v3(this, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        return (k0<Map<K, V>>) a((Callable) h.a.y0.j.m.asCallable(), (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, V>> b(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        h.a.y0.b.b.a(callable, "mapSupplier is null");
        return (k0<Map<K, V>>) a((Callable) callable, (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> b(Comparator<? super T> comparator) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) J().h(h.a.y0.b.a.a((Comparator) comparator));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<b0<T>> b(g0<B> g0Var, int i2) {
        h.a.y0.b.b.a(g0Var, "boundary is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new z3(this, g0Var, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> b0<T> a(Iterable<? extends g0<? extends T>> iterable, int i2) {
        return f((Iterable) iterable).d(h.a.y0.b.a.e(), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, h.a.x0.d<? super T, ? super T> dVar) {
        return a(g0Var, g0Var2, dVar, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> b(g0<? extends U> g0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return b(this, g0Var, cVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, h.a.x0.d<? super T, ? super T> dVar, int i2) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        h.a.y0.b.b.a(dVar, "isEqual is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new w2(g0Var, g0Var2, dVar, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T> k0<Boolean> a(g0<? extends T> g0Var, g0<? extends T> g0Var2, int i2) {
        return a(g0Var, g0Var2, h.a.y0.b.b.a(), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> b0<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends g0<? extends T>> oVar, h.a.x0.g<? super D> gVar) {
        return a((Callable) callable, (h.a.x0.o) oVar, (h.a.x0.g) gVar, true);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, D> b0<T> a(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends g0<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        h.a.y0.b.b.a(callable, "resourceSupplier is null");
        h.a.y0.b.b.a(oVar, "sourceSupplier is null");
        h.a.y0.b.b.a(gVar, "disposer is null");
        return h.a.c1.a.a(new x3(callable, oVar, gVar, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), z, L(), g0Var, g0Var2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T1, T2, R> b0<R> a(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, h.a.x0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        h.a.y0.b.b.a(g0Var, "source1 is null");
        h.a.y0.b.b.a(g0Var2, "source2 is null");
        return a(h.a.y0.b.a.a((h.a.x0.c) cVar), z, i2, g0Var, g0Var2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> a(h.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2, g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return M();
        }
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new f4(g0VarArr, null, oVar, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public static <T, R> b0<R> a(Iterable<? extends g0<? extends T>> iterable, h.a.x0.o<? super Object[], ? extends R> oVar, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "zipper is null");
        h.a.y0.b.b.a(iterable, "sources is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new f4(null, iterable, oVar, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<Boolean> a(h.a.x0.r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate is null");
        return h.a.c1.a.a(new h.a.y0.e.d.g(this, rVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return a(this, g0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    @h.a.t0.e
    public final <R> R a(@h.a.t0.f c0<T, ? extends R> c0Var) {
        return (R) ((c0) h.a.y0.b.b.a(c0Var, "converter is null")).a(this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T a() {
        h.a.y0.d.f fVar = new h.a.y0.d.f();
        subscribe(fVar);
        T tA = fVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final T a(T t) {
        h.a.y0.d.f fVar = new h.a.y0.d.f();
        subscribe(fVar);
        T tA = fVar.a();
        return tA != null ? tA : t;
    }

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

    @h.a.t0.d
    @h.a.t0.h("none")
    public final Iterable<T> a(int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return new h.a.y0.e.d.b(this, i2);
    }

    @h.a.t0.h("none")
    public final void a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        h.a.y0.e.d.l.a(this, gVar, gVar2, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.h("none")
    public final void a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        h.a.y0.e.d.l.a(this, gVar, gVar2, aVar);
    }

    @h.a.t0.h("none")
    public final void a(i0<? super T> i0Var) {
        h.a.y0.e.d.l.a(this, i0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<List<T>> a(int i2, int i3) {
        return (b0<List<T>>) a(i2, i3, h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> b0<U> a(int i2, int i3, Callable<U> callable) {
        h.a.y0.b.b.a(i2, "count");
        h.a.y0.b.b.a(i3, "skip");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.m(this, i2, i3, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U extends Collection<? super T>> b0<U> a(int i2, Callable<U> callable) {
        return a(i2, i2, callable);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<List<T>> a(long j2, long j3, TimeUnit timeUnit) {
        return (b0<List<T>>) a(j2, j3, timeUnit, h.a.e1.a.a(), h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<List<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var) {
        return (b0<List<T>>) a(j2, j3, timeUnit, j0Var, h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <U extends Collection<? super T>> b0<U> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, Callable<U> callable) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.q(this, j2, j3, timeUnit, j0Var, callable, Integer.MAX_VALUE, false));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<List<T>> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, h.a.e1.a.a(), Integer.MAX_VALUE);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, int i2) {
        return a(j2, timeUnit, h.a.e1.a.a(), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return (b0<List<T>>) a(j2, timeUnit, j0Var, i2, (Callable) h.a.y0.j.b.asCallable(), false);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <U extends Collection<? super T>> b0<U> a(long j2, TimeUnit timeUnit, j0 j0Var, int i2, Callable<U> callable, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        h.a.y0.b.b.a(i2, "count");
        return h.a.c1.a.a(new h.a.y0.e.d.q(this, j2, j2, timeUnit, j0Var, callable, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<List<T>> a(long j2, TimeUnit timeUnit, j0 j0Var) {
        return (b0<List<T>>) a(j2, timeUnit, j0Var, Integer.MAX_VALUE, (Callable) h.a.y0.j.b.asCallable(), false);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TOpening, TClosing> b0<List<T>> a(g0<? extends TOpening> g0Var, h.a.x0.o<? super TOpening, ? extends g0<? extends TClosing>> oVar) {
        return (b0<List<T>>) a((g0) g0Var, (h.a.x0.o) oVar, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> b0<U> a(g0<? extends TOpening> g0Var, h.a.x0.o<? super TOpening, ? extends g0<? extends TClosing>> oVar, Callable<U> callable) {
        h.a.y0.b.b.a(g0Var, "openingIndicator is null");
        h.a.y0.b.b.a(oVar, "closingIndicator is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.n(this, g0Var, oVar, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<List<T>> a(g0<B> g0Var, int i2) {
        h.a.y0.b.b.a(i2, "initialCapacity");
        return (b0<List<T>>) a((g0) g0Var, (Callable) h.a.y0.b.a.a(i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B, U extends Collection<? super T>> b0<U> a(g0<B> g0Var, Callable<U> callable) {
        h.a.y0.b.b.a(g0Var, "boundary is null");
        h.a.y0.b.b.a(callable, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.p(this, g0Var, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<List<T>> a(Callable<? extends g0<B>> callable) {
        return (b0<List<T>>) a((Callable) callable, (Callable) h.a.y0.j.b.asCallable());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B, U extends Collection<? super T>> b0<U> a(Callable<? extends g0<B>> callable, Callable<U> callable2) {
        h.a.y0.b.b.a(callable, "boundarySupplier is null");
        h.a.y0.b.b.a(callable2, "bufferSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.o(this, callable, callable2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<U> a(Class<U> cls) {
        h.a.y0.b.b.a(cls, "clazz is null");
        return (b0<U>) p(h.a.y0.b.a.a((Class) cls));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<U> a(Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        h.a.y0.b.b.a(callable, "initialValueSupplier is null");
        h.a.y0.b.b.a(bVar, "collector is null");
        return h.a.c1.a.a(new h.a.y0.e.d.t(this, callable, bVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> k0<U> a(U u, h.a.x0.b<? super U, ? super T> bVar) {
        h.a.y0.b.b.a(u, "initialValue is null");
        return a((Callable) h.a.y0.b.a.b(u), (h.a.x0.b) bVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h0<? super T, ? extends R> h0Var) {
        return v(((h0) h.a.y0.b.b.a(h0Var, "composer is null")).a(this));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar) {
        return a(oVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h.a.y0.e.d.v(this, oVar, i2, h.a.y0.j.j.IMMEDIATE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return h.a.c1.a.a(new h.a.y0.e.d.v(this, oVar, i2, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.d.x(this, oVar, h.a.y0.j.j.IMMEDIATE, i2, i3));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z) {
        return a(oVar, Integer.MAX_VALUE, L(), z);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, int i2, int i3, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.d.x(this, oVar, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY, i2, i3));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> a(long j2, TimeUnit timeUnit, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), z);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new h.a.y0.e.d.e0(this, j2, timeUnit, j0Var, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K> b0<T> a(h.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(callable, "collectionSupplier is null");
        return h.a.c1.a.a(new h.a.y0.e.d.i0(this, oVar, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(h.a.x0.d<? super T, ? super T> dVar) {
        h.a.y0.b.b.a(dVar, "comparer is null");
        return h.a.c1.a.a(new h.a.y0.e.d.j0(this, h.a.y0.b.a.e(), dVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onFinally is null");
        return a((h.a.x0.g) h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.f10447c, aVar);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    private b0<T> a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.b.b.a(aVar2, "onAfterTerminate is null");
        return h.a.c1.a.a(new h.a.y0.e.d.m0(this, gVar, gVar2, aVar, aVar2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.a aVar) {
        h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.y0.b.b.a(aVar, "onDispose is null");
        return h.a.c1.a.a(new h.a.y0.e.d.n0(this, gVar, aVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(long j2) {
        if (j2 >= 0) {
            return h.a.c1.a.a(new h.a.y0.e.d.p0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<T> a(long j2, T t) {
        if (j2 >= 0) {
            h.a.y0.b.b.a((Object) t, "defaultItem is null");
            return h.a.c1.a.a(new h.a.y0.e.d.q0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, L());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, boolean z, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "bufferSize");
        if (this instanceof h.a.y0.c.m) {
            Object objCall = ((h.a.y0.c.m) this).call();
            if (objCall == null) {
                return M();
            }
            return s2.a(objCall, oVar);
        }
        return h.a.c1.a.a(new u0(this, oVar, z, i2, i3));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends g0<? extends R>> oVar2, Callable<? extends g0<? extends R>> callable) {
        h.a.y0.b.b.a(oVar, "onNextMapper is null");
        h.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        h.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return q(new v1(this, oVar, oVar2, callable));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends R>> oVar, h.a.x0.o<Throwable, ? extends g0<? extends R>> oVar2, Callable<? extends g0<? extends R>> callable, int i2) {
        h.a.y0.b.b.a(oVar, "onNextMapper is null");
        h.a.y0.b.b.a(oVar2, "onErrorMapper is null");
        h.a.y0.b.b.a(callable, "onCompleteSupplier is null");
        return d(new v1(this, oVar, oVar2, callable), i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return a((h.a.x0.o) oVar, (h.a.x0.c) cVar, false, L(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(oVar, cVar, z, L(), L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(oVar, cVar, z, i2, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(cVar, "combiner is null");
        return a(m1.a(oVar, cVar), z, i2, i3);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(h.a.x0.o<? super T, ? extends g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return a((h.a.x0.o) oVar, (h.a.x0.c) cVar, false, i2, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar) {
        return a((h.a.x0.r) rVar, gVar, h.a.y0.b.a.f10447c);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar, h.a.x0.a aVar) {
        h.a.y0.b.b.a(rVar, "onNext is null");
        h.a.y0.b.b.a(gVar, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.d.p pVar = new h.a.y0.d.p(rVar, gVar, aVar);
        subscribe(pVar);
        return pVar;
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> b0<h.a.z0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        return a((h.a.x0.o) oVar, (h.a.x0.o) oVar2, false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> b0<h.a.z0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, boolean z) {
        return a(oVar, oVar2, z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> b0<h.a.z0.b<K, V>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, boolean z, int i2) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new h1(this, oVar, oVar2, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <TRight, TLeftEnd, TRightEnd, R> b0<R> a(g0<? extends TRight> g0Var, h.a.x0.o<? super T, ? extends g0<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends g0<TRightEnd>> oVar2, h.a.x0.c<? super T, ? super b0<TRight>, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "other is null");
        h.a.y0.b.b.a(oVar, "leftEnd is null");
        h.a.y0.b.b.a(oVar2, "rightEnd is null");
        h.a.y0.b.b.a(cVar, "resultSelector is null");
        return h.a.c1.a.a(new i1(this, g0Var, oVar, oVar2, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(f0<? extends R, ? super T> f0Var) {
        h.a.y0.b.b.a(f0Var, "onLift is null");
        return h.a.c1.a.a(new t1(this, f0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(j0 j0Var) {
        return a(j0Var, false, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(j0 j0Var, boolean z) {
        return a(j0Var, z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new y1(this, j0Var, z, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final s<T> a(h.a.x0.c<T, T, T> cVar) {
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new f2(this, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(R r, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(r, "seed is null");
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new g2(this, r, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> k0<R> a(Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(callable, "seedSupplier is null");
        h.a.y0.b.b.a(cVar, "reducer is null");
        return h.a.c1.a.a(new h2(this, callable, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(h.a.x0.e eVar) {
        h.a.y0.b.b.a(eVar, "stop is null");
        return h.a.c1.a.a(new k2(this, eVar));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, long j2, TimeUnit timeUnit) {
        return a(oVar, i2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this, i2, j2, timeUnit, j0Var), (h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, int i2, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return m2.a(m1.a(this, i2), m1.a(oVar, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, long j2, TimeUnit timeUnit) {
        return a(oVar, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this, j2, timeUnit, j0Var), (h.a.x0.o) oVar);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final <R> b0<R> a(h.a.x0.o<? super b0<T>, ? extends g0<R>> oVar, j0 j0Var) {
        h.a.y0.b.b.a(oVar, "selector is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(m1.a(this), m1.a(oVar, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final h.a.z0.a<T> a(int i2, long j2, TimeUnit timeUnit) {
        return a(i2, j2, timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.z0.a<T> a(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return m2.a(this, j2, timeUnit, j0Var, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final h.a.z0.a<T> a(int i2, j0 j0Var) {
        h.a.y0.b.b.a(i2, "bufferSize");
        return m2.a((h.a.z0.a) d(i2), j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(long j2, h.a.x0.r<? super Throwable> rVar) {
        if (j2 >= 0) {
            h.a.y0.b.b.a(rVar, "predicate is null");
            return h.a.c1.a.a(new o2(this, j2, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U> b0<T> a(g0<U> g0Var, boolean z) {
        h.a.y0.b.b.a(g0Var, "sampler is null");
        return h.a.c1.a.a(new r2(this, g0Var, z));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new c3(this, j2, timeUnit, j0Var, i2 << 1, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(Comparator<? super T> comparator) {
        h.a.y0.b.b.a(comparator, "sortFunction is null");
        return J().p().p(h.a.y0.b.a.a((Comparator) comparator)).l((h.a.x0.o<? super R, ? extends Iterable<? extends U>>) h.a.y0.b.a.e());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(Iterable<? extends T> iterable) {
        return b(f((Iterable) iterable), this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<T> a(T... tArr) {
        b0 b0VarB = b((Object[]) tArr);
        if (b0VarB == M()) {
            return h.a.c1.a.a(this);
        }
        return b(b0VarB, this);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.u0.c a(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.g<? super h.a.u0.c> gVar3) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        h.a.y0.b.b.a(gVar3, "onSubscribe is null");
        h.a.y0.d.v vVar = new h.a.y0.d.v(gVar, gVar2, aVar, gVar3);
        subscribe(vVar);
        return vVar;
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, boolean z, int i2) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        if (j2 >= 0) {
            return h.a.c1.a.a(new l3(this, j2, j3, timeUnit, j0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> a(TimeUnit timeUnit) {
        return a(timeUnit, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<h.a.e1.c<T>> a(TimeUnit timeUnit, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new q3(this, timeUnit, j0Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <V> b0<T> a(h.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return b((g0) null, oVar, g0Var);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<T> a(long j2, TimeUnit timeUnit, g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return a(j2, timeUnit, g0Var, h.a.e1.a.a());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<T> a(long j2, TimeUnit timeUnit, j0 j0Var, g0<? extends T> g0Var) {
        h.a.y0.b.b.a(g0Var, "other is null");
        return a(j2, timeUnit, g0Var, j0Var);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<T> a(g0<U> g0Var, h.a.x0.o<? super T, ? extends g0<V>> oVar, g0<? extends T> g0Var2) {
        h.a.y0.b.b.a(g0Var, "firstTimeoutIndicator is null");
        h.a.y0.b.b.a(g0Var2, "other is null");
        return b(g0Var, oVar, g0Var2);
    }

    private b0<T> a(long j2, TimeUnit timeUnit, g0<? extends T> g0Var, j0 j0Var) {
        h.a.y0.b.b.a(timeUnit, "timeUnit is null");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        return h.a.c1.a.a(new s3(this, j2, timeUnit, j0Var, g0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <K, V> k0<Map<K, Collection<V>>> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, h.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        h.a.y0.b.b.a(oVar, "keySelector is null");
        h.a.y0.b.b.a(oVar2, "valueSelector is null");
        h.a.y0.b.b.a(callable, "mapSupplier is null");
        h.a.y0.b.b.a(oVar3, "collectionFactory is null");
        return (k0<Map<K, Collection<V>>>) a((Callable) callable, (h.a.x0.b) h.a.y0.b.a.a(oVar, oVar2, oVar3));
    }

    @h.a.t0.b(h.a.t0.a.SPECIAL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> a(b bVar) {
        h.a.y0.e.b.h1 h1Var = new h.a.y0.e.b.h1(this);
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            return h1Var.v();
        }
        if (i2 == 2) {
            return h1Var.w();
        }
        if (i2 == 3) {
            return h1Var;
        }
        if (i2 != 4) {
            return h1Var.u();
        }
        return h.a.c1.a.a(new h.a.y0.e.b.h2(h1Var));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final k0<List<T>> a(Comparator<? super T> comparator, int i2) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        return (k0<List<T>>) g(i2).h(h.a.y0.b.a.a((Comparator) comparator));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<b0<T>> a(long j2, long j3) {
        return a(j2, j3, L());
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final b0<b0<T>> a(long j2, long j3, int i2) {
        h.a.y0.b.b.a(j2, "count");
        h.a.y0.b.b.a(j3, "skip");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new y3(this, j2, j3, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, long j3, TimeUnit timeUnit, j0 j0Var, int i2) {
        h.a.y0.b.b.a(j2, "timespan");
        h.a.y0.b.b.a(j3, "timeskip");
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        return h.a.c1.a.a(new c4(this, j2, j3, timeUnit, j0Var, i.q2.t.m0.f12222b, i2, false));
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, long j3) {
        return a(j2, timeUnit, h.a.e1.a.a(), j3, false);
    }

    @h.a.t0.d
    @h.a.t0.h(h.a.t0.h.f10425j)
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return a(j2, timeUnit, h.a.e1.a.a(), j3, z);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3) {
        return a(j2, timeUnit, j0Var, j3, false);
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z) {
        return a(j2, timeUnit, j0Var, j3, z, L());
    }

    @h.a.t0.d
    @h.a.t0.h("custom")
    public final b0<b0<T>> a(long j2, TimeUnit timeUnit, j0 j0Var, long j3, boolean z, int i2) {
        h.a.y0.b.b.a(i2, "bufferSize");
        h.a.y0.b.b.a(j0Var, "scheduler is null");
        h.a.y0.b.b.a(timeUnit, "unit is null");
        h.a.y0.b.b.a(j3, "count");
        return h.a.c1.a.a(new c4(this, j2, j2, timeUnit, j0Var, j3, i2, z));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, V> b0<b0<T>> a(g0<U> g0Var, h.a.x0.o<? super U, ? extends g0<V>> oVar, int i2) {
        h.a.y0.b.b.a(g0Var, "openingIndicator is null");
        h.a.y0.b.b.a(oVar, "closingIndicator is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new a4(this, g0Var, oVar, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <B> b0<b0<T>> a(Callable<? extends g0<B>> callable, int i2) {
        h.a.y0.b.b.a(callable, "boundary is null");
        h.a.y0.b.b.a(i2, "bufferSize");
        return h.a.c1.a.a(new b4(this, callable, i2));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(g0Var, "other is null");
        h.a.y0.b.b.a(cVar, "combiner is null");
        return h.a.c1.a.a(new d4(this, cVar, g0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, h.a.x0.h<? super T, ? super T1, ? super T2, R> hVar) {
        h.a.y0.b.b.a(g0Var, "o1 is null");
        h.a.y0.b.b.a(g0Var2, "o2 is null");
        h.a.y0.b.b.a(hVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2}, h.a.y0.b.a.a((h.a.x0.h) hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, T3, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, g0<T3> g0Var3, h.a.x0.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        h.a.y0.b.b.a(g0Var, "o1 is null");
        h.a.y0.b.b.a(g0Var2, "o2 is null");
        h.a.y0.b.b.a(g0Var3, "o3 is null");
        h.a.y0.b.b.a(iVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2, g0Var3}, h.a.y0.b.a.a((h.a.x0.i) iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.a.t0.d
    @h.a.t0.h("none")
    public final <T1, T2, T3, T4, R> b0<R> a(g0<T1> g0Var, g0<T2> g0Var2, g0<T3> g0Var3, g0<T4> g0Var4, h.a.x0.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        h.a.y0.b.b.a(g0Var, "o1 is null");
        h.a.y0.b.b.a(g0Var2, "o2 is null");
        h.a.y0.b.b.a(g0Var3, "o3 is null");
        h.a.y0.b.b.a(g0Var4, "o4 is null");
        h.a.y0.b.b.a(jVar, "combiner is null");
        return a((g0<?>[]) new g0[]{g0Var, g0Var2, g0Var3, g0Var4}, h.a.y0.b.a.a((h.a.x0.j) jVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(g0<?>[] g0VarArr, h.a.x0.o<? super Object[], R> oVar) {
        h.a.y0.b.b.a(g0VarArr, "others is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        return h.a.c1.a.a(new e4(this, g0VarArr, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <R> b0<R> a(Iterable<? extends g0<?>> iterable, h.a.x0.o<? super Object[], R> oVar) {
        h.a.y0.b.b.a(iterable, "others is null");
        h.a.y0.b.b.a(oVar, "combiner is null");
        return h.a.c1.a.a(new e4(this, iterable, oVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(Iterable<U> iterable, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        h.a.y0.b.b.a(iterable, "other is null");
        h.a.y0.b.b.a(cVar, "zipper is null");
        return h.a.c1.a.a(new g4(this, iterable, cVar));
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return a(this, g0Var, cVar, z);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final <U, R> b0<R> a(g0<? extends U> g0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return a(this, g0Var, cVar, z, i2);
    }

    @h.a.t0.d
    @h.a.t0.h("none")
    public final h.a.a1.n<T> a(boolean z) {
        h.a.a1.n<T> nVar = new h.a.a1.n<>();
        if (z) {
            nVar.dispose();
        }
        subscribe(nVar);
        return nVar;
    }
}
