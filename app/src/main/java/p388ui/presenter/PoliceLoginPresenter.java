package p388ui.presenter;

import android.app.Activity;
import bean.PolicBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.PoliceLoginCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class PoliceLoginPresenter extends ModelPresent<PoliceLoginCallView> {
    private Activity mActivity;

    /* renamed from: ui.presenter.PoliceLoginPresenter$a */
    class C7038a extends MiddleSubscriber<APIresult> {
        C7038a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
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

    /* renamed from: ui.presenter.PoliceLoginPresenter$b */
    class C7039b extends MiddleSubscriber<APIresult<PolicBean>> {
        C7039b() {
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
            C7331w1.m26696e(aPIException.getMessage());
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
        postOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 2, C4445b.f17022M0), hashMap, new C7038a());
    }

    private void smsVerifyHttp(HashMap<String, String> hashMap) {
        policLogintion(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 8, C4445b.f17028O0), hashMap, new C7039b());
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
