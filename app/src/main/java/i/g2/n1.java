package i.g2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes2.dex */
class n1 extends m1 {
    @j.c.a.d
    public static final <T> Set<T> a(@j.c.a.d Set<? extends T> set, T t) {
        i.q2.t.i0.f(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && i.q2.t.i0.a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @i.m2.f
    private static final <T> Set<T> b(@j.c.a.d Set<? extends T> set, T t) {
        return a(set, t);
    }

    @j.c.a.d
    public static final <T> Set<T> c(@j.c.a.d Set<? extends T> set, T t) {
        i.q2.t.i0.f(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @i.m2.f
    private static final <T> Set<T> d(@j.c.a.d Set<? extends T> set, T t) {
        return c(set, t);
    }

    @j.c.a.d
    public static final <T> Set<T> b(@j.c.a.d Set<? extends T> set, @j.c.a.d T[] tArr) {
        i.q2.t.i0.f(set, "$this$plus");
        i.q2.t.i0.f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Object[]) tArr);
        return linkedHashSet;
    }

    @j.c.a.d
    public static final <T> Set<T> a(@j.c.a.d Set<? extends T> set, @j.c.a.d T[] tArr) {
        i.q2.t.i0.f(set, "$this$minus");
        i.q2.t.i0.f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @j.c.a.d
    public static final <T> Set<T> b(@j.c.a.d Set<? extends T> set, @j.c.a.d Iterable<? extends T> iterable) {
        int size;
        i.q2.t.i0.f(set, "$this$plus");
        i.q2.t.i0.f(iterable, "elements");
        Integer numA = z.a((Iterable) iterable);
        if (numA != null) {
            size = set.size() + numA.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(size));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (Iterable) iterable);
        return linkedHashSet;
    }

    @j.c.a.d
    public static final <T> Set<T> a(@j.c.a.d Set<? extends T> set, @j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(set, "$this$minus");
        i.q2.t.i0.f(iterable, "elements");
        Collection<?> collectionA = z.a(iterable, set);
        if (collectionA.isEmpty()) {
            return g0.Q(set);
        }
        if (collectionA instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!collectionA.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(collectionA);
        return linkedHashSet2;
    }

    @j.c.a.d
    public static final <T> Set<T> b(@j.c.a.d Set<? extends T> set, @j.c.a.d i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(set, "$this$plus");
        i.q2.t.i0.f(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(set.size() * 2));
        linkedHashSet.addAll(set);
        d0.a((Collection) linkedHashSet, (i.x2.m) mVar);
        return linkedHashSet;
    }

    @j.c.a.d
    public static final <T> Set<T> a(@j.c.a.d Set<? extends T> set, @j.c.a.d i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(set, "$this$minus");
        i.q2.t.i0.f(mVar, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.d(linkedHashSet, mVar);
        return linkedHashSet;
    }
}
