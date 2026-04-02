package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import ui.callview.LoginCallView;
import ui.model.ModelPresent;
import util.e2;
import util.h1;

/* JADX INFO: loaded from: classes2.dex */
public class LoginPresenter extends ModelPresent<LoginCallView> {
    HashMap<String, String> map;
    private String openId;
    private int platId;

    class a extends MiddleSubscriber<APIresult<AccountInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((LoginCallView) LoginPresenter.this.mvpView).onLoginSuccRequest(aPIresult);
        }
    }

    class b extends MiddleSubscriber<APIresult<AccountInfo>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((LoginCallView) LoginPresenter.this.mvpView).onOathfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            LoginPresenter loginPresenter = LoginPresenter.this;
            ((LoginCallView) loginPresenter.mvpView).onOauthLoginSuccRequest(aPIresult, loginPresenter.platId, LoginPresenter.this.openId);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    public LoginPresenter(Activity activity, LoginCallView loginCallView) {
        super(activity, loginCallView);
    }

    private void loginHttp(HashMap<String, String> map) {
        requestPhoneCode(e.a.f10139c + f.b.f10195n, map, new a());
    }

    private void oauthLoginHttp(HashMap<String, String> map) {
        requestPhoneCode(e.a.f10139c + f.b.f10195n, map, new b());
    }

    public void loginSubmit(String str, int i2, String str2, String str3) {
        RegisterBody registerBody = new RegisterBody();
        if (str.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            ((LoginCallView) this.mvpView).onfail();
            return;
        }
        registerBody.setPhoneNum(str);
        registerBody.setLoginType(i2);
        if (i2 != 0) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str3)) {
                    e2.a("\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801");
                    ((LoginCallView) this.mvpView).onfail();
                    return;
                }
                registerBody.setSmsVerifyCode(str3);
            }
        } else {
            if (str2.length() < 6 || str2.length() > 16 || h1.a(str2)) {
                e2.a(this.mActivity.getString(R.string.login_pwd));
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
