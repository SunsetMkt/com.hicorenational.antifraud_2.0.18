package ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import java.util.ArrayList;
import network.HistoryListInfo;
import ui.basemvp.BaseView;
import ui.callview.ReportCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class UrlFraudPresenter extends ModelPresent {

    class a implements ReportCallView {
        a() {
        }

        @Override // ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            e2.a("\u4e3e\u62a5\u6210\u529f");
            UrlFraudPresenter.this.mActivity.finish();
        }

        @Override // ui.callview.ReportCallView
        public void onfailRequest() {
            e2.a("\u4e3e\u62a5\u5931\u8d25\uff0c\u7a0d\u540e\u518d\u8bd5");
        }
    }

    public UrlFraudPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    public void oneKeyReportUrl(String str, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new a());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, arrayList, null, null, reportPersonBean);
    }
}
