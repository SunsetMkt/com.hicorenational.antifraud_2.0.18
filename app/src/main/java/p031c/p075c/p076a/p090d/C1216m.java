package p031c.p075c.p076a.p090d;

import com.hihonor.cloudservice.tasks.p161q.C2148i;
import com.hihonor.cloudservice.tasks.p161q.C2149j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Tasks.java */
/* renamed from: c.c.a.d.m */
/* loaded from: classes.dex */
public class C1216m {

    /* renamed from: a */
    private static C2149j f2662a = new C2149j();

    /* renamed from: a */
    public static AbstractC1213j<List<AbstractC1213j<?>>> m2357a(AbstractC1213j<?>... abstractC1213jArr) {
        return C2149j.m6083a((Collection<? extends AbstractC1213j<?>>) Arrays.asList(abstractC1213jArr));
    }

    /* renamed from: b */
    public static <TResult> AbstractC1213j<TResult> m2361b(Callable<TResult> callable) {
        return f2662a.m6088a(C1215l.m2348a(), callable);
    }

    /* renamed from: c */
    public static <TResult> AbstractC1213j<List<TResult>> m2363c(Collection<? extends AbstractC1213j<TResult>> collection) {
        return C2149j.m6086b(collection);
    }

    /* renamed from: a */
    public static <TResult> TResult m2358a(AbstractC1213j<TResult> abstractC1213j) {
        C2149j.m6085a("await must not be called on the UI thread");
        if (abstractC1213j.mo2342d()) {
            return (TResult) C2149j.m6084a((AbstractC1213j) abstractC1213j);
        }
        C2149j.d dVar = new C2149j.d();
        abstractC1213j.mo2328a((InterfaceC1211h) dVar).mo2327a((InterfaceC1210g) dVar);
        dVar.f6486a.await();
        return (TResult) C2149j.m6084a((AbstractC1213j) abstractC1213j);
    }

    /* renamed from: b */
    public static AbstractC1213j<Void> m2362b(AbstractC1213j<?>... abstractC1213jArr) {
        return C2149j.m6087c(Arrays.asList(abstractC1213jArr));
    }

    /* renamed from: c */
    public static <TResult> AbstractC1213j<List<TResult>> m2364c(AbstractC1213j<?>... abstractC1213jArr) {
        return C2149j.m6086b(Arrays.asList(abstractC1213jArr));
    }

    /* renamed from: b */
    public static AbstractC1213j<Void> m2360b(Collection<? extends AbstractC1213j<?>> collection) {
        return C2149j.m6087c(collection);
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m2355a(Callable<TResult> callable) {
        return f2662a.m6088a(C1215l.m2349b(), callable);
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m2351a() {
        C2148i c2148i = new C2148i();
        c2148i.m6081f();
        return c2148i;
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m2352a(Exception exc) {
        C1214k c1214k = new C1214k();
        c1214k.m2346a(exc);
        return c1214k.m2345a();
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m2353a(TResult tresult) {
        return C2149j.m6082a(tresult);
    }

    /* renamed from: a */
    public static AbstractC1213j<List<AbstractC1213j<?>>> m2354a(Collection<? extends AbstractC1213j<?>> collection) {
        return C2149j.m6083a(collection);
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m2356a(Executor executor, Callable<TResult> callable) {
        return f2662a.m6088a(executor, callable);
    }

    /* renamed from: a */
    public static <TResult> TResult m2359a(AbstractC1213j<TResult> abstractC1213j, long j2, TimeUnit timeUnit) {
        C2149j.m6085a("await must not be called on the UI thread");
        if (!abstractC1213j.mo2342d()) {
            C2149j.d dVar = new C2149j.d();
            abstractC1213j.mo2328a((InterfaceC1211h) dVar).mo2327a((InterfaceC1210g) dVar);
            if (!dVar.f6486a.await(j2, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) C2149j.m6084a((AbstractC1213j) abstractC1213j);
    }
}
