package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ManualDetailView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ManualDetailPresenter extends ModelPresent<ManualDetailView> {

    /* renamed from: ui.presenter.ManualDetailPresenter$a */
    class C7022a extends MiddleSubscriber<APIresult> {
        C7022a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
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
                C7257b1.m26210b(ManualDetailPresenter.this.mActivity, aPIresult.getMsg(), "确定", null);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    /* renamed from: ui.presenter.ManualDetailPresenter$b */
    class C7023b extends MiddleSubscriber<APIresult> {
        C7023b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() != 0 && aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ManualDetailView) ManualDetailPresenter.this.mvpView).onSuccessUnbind();
                C7331w1.m26688a(aPIresult.getMsg());
            }
        }
    }

    public ManualDetailPresenter(Activity activity, ManualDetailView manualDetailView) {
        super(activity, manualDetailView);
    }

    private void submitauditHttp(HashMap<String, String> hashMap) {
        submitaudit(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f17001F0), hashMap, new C7022a());
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
        postOperation(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f17004G0), hashMap, new C7023b());
    }
}
