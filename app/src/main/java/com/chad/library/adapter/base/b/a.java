package com.chad.library.adapter.base.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AbstractExpandableItem.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements b<T> {
    protected boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<T> f3613b;

    @Override // com.chad.library.adapter.base.b.b
    public List<T> a() {
        return this.f3613b;
    }

    public boolean b(T t) {
        List<T> list = this.f3613b;
        return list != null && list.contains(t);
    }

    public boolean c() {
        List<T> list = this.f3613b;
        return list != null && list.size() > 0;
    }

    public boolean d(T t) {
        List<T> list = this.f3613b;
        return list != null && list.remove(t);
    }

    @Override // com.chad.library.adapter.base.b.b
    public boolean isExpanded() {
        return this.a;
    }

    @Override // com.chad.library.adapter.base.b.b
    public void setExpanded(boolean z) {
        this.a = z;
    }

    public void a(List<T> list) {
        this.f3613b = list;
    }

    public boolean b(int i2) {
        List<T> list = this.f3613b;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return false;
        }
        this.f3613b.remove(i2);
        return true;
    }

    public int c(T t) {
        List<T> list = this.f3613b;
        if (list != null) {
            return list.indexOf(t);
        }
        return -1;
    }

    public T a(int i2) {
        if (!c() || i2 >= this.f3613b.size()) {
            return null;
        }
        return this.f3613b.get(i2);
    }

    public void a(T t) {
        if (this.f3613b == null) {
            this.f3613b = new ArrayList();
        }
        this.f3613b.add(t);
    }

    public void a(int i2, T t) {
        List<T> list = this.f3613b;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            this.f3613b.add(i2, t);
        } else {
            a(t);
        }
    }
}
