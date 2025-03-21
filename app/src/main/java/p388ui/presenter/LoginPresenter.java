package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.LoginCallView;
import p388ui.model.ModelPresent;
import util.C7268d1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class LoginPresenter extends ModelPresent<LoginCallView> {
    HashMap<String, String> map;
    private String openId;
    private int platId;

    /* renamed from: ui.presenter.LoginPresenter$a */
    class C7014a extends MiddleSubscriber<APIresult<AccountInfo>> {
        C7014a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((LoginCallView) LoginPresenter.this.mvpView).onLoginSuccRequest(aPIresult);
        }
    }

    /* renamed from: ui.presenter.LoginPresenter$b */
    class C7015b extends MiddleSubscriber<APIresult<AccountInfo>> {
        C7015b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onOathfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            LoginPresenter loginPresenter = LoginPresenter.this;
            ((LoginCallView) loginPresenter.mvpView).onOauthLoginSuccRequest(aPIresult, loginPresenter.platId, LoginPresenter.this.openId);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            super.onStartMiddle(interfaceC4552c);
        }
    }

    public LoginPresenter(Activity activity, LoginCallView loginCallView) {
        super(activity, loginCallView);
    }

    private void loginHttp(HashMap<String, String> hashMap) {
        requestPhoneCode(C4440a.f16881c + C4445b.f17105m, hashMap, new C7014a());
    }

    private void oauthLoginHttp(HashMap<String, String> hashMap) {
        requestPhoneCode(C4440a.f16881c + C4445b.f17105m, hashMap, new C7015b());
    }

    public void loginSubmit(String str, int i2, String str2, String str3) {
        RegisterBody registerBody = new RegisterBody();
        if (str.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            ((LoginCallView) this.mvpView).onfail();
            return;
        }
        registerBody.setPhoneNum(str);
        registerBody.setLoginType(i2);
        if (i2 != 0) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str3)) {
                    C7331w1.m26688a("请输入验证码");
                    ((LoginCallView) this.mvpView).onfail();
                    return;
                }
                registerBody.setSmsVerifyCode(str3);
            }
        } else {
            if (str2.length() < 6 || str2.length() > 16 || C7268d1.m26312a(str2)) {
                C7331w1.m26688a(this.mActivity.getString(C2113R.string.login_pwd));
                ((LoginCallView) this.mvpView).onfail();
                return;
            }
            registerBody.setPassword(str2);
        }
        this.map = JNIHandStamp.getInstance().pamramToMap(registerBody);
        loginHttp(this.map);
    }

    public void oauthLogin(int i2, String str) {
        this.map = new HashMap<>();
        this.map.put("loginType", "2");
        this.map.put("unionLoginType", i2 + "");
        this.map.put("openId", str);
        this.platId = i2;
        this.openId = str;
        oauthLoginHttp(this.map);
    }
}
