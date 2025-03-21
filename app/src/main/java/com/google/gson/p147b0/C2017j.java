package com.google.gson.p147b0;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* compiled from: NonNullElementWrapperList.java */
/* renamed from: com.google.gson.b0.j */
/* loaded from: classes.dex */
public class C2017j<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a */
    private final ArrayList<E> f5706a;

    public C2017j(ArrayList<E> arrayList) {
        this.f5706a = (ArrayList) Objects.requireNonNull(arrayList);
    }

    /* renamed from: a */
    private E m5372a(E e2) {
        if (e2 != null) {
            return e2;
        }
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        this.f5706a.add(i2, m5372a(e2));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f5706a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f5706a.contains(obj);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.f5706a.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        return this.f5706a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.f5706a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.f5706a.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.f5706a.lastIndexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        return this.f5706a.remove(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        return this.f5706a.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        return this.f5706a.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        return this.f5706a.set(i2, m5372a(e2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5706a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f5706a.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.f5706a.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f5706a.toArray(tArr);
    }
}
