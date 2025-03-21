package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.FeedbackDetailCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class FeedbackDetailPresenter extends ModelPresent<FeedbackDetailCallView> {

    /* renamed from: ui.presenter.FeedbackDetailPresenter$a */
    class C6979a extends MiddleSubscriber<APIresult> {
        C6979a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((FeedbackDetailCallView) FeedbackDetailPresenter.this.mvpView).onSuccessRequestt();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public FeedbackDetailPresenter(Activity activity, FeedbackDetailCallView feedbackDetailCallView) {
        super(activity, feedbackDetailCallView);
    }

    public void getSolve(String str, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", str);
        hashMap.put("isSolve", Boolean.valueOf(z));
        getSolve(hashMap);
    }

    public void getSolve(HashMap<String, Object> hashMap) {
        requestSolve(C4440a.m16395a(ModuelConfig.MODEL_FEEDBACK, 8, C4445b.f17016K0), hashMap, new C6979a());
    }
}
