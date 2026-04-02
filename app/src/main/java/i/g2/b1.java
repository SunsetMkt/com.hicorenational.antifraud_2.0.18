package i.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class b1 extends a1 {
    private static final int a = 1073741824;

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d i.i0<? extends K, ? extends V> i0Var) {
        i.q2.t.i0.f(i0Var, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(i0Var.getFirst(), i0Var.getSecond());
        i.q2.t.i0.a((Object) mapSingletonMap, "java.util.Collections.si\u2026(pair.first, pair.second)");
        return mapSingletonMap;
    }

    @i.n0
    @i.t0(version = "1.3")
    @i.j
    @i.m2.f
    private static final void a(int i2) {
    }

    @i.n0
    public static int b(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> b(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        i.q2.t.i0.a((Object) mapSingletonMap, "java.util.Collections.singletonMap(key, value)");
        i.q2.t.i0.a((Object) mapSingletonMap, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    @i.m2.f
    private static final <K, V> Map<K, V> c(@j.c.a.d Map<K, ? extends V> map) {
        return b(map);
    }

    @j.c.a.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> d(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> V a(@j.c.a.d ConcurrentMap<K, V> concurrentMap, K k2, @j.c.a.d i.q2.s.a<? extends V> aVar) {
        i.q2.t.i0.f(concurrentMap, "$this$getOrPut");
        i.q2.t.i0.f(aVar, "defaultValue");
        V v = concurrentMap.get(k2);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k2, vInvoke);
        return vPutIfAbsent != null ? vPutIfAbsent : vInvoke;
    }

    @j.c.a.d
    public static final <K, V> SortedMap<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d Comparator<? super K> comparator) {
        i.q2.t.i0.f(map, "$this$toSortedMap");
        i.q2.t.i0.f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    @j.c.a.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> a(@j.c.a.d i.i0<? extends K, ? extends V>... i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "pairs");
        TreeMap treeMap = new TreeMap();
        c1.c((Map) treeMap, (i.i0[]) i0VarArr);
        return treeMap;
    }

    @i.m2.f
    private static final Properties a(@j.c.a.d Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }
}
