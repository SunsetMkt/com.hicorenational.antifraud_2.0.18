package p388ui.activity;

import android.content.Context;
import android.text.TextUtils;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import network.http.ReportNumHttp;
import p245d.C4440a;
import util.C7292k1;
import util.C7337y1;

/* compiled from: PromosWebDetActivity.java */
/* renamed from: ui.activity.w1 */
/* loaded from: classes2.dex */
class C6805w1 implements ReportNumHttp.Callback {

    /* renamed from: a */
    final /* synthetic */ PromosWebDetActivity f23656a;

    C6805w1(PromosWebDetActivity promosWebDetActivity) {
        this.f23656a = promosWebDetActivity;
    }

    @Override // network.http.ReportNumHttp.Callback
    public void onNumSuccess() {
        RegionMudelBean m16408j = C4440a.m16408j();
        if (m16408j == null) {
            C7337y1.m26748a((Context) this.f23656a.mActivity, (Class<?>) ReportNewActivity.class);
            return;
        }
        if (m16408j.getTool() == null || m16408j.getTool().size() <= 0) {
            return;
        }
        for (HomeToolBean homeToolBean : m16408j.getTool()) {
            if (TextUtils.equals(homeToolBean.getModule(), ModuelConfig.MODEL_REPORT)) {
                C7337y1.m26748a((Context) this.f23656a.mActivity, (Class<?>) ReportNewActivity.class);
            } else if (TextUtils.equals(homeToolBean.getId(), ModuelConfig.MODEL_REPORT) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                C7292k1.m26393a(this.f23656a.mActivity, homeToolBean.getModule());
                return;
            }
        }
    }
}
