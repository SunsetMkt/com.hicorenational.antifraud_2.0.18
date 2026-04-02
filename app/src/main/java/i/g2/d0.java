package i.g2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes2.dex */
public class d0 extends c0 {
    @i.m2.f
    private static final <T> boolean a(@j.c.a.d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return i.q2.t.n1.a(collection).removeAll(collection2);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @i.m2.f
    private static final <T> boolean b(@j.c.a.d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return i.q2.t.n1.a(collection).retainAll(collection2);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @i.m2.f
    private static final <T> boolean c(@j.c.a.d Collection<? extends T> collection, T t) {
        if (collection != null) {
            return i.q2.t.n1.a(collection).remove(t);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public static final <T> boolean d(@j.c.a.d Collection<? super T> collection, @j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(collection, "$this$removeAll");
        i.q2.t.i0.f(iterable, "elements");
        return i.q2.t.n1.a(collection).removeAll(z.a(iterable, collection));
    }

    public static final <T> boolean e(@j.c.a.d Collection<? super T> collection, @j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(collection, "$this$retainAll");
        i.q2.t.i0.f(iterable, "elements");
        return i.q2.t.n1.a(collection).retainAll(z.a(iterable, collection));
    }

    @i.j
    @i.t0(version = "1.3")
    public static final <T> T f(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$removeLast");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(y.a((List) list));
    }

    @i.j
    @j.c.a.e
    @i.t0(version = "1.3")
    public static final <T> T g(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$removeLastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(y.a((List) list));
    }

    @i.m2.f
    private static final <T> void a(@j.c.a.d Collection<? super T> collection, T t) {
        i.q2.t.i0.f(collection, "$this$minusAssign");
        collection.remove(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <T> void b(@j.c.a.d Collection<? super T> collection, T t) {
        i.q2.t.i0.f(collection, "$this$plusAssign");
        collection.add(t);
    }

    @i.m2.f
    private static final <T> void c(@j.c.a.d Collection<? super T> collection, Iterable<? extends T> iterable) {
        i.q2.t.i0.f(collection, "$this$plusAssign");
        a((Collection) collection, (Iterable) iterable);
    }

    public static final <T> boolean d(@j.c.a.d Collection<? super T> collection, @j.c.a.d i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(collection, "$this$removeAll");
        i.q2.t.i0.f(mVar, "elements");
        HashSet hashSetK = i.x2.u.K(mVar);
        return (hashSetK.isEmpty() ^ true) && collection.removeAll(hashSetK);
    }

    public static final <T> boolean e(@j.c.a.d Collection<? super T> collection, @j.c.a.d T[] tArr) {
        i.q2.t.i0.f(collection, "$this$retainAll");
        i.q2.t.i0.f(tArr, "elements");
        return (tArr.length == 0) ^ true ? collection.retainAll(r.I(tArr)) : b((Collection<?>) collection);
    }

    public static <T> boolean a(@j.c.a.d Collection<? super T> collection, @j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(collection, "$this$addAll");
        i.q2.t.i0.f(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @i.m2.f
    private static final <T> void b(@j.c.a.d Collection<? super T> collection, Iterable<? extends T> iterable) {
        i.q2.t.i0.f(collection, "$this$minusAssign");
        d(collection, iterable);
    }

    @i.m2.f
    private static final <T> void c(@j.c.a.d Collection<? super T> collection, T[] tArr) {
        i.q2.t.i0.f(collection, "$this$plusAssign");
        a((Collection) collection, (Object[]) tArr);
    }

    @i.m2.f
    private static final <T> void b(@j.c.a.d Collection<? super T> collection, T[] tArr) {
        i.q2.t.i0.f(collection, "$this$minusAssign");
        d(collection, tArr);
    }

    @i.m2.f
    private static final <T> void c(@j.c.a.d Collection<? super T> collection, i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(collection, "$this$plusAssign");
        a((Collection) collection, (i.x2.m) mVar);
    }

    public static final <T> boolean d(@j.c.a.d Collection<? super T> collection, @j.c.a.d T[] tArr) {
        i.q2.t.i0.f(collection, "$this$removeAll");
        i.q2.t.i0.f(tArr, "elements");
        return ((tArr.length == 0) ^ true) && collection.removeAll(r.I(tArr));
    }

    @i.m2.f
    private static final <T> void b(@j.c.a.d Collection<? super T> collection, i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(collection, "$this$minusAssign");
        d(collection, mVar);
    }

    @i.j
    @i.t0(version = "1.3")
    public static final <T> T c(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$removeFirst");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static final <T> boolean e(@j.c.a.d Collection<? super T> collection, @j.c.a.d i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(collection, "$this$retainAll");
        i.q2.t.i0.f(mVar, "elements");
        HashSet hashSetK = i.x2.u.K(mVar);
        if (!hashSetK.isEmpty()) {
            return collection.retainAll(hashSetK);
        }
        return b((Collection<?>) collection);
    }

    public static <T> boolean a(@j.c.a.d Collection<? super T> collection, @j.c.a.d i.x2.m<? extends T> mVar) {
        i.q2.t.i0.f(collection, "$this$addAll");
        i.q2.t.i0.f(mVar, "elements");
        Iterator<? extends T> it = mVar.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private static final boolean b(@j.c.a.d Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean a(@j.c.a.d Collection<? super T> collection, @j.c.a.d T[] tArr) {
        i.q2.t.i0.f(collection, "$this$addAll");
        i.q2.t.i0.f(tArr, "elements");
        return collection.addAll(q.d((Object[]) tArr));
    }

    public static <T> boolean b(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i.q2.t.i0.f(iterable, "$this$retainAll");
        i.q2.t.i0.f(lVar, "predicate");
        return a((Iterable) iterable, (i.q2.s.l) lVar, false);
    }

    public static final <T> boolean a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i.q2.t.i0.f(iterable, "$this$removeAll");
        i.q2.t.i0.f(lVar, "predicate");
        return a((Iterable) iterable, (i.q2.s.l) lVar, true);
    }

    public static final <T> boolean b(@j.c.a.d List<T> list, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i.q2.t.i0.f(list, "$this$retainAll");
        i.q2.t.i0.f(lVar, "predicate");
        return a((List) list, (i.q2.s.l) lVar, false);
    }

    @i.j
    @j.c.a.e
    @i.t0(version = "1.3")
    public static final <T> T e(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$removeFirstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    private static final <T> boolean a(@j.c.a.d Iterable<? extends T> iterable, i.q2.s.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @i.t0(version = "1.3")
    @j.c.a.d
    public static final <T> List<T> a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(iterable, "$this$shuffled");
        i.q2.t.i0.f(fVar, "random");
        List<T> listO = g0.O(iterable);
        a((List) listO, fVar);
        return listO;
    }

    @i.c(level = i.d.ERROR, message = "Use removeAt(index) instead.", replaceWith = @i.o0(expression = "removeAt(index)", imports = {}))
    @i.m2.f
    private static final <T> T a(@j.c.a.d List<T> list, int i2) {
        return list.remove(i2);
    }

    public static final <T> boolean a(@j.c.a.d List<T> list, @j.c.a.d i.q2.s.l<? super T, Boolean> lVar) {
        i.q2.t.i0.f(list, "$this$removeAll");
        i.q2.t.i0.f(lVar, "predicate");
        return a((List) list, (i.q2.s.l) lVar, true);
    }

    private static final <T> boolean a(@j.c.a.d List<T> list, i.q2.s.l<? super T, Boolean> lVar, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            if (list != null) {
                return a(i.q2.t.n1.b(list), lVar, z);
            }
            throw new i.e1("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
        int iA = y.a((List) list);
        if (iA >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (lVar.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == iA) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int iA2 = y.a((List) list);
        if (iA2 < i2) {
            return true;
        }
        while (true) {
            list.remove(iA2);
            if (iA2 == i2) {
                return true;
            }
            iA2--;
        }
    }

    @i.t0(version = "1.3")
    public static final <T> void a(@j.c.a.d List<T> list, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(list, "$this$shuffle");
        i.q2.t.i0.f(fVar, "random");
        for (int iA = y.a((List) list); iA >= 1; iA--) {
            int iC = fVar.c(iA + 1);
            T t = list.get(iA);
            list.set(iA, list.get(iC));
            list.set(iC, t);
        }
    }
}
