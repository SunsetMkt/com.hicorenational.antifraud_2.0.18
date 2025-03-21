package p286h.p289g2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.C5715y1;
import p286h.InterfaceC5212b;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5560n1;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Maps.kt */
/* renamed from: h.g2.c1 */
/* loaded from: classes2.dex */
class C5251c1 extends C5248b1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19582a() {
        C5274k0 c5274k0 = C5274k0.INSTANCE;
        if (c5274k0 != null) {
            return c5274k0;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <K, V> HashMap<K, V> m19601b() {
        return new HashMap<>();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final <K, V> LinkedHashMap<K, V> m19613c() {
        return new LinkedHashMap<>();
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <K, V> Map<K, V> m19626d(@InterfaceC5816d C5334i0<? extends K, ? extends V>... c5334i0Arr) {
        int m19562b;
        C5544i0.m22546f(c5334i0Arr, "pairs");
        if (c5334i0Arr.length <= 0) {
            return m19582a();
        }
        m19562b = C5248b1.m19562b(c5334i0Arr.length);
        return m19596a(c5334i0Arr, new LinkedHashMap(m19562b));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: e */
    private static final <K, V> Map<K, V> m19632e() {
        return new LinkedHashMap();
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: f */
    public static final <K, V> V m19637f(@InterfaceC5816d Map<K, ? extends V> map, K k2) {
        C5544i0.m22546f(map, "$this$getValue");
        return (V) C5242a1.m18994a(map, k2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: g */
    public static final <K, V, R> Map<R, V> m19642g(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        int m19562b;
        C5544i0.m22546f(map, "$this$mapKeys");
        C5544i0.m22546f(interfaceC5506l, "transform");
        m19562b = C5248b1.m19562b(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m19562b);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(interfaceC5506l.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: h */
    private static final <K, V> Map<K, V> m19644h(@InterfaceC5817e Map<K, ? extends V> map) {
        return map != 0 ? map : m19582a();
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final <K, V> V m19647i(@InterfaceC5816d Map<? extends K, V> map, K k2) {
        if (map != null) {
            return (V) C5560n1.m22601f(map).remove(k2);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: j */
    public static final <K, V> Map<K, V> m19649j(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final <K, V> Map<K, V> m19584a(@InterfaceC5212b InterfaceC5506l<? super Map<K, V>, C5715y1> interfaceC5506l) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        interfaceC5506l.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <K, V> HashMap<K, V> m19602b(@InterfaceC5816d C5334i0<? extends K, ? extends V>... c5334i0Arr) {
        int m19562b;
        C5544i0.m22546f(c5334i0Arr, "pairs");
        m19562b = C5248b1.m19562b(c5334i0Arr.length);
        HashMap<K, V> hashMap = new HashMap<>(m19562b);
        m19620c((Map) hashMap, (C5334i0[]) c5334i0Arr);
        return hashMap;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V> LinkedHashMap<K, V> m19614c(@InterfaceC5816d C5334i0<? extends K, ? extends V>... c5334i0Arr) {
        int m19562b;
        C5544i0.m22546f(c5334i0Arr, "pairs");
        m19562b = C5248b1.m19562b(c5334i0Arr.length);
        return (LinkedHashMap) m19596a(c5334i0Arr, new LinkedHashMap(m19562b));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <K, V> Map<K, V> m19623d() {
        return m19582a();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final <K, V> Map<K, V> m19634e(@InterfaceC5816d C5334i0<? extends K, ? extends V>... c5334i0Arr) {
        int m19562b;
        C5544i0.m22546f(c5334i0Arr, "pairs");
        m19562b = C5248b1.m19562b(c5334i0Arr.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(m19562b);
        m19620c((Map) linkedHashMap, (C5334i0[]) c5334i0Arr);
        return linkedHashMap;
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "mutableIterator")
    /* renamed from: f */
    private static final <K, V> Iterator<Map.Entry<K, V>> m19638f(@InterfaceC5816d Map<K, V> map) {
        C5544i0.m22546f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: h */
    public static final <K, V, R> Map<K, R> m19645h(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        int m19562b;
        C5544i0.m22546f(map, "$this$mapValues");
        C5544i0.m22546f(interfaceC5506l, "transform");
        m19562b = C5248b1.m19562b(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m19562b);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), interfaceC5506l.invoke(entry));
        }
        return linkedHashMap;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: i */
    public static final <K, V> Map<K, V> m19648i(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$toMap");
        int size = map.size();
        return size != 0 ? size != 1 ? m19649j(map) : C5248b1.m19563b(map) : m19582a();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final <K, V> Map<K, V> m19583a(int i2, @InterfaceC5212b InterfaceC5506l<? super Map<K, V>, C5715y1> interfaceC5506l) {
        int m19562b;
        m19562b = C5248b1.m19562b(i2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(m19562b);
        interfaceC5506l.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> boolean m19610b(@InterfaceC5816d Map<? extends K, ? extends V> map, K k2) {
        C5544i0.m22546f(map, "$this$contains");
        return map.containsKey(k2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: c */
    private static final <K, V> boolean m19621c(@InterfaceC5817e Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <K, V> boolean m19629d(@InterfaceC5816d Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final <K, V> V m19630e(@InterfaceC5816d Map<? extends K, ? extends V> map, K k2) {
        C5544i0.m22546f(map, "$this$get");
        return map.get(k2);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final <K, V> Map<K, V> m19639f(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super V, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filterValues");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (interfaceC5506l.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <K, V> boolean m19598a(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> V m19599b(@InterfaceC5816d Map.Entry<? extends K, ? extends V> entry) {
        C5544i0.m22546f(entry, "$this$component2");
        return entry.getValue();
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <K> boolean m19622c(@InterfaceC5816d Map<? extends K, ?> map, K k2) {
        if (map != null) {
            return map.containsKey(k2);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: d */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M m19625d(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$mapValuesTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5506l, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(entry.getKey(), interfaceC5506l.invoke(entry));
        }
        return m2;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final <K, V> Iterator<Map.Entry<K, V>> m19631e(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lh/q2/s/a<+TR;>;)TR; */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final Object m19580a(Map map, InterfaceC5495a interfaceC5495a) {
        return map.isEmpty() ? interfaceC5495a.invoke() : map;
    }

    /* renamed from: b */
    public static final <K, V> V m19600b(@InterfaceC5816d Map<K, ? extends V> map, K k2, @InterfaceC5816d InterfaceC5495a<? extends V> interfaceC5495a) {
        C5544i0.m22546f(map, "$this$getOrElseNullable");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        V v = map.get(k2);
        return (v != null || map.containsKey(k2)) ? v : interfaceC5495a.invoke();
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <K, V> C5334i0<K, V> m19611c(@InterfaceC5816d Map.Entry<? extends K, ? extends V> entry) {
        return new C5334i0<>(entry.getKey(), entry.getValue());
    }

    /* renamed from: e */
    public static final <K, V> void m19636e(@InterfaceC5816d Map<? super K, ? super V> map, @InterfaceC5816d Iterable<? extends C5334i0<? extends K, ? extends V>> iterable) {
        C5544i0.m22546f(map, "$this$putAll");
        C5544i0.m22546f(iterable, "pairs");
        for (C5334i0<? extends K, ? extends V> c5334i0 : iterable) {
            map.put(c5334i0.component1(), c5334i0.component2());
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <K, V> void m19597a(@InterfaceC5816d Map<K, V> map, K k2, V v) {
        C5544i0.m22546f(map, "$this$set");
        map.put(k2, v);
    }

    /* renamed from: c */
    public static final <K, V> V m19612c(@InterfaceC5816d Map<K, V> map, K k2, @InterfaceC5816d InterfaceC5495a<? extends V> interfaceC5495a) {
        C5544i0.m22546f(map, "$this$getOrPut");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        V v = map.get(k2);
        if (v != null) {
            return v;
        }
        V invoke = interfaceC5495a.invoke();
        map.put(k2, invoke);
        return invoke;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: g */
    public static final <K, V> Map<K, V> m19643g(@InterfaceC5816d Map<? extends K, ? extends V> map, K k2) {
        C5544i0.m22546f(map, "$this$minus");
        Map m19649j = m19649j(map);
        m19649j.remove(k2);
        return m19641g(m19649j);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <K, V> K m19579a(@InterfaceC5816d Map.Entry<? extends K, ? extends V> entry) {
        C5544i0.m22546f(entry, "$this$component1");
        return entry.getKey();
    }

    /* renamed from: e */
    public static final <K, V> void m19635e(@InterfaceC5816d Map<? super K, ? super V> map, @InterfaceC5816d InterfaceC5699m<? extends C5334i0<? extends K, ? extends V>> interfaceC5699m) {
        C5544i0.m22546f(map, "$this$putAll");
        C5544i0.m22546f(interfaceC5699m, "pairs");
        for (C5334i0<? extends K, ? extends V> c5334i0 : interfaceC5699m) {
            map.put(c5334i0.component1(), c5334i0.component2());
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final <K, V> Map<K, V> m19640f(@InterfaceC5816d C5334i0<? extends K, ? extends V>[] c5334i0Arr) {
        int m19562b;
        C5544i0.m22546f(c5334i0Arr, "$this$toMap");
        int length = c5334i0Arr.length;
        if (length == 0) {
            return m19582a();
        }
        if (length != 1) {
            m19562b = C5248b1.m19562b(c5334i0Arr.length);
            return m19596a(c5334i0Arr, new LinkedHashMap(m19562b));
        }
        return C5248b1.m19557a(c5334i0Arr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: g */
    public static final <K, V> Map<K, V> m19641g(@InterfaceC5816d Map<K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : C5248b1.m19563b(map);
        }
        return m19582a();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: h */
    private static final <K, V> void m19646h(@InterfaceC5816d Map<K, V> map, K k2) {
        C5544i0.m22546f(map, "$this$minusAssign");
        map.remove(k2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <K, V> V m19581a(@InterfaceC5816d Map<K, ? extends V> map, K k2, InterfaceC5495a<? extends V> interfaceC5495a) {
        V v = map.get(k2);
        return v != null ? v : interfaceC5495a.invoke();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19603b(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filterTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (interfaceC5506l.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <K, V> Map<K, V> m19624d(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super K, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filterKeys");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (interfaceC5506l.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19593a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filterNotTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!interfaceC5506l.invoke(entry).booleanValue()) {
                m2.put(entry.getKey(), entry.getValue());
            }
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M m19619c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$mapKeysTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5506l, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m2.put(interfaceC5506l.invoke(entry), entry.getValue());
        }
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final <K, V> Map<K, V> m19633e(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filterNot");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!interfaceC5506l.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> void m19604b(@InterfaceC5816d Map<? super K, ? super V> map, C5334i0<? extends K, ? extends V> c5334i0) {
        C5544i0.m22546f(map, "$this$plusAssign");
        map.put(c5334i0.getFirst(), c5334i0.getSecond());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static <K, V> Map<K, V> m19587a(@InterfaceC5816d Iterable<? extends C5334i0<? extends K, ? extends V>> iterable) {
        int m19562b;
        C5544i0.m22546f(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return m19582a();
            }
            if (size == 1) {
                return C5248b1.m19557a(iterable instanceof List ? (C5334i0<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            m19562b = C5248b1.m19562b(collection.size());
            return m19588a(iterable, new LinkedHashMap(m19562b));
        }
        return m19641g(m19588a(iterable, new LinkedHashMap()));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> void m19608b(@InterfaceC5816d Map<? super K, ? super V> map, C5334i0<? extends K, ? extends V>[] c5334i0Arr) {
        C5544i0.m22546f(map, "$this$plusAssign");
        m19620c((Map) map, (C5334i0[]) c5334i0Arr);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <K, V> void m19628d(@InterfaceC5816d Map<? super K, ? super V> map, Iterable<? extends C5334i0<? extends K, ? extends V>> iterable) {
        C5544i0.m22546f(map, "$this$plusAssign");
        m19636e((Map) map, (Iterable) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> void m19607b(@InterfaceC5816d Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        C5544i0.m22546f(map, "$this$plusAssign");
        map.putAll(map2);
    }

    /* renamed from: c */
    public static final <K, V> void m19620c(@InterfaceC5816d Map<? super K, ? super V> map, @InterfaceC5816d C5334i0<? extends K, ? extends V>[] c5334i0Arr) {
        C5544i0.m22546f(map, "$this$putAll");
        C5544i0.m22546f(c5334i0Arr, "pairs");
        for (C5334i0<? extends K, ? extends V> c5334i0 : c5334i0Arr) {
            map.put(c5334i0.component1(), c5334i0.component2());
        }
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <K, V> void m19627d(@InterfaceC5816d Map<? super K, ? super V> map, InterfaceC5699m<? extends C5334i0<? extends K, ? extends V>> interfaceC5699m) {
        C5544i0.m22546f(map, "$this$plusAssign");
        m19635e((Map) map, (InterfaceC5699m) interfaceC5699m);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <K, V> void m19606b(@InterfaceC5816d Map<K, V> map, Iterable<? extends K> iterable) {
        C5544i0.m22546f(map, "$this$minusAssign");
        C5253d0.m19684d(map.keySet(), iterable);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <K, V> void m19609b(@InterfaceC5816d Map<K, V> map, K[] kArr) {
        C5544i0.m22546f(map, "$this$minusAssign");
        C5253d0.m19685d(map.keySet(), kArr);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V> Map<K, V> m19615c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$filter");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (interfaceC5506l.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <K, V> void m19605b(@InterfaceC5816d Map<K, V> map, InterfaceC5699m<? extends K> interfaceC5699m) {
        C5544i0.m22546f(map, "$this$minusAssign");
        C5253d0.m19683d(map.keySet(), interfaceC5699m);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19588a(@InterfaceC5816d Iterable<? extends C5334i0<? extends K, ? extends V>> iterable, @InterfaceC5816d M m2) {
        C5544i0.m22546f(iterable, "$this$toMap");
        C5544i0.m22546f(m2, "destination");
        m19636e((Map) m2, (Iterable) iterable);
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19596a(@InterfaceC5816d C5334i0<? extends K, ? extends V>[] c5334i0Arr, @InterfaceC5816d M m2) {
        C5544i0.m22546f(c5334i0Arr, "$this$toMap");
        C5544i0.m22546f(m2, "destination");
        m19620c((Map) m2, (C5334i0[]) c5334i0Arr);
        return m2;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19618c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d M m2) {
        C5544i0.m22546f(map, "$this$toMap");
        C5544i0.m22546f(m2, "destination");
        m2.putAll(map);
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19585a(@InterfaceC5816d InterfaceC5699m<? extends C5334i0<? extends K, ? extends V>> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$toMap");
        return m19641g(m19586a(interfaceC5699m, new LinkedHashMap()));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V> Map<K, V> m19617c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d Iterable<? extends C5334i0<? extends K, ? extends V>> iterable) {
        Map<K, V> m19587a;
        C5544i0.m22546f(map, "$this$plus");
        C5544i0.m22546f(iterable, "pairs");
        if (map.isEmpty()) {
            m19587a = m19587a(iterable);
            return m19587a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        m19636e((Map) linkedHashMap, (Iterable) iterable);
        return linkedHashMap;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m19586a(@InterfaceC5816d InterfaceC5699m<? extends C5334i0<? extends K, ? extends V>> interfaceC5699m, @InterfaceC5816d M m2) {
        C5544i0.m22546f(interfaceC5699m, "$this$toMap");
        C5544i0.m22546f(m2, "destination");
        m19635e((Map) m2, (InterfaceC5699m) interfaceC5699m);
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V> Map<K, V> m19616c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5699m<? extends C5334i0<? extends K, ? extends V>> interfaceC5699m) {
        C5544i0.m22546f(map, "$this$plus");
        C5544i0.m22546f(interfaceC5699m, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        m19635e((Map) linkedHashMap, (InterfaceC5699m) interfaceC5699m);
        return m19641g(linkedHashMap);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19589a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d C5334i0<? extends K, ? extends V> c5334i0) {
        C5544i0.m22546f(map, "$this$plus");
        C5544i0.m22546f(c5334i0, "pair");
        if (map.isEmpty()) {
            return C5248b1.m19557a(c5334i0);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(c5334i0.getFirst(), c5334i0.getSecond());
        return linkedHashMap;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19594a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d C5334i0<? extends K, ? extends V>[] c5334i0Arr) {
        C5544i0.m22546f(map, "$this$plus");
        C5544i0.m22546f(c5334i0Arr, "pairs");
        if (map.isEmpty()) {
            return m19640f(c5334i0Arr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        m19620c((Map) linkedHashMap, (C5334i0[]) c5334i0Arr);
        return linkedHashMap;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19592a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d Map<? extends K, ? extends V> map2) {
        C5544i0.m22546f(map, "$this$plus");
        C5544i0.m22546f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19591a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d Iterable<? extends K> iterable) {
        C5544i0.m22546f(map, "$this$minus");
        C5544i0.m22546f(iterable, "keys");
        Map m19649j = m19649j(map);
        C5253d0.m19684d(m19649j.keySet(), iterable);
        return m19641g(m19649j);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19595a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d K[] kArr) {
        C5544i0.m22546f(map, "$this$minus");
        C5544i0.m22546f(kArr, "keys");
        Map m19649j = m19649j(map);
        C5253d0.m19685d(m19649j.keySet(), kArr);
        return m19641g(m19649j);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19590a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5699m<? extends K> interfaceC5699m) {
        C5544i0.m22546f(map, "$this$minus");
        C5544i0.m22546f(interfaceC5699m, "keys");
        Map m19649j = m19649j(map);
        C5253d0.m19683d(m19649j.keySet(), interfaceC5699m);
        return m19641g(m19649j);
    }
}
