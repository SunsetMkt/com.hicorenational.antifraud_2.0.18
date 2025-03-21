package h.g2;

import h.q2.t.g1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: GroupingJVM.kt */
/* loaded from: classes2.dex */
class p0 {
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K> Map<K, Integer> a(@i.c.a.d n0<T, ? extends K> n0Var) {
        h.q2.t.i0.f(n0Var, "$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            K a3 = n0Var.a(a2.next());
            Object obj = linkedHashMap.get(a3);
            if (obj == null && !linkedHashMap.containsKey(a3)) {
                obj = new g1.f();
            }
            g1.f fVar = (g1.f) obj;
            fVar.element++;
            linkedHashMap.put(a3, fVar);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry == null) {
                throw new h.e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            h.q2.t.n1.g(entry).setValue(Integer.valueOf(((g1.f) entry.getValue()).element));
        }
        return h.q2.t.n1.f(linkedHashMap);
    }

    @h.m2.f
    @h.n0
    private static final <K, V, R> Map<K, R> a(@i.c.a.d Map<K, V> map, h.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry == null) {
                throw new h.e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            h.q2.t.n1.g(entry).setValue(lVar.invoke(entry));
        }
        if (map != null) {
            return h.q2.t.n1.f(map);
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
}
