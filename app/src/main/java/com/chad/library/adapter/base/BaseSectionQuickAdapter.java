package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.b.d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends d, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int W = 1092;
    protected int V;

    public BaseSectionQuickAdapter(int i2, int i3, List<T> list) {
        super(i2, list);
        this.V = i3;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(K k2, int i2) {
        if (k2.getItemViewType() != W) {
            super.onBindViewHolder(k2, i2);
        } else {
            a((RecyclerView.ViewHolder) k2);
            a((BaseViewHolder) k2, (d) getItem(i2 - j()));
        }
    }

    protected abstract void a(K k2, T t);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K b(ViewGroup viewGroup, int i2) {
        return i2 == W ? c(a(this.V, viewGroup)) : (K) super.b(viewGroup, i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int c(int i2) {
        if (this.A.get(i2).isHeader) {
            return W;
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected boolean d(int i2) {
        return super.d(i2) || i2 == W;
    }
}
