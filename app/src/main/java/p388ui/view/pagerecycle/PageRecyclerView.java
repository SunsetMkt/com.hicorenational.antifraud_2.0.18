package p388ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes2.dex */
public class PageRecyclerView extends RecyclerView {

    /* renamed from: a */
    private Context f24955a;

    /* renamed from: b */
    private PageAdapter f24956b;

    /* renamed from: c */
    private int f24957c;

    /* renamed from: d */
    private float f24958d;

    /* renamed from: e */
    private float f24959e;

    /* renamed from: f */
    private float f24960f;

    /* renamed from: g */
    private int f24961g;

    /* renamed from: h */
    private int f24962h;

    /* renamed from: i */
    private int f24963i;

    /* renamed from: j */
    private int f24964j;

    /* renamed from: k */
    private int f24965k;

    /* renamed from: l */
    private PageIndicatorView f24966l;

    public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a */
        private List<?> f24967a;

        /* renamed from: b */
        private InterfaceC7238a f24968b;

        /* renamed from: c */
        private int f24969c = 0;

        /* renamed from: d */
        private int f24970d;

        public PageAdapter(List<?> list, InterfaceC7238a interfaceC7238a) {
            this.f24967a = null;
            this.f24968b = null;
            this.f24970d = 0;
            this.f24967a = list;
            this.f24968b = interfaceC7238a;
            this.f24970d = this.f24967a.size() + (PageRecyclerView.this.f24961g * PageRecyclerView.this.f24962h);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f24970d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (PageRecyclerView.this.f24962h == 1) {
                viewHolder.itemView.getLayoutParams().width = this.f24969c + PageRecyclerView.this.f24965k;
                viewHolder.itemView.setPadding(PageRecyclerView.this.f24965k, 0, 0, 0);
            } else {
                int i3 = i2 % (PageRecyclerView.this.f24961g * PageRecyclerView.this.f24962h);
                if (i3 < PageRecyclerView.this.f24961g) {
                    viewHolder.itemView.getLayoutParams().width = this.f24969c + PageRecyclerView.this.f24965k;
                    viewHolder.itemView.setPadding(PageRecyclerView.this.f24965k, 0, 0, 0);
                } else if (i3 >= (PageRecyclerView.this.f24961g * PageRecyclerView.this.f24962h) - PageRecyclerView.this.f24961g) {
                    viewHolder.itemView.getLayoutParams().width = this.f24969c + PageRecyclerView.this.f24965k;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                } else {
                    viewHolder.itemView.getLayoutParams().width = this.f24969c;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                }
            }
            if (i2 >= this.f24967a.size()) {
                viewHolder.itemView.setVisibility(4);
            } else {
                viewHolder.itemView.setVisibility(0);
                this.f24968b.mo25605a(viewHolder, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (this.f24969c <= 0) {
                this.f24969c = (viewGroup.getWidth() - PageRecyclerView.this.f24965k) / PageRecyclerView.this.f24962h;
            }
            RecyclerView.ViewHolder mo25604a = this.f24968b.mo25604a(viewGroup, i2);
            mo25604a.itemView.measure(0, 0);
            mo25604a.itemView.getLayoutParams().width = this.f24969c;
            mo25604a.itemView.getLayoutParams().height = mo25604a.itemView.getMeasuredHeight();
            return mo25604a;
        }

        /* renamed from: a */
        public void m26026a(List<?> list) {
            this.f24967a = list;
            this.f24970d = this.f24967a.size() + (PageRecyclerView.this.f24961g * PageRecyclerView.this.f24962h);
            notifyDataSetChanged();
            PageRecyclerView.this.m26018a();
        }
    }

    /* renamed from: ui.view.pagerecycle.PageRecyclerView$a */
    public interface InterfaceC7238a {
        /* renamed from: a */
        RecyclerView.ViewHolder mo25604a(ViewGroup viewGroup, int i2);

        /* renamed from: a */
        void mo25605a(RecyclerView.ViewHolder viewHolder, int i2);
    }

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        PageAdapter pageAdapter = this.f24956b;
        if (pageAdapter != null && pageAdapter.f24967a != null && this.f24956b.f24967a.size() == 0) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24958d = motionEvent.getX();
        } else {
            if (action == 1) {
                this.f24959e = motionEvent.getX() - this.f24958d;
                if (Math.abs(this.f24959e) > this.f24957c) {
                    if (this.f24959e > 0.0f) {
                        int i2 = this.f24964j;
                        this.f24964j = i2 == 1 ? 1 : i2 - 1;
                    } else {
                        int i3 = this.f24964j;
                        int i4 = this.f24963i;
                        if (i3 != i4) {
                            i4 = i3 + 1;
                        }
                        this.f24964j = i4;
                    }
                    PageIndicatorView pageIndicatorView = this.f24966l;
                    if (pageIndicatorView != null) {
                        pageIndicatorView.setSelectedPage(this.f24964j - 1);
                    }
                }
                smoothScrollBy((int) (((this.f24964j - 1) * getWidth()) - this.f24960f), 0);
                return true;
            }
            if (action == 2 && this.f24964j == this.f24963i && this.f24958d - motionEvent.getX() > 0.0f) {
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
        this.f24960f += i2;
        super.onScrolled(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter2) {
        super.setAdapter(adapter2);
        this.f24956b = (PageAdapter) adapter2;
        m26018a();
    }

    public void setIndicator(PageIndicatorView pageIndicatorView) {
        this.f24966l = pageIndicatorView;
    }

    public void setPageMargin(int i2) {
        this.f24965k = i2;
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m26019a(Context context) {
        this.f24955a = context;
        setLayoutManager(new GridLayoutManager(this.f24955a, this.f24961g, 0, false));
        setOverScrollMode(2);
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24955a = null;
        this.f24956b = null;
        this.f24957c = 100;
        this.f24958d = 0.0f;
        this.f24959e = 0.0f;
        this.f24960f = 0.0f;
        this.f24961g = 1;
        this.f24962h = 1;
        this.f24963i = 0;
        this.f24964j = 1;
        this.f24965k = 0;
        this.f24966l = null;
        m26019a(context);
    }

    /* renamed from: a */
    public void m26024a(int i2, int i3) {
        if (i2 <= 0) {
            i2 = this.f24961g;
        }
        this.f24961g = i2;
        if (i3 <= 0) {
            i3 = this.f24962h;
        }
        this.f24962h = i3;
        setLayoutManager(new GridLayoutManager(this.f24955a, this.f24961g, 0, false));
    }

    /* renamed from: a */
    public View m26023a(int i2) {
        int i3 = this.f24962h;
        if ((i2 / i3) + 1 == this.f24964j) {
            return getChildAt(i2 % i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m26018a() {
        int ceil = (int) Math.ceil(this.f24956b.f24967a.size() / (this.f24961g * this.f24962h));
        if (ceil != this.f24963i) {
            PageIndicatorView pageIndicatorView = this.f24966l;
            if (pageIndicatorView != null) {
                pageIndicatorView.m26016a(ceil);
            }
            int i2 = this.f24963i;
            if (ceil < i2 && this.f24964j == i2) {
                this.f24964j = ceil;
                smoothScrollBy(-getWidth(), 0);
            }
            PageIndicatorView pageIndicatorView2 = this.f24966l;
            if (pageIndicatorView2 != null) {
                pageIndicatorView2.setSelectedPage(this.f24964j - 1);
            }
            this.f24963i = ceil;
        }
    }
}
