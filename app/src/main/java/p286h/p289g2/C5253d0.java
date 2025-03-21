package p286h.p289g2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p286h.C5226e1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5560n1;
import p286h.p318u2.AbstractC5625f;
import p286h.p321x2.C5707u;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* renamed from: h.g2.d0 */
/* loaded from: classes2.dex */
public class C5253d0 extends C5250c0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> boolean m19666a(@InterfaceC5816d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return C5560n1.m22589a(collection).removeAll(collection2);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> boolean m19676b(@InterfaceC5816d Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return C5560n1.m22589a(collection).retainAll(collection2);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> boolean m19682c(@InterfaceC5816d Collection<? extends T> collection, T t) {
        if (collection != null) {
            return C5560n1.m22589a(collection).remove(t);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: d */
    public static final <T> boolean m19684d(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(collection, "$this$removeAll");
        C5544i0.m22546f(iterable, "elements");
        return C5560n1.m22589a(collection).removeAll(C5318z.m21799a(iterable, collection));
    }

    /* renamed from: e */
    public static final <T> boolean m19688e(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(collection, "$this$retainAll");
        C5544i0.m22546f(iterable, "elements");
        return C5560n1.m22589a(collection).retainAll(C5318z.m21799a(iterable, collection));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: f */
    public static final <T> T m19690f(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$removeLast");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(C5315y.m21757a((List) list));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: g */
    public static final <T> T m19691g(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$removeLastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(C5315y.m21757a((List) list));
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> void m19660a(@InterfaceC5816d Collection<? super T> collection, T t) {
        C5544i0.m22546f(collection, "$this$minusAssign");
        collection.remove(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> void m19672b(@InterfaceC5816d Collection<? super T> collection, T t) {
        C5544i0.m22546f(collection, "$this$plusAssign");
        collection.add(t);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> void m19680c(@InterfaceC5816d Collection<? super T> collection, Iterable<? extends T> iterable) {
        C5544i0.m22546f(collection, "$this$plusAssign");
        m19665a((Collection) collection, (Iterable) iterable);
    }

    /* renamed from: d */
    public static final <T> boolean m19683d(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(collection, "$this$removeAll");
        C5544i0.m22546f(interfaceC5699m, "elements");
        HashSet m23390K = C5707u.m23390K(interfaceC5699m);
        return (m23390K.isEmpty() ^ true) && collection.removeAll(m23390K);
    }

    /* renamed from: e */
    public static final <T> boolean m19689e(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d T[] tArr) {
        HashSet m20535I;
        C5544i0.m22546f(collection, "$this$retainAll");
        C5544i0.m22546f(tArr, "elements");
        if (!(!(tArr.length == 0))) {
            return m19675b((Collection<?>) collection);
        }
        m20535I = C5294r.m20535I(tArr);
        return collection.retainAll(m20535I);
    }

    /* renamed from: a */
    public static <T> boolean m19665a(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(collection, "$this$addAll");
        C5544i0.m22546f(iterable, "elements");
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

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> void m19671b(@InterfaceC5816d Collection<? super T> collection, Iterable<? extends T> iterable) {
        C5544i0.m22546f(collection, "$this$minusAssign");
        m19684d(collection, iterable);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> void m19681c(@InterfaceC5816d Collection<? super T> collection, T[] tArr) {
        C5544i0.m22546f(collection, "$this$plusAssign");
        m19667a((Collection) collection, (Object[]) tArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> void m19673b(@InterfaceC5816d Collection<? super T> collection, T[] tArr) {
        C5544i0.m22546f(collection, "$this$minusAssign");
        m19685d(collection, tArr);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> void m19679c(@InterfaceC5816d Collection<? super T> collection, InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(collection, "$this$plusAssign");
        m19664a((Collection) collection, (InterfaceC5699m) interfaceC5699m);
    }

    /* renamed from: d */
    public static final <T> boolean m19685d(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d T[] tArr) {
        HashSet m20535I;
        C5544i0.m22546f(collection, "$this$removeAll");
        C5544i0.m22546f(tArr, "elements");
        if (!(!(tArr.length == 0))) {
            return false;
        }
        m20535I = C5294r.m20535I(tArr);
        return collection.removeAll(m20535I);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> void m19670b(@InterfaceC5816d Collection<? super T> collection, InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(collection, "$this$minusAssign");
        m19683d(collection, interfaceC5699m);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: c */
    public static final <T> T m19678c(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$removeFirst");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    /* renamed from: e */
    public static final <T> boolean m19687e(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(collection, "$this$retainAll");
        C5544i0.m22546f(interfaceC5699m, "elements");
        HashSet m23390K = C5707u.m23390K(interfaceC5699m);
        if (!m23390K.isEmpty()) {
            return collection.retainAll(m23390K);
        }
        return m19675b((Collection<?>) collection);
    }

    /* renamed from: a */
    public static <T> boolean m19664a(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(collection, "$this$addAll");
        C5544i0.m22546f(interfaceC5699m, "elements");
        Iterator<? extends T> it = interfaceC5699m.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    private static final boolean m19675b(@InterfaceC5816d Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    /* renamed from: a */
    public static final <T> boolean m19667a(@InterfaceC5816d Collection<? super T> collection, @InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(collection, "$this$addAll");
        C5544i0.m22546f(tArr, "elements");
        return collection.addAll(C5291q.m20317d((Object[]) tArr));
    }

    /* renamed from: b */
    public static <T> boolean m19674b(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(iterable, "$this$retainAll");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        return m19663a((Iterable) iterable, (InterfaceC5506l) interfaceC5506l, false);
    }

    /* renamed from: a */
    public static final <T> boolean m19662a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(iterable, "$this$removeAll");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        return m19663a((Iterable) iterable, (InterfaceC5506l) interfaceC5506l, true);
    }

    /* renamed from: b */
    public static final <T> boolean m19677b(@InterfaceC5816d List<T> list, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(list, "$this$retainAll");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        return m19669a((List) list, (InterfaceC5506l) interfaceC5506l, false);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: e */
    public static final <T> T m19686e(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$removeFirstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    /* renamed from: a */
    private static final <T> boolean m19663a(@InterfaceC5816d Iterable<? extends T> iterable, InterfaceC5506l<? super T, Boolean> interfaceC5506l, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (interfaceC5506l.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> List<T> m19659a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(iterable, "$this$shuffled");
        C5544i0.m22546f(abstractC5625f, "random");
        List<T> m19768O = C5262g0.m19768O(iterable);
        m19661a((List) m19768O, abstractC5625f);
        return m19768O;
    }

    @InterfaceC5426f
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use removeAt(index) instead.", replaceWith = @InterfaceC5467o0(expression = "removeAt(index)", imports = {}))
    /* renamed from: a */
    private static final <T> T m19658a(@InterfaceC5816d List<T> list, int i2) {
        return list.remove(i2);
    }

    /* renamed from: a */
    public static final <T> boolean m19668a(@InterfaceC5816d List<T> list, @InterfaceC5816d InterfaceC5506l<? super T, Boolean> interfaceC5506l) {
        C5544i0.m22546f(list, "$this$removeAll");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        return m19669a((List) list, (InterfaceC5506l) interfaceC5506l, true);
    }

    /* renamed from: a */
    private static final <T> boolean m19669a(@InterfaceC5816d List<T> list, InterfaceC5506l<? super T, Boolean> interfaceC5506l, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            if (list != null) {
                return m19663a(C5560n1.m22592b(list), interfaceC5506l, z);
            }
            throw new C5226e1("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
        int m21757a = C5315y.m21757a((List) list);
        if (m21757a >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (interfaceC5506l.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == m21757a) {
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
        int m21757a2 = C5315y.m21757a((List) list);
        if (m21757a2 < i2) {
            return true;
        }
        while (true) {
            list.remove(m21757a2);
            if (m21757a2 == i2) {
                return true;
            }
            m21757a2--;
        }
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final <T> void m19661a(@InterfaceC5816d List<T> list, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(list, "$this$shuffle");
        C5544i0.m22546f(abstractC5625f, "random");
        for (int m21757a = C5315y.m21757a((List) list); m21757a >= 1; m21757a--) {
            int mo22948c = abstractC5625f.mo22948c(m21757a + 1);
            T t = list.get(m21757a);
            list.set(m21757a, list.get(mo22948c));
            list.set(mo22948c, t);
        }
    }
}
