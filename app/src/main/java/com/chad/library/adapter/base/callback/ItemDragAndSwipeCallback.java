package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.C1883R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;

/* loaded from: classes.dex */
public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private BaseItemDraggableAdapter f5619a;

    /* renamed from: b */
    private float f5620b = 0.1f;

    /* renamed from: c */
    private float f5621c = 0.7f;

    /* renamed from: d */
    private int f5622d = 15;

    /* renamed from: e */
    private int f5623e = 32;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.f5619a = baseItemDraggableAdapter;
    }

    /* renamed from: a */
    public void m5262a(float f2) {
        this.f5620b = f2;
    }

    /* renamed from: b */
    public void m5264b(float f2) {
        this.f5621c = f2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (m5261a(viewHolder)) {
            return;
        }
        if (viewHolder.itemView.getTag(C1883R.id.BaseQuickAdapter_dragging_support) != null && ((Boolean) viewHolder.itemView.getTag(C1883R.id.BaseQuickAdapter_dragging_support)).booleanValue()) {
            this.f5619a.m5043c(viewHolder);
            viewHolder.itemView.setTag(C1883R.id.BaseQuickAdapter_dragging_support, false);
        }
        if (viewHolder.itemView.getTag(C1883R.id.BaseQuickAdapter_swiping_support) == null || !((Boolean) viewHolder.itemView.getTag(C1883R.id.BaseQuickAdapter_swiping_support)).booleanValue()) {
            return;
        }
        this.f5619a.m5045e(viewHolder);
        viewHolder.itemView.setTag(C1883R.id.BaseQuickAdapter_swiping_support, false);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.f5620b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return m5261a(viewHolder) ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(this.f5622d, this.f5623e);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.f5621c;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return this.f5619a.m5037K();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f2, f3, i2, z);
        if (i2 != 1 || m5261a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        canvas.save();
        if (f2 > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f2, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f2, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f2, view.getTop());
        }
        this.f5619a.m5038a(canvas, viewHolder, f2, f3, z);
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i2, RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5) {
        super.onMoved(recyclerView, viewHolder, i2, viewHolder2, i3, i4, i5);
        this.f5619a.m5041a(viewHolder, viewHolder2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        if (i2 == 2 && !m5261a(viewHolder)) {
            this.f5619a.m5044d(viewHolder);
            viewHolder.itemView.setTag(C1883R.id.BaseQuickAdapter_dragging_support, true);
        } else if (i2 == 1 && !m5261a(viewHolder)) {
            this.f5619a.m5046f(viewHolder);
            viewHolder.itemView.setTag(C1883R.id.BaseQuickAdapter_swiping_support, true);
        }
        super.onSelectedChanged(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
        if (m5261a(viewHolder)) {
            return;
        }
        this.f5619a.m5047g(viewHolder);
    }

    /* renamed from: a */
    public void m5263a(int i2) {
        this.f5622d = i2;
    }

    /* renamed from: b */
    public void m5265b(int i2) {
        this.f5623e = i2;
    }

    /* renamed from: a */
    private boolean m5261a(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }
}
