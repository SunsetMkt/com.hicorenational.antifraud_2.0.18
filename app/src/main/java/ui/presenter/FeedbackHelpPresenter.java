package ui.presenter;

import android.app.Activity;
import bean.QATypeBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.FeedbackHelpCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackHelpPresenter extends ModelPresent<FeedbackHelpCallView> {

    class a extends MiddleSubscriber<APIresult<List<QATypeBean>>> {

        /* JADX INFO: renamed from: ui.presenter.FeedbackHelpPresenter$a$a */
        class C0303a extends com.google.gson.d0.a<List<QATypeBean>> {
            C0303a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0303a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<QATypeBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else if (aPIresult.getData() != null) {
                ((FeedbackHelpCallView) FeedbackHelpPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            } else {
                e2.a("\u8bf7\u91cd\u8bd5");
            }
        }
    }

    public FeedbackHelpPresenter(Activity activity, FeedbackHelpCallView feedbackHelpCallView) {
        super(activity, feedbackHelpCallView);
    }

    public void getQAList() {
        requestQAList(e.a.b(ModuelConfig.MODEL_FEEDBACK, 8, f.b.K0), new a());
    }
}
