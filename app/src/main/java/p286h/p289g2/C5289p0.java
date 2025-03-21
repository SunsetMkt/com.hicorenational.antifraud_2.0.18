package p286h.p289g2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p286h.C5226e1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5539g1;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5560n1;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: GroupingJVM.kt */
/* renamed from: h.g2.p0 */
/* loaded from: classes2.dex */
class C5289p0 {
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K> Map<K, Integer> m20137a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0) {
        C5544i0.m22546f(interfaceC5283n0, "$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            K mo19949a = interfaceC5283n0.mo19949a(mo19950a.next());
            Object obj = linkedHashMap.get(mo19949a);
            if (obj == null && !linkedHashMap.containsKey(mo19949a)) {
                obj = new C5539g1.f();
            }
            C5539g1.f fVar = (C5539g1.f) obj;
            fVar.element++;
            linkedHashMap.put(mo19949a, fVar);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            C5560n1.m22603g(entry).setValue(Integer.valueOf(((C5539g1.f) entry.getValue()).element));
        }
        return C5560n1.m22601f(linkedHashMap);
    }

    @InterfaceC5426f
    @InterfaceC5440n0
    /* renamed from: a */
    private static final <K, V, R> Map<K, R> m20138a(@InterfaceC5816d Map<K, V> map, InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            C5560n1.m22603g(entry).setValue(interfaceC5506l.invoke(entry));
        }
        if (map != null) {
            return C5560n1.m22601f(map);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
}
