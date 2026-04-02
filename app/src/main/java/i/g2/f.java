package i.g2;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.t0(version = "1.1")
public abstract class f<E> extends AbstractCollection<E> implements Collection<E>, i.q2.t.q1.b {
    protected f() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e2);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
