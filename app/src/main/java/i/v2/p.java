package i.v2;

import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
class p {
    @j.c.a.d
    public static final <T extends Comparable<? super T>> g<T> a(@j.c.a.d T t, @j.c.a.d T t2) {
        i0.f(t, "$this$rangeTo");
        i0.f(t2, "that");
        return new h(t, t2);
    }

    @t0(version = "1.1")
    @j.c.a.d
    public static final f<Double> a(double d2, double d3) {
        return new d(d2, d3);
    }

    @t0(version = "1.1")
    @j.c.a.d
    public static final f<Float> a(float f2, float f3) {
        return new e(f2, f3);
    }

    @t0(version = "1.3")
    @i.m2.f
    private static final boolean a(@j.c.a.d Iterable iterable, Object obj) {
        i0.f(iterable, "$this$contains");
        return obj != null && ((g) iterable).contains((Comparable) obj);
    }

    public static final void a(boolean z, @j.c.a.d Number number) {
        i0.f(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
