package p388ui.fragment;

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
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.fragment.ToolView;
import p388ui.view.pagerecycle.PageIndicatorView;
import p388ui.view.pagerecycle.PageRecyclerView;
import ui.view.pagerecycle.PageRecyclerView.PageAdapter;

/* loaded from: classes2.dex */
public class ToolView extends LinearLayout {

    /* renamed from: a */
    private Context f23861a;

    /* renamed from: b */
    private PageRecyclerView f23862b;

    /* renamed from: c */
    private PageIndicatorView f23863c;

    /* renamed from: d */
    private List<HomeToolBean> f23864d;

    /* renamed from: e */
    private List<HomeToolBean> f23865e;

    /* renamed from: f */
    private PageRecyclerView.PageAdapter f23866f;

    /* renamed from: g */
    private InterfaceC6878b f23867g;

    /* renamed from: h */
    private ArrayList<String> f23868h;

    /* renamed from: i */
    private int[] f23869i;

    public class Holder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        private View f23870a;

        /* renamed from: b */
        private ImageView f23871b;

        /* renamed from: c */
        private TextView f23872c;

        /* renamed from: d */
        private View f23873d;

        /* synthetic */ Holder(ToolView toolView, Context context, View view, C6877a c6877a) {
            this(context, view);
        }

        private Holder(Context context, View view) {
            super(view);
            this.f23870a = view.findViewById(C2113R.id.ll_item);
            this.f23871b = (ImageView) view.findViewById(C2113R.id.iv_icon);
            this.f23872c = (TextView) view.findViewById(C2113R.id.tv_name);
            this.f23873d = view.findViewById(C2113R.id.red_dot);
            view.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ToolView.Holder.this.m25603a(view2);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m25603a(View view) {
            int adapterPosition;
            if (!Hicore.getApp().isDouble() && ToolView.this.f23865e.size() > 0 && (adapterPosition = getAdapterPosition()) >= 0) {
                HomeToolBean homeToolBean = (HomeToolBean) ToolView.this.f23865e.get(adapterPosition);
                if (ToolView.this.f23867g == null || homeToolBean == null) {
                    return;
                }
                ToolView.this.f23867g.onClickToolItem(homeToolBean);
            }
        }
    }

    /* renamed from: ui.fragment.ToolView$b */
    public interface InterfaceC6878b {
        void onClickToolItem(HomeToolBean homeToolBean);
    }

    public ToolView(Context context) {
        super(context);
        this.f23864d = new ArrayList();
        this.f23865e = new ArrayList();
        this.f23868h = null;
        this.f23869i = new int[]{C2113R.drawable.iv_home_report, C2113R.drawable.iv_home_case, C2113R.drawable.iv_home_warn, C2113R.drawable.iv_home_id_check};
        m25592a();
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        if (regionMudelBean == null) {
            m25594b();
            this.f23865e = this.f23864d;
        } else if (regionMudelBean.getTool() == null || regionMudelBean.getTool().size() <= 0) {
            setVisibility(8);
        } else {
            this.f23865e = regionMudelBean.getTool();
            for (int i2 = 0; i2 < this.f23865e.size(); i2++) {
                HomeToolBean homeToolBean = this.f23865e.get(i2);
                int indexOf = this.f23868h.indexOf(homeToolBean.getModule());
                if (indexOf > -1) {
                    homeToolBean.setLocalIcon(this.f23869i[indexOf]);
                } else {
                    int indexOf2 = this.f23868h.indexOf(homeToolBean.getId());
                    if (indexOf2 > -1) {
                        homeToolBean.setLocalIcon(this.f23869i[indexOf2]);
                    } else {
                        homeToolBean.setLocalIcon(C2113R.drawable.iv_cricle_img_def);
                    }
                }
            }
        }
        this.f23862b.setIndicator(this.f23863c);
        this.f23862b.m26024a(1, 4);
        this.f23866f = m25596a(this.f23862b);
    }

    public void setItemClick(InterfaceC6878b interfaceC6878b) {
        if (interfaceC6878b != null) {
            this.f23867g = interfaceC6878b;
        }
    }

    /* renamed from: ui.fragment.ToolView$a */
    class C6877a implements PageRecyclerView.InterfaceC7238a {
        C6877a() {
        }

        @Override // p388ui.view.pagerecycle.PageRecyclerView.InterfaceC7238a
        /* renamed from: a */
        public RecyclerView.ViewHolder mo25604a(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(ToolView.this.f23861a).inflate(C2113R.layout.item_tool, viewGroup, false);
            ToolView toolView = ToolView.this;
            return new Holder(toolView, toolView.f23861a, inflate, null);
        }

        @Override // p388ui.view.pagerecycle.PageRecyclerView.InterfaceC7238a
        /* renamed from: a */
        public void mo25605a(RecyclerView.ViewHolder viewHolder, int i2) {
            HomeToolBean homeToolBean;
            if (ToolView.this.f23865e.size() <= 0 || (homeToolBean = (HomeToolBean) ToolView.this.f23865e.get(i2)) == null) {
                return;
            }
            Holder holder = (Holder) viewHolder;
            holder.f23870a.setVisibility(0);
            holder.f23872c.setText(homeToolBean.getContent());
            C5845d.m24615b(homeToolBean.getImage(), holder.f23871b, Integer.valueOf(homeToolBean.getLocalIcon()));
            if (homeToolBean.isHasRedDot()) {
                holder.f23873d.setVisibility(0);
            } else {
                holder.f23873d.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    private void m25592a() {
        this.f23861a = getContext();
        this.f23868h = new ArrayList<>();
        this.f23868h.add(ModuelConfig.MODEL_REPORT);
        this.f23868h.add(ModuelConfig.MODEL_CASEXC);
        this.f23868h.add(ModuelConfig.MODEL_WARN);
        this.f23868h.add(ModuelConfig.MODEL_IDVERIFY);
        View inflate = LayoutInflater.from(this.f23861a).inflate(C2113R.layout.view_tools, (ViewGroup) this, true);
        this.f23862b = (PageRecyclerView) inflate.findViewById(C2113R.id.page_recyclerview);
        this.f23863c = (PageIndicatorView) inflate.findViewById(C2113R.id.page_indicator);
    }

    /* renamed from: b */
    private void m25594b() {
        List<HomeToolBean> list = this.f23864d;
        if (list == null || list.size() <= 0) {
            String[] strArr = {"我要举报", "报案助手", "来电预警", "身份核实"};
            this.f23864d.clear();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                HomeToolBean homeToolBean = new HomeToolBean();
                homeToolBean.setModule(this.f23868h.get(i2));
                homeToolBean.setContent(str);
                homeToolBean.setLocalIcon(this.f23869i[i2]);
                homeToolBean.setIsNeedVerified(1);
                this.f23864d.add(homeToolBean);
            }
        }
    }

    public ToolView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23864d = new ArrayList();
        this.f23865e = new ArrayList();
        this.f23868h = null;
        this.f23869i = new int[]{C2113R.drawable.iv_home_report, C2113R.drawable.iv_home_case, C2113R.drawable.iv_home_warn, C2113R.drawable.iv_home_id_check};
        m25592a();
    }

    /* renamed from: a */
    public boolean m25598a(String str) {
        ArrayList<String> arrayList = this.f23868h;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(str);
    }

    /* renamed from: a */
    public void m25597a(boolean z) {
        int i2;
        if (this.f23862b != null) {
            try {
                if (this.f23865e == null || this.f23865e.size() <= 0) {
                    return;
                }
                int i3 = 0;
                while (i2 < this.f23865e.size()) {
                    i2 = (TextUtils.equals(this.f23865e.get(i2).getModule(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f23865e.get(i2).getId(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f23865e.get(i2).getContent(), "身份核实")) ? 0 : i2 + 1;
                    this.f23865e.get(i2).setHasRedDot(z);
                    View m26023a = this.f23862b.m26023a(i2);
                    if (m26023a != null) {
                        View findViewById = m26023a.findViewById(C2113R.id.red_dot);
                        if (!z) {
                            i3 = 8;
                        }
                        if (findViewById == null || findViewById.getVisibility() == i3) {
                            return;
                        }
                        findViewById.setVisibility(i3);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public PageRecyclerView.PageAdapter m25596a(PageRecyclerView pageRecyclerView) {
        pageRecyclerView.getClass();
        this.f23866f = pageRecyclerView.new PageAdapter(this.f23865e, new C6877a());
        pageRecyclerView.setAdapter(this.f23866f);
        this.f23866f.notifyDataSetChanged();
        return this.f23866f;
    }
}
