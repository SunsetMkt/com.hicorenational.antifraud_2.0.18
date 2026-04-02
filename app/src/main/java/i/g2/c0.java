package i.g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class c0 extends b0 {
    @i.c(level = i.d.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @i.o0(expression = "this.sortWith(comparator)", imports = {}))
    @i.m2.f
    private static final <T> void a(@j.c.a.d List<T> list, Comparator<? super T> comparator) {
        throw new i.a0(null, 1, null);
    }

    public static <T> void b(@j.c.a.d List<T> list, @j.c.a.d Comparator<? super T> comparator) {
        i.q2.t.i0.f(list, "$this$sortWith");
        i.q2.t.i0.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @i.t0(version = "1.2")
    @i.m2.f
    private static final <T> void c(@j.c.a.d List<T> list) {
        Collections.shuffle(list);
    }

    public static <T extends Comparable<? super T>> void d(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @i.t0(version = "1.2")
    @j.c.a.d
    public static final <T> List<T> e(@j.c.a.d Iterable<? extends T> iterable) {
        i.q2.t.i0.f(iterable, "$this$shuffled");
        List<T> listO = g0.O(iterable);
        Collections.shuffle(listO);
        return listO;
    }

    @i.c(level = i.d.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @i.o0(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @i.m2.f
    private static final <T> void a(@j.c.a.d List<T> list, i.q2.s.p<? super T, ? super T, Integer> pVar) {
        throw new i.a0(null, 1, null);
    }

    @i.t0(version = "1.2")
    @i.m2.f
    private static final <T> void a(@j.c.a.d List<T> list, T t) {
        Collections.fill(list, t);
    }

    @i.t0(version = "1.2")
    @i.m2.f
    private static final <T> void a(@j.c.a.d List<T> list, Random random) {
        Collections.shuffle(list, random);
    }

    @i.t0(version = "1.2")
    @j.c.a.d
    public static final <T> List<T> a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d Random random) {
        i.q2.t.i0.f(iterable, "$this$shuffled");
        i.q2.t.i0.f(random, "random");
        List<T> listO = g0.O(iterable);
        Collections.shuffle(listO, random);
        return listO;
    }
}
