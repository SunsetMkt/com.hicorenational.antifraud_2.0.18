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
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
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
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                e2.a("\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u67e5\u6536");
                ((ResetPwdView) ResetPwdPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            }
        }
    }

    public ResetPwdPresenter(Activity activity, ResetPwdView resetPwdView) {
        super(activity, resetPwdView);
    }

    private void verificationHttp(HashMap<String, String> map) {
        requestPhoneCodeTime(e.a.f10139c + f.b.D, map, new a());
    }

    public void verificationSubmit(int i2, String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i2 + "");
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(map);
    }
}
