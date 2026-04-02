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
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
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
            e2.e(aPIException.getMessage());
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
            e2.e(aPIException.getMessage());
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

    private void sendSmsHttp(HashMap<String, String> map) {
        postOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 2, f.b.N0), map, new a());
    }

    private void smsVerifyHttp(HashMap<String, String> map) {
        policLogintion(e.a.b(ModuelConfig.MODEL_CASEXC, 8, f.b.P0), map, new b());
    }

    public void sendSms(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("telnumber", str);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        sendSmsHttp(map);
    }

    public void smsVerify(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("telnumber", str);
        map.put("smsCode", str2);
        smsVerifyHttp(map);
    }
}
