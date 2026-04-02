package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import ui.callview.LogoutSmsCodeView;
import ui.model.ModelPresent;
import ui.view.CodeCutTimeTextView;
import util.e2;
import util.f1;

/* JADX INFO: compiled from: LogoutSmsCodePresenter.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lui/presenter/LogoutSmsCodePresenter;", "Lui/model/ModelPresent;", "Lui/callview/LogoutSmsCodeView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/LogoutSmsCodeView;)V", "mCodeTimer", "Lui/view/CodeCutTimeTextView;", "getMCodeTimer", "()Lui/view/CodeCutTimeTextView;", "setMCodeTimer", "(Lui/view/CodeCutTimeTextView;)V", "verificationCode", "", "phone", "", "code", "codetype", "", "verificationCodeHttp", "map", "Ljava/util/HashMap;", "verificationHttp", "verificationSubmit", "phoneNum", "verificationType", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class LogoutSmsCodePresenter extends ModelPresent<LogoutSmsCodeView> {

    @j.c.a.e
    private CodeCutTimeTextView mCodeTimer;

    /* JADX INFO: compiled from: LogoutSmsCodePresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<AccountInfo>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        @j.c.a.d
        protected Type getType() {
            return AccountInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@j.c.a.d APIException aPIException) {
            i.q2.t.i0.f(aPIException, "e");
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@j.c.a.d APIresult<AccountInfo> aPIresult) {
            i.q2.t.i0.f(aPIresult, "resultInfo");
            if (aPIresult.getCode() == 0) {
                ((LogoutSmsCodeView) LogoutSmsCodePresenter.this.mvpView).onSuccessRequest();
                return;
            }
            APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
            i.q2.t.i0.a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
            onErrorMiddle(apiExcept);
        }
    }

    /* JADX INFO: compiled from: LogoutSmsCodePresenter.kt */
    public static final class b extends MiddleSubscriber<APIresult<Integer>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        @j.c.a.d
        protected Type getType() {
            return Integer.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@j.c.a.d APIException aPIException) {
            i.q2.t.i0.f(aPIException, "e");
            e2.a(aPIException.getMessage());
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer == null) {
                i.q2.t.i0.f();
            }
            mCodeTimer.setEnabled(true);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@j.c.a.d APIresult<Integer> aPIresult) {
            i.q2.t.i0.f(aPIresult, "resultInfo");
            if (aPIresult.getCode() != 0) {
                APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
                i.q2.t.i0.a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
                onErrorMiddle(apiExcept);
                return;
            }
            e2.a("\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u67e5\u6536");
            CodeCutTimeTextView mCodeTimer = LogoutSmsCodePresenter.this.getMCodeTimer();
            if (mCodeTimer != null) {
                Activity activity = LogoutSmsCodePresenter.this.mActivity;
                Integer data = aPIresult.getData();
                i.q2.t.i0.a((Object) data, "resultInfo.data");
                mCodeTimer.a(activity, data.intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutSmsCodePresenter(@j.c.a.d Activity activity, @j.c.a.d LogoutSmsCodeView logoutSmsCodeView) {
        super(activity, logoutSmsCodeView);
        i.q2.t.i0.f(activity, "activity");
        i.q2.t.i0.f(logoutSmsCodeView, "view");
    }

    private final void verificationCodeHttp(HashMap<String, String> map) {
        requestPhoneCode(e.a.b("", 1, f.b.H), map, new a());
    }

    private final void verificationHttp(HashMap<String, String> map) {
        requestPhoneCodeTime(e.a.b("", 2, f.b.D), map, new b());
    }

    @j.c.a.e
    public final CodeCutTimeTextView getMCodeTimer() {
        return this.mCodeTimer;
    }

    public final void setMCodeTimer(@j.c.a.e CodeCutTimeTextView codeCutTimeTextView) {
        this.mCodeTimer = codeCutTimeTextView;
    }

    public final void verificationCode(@j.c.a.d String str, @j.c.a.d String str2, int i2) {
        i.q2.t.i0.f(str, "phone");
        i.q2.t.i0.f(str2, "code");
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
        map.put("codeType", String.valueOf(i2));
        f1.a("\u52a0\u8f7d\u4e2d...", true, this.mActivity);
        verificationCodeHttp(map);
    }

    public final void verificationSubmit(@j.c.a.d String str, int i2, @j.c.a.e CodeCutTimeTextView codeCutTimeTextView) {
        i.q2.t.i0.f(str, "phoneNum");
        this.mCodeTimer = codeCutTimeTextView;
        if (str.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("mobilenumber", str);
        map.put("codetype", String.valueOf(i2) + "");
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        i.q2.t.i0.a((Object) nodeRegionId, "RegionConfigHttp.getNodeRegionId()");
        map.put("areaCode", nodeRegionId);
        verificationHttp(map);
    }
}
