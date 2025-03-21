package com.lxj.easyadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: WrapperUtils.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000f0\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, m23546d2 = {"Lcom/lxj/easyadapter/WrapperUtils;", "", "()V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "fn", "Lkotlin/Function3;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "oldLookup", "", "position", "setFullSpan", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "easy-adapter_release"}, m23547k = 1, m23548mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class WrapperUtils {

    /* renamed from: a */
    public static final WrapperUtils f8496a = new WrapperUtils();

    private WrapperUtils() {
    }

    /* renamed from: a */
    public final void m8237a(@InterfaceC5816d RecyclerView recyclerView, @InterfaceC5816d final InterfaceC5511q<? super GridLayoutManager, ? super GridLayoutManager.SpanSizeLookup, ? super Integer, Integer> interfaceC5511q) {
        C5544i0.m22546f(recyclerView, "recyclerView");
        C5544i0.m22546f(interfaceC5511q, "fn");
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.lxj.easyadapter.WrapperUtils$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i2) {
                    InterfaceC5511q interfaceC5511q2 = InterfaceC5511q.this;
                    RecyclerView.LayoutManager layoutManager2 = layoutManager;
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    C5544i0.m22521a((Object) spanSizeLookup2, "spanSizeLookup");
                    return ((Number) interfaceC5511q2.invoke(layoutManager2, spanSizeLookup2, Integer.valueOf(i2))).intValue();
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    /* renamed from: a */
    public final void m8236a(@InterfaceC5816d RecyclerView.ViewHolder viewHolder) {
        C5544i0.m22546f(viewHolder, "holder");
        View view = viewHolder.itemView;
        C5544i0.m22521a((Object) view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }
}
