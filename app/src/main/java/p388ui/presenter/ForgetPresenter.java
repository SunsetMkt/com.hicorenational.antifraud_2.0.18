package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.ForgetPwdCallView;
import p388ui.model.ModelPresent;
import p388ui.view.CodeCutTimeTextView;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ForgetPresenter extends ModelPresent<ForgetPwdCallView> {
    private int fromType;
    private CodeCutTimeTextView mCodeTimer;

    /* renamed from: ui.presenter.ForgetPresenter$a */
    class C6983a extends MiddleSubscriber<APIresult<Integer>> {
        C6983a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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
            C7331w1.m26688a("验证码已发送，请查收");
            if (ForgetPresenter.this.fromType == C7292k1.f25351J) {
                ForgetPresenter.this.mCodeTimer.m25756a(ForgetPresenter.this.mActivity, aPIresult.getData().intValue());
            } else if (ForgetPresenter.this.fromType == 3) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(aPIresult.getData().intValue());
            } else {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            if (ForgetPresenter.this.mCodeTimer != null) {
                ForgetPresenter.this.mCodeTimer.setEnabled(false);
            }
        }
    }

    /* renamed from: ui.presenter.ForgetPresenter$b */
    class C6984b extends MiddleSubscriber<APIresult<AccountInfo>> {
        C6984b() {
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
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.ForgetPresenter$c */
    class C6985c extends MiddleSubscriber<APIresult<AccountInfo>> {
        C6985c() {
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
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onSuccRequest(0);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.ForgetPresenter$d */
    class C6986d extends MiddleSubscriber<APIresult<AccountInfo>> {
        C6986d() {
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
            if (aPIresult.getCode() == 0) {
                ((ForgetPwdCallView) ForgetPresenter.this.mvpView).onChangeMobileSuccRequest();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.ForgetPresenter$e */
    class C6987e extends MiddleSubscriber<APIresult> {
        C6987e() {
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

    private void changeMobileHttp(HashMap<String, String> hashMap, boolean z) {
        requestPhoneCode(C4440a.m16395a("", 1, C4445b.f17000F), hashMap, new C6986d());
    }

    private void resetPwdHttp(HashMap<String, String> hashMap, boolean z) {
        requestPhoneCode(C4440a.f16881c + C4445b.f17111o, hashMap, new C6985c());
    }

    private void verificationCodeHttp(HashMap<String, String> hashMap) {
        requestPhoneCode(C4440a.f16881c + C4445b.f17003G, hashMap, new C6984b());
    }

    private void verificationHttp(HashMap<String, String> hashMap, int i2) {
        String m16395a;
        if (i2 == 3) {
            m16395a = C4440a.f16881c + C4445b.f16991C;
        } else {
            m16395a = C4440a.m16395a("", 2, C4445b.f16991C);
        }
        requestPhoneCodeTime(m16395a, hashMap, new C6983a());
    }

    public void changeMobileSubmit(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile", str);
        hashMap.put("smsVerifyCode", str2);
        C7257b1.m26203a("加载中...", true, this.mActivity);
        changeMobileHttp(hashMap, true);
    }

    public void requestLoginOut() {
        C7257b1.m26203a("退出中...", true, this.mActivity);
        requestLoginOut(C4440a.m16395a("", 1, C4445b.f17006H), new C6987e());
    }

    public void resetPwd(String str, String str2, String str3) {
        if (str3.length() < 6 || str3.length() > 16 || C7268d1.m26312a(str3)) {
            C7331w1.m26688a(this.mActivity.getString(C2113R.string.login_pwd));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobileNumber", str);
        hashMap.put("smsVerifyCode", str2);
        hashMap.put("newPWD", str3);
        resetPwdHttp(hashMap, true);
    }

    public void verificationCode(String str, String str2) {
        if (str.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            C7331w1.m26688a("请输入验证码");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("code", str2);
        hashMap.put("mobileNumber", str);
        hashMap.put("codeType", "3");
        C7257b1.m26203a("加载中...", true, this.mActivity);
        verificationCodeHttp(hashMap);
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
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobilenumber", str);
        hashMap.put("codetype", i3 + "");
        hashMap.put("areaCode", AccountManager.getRegisterRegionCode());
        verificationHttp(hashMap, i3);
    }
}
