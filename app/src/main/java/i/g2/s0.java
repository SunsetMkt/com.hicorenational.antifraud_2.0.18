package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> implements Iterable<r0<? extends T>>, i.q2.t.q1.a {
    private final i.q2.s.a<Iterator<T>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(@j.c.a.d i.q2.s.a<? extends Iterator<? extends T>> aVar) {
        i.q2.t.i0.f(aVar, "iteratorFactory");
        this.a = aVar;
    }

    @Override // java.lang.Iterable
    @j.c.a.d
    public Iterator<r0<T>> iterator() {
        return new t0(this.a.invoke());
    }
}
