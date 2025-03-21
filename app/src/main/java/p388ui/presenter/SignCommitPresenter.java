package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import java.util.Map;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ReportCommitView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SignCommitPresenter extends ModelPresent<ReportCommitView> {

    /* renamed from: ui.presenter.SignCommitPresenter$a */
    class C7086a extends MiddleSubscriber<APIresult> {
        C7086a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportCommitView) SignCommitPresenter.this.mvpView).onSuccessHandle();
            }
        }
    }

    public SignCommitPresenter(Activity activity, ReportCommitView reportCommitView) {
        super(activity, reportCommitView);
    }

    public void comitCaseInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        comitCaseInfoHttp(hashMap);
    }

    public void comitCaseInfoHttp(Map<String, String> map) {
        reportConfirm(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17074c2), map, new C7086a());
    }
}
