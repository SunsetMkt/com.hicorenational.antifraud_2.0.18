package p286h.p289g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import p286h.C5334i0;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* renamed from: h.g2.b1 */
/* loaded from: classes2.dex */
public class C5248b1 extends C5242a1 {

    /* renamed from: a */
    private static final int f20101a = 1073741824;

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> Map<K, V> m19557a(@InterfaceC5816d C5334i0<? extends K, ? extends V> c5334i0) {
        C5544i0.m22546f(c5334i0, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(c5334i0.getFirst(), c5334i0.getSecond());
        C5544i0.m22521a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: a */
    private static final void m19561a(int i2) {
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static int m19562b(int i2) {
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

    @InterfaceC5816d
    /* renamed from: b */
    public static final <K, V> Map<K, V> m19563b(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C5544i0.m22521a((Object) singletonMap, "java.util.Collections.singletonMap(key, value)");
        C5544i0.m22521a((Object) singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <K, V> Map<K, V> m19564c(@InterfaceC5816d Map<K, ? extends V> map) {
        return m19563b(map);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m19565d(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    /* renamed from: a */
    public static final <K, V> V m19556a(@InterfaceC5816d ConcurrentMap<K, V> concurrentMap, K k2, @InterfaceC5816d InterfaceC5495a<? extends V> interfaceC5495a) {
        C5544i0.m22546f(concurrentMap, "$this$getOrPut");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        V v = concurrentMap.get(k2);
        if (v != null) {
            return v;
        }
        V invoke = interfaceC5495a.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k2, invoke);
        return putIfAbsent != null ? putIfAbsent : invoke;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V> SortedMap<K, V> m19559a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d Comparator<? super K> comparator) {
        C5544i0.m22546f(map, "$this$toSortedMap");
        C5544i0.m22546f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m19560a(@InterfaceC5816d C5334i0<? extends K, ? extends V>... c5334i0Arr) {
        C5544i0.m22546f(c5334i0Arr, "pairs");
        TreeMap treeMap = new TreeMap();
        C5251c1.m19620c((Map) treeMap, (C5334i0[]) c5334i0Arr);
        return treeMap;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Properties m19558a(@InterfaceC5816d Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }
}
