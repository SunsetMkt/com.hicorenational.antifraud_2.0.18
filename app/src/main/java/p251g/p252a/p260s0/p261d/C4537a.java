package p251g.p252a.p260s0.p261d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;

/* compiled from: RxAndroidPlugins.java */
/* renamed from: g.a.s0.d.a */
/* loaded from: classes2.dex */
public final class C4537a {

    /* renamed from: a */
    private static volatile InterfaceC4584o<Callable<AbstractC4516j0>, AbstractC4516j0> f17449a;

    /* renamed from: b */
    private static volatile InterfaceC4584o<AbstractC4516j0, AbstractC4516j0> f17450b;

    private C4537a() {
        throw new AssertionError("No instances.");
    }

    /* renamed from: a */
    public static void m18170a(InterfaceC4584o<Callable<AbstractC4516j0>, AbstractC4516j0> interfaceC4584o) {
        f17449a = interfaceC4584o;
    }

    /* renamed from: b */
    public static AbstractC4516j0 m18171b(Callable<AbstractC4516j0> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC4584o<Callable<AbstractC4516j0>, AbstractC4516j0> interfaceC4584o = f17449a;
        return interfaceC4584o == null ? m18167a(callable) : m18166a(interfaceC4584o, callable);
    }

    /* renamed from: a */
    public static AbstractC4516j0 m18165a(AbstractC4516j0 abstractC4516j0) {
        if (abstractC4516j0 == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC4584o<AbstractC4516j0, AbstractC4516j0> interfaceC4584o = f17450b;
        return interfaceC4584o == null ? abstractC4516j0 : (AbstractC4516j0) m18168a((InterfaceC4584o<AbstractC4516j0, R>) interfaceC4584o, abstractC4516j0);
    }

    /* renamed from: a */
    public static void m18169a() {
        m18170a((InterfaceC4584o<Callable<AbstractC4516j0>, AbstractC4516j0>) null);
        m18172b((InterfaceC4584o<AbstractC4516j0, AbstractC4516j0>) null);
    }

    /* renamed from: b */
    public static void m18172b(InterfaceC4584o<AbstractC4516j0, AbstractC4516j0> interfaceC4584o) {
        f17450b = interfaceC4584o;
    }

    /* renamed from: a */
    static AbstractC4516j0 m18167a(Callable<AbstractC4516j0> callable) {
        try {
            AbstractC4516j0 call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw C4561b.m18198a(th);
        }
    }

    /* renamed from: a */
    static AbstractC4516j0 m18166a(InterfaceC4584o<Callable<AbstractC4516j0>, AbstractC4516j0> interfaceC4584o, Callable<AbstractC4516j0> callable) {
        AbstractC4516j0 abstractC4516j0 = (AbstractC4516j0) m18168a((InterfaceC4584o<Callable<AbstractC4516j0>, R>) interfaceC4584o, callable);
        if (abstractC4516j0 != null) {
            return abstractC4516j0;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    static <T, R> R m18168a(InterfaceC4584o<T, R> interfaceC4584o, T t) {
        try {
            return interfaceC4584o.apply(t);
        } catch (Throwable th) {
            throw C4561b.m18198a(th);
        }
    }
}
