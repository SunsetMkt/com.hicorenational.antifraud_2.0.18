package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v implements Iterator<Character>, i.q2.t.q1.a {
    public abstract char b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @j.c.a.d
    public final Character next() {
        return Character.valueOf(b());
    }
}
