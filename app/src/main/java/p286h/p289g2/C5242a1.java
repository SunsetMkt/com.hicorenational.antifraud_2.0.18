package p286h.p289g2;

import java.util.Map;
import java.util.NoSuchElementException;
import p286h.InterfaceC5440n0;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: MapWithDefault.kt */
/* renamed from: h.g2.a1 */
/* loaded from: classes2.dex */
class C5242a1 {
    @InterfaceC5481e(name = "getOrImplicitDefaultNullable")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final <K, V> V m18994a(@InterfaceC5816d Map<K, ? extends V> map, K k2) {
        C5544i0.m22546f(map, "$this$getOrImplicitDefault");
        if (map instanceof InterfaceC5313x0) {
            return (V) ((InterfaceC5313x0) map).mo19951a(k2);
        }
        V v = map.get(k2);
        if (v != null || map.containsKey(k2)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }

    @InterfaceC5481e(name = "withDefaultMutable")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <K, V> Map<K, V> m18996b(@InterfaceC5816d Map<K, V> map, @InterfaceC5816d InterfaceC5506l<? super K, ? extends V> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$withDefault");
        C5544i0.m22546f(interfaceC5506l, "defaultValue");
        return map instanceof InterfaceC5260f1 ? m18996b(((InterfaceC5260f1) map).mo19739a(), interfaceC5506l) : new C5263g1(map, interfaceC5506l);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m18995a(@InterfaceC5816d Map<K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super K, ? extends V> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$withDefault");
        C5544i0.m22546f(interfaceC5506l, "defaultValue");
        return map instanceof InterfaceC5313x0 ? m18995a((Map) ((InterfaceC5313x0) map).mo19739a(), (InterfaceC5506l) interfaceC5506l) : new C5316y0(map, interfaceC5506l);
    }
}
