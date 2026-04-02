package i.g2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
class f0 extends e0 {
    @j.c.a.d
    public static final <R> List<R> a(@j.c.a.d Iterable<?> iterable, @j.c.a.d Class<R> cls) {
        i.q2.t.i0.f(iterable, "$this$filterIsInstance");
        i.q2.t.i0.f(cls, "klass");
        return (List) a(iterable, new ArrayList(), cls);
    }

    @j.c.a.d
    public static final <T extends Comparable<? super T>> SortedSet<T> f(@j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(iterable, "$this$toSortedSet");
        return (SortedSet) g0.c((Iterable) iterable, new TreeSet());
    }

    public static <T> void j(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$reverse");
        Collections.reverse(list);
    }

    @j.c.a.d
    public static final <C extends Collection<? super R>, R> C a(@j.c.a.d Iterable<?> iterable, @j.c.a.d C c2, @j.c.a.d Class<R> cls) {
        i.q2.t.i0.f(iterable, "$this$filterIsInstanceTo");
        i.q2.t.i0.f(c2, "destination");
        i.q2.t.i0.f(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @j.c.a.d
    public static final <T> SortedSet<T> a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d Comparator<? super T> comparator) {
        i.q2.t.i0.f(iterable, "$this$toSortedSet");
        i.q2.t.i0.f(comparator, "comparator");
        return (SortedSet) g0.c((Iterable) iterable, new TreeSet(comparator));
    }
}
