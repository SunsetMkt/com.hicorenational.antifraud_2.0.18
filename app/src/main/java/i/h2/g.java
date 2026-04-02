package i.h2;

import i.q2.t.i0;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g<T> implements Comparator<T> {

    @j.c.a.d
    private final Comparator<T> a;

    public g(@j.c.a.d Comparator<T> comparator) {
        i0.f(comparator, "comparator");
        this.a = comparator;
    }

    @j.c.a.d
    public final Comparator<T> a() {
        return this.a;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }

    @Override // java.util.Comparator
    @j.c.a.d
    public final Comparator<T> reversed() {
        return this.a;
    }
}
