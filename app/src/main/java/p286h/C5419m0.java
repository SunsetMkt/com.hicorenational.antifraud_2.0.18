package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;

/* compiled from: Preconditions.kt */
/* renamed from: h.m0 */
/* loaded from: classes2.dex */
class C5419m0 extends C5414l0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22163a(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22167b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> T m22169c(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22164a(boolean z, InterfaceC5495a<? extends Object> interfaceC5495a) {
        if (!z) {
            throw new IllegalStateException(interfaceC5495a.invoke().toString());
        }
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22168b(boolean z, InterfaceC5495a<? extends Object> interfaceC5495a) {
        if (!z) {
            throw new IllegalArgumentException(interfaceC5495a.invoke().toString());
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T m22161a(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> T m22165b(T t, InterfaceC5495a<? extends Object> interfaceC5495a) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(interfaceC5495a.invoke().toString());
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T m22162a(T t, InterfaceC5495a<? extends Object> interfaceC5495a) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(interfaceC5495a.invoke().toString());
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final Void m22166b(Object obj) {
        throw new IllegalStateException(obj.toString());
    }
}
