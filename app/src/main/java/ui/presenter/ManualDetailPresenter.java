package ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ManualDetailView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class ManualDetailPresenter extends ModelPresent<ManualDetailView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            e2.e(aPIException.getMessage());
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
                f1.b(ManualDetailPresenter.this.mActivity, aPIresult.getMsg(), "\u786e\u5b9a", null);
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
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() != 0 && aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ManualDetailView) ManualDetailPresenter.this.mvpView).onSuccessUnbind();
                e2.a(aPIresult.getMsg());
            }
        }
    }

    public ManualDetailPresenter(Activity activity, ManualDetailView manualDetailView) {
        super(activity, manualDetailView);
    }

    private void submitauditHttp(HashMap<String, String> map) {
        submitaudit(e.a.b(ModuelConfig.MODEL_MANUAL, 8, f.b.G0), map, new a());
    }

    public void submitaudit(String str, String str2, String str3) {
        HashMap<String, String> map = new HashMap<>();
        map.put("TelNumber", str2);
        map.put("auditStatus", str);
        map.put("auditMessage", str3);
        submitauditHttp(map);
    }

    public void unbind(String str, String str2, String str3) {
        HashMap<String, String> map = new HashMap<>();
        map.put("TelNumber", str2);
        map.put("auditStatus", str);
        map.put("auditMessage", str3);
        postOperation(e.a.b(ModuelConfig.MODEL_MANUAL, 8, f.b.H0), map, new b());
    }
}
