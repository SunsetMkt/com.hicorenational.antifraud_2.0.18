package i.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class l1 {
    @j.c.a.d
    public static <T> Set<T> a(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        i.q2.t.i0.a((Object) setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    @j.c.a.d
    public static final <T> TreeSet<T> a(@j.c.a.d T... tArr) {
        i.q2.t.i0.f(tArr, "elements");
        return (TreeSet) r.e((Object[]) tArr, new TreeSet());
    }

    @j.c.a.d
    public static final <T> TreeSet<T> a(@j.c.a.d Comparator<? super T> comparator, @j.c.a.d T... tArr) {
        i.q2.t.i0.f(comparator, "comparator");
        i.q2.t.i0.f(tArr, "elements");
        return (TreeSet) r.e((Object[]) tArr, new TreeSet(comparator));
    }
}
