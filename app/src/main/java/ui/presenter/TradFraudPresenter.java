package ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReportCallView;
import ui.callview.TradFraudView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class TradFraudPresenter extends ModelPresent<TradFraudView> {

    class a extends MiddleSubscriber<APIresult<List<SocialTypeBean>>> {

        /* JADX INFO: renamed from: ui.presenter.TradFraudPresenter$a$a, reason: collision with other inner class name */
        class C0320a extends com.google.gson.d0.a<List<SocialTypeBean>> {
            C0320a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0320a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((TradFraudView) TradFraudPresenter.this.mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SocialTypeBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((TradFraudView) TradFraudPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    class b implements ReportCallView {
        b() {
        }

        @Override // ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            e2.a("\u4e3e\u62a5\u6210\u529f");
            TradFraudPresenter.this.mActivity.finish();
        }

        @Override // ui.callview.ReportCallView
        public void onfailRequest() {
            e2.a("\u4e3e\u62a5\u5931\u8d25\uff0c\u7a0d\u540e\u518d\u8bd5");
        }
    }

    public TradFraudPresenter(Activity activity, TradFraudView tradFraudView) {
        super(activity, tradFraudView);
    }

    public void getSocialTags() {
        getSocialTags(e.a.b(ModuelConfig.MODEL_FRAUDCHECK, 5, f.b.a0), new a());
    }

    public void oneKeyReportTrad(SocialAccBean socialAccBean, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(socialAccBean);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new b());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, null, null, arrayList, reportPersonBean);
    }
}
