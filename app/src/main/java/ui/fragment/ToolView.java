package ui.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.view.pagerecycle.PageIndicatorView;
import ui.view.pagerecycle.PageRecyclerView;
import ui.view.pagerecycle.PageRecyclerView.PageAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class ToolView extends LinearLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PageRecyclerView f14209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PageIndicatorView f14210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<HomeToolBean> f14211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<HomeToolBean> f14212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PageRecyclerView.PageAdapter f14213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f14214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f14215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f14216i;

    public class Holder extends RecyclerView.ViewHolder {
        private View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f14217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f14218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f14219d;

        /* synthetic */ Holder(ToolView toolView, Context context, View view, a aVar) {
            this(context, view);
        }

        private Holder(Context context, View view) {
            super(view);
            this.a = view.findViewById(R.id.ll_item);
            this.f14217b = (ImageView) view.findViewById(R.id.iv_icon);
            this.f14218c = (TextView) view.findViewById(R.id.tv_name);
            this.f14219d = view.findViewById(R.id.red_dot);
            view.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.a(view2);
                }
            });
        }

        public /* synthetic */ void a(View view) {
            int adapterPosition;
            if (!Hicore.getApp().isDouble() && ToolView.this.f14212e.size() > 0 && (adapterPosition = getAdapterPosition()) >= 0) {
                HomeToolBean homeToolBean = (HomeToolBean) ToolView.this.f14212e.get(adapterPosition);
                if (ToolView.this.f14214g == null || homeToolBean == null) {
                    return;
                }
                ToolView.this.f14214g.onClickToolItem(homeToolBean);
            }
        }
    }

    public interface b {
        void onClickToolItem(HomeToolBean homeToolBean);
    }

    public ToolView(Context context) {
        super(context);
        this.f14211d = new ArrayList();
        this.f14212e = new ArrayList();
        this.f14215h = null;
        this.f14216i = new int[]{R.drawable.iv_home_report, R.drawable.iv_home_case, R.drawable.iv_home_warn, R.drawable.iv_home_id_check};
        a();
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        if (regionMudelBean == null) {
            b();
            this.f14212e = this.f14211d;
        } else if (regionMudelBean.getTool() == null || regionMudelBean.getTool().size() <= 0) {
            setVisibility(8);
        } else {
            this.f14212e = regionMudelBean.getTool();
            for (int i2 = 0; i2 < this.f14212e.size(); i2++) {
                HomeToolBean homeToolBean = this.f14212e.get(i2);
                int iIndexOf = this.f14215h.indexOf(homeToolBean.getModule());
                if (iIndexOf > -1) {
                    homeToolBean.setLocalIcon(this.f14216i[iIndexOf]);
                } else {
                    int iIndexOf2 = this.f14215h.indexOf(homeToolBean.getId());
                    if (iIndexOf2 > -1) {
                        homeToolBean.setLocalIcon(this.f14216i[iIndexOf2]);
                    } else {
                        homeToolBean.setLocalIcon(R.drawable.iv_cricle_img_def);
                    }
                }
            }
        }
        this.f14209b.setIndicator(this.f14210c);
        this.f14209b.a(1, 4);
        this.f14213f = a(this.f14209b);
    }

    public void setItemClick(b bVar) {
        if (bVar != null) {
            this.f14214g = bVar;
        }
    }

    class a implements PageRecyclerView.a {
        a() {
        }

        @Override // ui.view.pagerecycle.PageRecyclerView.a
        public RecyclerView.ViewHolder a(ViewGroup viewGroup, int i2) {
            View viewInflate = LayoutInflater.from(ToolView.this.a).inflate(R.layout.item_tool, viewGroup, false);
            ToolView toolView = ToolView.this;
            return new Holder(toolView, toolView.a, viewInflate, null);
        }

        @Override // ui.view.pagerecycle.PageRecyclerView.a
        public void a(RecyclerView.ViewHolder viewHolder, int i2) {
            HomeToolBean homeToolBean;
            if (ToolView.this.f14212e.size() <= 0 || (homeToolBean = (HomeToolBean) ToolView.this.f14212e.get(i2)) == null) {
                return;
            }
            Holder holder = (Holder) viewHolder;
            holder.a.setVisibility(0);
            holder.f14218c.setText(homeToolBean.getContent());
            k.d.b(homeToolBean.getImage(), holder.f14217b, Integer.valueOf(homeToolBean.getLocalIcon()));
            if (homeToolBean.isHasRedDot()) {
                holder.f14219d.setVisibility(0);
            } else {
                holder.f14219d.setVisibility(8);
            }
        }
    }

    private void a() {
        this.a = getContext();
        this.f14215h = new ArrayList<>();
        this.f14215h.add(ModuelConfig.MODEL_REPORT);
        this.f14215h.add(ModuelConfig.MODEL_CASEXC);
        this.f14215h.add(ModuelConfig.MODEL_WARN);
        this.f14215h.add(ModuelConfig.MODEL_IDVERIFY);
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.view_tools, (ViewGroup) this, true);
        this.f14209b = (PageRecyclerView) viewInflate.findViewById(R.id.page_recyclerview);
        this.f14210c = (PageIndicatorView) viewInflate.findViewById(R.id.page_indicator);
    }

    private void b() {
        List<HomeToolBean> list = this.f14211d;
        if (list == null || list.size() <= 0) {
            String[] strArr = {"\u6211\u8981\u4e3e\u62a5", "\u62a5\u6848\u52a9\u624b", "\u6765\u7535\u9884\u8b66", "\u8eab\u4efd\u6838\u5b9e"};
            this.f14211d.clear();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                HomeToolBean homeToolBean = new HomeToolBean();
                homeToolBean.setModule(this.f14215h.get(i2));
                homeToolBean.setContent(str);
                homeToolBean.setLocalIcon(this.f14216i[i2]);
                homeToolBean.setIsNeedVerified(1);
                this.f14211d.add(homeToolBean);
            }
        }
    }

    public ToolView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14211d = new ArrayList();
        this.f14212e = new ArrayList();
        this.f14215h = null;
        this.f14216i = new int[]{R.drawable.iv_home_report, R.drawable.iv_home_case, R.drawable.iv_home_warn, R.drawable.iv_home_id_check};
        a();
    }

    public boolean a(String str) {
        ArrayList<String> arrayList = this.f14215h;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(str);
    }

    public void a(boolean z) {
        int i2;
        if (this.f14209b != null) {
            try {
                if (this.f14212e == null || this.f14212e.size() <= 0) {
                    return;
                }
                int i3 = 0;
                while (i2 < this.f14212e.size()) {
                    i2 = (TextUtils.equals(this.f14212e.get(i2).getModule(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f14212e.get(i2).getId(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f14212e.get(i2).getContent(), "\u8eab\u4efd\u6838\u5b9e")) ? 0 : i2 + 1;
                    this.f14212e.get(i2).setHasRedDot(z);
                    View viewA = this.f14209b.a(i2);
                    if (viewA != null) {
                        View viewFindViewById = viewA.findViewById(R.id.red_dot);
                        if (!z) {
                            i3 = 8;
                        }
                        if (viewFindViewById == null || viewFindViewById.getVisibility() == i3) {
                            return;
                        }
                        viewFindViewById.setVisibility(i3);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public PageRecyclerView.PageAdapter a(PageRecyclerView pageRecyclerView) {
        pageRecyclerView.getClass();
        this.f14213f = pageRecyclerView.new PageAdapter(this.f14212e, new a());
        pageRecyclerView.setAdapter(this.f14213f);
        this.f14213f.notifyDataSetChanged();
        return this.f14213f;
    }
}
