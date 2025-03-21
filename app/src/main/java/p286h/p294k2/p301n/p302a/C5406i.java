package p286h.p294k2.p301n.p302a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: DebugMetadata.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m23546d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.n.a.i */
/* loaded from: classes2.dex */
final class C5406i {

    /* renamed from: b */
    @InterfaceC5479c
    @InterfaceC5817e
    public static a f20291b;

    /* renamed from: c */
    public static final C5406i f20292c = new C5406i();

    /* renamed from: a */
    private static final a f20290a = new a(null, null, null);

    /* compiled from: DebugMetadata.kt */
    /* renamed from: h.k2.n.a.i$a */
    private static final class a {

        /* renamed from: a */
        @InterfaceC5479c
        @InterfaceC5817e
        public final Method f20293a;

        /* renamed from: b */
        @InterfaceC5479c
        @InterfaceC5817e
        public final Method f20294b;

        /* renamed from: c */
        @InterfaceC5479c
        @InterfaceC5817e
        public final Method f20295c;

        public a(@InterfaceC5817e Method method, @InterfaceC5817e Method method2, @InterfaceC5817e Method method3) {
            this.f20293a = method;
            this.f20294b = method2;
            this.f20295c = method3;
        }
    }

    private C5406i() {
    }

    /* renamed from: b */
    private final a m22143b(AbstractC5398a abstractC5398a) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC5398a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC5398a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(CommonNetImpl.NAME, new Class[0]));
            f20291b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f20290a;
            f20291b = aVar2;
            return aVar2;
        }
    }

    @InterfaceC5817e
    /* renamed from: a */
    public final String m22144a(@InterfaceC5816d AbstractC5398a abstractC5398a) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        C5544i0.m22546f(abstractC5398a, "continuation");
        a aVar = f20291b;
        if (aVar == null) {
            aVar = m22143b(abstractC5398a);
        }
        if (aVar == f20290a || (method = aVar.f20293a) == null || (invoke = method.invoke(abstractC5398a.getClass(), new Object[0])) == null || (method2 = aVar.f20294b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f20295c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }
}
