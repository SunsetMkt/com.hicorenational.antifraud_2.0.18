package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import bean.AppSignBean;
import bean.AppVirusBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.Hicore;
import p388ui.callview.VirusKillingCallView;
import p388ui.model.ModelPresent;
import util.C7316r1;
import util.C7328v1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class VirusKillingPresenter extends ModelPresent<VirusKillingCallView> {

    /* renamed from: ui.presenter.VirusKillingPresenter$a */
    class C7110a extends MiddleSubscriber<APIresult> {
        C7110a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((VirusKillingCallView) VirusKillingPresenter.this.mvpView).onAppealSuccess();
                    return;
                }
                C7331w1.m26688a(aPIresult.getMsg());
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public VirusKillingPresenter(Activity activity, VirusKillingCallView virusKillingCallView) {
        super(activity, virusKillingCallView);
    }

    private void appealAppHttp(List<AppVirusBean> list) {
        appOperation(C4440a.m16395a(ModuelConfig.MODEL_WARN, 5, C4445b.f17097j0), list, new C7110a());
    }

    private void setSign(List<AppVirusBean> list) {
        for (AppVirusBean appVirusBean : list) {
            appVirusBean.setUseMobileNumber(C7328v1.m26670j());
            getSignVirus(appVirusBean);
        }
    }

    public void appealApp(List<AppVirusBean> list) {
        for (AppVirusBean appVirusBean : list) {
            appVirusBean.setUseMobileNumber(C7328v1.m26670j());
            getSignVirus(appVirusBean);
        }
        appealAppHttp(list);
    }

    public void getSignVirus(AppVirusBean appVirusBean) {
        AppSignBean m26549d;
        if (appVirusBean == null || (m26549d = C7316r1.m26549d(appVirusBean.getPkgName(), appVirusBean.getFilePath())) == null) {
            return;
        }
        appVirusBean.setSignMD5(m26549d.getSignMD5());
        appVirusBean.setSignSha1(m26549d.getSignSha1());
        appVirusBean.setSignSha256(m26549d.getSignSha256());
    }

    public VirusKillingPresenter(Context context, VirusKillingCallView virusKillingCallView) {
        super(context, virusKillingCallView);
    }
}
