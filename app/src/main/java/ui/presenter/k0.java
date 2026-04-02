package ui.presenter;

import android.content.Context;
import android.text.TextUtils;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import network.http.ReportNumHttp;
import ui.activity.ReportNewActivity;
import util.g2;
import util.p1;

/* JADX INFO: compiled from: MainPagePresenter.java */
/* JADX INFO: loaded from: classes2.dex */
class k0 implements ReportNumHttp.Callback {
    final /* synthetic */ MainPagePresenter a;

    k0(MainPagePresenter mainPagePresenter) {
        this.a = mainPagePresenter;
    }

    @Override // network.http.ReportNumHttp.Callback
    public void onNumSuccess() {
        RegionMudelBean regionMudelBeanJ = e.a.j();
        if (regionMudelBeanJ == null) {
            g2.a((Context) this.a.mActivity, (Class<?>) ReportNewActivity.class);
            return;
        }
        if (regionMudelBeanJ.getTool() == null || regionMudelBeanJ.getTool().size() <= 0) {
            return;
        }
        for (HomeToolBean homeToolBean : regionMudelBeanJ.getTool()) {
            if (TextUtils.equals(homeToolBean.getId(), ModuelConfig.MODEL_REPORT) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                p1.a(this.a.mActivity, homeToolBean.getModule());
                return;
            } else if (TextUtils.equals(homeToolBean.getModule(), ModuelConfig.MODEL_REPORT)) {
                g2.a((Context) this.a.mActivity, (Class<?>) ReportNewActivity.class);
            }
        }
    }
}
