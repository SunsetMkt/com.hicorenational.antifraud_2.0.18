package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.LogoutSmsCodeView;
import p388ui.model.ModelPresent;
import p388ui.view.CodeCutTimeTextView;
import util.C7257b1;
import util.C7331w1;

/* compiled from: LogoutSmsCodePresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, m23546d2 = {"Lui/presenter/LogoutSmsCodePresenter;", "Lui/model/ModelPresent;", "Lui/callview/LogoutSmsCodeView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/LogoutSmsCodeView;)V", "mCodeTimer", "Lui/view/CodeCutTimeTextView;", "getMCodeTimer", "()Lui/view/CodeCutTimeTextView;", "setMCodeTimer", "(Lui/view/CodeCutTimeTextView;)V", "verificationCode", "", "phone", "", "code", "codetype", "", "verificationCodeHttp", "map", "Ljava/util/HashMap;", "verificationHttp", "verificationSubmit", "phoneNum", "verificationType", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutSmsCodePresenter extends ModelPresent<LogoutSmsCodeView> {

    @InterfaceC5817e
    private CodeCutTimeTextView mCodeTimer;

    /* compiled from: LogoutSmsCodePresenter.kt */
    /* renamed from: ui.presenter.LogoutSmsCodePresenter$a */
    public static final class C7017a extends MiddleSubscriber<APIresult<AccountInfo>> {
        C7017a() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
            C5544i0.m22546f(aPIException, "e");
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<AccountInfo> aPIresult) {
            C5544i0.m22546f(aPIresult, "resultInfo");
            if (aPIresult.getCode() == 0) {
                ((LogoutSmsCodeView) LogoutSmsCodePresenter.this.mvpView).onSuccessRequest();
                return;
            }
            APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
            C5544i0.m22521a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
            onErrorMiddle(apiExcept);
        }
    }

    /* compiled from: LogoutSmsCodePresenter.kt */
    /* renamed from: ui.presenter.LogoutSmsCodePresenter$b */
    public static final class C7018b extends MiddleSubscriber<APIresult<Integer>> {
        C7018b() {
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            return Integer.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
            C5544i0.m22546f(aPIException, "e");
            C7331w1.m26688a(aPIException.getMessage());
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer == null) {
                C5544i0.m22545f();
            }
            mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<Integer> aPIresult) {
            C5544i0.m22546f(aPIresult, "resultInfo");
            if (aPIresult.getCode() != 0) {
                APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
                C5544i0.m22521a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
                onErrorMiddle(apiExcept);
                return;
            }
            C7331w1.m26688a("验证码已发送，请查收");
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer != null) {
                Activity activity = LogoutSmsCodePresenter.this.mActivity;
                Integer data = aPIresult.getData();
                C5544i0.m22521a((Object) data, "resultInfo.data");
                mCodeTimer.m25756a(activity, data.intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutSmsCodePresenter(@InterfaceC5816d Activity activity, @InterfaceC5816d LogoutSmsCodeView logoutSmsCodeView) {
        super(activity, logoutSmsCodeView);
        C5544i0.m22546f(activity, "activity");
        C5544i0.m22546f(logoutSmsCodeView, "view");
    }

    private final void verificationCodeHttp(HashMap<String, String> hashMap) {
        requestPhoneCode(C4440a.m16395a("", 1, C4445b.f17003G), hashMap, new C7017a());
    }

    private final void verificationHttp(HashMap<String, String> hashMap) {
        requestPhoneCodeTime(C4440a.m16395a("", 2, C4445b.f16991C), hashMap, new C7018b());
    }

    @InterfaceC5817e
    public final CodeCutTimeTextView getMCodeTimer() {
        return this.mCodeTimer;
    }

    public final void setMCodeTimer(@InterfaceC5817e CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
    }

    public final void verificationCode(@InterfaceC5816d String str, @InterfaceC5816d String str2, int i2) {
        C5544i0.m22546f(str, "phone");
        C5544i0.m22546f(str2, "code");
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
        hashMap.put("codeType", String.valueOf(i2));
        C7257b1.m26203a("加载中...", true, this.mActivity);
        verificationCodeHttp(hashMap);
    }

    public final void verificationSubmit(@InterfaceC5816d String str, int i2, @InterfaceC5817e CodeCutTimeTextView codeCutTimeTextView) {
        C5544i0.m22546f(str, "phoneNum");
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobilenumber", str);
        hashMap.put("codetype", String.valueOf(i2) + "");
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        C5544i0.m22521a((Object) nodeRegionId, "RegionConfigHttp.getNodeRegionId()");
        hashMap.put("areaCode", nodeRegionId);
        verificationHttp(hashMap);
    }
}
