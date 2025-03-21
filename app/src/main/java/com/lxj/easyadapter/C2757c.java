package com.lxj.easyadapter;

import androidx.collection.SparseArrayCompat;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ItemDelegateManager.kt */
/* renamed from: com.lxj.easyadapter.c */
/* loaded from: classes.dex */
public final class C2757c<T> {

    /* renamed from: a */
    private SparseArrayCompat<InterfaceC2756b<T>> f8506a = new SparseArrayCompat<>();

    /* renamed from: a */
    public final int m8238a() {
        return this.f8506a.size();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final InterfaceC2756b<T> m8245b(int i2) {
        InterfaceC2756b<T> interfaceC2756b = this.f8506a.get(i2);
        if (interfaceC2756b == null) {
            C5544i0.m22545f();
        }
        return interfaceC2756b;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final C2757c<T> m8247c(@InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "delegate");
        int indexOfValue = this.f8506a.indexOfValue(interfaceC2756b);
        if (indexOfValue >= 0) {
            this.f8506a.removeAt(indexOfValue);
        }
        return this;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C2757c<T> m8242a(@InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "delegate");
        this.f8506a.put(this.f8506a.size(), interfaceC2756b);
        return this;
    }

    /* renamed from: b */
    public final int m8244b(@InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "itemViewDelegate");
        return this.f8506a.indexOfValue(interfaceC2756b);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final C2757c<T> m8246c(int i2) {
        int indexOfKey = this.f8506a.indexOfKey(i2);
        if (indexOfKey >= 0) {
            this.f8506a.removeAt(indexOfKey);
        }
        return this;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C2757c<T> m8241a(int i2, @InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "delegate");
        if (this.f8506a.get(i2) == null) {
            this.f8506a.put(i2, interfaceC2756b);
            return this;
        }
        throw new IllegalArgumentException("An ItemDelegate is already registered for the viewType = " + i2 + ". Already registered ItemDelegate is " + this.f8506a.get(i2));
    }

    /* renamed from: a */
    public final int m8240a(T t, int i2) {
        for (int size = this.f8506a.size() - 1; size >= 0; size--) {
            if (this.f8506a.valueAt(size).mo8205a(t, i2)) {
                return this.f8506a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i2 + " in data source");
    }

    /* renamed from: a */
    public final void m8243a(@InterfaceC5816d ViewHolder viewHolder, T t, int i2) {
        C5544i0.m22546f(viewHolder, "holder");
        int size = this.f8506a.size();
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC2756b<T> valueAt = this.f8506a.valueAt(i3);
            if (valueAt.mo8205a(t, i2)) {
                valueAt.mo8204a(viewHolder, t, i2);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i2 + " in data source");
    }

    /* renamed from: a */
    public final int m8239a(int i2) {
        return m8245b(i2).mo8203a();
    }
}
