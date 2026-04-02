package i.g2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes2.dex */
class c1 extends b1 {
    @j.c.a.d
    public static final <K, V> Map<K, V> a() {
        k0 k0Var = k0.INSTANCE;
        if (k0Var != null) {
            return k0Var;
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> HashMap<K, V> b() {
        return new HashMap<>();
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> LinkedHashMap<K, V> c() {
        return new LinkedHashMap<>();
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> d(@j.c.a.d i.i0<? extends K, ? extends V>... i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "pairs");
        return i0VarArr.length > 0 ? a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length))) : a();
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> Map<K, V> e() {
        return new LinkedHashMap();
    }

    @i.t0(version = "1.1")
    public static final <K, V> V f(@j.c.a.d Map<K, ? extends V> map, K k2) {
        i.q2.t.i0.f(map, "$this$getValue");
        return (V) a1.a(map, k2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static final <K, V, R> Map<R, V> g(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapKeys");
        i.q2.t.i0.f(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(lVar.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <K, V> Map<K, V> h(@j.c.a.e Map<K, ? extends V> map) {
        return map != 0 ? map : a();
    }

    @i.m2.f
    private static final <K, V> V i(@j.c.a.d Map<? extends K, V> map, K k2) {
        if (map != null) {
            return (V) i.q2.t.n1.f(map).remove(k2);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> j(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    @i.j
    @i.t0(version = "1.3")
    @i.m2.f
    private static final <K, V> Map<K, V> a(@i.b i.q2.s.l<? super Map<K, V>, i.y1> lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        lVar.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @j.c.a.d
    public static final <K, V> HashMap<K, V> b(@j.c.a.d i.i0<? extends K, ? extends V>... i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "pairs");
        HashMap<K, V> map = new HashMap<>(b1.b(i0VarArr.length));
        c((Map) map, (i.i0[]) i0VarArr);
        return map;
    }

    @j.c.a.d
    public static final <K, V> LinkedHashMap<K, V> c(@j.c.a.d i.i0<? extends K, ? extends V>... i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "pairs");
        return (LinkedHashMap) a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length)));
    }

    @i.m2.f
    private static final <K, V> Map<K, V> d() {
        return a();
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> e(@j.c.a.d i.i0<? extends K, ? extends V>... i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(i0VarArr.length));
        c((Map) linkedHashMap, (i.i0[]) i0VarArr);
        return linkedHashMap;
    }

    @i.q2.e(name = "mutableIterator")
    @i.m2.f
    private static final <K, V> Iterator<Map.Entry<K, V>> f(@j.c.a.d Map<K, V> map) {
        i.q2.t.i0.f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static final <K, V, R> Map<K, R> h(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapValues");
        i.q2.t.i0.f(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), lVar.invoke(entry));
        }
        return linkedHashMap;
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> i(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$toMap");
        int size = map.size();
        return size != 0 ? size != 1 ? j(map) : b1.b(map) : a();
    }

    @i.j
    @i.t0(version = "1.3")
    @i.m2.f
    private static final <K, V> Map<K, V> a(int i2, @i.b i.q2.s.l<? super Map<K, V>, i.y1> lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.b(i2));
        lVar.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @i.m2.f
    private static final <K, V> boolean b(@j.c.a.d Map<? extends K, ? extends V> map, K k2) {
        i.q2.t.i0.f(map, "$this$contains");
        return map.containsKey(k2);
    }

    @i.t0(version = "1.3")
    @i.m2.f
    private static final <K, V> boolean c(@j.c.a.e Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @i.m2.f
    private static final <K, V> boolean d(@j.c.a.d Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    @i.m2.f
    private static final <K, V> V e(@j.c.a.d Map<? extends K, ? extends V> map, K k2) {
        i.q2.t.i0.f(map, "$this$get");
        return map.get(k2);
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> f(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super V, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filterValues");
        i.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @i.m2.f
    private static final <K, V> boolean a(@j.c.a.d Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @i.m2.f
    private static final <K, V> V b(@j.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        i.q2.t.i0.f(entry, "$this$component2");
        return entry.getValue();
    }

    @i.m2.f
    private static final <K> boolean c(@j.c.a.d Map<? extends K, ?> map, K k2) {
        if (map != null) {
            return map.containsKey(k2);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static final <K, V, R, M extends Map<? super K, ? super R>> M d(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d M m2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapValuesTo");
        i.q2.t.i0.f(m2, "destination");
        i.q2.t.i0.f(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(entry.getKey(), lVar.invoke(entry));
        }
        return m2;
    }

    @i.m2.f
    private static final <K, V> Iterator<Map.Entry<K, V>> e(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Li/q2/s/a<+TR;>;)TR; */
    @i.t0(version = "1.3")
    @i.m2.f
    private static final Object a(Map map, i.q2.s.a aVar) {
        return map.isEmpty() ? aVar.invoke() : map;
    }

    public static final <K, V> V b(@j.c.a.d Map<K, ? extends V> map, K k2, @j.c.a.d i.q2.s.a<? extends V> aVar) {
        i.q2.t.i0.f(map, "$this$getOrElseNullable");
        i.q2.t.i0.f(aVar, "defaultValue");
        V v = map.get(k2);
        return (v != null || map.containsKey(k2)) ? v : aVar.invoke();
    }

    @i.m2.f
    private static final <K, V> i.i0<K, V> c(@j.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        return new i.i0<>(entry.getKey(), entry.getValue());
    }

    public static final <K, V> void e(@j.c.a.d Map<? super K, ? super V> map, @j.c.a.d Iterable<? extends i.i0<? extends K, ? extends V>> iterable) {
        i.q2.t.i0.f(map, "$this$putAll");
        i.q2.t.i0.f(iterable, "pairs");
        for (i.i0<? extends K, ? extends V> i0Var : iterable) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @i.m2.f
    private static final <K, V> void a(@j.c.a.d Map<K, V> map, K k2, V v) {
        i.q2.t.i0.f(map, "$this$set");
        map.put(k2, v);
    }

    public static final <K, V> V c(@j.c.a.d Map<K, V> map, K k2, @j.c.a.d i.q2.s.a<? extends V> aVar) {
        i.q2.t.i0.f(map, "$this$getOrPut");
        i.q2.t.i0.f(aVar, "defaultValue");
        V v = map.get(k2);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        map.put(k2, vInvoke);
        return vInvoke;
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> g(@j.c.a.d Map<? extends K, ? extends V> map, K k2) {
        i.q2.t.i0.f(map, "$this$minus");
        Map mapJ = j(map);
        mapJ.remove(k2);
        return g(mapJ);
    }

    @i.m2.f
    private static final <K, V> K a(@j.c.a.d Map.Entry<? extends K, ? extends V> entry) {
        i.q2.t.i0.f(entry, "$this$component1");
        return entry.getKey();
    }

    public static final <K, V> void e(@j.c.a.d Map<? super K, ? super V> map, @j.c.a.d i.x2.m<? extends i.i0<? extends K, ? extends V>> mVar) {
        i.q2.t.i0.f(map, "$this$putAll");
        i.q2.t.i0.f(mVar, "pairs");
        for (i.i0<? extends K, ? extends V> i0Var : mVar) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> f(@j.c.a.d i.i0<? extends K, ? extends V>[] i0VarArr) {
        i.q2.t.i0.f(i0VarArr, "$this$toMap");
        int length = i0VarArr.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return a(i0VarArr, new LinkedHashMap(b1.b(i0VarArr.length)));
        }
        return b1.a(i0VarArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static final <K, V> Map<K, V> g(@j.c.a.d Map<K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : b1.b(map);
        }
        return a();
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> void h(@j.c.a.d Map<K, V> map, K k2) {
        i.q2.t.i0.f(map, "$this$minusAssign");
        map.remove(k2);
    }

    @i.m2.f
    private static final <K, V> V a(@j.c.a.d Map<K, ? extends V> map, K k2, i.q2.s.a<? extends V> aVar) {
        V v = map.get(k2);
        return v != null ? v : aVar.invoke();
    }

    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M b(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d M m2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filterTo");
        i.q2.t.i0.f(m2, "destination");
        i.q2.t.i0.f(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> d(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super K, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filterKeys");
        i.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d M m2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filterNotTo");
        i.q2.t.i0.f(m2, "destination");
        i.q2.t.i0.f(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static final <K, V, R, M extends Map<? super R, ? super V>> M c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d M m2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapKeysTo");
        i.q2.t.i0.f(m2, "destination");
        i.q2.t.i0.f(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(lVar.invoke(entry), entry.getValue());
        }
        return m2;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> e(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filterNot");
        i.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<? super K, ? super V> map, i.i0<? extends K, ? extends V> i0Var) {
        i.q2.t.i0.f(map, "$this$plusAssign");
        map.put(i0Var.getFirst(), i0Var.getSecond());
    }

    @j.c.a.d
    public static <K, V> Map<K, V> a(@j.c.a.d Iterable<? extends i.i0<? extends K, ? extends V>> iterable) {
        i.q2.t.i0.f(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return a();
            }
            if (size != 1) {
                return a(iterable, new LinkedHashMap(b1.b(collection.size())));
            }
            return b1.a(iterable instanceof List ? (i.i0<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        return g(a(iterable, new LinkedHashMap()));
    }

    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<? super K, ? super V> map, i.i0<? extends K, ? extends V>[] i0VarArr) {
        i.q2.t.i0.f(map, "$this$plusAssign");
        c((Map) map, (i.i0[]) i0VarArr);
    }

    @i.m2.f
    private static final <K, V> void d(@j.c.a.d Map<? super K, ? super V> map, Iterable<? extends i.i0<? extends K, ? extends V>> iterable) {
        i.q2.t.i0.f(map, "$this$plusAssign");
        e((Map) map, (Iterable) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        i.q2.t.i0.f(map, "$this$plusAssign");
        map.putAll(map2);
    }

    public static final <K, V> void c(@j.c.a.d Map<? super K, ? super V> map, @j.c.a.d i.i0<? extends K, ? extends V>[] i0VarArr) {
        i.q2.t.i0.f(map, "$this$putAll");
        i.q2.t.i0.f(i0VarArr, "pairs");
        for (i.i0<? extends K, ? extends V> i0Var : i0VarArr) {
            map.put(i0Var.component1(), i0Var.component2());
        }
    }

    @i.m2.f
    private static final <K, V> void d(@j.c.a.d Map<? super K, ? super V> map, i.x2.m<? extends i.i0<? extends K, ? extends V>> mVar) {
        i.q2.t.i0.f(map, "$this$plusAssign");
        e((Map) map, (i.x2.m) mVar);
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<K, V> map, Iterable<? extends K> iterable) {
        i.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), iterable);
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<K, V> map, K[] kArr) {
        i.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), kArr);
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$filter");
        i.q2.t.i0.f(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <K, V> void b(@j.c.a.d Map<K, V> map, i.x2.m<? extends K> mVar) {
        i.q2.t.i0.f(map, "$this$minusAssign");
        d0.d(map.keySet(), mVar);
    }

    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@j.c.a.d Iterable<? extends i.i0<? extends K, ? extends V>> iterable, @j.c.a.d M m2) {
        i.q2.t.i0.f(iterable, "$this$toMap");
        i.q2.t.i0.f(m2, "destination");
        e((Map) m2, (Iterable) iterable);
        return m2;
    }

    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@j.c.a.d i.i0<? extends K, ? extends V>[] i0VarArr, @j.c.a.d M m2) {
        i.q2.t.i0.f(i0VarArr, "$this$toMap");
        i.q2.t.i0.f(m2, "destination");
        c((Map) m2, (i.i0[]) i0VarArr);
        return m2;
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d M m2) {
        i.q2.t.i0.f(map, "$this$toMap");
        i.q2.t.i0.f(m2, "destination");
        m2.putAll(map);
        return m2;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d i.x2.m<? extends i.i0<? extends K, ? extends V>> mVar) {
        i.q2.t.i0.f(mVar, "$this$toMap");
        return g(a(mVar, new LinkedHashMap()));
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d Iterable<? extends i.i0<? extends K, ? extends V>> iterable) {
        i.q2.t.i0.f(map, "$this$plus");
        i.q2.t.i0.f(iterable, "pairs");
        if (map.isEmpty()) {
            return a(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        e((Map) linkedHashMap, (Iterable) iterable);
        return linkedHashMap;
    }

    @j.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@j.c.a.d i.x2.m<? extends i.i0<? extends K, ? extends V>> mVar, @j.c.a.d M m2) {
        i.q2.t.i0.f(mVar, "$this$toMap");
        i.q2.t.i0.f(m2, "destination");
        e((Map) m2, (i.x2.m) mVar);
        return m2;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.x2.m<? extends i.i0<? extends K, ? extends V>> mVar) {
        i.q2.t.i0.f(map, "$this$plus");
        i.q2.t.i0.f(mVar, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        e((Map) linkedHashMap, (i.x2.m) mVar);
        return g(linkedHashMap);
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.i0<? extends K, ? extends V> i0Var) {
        i.q2.t.i0.f(map, "$this$plus");
        i.q2.t.i0.f(i0Var, "pair");
        if (map.isEmpty()) {
            return b1.a(i0Var);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(i0Var.getFirst(), i0Var.getSecond());
        return linkedHashMap;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.i0<? extends K, ? extends V>[] i0VarArr) {
        i.q2.t.i0.f(map, "$this$plus");
        i.q2.t.i0.f(i0VarArr, "pairs");
        if (map.isEmpty()) {
            return f(i0VarArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        c((Map) linkedHashMap, (i.i0[]) i0VarArr);
        return linkedHashMap;
    }

    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d Map<? extends K, ? extends V> map2) {
        i.q2.t.i0.f(map, "$this$plus");
        i.q2.t.i0.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d Iterable<? extends K> iterable) {
        i.q2.t.i0.f(map, "$this$minus");
        i.q2.t.i0.f(iterable, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), iterable);
        return g(mapJ);
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d K[] kArr) {
        i.q2.t.i0.f(map, "$this$minus");
        i.q2.t.i0.f(kArr, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), kArr);
        return g(mapJ);
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V> Map<K, V> a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.x2.m<? extends K> mVar) {
        i.q2.t.i0.f(map, "$this$minus");
        i.q2.t.i0.f(mVar, "keys");
        Map mapJ = j(map);
        d0.d(mapJ.keySet(), mVar);
        return g(mapJ);
    }
}
