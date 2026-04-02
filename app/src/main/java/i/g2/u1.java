package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: UIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.k
@i.t0(version = "1.3")
public abstract class u1 implements Iterator<i.f1>, i.q2.t.q1.a {
    public abstract byte b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @j.c.a.d
    public final i.f1 next() {
        return i.f1.a(b());
    }
}
