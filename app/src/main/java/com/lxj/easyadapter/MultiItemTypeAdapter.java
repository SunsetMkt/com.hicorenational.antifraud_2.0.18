package com.lxj.easyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.ViewHolder;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: MultiItemTypeAdapter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 D*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003DEFB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\"\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\u001b\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00028\u0000¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010)\u001a\u00020\u000bH\u0004J\u0010\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00104\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0016\u0010=\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0012J \u0010?\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000bH\u0004J\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u001bJ\b\u0010C\u001a\u000202H\u0004R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006G"}, m23546d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lxj/easyadapter/ViewHolder;", "data", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "footersCount", "", "getFootersCount", "()I", "headersCount", "getHeadersCount", "mFootViews", "Landroidx/collection/SparseArrayCompat;", "Landroid/view/View;", "mHeaderViews", "mItemDelegateManager", "Lcom/lxj/easyadapter/ItemDelegateManager;", "getMItemDelegateManager", "()Lcom/lxj/easyadapter/ItemDelegateManager;", "setMItemDelegateManager", "(Lcom/lxj/easyadapter/ItemDelegateManager;)V", "mOnItemClickListener", "Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "getMOnItemClickListener", "()Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;)V", "realItemCount", "getRealItemCount", "addFootView", "", "view", "addHeaderView", "addItemDelegate", "itemViewDelegate", "Lcom/lxj/easyadapter/ItemDelegate;", "viewType", "convert", "holder", "t", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;)V", "getItemCount", "getItemViewType", "position", "isEnabled", "", "isFooterViewPos", "isHeaderViewPos", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "onViewHolderCreated", "itemView", "setListener", "viewHolder", "setOnItemClickListener", "onItemClickListener", "useItemDelegateManager", "Companion", "OnItemClickListener", "SimpleOnItemClickListener", "easy-adapter_release"}, m23547k = 1, m23548mv = {1, 1, 13})
/* loaded from: classes.dex */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: f */
    private static final int f8480f = 100000;

    /* renamed from: g */
    private static final int f8481g = 200000;

    /* renamed from: h */
    public static final C2747a f8482h = new C2747a(null);

    /* renamed from: a */
    private final SparseArrayCompat<View> f8483a;

    /* renamed from: b */
    private final SparseArrayCompat<View> f8484b;

    /* renamed from: c */
    @InterfaceC5816d
    private C2757c<T> f8485c;

    /* renamed from: d */
    @InterfaceC5817e
    private InterfaceC2748b f8486d;

    /* renamed from: e */
    @InterfaceC5816d
    private List<? extends T> f8487e;

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$a */
    public static final class C2747a {
        private C2747a() {
        }

        public /* synthetic */ C2747a(C5586v c5586v) {
            this();
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$b */
    public interface InterfaceC2748b {
        /* renamed from: a */
        void mo8228a(@InterfaceC5816d View view, @InterfaceC5816d RecyclerView.ViewHolder viewHolder, int i2);

        /* renamed from: b */
        boolean mo8229b(@InterfaceC5816d View view, @InterfaceC5816d RecyclerView.ViewHolder viewHolder, int i2);
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$c */
    public static class C2749c implements InterfaceC2748b {
        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.InterfaceC2748b
        /* renamed from: a */
        public void mo8228a(@InterfaceC5816d View view, @InterfaceC5816d RecyclerView.ViewHolder viewHolder, int i2) {
            C5544i0.m22546f(view, "view");
            C5544i0.m22546f(viewHolder, "holder");
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.InterfaceC2748b
        /* renamed from: b */
        public boolean mo8229b(@InterfaceC5816d View view, @InterfaceC5816d RecyclerView.ViewHolder viewHolder, int i2) {
            C5544i0.m22546f(view, "view");
            C5544i0.m22546f(viewHolder, "holder");
            return false;
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$d */
    static final class C2750d extends AbstractC5547j0 implements InterfaceC5511q<GridLayoutManager, GridLayoutManager.SpanSizeLookup, Integer, Integer> {
        C2750d() {
            super(3);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5511q
        public /* bridge */ /* synthetic */ Integer invoke(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, Integer num) {
            return Integer.valueOf(invoke(gridLayoutManager, spanSizeLookup, num.intValue()));
        }

        public final int invoke(@InterfaceC5816d GridLayoutManager gridLayoutManager, @InterfaceC5816d GridLayoutManager.SpanSizeLookup spanSizeLookup, int i2) {
            C5544i0.m22546f(gridLayoutManager, "layoutManager");
            C5544i0.m22546f(spanSizeLookup, "oldLookup");
            int itemViewType = MultiItemTypeAdapter.this.getItemViewType(i2);
            if (MultiItemTypeAdapter.this.f8483a.get(itemViewType) == null && MultiItemTypeAdapter.this.f8484b.get(itemViewType) == null) {
                return spanSizeLookup.getSpanSize(i2);
            }
            return gridLayoutManager.getSpanCount();
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$e */
    static final class ViewOnClickListenerC2751e implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ ViewHolder f8489b;

        ViewOnClickListenerC2751e(ViewHolder viewHolder) {
            this.f8489b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (MultiItemTypeAdapter.this.m8226e() != null) {
                int adapterPosition = this.f8489b.getAdapterPosition() - MultiItemTypeAdapter.this.m8224c();
                InterfaceC2748b m8226e = MultiItemTypeAdapter.this.m8226e();
                if (m8226e == null) {
                    C5544i0.m22545f();
                }
                C5544i0.m22521a((Object) view, "v");
                m8226e.mo8228a(view, this.f8489b, adapterPosition);
            }
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: com.lxj.easyadapter.MultiItemTypeAdapter$f */
    static final class ViewOnLongClickListenerC2752f implements View.OnLongClickListener {

        /* renamed from: b */
        final /* synthetic */ ViewHolder f8491b;

        ViewOnLongClickListenerC2752f(ViewHolder viewHolder) {
            this.f8491b = viewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            if (MultiItemTypeAdapter.this.m8226e() == null) {
                return false;
            }
            int adapterPosition = this.f8491b.getAdapterPosition() - MultiItemTypeAdapter.this.m8224c();
            InterfaceC2748b m8226e = MultiItemTypeAdapter.this.m8226e();
            if (m8226e == null) {
                C5544i0.m22545f();
            }
            C5544i0.m22521a((Object) view, "v");
            return m8226e.mo8229b(view, this.f8491b, adapterPosition);
        }
    }

    public MultiItemTypeAdapter(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "data");
        this.f8487e = list;
        this.f8483a = new SparseArrayCompat<>();
        this.f8484b = new SparseArrayCompat<>();
        this.f8485c = new C2757c<>();
    }

    /* renamed from: g */
    private final int m8210g() {
        return (getItemCount() - m8224c()) - m8222b();
    }

    /* renamed from: a */
    public final void m8218a(@InterfaceC5816d ViewHolder viewHolder, @InterfaceC5816d View view) {
        C5544i0.m22546f(viewHolder, "holder");
        C5544i0.m22546f(view, "itemView");
    }

    /* renamed from: a */
    protected final boolean m8221a(int i2) {
        return true;
    }

    /* renamed from: c */
    public final int m8224c() {
        return this.f8483a.size();
    }

    @InterfaceC5816d
    /* renamed from: d */
    protected final C2757c<T> m8225d() {
        return this.f8485c;
    }

    @InterfaceC5817e
    /* renamed from: e */
    protected final InterfaceC2748b m8226e() {
        return this.f8486d;
    }

    /* renamed from: f */
    protected final boolean m8227f() {
        return this.f8485c.m8238a() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return m8224c() + m8222b() + this.f8487e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return m8209c(i2) ? this.f8483a.keyAt(i2) : m8208b(i2) ? this.f8484b.keyAt((i2 - m8224c()) - m8210g()) : !m8227f() ? super.getItemViewType(i2) : this.f8485c.m8240a((C2757c<T>) this.f8487e.get(i2 - m8224c()), i2 - m8224c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WrapperUtils.f8496a.m8237a(recyclerView, new C2750d());
    }

    public final void setData(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "<set-?>");
        this.f8487e = list;
    }

    protected final void setMOnItemClickListener(@InterfaceC5817e InterfaceC2748b interfaceC2748b) {
        this.f8486d = interfaceC2748b;
    }

    public final void setOnItemClickListener(@InterfaceC5816d InterfaceC2748b interfaceC2748b) {
        C5544i0.m22546f(interfaceC2748b, "onItemClickListener");
        this.f8486d = interfaceC2748b;
    }

    /* renamed from: c */
    private final boolean m8209c(int i2) {
        return i2 < m8224c();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final List<T> m8213a() {
        return this.f8487e;
    }

    /* renamed from: b */
    public final int m8222b() {
        return this.f8484b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @InterfaceC5816d
    public ViewHolder onCreateViewHolder(@InterfaceC5816d ViewGroup viewGroup, int i2) {
        C5544i0.m22546f(viewGroup, "parent");
        if (this.f8483a.get(i2) != null) {
            ViewHolder.C2754a c2754a = ViewHolder.f8493c;
            View view = this.f8483a.get(i2);
            if (view == null) {
                C5544i0.m22545f();
            }
            return c2754a.m8235a(view);
        }
        if (this.f8484b.get(i2) != null) {
            ViewHolder.C2754a c2754a2 = ViewHolder.f8493c;
            View view2 = this.f8484b.get(i2);
            if (view2 == null) {
                C5544i0.m22545f();
            }
            return c2754a2.m8235a(view2);
        }
        int mo8203a = this.f8485c.m8245b(i2).mo8203a();
        ViewHolder.C2754a c2754a3 = ViewHolder.f8493c;
        Context context = viewGroup.getContext();
        C5544i0.m22521a((Object) context, "parent.context");
        ViewHolder m8234a = c2754a3.m8234a(context, viewGroup, mo8203a);
        m8218a(m8234a, m8234a.m8230a());
        m8215a(viewGroup, m8234a, i2);
        return m8234a;
    }

    /* renamed from: b */
    private final boolean m8208b(int i2) {
        return i2 >= m8224c() + m8210g();
    }

    /* renamed from: a */
    protected final void m8220a(@InterfaceC5816d C2757c<T> c2757c) {
        C5544i0.m22546f(c2757c, "<set-?>");
        this.f8485c = c2757c;
    }

    /* renamed from: a */
    public final void m8219a(@InterfaceC5816d ViewHolder viewHolder, T t) {
        C5544i0.m22546f(viewHolder, "holder");
        this.f8485c.m8243a(viewHolder, t, viewHolder.getAdapterPosition() - m8224c());
    }

    /* renamed from: b */
    public final void m8223b(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        SparseArrayCompat<View> sparseArrayCompat = this.f8483a;
        sparseArrayCompat.put(sparseArrayCompat.size() + f8480f, view);
    }

    /* renamed from: a */
    protected final void m8215a(@InterfaceC5816d ViewGroup viewGroup, @InterfaceC5816d ViewHolder viewHolder, int i2) {
        C5544i0.m22546f(viewGroup, "parent");
        C5544i0.m22546f(viewHolder, "viewHolder");
        if (m8221a(i2)) {
            viewHolder.m8230a().setOnClickListener(new ViewOnClickListenerC2751e(viewHolder));
            viewHolder.m8230a().setOnLongClickListener(new ViewOnLongClickListenerC2752f(viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@InterfaceC5816d ViewHolder viewHolder, int i2) {
        C5544i0.m22546f(viewHolder, "holder");
        if (m8209c(i2) || m8208b(i2)) {
            return;
        }
        m8219a(viewHolder, (ViewHolder) this.f8487e.get(i2 - m8224c()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@InterfaceC5816d ViewHolder viewHolder) {
        C5544i0.m22546f(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (m8209c(layoutPosition) || m8208b(layoutPosition)) {
            WrapperUtils.f8496a.m8236a(viewHolder);
        }
    }

    /* renamed from: a */
    public final void m8214a(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        SparseArrayCompat<View> sparseArrayCompat = this.f8484b;
        sparseArrayCompat.put(sparseArrayCompat.size() + f8481g, view);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final MultiItemTypeAdapter<T> m8212a(@InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "itemViewDelegate");
        this.f8485c.m8242a(interfaceC2756b);
        return this;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final MultiItemTypeAdapter<T> m8211a(int i2, @InterfaceC5816d InterfaceC2756b<T> interfaceC2756b) {
        C5544i0.m22546f(interfaceC2756b, "itemViewDelegate");
        this.f8485c.m8241a(i2, interfaceC2756b);
        return this;
    }
}
