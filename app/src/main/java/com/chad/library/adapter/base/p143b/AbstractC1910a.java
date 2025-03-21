package com.chad.library.adapter.base.p143b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractExpandableItem.java */
/* renamed from: com.chad.library.adapter.base.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1910a<T> implements InterfaceC1911b<T> {

    /* renamed from: a */
    protected boolean f5610a = false;

    /* renamed from: b */
    protected List<T> f5611b;

    @Override // com.chad.library.adapter.base.p143b.InterfaceC1911b
    /* renamed from: a */
    public List<T> mo5237a() {
        return this.f5611b;
    }

    /* renamed from: b */
    public boolean m5242b(T t) {
        List<T> list = this.f5611b;
        return list != null && list.contains(t);
    }

    /* renamed from: c */
    public boolean m5244c() {
        List<T> list = this.f5611b;
        return list != null && list.size() > 0;
    }

    /* renamed from: d */
    public boolean m5245d(T t) {
        List<T> list = this.f5611b;
        return list != null && list.remove(t);
    }

    @Override // com.chad.library.adapter.base.p143b.InterfaceC1911b
    public boolean isExpanded() {
        return this.f5610a;
    }

    @Override // com.chad.library.adapter.base.p143b.InterfaceC1911b
    public void setExpanded(boolean z) {
        this.f5610a = z;
    }

    /* renamed from: a */
    public void m5240a(List<T> list) {
        this.f5611b = list;
    }

    /* renamed from: b */
    public boolean m5241b(int i2) {
        List<T> list = this.f5611b;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return false;
        }
        this.f5611b.remove(i2);
        return true;
    }

    /* renamed from: c */
    public int m5243c(T t) {
        List<T> list = this.f5611b;
        if (list != null) {
            return list.indexOf(t);
        }
        return -1;
    }

    /* renamed from: a */
    public T m5236a(int i2) {
        if (!m5244c() || i2 >= this.f5611b.size()) {
            return null;
        }
        return this.f5611b.get(i2);
    }

    /* renamed from: a */
    public void m5239a(T t) {
        if (this.f5611b == null) {
            this.f5611b = new ArrayList();
        }
        this.f5611b.add(t);
    }

    /* renamed from: a */
    public void m5238a(int i2, T t) {
        List<T> list = this.f5611b;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            this.f5611b.add(i2, t);
        } else {
            m5239a((AbstractC1910a<T>) t);
        }
    }
}
