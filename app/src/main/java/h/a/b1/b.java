package h.a.b1;

import h.a.j0;
import h.a.l;
import h.a.t0.e;
import h.a.t0.f;
import h.a.x0.o;
import h.a.x0.q;
import h.a.x0.r;
import h.a.y0.e.e.h;
import h.a.y0.e.e.i;
import h.a.y0.e.e.j;
import h.a.y0.e.e.m;
import h.a.y0.e.e.n;
import h.a.y0.i.g;
import h.a.y0.j.k;
import h.a.y0.j.p;
import h.a.y0.j.w;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ParallelFlowable.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.c
public abstract class b<T> {
    @h.a.t0.d
    public static <T> b<T> a(@f j.d.b<? extends T> bVar) {
        return a(bVar, Runtime.getRuntime().availableProcessors(), l.Q());
    }

    public abstract int a();

    public abstract void a(@f j.d.c<? super T>[] cVarArr);

    protected final boolean b(@f j.d.c<?>[] cVarArr) {
        int iA = a();
        if (cVarArr.length == iA) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + iA + ", subscribers = " + cVarArr.length);
        for (j.d.c<?> cVar : cVarArr) {
            g.error(illegalArgumentException, cVar);
        }
        return false;
    }

    @f
    @h.a.t0.d
    public final <R> b<R> c(@f o<? super T, ? extends R> oVar) {
        h.a.y0.b.b.a(oVar, "mapper");
        return h.a.c1.a.a(new j(this, oVar));
    }

    @f
    @h.a.t0.d
    public final b<T> d(@f h.a.x0.g<? super j.d.d> gVar) {
        h.a.y0.b.b.a(gVar, "onSubscribe is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVarD3 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar, aVar, gVar, h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @h.a.t0.d
    public static <T> b<T> a(@f j.d.b<? extends T> bVar, int i2) {
        return a(bVar, i2, l.Q());
    }

    @f
    @h.a.t0.d
    public static <T> b<T> a(@f j.d.b<? extends T> bVar, int i2, int i3) {
        h.a.y0.b.b.a(bVar, "source");
        h.a.y0.b.b.a(i2, "parallelism");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h(bVar, i2, i3));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @e
    @f
    @h.a.t0.h("none")
    public final l<T> c() {
        return b(l.Q());
    }

    @f
    @h.a.t0.d
    public final b<T> c(@f h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVar, gVarD, gVarD2, aVar, aVar, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @h.a.t0.h("none")
    public final l<T> b() {
        return a(l.Q());
    }

    @f
    @h.a.t0.d
    @e
    public final <R> R a(@f c<T, R> cVar) {
        return (R) ((c) h.a.y0.b.b.a(cVar, "converter is null")).a(this);
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @f
    @h.a.t0.h("none")
    public final l<T> b(int i2) {
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new i(this, i2, true));
    }

    @f
    @h.a.t0.d
    public final <U> U d(@f o<? super b<T>, U> oVar) {
        try {
            return (U) ((o) h.a.y0.b.b.a(oVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw k.c(th);
        }
    }

    @f
    @h.a.t0.d
    @e
    public final <R> b<R> a(@f o<? super T, ? extends R> oVar, @f a aVar) {
        h.a.y0.b.b.a(oVar, "mapper");
        h.a.y0.b.b.a(aVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.k(this, oVar, aVar));
    }

    @f
    @h.a.t0.d
    public final l<List<T>> b(@f Comparator<? super T> comparator) {
        return b(comparator, 16);
    }

    @f
    @h.a.t0.d
    public final l<List<T>> b(@f Comparator<? super T> comparator, int i2) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(a(h.a.y0.b.a.a((i2 / a()) + 1), h.a.y0.j.o.instance()).c(new w(comparator)).a(new p(comparator)));
    }

    @f
    @h.a.t0.d
    public final b<T> c(@f h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onComplete is null");
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.d(), aVar, h.a.y0.b.a.f10447c, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @f
    @h.a.t0.d
    @e
    public final <R> b<R> a(@f o<? super T, ? extends R> oVar, @f h.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        h.a.y0.b.b.a(oVar, "mapper");
        h.a.y0.b.b.a(cVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.k(this, oVar, cVar));
    }

    @h.a.t0.d
    public final b<T> a(@f r<? super T> rVar) {
        h.a.y0.b.b.a(rVar, "predicate");
        return h.a.c1.a.a(new h.a.y0.e.e.d(this, rVar));
    }

    @h.a.t0.d
    @e
    public final b<T> a(@f r<? super T> rVar, @f a aVar) {
        h.a.y0.b.b.a(rVar, "predicate");
        h.a.y0.b.b.a(aVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.e(this, rVar, aVar));
    }

    @f
    @h.a.t0.d
    public final b<T> b(@f h.a.x0.g<Throwable> gVar) {
        h.a.y0.b.b.a(gVar, "onError is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVarD, gVarD2, gVar, aVar, aVar, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @h.a.t0.d
    @e
    public final b<T> a(@f r<? super T> rVar, @f h.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        h.a.y0.b.b.a(rVar, "predicate");
        h.a.y0.b.b.a(cVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.e(this, rVar, cVar));
    }

    @f
    @h.a.t0.d
    public final b<T> a(@f j0 j0Var) {
        return a(j0Var, l.Q());
    }

    @f
    @h.a.t0.d
    public final b<T> a(@f j0 j0Var, int i2) {
        h.a.y0.b.b.a(j0Var, "scheduler");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.e.o(this, j0Var, i2));
    }

    @f
    @h.a.t0.d
    public final b<T> b(@f h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onCancel is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVarD3 = h.a.y0.b.a.d();
        h.a.x0.a aVar2 = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar2, aVar2, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, aVar));
    }

    @f
    @h.a.t0.d
    public final l<T> a(@f h.a.x0.c<T, T, T> cVar) {
        h.a.y0.b.b.a(cVar, "reducer");
        return h.a.c1.a.a(new n(this, cVar));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f Callable<R> callable, @f h.a.x0.c<R, ? super T, R> cVar) {
        h.a.y0.b.b.a(callable, "initialSupplier");
        h.a.y0.b.b.a(cVar, "reducer");
        return h.a.c1.a.a(new m(this, callable, cVar));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> b(@f o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a(oVar, false, Integer.MAX_VALUE, l.Q());
    }

    @h.a.t0.b(h.a.t0.a.FULL)
    @h.a.t0.d
    @f
    @h.a.t0.h("none")
    public final l<T> a(int i2) {
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new i(this, i2, false));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> b(@f o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, z, Integer.MAX_VALUE, l.Q());
    }

    @f
    @h.a.t0.d
    public final l<T> a(@f Comparator<? super T> comparator) {
        return a(comparator, 16);
    }

    @f
    @h.a.t0.d
    public final l<T> a(@f Comparator<? super T> comparator, int i2) {
        h.a.y0.b.b.a(comparator, "comparator is null");
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(new h.a.y0.e.e.p(a(h.a.y0.b.a.a((i2 / a()) + 1), h.a.y0.j.o.instance()).c(new w(comparator)), comparator));
    }

    @f
    @h.a.t0.d
    @e
    public final b<T> a(@f h.a.x0.g<? super T> gVar, @f a aVar) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(aVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.c(this, gVar, aVar));
    }

    @f
    @h.a.t0.d
    @e
    public final b<T> a(@f h.a.x0.g<? super T> gVar, @f h.a.x0.c<? super Long, ? super Throwable, a> cVar) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(cVar, "errorHandler is null");
        return h.a.c1.a.a(new h.a.y0.e.e.c(this, gVar, cVar));
    }

    @f
    @h.a.t0.d
    public final b<T> a(@f h.a.x0.g<? super T> gVar) {
        h.a.y0.b.b.a(gVar, "onAfterNext is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVarD, gVar, gVarD2, aVar, aVar, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @f
    @h.a.t0.d
    public final b<T> a(@f h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "onAfterTerminate is null");
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.d(), h.a.y0.b.a.f10447c, aVar, h.a.y0.b.a.d(), h.a.y0.b.a.f10451g, h.a.y0.b.a.f10447c));
    }

    @f
    @h.a.t0.d
    public final b<T> a(@f q qVar) {
        h.a.y0.b.b.a(qVar, "onRequest is null");
        h.a.x0.g gVarD = h.a.y0.b.a.d();
        h.a.x0.g gVarD2 = h.a.y0.b.a.d();
        h.a.x0.g gVarD3 = h.a.y0.b.a.d();
        h.a.x0.a aVar = h.a.y0.b.a.f10447c;
        return h.a.c1.a.a(new h.a.y0.e.e.l(this, gVarD, gVarD2, gVarD3, aVar, aVar, h.a.y0.b.a.d(), qVar, h.a.y0.b.a.f10447c));
    }

    @f
    @h.a.t0.d
    public final <C> b<C> a(@f Callable<? extends C> callable, @f h.a.x0.b<? super C, ? super T> bVar) {
        h.a.y0.b.b.a(callable, "collectionSupplier is null");
        h.a.y0.b.b.a(bVar, "collector is null");
        return h.a.c1.a.a(new h.a.y0.e.e.a(this, callable, bVar));
    }

    @f
    @h.a.t0.d
    public static <T> b<T> a(@f j.d.b<T>... bVarArr) {
        if (bVarArr.length != 0) {
            return h.a.c1.a.a(new h.a.y0.e.e.g(bVarArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @f
    @h.a.t0.d
    public final <U> b<U> a(@f d<T, U> dVar) {
        return h.a.c1.a.a(((d) h.a.y0.b.b.a(dVar, "composer is null")).a(this));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z, int i2) {
        return a(oVar, z, i2, l.Q());
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z, int i2, int i3) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "maxConcurrency");
        h.a.y0.b.b.a(i3, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.e.f(this, oVar, z, i2, i3));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar) {
        return a(oVar, 2);
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar, int i2) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.e.b(this, oVar, i2, h.a.y0.j.j.IMMEDIATE));
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar, boolean z) {
        return a(oVar, 2, z);
    }

    @f
    @h.a.t0.d
    public final <R> b<R> a(@f o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        h.a.y0.b.b.a(i2, "prefetch");
        return h.a.c1.a.a(new h.a.y0.e.e.b(this, oVar, i2, z ? h.a.y0.j.j.END : h.a.y0.j.j.BOUNDARY));
    }
}
