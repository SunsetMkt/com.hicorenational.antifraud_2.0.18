package p388ui.presenter;

import android.app.Activity;
import bean.QATypeBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.FeedbackHelpCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class FeedbackHelpPresenter extends ModelPresent<FeedbackHelpCallView> {

    /* renamed from: ui.presenter.FeedbackHelpPresenter$a */
    class C6980a extends MiddleSubscriber<APIresult<List<QATypeBean>>> {

        /* renamed from: ui.presenter.FeedbackHelpPresenter$a$a */
        class a extends C2049a<List<QATypeBean>> {
            a() {
            }
        }

        C6980a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26696e(aPIException.getMessage());
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
                C7331w1.m26688a("请重试");
            }
        }
    }

    public FeedbackHelpPresenter(Activity activity, FeedbackHelpCallView feedbackHelpCallView) {
        super(activity, feedbackHelpCallView);
    }

    public void getQAList() {
        requestQAList(C4440a.m16395a(ModuelConfig.MODEL_FEEDBACK, 8, C4445b.f17013J0), new C6980a());
    }
}
