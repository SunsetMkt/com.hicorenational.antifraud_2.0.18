package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 implements Iterator<Float>, i.q2.t.q1.a {
    public abstract float b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @j.c.a.d
    public final Float next() {
        return Float.valueOf(b());
    }
}
