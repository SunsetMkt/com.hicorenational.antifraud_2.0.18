package h.g2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: _Sets.kt */
/* loaded from: classes2.dex */
class n1 extends m1 {
    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, T t) {
        int b2;
        h.q2.t.i0.f(set, "$this$minus");
        b2 = b1.b(set.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(b2);
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && h.q2.t.i0.a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @h.m2.f
    private static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, T t) {
        return a(set, t);
    }

    @i.c.a.d
    public static final <T> Set<T> c(@i.c.a.d Set<? extends T> set, T t) {
        int b2;
        h.q2.t.i0.f(set, "$this$plus");
        b2 = b1.b(set.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b2);
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @h.m2.f
    private static final <T> Set<T> d(@i.c.a.d Set<? extends T> set, T t) {
        return c(set, t);
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d T[] tArr) {
        int b2;
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(tArr, "elements");
        b2 = b1.b(set.size() + tArr.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b2);
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Object[]) tArr);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d T[] tArr) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d Iterable<? extends T> iterable) {
        int size;
        int b2;
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(iterable, "elements");
        Integer a2 = z.a((Iterable) iterable);
        if (a2 != null) {
            size = set.size() + a2.intValue();
        } else {
            size = set.size() * 2;
        }
        b2 = b1.b(size);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b2);
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Iterable) iterable);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d Iterable<? extends T> iterable) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(iterable, "elements");
        Collection<?> a2 = z.a(iterable, set);
        if (a2.isEmpty()) {
            return g0.Q(set);
        }
        if (a2 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!a2.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(a2);
        return linkedHashSet2;
    }

    @i.c.a.d
    public static final <T> Set<T> b(@i.c.a.d Set<? extends T> set, @i.c.a.d h.x2.m<? extends T> mVar) {
        int b2;
        h.q2.t.i0.f(set, "$this$plus");
        h.q2.t.i0.f(mVar, "elements");
        b2 = b1.b(set.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b2);
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (h.x2.m) mVar);
        return linkedHashSet;
    }

    @i.c.a.d
    public static final <T> Set<T> a(@i.c.a.d Set<? extends T> set, @i.c.a.d h.x2.m<? extends T> mVar) {
        h.q2.t.i0.f(set, "$this$minus");
        h.q2.t.i0.f(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, mVar);
        return linkedHashSet;
    }
}
