package ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.ResetPwdView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ResetPwdPresenter extends ModelPresent<ResetPwdView> {

    class a extends MiddleSubscriber<APIresult<Integer>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                w1.a("验证码已发送，请查收");
                ((ResetPwdView) ResetPwdPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            }
        }
    }

    public ResetPwdPresenter(Activity activity, ResetPwdView resetPwdView) {
        super(activity, resetPwdView);
    }

    private void verificationHttp(HashMap<String, String> hashMap) {
        requestPhoneCodeTime(d.a.f13517c + e.b.C, hashMap, new a());
    }

    public void verificationSubmit(int i2, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobilenumber", str);
        hashMap.put("codetype", i2 + "");
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(hashMap);
    }
}
