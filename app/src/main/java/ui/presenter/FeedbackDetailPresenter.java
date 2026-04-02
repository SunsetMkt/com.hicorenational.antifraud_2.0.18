package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.FeedbackDetailCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackDetailPresenter extends ModelPresent<FeedbackDetailCallView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.e(aPIException.getMessage());
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
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("isSolve", Boolean.valueOf(z));
        getSolve(map);
    }

    public void getSolve(HashMap<String, Object> map) {
        requestSolve(e.a.b(ModuelConfig.MODEL_FEEDBACK, 8, f.b.L0), map, new a());
    }
}
