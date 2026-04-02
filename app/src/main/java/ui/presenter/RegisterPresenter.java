package ui.presenter;

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
import ui.activity.MainActivity;
import ui.callview.RegisterlView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.d2;
import util.e2;
import util.f1;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterPresenter extends ModelPresent<RegisterlView> {
    private CodeCutTimeTextView mCodeTimer;

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
            RegisterPresenter.this.mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            e2.a("\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u67e5\u6536");
            if (RegisterPresenter.this.mCodeTimer != null) {
                RegisterPresenter.this.mCodeTimer.a(RegisterPresenter.this.mActivity, aPIresult.getData().intValue());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            f1.a("\u8bf7\u7a0d\u7b49", true, RegisterPresenter.this.mActivity);
            RegisterPresenter.this.mCodeTimer.setEnabled(false);
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
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
        }
    }

    class c extends MiddleSubscriber<APIresult<AccountInfo>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            ((RegisterlView) RegisterPresenter.this.mvpView).onOauthSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            f1.a("\u8bf7\u7a0d\u7b49", true, RegisterPresenter.this.mActivity);
        }
    }

    class d extends MiddleSubscriber<APIresult> {
        final /* synthetic */ AccountInfo a;

        d(AccountInfo accountInfo) {
            this.a = accountInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIresult.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                RegisterPresenter.this.oauthLoginHttp(this.a.getLoginType(), this.a.getOpenId());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            f1.a("\u8bf7\u7a0d\u7b49", true, RegisterPresenter.this.mActivity);
        }
    }

    class e extends MiddleSubscriber<APIresult<AccountInfo>> {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f14372b;

        e(int i2, String str) {
            this.a = i2;
            this.f14372b = str;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            RegisterPresenter.this.onOauthLoginSuccRequest(aPIresult, this.a, this.f14372b);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            super.onStartMiddle(cVar);
        }
    }

    public RegisterPresenter(Activity activity, RegisterlView registerlView) {
        super(activity, registerlView);
    }

    private void oauthBindAccountHttp(HashMap<String, String> map) {
        requestPhoneCode(e.a.f10139c + f.b.r, map, new c());
    }

    private void registerHttp(HashMap<String, String> map) {
        registerHttp(map, e.a.b("", 1, f.b.F), new b());
    }

    private void verificationHttp(int i2, HashMap<String, String> map) {
        String strB;
        if (i2 == 5) {
            strB = e.a.f10139c + f.b.D;
        } else {
            strB = e.a.b("", 2, f.b.D);
        }
        requestPhoneCodeTime(strB, map, new a());
    }

    public void oauthBindAccount(String str, String str2, String str3, int i2, String str4) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phoneNum", str);
        map.put("smsVerifyCode", str2);
        map.put("region", str3);
        map.put("unionLoginType", i2 + "");
        map.put("openId", str4 + "");
        oauthBindAccountHttp(map);
    }

    public void oauthLoginHttp(int i2, String str) {
        HashMap map = new HashMap();
        map.put("loginType", "2");
        map.put("unionLoginType", i2 + "");
        map.put("openId", str);
        requestPhoneCode(e.a.f10139c + f.b.f10195n, map, new e(i2, str));
    }

    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        if (aPIresult.getCode() != 0) {
            e2.a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(i2);
        data.setOpenId(str);
        data.setVisiblePhone("");
        AccountManager.saveAccount(data);
        g2.a((Context) this.mActivity, (Class<?>) MainActivity.class);
        receiver.e.a(data.getTags());
    }

    public void principalHttp(RegisterBody registerBody) {
        f1.a("\u8bf7\u7a0d\u7b49...", true, this.mActivity);
        registerHttp(JNIHandStamp.getInstance().pamramToMap(registerBody));
    }

    public void silentlyreg(AccountInfo accountInfo) {
        HashMap map = new HashMap();
        map.put("mobileNumber", accountInfo.getPhoneNum());
        map.put("region", RegionConfigHttp.getNodeRegionId());
        map.put("openId", accountInfo.getOpenId());
        map.put("loginType", accountInfo.getLoginType() + "");
        map.put("AppVersion", d2.o());
        map.put("IMEI", d2.l());
        map.put("OS", "0");
        map.put("OSVersion", d2.i());
        silentlyreg(e.a.b("", 1, f.b.s), map, new d(accountInfo));
    }

    public void verificationSubmit(int i2, String str, CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i2 + "");
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        verificationHttp(i2, map);
    }
}
