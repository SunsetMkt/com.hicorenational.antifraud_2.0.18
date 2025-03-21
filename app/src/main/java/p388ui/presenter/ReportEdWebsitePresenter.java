package p388ui.presenter;

import android.app.Activity;
import bean.ReportWebsitBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ReporCriminalView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportEdWebsitePresenter extends ModelPresent<ReporCriminalView> {

    /* renamed from: ui.presenter.ReportEdWebsitePresenter$a */
    class C7070a extends MiddleSubscriber<APIresult<String>> {
        C7070a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                C7331w1.m26688a("提交成功");
                ReportEdWebsitePresenter.this.mActivity.finish();
            }
        }
    }

    public ReportEdWebsitePresenter(Activity activity, ReporCriminalView reporCriminalView) {
        super(activity, reporCriminalView);
    }

    public void surveyAddCaseWebUrl(ReportWebsitBean reportWebsitBean) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        reportAddCaseWebUrl(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17062Z1), reportWebsitBean, new C7070a());
    }
}
