package ui.presenter;

import android.app.Activity;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.PaymentTypeCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentTypePresenter extends ModelPresent<PaymentTypeCallView> {

    class a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* JADX INFO: renamed from: ui.presenter.PaymentTypePresenter$a$a, reason: collision with other inner class name */
        class C0308a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            C0308a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0308a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((PaymentTypeCallView) PaymentTypePresenter.this.mvpView).onSuccessPaymentType(aPIresult.getData());
            }
        }
    }

    public PaymentTypePresenter(Activity activity, PaymentTypeCallView paymentTypeCallView) {
        super(activity, paymentTypeCallView);
    }

    public void paymentType() {
        surveyCredentType(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.j1), new a());
    }
}
