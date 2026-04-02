package ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageRecyclerView extends RecyclerView {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PageAdapter f14775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f14777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PageIndicatorView f14785l;

    public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f14786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14787c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14788d;

        public PageAdapter(List<?> list, a aVar) {
            this.a = null;
            this.f14786b = null;
            this.f14788d = 0;
            this.a = list;
            this.f14786b = aVar;
            this.f14788d = this.a.size() + (PageRecyclerView.this.f14780g * PageRecyclerView.this.f14781h);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f14788d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (PageRecyclerView.this.f14781h == 1) {
                viewHolder.itemView.getLayoutParams().width = this.f14787c + PageRecyclerView.this.f14784k;
                viewHolder.itemView.setPadding(PageRecyclerView.this.f14784k, 0, 0, 0);
            } else {
                int i3 = i2 % (PageRecyclerView.this.f14780g * PageRecyclerView.this.f14781h);
                if (i3 < PageRecyclerView.this.f14780g) {
                    viewHolder.itemView.getLayoutParams().width = this.f14787c + PageRecyclerView.this.f14784k;
                    viewHolder.itemView.setPadding(PageRecyclerView.this.f14784k, 0, 0, 0);
                } else if (i3 >= (PageRecyclerView.this.f14780g * PageRecyclerView.this.f14781h) - PageRecyclerView.this.f14780g) {
                    viewHolder.itemView.getLayoutParams().width = this.f14787c + PageRecyclerView.this.f14784k;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                } else {
                    viewHolder.itemView.getLayoutParams().width = this.f14787c;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                }
            }
            if (i2 >= this.a.size()) {
                viewHolder.itemView.setVisibility(4);
            } else {
                viewHolder.itemView.setVisibility(0);
                this.f14786b.a(viewHolder, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (this.f14787c <= 0) {
                this.f14787c = (viewGroup.getWidth() - PageRecyclerView.this.f14784k) / PageRecyclerView.this.f14781h;
            }
            RecyclerView.ViewHolder viewHolderA = this.f14786b.a(viewGroup, i2);
            viewHolderA.itemView.measure(0, 0);
            viewHolderA.itemView.getLayoutParams().width = this.f14787c;
            viewHolderA.itemView.getLayoutParams().height = viewHolderA.itemView.getMeasuredHeight();
            return viewHolderA;
        }

        public void a(List<?> list) {
            this.a = list;
            this.f14788d = this.a.size() + (PageRecyclerView.this.f14780g * PageRecyclerView.this.f14781h);
            notifyDataSetChanged();
            PageRecyclerView.this.a();
        }
    }

    public interface a {
        RecyclerView.ViewHolder a(ViewGroup viewGroup, int i2);

        void a(RecyclerView.ViewHolder viewHolder, int i2);
    }

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        PageAdapter pageAdapter = this.f14775b;
        if (pageAdapter != null && pageAdapter.a != null && this.f14775b.a.size() == 0) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14777d = motionEvent.getX();
        } else {
            if (action == 1) {
                this.f14778e = motionEvent.getX() - this.f14777d;
                if (Math.abs(this.f14778e) > this.f14776c) {
                    if (this.f14778e > 0.0f) {
                        int i2 = this.f14783j;
                        this.f14783j = i2 == 1 ? 1 : i2 - 1;
                    } else {
                        int i3 = this.f14783j;
                        int i4 = this.f14782i;
                        if (i3 != i4) {
                            i4 = i3 + 1;
                        }
                        this.f14783j = i4;
                    }
                    PageIndicatorView pageIndicatorView = this.f14785l;
                    if (pageIndicatorView != null) {
                        pageIndicatorView.setSelectedPage(this.f14783j - 1);
                    }
                }
                smoothScrollBy((int) (((this.f14783j - 1) * getWidth()) - this.f14779f), 0);
                return true;
            }
            if (action == 2 && this.f14783j == this.f14782i && this.f14777d - motionEvent.getX() > 0.0f) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i2, int i3) {
        this.f14779f += i2;
        super.onScrolled(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter2) {
        super.setAdapter(adapter2);
        this.f14775b = (PageAdapter) adapter2;
        a();
    }

    public void setIndicator(PageIndicatorView pageIndicatorView) {
        this.f14785l = pageIndicatorView;
    }

    public void setPageMargin(int i2) {
        this.f14784k = i2;
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.a = context;
        setLayoutManager(new GridLayoutManager(this.a, this.f14780g, 0, false));
        setOverScrollMode(2);
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.f14775b = null;
        this.f14776c = 100;
        this.f14777d = 0.0f;
        this.f14778e = 0.0f;
        this.f14779f = 0.0f;
        this.f14780g = 1;
        this.f14781h = 1;
        this.f14782i = 0;
        this.f14783j = 1;
        this.f14784k = 0;
        this.f14785l = null;
        a(context);
    }

    public void a(int i2, int i3) {
        if (i2 <= 0) {
            i2 = this.f14780g;
        }
        this.f14780g = i2;
        if (i3 <= 0) {
            i3 = this.f14781h;
        }
        this.f14781h = i3;
        setLayoutManager(new GridLayoutManager(this.a, this.f14780g, 0, false));
    }

    public View a(int i2) {
        int i3 = this.f14781h;
        if ((i2 / i3) + 1 == this.f14783j) {
            return getChildAt(i2 % i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iCeil = (int) Math.ceil(((double) this.f14775b.a.size()) / ((double) (this.f14780g * this.f14781h)));
        if (iCeil != this.f14782i) {
            PageIndicatorView pageIndicatorView = this.f14785l;
            if (pageIndicatorView != null) {
                pageIndicatorView.a(iCeil);
            }
            int i2 = this.f14782i;
            if (iCeil < i2 && this.f14783j == i2) {
                this.f14783j = iCeil;
                smoothScrollBy(-getWidth(), 0);
            }
            PageIndicatorView pageIndicatorView2 = this.f14785l;
            if (pageIndicatorView2 != null) {
                pageIndicatorView2.setSelectedPage(this.f14783j - 1);
            }
            this.f14782i = iCeil;
        }
    }
}
