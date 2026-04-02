package i.g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: _Maps.kt */
/* JADX INFO: loaded from: classes2.dex */
class d1 extends c1 {
    @j.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C a(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d C c2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        i.q2.t.i0.f(map, "$this$flatMapTo");
        i.q2.t.i0.f(c2, "destination");
        i.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.a((Collection) c2, (Iterable) lVar.invoke(it.next()));
        }
        return c2;
    }

    @i.m2.f
    private static final <K, V> Map.Entry<K, V> b(@j.c.a.d Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) g0.b((Iterable) map.entrySet(), (Comparator) comparator);
    }

    @j.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d C c2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapTo");
        i.q2.t.i0.f(c2, "destination");
        i.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c2.add(lVar.invoke(it.next()));
        }
        return c2;
    }

    @j.c.a.d
    public static final <K, V> i.x2.m<Map.Entry<K, V>> e(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$asSequence");
        return g0.i((Iterable) map.entrySet());
    }

    @i.m2.f
    private static final <K, V> int f(@j.c.a.d Map<? extends K, ? extends V> map) {
        return map.size();
    }

    public static final <K, V> boolean h(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$none");
        return map.isEmpty();
    }

    public static final <K, V> boolean i(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$all");
        i.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean j(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$any");
        i.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @j.c.a.d
    public static final <K, V> List<i.i0<K, V>> k(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$toList");
        if (map.size() == 0) {
            return y.b();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return y.b();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return x.a(new i.i0(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new i.i0(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new i.i0(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    @j.c.a.d
    public static final <K, V, R> List<R> l(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        i.q2.t.i0.f(map, "$this$flatMap");
        i.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.a((Collection) arrayList, (Iterable) lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @i.m2.e
    public static final <K, V> void m(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, i.y1> lVar) {
        i.q2.t.i0.f(map, "$this$forEach");
        i.q2.t.i0.f(lVar, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    @j.c.a.d
    public static final <K, V, R> List<R> n(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$map");
        i.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.invoke(it.next()));
        }
        return arrayList;
    }

    @j.c.a.d
    public static final <K, V, R> List<R> o(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapNotNull");
        i.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @i.m2.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> p(@j.c.a.d Map<? extends K, ? extends V> map, i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry2);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        entry = entry2;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    @j.c.a.e
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> q(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        i.q2.t.i0.f(map, "$this$minBy");
        i.q2.t.i0.f(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            entry = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry2);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        entry = entry2;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
        } else {
            entry = null;
        }
        return entry;
    }

    public static final <K, V> boolean r(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$none");
        i.q2.t.i0.f(lVar, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @i.t0(version = "1.1")
    @j.c.a.d
    public static final <K, V, M extends Map<? extends K, ? extends V>> M s(@j.c.a.d M m2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, i.y1> lVar) {
        i.q2.t.i0.f(m2, "$this$onEach");
        i.q2.t.i0.f(lVar, "action");
        Iterator<Map.Entry<K, V>> it = m2.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
        return m2;
    }

    @j.c.a.d
    public static final <K, V, R, C extends Collection<? super R>> C b(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d C c2, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        i.q2.t.i0.f(map, "$this$mapNotNullTo");
        i.q2.t.i0.f(c2, "destination");
        i.q2.t.i0.f(lVar, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    @j.c.a.e
    public static final <K, V> Map.Entry<K, V> c(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        i.q2.t.i0.f(map, "$this$minWith");
        i.q2.t.i0.f(comparator, "comparator");
        return (Map.Entry) g0.c((Iterable) map.entrySet(), (Comparator) comparator);
    }

    public static final <K, V> boolean a(@j.c.a.d Map<? extends K, ? extends V> map) {
        i.q2.t.i0.f(map, "$this$any");
        return !map.isEmpty();
    }

    @i.m2.f
    private static final <K, V> Iterable<Map.Entry<K, V>> c(@j.c.a.d Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    public static final <K, V> int k(@j.c.a.d Map<? extends K, ? extends V> map, @j.c.a.d i.q2.s.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        i.q2.t.i0.f(map, "$this$count");
        i.q2.t.i0.f(lVar, "predicate");
        int i2 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }
}
