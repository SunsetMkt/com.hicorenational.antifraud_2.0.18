package p388ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import bean.SocialAccBean;
import java.util.ArrayList;
import network.HistoryListInfo;
import p388ui.callview.ChatFraudView;
import p388ui.callview.ReportCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ChatFraudPresenter extends ModelPresent<ChatFraudView> {

    /* renamed from: ui.presenter.ChatFraudPresenter$a */
    class C6948a implements ReportCallView {
        C6948a() {
        }

        @Override // p388ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            C7331w1.m26688a("举报成功");
            ChatFraudPresenter.this.mActivity.finish();
        }

        @Override // p388ui.callview.ReportCallView
        public void onfailRequest() {
            C7331w1.m26688a("举报失败，稍后再试");
        }
    }

    public ChatFraudPresenter(Activity activity, ChatFraudView chatFraudView) {
        super(activity, chatFraudView);
    }

    public void oneKeyReportTrad(SocialAccBean socialAccBean, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(socialAccBean);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new C6948a());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, null, arrayList, null, reportPersonBean);
    }
}
