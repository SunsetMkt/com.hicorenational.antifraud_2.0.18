package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.C1883R;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.InterfaceC1919a;
import com.chad.library.adapter.base.listener.InterfaceC1920b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    /* renamed from: e0 */
    private static final int f5520e0 = 0;

    /* renamed from: f0 */
    private static final String f5521f0 = "Item drag and item swipe should pass the same ItemTouchHelper";

    /* renamed from: V */
    protected int f5522V;

    /* renamed from: W */
    protected ItemTouchHelper f5523W;

    /* renamed from: X */
    protected boolean f5524X;

    /* renamed from: Y */
    protected boolean f5525Y;

    /* renamed from: Z */
    protected InterfaceC1919a f5526Z;

    /* renamed from: a0 */
    protected InterfaceC1920b f5527a0;

    /* renamed from: b0 */
    protected boolean f5528b0;

    /* renamed from: c0 */
    protected View.OnTouchListener f5529c0;

    /* renamed from: d0 */
    protected View.OnLongClickListener f5530d0;

    /* renamed from: com.chad.library.adapter.base.BaseItemDraggableAdapter$a */
    class ViewOnLongClickListenerC1885a implements View.OnLongClickListener {
        ViewOnLongClickListenerC1885a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
            ItemTouchHelper itemTouchHelper = baseItemDraggableAdapter.f5523W;
            if (itemTouchHelper == null || !baseItemDraggableAdapter.f5524X) {
                return true;
            }
            itemTouchHelper.startDrag((RecyclerView.ViewHolder) view.getTag(C1883R.id.BaseQuickAdapter_viewholder_support));
            return true;
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseItemDraggableAdapter$b */
    class ViewOnTouchListenerC1886b implements View.OnTouchListener {
        ViewOnTouchListenerC1886b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (MotionEventCompat.getActionMasked(motionEvent) != 0) {
                return false;
            }
            BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
            if (baseItemDraggableAdapter.f5528b0) {
                return false;
            }
            ItemTouchHelper itemTouchHelper = baseItemDraggableAdapter.f5523W;
            if (itemTouchHelper == null || !baseItemDraggableAdapter.f5524X) {
                return true;
            }
            itemTouchHelper.startDrag((RecyclerView.ViewHolder) view.getTag(C1883R.id.BaseQuickAdapter_viewholder_support));
            return true;
        }
    }

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.f5522V = 0;
        this.f5524X = false;
        this.f5525Y = false;
        this.f5528b0 = true;
    }

    /* renamed from: n */
    private boolean m5032n(int i2) {
        return i2 >= 0 && i2 < this.f5546A.size();
    }

    /* renamed from: G */
    public void m5033G() {
        this.f5524X = false;
        this.f5523W = null;
    }

    /* renamed from: H */
    public void m5034H() {
        this.f5525Y = false;
    }

    /* renamed from: I */
    public void m5035I() {
        this.f5525Y = true;
    }

    /* renamed from: J */
    public boolean m5036J() {
        return this.f5524X;
    }

    /* renamed from: K */
    public boolean m5037K() {
        return this.f5525Y;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(K k2, int i2) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k2, i2);
        int itemViewType = k2.getItemViewType();
        if (this.f5523W == null || !this.f5524X || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819) {
            return;
        }
        int i3 = this.f5522V;
        if (i3 == 0) {
            k2.itemView.setTag(C1883R.id.BaseQuickAdapter_viewholder_support, k2);
            k2.itemView.setOnLongClickListener(this.f5530d0);
            return;
        }
        View m5224c = k2.m5224c(i3);
        if (m5224c != null) {
            m5224c.setTag(C1883R.id.BaseQuickAdapter_viewholder_support, k2);
            if (this.f5528b0) {
                m5224c.setOnLongClickListener(this.f5530d0);
            } else {
                m5224c.setOnTouchListener(this.f5529c0);
            }
        }
    }

    /* renamed from: b */
    public int m5042b(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition() - m5164j();
    }

    /* renamed from: c */
    public void m5043c(RecyclerView.ViewHolder viewHolder) {
        InterfaceC1919a interfaceC1919a = this.f5526Z;
        if (interfaceC1919a == null || !this.f5524X) {
            return;
        }
        interfaceC1919a.m5294a(viewHolder, m5042b(viewHolder));
    }

    /* renamed from: d */
    public void m5044d(RecyclerView.ViewHolder viewHolder) {
        InterfaceC1919a interfaceC1919a = this.f5526Z;
        if (interfaceC1919a == null || !this.f5524X) {
            return;
        }
        interfaceC1919a.m5296b(viewHolder, m5042b(viewHolder));
    }

    /* renamed from: e */
    public void m5045e(RecyclerView.ViewHolder viewHolder) {
        InterfaceC1920b interfaceC1920b = this.f5527a0;
        if (interfaceC1920b == null || !this.f5525Y) {
            return;
        }
        interfaceC1920b.m5300c(viewHolder, m5042b(viewHolder));
    }

    /* renamed from: f */
    public void m5046f(RecyclerView.ViewHolder viewHolder) {
        InterfaceC1920b interfaceC1920b = this.f5527a0;
        if (interfaceC1920b == null || !this.f5525Y) {
            return;
        }
        interfaceC1920b.m5298a(viewHolder, m5042b(viewHolder));
    }

    /* renamed from: g */
    public void m5047g(RecyclerView.ViewHolder viewHolder) {
        InterfaceC1920b interfaceC1920b = this.f5527a0;
        if (interfaceC1920b != null && this.f5525Y) {
            interfaceC1920b.m5299b(viewHolder, m5042b(viewHolder));
        }
        int m5042b = m5042b(viewHolder);
        if (m5032n(m5042b)) {
            this.f5546A.remove(m5042b);
            notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    /* renamed from: k */
    public void m5048k(boolean z) {
        this.f5528b0 = z;
        if (this.f5528b0) {
            this.f5529c0 = null;
            this.f5530d0 = new ViewOnLongClickListenerC1885a();
        } else {
            this.f5529c0 = new ViewOnTouchListenerC1886b();
            this.f5530d0 = null;
        }
    }

    /* renamed from: m */
    public void m5049m(int i2) {
        this.f5522V = i2;
    }

    public void setOnItemDragListener(InterfaceC1919a interfaceC1919a) {
        this.f5526Z = interfaceC1919a;
    }

    public void setOnItemSwipeListener(InterfaceC1920b interfaceC1920b) {
        this.f5527a0 = interfaceC1920b;
    }

    public BaseItemDraggableAdapter(int i2, List<T> list) {
        super(i2, list);
        this.f5522V = 0;
        this.f5524X = false;
        this.f5525Y = false;
        this.f5528b0 = true;
    }

    /* renamed from: a */
    public void m5039a(@NonNull ItemTouchHelper itemTouchHelper) {
        m5040a(itemTouchHelper, 0, true);
    }

    /* renamed from: a */
    public void m5040a(@NonNull ItemTouchHelper itemTouchHelper, int i2, boolean z) {
        this.f5524X = true;
        this.f5523W = itemTouchHelper;
        m5049m(i2);
        m5048k(z);
    }

    /* renamed from: a */
    public void m5041a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int m5042b = m5042b(viewHolder);
        int m5042b2 = m5042b(viewHolder2);
        if (m5032n(m5042b) && m5032n(m5042b2)) {
            if (m5042b < m5042b2) {
                int i2 = m5042b;
                while (i2 < m5042b2) {
                    int i3 = i2 + 1;
                    Collections.swap(this.f5546A, i2, i3);
                    i2 = i3;
                }
            } else {
                for (int i4 = m5042b; i4 > m5042b2; i4--) {
                    Collections.swap(this.f5546A, i4, i4 - 1);
                }
            }
            notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        InterfaceC1919a interfaceC1919a = this.f5526Z;
        if (interfaceC1919a == null || !this.f5524X) {
            return;
        }
        interfaceC1919a.m5295a(viewHolder, m5042b, viewHolder2, m5042b2);
    }

    /* renamed from: a */
    public void m5038a(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f2, float f3, boolean z) {
        InterfaceC1920b interfaceC1920b = this.f5527a0;
        if (interfaceC1920b == null || !this.f5525Y) {
            return;
        }
        interfaceC1920b.m5297a(canvas, viewHolder, f2, f3, z);
    }
}
