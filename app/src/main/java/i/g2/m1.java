package i.g2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes2.dex */
public class m1 extends l1 {
    @j.c.a.d
    public static <T> Set<T> a() {
        return l0.INSTANCE;
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <T> HashSet<T> b() {
        return new HashSet<>();
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <T> LinkedHashSet<T> c() {
        return new LinkedHashSet<>();
    }

    @i.t0(version = "1.1")
    @i.m2.f
    private static final <T> Set<T> d() {
        return new LinkedHashSet();
    }

    @j.c.a.d
    public static final <T> Set<T> e(@j.c.a.d T... tArr) {
        i.q2.t.i0.f(tArr, "elements");
        return tArr.length > 0 ? r.M(tArr) : a();
    }

    @i.j
    @i.t0(version = "1.3")
    @i.m2.f
    private static final <E> Set<E> a(@i.b i.q2.s.l<? super Set<E>, i.y1> lVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        lVar.invoke(linkedHashSet);
        return linkedHashSet;
    }

    @j.c.a.d
    public static final <T> HashSet<T> b(@j.c.a.d T... tArr) {
        i.q2.t.i0.f(tArr, "elements");
        return (HashSet) r.e((Object[]) tArr, new HashSet(b1.b(tArr.length)));
    }

    @j.c.a.d
    public static final <T> LinkedHashSet<T> c(@j.c.a.d T... tArr) {
        i.q2.t.i0.f(tArr, "elements");
        return (LinkedHashSet) r.e((Object[]) tArr, new LinkedHashSet(b1.b(tArr.length)));
    }

    @j.c.a.d
    public static final <T> Set<T> d(@j.c.a.d T... tArr) {
        i.q2.t.i0.f(tArr, "elements");
        return (Set) r.e((Object[]) tArr, new LinkedHashSet(b1.b(tArr.length)));
    }

    @i.m2.f
    private static final <T> Set<T> e() {
        return a();
    }

    @i.j
    @i.t0(version = "1.3")
    @i.m2.f
    private static final <E> Set<E> a(int i2, @i.b i.q2.s.l<? super Set<E>, i.y1> lVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.b(i2));
        lVar.invoke(linkedHashSet);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <T> Set<T> b(@j.c.a.e Set<? extends T> set) {
        return set != 0 ? set : a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @j.c.a.d
    public static <T> Set<T> a(@j.c.a.d Set<? extends T> set) {
        i.q2.t.i0.f(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : l1.a(set.iterator().next());
        }
        return a();
    }
}
