package p388ui.presenter;

import android.app.Activity;
import bean.CheckUserBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ManualView;
import p388ui.model.ModelPresent;
import util.C7257b1;

/* loaded from: classes2.dex */
public class ManualPresenter extends ModelPresent<ManualView> {

    /* renamed from: ui.presenter.ManualPresenter$a */
    class C7026a extends MiddleSubscriber<APIresult<CheckUserBean>> {
        C7026a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            ((ManualView) ManualPresenter.this.mvpView).onfail("");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ManualView) ManualPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public ManualPresenter(Activity activity, ManualView manualView) {
        super(activity, manualView);
    }

    public void getAuditinfoHttp(HashMap<String, String> hashMap) {
        getAuditinfo(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f16998E0), hashMap, new C7026a());
    }

    public void getCheckInfo(String str) {
        C7257b1.m26203a("查询中...", true, this.mActivity);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("number", str);
        getAuditinfoHttp(hashMap);
    }
}
