package i.g2;

import i.q2.t.g1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: GroupingJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class p0 {
    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <T, K> Map<K, Integer> a(@j.c.a.d n0<T, ? extends K> n0Var) {
        i.q2.t.i0.f(n0Var, "$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itA = n0Var.a();
        while (itA.hasNext()) {
            K kA = n0Var.a(itA.next());
            Object fVar = linkedHashMap.get(kA);
            if (fVar == null && !linkedHashMap.containsKey(kA)) {
                fVar = new g1.f();
            }
            g1.f fVar2 = (g1.f) fVar;
            fVar2.element++;
            linkedHashMap.put(kA, fVar2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry == null) {
                throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            i.q2.t.n1.g(entry).setValue(Integer.valueOf(((g1.f) entry.getValue()).element));
        }
        return i.q2.t.n1.f(linkedHashMap);
    }

    @i.n0
    @i.m2.f
    private static final <K, V, R> Map<K, R> a(@j.c.a.d Map<K, V> map, i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry == null) {
                throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            i.q2.t.n1.g(entry).setValue(lVar.invoke(entry));
        }
        if (map != null) {
            return i.q2.t.n1.f(map);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
}
