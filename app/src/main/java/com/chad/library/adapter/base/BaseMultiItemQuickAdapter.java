package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.b.b;
import com.chad.library.adapter.base.b.c;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends c, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int W = -255;
    public static final int X = -404;
    private SparseIntArray V;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    private int n(int i2) {
        return this.V.get(i2, -404);
    }

    protected void a(b bVar, int i2) {
        List a2;
        if (!bVar.isExpanded() || (a2 = bVar.a()) == null || a2.size() == 0) {
            return;
        }
        int size = a2.size();
        for (int i3 = 0; i3 < size; i3++) {
            f(i2 + 1);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K b(ViewGroup viewGroup, int i2) {
        return a(viewGroup, n(i2));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int c(int i2) {
        Object obj = this.A.get(i2);
        return obj instanceof c ? ((c) obj).a() : W;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void f(@IntRange(from = 0) int i2) {
        List<T> list = this.A;
        if (list == 0 || i2 < 0 || i2 >= list.size()) {
            return;
        }
        c cVar = (c) this.A.get(i2);
        if (cVar instanceof b) {
            a((b) cVar, i2);
        }
        a((BaseMultiItemQuickAdapter<T, K>) cVar);
        super.f(i2);
    }

    protected void m(@LayoutRes int i2) {
        b(W, i2);
    }

    protected void b(int i2, @LayoutRes int i3) {
        if (this.V == null) {
            this.V = new SparseIntArray();
        }
        this.V.put(i2, i3);
    }

    protected void a(T t) {
        int b2 = b((BaseMultiItemQuickAdapter<T, K>) t);
        if (b2 >= 0) {
            ((b) this.A.get(b2)).a().remove(t);
        }
    }
}
