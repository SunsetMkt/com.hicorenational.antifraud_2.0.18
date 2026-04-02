package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bean.APIH5Bean;
import bean.CheckUserBean;
import interfaces.ICheckVerifyListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class HelperPresenter extends ModelPresent {
    public static String XY_verification;

    class a extends MiddleSubscriber<APIresult<APIH5Bean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                return;
            }
            String value = aPIresult.getData().getValue();
            if (TextUtils.isEmpty(value)) {
                return;
            }
            HelperPresenter.XY_verification = value;
        }
    }

    class b extends MiddleSubscriber<APIresult<CheckUserBean>> {
        final /* synthetic */ ICheckVerifyListener a;

        b(ICheckVerifyListener iCheckVerifyListener) {
            this.a = iCheckVerifyListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                this.a.onSuccessVerify(aPIresult.getData());
            }
        }
    }

    public HelperPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    public void checkisverify(ICheckVerifyListener iCheckVerifyListener) {
        checkisverify(e.a.b("", 1, f.b.S), new b(iCheckVerifyListener));
    }

    public String getXY_verification() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(XY_verification)) {
            str = e.a.f10142f + f.b.w;
        } else {
            str = XY_verification;
        }
        sb.append(str);
        sb.append("?time=");
        sb.append(e.a.m());
        return sb.toString();
    }

    public void requestVerificationXY() {
        String str = e.a.f10139c + f.b.f10192k;
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykey", "AnVerificationAgreement");
        requestAppConfig(map, str, new a());
    }

    public HelperPresenter(Context context) {
        super(context, (BaseView) null);
    }
}
