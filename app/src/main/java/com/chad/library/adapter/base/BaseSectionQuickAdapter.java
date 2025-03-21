package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.p143b.AbstractC1913d;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends AbstractC1913d, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    /* renamed from: W */
    protected static final int f5595W = 1092;

    /* renamed from: V */
    protected int f5596V;

    public BaseSectionQuickAdapter(int i2, int i3, List<T> list) {
        super(i2, list);
        this.f5596V = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(K k2, int i2) {
        if (k2.getItemViewType() != f5595W) {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, K>) k2, i2);
        } else {
            m5102a((RecyclerView.ViewHolder) k2);
            m5190a((BaseSectionQuickAdapter<T, K>) k2, (K) getItem(i2 - m5164j()));
        }
    }

    /* renamed from: a */
    protected abstract void m5190a(K k2, T t);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b */
    protected K mo5053b(ViewGroup viewGroup, int i2) {
        return i2 == f5595W ? m5133c(m5095a(this.f5596V, viewGroup)) : (K) super.mo5053b(viewGroup, i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c */
    protected int mo5055c(int i2) {
        if (((AbstractC1913d) this.f5546A.get(i2)).isHeader) {
            return f5595W;
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d */
    protected boolean mo5143d(int i2) {
        return super.mo5143d(i2) || i2 == f5595W;
    }
}
