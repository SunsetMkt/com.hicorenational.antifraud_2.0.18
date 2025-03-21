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
import p388ui.callview.ManualAlreadyDetailView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ManualAlreadyDetailPresenter extends ModelPresent<ManualAlreadyDetailView> {

    /* renamed from: ui.presenter.ManualAlreadyDetailPresenter$a */
    class C7019a extends MiddleSubscriber<APIresult<CheckUserBean>> {
        C7019a() {
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
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((ManualAlreadyDetailView) ManualAlreadyDetailPresenter.this.mvpView).onSuccess(aPIresult.getData());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    public ManualAlreadyDetailPresenter(Activity activity, ManualAlreadyDetailView manualAlreadyDetailView) {
        super(activity, manualAlreadyDetailView);
    }

    public void detail(Long l2) {
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("id", l2);
        manualAlreadyDetail(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f17010I0), hashMap, new C7019a());
    }
}
