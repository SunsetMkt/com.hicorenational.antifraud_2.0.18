package i.g2;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes2.dex */
class a1 {
    @i.n0
    @i.q2.e(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V a(@j.c.a.d Map<K, ? extends V> map, K k2) {
        i.q2.t.i0.f(map, "$this$getOrImplicitDefault");
        if (map instanceof x0) {
            return (V) ((x0) map).a(k2);
        }
        V v = map.get(k2);
        if (v != null || map.containsKey(k2)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }

    @i.q2.e(name = "withDefaultMutable")
    @j.c.a.d
    public static final <K, V> Map<K, V> b(@j.c.a.d Map<K, V> map, @j.c.a.d i.q2.s.l<? super K, ? extends V> lVar) {
        i.q2.t.i0.f(map, "$this$withDefault");
        i.q2.t.i0.f(lVar, "defaultValue");
        return map instanceof f1 ? b(((f1) map).a(), lVar) : new g1(map, lVar);
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<K, ? extends V> map, @j.c.a.d i.q2.s.l<? super K, ? extends V> lVar) {
        i.q2.t.i0.f(map, "$this$withDefault");
        i.q2.t.i0.f(lVar, "defaultValue");
        return map instanceof x0 ? a((Map) ((x0) map).a(), (i.q2.s.l) lVar) : new y0(map, lVar);
    }
}
