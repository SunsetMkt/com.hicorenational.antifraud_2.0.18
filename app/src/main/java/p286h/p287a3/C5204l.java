package p286h.p287a3;

import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p287a3.InterfaceC5208p;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: measureTime.kt */
/* renamed from: h.a3.l */
/* loaded from: classes2.dex */
public final class C5204l {
    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final double m18787a(@InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "block");
        AbstractC5207o mo18665a = InterfaceC5208p.b.f20077c.mo18665a();
        interfaceC5495a.invoke();
        return mo18665a.mo18668a();
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> C5211s<T> m18789b(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "block");
        return new C5211s<>(interfaceC5495a.invoke(), InterfaceC5208p.b.f20077c.mo18665a().mo18668a(), null);
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final double m18786a(@InterfaceC5816d InterfaceC5208p interfaceC5208p, @InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5208p, "$this$measureTime");
        C5544i0.m22546f(interfaceC5495a, "block");
        AbstractC5207o mo18665a = interfaceC5208p.mo18665a();
        interfaceC5495a.invoke();
        return mo18665a.mo18668a();
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> C5211s<T> m18788b(@InterfaceC5816d InterfaceC5208p interfaceC5208p, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5208p, "$this$measureTimedValue");
        C5544i0.m22546f(interfaceC5495a, "block");
        return new C5211s<>(interfaceC5495a.invoke(), interfaceC5208p.mo18665a().mo18668a(), null);
    }
}
