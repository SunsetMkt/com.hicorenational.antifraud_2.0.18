package ui.presenter;

import android.app.Activity;
import bean.PolicBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.PoliceLoginCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class PoliceLoginPresenter extends ModelPresent<PoliceLoginCallView> {
    private Activity mActivity;

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
            ((PoliceLoginCallView) PoliceLoginPresenter.this.mvpView).onSendFailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((PoliceLoginCallView) PoliceLoginPresenter.this.mvpView).onSendSuccessRequest();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<PolicBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return PolicBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<PolicBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((PoliceLoginCallView) PoliceLoginPresenter.this.mvpView).onVerifySuccessRequest(aPIresult.getData());
            }
        }
    }

    public PoliceLoginPresenter(Activity activity, PoliceLoginCallView policeLoginCallView) {
        super(activity, policeLoginCallView);
        this.mActivity = activity;
    }

    private void sendSmsHttp(HashMap<String, String> hashMap) {
        postOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 2, e.b.M0), hashMap, new a());
    }

    private void smsVerifyHttp(HashMap<String, String> hashMap) {
        policLogintion(d.a.a(ModuelConfig.MODEL_CASEXC, 8, e.b.O0), hashMap, new b());
    }

    public void sendSms(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("telnumber", str);
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        sendSmsHttp(hashMap);
    }

    public void smsVerify(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("telnumber", str);
        hashMap.put("smsCode", str2);
        smsVerifyHttp(hashMap);
    }
}
