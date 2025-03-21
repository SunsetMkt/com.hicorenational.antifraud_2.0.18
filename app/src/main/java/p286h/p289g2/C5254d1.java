package p286h.p289g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p286h.C5334i0;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5425e;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: _Maps.kt */
/* renamed from: h.g2.d1 */
/* loaded from: classes2.dex */
class C5254d1 extends C5251c1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <K, V, R, C extends Collection<? super R>> C m19692a(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d C c2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$flatMapTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(interfaceC5506l, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C5253d0.m19665a((Collection) c2, (Iterable) interfaceC5506l.invoke(it.next()));
        }
        return c2;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <K, V> Map.Entry<K, V> m19695b(@InterfaceC5816d Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) C5262g0.m19811b((Iterable) map.entrySet(), (Comparator) comparator);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <K, V, R, C extends Collection<? super R>> C m19697c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d C c2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$mapTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(interfaceC5506l, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c2.add(interfaceC5506l.invoke(it.next()));
        }
        return c2;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final <K, V> InterfaceC5699m<Map.Entry<K, V>> m19699e(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$asSequence");
        return C5262g0.m19888i((Iterable) map.entrySet());
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final <K, V> int m19700f(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        return map.size();
    }

    /* renamed from: h */
    public static final <K, V> boolean m19701h(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$none");
        return map.isEmpty();
    }

    /* renamed from: i */
    public static final <K, V> boolean m19702i(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$all");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!interfaceC5506l.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    public static final <K, V> boolean m19703j(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$any");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (interfaceC5506l.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @InterfaceC5816d
    /* renamed from: k */
    public static final <K, V> List<C5334i0<K, V>> m19705k(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$toList");
        if (map.size() == 0) {
            return C5315y.m21775b();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return C5315y.m21775b();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return C5312x.m21750a(new C5334i0(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new C5334i0(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new C5334i0(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    @InterfaceC5816d
    /* renamed from: l */
    public static final <K, V, R> List<R> m19706l(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$flatMap");
        C5544i0.m22546f(interfaceC5506l, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C5253d0.m19665a((Collection) arrayList, (Iterable) interfaceC5506l.invoke(it.next()));
        }
        return arrayList;
    }

    @InterfaceC5425e
    /* renamed from: m */
    public static final <K, V> void m19707m(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$forEach");
        C5544i0.m22546f(interfaceC5506l, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            interfaceC5506l.invoke(it.next());
        }
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static final <K, V, R> List<R> m19708n(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$map");
        C5544i0.m22546f(interfaceC5506l, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(interfaceC5506l.invoke(it.next()));
        }
        return arrayList;
    }

    @InterfaceC5816d
    /* renamed from: o */
    public static final <K, V, R> List<R> m19709o(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$mapNotNull");
        C5544i0.m22546f(interfaceC5506l, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = interfaceC5506l.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m19710p(@InterfaceC5816d Map<? extends K, ? extends V> map, InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        Map.Entry<K, V> entry;
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R invoke = interfaceC5506l.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R invoke2 = interfaceC5506l.invoke(entry2);
                    if (invoke.compareTo(invoke2) < 0) {
                        entry = entry2;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    @InterfaceC5817e
    /* renamed from: q */
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m19711q(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        Map.Entry<K, V> entry;
        C5544i0.m22546f(map, "$this$minBy");
        C5544i0.m22546f(interfaceC5506l, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R invoke = interfaceC5506l.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R invoke2 = interfaceC5506l.invoke(entry2);
                    if (invoke.compareTo(invoke2) > 0) {
                        entry = entry2;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    /* renamed from: r */
    public static final <K, V> boolean m19712r(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$none");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (interfaceC5506l.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: s */
    public static final <K, V, M extends Map<? extends K, ? extends V>> M m19713s(@InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(m2, "$this$onEach");
        C5544i0.m22546f(interfaceC5506l, "action");
        Iterator<Map.Entry<K, V>> it = m2.entrySet().iterator();
        while (it.hasNext()) {
            interfaceC5506l.invoke(it.next());
        }
        return m2;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <K, V, R, C extends Collection<? super R>> C m19694b(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d C c2, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$mapNotNullTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(interfaceC5506l, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = interfaceC5506l.invoke(it.next());
            if (invoke != null) {
                c2.add(invoke);
            }
        }
        return c2;
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final <K, V> Map.Entry<K, V> m19698c(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        C5544i0.m22546f(map, "$this$minWith");
        C5544i0.m22546f(comparator, "comparator");
        return (Map.Entry) C5262g0.m19834c((Iterable) map.entrySet(), (Comparator) comparator);
    }

    /* renamed from: a */
    public static final <K, V> boolean m19693a(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "$this$any");
        return !map.isEmpty();
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <K, V> Iterable<Map.Entry<K, V>> m19696c(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    /* renamed from: k */
    public static final <K, V> int m19704k(@InterfaceC5816d Map<? extends K, ? extends V> map, @InterfaceC5816d InterfaceC5506l<? super Map.Entry<? extends K, ? extends V>, Boolean> interfaceC5506l) {
        C5544i0.m22546f(map, "$this$count");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int i2 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (interfaceC5506l.invoke(it.next()).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }
}
