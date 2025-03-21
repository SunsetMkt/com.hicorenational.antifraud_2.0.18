package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.p143b.InterfaceC1911b;
import com.chad.library.adapter.base.p143b.InterfaceC1912c;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends InterfaceC1912c, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    /* renamed from: W */
    private static final int f5533W = -255;

    /* renamed from: X */
    public static final int f5534X = -404;

    /* renamed from: V */
    private SparseIntArray f5535V;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    /* renamed from: n */
    private int m5050n(int i2) {
        return this.f5535V.get(i2, -404);
    }

    /* renamed from: a */
    protected void m5051a(InterfaceC1911b interfaceC1911b, int i2) {
        List mo5237a;
        if (!interfaceC1911b.isExpanded() || (mo5237a = interfaceC1911b.mo5237a()) == null || mo5237a.size() == 0) {
            return;
        }
        int size = mo5237a.size();
        for (int i3 = 0; i3 < size; i3++) {
            mo5056f(i2 + 1);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b */
    protected K mo5053b(ViewGroup viewGroup, int i2) {
        return m5097a(viewGroup, m5050n(i2));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c */
    protected int mo5055c(int i2) {
        Object obj = this.f5546A.get(i2);
        return obj instanceof InterfaceC1912c ? ((InterfaceC1912c) obj).m5247a() : f5533W;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: f */
    public void mo5056f(@IntRange(from = 0) int i2) {
        List<T> list = this.f5546A;
        if (list == 0 || i2 < 0 || i2 >= list.size()) {
            return;
        }
        InterfaceC1912c interfaceC1912c = (InterfaceC1912c) this.f5546A.get(i2);
        if (interfaceC1912c instanceof InterfaceC1911b) {
            m5051a((InterfaceC1911b) interfaceC1912c, i2);
        }
        m5052a((BaseMultiItemQuickAdapter<T, K>) interfaceC1912c);
        super.mo5056f(i2);
    }

    /* renamed from: m */
    protected void m5057m(@LayoutRes int i2) {
        m5054b(f5533W, i2);
    }

    /* renamed from: b */
    protected void m5054b(int i2, @LayoutRes int i3) {
        if (this.f5535V == null) {
            this.f5535V = new SparseIntArray();
        }
        this.f5535V.put(i2, i3);
    }

    /* renamed from: a */
    protected void m5052a(T t) {
        int m5122b = m5122b((BaseMultiItemQuickAdapter<T, K>) t);
        if (m5122b >= 0) {
            ((InterfaceC1911b) this.f5546A.get(m5122b)).mo5237a().remove(t);
        }
    }
}
