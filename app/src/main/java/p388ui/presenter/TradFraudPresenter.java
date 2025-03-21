package p388ui.presenter;

import android.app.Activity;
import bean.ReportPersonBean;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ReportCallView;
import p388ui.callview.TradFraudView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class TradFraudPresenter extends ModelPresent<TradFraudView> {

    /* renamed from: ui.presenter.TradFraudPresenter$a */
    class C7100a extends MiddleSubscriber<APIresult<List<SocialTypeBean>>> {

        /* renamed from: ui.presenter.TradFraudPresenter$a$a */
        class a extends C2049a<List<SocialTypeBean>> {
            a() {
            }
        }

        C7100a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
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

    /* renamed from: ui.presenter.TradFraudPresenter$b */
    class C7101b implements ReportCallView {
        C7101b() {
        }

        @Override // p388ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            C7331w1.m26688a("举报成功");
            TradFraudPresenter.this.mActivity.finish();
        }

        @Override // p388ui.callview.ReportCallView
        public void onfailRequest() {
            C7331w1.m26688a("举报失败，稍后再试");
        }
    }

    public TradFraudPresenter(Activity activity, TradFraudView tradFraudView) {
        super(activity, tradFraudView);
    }

    public void getSocialTags() {
        getSocialTags(C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 5, C4445b.f17060Z), new C7100a());
    }

    public void oneKeyReportTrad(SocialAccBean socialAccBean, ReportPersonBean reportPersonBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(socialAccBean);
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new C7101b());
        reportPresenter.setIsilent(false);
        reportPresenter.reportSubmit(null, null, null, null, arrayList, reportPersonBean);
    }
}
