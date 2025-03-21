package p388ui.presenter;

import android.app.Activity;
import bean.CaseDivisonBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.PaymentTypeCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class PaymentTypePresenter extends ModelPresent<PaymentTypeCallView> {

    /* renamed from: ui.presenter.PaymentTypePresenter$a */
    class C7035a extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: ui.presenter.PaymentTypePresenter$a$a */
        class a extends C2049a<List<CaseDivisonBean>> {
            a() {
            }
        }

        C7035a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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
        surveyCredentType(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17095i1), new C7035a());
    }
}
