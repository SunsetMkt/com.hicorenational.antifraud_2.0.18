package p388ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bean.module.BottomLocalBean;
import com.hicorenational.antifraud.C2113R;
import manager.GrayManager;
import p357j.C5845d;

/* loaded from: classes2.dex */
public class BottomBarTab extends FrameLayout {

    /* renamed from: a */
    private ImageView f24461a;

    /* renamed from: b */
    private TextView f24462b;

    /* renamed from: c */
    private TextView f24463c;

    /* renamed from: d */
    private int f24464d;

    /* renamed from: e */
    private String[] f24465e;

    /* renamed from: f */
    private int[] f24466f;

    /* renamed from: g */
    private int[] f24467g;

    public BottomBarTab(Context context, int i2) {
        super(context);
        this.f24464d = -1;
        this.f24465e = new String[]{"首页", "骗局曝光", "我的"};
        this.f24466f = new int[]{C2113R.mipmap.tab_home_unseled, C2113R.mipmap.tab_xc_unseled, C2113R.mipmap.tab_mine_unseled};
        this.f24467g = new int[]{C2113R.mipmap.tab_home_seled, C2113R.mipmap.tab_xc_seled, C2113R.mipmap.tab_mine_seled};
        m25737a(context, i2);
    }

    /* renamed from: a */
    private void m25737a(Context context, int i2) {
        View inflate = LayoutInflater.from(context).inflate(C2113R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.f24461a = (ImageView) inflate.findViewById(C2113R.id.iv_tab_bar);
        this.f24462b = (TextView) inflate.findViewById(C2113R.id.tv_tab_bar);
        this.f24463c = (TextView) inflate.findViewById(C2113R.id.red_tip);
        C5845d.m24612b(this.f24461a, Integer.valueOf(this.f24466f[i2]));
        this.f24462b.setText(this.f24465e[i2]);
    }

    public int getTabPosition() {
        return this.f24464d;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.f24461a.setImageResource(this.f24467g[this.f24464d]);
            this.f24462b.setTextColor(Color.parseColor("#2946E6"));
        } else {
            this.f24461a.setImageResource(this.f24466f[this.f24464d]);
            this.f24462b.setTextColor(Color.parseColor("#666666"));
        }
        if (this.f24464d == 0) {
            GrayManager.Companion.getInstance().setLayerGray(this);
        }
    }

    public BottomBarTab(Context context, int i2, BottomLocalBean bottomLocalBean) {
        super(context);
        this.f24464d = -1;
        this.f24465e = new String[]{"首页", "骗局曝光", "我的"};
        this.f24466f = new int[]{C2113R.mipmap.tab_home_unseled, C2113R.mipmap.tab_xc_unseled, C2113R.mipmap.tab_mine_unseled};
        this.f24467g = new int[]{C2113R.mipmap.tab_home_seled, C2113R.mipmap.tab_xc_seled, C2113R.mipmap.tab_mine_seled};
        m25738a(context, i2, bottomLocalBean);
    }

    /* renamed from: a */
    private void m25738a(Context context, int i2, BottomLocalBean bottomLocalBean) {
        this.f24465e = new String[]{"首页", "骗局曝光", bottomLocalBean.getContent(), "我的"};
        this.f24466f = new int[]{C2113R.mipmap.tab_home_unseled, C2113R.mipmap.tab_xc_unseled, C2113R.mipmap.tab_local_unseled, C2113R.mipmap.tab_mine_unseled};
        this.f24467g = new int[]{C2113R.mipmap.tab_home_seled, C2113R.mipmap.tab_xc_seled, C2113R.mipmap.tab_local_seled, C2113R.mipmap.tab_mine_seled};
        View inflate = LayoutInflater.from(context).inflate(C2113R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.f24461a = (ImageView) inflate.findViewById(C2113R.id.iv_tab_bar);
        this.f24462b = (TextView) inflate.findViewById(C2113R.id.tv_tab_bar);
        this.f24463c = (TextView) inflate.findViewById(C2113R.id.red_tip);
        C5845d.m24612b(this.f24461a, Integer.valueOf(this.f24466f[i2]));
        this.f24462b.setText(this.f24465e[i2]);
    }

    /* renamed from: a */
    public void m25739a(int i2, int i3) {
        this.f24464d = i2;
        if (i2 == i3) {
            setSelected(true);
        }
    }

    /* renamed from: a */
    public void m25740a(boolean z) {
        if (z) {
            this.f24463c.setVisibility(0);
        } else {
            this.f24463c.setVisibility(4);
        }
    }
}
