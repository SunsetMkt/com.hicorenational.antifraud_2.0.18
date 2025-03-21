package p388ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import java.util.ArrayList;
import network.HistoryListInfo;
import p388ui.basemvp.BaseView;
import p388ui.callview.ReportCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class UrlFraudPresenter extends ModelPresent {

    /* renamed from: ui.presenter.UrlFraudPresenter$a */
    class C7103a implements ReportCallView {
        C7103a() {
        }

        @Override // p388ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            C7331w1.m26688a("举报成功");
            UrlFraudPresenter.this.mActivity.finish();
        }

        @Override // p388ui.callview.ReportCallView
        public void onfailRequest() {
            C7331w1.m26688a("举报失败，稍后再试");
        }
    }

    public UrlFraudPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    public void oneKeyReportUrl(String str, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new C7103a());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, arrayList, null, null, reportPersonBean);
    }
}
