package p286h.p289g2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Sets.kt */
/* renamed from: h.g2.l0 */
/* loaded from: classes2.dex */
public final class C5277l0 implements Set, Serializable, InterfaceC5569a {
    public static final C5277l0 INSTANCE = new C5277l0();
    private static final long serialVersionUID = 3406603774387020532L;

    private C5277l0() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    public boolean contains(@InterfaceC5816d Void r2) {
        C5544i0.m22546f(r2, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection collection) {
        C5544i0.m22546f(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(@InterfaceC5817e Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public Iterator iterator() {
        return C5268i0.f20126a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C5584u.m22686a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C5584u.m22688a(this, tArr);
    }

    @InterfaceC5816d
    public String toString() {
        return "[]";
    }
}
