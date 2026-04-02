package com.chad.library.adapter.base.d;

import android.util.SparseIntArray;
import androidx.annotation.LayoutRes;
import java.util.List;

/* JADX INFO: compiled from: MultiTypeDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f3623d = -255;
    private SparseIntArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3625c;

    public a(SparseIntArray sparseIntArray) {
        this.a = sparseIntArray;
    }

    private void b(int i2, @LayoutRes int i3) {
        if (this.a == null) {
            this.a = new SparseIntArray();
        }
        this.a.put(i2, i3);
    }

    protected abstract int a(T t);

    public final int a(List<T> list, int i2) {
        T t = list.get(i2);
        return t != null ? a(t) : f3623d;
    }

    public a() {
    }

    public final int a(int i2) {
        return this.a.get(i2, -404);
    }

    public a a(@LayoutRes int... iArr) {
        this.f3624b = true;
        a(this.f3625c);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            b(i2, iArr[i2]);
        }
        return this;
    }

    public a a(int i2, @LayoutRes int i3) {
        this.f3625c = true;
        a(this.f3624b);
        b(i2, i3);
        return this;
    }

    private void a(boolean z) {
        if (z) {
            throw new RuntimeException("Don't mess two register mode");
        }
    }
}
