package p388ui.presenter;

import android.app.Activity;
import bean.CriminalRequestBean;
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
public class ReportCriminalPresenter extends ModelPresent<ReporCriminalView> {

    /* renamed from: ui.presenter.ReportCriminalPresenter$a */
    class C7069a extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ boolean f24258a;

        C7069a(boolean z) {
            this.f24258a = z;
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
            } else if (this.f24258a) {
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
        reportCriminalAdd(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17116p1), criminalRequestBean, new C7069a(z));
    }

    public void reportCriminalAdd(CriminalRequestBean criminalRequestBean, boolean z) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        httpReportCriminalAdd(criminalRequestBean, z);
    }
}
