package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.activity.MainActivity;
import p388ui.callview.RegisterlView;
import p388ui.model.ModelPresent;
import p388ui.view.CodeCutTimeTextView;
import receiver.C6088e;
import util.C7257b1;
import util.C7328v1;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class RegisterPresenter extends ModelPresent<RegisterlView> {
    private CodeCutTimeTextView mCodeTimer;

    /* renamed from: ui.presenter.RegisterPresenter$a */
    class C7049a extends MiddleSubscriber<APIresult<Integer>> {
        C7049a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            RegisterPresenter.this.mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            C7331w1.m26688a("验证码已发送，请查收");
            if (RegisterPresenter.this.mCodeTimer != null) {
                RegisterPresenter.this.mCodeTimer.m25756a(RegisterPresenter.this.mActivity, aPIresult.getData().intValue());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            C7257b1.m26203a("请稍等", true, RegisterPresenter.this.mActivity);
            RegisterPresenter.this.mCodeTimer.setEnabled(false);
        }
    }

    /* renamed from: ui.presenter.RegisterPresenter$b */
    class C7050b extends MiddleSubscriber<APIresult<AccountInfo>> {
        C7050b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
        }
    }

    /* renamed from: ui.presenter.RegisterPresenter$c */
    class C7051c extends MiddleSubscriber<APIresult<AccountInfo>> {
        C7051c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onOauthSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            C7257b1.m26203a("请稍等", true, RegisterPresenter.this.mActivity);
        }
    }

    /* renamed from: ui.presenter.RegisterPresenter$d */
    class C7052d extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ AccountInfo f24211a;

        C7052d(AccountInfo accountInfo) {
            this.f24211a = accountInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIresult.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                RegisterPresenter.this.oauthLoginHttp(this.f24211a.getLoginType(), this.f24211a.getOpenId());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            C7257b1.m26203a("请稍等", true, RegisterPresenter.this.mActivity);
        }
    }

    /* renamed from: ui.presenter.RegisterPresenter$e */
    class C7053e extends MiddleSubscriber<APIresult<AccountInfo>> {

        /* renamed from: a */
        final /* synthetic */ int f24213a;

        /* renamed from: b */
        final /* synthetic */ String f24214b;

        C7053e(int i2, String str) {
            this.f24213a = i2;
            this.f24214b = str;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            RegisterPresenter.this.onOauthLoginSuccRequest(aPIresult, this.f24213a, this.f24214b);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            super.onStartMiddle(interfaceC4552c);
        }
    }

    public RegisterPresenter(Activity activity, RegisterlView registerlView) {
        super(activity, registerlView);
    }

    private void oauthBindAccountHttp(HashMap<String, String> hashMap) {
        requestPhoneCode(C4440a.f16881c + C4445b.f17117q, hashMap, new C7051c());
    }

    private void registerHttp(HashMap<String, String> hashMap) {
        registerHttp(hashMap, C4440a.m16395a("", 1, C4445b.f16997E), new C7050b());
    }

    private void verificationHttp(int i2, HashMap<String, String> hashMap) {
        String m16395a;
        if (i2 == 5) {
            m16395a = C4440a.f16881c + C4445b.f16991C;
        } else {
            m16395a = C4440a.m16395a("", 2, C4445b.f16991C);
        }
        requestPhoneCodeTime(m16395a, hashMap, new C7049a());
    }

    public void oauthBindAccount(String str, String str2, String str3, int i2, String str4) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phoneNum", str);
        hashMap.put("smsVerifyCode", str2);
        hashMap.put("region", str3);
        hashMap.put("unionLoginType", i2 + "");
        hashMap.put("openId", str4 + "");
        oauthBindAccountHttp(hashMap);
    }

    public void oauthLoginHttp(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("loginType", "2");
        hashMap.put("unionLoginType", i2 + "");
        hashMap.put("openId", str);
        requestPhoneCode(C4440a.f16881c + C4445b.f17105m, hashMap, new C7053e(i2, str));
    }

    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        if (aPIresult.getCode() != 0) {
            C7331w1.m26688a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(i2);
        data.setOpenId(str);
        data.setVisiblePhone("");
        AccountManager.saveAccount(data);
        C7337y1.m26748a((Context) this.mActivity, (Class<?>) MainActivity.class);
        C6088e.m25181a(data.getTags());
    }

    public void principalHttp(RegisterBody registerBody) {
        C7257b1.m26203a("请稍等...", true, this.mActivity);
        registerHttp(JNIHandStamp.getInstance().pamramToMap(registerBody));
    }

    public void silentlyreg(AccountInfo accountInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobileNumber", accountInfo.getPhoneNum());
        hashMap.put("region", RegionConfigHttp.getNodeRegionId());
        hashMap.put("openId", accountInfo.getOpenId());
        hashMap.put("loginType", accountInfo.getLoginType() + "");
        hashMap.put("AppVersion", C7328v1.m26678o());
        hashMap.put("IMEI", C7328v1.m26674l());
        hashMap.put("OS", "0");
        hashMap.put("OSVersion", C7328v1.m26668i());
        silentlyreg(C4440a.m16395a("", 1, C4445b.f17120r), hashMap, new C7052d(accountInfo));
    }

    public void verificationSubmit(int i2, String str, CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobilenumber", str);
        hashMap.put("codetype", i2 + "");
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(i2, hashMap);
    }
}
