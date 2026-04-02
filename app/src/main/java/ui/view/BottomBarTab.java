package ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bean.module.BottomLocalBean;
import com.hicorenational.antifraud.R;
import manager.GrayManager;

/* JADX INFO: loaded from: classes2.dex */
public class BottomBarTab extends FrameLayout {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f14496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f14497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f14499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f14500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f14501g;

    public BottomBarTab(Context context, int i2) {
        super(context);
        this.f14498d = -1;
        this.f14499e = new String[]{"\u9996\u9875", "\u9a97\u5c40\u66dd\u5149", "\u6211\u7684"};
        this.f14500f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_mine_unseled};
        this.f14501g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_mine_seled};
        a(context, i2);
    }

    private void a(Context context, int i2) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.a = (ImageView) viewInflate.findViewById(R.id.iv_tab_bar);
        this.f14496b = (TextView) viewInflate.findViewById(R.id.tv_tab_bar);
        this.f14497c = (TextView) viewInflate.findViewById(R.id.red_tip);
        k.d.b(this.a, Integer.valueOf(this.f14500f[i2]));
        this.f14496b.setText(this.f14499e[i2]);
    }

    public int getTabPosition() {
        return this.f14498d;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.a.setImageResource(this.f14501g[this.f14498d]);
            this.f14496b.setTextColor(Color.parseColor("#2946E6"));
        } else {
            this.a.setImageResource(this.f14500f[this.f14498d]);
            this.f14496b.setTextColor(Color.parseColor("#666666"));
        }
        if (this.f14498d == 0) {
            GrayManager.Companion.getInstance().setLayerGray(this);
        }
    }

    public BottomBarTab(Context context, int i2, BottomLocalBean bottomLocalBean) {
        super(context);
        this.f14498d = -1;
        this.f14499e = new String[]{"\u9996\u9875", "\u9a97\u5c40\u66dd\u5149", "\u6211\u7684"};
        this.f14500f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_mine_unseled};
        this.f14501g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_mine_seled};
        a(context, i2, bottomLocalBean);
    }

    private void a(Context context, int i2, BottomLocalBean bottomLocalBean) {
        this.f14499e = new String[]{"\u9996\u9875", "\u9a97\u5c40\u66dd\u5149", bottomLocalBean.getContent(), "\u6211\u7684"};
        this.f14500f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_local_unseled, R.mipmap.tab_mine_unseled};
        this.f14501g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_local_seled, R.mipmap.tab_mine_seled};
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.a = (ImageView) viewInflate.findViewById(R.id.iv_tab_bar);
        this.f14496b = (TextView) viewInflate.findViewById(R.id.tv_tab_bar);
        this.f14497c = (TextView) viewInflate.findViewById(R.id.red_tip);
        k.d.b(this.a, Integer.valueOf(this.f14500f[i2]));
        this.f14496b.setText(this.f14499e[i2]);
    }

    public void a(int i2, int i3) {
        this.f14498d = i2;
        if (i2 == i3) {
            setSelected(true);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f14497c.setVisibility(0);
        } else {
            this.f14497c.setVisibility(4);
        }
    }
}
