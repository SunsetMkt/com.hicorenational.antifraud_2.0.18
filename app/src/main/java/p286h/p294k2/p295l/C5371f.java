package p286h.p294k2.p295l;

import p286h.C5190a0;
import p286h.C5226e1;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p294k2.p295l.p297o.p298a.C5383b;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesLibrary.kt */
@InterfaceC5481e(name = "CoroutinesKt")
/* renamed from: h.k2.l.f */
/* loaded from: classes2.dex */
public final class C5371f {
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <R, T> InterfaceC5368c<C5715y1> m22045a(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5368c<? super T>, ? extends Object> interfaceC5510p, R r, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<C5715y1> m22072a;
        Object m22074b;
        C5544i0.m22546f(interfaceC5510p, "$this$createCoroutine");
        C5544i0.m22546f(interfaceC5368c, "completion");
        m22072a = C5380b.m22072a(interfaceC5510p, r, interfaceC5368c);
        m22074b = C5380b.m22074b();
        return new C5374i(m22072a, m22074b);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    public static /* synthetic */ void m22046a() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    public static final <R, T> void m22050b(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5368c<? super T>, ? extends Object> interfaceC5510p, R r, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<C5715y1> m22072a;
        C5544i0.m22546f(interfaceC5510p, "$this$startCoroutine");
        C5544i0.m22546f(interfaceC5368c, "completion");
        m22072a = C5380b.m22072a(interfaceC5510p, r, interfaceC5368c);
        m22072a.resume(C5715y1.f20665a);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: c */
    public static final <T> Object m22051c(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5368c<? super T>, C5715y1> interfaceC5506l, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        C5374i c5374i = new C5374i(C5383b.m22083a(interfaceC5368c));
        interfaceC5506l.invoke(c5374i);
        return c5374i.m22053a();
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    /* renamed from: d */
    private static final Object m22052d(@InterfaceC5816d InterfaceC5506l interfaceC5506l, @InterfaceC5816d InterfaceC5368c interfaceC5368c) {
        C5535f0.m22475c(0);
        C5374i c5374i = new C5374i(C5383b.m22083a(interfaceC5368c));
        interfaceC5506l.invoke(c5374i);
        Object m22053a = c5374i.m22053a();
        C5535f0.m22475c(1);
        return m22053a;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5368c<C5715y1> m22044a(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5368c<? super T>, ? extends Object> interfaceC5506l, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<C5715y1> m22071a;
        Object m22074b;
        C5544i0.m22546f(interfaceC5506l, "$this$createCoroutine");
        C5544i0.m22546f(interfaceC5368c, "completion");
        m22071a = C5380b.m22071a(interfaceC5506l, interfaceC5368c);
        m22074b = C5380b.m22074b();
        return new C5374i(m22071a, m22074b);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    public static final <T> void m22049b(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5368c<? super T>, ? extends Object> interfaceC5506l, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<C5715y1> m22071a;
        C5544i0.m22546f(interfaceC5506l, "$this$startCoroutine");
        C5544i0.m22546f(interfaceC5368c, "completion");
        m22071a = C5380b.m22071a(interfaceC5506l, interfaceC5368c);
        m22071a.resume(C5715y1.f20665a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22047a(InterfaceC5368c<?> interfaceC5368c, InterfaceC5495a<? extends Object> interfaceC5495a) {
        Object m22074b;
        try {
            Object invoke = interfaceC5495a.invoke();
            m22074b = C5380b.m22074b();
            if (invoke != m22074b) {
                if (interfaceC5368c == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                interfaceC5368c.resume(invoke);
            }
        } catch (Throwable th) {
            interfaceC5368c.resumeWithException(th);
        }
    }

    /* renamed from: b */
    private static final InterfaceC5370e m22048b() {
        throw new C5190a0("Implemented as intrinsic");
    }
}
