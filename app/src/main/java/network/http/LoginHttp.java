package network.http;

import android.app.Activity;
import android.text.TextUtils;
import interfaces.IOneClickListener;
import java.lang.reflect.Type;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.C6813c;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7268d1;
import util.C7301n1;

/* loaded from: classes2.dex */
public class LoginHttp extends ModelPresent {
    private static final String TAG = LoginHttp.class.getSimpleName();
    private static LoginHttp loginHttp;
    private IOneClickListener clickListener;
    private Activity mContext;

    private LoginHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static LoginHttp getInstance() {
        if (loginHttp == null) {
            loginHttp = new LoginHttp();
        }
        return loginHttp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentLogin() {
        LoginManager.getInstance().exitToLogin();
    }

    private void loginHttp(final RegisterBody registerBody) {
        loginHttp(C4440a.f16881c + C4445b.f17105m, registerBody, new MiddleSubscriber<APIresult<AccountInfo>>() { // from class: network.http.LoginHttp.1
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return AccountInfo.class;
            }

            @Override // network.MiddleSubscriber
            protected void onCompleteMiddle() {
                C7301n1.m26454a(LoginHttp.TAG, "-->onComplete");
                C7257b1.m26191a();
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                C7301n1.m26454a(LoginHttp.TAG, "-->onError");
                C7257b1.m26191a();
                LoginHttp.this.intentLogin();
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
                C7301n1.m26454a(LoginHttp.TAG, "-->onNext");
                if (aPIresult.getCode() != 0) {
                    LoginHttp.this.intentLogin();
                    return;
                }
                AccountInfo data = aPIresult.getData();
                data.setLoginType(AccountManager.LOGIN_NORMAL);
                AccountManager.saveAccount(data, registerBody.getPhoneNum());
                C6813c.m25437i().m25450e();
                LoginHttp.this.clickListener.clickOKBtn();
            }

            @Override // network.MiddleSubscriber
            protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
                C7301n1.m26454a(LoginHttp.TAG, "-->onSubscribe");
                C7257b1.m26203a("请稍后...", false, LoginHttp.this.mContext);
            }
        });
    }

    public void loginSubmit(Activity activity, String str, String str2, String str3, int i2, IOneClickListener iOneClickListener) {
        this.mContext = activity;
        if (TextUtils.isEmpty(str)) {
            intentLogin();
            return;
        }
        if (i2 == -1) {
            intentLogin();
            return;
        }
        RegisterBody registerBody = new RegisterBody();
        registerBody.setPhoneNum(str);
        registerBody.setLoginType(i2);
        if (i2 != 0) {
            if (i2 != 1) {
                intentLogin();
            } else {
                if (TextUtils.isEmpty(str3)) {
                    intentLogin();
                    return;
                }
                registerBody.setSmsVerifyCode(str3);
            }
        } else {
            if (TextUtils.isEmpty(str2) || str2.length() < 6 || str2.length() > 16 || C7268d1.m26312a(str2)) {
                intentLogin();
                return;
            }
            registerBody.setPassword(str2);
        }
        C7301n1.m26457b("RegisterBody-->", registerBody.toString());
        this.clickListener = iOneClickListener;
        loginHttp(registerBody);
    }
}
