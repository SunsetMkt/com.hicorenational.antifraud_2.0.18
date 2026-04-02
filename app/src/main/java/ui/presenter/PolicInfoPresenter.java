package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.PolicInfoView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class PolicInfoPresenter extends ModelPresent<PolicInfoView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                e.b.e();
                PolicInfoPresenter.this.mActivity.finish();
            }
        }
    }

    public PolicInfoPresenter(Activity activity, PolicInfoView policInfoView) {
        super(activity, policInfoView);
    }

    public void policUserLogout() {
        policUserLogout(e.a.b(ModuelConfig.MODEL_CASEXC, 8, f.b.a1), new a());
    }
}
