package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p245d.C4441b;
import p247e.C4445b;
import p388ui.callview.PolicInfoView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class PolicInfoPresenter extends ModelPresent<PolicInfoView> {

    /* renamed from: ui.presenter.PolicInfoPresenter$a */
    class C7037a extends MiddleSubscriber<APIresult> {
        C7037a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                C4441b.m16417e();
                PolicInfoPresenter.this.mActivity.finish();
            }
        }
    }

    public PolicInfoPresenter(Activity activity, PolicInfoView policInfoView) {
        super(activity, policInfoView);
    }

    public void policUserLogout() {
        policUserLogout(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 8, C4445b.f17061Z0), new C7037a());
    }
}
