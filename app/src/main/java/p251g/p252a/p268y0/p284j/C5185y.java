package p251g.p252a.p268y0.p284j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: VolatileSizeArrayList.java */
/* renamed from: g.a.y0.j.y */
/* loaded from: classes2.dex */
public final class C5185y<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public C5185y() {
        this.list = new ArrayList<>();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.list.add(t);
        lazySet(this.list.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return obj instanceof C5185y ? this.list.equals(((C5185y) obj).list) : this.list.equals(obj);
    }

    @Override // java.util.List
    public T get(int i2) {
        return this.list.get(i2);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        return this.list.set(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i2, int i3) {
        return this.list.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i2) {
        return this.list.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.list.toArray(eArr);
    }

    public C5185y(int i2) {
        this.list = new ArrayList<>(i2);
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        this.list.add(i2, t);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i2, collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i2) {
        T remove = this.list.remove(i2);
        lazySet(this.list.size());
        return remove;
    }
}
