package com.lxj.easyadapter;

import androidx.collection.SparseArrayCompat;
import i.q2.t.i0;
import j.c.a.d;

/* JADX INFO: compiled from: ItemDelegateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> {
    private SparseArrayCompat<b<T>> a = new SparseArrayCompat<>();

    public final int a() {
        return this.a.size();
    }

    @d
    public final b<T> b(int i2) {
        b<T> bVar = this.a.get(i2);
        if (bVar == null) {
            i0.f();
        }
        return bVar;
    }

    @d
    public final c<T> c(@d b<T> bVar) {
        i0.f(bVar, "delegate");
        int iIndexOfValue = this.a.indexOfValue(bVar);
        if (iIndexOfValue >= 0) {
            this.a.removeAt(iIndexOfValue);
        }
        return this;
    }

    @d
    public final c<T> a(@d b<T> bVar) {
        i0.f(bVar, "delegate");
        this.a.put(this.a.size(), bVar);
        return this;
    }

    public final int b(@d b<T> bVar) {
        i0.f(bVar, "itemViewDelegate");
        return this.a.indexOfValue(bVar);
    }

    @d
    public final c<T> c(int i2) {
        int iIndexOfKey = this.a.indexOfKey(i2);
        if (iIndexOfKey >= 0) {
            this.a.removeAt(iIndexOfKey);
        }
        return this;
    }

    @d
    public final c<T> a(int i2, @d b<T> bVar) {
        i0.f(bVar, "delegate");
        if (this.a.get(i2) == null) {
            this.a.put(i2, bVar);
            return this;
        }
        throw new IllegalArgumentException("An ItemDelegate is already registered for the viewType = " + i2 + ". Already registered ItemDelegate is " + this.a.get(i2));
    }

    public final int a(T t, int i2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (this.a.valueAt(size).a(t, i2)) {
                return this.a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i2 + " in data source");
    }

    public final void a(@d ViewHolder viewHolder, T t, int i2) {
        i0.f(viewHolder, "holder");
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b<T> bVarValueAt = this.a.valueAt(i3);
            if (bVarValueAt.a(t, i2)) {
                bVarValueAt.a(viewHolder, t, i2);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i2 + " in data source");
    }

    public final int a(int i2) {
        return b(i2).a();
    }
}
