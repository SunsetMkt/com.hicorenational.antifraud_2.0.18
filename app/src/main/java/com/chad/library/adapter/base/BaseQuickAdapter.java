package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.p142a.C1904a;
import com.chad.library.adapter.base.p142a.C1906c;
import com.chad.library.adapter.base.p142a.C1907d;
import com.chad.library.adapter.base.p142a.C1908e;
import com.chad.library.adapter.base.p142a.C1909f;
import com.chad.library.adapter.base.p142a.InterfaceC1905b;
import com.chad.library.adapter.base.p143b.InterfaceC1911b;
import com.chad.library.adapter.base.p144c.AbstractC1914a;
import com.chad.library.adapter.base.p144c.C1915b;
import com.chad.library.adapter.base.p145d.AbstractC1916a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {

    /* renamed from: L */
    public static final int f5536L = 1;

    /* renamed from: M */
    public static final int f5537M = 2;

    /* renamed from: N */
    public static final int f5538N = 3;

    /* renamed from: O */
    public static final int f5539O = 4;

    /* renamed from: P */
    public static final int f5540P = 5;

    /* renamed from: Q */
    protected static final String f5541Q = "BaseQuickAdapter";

    /* renamed from: R */
    public static final int f5542R = 273;

    /* renamed from: S */
    public static final int f5543S = 546;

    /* renamed from: T */
    public static final int f5544T = 819;

    /* renamed from: U */
    public static final int f5545U = 1365;

    /* renamed from: A */
    protected List<T> f5546A;

    /* renamed from: B */
    private RecyclerView f5547B;

    /* renamed from: C */
    private boolean f5548C;

    /* renamed from: D */
    private boolean f5549D;

    /* renamed from: E */
    private InterfaceC1901o f5550E;

    /* renamed from: F */
    private int f5551F;

    /* renamed from: G */
    private boolean f5552G;

    /* renamed from: H */
    private boolean f5553H;

    /* renamed from: I */
    private InterfaceC1900n f5554I;

    /* renamed from: J */
    private AbstractC1916a<T> f5555J;

    /* renamed from: K */
    private int f5556K;

    /* renamed from: a */
    private boolean f5557a;

    /* renamed from: b */
    private boolean f5558b;

    /* renamed from: c */
    private boolean f5559c;

    /* renamed from: d */
    private AbstractC1914a f5560d;

    /* renamed from: e */
    private InterfaceC1899m f5561e;

    /* renamed from: f */
    private boolean f5562f;

    /* renamed from: g */
    private InterfaceC1897k f5563g;

    /* renamed from: h */
    private InterfaceC1898l f5564h;

    /* renamed from: i */
    private InterfaceC1895i f5565i;

    /* renamed from: j */
    private InterfaceC1896j f5566j;

    /* renamed from: k */
    private boolean f5567k;

    /* renamed from: l */
    private boolean f5568l;

    /* renamed from: m */
    private Interpolator f5569m;

    /* renamed from: n */
    private int f5570n;

    /* renamed from: o */
    private int f5571o;

    /* renamed from: p */
    private InterfaceC1905b f5572p;

    /* renamed from: q */
    private InterfaceC1905b f5573q;

    /* renamed from: r */
    private LinearLayout f5574r;

    /* renamed from: s */
    private LinearLayout f5575s;

    /* renamed from: t */
    private FrameLayout f5576t;

    /* renamed from: u */
    private boolean f5577u;

    /* renamed from: v */
    private boolean f5578v;

    /* renamed from: w */
    private boolean f5579w;

    /* renamed from: x */
    protected Context f5580x;

    /* renamed from: y */
    protected int f5581y;

    /* renamed from: z */
    protected LayoutInflater f5582z;

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$a */
    class RunnableC1887a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LinearLayoutManager f5583a;

        RunnableC1887a(LinearLayoutManager linearLayoutManager) {
            this.f5583a = linearLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5583a.findLastCompletelyVisibleItemPosition() + 1 != BaseQuickAdapter.this.getItemCount()) {
                BaseQuickAdapter.this.m5148e(true);
            }
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$b */
    class RunnableC1888b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ StaggeredGridLayoutManager f5585a;

        RunnableC1888b(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f5585a = staggeredGridLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f5585a.getSpanCount()];
            this.f5585a.findLastCompletelyVisibleItemPositions(iArr);
            if (BaseQuickAdapter.this.m5063a(iArr) + 1 != BaseQuickAdapter.this.getItemCount()) {
                BaseQuickAdapter.this.m5148e(true);
            }
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$c */
    class ViewOnClickListenerC1889c implements View.OnClickListener {
        ViewOnClickListenerC1889c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseQuickAdapter.this.f5560d.m5257d() == 3) {
                BaseQuickAdapter.this.m5084C();
            }
            if (BaseQuickAdapter.this.f5562f && BaseQuickAdapter.this.f5560d.m5257d() == 4) {
                BaseQuickAdapter.this.m5084C();
            }
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$d */
    class C1890d extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a */
        final /* synthetic */ GridLayoutManager f5588a;

        C1890d(GridLayoutManager gridLayoutManager) {
            this.f5588a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            int itemViewType = BaseQuickAdapter.this.getItemViewType(i2);
            if (itemViewType == 273 && BaseQuickAdapter.this.m5179u()) {
                return 1;
            }
            if (itemViewType == 819 && BaseQuickAdapter.this.m5178t()) {
                return 1;
            }
            if (BaseQuickAdapter.this.f5554I != null) {
                return BaseQuickAdapter.this.mo5143d(itemViewType) ? this.f5588a.getSpanCount() : BaseQuickAdapter.this.f5554I.m5188a(this.f5588a, i2 - BaseQuickAdapter.this.m5164j());
            }
            if (BaseQuickAdapter.this.mo5143d(itemViewType)) {
                return this.f5588a.getSpanCount();
            }
            return 1;
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$e */
    class ViewOnClickListenerC1891e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f5590a;

        ViewOnClickListenerC1891e(BaseViewHolder baseViewHolder) {
            this.f5590a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseQuickAdapter.this.m5147e(view, this.f5590a.getLayoutPosition() - BaseQuickAdapter.this.m5164j());
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$f */
    class ViewOnLongClickListenerC1892f implements View.OnLongClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f5592a;

        ViewOnLongClickListenerC1892f(BaseViewHolder baseViewHolder) {
            this.f5592a = baseViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return BaseQuickAdapter.this.m5152f(view, this.f5592a.getLayoutPosition() - BaseQuickAdapter.this.m5164j());
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$g */
    class RunnableC1893g implements Runnable {
        RunnableC1893g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseQuickAdapter.this.f5561e.m5187a();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$h */
    public @interface InterfaceC1894h {
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$i */
    public interface InterfaceC1895i {
        void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$j */
    public interface InterfaceC1896j {
        /* renamed from: a */
        boolean m5185a(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$k */
    public interface InterfaceC1897k {
        void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$l */
    public interface InterfaceC1898l {
        /* renamed from: a */
        boolean m5186a(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$m */
    public interface InterfaceC1899m {
        /* renamed from: a */
        void m5187a();
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$n */
    public interface InterfaceC1900n {
        /* renamed from: a */
        int m5188a(GridLayoutManager gridLayoutManager, int i2);
    }

    /* renamed from: com.chad.library.adapter.base.BaseQuickAdapter$o */
    public interface InterfaceC1901o {
        /* renamed from: a */
        void m5189a();
    }

    public BaseQuickAdapter(@LayoutRes int i2, @Nullable List<T> list) {
        this.f5557a = false;
        this.f5558b = false;
        this.f5559c = false;
        this.f5560d = new C1915b();
        this.f5562f = false;
        this.f5567k = true;
        this.f5568l = false;
        this.f5569m = new LinearInterpolator();
        this.f5570n = 300;
        this.f5571o = -1;
        this.f5573q = new C1904a();
        this.f5577u = true;
        this.f5551F = 1;
        this.f5556K = 1;
        this.f5546A = list == null ? new ArrayList<>() : list;
        if (i2 != 0) {
            this.f5581y = i2;
        }
    }

    /* renamed from: G */
    private void m5058G() {
        if (m5177s() == null) {
            throw new RuntimeException("please bind recyclerView first!");
        }
    }

    /* renamed from: H */
    private int m5059H() {
        int i2 = 1;
        if (m5144e() != 1) {
            return m5164j() + this.f5546A.size();
        }
        if (this.f5578v && m5164j() != 0) {
            i2 = 2;
        }
        if (this.f5579w) {
            return i2;
        }
        return -1;
    }

    /* renamed from: I */
    private int m5060I() {
        return (m5144e() != 1 || this.f5578v) ? 0 : -1;
    }

    /* renamed from: n */
    private void m5078n(int i2) {
        InterfaceC1901o interfaceC1901o;
        if (!m5182x() || m5183y() || i2 > this.f5551F || (interfaceC1901o = this.f5550E) == null) {
            return;
        }
        interfaceC1901o.m5189a();
    }

    /* renamed from: o */
    private void m5079o(int i2) {
        List<T> list = this.f5546A;
        if ((list == null ? 0 : list.size()) == i2) {
            notifyDataSetChanged();
        }
    }

    /* renamed from: p */
    private InterfaceC1911b m5080p(int i2) {
        T item = getItem(i2);
        if (m5137c((BaseQuickAdapter<T, K>) item)) {
            return (InterfaceC1911b) item;
        }
        return null;
    }

    /* renamed from: q */
    private int m5081q(@IntRange(from = 0) int i2) {
        T item = getItem(i2);
        int i3 = 0;
        if (!m5137c((BaseQuickAdapter<T, K>) item)) {
            return 0;
        }
        InterfaceC1911b interfaceC1911b = (InterfaceC1911b) item;
        if (interfaceC1911b.isExpanded()) {
            List<T> mo5237a = interfaceC1911b.mo5237a();
            if (mo5237a == null) {
                return 0;
            }
            for (int size = mo5237a.size() - 1; size >= 0; size--) {
                T t = mo5237a.get(size);
                int m5075d = m5075d((BaseQuickAdapter<T, K>) t);
                if (m5075d >= 0) {
                    if (t instanceof InterfaceC1911b) {
                        i3 += m5081q(m5075d);
                    }
                    this.f5546A.remove(m5075d);
                    i3++;
                }
            }
        }
        return i3;
    }

    /* renamed from: A */
    public void m5082A() {
        m5142d(false);
    }

    /* renamed from: B */
    public void m5083B() {
        if (m5169l() == 0) {
            return;
        }
        this.f5559c = false;
        this.f5560d.m5252a(3);
        notifyItemChanged(m5171m());
    }

    /* renamed from: C */
    public void m5084C() {
        if (this.f5560d.m5257d() == 2) {
            return;
        }
        this.f5560d.m5252a(1);
        notifyItemChanged(m5171m());
    }

    /* renamed from: D */
    public void m5085D() {
        this.f5568l = true;
    }

    /* renamed from: E */
    public void m5086E() {
        if (m5153g() == 0) {
            return;
        }
        this.f5575s.removeAllViews();
        int m5059H = m5059H();
        if (m5059H != -1) {
            notifyItemRemoved(m5059H);
        }
    }

    /* renamed from: F */
    public void m5087F() {
        if (m5164j() == 0) {
            return;
        }
        this.f5574r.removeAllViews();
        int m5060I = m5060I();
        if (m5060I != -1) {
            notifyItemRemoved(m5060I);
        }
    }

    /* renamed from: a */
    protected abstract void mo204a(K k2, T t);

    /* renamed from: d */
    protected boolean mo5143d(int i2) {
        return i2 == 1365 || i2 == 273 || i2 == 819 || i2 == 546;
    }

    /* renamed from: e */
    public void m5148e(boolean z) {
        int m5169l = m5169l();
        this.f5558b = z;
        int m5169l2 = m5169l();
        if (m5169l == 1) {
            if (m5169l2 == 0) {
                notifyItemRemoved(m5171m());
            }
        } else if (m5169l2 == 1) {
            this.f5560d.m5252a(1);
            notifyItemInserted(m5171m());
        }
    }

    /* renamed from: f */
    public void mo5056f(@IntRange(from = 0) int i2) {
        this.f5546A.remove(i2);
        int m5164j = i2 + m5164j();
        notifyItemRemoved(m5164j);
        m5079o(0);
        notifyItemRangeChanged(m5164j, this.f5546A.size() - m5164j);
    }

    /* renamed from: g */
    public int m5153g() {
        LinearLayout linearLayout = this.f5575s;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Nullable
    public T getItem(@IntRange(from = 0) int i2) {
        if (i2 < this.f5546A.size()) {
            return this.f5546A.get(i2);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i2 = 1;
        if (m5144e() != 1) {
            return m5169l() + m5164j() + this.f5546A.size() + m5153g();
        }
        if (this.f5578v && m5164j() != 0) {
            i2 = 2;
        }
        return (!this.f5579w || m5153g() == 0) ? i2 : i2 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (m5144e() == 1) {
            boolean z = this.f5578v && m5164j() != 0;
            if (i2 != 0) {
                return i2 != 1 ? i2 != 2 ? f5545U : f5544T : z ? f5545U : f5544T;
            }
            if (z) {
                return 273;
            }
            return f5545U;
        }
        int m5164j = m5164j();
        if (i2 < m5164j) {
            return 273;
        }
        int i3 = i2 - m5164j;
        int size = this.f5546A.size();
        return i3 < size ? mo5055c(i3) : i3 - size < m5153g() ? f5544T : f5543S;
    }

    /* renamed from: h */
    public void m5159h(int i2) {
        this.f5570n = i2;
    }

    /* renamed from: i */
    public void m5163i(boolean z) {
        this.f5548C = z;
    }

    /* renamed from: j */
    public void m5166j(boolean z) {
        this.f5549D = z;
    }

    @Deprecated
    /* renamed from: k */
    public int m5167k() {
        return m5164j();
    }

    /* renamed from: l */
    public void m5170l(int i2) {
        this.f5551F = i2;
    }

    /* renamed from: m */
    public int m5171m() {
        return m5164j() + this.f5546A.size() + m5153g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new C1890d(gridLayoutManager));
        }
    }

    /* renamed from: r */
    public final InterfaceC1898l m5176r() {
        return this.f5564h;
    }

    /* renamed from: s */
    protected RecyclerView m5177s() {
        return this.f5547B;
    }

    public void setNewData(@Nullable List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f5546A = list;
        if (this.f5561e != null) {
            this.f5557a = true;
            this.f5558b = true;
            this.f5559c = false;
            this.f5560d.m5252a(1);
        }
        this.f5571o = -1;
        notifyDataSetChanged();
    }

    public void setOnItemChildClickListener(InterfaceC1895i interfaceC1895i) {
        this.f5565i = interfaceC1895i;
    }

    public void setOnItemChildLongClickListener(InterfaceC1896j interfaceC1896j) {
        this.f5566j = interfaceC1896j;
    }

    public void setOnItemClickListener(@Nullable InterfaceC1897k interfaceC1897k) {
        this.f5563g = interfaceC1897k;
    }

    public void setOnItemLongClickListener(InterfaceC1898l interfaceC1898l) {
        this.f5564h = interfaceC1898l;
    }

    /* renamed from: t */
    public boolean m5178t() {
        return this.f5553H;
    }

    /* renamed from: u */
    public boolean m5179u() {
        return this.f5552G;
    }

    /* renamed from: v */
    public boolean m5180v() {
        return this.f5558b;
    }

    /* renamed from: w */
    public boolean m5181w() {
        return this.f5559c;
    }

    /* renamed from: x */
    public boolean m5182x() {
        return this.f5548C;
    }

    /* renamed from: y */
    public boolean m5183y() {
        return this.f5549D;
    }

    /* renamed from: z */
    public void m5184z() {
        if (m5169l() == 0) {
            return;
        }
        this.f5559c = false;
        this.f5557a = true;
        this.f5560d.m5252a(1);
        notifyItemChanged(m5171m());
    }

    /* renamed from: b */
    private void m5070b(InterfaceC1899m interfaceC1899m) {
        this.f5561e = interfaceC1899m;
        this.f5557a = true;
        this.f5558b = true;
        this.f5559c = false;
    }

    /* renamed from: c */
    private void m5074c(RecyclerView recyclerView) {
        this.f5547B = recyclerView;
    }

    /* renamed from: m */
    private void m5077m(int i2) {
        if (m5169l() != 0 && i2 >= getItemCount() - this.f5556K && this.f5560d.m5257d() == 1) {
            this.f5560d.m5252a(2);
            if (this.f5559c) {
                return;
            }
            this.f5559c = true;
            if (m5177s() != null) {
                m5177s().post(new RunnableC1893g());
            } else {
                this.f5561e.m5187a();
            }
        }
    }

    /* renamed from: d */
    public void m5142d(boolean z) {
        if (m5169l() == 0) {
            return;
        }
        this.f5559c = false;
        this.f5557a = false;
        this.f5560d.m5254a(z);
        if (z) {
            notifyItemRemoved(m5171m());
        } else {
            this.f5560d.m5252a(4);
            notifyItemChanged(m5171m());
        }
    }

    /* renamed from: g */
    public int m5154g(View view) {
        return m5132c(view, 0, 1);
    }

    @Deprecated
    /* renamed from: h */
    public int m5157h() {
        return m5153g();
    }

    /* renamed from: i */
    public LinearLayout m5161i() {
        return this.f5574r;
    }

    /* renamed from: j */
    public void m5165j(int i2) {
        this.f5571o = i2;
    }

    /* renamed from: k */
    public void m5168k(int i2) {
        if (i2 > 1) {
            this.f5556K = i2;
        }
    }

    /* renamed from: l */
    public int m5169l() {
        if (this.f5561e == null || !this.f5558b) {
            return 0;
        }
        return ((this.f5557a || !this.f5560d.m5260g()) && this.f5546A.size() != 0) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(ViewGroup viewGroup, int i2) {
        K m5133c;
        this.f5580x = viewGroup.getContext();
        this.f5582z = LayoutInflater.from(this.f5580x);
        if (i2 == 273) {
            m5133c = m5133c((View) this.f5574r);
        } else if (i2 == 546) {
            m5133c = m5064a(viewGroup);
        } else if (i2 == 819) {
            m5133c = m5133c((View) this.f5575s);
        } else if (i2 != 1365) {
            m5133c = mo5053b(viewGroup, i2);
            m5071b((BaseViewHolder) m5133c);
        } else {
            m5133c = m5133c((View) this.f5576t);
        }
        m5133c.m5215a(this);
        return m5133c;
    }

    /* renamed from: a */
    public void m5103a(RecyclerView recyclerView) {
        if (m5177s() == null) {
            m5074c(recyclerView);
            m5177s().setAdapter(this);
            return;
        }
        throw new RuntimeException("Don't bind twice");
    }

    /* renamed from: c */
    public void m5135c(@IntRange(from = 0) int i2, @NonNull T t) {
        this.f5546A.set(i2, t);
        notifyItemChanged(i2 + m5164j());
    }

    /* renamed from: g */
    public void m5156g(boolean z) {
        m5115a(z, false);
    }

    /* renamed from: h */
    public void m5160h(boolean z) {
        this.f5552G = z;
    }

    /* renamed from: i */
    public void m5162i(int i2) {
        m5058G();
        m5124b(i2, (ViewGroup) m5177s());
    }

    /* renamed from: j */
    public int m5164j() {
        LinearLayout linearLayout = this.f5574r;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Nullable
    /* renamed from: o */
    public final InterfaceC1895i m5173o() {
        return this.f5565i;
    }

    @Deprecated
    /* renamed from: g */
    public void m5155g(int i2) {
        m5168k(i2);
    }

    /* renamed from: h */
    public int m5158h(View view) {
        return m5139d(view, 0, 1);
    }

    /* renamed from: n */
    public AbstractC1916a<T> m5172n() {
        return this.f5555J;
    }

    @Nullable
    /* renamed from: p */
    public final InterfaceC1896j m5174p() {
        return this.f5566j;
    }

    @NonNull
    /* renamed from: c */
    public List<T> m5134c() {
        return this.f5546A;
    }

    /* renamed from: b */
    public void m5126b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        m5148e(false);
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.postDelayed(new RunnableC1887a((LinearLayoutManager) layoutManager), 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            recyclerView.postDelayed(new RunnableC1888b((StaggeredGridLayoutManager) layoutManager), 50L);
        }
    }

    /* renamed from: c */
    protected int mo5055c(int i2) {
        AbstractC1916a<T> abstractC1916a = this.f5555J;
        if (abstractC1916a != null) {
            return abstractC1916a.m5270a(this.f5546A, i2);
        }
        return super.getItemViewType(i2);
    }

    /* renamed from: f */
    public void m5151f(boolean z) {
        this.f5553H = z;
    }

    @Deprecated
    /* renamed from: a */
    public void m5104a(InterfaceC1899m interfaceC1899m) {
        m5070b(interfaceC1899m);
    }

    /* renamed from: e */
    public int m5144e() {
        FrameLayout frameLayout = this.f5576t;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.f5577u || this.f5546A.size() != 0) ? 0 : 1;
    }

    /* renamed from: f */
    public boolean m5152f(View view, int i2) {
        return m5176r().m5186a(this, view, i2);
    }

    /* renamed from: a */
    public void m5105a(InterfaceC1899m interfaceC1899m, RecyclerView recyclerView) {
        m5070b(interfaceC1899m);
        if (m5177s() == null) {
            m5074c(recyclerView);
        }
    }

    /* renamed from: f */
    public LinearLayout m5149f() {
        return this.f5575s;
    }

    /* renamed from: c */
    protected K m5133c(View view) {
        K m5065a;
        Class cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = m5067a((Class) cls2);
        }
        if (cls == null) {
            m5065a = (K) new BaseViewHolder(view);
        } else {
            m5065a = m5065a(cls, view);
        }
        return m5065a != null ? m5065a : (K) new BaseViewHolder(view);
    }

    /* renamed from: d */
    public int m5138d(View view, int i2) {
        return m5139d(view, i2, 1);
    }

    /* renamed from: f */
    public void m5150f(View view) {
        boolean z;
        int i2 = 0;
        if (this.f5576t == null) {
            this.f5576t = new FrameLayout(view.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = layoutParams2.width;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = layoutParams2.height;
            }
            this.f5576t.setLayoutParams(layoutParams);
            z = true;
        } else {
            z = false;
        }
        this.f5576t.removeAllViews();
        this.f5576t.addView(view);
        this.f5577u = true;
        if (z && m5144e() == 1) {
            if (this.f5578v && m5164j() != 0) {
                i2 = 1;
            }
            notifyItemInserted(i2);
        }
    }

    /* renamed from: d */
    public int m5139d(View view, int i2, int i3) {
        LinearLayout linearLayout = this.f5574r;
        if (linearLayout != null && linearLayout.getChildCount() > i2) {
            this.f5574r.removeViewAt(i2);
            this.f5574r.addView(view, i2);
            return i2;
        }
        return m5121b(view, i2, i3);
    }

    /* renamed from: e */
    public void m5147e(View view, int i2) {
        m5175q().onItemClick(this, view, i2);
    }

    /* renamed from: a */
    public void m5098a() {
        m5058G();
        m5126b(m5177s());
    }

    /* renamed from: e */
    public void m5146e(View view) {
        int m5060I;
        if (m5164j() == 0) {
            return;
        }
        this.f5574r.removeView(view);
        if (this.f5574r.getChildCount() != 0 || (m5060I = m5060I()) == -1) {
            return;
        }
        notifyItemRemoved(m5060I);
    }

    /* renamed from: q */
    public final InterfaceC1897k m5175q() {
        return this.f5563g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m5063a(int[] iArr) {
        int i2 = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    /* renamed from: b */
    public void m5125b(@IntRange(from = 0) int i2, @NonNull T t) {
        this.f5546A.add(i2, t);
        notifyItemInserted(i2 + m5164j());
        m5079o(1);
    }

    /* renamed from: d */
    public void m5141d(View view) {
        int m5059H;
        if (m5153g() == 0) {
            return;
        }
        this.f5575s.removeView(view);
        if (this.f5575s.getChildCount() != 0 || (m5059H = m5059H()) == -1) {
            return;
        }
        notifyItemRemoved(m5059H);
    }

    /* renamed from: a */
    public void m5107a(InterfaceC1901o interfaceC1901o) {
        this.f5550E = interfaceC1901o;
    }

    /* renamed from: c */
    public int m5131c(View view, int i2) {
        return m5132c(view, i2, 1);
    }

    /* renamed from: a */
    public void m5110a(AbstractC1914a abstractC1914a) {
        this.f5560d = abstractC1914a;
    }

    /* renamed from: c */
    public int m5132c(View view, int i2, int i3) {
        LinearLayout linearLayout = this.f5575s;
        if (linearLayout != null && linearLayout.getChildCount() > i2) {
            this.f5575s.removeViewAt(i2);
            this.f5575s.addView(view, i2);
            return i2;
        }
        return m5093a(view, i2, i3);
    }

    /* renamed from: e */
    public void m5145e(int i2) {
        this.f5568l = true;
        this.f5572p = null;
        if (i2 == 1) {
            this.f5573q = new C1904a();
            return;
        }
        if (i2 == 2) {
            this.f5573q = new C1906c();
            return;
        }
        if (i2 == 3) {
            this.f5573q = new C1907d();
        } else if (i2 == 4) {
            this.f5573q = new C1908e();
        } else {
            if (i2 != 5) {
                return;
            }
            this.f5573q = new C1909f();
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m5099a(@IntRange(from = 0) int i2, @NonNull T t) {
        m5125b(i2, (int) t);
    }

    /* renamed from: b */
    public void m5127b(@NonNull Collection<? extends T> collection) {
        List<T> list = this.f5546A;
        if (collection != list) {
            list.clear();
            this.f5546A.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public BaseQuickAdapter(@Nullable List<T> list) {
        this(0, list);
    }

    /* renamed from: a */
    public void m5112a(@NonNull T t) {
        this.f5546A.add(t);
        notifyItemInserted(this.f5546A.size() + m5164j());
        m5079o(1);
    }

    public BaseQuickAdapter(@LayoutRes int i2) {
        this(i2, null);
    }

    /* renamed from: d */
    public View m5140d() {
        return this.f5576t;
    }

    /* renamed from: d */
    private int m5075d(T t) {
        List<T> list;
        if (t == null || (list = this.f5546A) == null || list.isEmpty()) {
            return -1;
        }
        return this.f5546A.indexOf(t);
    }

    /* renamed from: c */
    public void m5136c(boolean z) {
        this.f5577u = z;
    }

    /* renamed from: b */
    private void m5071b(BaseViewHolder baseViewHolder) {
        View view;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        if (m5175q() != null) {
            view.setOnClickListener(new ViewOnClickListenerC1891e(baseViewHolder));
        }
        if (m5176r() != null) {
            view.setOnLongClickListener(new ViewOnLongClickListenerC1892f(baseViewHolder));
        }
    }

    /* renamed from: a */
    public void m5100a(@IntRange(from = 0) int i2, @NonNull Collection<? extends T> collection) {
        this.f5546A.addAll(i2, collection);
        notifyItemRangeInserted(i2 + m5164j(), collection.size());
        m5079o(collection.size());
    }

    /* renamed from: c */
    public int m5130c(int i2, boolean z, boolean z2) {
        T item;
        int m5164j = i2 - m5164j();
        int i3 = m5164j + 1;
        T item2 = i3 < this.f5546A.size() ? getItem(i3) : null;
        InterfaceC1911b m5080p = m5080p(m5164j);
        if (m5080p == null) {
            return 0;
        }
        if (!m5068a(m5080p)) {
            m5080p.setExpanded(true);
            notifyItemChanged(m5164j);
            return 0;
        }
        int m5118b = m5118b(m5164j() + m5164j, false, false);
        while (i3 < this.f5546A.size() && (item = getItem(i3)) != item2) {
            if (m5137c((BaseQuickAdapter<T, K>) item)) {
                m5118b += m5118b(m5164j() + i3, false, false);
            }
            i3++;
        }
        if (z2) {
            if (z) {
                notifyItemRangeInserted(m5164j + m5164j() + 1, m5118b);
            } else {
                notifyDataSetChanged();
            }
        }
        return m5118b;
    }

    /* renamed from: a */
    public void m5113a(@NonNull Collection<? extends T> collection) {
        this.f5546A.addAll(collection);
        notifyItemRangeInserted((this.f5546A.size() - collection.size()) + m5164j(), collection.size());
        m5079o(collection.size());
    }

    /* renamed from: b */
    protected K mo5053b(ViewGroup viewGroup, int i2) {
        int i3 = this.f5581y;
        AbstractC1916a<T> abstractC1916a = this.f5555J;
        if (abstractC1916a != null) {
            i3 = abstractC1916a.m5268a(i2);
        }
        return m5097a(viewGroup, i3);
    }

    /* renamed from: a */
    private K m5064a(ViewGroup viewGroup) {
        K m5133c = m5133c(m5095a(this.f5560d.mo5251a(), viewGroup));
        m5133c.itemView.setOnClickListener(new ViewOnClickListenerC1889c());
        return m5133c;
    }

    /* renamed from: a */
    public void m5114a(boolean z) {
        this.f5562f = z;
    }

    /* renamed from: b */
    public int m5119b(View view) {
        return m5120b(view, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(K k2) {
        super.onViewAttachedToWindow(k2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType != 1365 && itemViewType != 273 && itemViewType != 819 && itemViewType != 546) {
            m5069b((RecyclerView.ViewHolder) k2);
        } else {
            m5102a((RecyclerView.ViewHolder) k2);
        }
    }

    /* renamed from: b */
    public int m5120b(View view, int i2) {
        return m5121b(view, i2, 1);
    }

    /* renamed from: b */
    public int m5121b(View view, int i2, int i3) {
        int m5060I;
        if (this.f5574r == null) {
            this.f5574r = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.f5574r.setOrientation(1);
                this.f5574r.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.f5574r.setOrientation(0);
                this.f5574r.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.f5574r.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.f5574r.addView(view, i2);
        if (this.f5574r.getChildCount() == 1 && (m5060I = m5060I()) != -1) {
            notifyItemInserted(m5060I);
        }
        return i2;
    }

    /* renamed from: a */
    protected void m5102a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }

    /* renamed from: c */
    public int m5129c(int i2, boolean z) {
        return m5130c(i2, true, !z);
    }

    /* renamed from: c */
    public boolean m5137c(T t) {
        return t != null && (t instanceof InterfaceC1911b);
    }

    /* renamed from: a */
    public void m5106a(InterfaceC1900n interfaceC1900n) {
        this.f5554I = interfaceC1900n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(K k2, int i2) {
        m5078n(i2);
        m5077m(i2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType == 0) {
            mo204a((BaseQuickAdapter<T, K>) k2, (K) getItem(i2 - m5164j()));
            return;
        }
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.f5560d.m5253a(k2);
            } else {
                if (itemViewType == 819 || itemViewType == 1365) {
                    return;
                }
                mo204a((BaseQuickAdapter<T, K>) k2, (K) getItem(i2 - m5164j()));
            }
        }
    }

    /* renamed from: b */
    public void m5124b(int i2, ViewGroup viewGroup) {
        m5150f(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    /* renamed from: b */
    private void m5069b(RecyclerView.ViewHolder viewHolder) {
        if (this.f5568l) {
            if (!this.f5567k || viewHolder.getLayoutPosition() > this.f5571o) {
                InterfaceC1905b interfaceC1905b = this.f5572p;
                if (interfaceC1905b == null) {
                    interfaceC1905b = this.f5573q;
                }
                for (Animator animator : interfaceC1905b.mo5235a(viewHolder.itemView)) {
                    m5101a(animator, viewHolder.getLayoutPosition());
                }
                this.f5571o = viewHolder.getLayoutPosition();
            }
        }
    }

    /* renamed from: a */
    public void m5111a(AbstractC1916a<T> abstractC1916a) {
        this.f5555J = abstractC1916a;
    }

    /* renamed from: a */
    protected K m5097a(ViewGroup viewGroup, int i2) {
        return m5133c(m5095a(i2, viewGroup));
    }

    /* renamed from: a */
    private K m5065a(Class cls, View view) {
        try {
            if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(getClass(), View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(this, view);
            }
            Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(view);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void m5128b(boolean z) {
        this.f5567k = z;
    }

    /* renamed from: b */
    public int m5118b(@IntRange(from = 0) int i2, boolean z, boolean z2) {
        int m5164j = i2 - m5164j();
        InterfaceC1911b m5080p = m5080p(m5164j);
        int i3 = 0;
        if (m5080p == null) {
            return 0;
        }
        if (!m5068a(m5080p)) {
            m5080p.setExpanded(true);
            notifyItemChanged(m5164j);
            return 0;
        }
        if (!m5080p.isExpanded()) {
            List<T> mo5237a = m5080p.mo5237a();
            int i4 = m5164j + 1;
            this.f5546A.addAll(i4, mo5237a);
            i3 = 0 + m5061a(i4, (List) mo5237a);
            m5080p.setExpanded(true);
        }
        int m5164j2 = m5164j + m5164j();
        if (z2) {
            if (z) {
                notifyItemChanged(m5164j2);
                notifyItemRangeInserted(m5164j2 + 1, i3);
            } else {
                notifyDataSetChanged();
            }
        }
        return i3;
    }

    /* renamed from: a */
    private Class m5067a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (BaseViewHolder.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    Class cls3 = (Class) rawType;
                    if (BaseViewHolder.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int m5117b(@IntRange(from = 0) int i2, boolean z) {
        return m5118b(i2, z, true);
    }

    /* renamed from: b */
    public int m5116b(@IntRange(from = 0) int i2) {
        return m5118b(i2, true, true);
    }

    /* renamed from: a */
    public int m5091a(View view) {
        return m5093a(view, -1, 1);
    }

    /* renamed from: b */
    public void m5123b() {
        for (int size = (this.f5546A.size() - 1) + m5164j(); size >= m5164j(); size--) {
            m5130c(size, false, false);
        }
    }

    /* renamed from: a */
    public int m5092a(View view, int i2) {
        return m5093a(view, i2, 1);
    }

    /* renamed from: a */
    public int m5093a(View view, int i2, int i3) {
        int m5059H;
        if (this.f5575s == null) {
            this.f5575s = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.f5575s.setOrientation(1);
                this.f5575s.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.f5575s.setOrientation(0);
                this.f5575s.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.f5575s.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.f5575s.addView(view, i2);
        if (this.f5575s.getChildCount() == 1 && (m5059H = m5059H()) != -1) {
            notifyItemInserted(m5059H);
        }
        return i2;
    }

    /* renamed from: b */
    public int m5122b(@NonNull T t) {
        int m5075d = m5075d((BaseQuickAdapter<T, K>) t);
        if (m5075d == -1) {
            return -1;
        }
        int m5246b = t instanceof InterfaceC1911b ? ((InterfaceC1911b) t).m5246b() : Integer.MAX_VALUE;
        if (m5246b == 0) {
            return m5075d;
        }
        if (m5246b == -1) {
            return -1;
        }
        while (m5075d >= 0) {
            T t2 = this.f5546A.get(m5075d);
            if (t2 instanceof InterfaceC1911b) {
                InterfaceC1911b interfaceC1911b = (InterfaceC1911b) t2;
                if (interfaceC1911b.m5246b() >= 0 && interfaceC1911b.m5246b() < m5246b) {
                    return m5075d;
                }
            }
            m5075d--;
        }
        return -1;
    }

    /* renamed from: a */
    public void m5115a(boolean z, boolean z2) {
        this.f5578v = z;
        this.f5579w = z2;
    }

    /* renamed from: a */
    protected void m5101a(Animator animator, int i2) {
        animator.setDuration(this.f5570n).start();
        animator.setInterpolator(this.f5569m);
    }

    /* renamed from: a */
    protected View m5095a(@LayoutRes int i2, ViewGroup viewGroup) {
        return this.f5582z.inflate(i2, viewGroup, false);
    }

    /* renamed from: a */
    public void m5109a(InterfaceC1905b interfaceC1905b) {
        this.f5568l = true;
        this.f5572p = interfaceC1905b;
    }

    @Nullable
    /* renamed from: a */
    public View m5094a(int i2, @IdRes int i3) {
        m5058G();
        return m5096a(m5177s(), i2, i3);
    }

    @Nullable
    /* renamed from: a */
    public View m5096a(RecyclerView recyclerView, int i2, @IdRes int i3) {
        BaseViewHolder baseViewHolder;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i2)) == null) {
            return null;
        }
        return baseViewHolder.m5224c(i3);
    }

    /* renamed from: a */
    private int m5061a(int i2, @NonNull List list) {
        int size = list.size();
        int size2 = (i2 + list.size()) - 1;
        int size3 = list.size() - 1;
        while (size3 >= 0) {
            if (list.get(size3) instanceof InterfaceC1911b) {
                InterfaceC1911b interfaceC1911b = (InterfaceC1911b) list.get(size3);
                if (interfaceC1911b.isExpanded() && m5068a(interfaceC1911b)) {
                    List<T> mo5237a = interfaceC1911b.mo5237a();
                    int i3 = size2 + 1;
                    this.f5546A.addAll(i3, mo5237a);
                    size += m5061a(i3, (List) mo5237a);
                }
            }
            size3--;
            size2--;
        }
        return size;
    }

    /* renamed from: a */
    public int m5090a(@IntRange(from = 0) int i2, boolean z, boolean z2) {
        int m5164j = i2 - m5164j();
        InterfaceC1911b m5080p = m5080p(m5164j);
        if (m5080p == null) {
            return 0;
        }
        int m5081q = m5081q(m5164j);
        m5080p.setExpanded(false);
        int m5164j2 = m5164j + m5164j();
        if (z2) {
            if (z) {
                notifyItemChanged(m5164j2);
                notifyItemRangeRemoved(m5164j2 + 1, m5081q);
            } else {
                notifyDataSetChanged();
            }
        }
        return m5081q;
    }

    /* renamed from: a */
    public int m5088a(@IntRange(from = 0) int i2) {
        return m5090a(i2, true, true);
    }

    /* renamed from: a */
    public int m5089a(@IntRange(from = 0) int i2, boolean z) {
        return m5090a(i2, z, true);
    }

    /* renamed from: a */
    private boolean m5068a(InterfaceC1911b interfaceC1911b) {
        List<T> mo5237a;
        return (interfaceC1911b == null || (mo5237a = interfaceC1911b.mo5237a()) == null || mo5237a.size() <= 0) ? false : true;
    }
}
