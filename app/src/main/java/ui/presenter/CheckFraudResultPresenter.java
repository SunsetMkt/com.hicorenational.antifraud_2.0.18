package ui.presenter;

import android.app.Activity;
import bean.CheckFraudBean;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CheckFraudResultCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CheckFraudResultPresenter extends ModelPresent<CheckFraudResultCallView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((CheckFraudResultCallView) CheckFraudResultPresenter.this.mvpView).onSuccessRequest();
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public CheckFraudResultPresenter(Activity activity, CheckFraudResultCallView checkFraudResultCallView) {
        super(activity, checkFraudResultCallView);
    }

    public void reportFraudIpUrlHttp(CheckFraudBean checkFraudBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("content", checkFraudBean.getContent());
        hashMap.put("source", checkFraudBean.getSource());
        reportFraudIpUrlHttp(hashMap);
    }

    private void reportFraudIpUrlHttp(HashMap<String, Object> hashMap) {
        ReportFraudIpUrl(hashMap, d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.C0), new a());
    }
}
