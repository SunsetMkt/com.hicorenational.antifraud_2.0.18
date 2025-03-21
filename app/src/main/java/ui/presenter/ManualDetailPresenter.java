package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ManualDetailView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class ManualDetailPresenter extends ModelPresent<ManualDetailView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((ManualDetailView) ManualDetailPresenter.this.mvpView).onSuccess();
                return;
            }
            if (aPIresult.getCode() == 3) {
                ((ManualDetailView) ManualDetailPresenter.this.mvpView).onSuccessOverrun();
            } else if (aPIresult.getCode() == 4) {
                b1.b(ManualDetailPresenter.this.mActivity, aPIresult.getMsg(), "确定", null);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() != 0 && aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ManualDetailView) ManualDetailPresenter.this.mvpView).onSuccessUnbind();
                w1.a(aPIresult.getMsg());
            }
        }
    }

    public ManualDetailPresenter(Activity activity, ManualDetailView manualDetailView) {
        super(activity, manualDetailView);
    }

    private void submitauditHttp(HashMap<String, String> hashMap) {
        submitaudit(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.F0), hashMap, new a());
    }

    public void submitaudit(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("TelNumber", str2);
        hashMap.put("auditStatus", str);
        hashMap.put("auditMessage", str3);
        submitauditHttp(hashMap);
    }

    public void unbind(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("TelNumber", str2);
        hashMap.put("auditStatus", str);
        hashMap.put("auditMessage", str3);
        postOperation(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.G0), hashMap, new b());
    }
}
