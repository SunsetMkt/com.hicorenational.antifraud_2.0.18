package p286h.p289g2;

import java.util.Map;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.p304m2.InterfaceC5426f;
import p286h.p304m2.InterfaceC5427g;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p320w2.InterfaceC5672m;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: MapAccessors.kt */
@InterfaceC5481e(name = "MapAccessorsKt")
/* renamed from: h.g2.w0 */
/* loaded from: classes2.dex */
public final class C5310w0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final <V, V1 extends V> V1 m21737a(@InterfaceC5816d Map<? super String, ? extends V> map, Object obj, InterfaceC5672m<?> interfaceC5672m) {
        C5544i0.m22546f(map, "$this$getValue");
        return (V1) C5242a1.m18994a((Map<String, ? extends V>) map, interfaceC5672m.getName());
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "getVar")
    /* renamed from: b */
    private static final <V, V1 extends V> V1 m21739b(@InterfaceC5816d Map<? super String, ? extends V> map, Object obj, InterfaceC5672m<?> interfaceC5672m) {
        C5544i0.m22546f(map, "$this$getValue");
        return (V1) C5242a1.m18994a((Map<String, ? extends V>) map, interfaceC5672m.getName());
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "getVarContravariant")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use getValue() with two type parameters instead")
    @InterfaceC5427g
    /* renamed from: c */
    private static final <V> V m21740c(@InterfaceC5816d Map<? super String, ? super V> map, Object obj, InterfaceC5672m<?> interfaceC5672m) {
        return (V) C5242a1.m18994a((Map<String, ? extends V>) map, interfaceC5672m.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: a */
    private static final <V> void m21738a(@InterfaceC5816d Map<? super String, ? super V> map, Object obj, InterfaceC5672m<?> interfaceC5672m, V v) {
        C5544i0.m22546f(map, "$this$setValue");
        map.put(interfaceC5672m.getName(), v);
    }
}
