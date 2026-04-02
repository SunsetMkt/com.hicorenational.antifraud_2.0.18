package i.g2;

import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes2.dex */
class e0 extends d0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(@j.c.a.d List<?> list, int i2) {
        int iA = y.a((List) list);
        if (i2 >= 0 && iA >= i2) {
            return y.a((List) list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new i.v2.k(0, y.a((List) list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(@j.c.a.d List<?> list, int i2) {
        int size = list.size();
        if (i2 >= 0 && size >= i2) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new i.v2.k(0, list.size()) + "].");
    }

    @j.c.a.d
    public static final <T> List<T> h(@j.c.a.d List<? extends T> list) {
        i.q2.t.i0.f(list, "$this$asReversed");
        return new i1(list);
    }

    @i.q2.e(name = "asReversedMutable")
    @j.c.a.d
    public static final <T> List<T> i(@j.c.a.d List<T> list) {
        i.q2.t.i0.f(list, "$this$asReversed");
        return new h1(list);
    }
}
