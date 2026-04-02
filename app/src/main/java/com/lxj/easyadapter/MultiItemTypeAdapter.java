package com.lxj.easyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.ViewHolder;
import i.q2.s.q;
import i.q2.t.i0;
import i.q2.t.j0;
import i.q2.t.v;
import i.y;
import java.util.List;

/* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 D*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003DEFB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\"\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\u001b\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00028\u0000\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010)\u001a\u00020\u000bH\u0004J\u0010\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00104\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0016\u0010=\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0012J \u0010?\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000bH\u0004J\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u001bJ\b\u0010C\u001a\u000202H\u0004R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\r\u00a8\u0006G"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lxj/easyadapter/ViewHolder;", "data", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "footersCount", "", "getFootersCount", "()I", "headersCount", "getHeadersCount", "mFootViews", "Landroidx/collection/SparseArrayCompat;", "Landroid/view/View;", "mHeaderViews", "mItemDelegateManager", "Lcom/lxj/easyadapter/ItemDelegateManager;", "getMItemDelegateManager", "()Lcom/lxj/easyadapter/ItemDelegateManager;", "setMItemDelegateManager", "(Lcom/lxj/easyadapter/ItemDelegateManager;)V", "mOnItemClickListener", "Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "getMOnItemClickListener", "()Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;)V", "realItemCount", "getRealItemCount", "addFootView", "", "view", "addHeaderView", "addItemDelegate", "itemViewDelegate", "Lcom/lxj/easyadapter/ItemDelegate;", "viewType", "convert", "holder", "t", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;)V", "getItemCount", "getItemViewType", "position", "isEnabled", "", "isFooterViewPos", "isHeaderViewPos", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "onViewHolderCreated", "itemView", "setListener", "viewHolder", "setOnItemClickListener", "onItemClickListener", "useItemDelegateManager", "Companion", "OnItemClickListener", "SimpleOnItemClickListener", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f5340f = 100000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5341g = 200000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f5342h = new a(null);
    private final SparseArrayCompat<View> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArrayCompat<View> f5343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @j.c.a.d
    private com.lxj.easyadapter.c<T> f5344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @j.c.a.e
    private b f5345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @j.c.a.d
    private List<? extends T> f5346e;

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public interface b {
        void a(@j.c.a.d View view, @j.c.a.d RecyclerView.ViewHolder viewHolder, int i2);

        boolean b(@j.c.a.d View view, @j.c.a.d RecyclerView.ViewHolder viewHolder, int i2);
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public static class c implements b {
        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void a(@j.c.a.d View view, @j.c.a.d RecyclerView.ViewHolder viewHolder, int i2) {
            i0.f(view, "view");
            i0.f(viewHolder, "holder");
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.b
        public boolean b(@j.c.a.d View view, @j.c.a.d RecyclerView.ViewHolder viewHolder, int i2) {
            i0.f(view, "view");
            i0.f(viewHolder, "holder");
            return false;
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    static final class d extends j0 implements q<GridLayoutManager, GridLayoutManager.SpanSizeLookup, Integer, Integer> {
        d() {
            super(3);
        }

        @Override // i.q2.s.q
        public /* bridge */ /* synthetic */ Integer invoke(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, Integer num) {
            return Integer.valueOf(invoke(gridLayoutManager, spanSizeLookup, num.intValue()));
        }

        public final int invoke(@j.c.a.d GridLayoutManager gridLayoutManager, @j.c.a.d GridLayoutManager.SpanSizeLookup spanSizeLookup, int i2) {
            i0.f(gridLayoutManager, "layoutManager");
            i0.f(spanSizeLookup, "oldLookup");
            int itemViewType = MultiItemTypeAdapter.this.getItemViewType(i2);
            if (MultiItemTypeAdapter.this.a.get(itemViewType) == null && MultiItemTypeAdapter.this.f5343b.get(itemViewType) == null) {
                return spanSizeLookup.getSpanSize(i2);
            }
            return gridLayoutManager.getSpanCount();
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewHolder f5347b;

        e(ViewHolder viewHolder) {
            this.f5347b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (MultiItemTypeAdapter.this.e() != null) {
                int adapterPosition = this.f5347b.getAdapterPosition() - MultiItemTypeAdapter.this.c();
                b bVarE = MultiItemTypeAdapter.this.e();
                if (bVarE == null) {
                    i0.f();
                }
                i0.a((Object) view, "v");
                bVarE.a(view, this.f5347b, adapterPosition);
            }
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    static final class f implements View.OnLongClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewHolder f5348b;

        f(ViewHolder viewHolder) {
            this.f5348b = viewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            if (MultiItemTypeAdapter.this.e() == null) {
                return false;
            }
            int adapterPosition = this.f5348b.getAdapterPosition() - MultiItemTypeAdapter.this.c();
            b bVarE = MultiItemTypeAdapter.this.e();
            if (bVarE == null) {
                i0.f();
            }
            i0.a((Object) view, "v");
            return bVarE.b(view, this.f5348b, adapterPosition);
        }
    }

    public MultiItemTypeAdapter(@j.c.a.d List<? extends T> list) {
        i0.f(list, "data");
        this.f5346e = list;
        this.a = new SparseArrayCompat<>();
        this.f5343b = new SparseArrayCompat<>();
        this.f5344c = new com.lxj.easyadapter.c<>();
    }

    private final int g() {
        return (getItemCount() - c()) - b();
    }

    public final void a(@j.c.a.d ViewHolder viewHolder, @j.c.a.d View view) {
        i0.f(viewHolder, "holder");
        i0.f(view, "itemView");
    }

    protected final boolean a(int i2) {
        return true;
    }

    public final int c() {
        return this.a.size();
    }

    @j.c.a.d
    protected final com.lxj.easyadapter.c<T> d() {
        return this.f5344c;
    }

    @j.c.a.e
    protected final b e() {
        return this.f5345d;
    }

    protected final boolean f() {
        return this.f5344c.a() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return c() + b() + this.f5346e.size();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return c(i2) ? this.a.keyAt(i2) : b(i2) ? this.f5343b.keyAt((i2 - c()) - g()) : !f() ? super.getItemViewType(i2) : this.f5344c.a(this.f5346e.get(i2 - c()), i2 - c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@j.c.a.d RecyclerView recyclerView) {
        i0.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WrapperUtils.a.a(recyclerView, new d());
    }

    public final void setData(@j.c.a.d List<? extends T> list) {
        i0.f(list, "<set-?>");
        this.f5346e = list;
    }

    protected final void setMOnItemClickListener(@j.c.a.e b bVar) {
        this.f5345d = bVar;
    }

    public final void setOnItemClickListener(@j.c.a.d b bVar) {
        i0.f(bVar, "onItemClickListener");
        this.f5345d = bVar;
    }

    private final boolean c(int i2) {
        return i2 < c();
    }

    @j.c.a.d
    public final List<T> a() {
        return this.f5346e;
    }

    public final int b() {
        return this.f5343b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @j.c.a.d
    public ViewHolder onCreateViewHolder(@j.c.a.d ViewGroup viewGroup, int i2) {
        i0.f(viewGroup, "parent");
        if (this.a.get(i2) != null) {
            ViewHolder.a aVar = ViewHolder.f5349c;
            View view = this.a.get(i2);
            if (view == null) {
                i0.f();
            }
            return aVar.a(view);
        }
        if (this.f5343b.get(i2) != null) {
            ViewHolder.a aVar2 = ViewHolder.f5349c;
            View view2 = this.f5343b.get(i2);
            if (view2 == null) {
                i0.f();
            }
            return aVar2.a(view2);
        }
        int iA = this.f5344c.b(i2).a();
        ViewHolder.a aVar3 = ViewHolder.f5349c;
        Context context = viewGroup.getContext();
        i0.a((Object) context, "parent.context");
        ViewHolder viewHolderA = aVar3.a(context, viewGroup, iA);
        a(viewHolderA, viewHolderA.a());
        a(viewGroup, viewHolderA, i2);
        return viewHolderA;
    }

    private final boolean b(int i2) {
        return i2 >= c() + g();
    }

    protected final void a(@j.c.a.d com.lxj.easyadapter.c<T> cVar) {
        i0.f(cVar, "<set-?>");
        this.f5344c = cVar;
    }

    public final void a(@j.c.a.d ViewHolder viewHolder, T t) {
        i0.f(viewHolder, "holder");
        this.f5344c.a(viewHolder, t, viewHolder.getAdapterPosition() - c());
    }

    public final void b(@j.c.a.d View view) {
        i0.f(view, "view");
        SparseArrayCompat<View> sparseArrayCompat = this.a;
        sparseArrayCompat.put(sparseArrayCompat.size() + f5340f, view);
    }

    protected final void a(@j.c.a.d ViewGroup viewGroup, @j.c.a.d ViewHolder viewHolder, int i2) {
        i0.f(viewGroup, "parent");
        i0.f(viewHolder, "viewHolder");
        if (a(i2)) {
            viewHolder.a().setOnClickListener(new e(viewHolder));
            viewHolder.a().setOnLongClickListener(new f(viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@j.c.a.d ViewHolder viewHolder, int i2) {
        i0.f(viewHolder, "holder");
        if (c(i2) || b(i2)) {
            return;
        }
        a(viewHolder, this.f5346e.get(i2 - c()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@j.c.a.d ViewHolder viewHolder) {
        i0.f(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (c(layoutPosition) || b(layoutPosition)) {
            WrapperUtils.a.a(viewHolder);
        }
    }

    public final void a(@j.c.a.d View view) {
        i0.f(view, "view");
        SparseArrayCompat<View> sparseArrayCompat = this.f5343b;
        sparseArrayCompat.put(sparseArrayCompat.size() + f5341g, view);
    }

    @j.c.a.d
    public final MultiItemTypeAdapter<T> a(@j.c.a.d com.lxj.easyadapter.b<T> bVar) {
        i0.f(bVar, "itemViewDelegate");
        this.f5344c.a(bVar);
        return this;
    }

    @j.c.a.d
    public final MultiItemTypeAdapter<T> a(int i2, @j.c.a.d com.lxj.easyadapter.b<T> bVar) {
        i0.f(bVar, "itemViewDelegate");
        this.f5344c.a(i2, bVar);
        return this;
    }
}
