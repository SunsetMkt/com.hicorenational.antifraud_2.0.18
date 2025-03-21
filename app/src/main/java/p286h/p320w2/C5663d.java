package p286h.p320w2;

import p286h.C5226e1;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5427g;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KClasses.kt */
@InterfaceC5481e(name = "KClasses")
/* renamed from: h.w2.d */
/* loaded from: classes2.dex */
public final class C5663d {
    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5427g
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> T m23244a(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(interfaceC5662c, "$this$cast");
        if (interfaceC5662c.mo22671a(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new C5226e1("null cannot be cast to non-null type T");
        }
        throw new ClassCastException("Value cannot be cast to " + interfaceC5662c.mo22672b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5817e
    @InterfaceC5427g
    /* renamed from: b */
    public static final <T> T m23245b(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(interfaceC5662c, "$this$safeCast");
        if (!interfaceC5662c.mo22671a(obj)) {
            return null;
        }
        if (obj != 0) {
            return obj;
        }
        throw new C5226e1("null cannot be cast to non-null type T");
    }
}
