package i.k2.n.a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.q2.t.i0;
import i.y;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.e
    @i.q2.c
    public static a f12154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12155c = new i();
    private static final a a = new a(null, null, null);

    /* JADX INFO: compiled from: DebugMetadata.kt */
    private static final class a {

        @j.c.a.e
        @i.q2.c
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @j.c.a.e
        @i.q2.c
        public final Method f12156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @j.c.a.e
        @i.q2.c
        public final Method f12157c;

        public a(@j.c.a.e Method method, @j.c.a.e Method method2, @j.c.a.e Method method3) {
            this.a = method;
            this.f12156b = method2;
            this.f12157c = method3;
        }
    }

    private i() {
    }

    private final a b(i.k2.n.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(CommonNetImpl.NAME, new Class[0]));
            f12154b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = a;
            f12154b = aVar3;
            return aVar3;
        }
    }

    @j.c.a.e
    public final String a(@j.c.a.d i.k2.n.a.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        i0.f(aVar, "continuation");
        a aVarB = f12154b;
        if (aVarB == null) {
            aVarB = b(aVar);
        }
        if (aVarB == a || (method = aVarB.a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVarB.f12156b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarB.f12157c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (!(objInvoke3 instanceof String)) {
            objInvoke3 = null;
        }
        return (String) objInvoke3;
    }
}
