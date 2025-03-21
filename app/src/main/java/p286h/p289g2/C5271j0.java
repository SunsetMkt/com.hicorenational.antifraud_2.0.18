package p286h.p289g2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Collections.kt */
/* renamed from: h.g2.j0 */
/* loaded from: classes2.dex */
public final class C5271j0 implements List, Serializable, RandomAccess, InterfaceC5569a {
    public static final C5271j0 INSTANCE = new C5271j0();
    private static final long serialVersionUID = -7390468764508069838L;

    private C5271j0() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List
    public /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int i2, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
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

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection collection) {
        C5544i0.m22546f(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@InterfaceC5817e Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    public int indexOf(@InterfaceC5816d Void r2) {
        C5544i0.m22546f(r2, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public Iterator iterator() {
        return C5268i0.f20126a;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    public int lastIndexOf(@InterfaceC5816d Void r2) {
        C5544i0.m22546f(r2, "element");
        return -1;
    }

    @Override // java.util.List
    @InterfaceC5816d
    public ListIterator listIterator() {
        return C5268i0.f20126a;
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Void remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int i2, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @InterfaceC5816d
    public List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return C5584u.m22686a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C5584u.m22688a(this, tArr);
    }

    @InterfaceC5816d
    public String toString() {
        return "[]";
    }

    @Override // java.util.List
    @InterfaceC5816d
    public Void get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
    }

    @Override // java.util.List
    @InterfaceC5816d
    public ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return C5268i0.f20126a;
        }
        throw new IndexOutOfBoundsException("Index: " + i2);
    }
}
