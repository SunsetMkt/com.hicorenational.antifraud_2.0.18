package h.a.s0.d;

import h.a.j0;
import h.a.v0.b;
import h.a.x0.o;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static volatile o<Callable<j0>, j0> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile o<j0, j0> f10418b;

    private a() {
        throw new AssertionError("No instances.");
    }

    public static void a(o<Callable<j0>, j0> oVar) {
        a = oVar;
    }

    public static j0 b(Callable<j0> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        o<Callable<j0>, j0> oVar = a;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static j0 a(j0 j0Var) {
        if (j0Var == null) {
            throw new NullPointerException("scheduler == null");
        }
        o<j0, j0> oVar = f10418b;
        return oVar == null ? j0Var : (j0) a((o<j0, R>) oVar, j0Var);
    }

    public static void a() {
        a((o<Callable<j0>, j0>) null);
        b((o<j0, j0>) null);
    }

    public static void b(o<j0, j0> oVar) {
        f10418b = oVar;
    }

    static j0 a(Callable<j0> callable) {
        try {
            j0 j0VarCall = callable.call();
            if (j0VarCall != null) {
                return j0VarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static j0 a(o<Callable<j0>, j0> oVar, Callable<j0> callable) {
        j0 j0Var = (j0) a((o<Callable<j0>, R>) oVar, callable);
        if (j0Var != null) {
            return j0Var;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(o<T, R> oVar, T t) {
        try {
            return oVar.apply(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }
}
