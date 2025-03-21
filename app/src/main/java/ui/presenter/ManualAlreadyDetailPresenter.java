package ui.presenter;

import android.app.Activity;
import bean.CheckUserBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ManualAlreadyDetailView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ManualAlreadyDetailPresenter extends ModelPresent<ManualAlreadyDetailView> {

    class a extends MiddleSubscriber<APIresult<CheckUserBean>> {
        a() {
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
            w1.e(aPIException.getMessage());
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
        manualAlreadyDetail(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.I0), hashMap, new a());
    }
}
