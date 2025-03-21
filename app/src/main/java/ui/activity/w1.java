package ui.activity;

import android.content.Context;
import android.text.TextUtils;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import network.http.ReportNumHttp;
import util.y1;

/* compiled from: PromosWebDetActivity.java */
/* loaded from: classes2.dex */
class w1 implements ReportNumHttp.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PromosWebDetActivity f19485a;

    w1(PromosWebDetActivity promosWebDetActivity) {
        this.f19485a = promosWebDetActivity;
    }

    @Override // network.http.ReportNumHttp.Callback
    public void onNumSuccess() {
        RegionMudelBean j2 = d.a.j();
        if (j2 == null) {
            y1.a((Context) this.f19485a.mActivity, (Class<?>) ReportNewActivity.class);
            return;
        }
        if (j2.getTool() == null || j2.getTool().size() <= 0) {
            return;
        }
        for (HomeToolBean homeToolBean : j2.getTool()) {
            if (TextUtils.equals(homeToolBean.getModule(), ModuelConfig.MODEL_REPORT)) {
                y1.a((Context) this.f19485a.mActivity, (Class<?>) ReportNewActivity.class);
            } else if (TextUtils.equals(homeToolBean.getId(), ModuelConfig.MODEL_REPORT) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                util.k1.a(this.f19485a.mActivity, homeToolBean.getModule());
                return;
            }
        }
    }
}
