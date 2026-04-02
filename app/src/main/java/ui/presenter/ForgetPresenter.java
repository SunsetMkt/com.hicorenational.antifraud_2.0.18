package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import ui.callview.ForgetPwdCallView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.e2;
import util.f1;
import util.h1;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class ForgetPresenter extends ModelPresent<ForgetPwdCallView> {
    private int fromType;
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
            if (ForgetPresenter.this.mCodeTimer != null) {
                ForgetPresenter.this.mCodeTimer.setEnabled(true);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            e2.a("\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u67e5\u6536");
            if (ForgetPresenter.this.fromType == p1.J) {
                ForgetPresenter.this.mCodeTimer.a(ForgetPresenter.this.mActivity, aPIresult.getData().intValue());
            } else if (ForgetPresenter.this.fromType == 3) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            } else {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            if (ForgetPresenter.this.mCodeTimer != null) {
                ForgetPresenter.this.mCodeTimer.setEnabled(false);
            }
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
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AccountInfo> aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
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
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<AccountInfo>> {
        d() {
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
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onChangeMobileSuccRequest();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class e extends MiddleSubscriber<APIresult> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccessLoginOut();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccessLoginOut();
        }
    }

    public ForgetPresenter(Activity activity, ForgetPwdCallView forgetPwdCallView) {
        super(activity, forgetPwdCallView);
    }

    private void changeMobileHttp(HashMap<String, String> map, boolean z) {
        requestPhoneCode(e.a.b("", 1, f.b.G), map, new d());
    }

    private void resetPwdHttp(HashMap<String, String> map, boolean z) {
        requestPhoneCode(e.a.f10139c + f.b.p, map, new c());
    }

    private void verificationCodeHttp(HashMap<String, String> map) {
        requestPhoneCode(e.a.f10139c + f.b.H, map, new b());
    }

    private void verificationHttp(HashMap<String, String> map, int i2) {
        String strB;
        if (i2 == 3) {
            strB = e.a.f10139c + f.b.D;
        } else {
            strB = e.a.b("", 2, f.b.D);
        }
        requestPhoneCodeTime(strB, map, new a());
    }

    public void changeMobileSubmit(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", str);
        map.put("smsVerifyCode", str2);
        f1.a("\u52a0\u8f7d\u4e2d...", true, this.mActivity);
        changeMobileHttp(map, true);
    }

    public void requestLoginOut() {
        f1.a("\u9000\u51fa\u4e2d...", true, this.mActivity);
        requestLoginOut(e.a.b("", 1, f.b.I), new e());
    }

    public void resetPwd(String str, String str2, String str3) {
        if (str3.length() < 6 || str3.length() > 16 || h1.a(str3)) {
            e2.a(this.mActivity.getString(R.string.login_pwd));
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobileNumber", str);
        map.put("smsVerifyCode", str2);
        map.put("newPWD", str3);
        resetPwdHttp(map, true);
    }

    public void verificationCode(String str, String str2) {
        if (str.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            e2.a("\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("code", str2);
        map.put("mobileNumber", str);
        map.put("codeType", "3");
        f1.a("\u52a0\u8f7d\u4e2d...", true, this.mActivity);
        verificationCodeHttp(map);
    }

    public void verificationResetPhone(String str, int i2) {
        verificationSubmit(str, i2, 4, null);
    }

    public void verificationSubmit(String str, int i2) {
        verificationSubmit(str, i2, 3, null);
    }

    public void verificationSubmit(String str, int i2, int i3, CodeCutTimeTextView codeCutTimeTextView) {
        this.fromType = i2;
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", i3 + "");
        map.put("areaCode", AccountManager.getRegisterRegionCode());
        verificationHttp(map, i3);
    }
}
