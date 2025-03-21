package p388ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ResetPwdView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ResetPwdPresenter extends ModelPresent<ResetPwdView> {

    /* renamed from: ui.presenter.ResetPwdPresenter$a */
    class C7080a extends MiddleSubscriber<APIresult<Integer>> {
        C7080a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                C7331w1.m26688a("验证码已发送，请查收");
                ((ResetPwdView) ResetPwdPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            }
        }
    }

    public ResetPwdPresenter(Activity activity, ResetPwdView resetPwdView) {
        super(activity, resetPwdView);
    }

    private void verificationHttp(HashMap<String, String> hashMap) {
        requestPhoneCodeTime(C4440a.f16881c + C4445b.f16991C, hashMap, new C7080a());
    }

    public void verificationSubmit(int i2, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobilenumber", str);
        hashMap.put("codetype", i2 + "");
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(hashMap);
    }
}
