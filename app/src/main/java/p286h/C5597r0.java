package p286h;

import p286h.C5475q0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Result.kt */
/* renamed from: h.r0 */
/* loaded from: classes2.dex */
public final class C5597r0 {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final Object m22715a(@InterfaceC5816d Throwable th) {
        C5544i0.m22546f(th, "exception");
        return new C5475q0.b(th);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: b */
    public static final void m22717b(@InterfaceC5816d Object obj) {
        if (obj instanceof C5475q0.b) {
            throw ((C5475q0.b) obj).exception;
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: c */
    private static final <R, T> Object m22718c(@InterfaceC5816d Object obj, InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        if (!C5475q0.m26861isSuccessimpl(obj)) {
            return C5475q0.m26855constructorimpl(obj);
        }
        try {
            C5475q0.a aVar = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(interfaceC5506l.invoke(obj));
        } catch (Throwable th) {
            C5475q0.a aVar2 = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(m22715a(th));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: d */
    private static final <T> Object m22719d(@InterfaceC5816d Object obj, InterfaceC5506l<? super Throwable, C5715y1> interfaceC5506l) {
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        if (m26858exceptionOrNullimpl != null) {
            interfaceC5506l.invoke(m26858exceptionOrNullimpl);
        }
        return obj;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: e */
    private static final <T> Object m22720e(@InterfaceC5816d Object obj, InterfaceC5506l<? super T, C5715y1> interfaceC5506l) {
        if (C5475q0.m26861isSuccessimpl(obj)) {
            interfaceC5506l.invoke(obj);
        }
        return obj;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: f */
    private static final <R, T extends R> Object m22721f(@InterfaceC5816d Object obj, InterfaceC5506l<? super Throwable, ? extends R> interfaceC5506l) {
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        if (m26858exceptionOrNullimpl == null) {
            return obj;
        }
        C5475q0.a aVar = C5475q0.Companion;
        return C5475q0.m26855constructorimpl(interfaceC5506l.invoke(m26858exceptionOrNullimpl));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: g */
    private static final <R, T extends R> Object m22722g(@InterfaceC5816d Object obj, InterfaceC5506l<? super Throwable, ? extends R> interfaceC5506l) {
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        if (m26858exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            C5475q0.a aVar = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(interfaceC5506l.invoke(m26858exceptionOrNullimpl));
        } catch (Throwable th) {
            C5475q0.a aVar2 = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(m22715a(th));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: h */
    private static final <T, R> Object m22723h(T t, InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        try {
            C5475q0.a aVar = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(interfaceC5506l.invoke(t));
        } catch (Throwable th) {
            C5475q0.a aVar2 = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(m22715a(th));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <R> Object m22710a(InterfaceC5495a<? extends R> interfaceC5495a) {
        try {
            C5475q0.a aVar = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(interfaceC5495a.invoke());
        } catch (Throwable th) {
            C5475q0.a aVar2 = C5475q0.Companion;
            return C5475q0.m26855constructorimpl(m22715a(th));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    private static final <R, T> Object m22716b(@InterfaceC5816d Object obj, InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        if (!C5475q0.m26861isSuccessimpl(obj)) {
            return C5475q0.m26855constructorimpl(obj);
        }
        C5475q0.a aVar = C5475q0.Companion;
        return C5475q0.m26855constructorimpl(interfaceC5506l.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <T> T m22711a(@InterfaceC5816d Object obj) {
        m22717b(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <R, T extends R> R m22712a(@InterfaceC5816d Object obj, InterfaceC5506l<? super Throwable, ? extends R> interfaceC5506l) {
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        return m26858exceptionOrNullimpl == null ? obj : interfaceC5506l.invoke(m26858exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <R, T extends R> R m22714a(@InterfaceC5816d Object obj, R r) {
        return C5475q0.m26860isFailureimpl(obj) ? r : obj;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <R, T> R m22713a(@InterfaceC5816d Object obj, InterfaceC5506l<? super T, ? extends R> interfaceC5506l, InterfaceC5506l<? super Throwable, ? extends R> interfaceC5506l2) {
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        if (m26858exceptionOrNullimpl == null) {
            return interfaceC5506l.invoke(obj);
        }
        return interfaceC5506l2.invoke(m26858exceptionOrNullimpl);
    }
}
