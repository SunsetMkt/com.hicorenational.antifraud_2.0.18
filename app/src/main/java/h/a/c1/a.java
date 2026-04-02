package h.a.c1;

import h.a.b0;
import h.a.b1.b;
import h.a.c;
import h.a.f;
import h.a.i0;
import h.a.j0;
import h.a.k0;
import h.a.l;
import h.a.n0;
import h.a.s;
import h.a.t0.g;
import h.a.v;
import h.a.v0.d;
import h.a.x0.e;
import h.a.x0.o;
import h.a.y0.g.h;
import h.a.y0.g.q;
import h.a.y0.j.k;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    @g
    static volatile h.a.x0.g<? super Throwable> a;

    /* JADX INFO: renamed from: b */
    @g
    static volatile o<? super Runnable, ? extends Runnable> f10252b;

    /* JADX INFO: renamed from: c */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f10253c;

    /* JADX INFO: renamed from: d */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f10254d;

    /* JADX INFO: renamed from: e */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f10255e;

    /* JADX INFO: renamed from: f */
    @g
    static volatile o<? super Callable<j0>, ? extends j0> f10256f;

    /* JADX INFO: renamed from: g */
    @g
    static volatile o<? super j0, ? extends j0> f10257g;

    /* JADX INFO: renamed from: h */
    @g
    static volatile o<? super j0, ? extends j0> f10258h;

    /* JADX INFO: renamed from: i */
    @g
    static volatile o<? super j0, ? extends j0> f10259i;

    /* JADX INFO: renamed from: j */
    @g
    static volatile o<? super j0, ? extends j0> f10260j;

    /* JADX INFO: renamed from: k */
    @g
    static volatile o<? super l, ? extends l> f10261k;

    /* JADX INFO: renamed from: l */
    @g
    static volatile o<? super h.a.w0.a, ? extends h.a.w0.a> f10262l;

    /* JADX INFO: renamed from: m */
    @g
    static volatile o<? super b0, ? extends b0> f10263m;

    /* JADX INFO: renamed from: n */
    @g
    static volatile o<? super h.a.z0.a, ? extends h.a.z0.a> f10264n;

    @g
    static volatile o<? super s, ? extends s> o;

    @g
    static volatile o<? super k0, ? extends k0> p;
    static volatile o<? super c, ? extends c> q;

    @g
    static volatile o<? super b, ? extends b> r;

    @g
    static volatile h.a.x0.c<? super l, ? super j.d.c, ? extends j.d.c> s;

    @g
    static volatile h.a.x0.c<? super s, ? super v, ? extends v> t;

    @g
    static volatile h.a.x0.c<? super b0, ? super i0, ? extends i0> u;

    @g
    static volatile h.a.x0.c<? super k0, ? super n0, ? extends n0> v;

    @g
    static volatile h.a.x0.c<? super c, ? super f, ? extends f> w;

    @g
    static volatile e x;
    static volatile boolean y;
    static volatile boolean z;

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static void A() {
        y = true;
    }

    public static boolean B() {
        e eVar = x;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    public static void C() {
        a((h.a.x0.g<? super Throwable>) null);
        p(null);
        a((o<? super j0, ? extends j0>) null);
        b((o<? super Callable<j0>, ? extends j0>) null);
        f(null);
        c((o<? super Callable<j0>, ? extends j0>) null);
        q(null);
        e((o<? super Callable<j0>, ? extends j0>) null);
        g(null);
        d((o<? super Callable<j0>, ? extends j0>) null);
        k(null);
        b((h.a.x0.c<? super l, ? super j.d.c, ? extends j.d.c>) null);
        m(null);
        d((h.a.x0.c<? super b0, ? super i0, ? extends i0>) null);
        o(null);
        e((h.a.x0.c<? super k0, ? super n0, ? extends n0>) null);
        h(null);
        a((h.a.x0.c<? super c, ? super f, ? extends f>) null);
        i(null);
        j(null);
        l(null);
        c((h.a.x0.c<? super s, v, ? extends v>) null);
        n(null);
        a(false);
        a((e) null);
    }

    static void D() {
        y = false;
    }

    public static void a(boolean z2) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        z = z2;
    }

    @g
    public static h.a.x0.g<? super Throwable> b() {
        return a;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> c() {
        return f10253c;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> d() {
        return f10255e;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> e() {
        return f10256f;
    }

    @g
    public static o<? super Callable<j0>, ? extends j0> f() {
        return f10254d;
    }

    @g
    public static o<? super j0, ? extends j0> g() {
        return f10259i;
    }

    @g
    public static o<? super j0, ? extends j0> h() {
        return f10260j;
    }

    public static void i(@g o<? super h.a.w0.a, ? extends h.a.w0.a> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10262l = oVar;
    }

    @g
    public static o<? super c, ? extends c> j() {
        return q;
    }

    @g
    public static h.a.x0.c<? super c, ? super f, ? extends f> k() {
        return w;
    }

    @g
    public static o<? super h.a.w0.a, ? extends h.a.w0.a> l() {
        return f10262l;
    }

    @g
    public static o<? super h.a.z0.a, ? extends h.a.z0.a> m() {
        return f10264n;
    }

    @g
    public static o<? super l, ? extends l> n() {
        return f10261k;
    }

    @g
    public static h.a.x0.c<? super l, ? super j.d.c, ? extends j.d.c> o() {
        return s;
    }

    public static void p(@g o<? super Runnable, ? extends Runnable> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10252b = oVar;
    }

    public static void q(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10258h = oVar;
    }

    @g
    public static o<? super b0, ? extends b0> r() {
        return f10263m;
    }

    @g
    public static h.a.x0.c<? super b0, ? super i0, ? extends i0> s() {
        return u;
    }

    @h.a.t0.c
    @g
    public static o<? super b, ? extends b> t() {
        return r;
    }

    @g
    public static o<? super k0, ? extends k0> u() {
        return p;
    }

    @g
    public static h.a.x0.c<? super k0, ? super n0, ? extends n0> v() {
        return v;
    }

    @g
    public static o<? super Runnable, ? extends Runnable> w() {
        return f10252b;
    }

    @g
    public static o<? super j0, ? extends j0> x() {
        return f10258h;
    }

    public static boolean y() {
        return z;
    }

    public static boolean z() {
        return y;
    }

    @h.a.t0.f
    public static j0 b(@h.a.t0.f Callable<j0> callable) {
        h.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f10253c;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @h.a.t0.f
    public static j0 c(@h.a.t0.f Callable<j0> callable) {
        h.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f10255e;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @h.a.t0.f
    public static j0 d(@h.a.t0.f Callable<j0> callable) {
        h.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f10256f;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    @h.a.t0.f
    public static j0 e(@h.a.t0.f Callable<j0> callable) {
        h.a.y0.b.b.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<j0>, ? extends j0> oVar = f10254d;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static void f(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10259i = oVar;
    }

    public static void g(@g o<? super j0, ? extends j0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10260j = oVar;
    }

    public static void h(@g o<? super c, ? extends c> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        q = oVar;
    }

    public static void j(@g o<? super h.a.z0.a, ? extends h.a.z0.a> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10264n = oVar;
    }

    public static void k(@g o<? super l, ? extends l> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10261k = oVar;
    }

    public static void l(@g o<? super s, ? extends s> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        o = oVar;
    }

    public static void m(@g o<? super b0, ? extends b0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f10263m = oVar;
    }

    @h.a.t0.c
    public static void n(@g o<? super b, ? extends b> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        r = oVar;
    }

    public static void o(@g o<? super k0, ? extends k0> oVar) {
        if (y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        p = oVar;
    }

    @g
    public static o<? super j0, ? extends j0> a() {
        return f10257g;
    }

    @g
    public static e i() {
        return x;
    }

    @g
    public static o<? super s, ? extends s> p() {
        return o;
    }

    @g
    public static h.a.x0.c<? super s, ? super v, ? extends v> q() {
        return t;
    }

    @h.a.t0.f
    public static j0 a(@h.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f10257g;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void b(@h.a.t0.f Throwable th) {
        h.a.x0.g<? super Throwable> gVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new h.a.v0.f(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(@h.a.t0.f Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    @h.a.t0.f
    public static j0 d(@h.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f10258h;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void e(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f10254d = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static boolean a(Throwable th) {
        return (th instanceof d) || (th instanceof h.a.v0.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof h.a.v0.a);
    }

    public static void d(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f10256f = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 c(@h.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f10260j;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void e(@g h.a.x0.c<? super k0, ? super n0, ? extends n0> cVar) {
        if (!y) {
            v = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void c(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f10255e = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void d(@g h.a.x0.c<? super b0, ? super i0, ? extends i0> cVar) {
        if (!y) {
            u = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static Runnable a(@h.a.t0.f Runnable runnable) {
        o<? super Runnable, ? extends Runnable> oVar = f10252b;
        return oVar == null ? runnable : (Runnable) a((o<Runnable, R>) oVar, runnable);
    }

    public static void c(@g h.a.x0.c<? super s, v, ? extends v> cVar) {
        if (!y) {
            t = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 d(@h.a.t0.f ThreadFactory threadFactory) {
        return new q((ThreadFactory) h.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    public static void a(@g o<? super j0, ? extends j0> oVar) {
        if (!y) {
            f10257g = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 b(@h.a.t0.f j0 j0Var) {
        o<? super j0, ? extends j0> oVar = f10259i;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void b(@g o<? super Callable<j0>, ? extends j0> oVar) {
        if (!y) {
            f10253c = oVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 c(@h.a.t0.f ThreadFactory threadFactory) {
        return new h((ThreadFactory) h.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    public static void a(@g h.a.x0.g<? super Throwable> gVar) {
        if (!y) {
            a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void b(@g h.a.x0.c<? super l, ? super j.d.c, ? extends j.d.c> cVar) {
        if (!y) {
            s = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void a(@g h.a.x0.c<? super c, ? super f, ? extends f> cVar) {
        if (!y) {
            w = cVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 b(@h.a.t0.f ThreadFactory threadFactory) {
        return new h.a.y0.g.g((ThreadFactory) h.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    @h.a.t0.f
    public static <T> j.d.c<? super T> a(@h.a.t0.f l<T> lVar, @h.a.t0.f j.d.c<? super T> cVar) {
        h.a.x0.c<? super l, ? super j.d.c, ? extends j.d.c> cVar2 = s;
        return cVar2 != null ? (j.d.c) a(cVar2, lVar, cVar) : cVar;
    }

    @h.a.t0.f
    public static <T> i0<? super T> a(@h.a.t0.f b0<T> b0Var, @h.a.t0.f i0<? super T> i0Var) {
        h.a.x0.c<? super b0, ? super i0, ? extends i0> cVar = u;
        return cVar != null ? (i0) a(cVar, b0Var, i0Var) : i0Var;
    }

    @h.a.t0.f
    public static <T> n0<? super T> a(@h.a.t0.f k0<T> k0Var, @h.a.t0.f n0<? super T> n0Var) {
        h.a.x0.c<? super k0, ? super n0, ? extends n0> cVar = v;
        return cVar != null ? (n0) a(cVar, k0Var, n0Var) : n0Var;
    }

    @h.a.t0.f
    public static f a(@h.a.t0.f c cVar, @h.a.t0.f f fVar) {
        h.a.x0.c<? super c, ? super f, ? extends f> cVar2 = w;
        return cVar2 != null ? (f) a(cVar2, cVar, fVar) : fVar;
    }

    @h.a.t0.f
    public static <T> v<? super T> a(@h.a.t0.f s<T> sVar, @h.a.t0.f v<? super T> vVar) {
        h.a.x0.c<? super s, ? super v, ? extends v> cVar = t;
        return cVar != null ? (v) a(cVar, sVar, vVar) : vVar;
    }

    @h.a.t0.f
    public static <T> s<T> a(@h.a.t0.f s<T> sVar) {
        o<? super s, ? extends s> oVar = o;
        return oVar != null ? (s) a((o<s<T>, R>) oVar, sVar) : sVar;
    }

    @h.a.t0.f
    public static <T> l<T> a(@h.a.t0.f l<T> lVar) {
        o<? super l, ? extends l> oVar = f10261k;
        return oVar != null ? (l) a((o<l<T>, R>) oVar, lVar) : lVar;
    }

    @h.a.t0.f
    public static <T> h.a.w0.a<T> a(@h.a.t0.f h.a.w0.a<T> aVar) {
        o<? super h.a.w0.a, ? extends h.a.w0.a> oVar = f10262l;
        return oVar != null ? (h.a.w0.a) a((o<h.a.w0.a<T>, R>) oVar, aVar) : aVar;
    }

    @h.a.t0.f
    public static <T> b0<T> a(@h.a.t0.f b0<T> b0Var) {
        o<? super b0, ? extends b0> oVar = f10263m;
        return oVar != null ? (b0) a((o<b0<T>, R>) oVar, b0Var) : b0Var;
    }

    @h.a.t0.f
    public static <T> h.a.z0.a<T> a(@h.a.t0.f h.a.z0.a<T> aVar) {
        o<? super h.a.z0.a, ? extends h.a.z0.a> oVar = f10264n;
        return oVar != null ? (h.a.z0.a) a((o<h.a.z0.a<T>, R>) oVar, aVar) : aVar;
    }

    @h.a.t0.f
    public static <T> k0<T> a(@h.a.t0.f k0<T> k0Var) {
        o<? super k0, ? extends k0> oVar = p;
        return oVar != null ? (k0) a((o<k0<T>, R>) oVar, k0Var) : k0Var;
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f c cVar) {
        o<? super c, ? extends c> oVar = q;
        return oVar != null ? (c) a((o<c, R>) oVar, cVar) : cVar;
    }

    @h.a.t0.f
    @h.a.t0.c
    public static <T> b<T> a(@h.a.t0.f b<T> bVar) {
        o<? super b, ? extends b> oVar = r;
        return oVar != null ? (b) a((o<b<T>, R>) oVar, bVar) : bVar;
    }

    public static void a(@g e eVar) {
        if (!y) {
            x = eVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @h.a.t0.f
    public static j0 a(@h.a.t0.f ThreadFactory threadFactory) {
        return new h.a.y0.g.b((ThreadFactory) h.a.y0.b.b.a(threadFactory, "threadFactory is null"));
    }

    @h.a.t0.f
    static <T, R> R a(@h.a.t0.f o<T, R> oVar, @h.a.t0.f T t2) {
        try {
            return oVar.apply(t2);
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @h.a.t0.f
    static <T, U, R> R a(@h.a.t0.f h.a.x0.c<T, U, R> cVar, @h.a.t0.f T t2, @h.a.t0.f U u2) {
        try {
            return cVar.apply(t2, u2);
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @h.a.t0.f
    static j0 a(@h.a.t0.f Callable<j0> callable) {
        try {
            return (j0) h.a.y0.b.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @h.a.t0.f
    static j0 a(@h.a.t0.f o<? super Callable<j0>, ? extends j0> oVar, Callable<j0> callable) {
        return (j0) h.a.y0.b.b.a(a((o<Callable<j0>, R>) oVar, callable), "Scheduler Callable result can't be null");
    }
}
