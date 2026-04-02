package i.g2;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: compiled from: AbstractMutableSet.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.t0(version = "1.1")
public abstract class i<E> extends AbstractSet<E> implements Set<E>, i.q2.t.q1.h {
    protected i() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
