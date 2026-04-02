package ui.presenter;

import android.app.Activity;
import bean.ReportWebsitBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReporCriminalView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class ReportEdWebsitePresenter extends ModelPresent<ReporCriminalView> {

    class a extends MiddleSubscriber<APIresult<String>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                e2.a("\u63d0\u4ea4\u6210\u529f");
                ReportEdWebsitePresenter.this.mActivity.finish();
            }
        }
    }

    public ReportEdWebsitePresenter(Activity activity, ReporCriminalView reporCriminalView) {
        super(activity, reporCriminalView);
    }

    public void surveyAddCaseWebUrl(ReportWebsitBean reportWebsitBean) {
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        reportAddCaseWebUrl(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.a2), reportWebsitBean, new a());
    }
}
