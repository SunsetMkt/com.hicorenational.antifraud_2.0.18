package com.chad.library.adapter.base.p145d;

import android.util.SparseIntArray;
import androidx.annotation.LayoutRes;
import java.util.List;

/* compiled from: MultiTypeDelegate.java */
/* renamed from: com.chad.library.adapter.base.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC1916a<T> {

    /* renamed from: d */
    private static final int f5624d = -255;

    /* renamed from: a */
    private SparseIntArray f5625a;

    /* renamed from: b */
    private boolean f5626b;

    /* renamed from: c */
    private boolean f5627c;

    public AbstractC1916a(SparseIntArray sparseIntArray) {
        this.f5625a = sparseIntArray;
    }

    /* renamed from: b */
    private void m5267b(int i2, @LayoutRes int i3) {
        if (this.f5625a == null) {
            this.f5625a = new SparseIntArray();
        }
        this.f5625a.put(i2, i3);
    }

    /* renamed from: a */
    protected abstract int m5269a(T t);

    /* renamed from: a */
    public final int m5270a(List<T> list, int i2) {
        T t = list.get(i2);
        return t != null ? m5269a((AbstractC1916a<T>) t) : f5624d;
    }

    public AbstractC1916a() {
    }

    /* renamed from: a */
    public final int m5268a(int i2) {
        return this.f5625a.get(i2, -404);
    }

    /* renamed from: a */
    public AbstractC1916a m5272a(@LayoutRes int... iArr) {
        this.f5626b = true;
        m5266a(this.f5627c);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            m5267b(i2, iArr[i2]);
        }
        return this;
    }

    /* renamed from: a */
    public AbstractC1916a m5271a(int i2, @LayoutRes int i3) {
        this.f5627c = true;
        m5266a(this.f5626b);
        m5267b(i2, i3);
        return this;
    }

    /* renamed from: a */
    private void m5266a(boolean z) {
        if (z) {
            throw new RuntimeException("Don't mess two register mode");
        }
    }
}
