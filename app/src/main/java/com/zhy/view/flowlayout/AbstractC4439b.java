package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: TagAdapter.java */
/* renamed from: com.zhy.view.flowlayout.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4439b<T> {

    /* renamed from: a */
    private List<T> f16876a;

    /* renamed from: b */
    private a f16877b;

    /* renamed from: c */
    @Deprecated
    private HashSet<Integer> f16878c = new HashSet<>();

    /* compiled from: TagAdapter.java */
    /* renamed from: com.zhy.view.flowlayout.b$a */
    interface a {
        /* renamed from: a */
        void mo16379a();
    }

    public AbstractC4439b(List<T> list) {
        this.f16876a = list;
    }

    /* renamed from: a */
    public abstract View mo16383a(FlowLayout flowLayout, int i2, T t);

    @Deprecated
    /* renamed from: a */
    public void m16387a(int... iArr) {
        HashSet hashSet = new HashSet();
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        m16386a(hashSet);
    }

    /* renamed from: a */
    public boolean m16388a(int i2, T t) {
        return false;
    }

    @Deprecated
    /* renamed from: b */
    HashSet<Integer> m16389b() {
        return this.f16878c;
    }

    /* renamed from: c */
    public void m16391c() {
        a aVar = this.f16877b;
        if (aVar != null) {
            aVar.mo16379a();
        }
    }

    void setOnDataChangedListener(a aVar) {
        this.f16877b = aVar;
    }

    /* renamed from: b */
    public void m16390b(int i2, View view) {
        String str = "unSelected " + i2;
    }

    @Deprecated
    public AbstractC4439b(T[] tArr) {
        this.f16876a = new ArrayList(Arrays.asList(tArr));
    }

    @Deprecated
    /* renamed from: a */
    public void m16386a(Set<Integer> set) {
        this.f16878c.clear();
        if (set != null) {
            this.f16878c.addAll(set);
        }
        m16391c();
    }

    /* renamed from: a */
    public int m16382a() {
        List<T> list = this.f16876a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public T m16384a(int i2) {
        return this.f16876a.get(i2);
    }

    /* renamed from: a */
    public void m16385a(int i2, View view) {
        String str = "onSelected " + i2;
    }
}
