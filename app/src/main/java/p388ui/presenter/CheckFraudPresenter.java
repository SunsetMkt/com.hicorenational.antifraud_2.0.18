package p388ui.presenter;

import android.app.Activity;
import bean.APIH5Bean;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CheckFraudCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CheckFraudPresenter extends ModelPresent<CheckFraudCallView> {

    /* renamed from: ui.presenter.CheckFraudPresenter$a */
    class C6949a extends MiddleSubscriber<APIresult<APIH5Bean>> {
        C6949a() {
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
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessShareConfig(aPIresult.getData());
        }
    }

    /* renamed from: ui.presenter.CheckFraudPresenter$b */
    class C6950b extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        C6950b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    /* renamed from: ui.presenter.CheckFraudPresenter$c */
    class C6951c extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        C6951c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26696e(aPIException.getMessage());
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    /* renamed from: ui.presenter.CheckFraudPresenter$d */
    class C6952d extends MiddleSubscriber<APIresult<CheckFraudBean>> {
        C6952d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null) {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequest(aPIresult);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    /* renamed from: ui.presenter.CheckFraudPresenter$e */
    class C6953e extends MiddleSubscriber<APIresult<CheckFraudCountBean>> {
        C6953e() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckFraudCountBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckFraudCountBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CheckFraudCallView) CheckFraudPresenter.this.mvpView).onSuccessRequestCount(aPIresult.getData());
            }
        }
    }

    public CheckFraudPresenter(Activity activity, CheckFraudCallView checkFraudCallView) {
        super(activity, checkFraudCallView);
    }

    private void checkFraudIpUrlHttp(HashMap<String, String> hashMap) {
        checkFraudIpUrl(hashMap, C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f17145z0), new C6951c());
    }

    public void checkFraud(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f17136w0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("CardNumber", str);
        requestCheckFraud(m16395a, hashMap, new C6950b());
    }

    public void checkFraudChat(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f17142y0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accountNumber", str);
        requestCheckFraud(m16395a, hashMap, new C6952d());
    }

    public void checkFraudCount(int i2) {
        requestCheckFraudCount(i2 == 1 ? C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f16986A0) : i2 == 2 ? C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f16989B0) : C4440a.m16395a(ModuelConfig.MODEL_FRAUDCHECK, 7, C4445b.f17139x0), new C6953e());
    }

    public void checkFraudIpUrl(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content", str);
        checkFraudIpUrlHttp(hashMap);
    }

    public void requestShareConfig() {
        String str = C4440a.f16881c + C4445b.f17099k;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykey", "CheckShare");
        requestAppConfig(hashMap, str, new C6949a());
    }
}
