package ui.presenter;

import android.app.Activity;
import bean.CriminalRequestBean;
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
public class ReportCriminalPresenter extends ModelPresent<ReporCriminalView> {

    class a extends MiddleSubscriber<APIresult<String>> {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
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
            } else if (this.a) {
                ((ReporCriminalView) ReportCriminalPresenter.this.mvpView).onSuccessHandle(2, aPIresult.getData());
            } else {
                ((ReporCriminalView) ReportCriminalPresenter.this.mvpView).onSuccessHandle(3, aPIresult.getData());
            }
        }
    }

    public ReportCriminalPresenter(Activity activity, ReporCriminalView reporCriminalView) {
        super(activity, reporCriminalView);
    }

    private void httpReportCriminalAdd(CriminalRequestBean criminalRequestBean, boolean z) {
        reportCriminalAdd(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.q1), criminalRequestBean, new a(z));
    }

    public void reportCriminalAdd(CriminalRequestBean criminalRequestBean, boolean z) {
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        httpReportCriminalAdd(criminalRequestBean, z);
    }
}
