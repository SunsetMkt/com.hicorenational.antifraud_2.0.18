package p388ui.presenter;

import android.app.Activity;
import bean.CheckFraudBean;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CheckFraudResultCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CheckFraudResultPresenter extends ModelPresent<CheckFraudResultCallView> {

    /* renamed from: ui.presenter.CheckFraudResultPresenter$a */
    class C6954a extends MiddleSubscriber<APIresult> {
        C6954a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26696e(aPIException.getMessage());
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
        ReportFraudIpUrl(hashMap, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f16992C0), new C6954a());
    }
}
