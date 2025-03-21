package p388ui.presenter;

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
import p245d.C4440a;
import p247e.C4445b;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class HelperPresenter extends ModelPresent {
    public static String XY_verification;

    /* renamed from: ui.presenter.HelperPresenter$a */
    class C6994a extends MiddleSubscriber<APIresult<APIH5Bean>> {
        C6994a() {
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

    /* renamed from: ui.presenter.HelperPresenter$b */
    class C6995b extends MiddleSubscriber<APIresult<CheckUserBean>> {

        /* renamed from: a */
        final /* synthetic */ ICheckVerifyListener f24109a;

        C6995b(ICheckVerifyListener iCheckVerifyListener) {
            this.f24109a = iCheckVerifyListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26688a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                this.f24109a.onSuccessVerify(aPIresult.getData());
            }
        }
    }

    public HelperPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    public void checkisverify(ICheckVerifyListener iCheckVerifyListener) {
        checkisverify(C4440a.m16395a("", 1, C4445b.f17036R), new C6995b(iCheckVerifyListener));
    }

    public String getXY_verification() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(XY_verification)) {
            str = C4440a.f16884f + C4445b.f17132v;
        } else {
            str = XY_verification;
        }
        sb.append(str);
        sb.append("?time=");
        sb.append(C4440a.m16411m());
        return sb.toString();
    }

    public void requestVerificationXY() {
        String str = C4440a.f16881c + C4445b.f17099k;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykey", "AnVerificationAgreement");
        requestAppConfig(hashMap, str, new C6994a());
    }

    public HelperPresenter(Context context) {
        super(context, (BaseView) null);
    }
}
