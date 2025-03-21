package p286h.p289g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _CollectionsJvm.kt */
/* renamed from: h.g2.f0 */
/* loaded from: classes2.dex */
class C5259f0 extends C5256e0 {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <R> List<R> m19735a(@InterfaceC5816d Iterable<?> iterable, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(iterable, "$this$filterIsInstance");
        C5544i0.m22546f(cls, "klass");
        return (List) m19734a(iterable, new ArrayList(), cls);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final <T extends Comparable<? super T>> SortedSet<T> m19737f(@InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(iterable, "$this$toSortedSet");
        return (SortedSet) C5262g0.m19836c((Iterable) iterable, new TreeSet());
    }

    /* renamed from: j */
    public static <T> void m19738j(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$reverse");
        Collections.reverse(list);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m19734a(@InterfaceC5816d Iterable<?> iterable, @InterfaceC5816d C c2, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(iterable, "$this$filterIsInstanceTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> SortedSet<T> m19736a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(iterable, "$this$toSortedSet");
        C5544i0.m22546f(comparator, "comparator");
        return (SortedSet) C5262g0.m19836c((Iterable) iterable, new TreeSet(comparator));
    }
}
