package p286h.p289g2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _Sets.kt */
/* renamed from: h.g2.n1 */
/* loaded from: classes2.dex */
class C5284n1 extends C5281m1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Set<T> m20115a(@InterfaceC5816d Set<? extends T> set, T t) {
        int m19562b;
        C5544i0.m22546f(set, "$this$minus");
        m19562b = C5248b1.m19562b(set.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && C5544i0.m22531a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> Set<T> m20119b(@InterfaceC5816d Set<? extends T> set, T t) {
        return m20115a(set, t);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> Set<T> m20121c(@InterfaceC5816d Set<? extends T> set, T t) {
        int m19562b;
        C5544i0.m22546f(set, "$this$plus");
        m19562b = C5248b1.m19562b(set.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final <T> Set<T> m20122d(@InterfaceC5816d Set<? extends T> set, T t) {
        return m20121c(set, t);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Set<T> m20120b(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d T[] tArr) {
        int m19562b;
        C5544i0.m22546f(set, "$this$plus");
        C5544i0.m22546f(tArr, "elements");
        m19562b = C5248b1.m19562b(set.size() + tArr.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        linkedHashSet.addAll(set);
        C5253d0.m19667a((Collection) linkedHashSet, (Object[]) tArr);
        return linkedHashSet;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Set<T> m20116a(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(set, "$this$minus");
        C5544i0.m22546f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        C5253d0.m19685d(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Set<T> m20118b(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d Iterable<? extends T> iterable) {
        int size;
        int m19562b;
        C5544i0.m22546f(set, "$this$plus");
        C5544i0.m22546f(iterable, "elements");
        Integer m21797a = C5318z.m21797a((Iterable) iterable);
        if (m21797a != null) {
            size = set.size() + m21797a.intValue();
        } else {
            size = set.size() * 2;
        }
        m19562b = C5248b1.m19562b(size);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        linkedHashSet.addAll(set);
        C5253d0.m19665a((Collection) linkedHashSet, (Iterable) iterable);
        return linkedHashSet;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Set<T> m20114a(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(set, "$this$minus");
        C5544i0.m22546f(iterable, "elements");
        Collection<?> m21799a = C5318z.m21799a(iterable, set);
        if (m21799a.isEmpty()) {
            return C5262g0.m19770Q(set);
        }
        if (m21799a instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!m21799a.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(m21799a);
        return linkedHashSet2;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Set<T> m20117b(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        int m19562b;
        C5544i0.m22546f(set, "$this$plus");
        C5544i0.m22546f(interfaceC5699m, "elements");
        m19562b = C5248b1.m19562b(set.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        linkedHashSet.addAll(set);
        C5253d0.m19664a((Collection) linkedHashSet, (InterfaceC5699m) interfaceC5699m);
        return linkedHashSet;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Set<T> m20113a(@InterfaceC5816d Set<? extends T> set, @InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(set, "$this$minus");
        C5544i0.m22546f(interfaceC5699m, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        C5253d0.m19683d(linkedHashSet, interfaceC5699m);
        return linkedHashSet;
    }
}
