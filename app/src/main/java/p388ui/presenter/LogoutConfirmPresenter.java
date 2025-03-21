package p388ui.presenter;

import android.app.Activity;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.LogoutConfirmView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* compiled from: LogoutConfirmPresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0002¨\u0006\u000e"}, m23546d2 = {"Lui/presenter/LogoutConfirmPresenter;", "Lui/model/ModelPresent;", "Lui/callview/LogoutConfirmView;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Lui/callview/LogoutConfirmView;)V", "loginOff", "", "reason", "", "loginOffHttp", "map", "Ljava/util/HashMap;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutConfirmPresenter extends ModelPresent<LogoutConfirmView> {

    /* compiled from: LogoutConfirmPresenter.kt */
    /* renamed from: ui.presenter.LogoutConfirmPresenter$a */
    public static final class C7016a extends MiddleSubscriber<APIresult<?>> {
        C7016a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5816d APIException aPIException) {
            C5544i0.m22546f(aPIException, "e");
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5816d APIresult<?> aPIresult) {
            C5544i0.m22546f(aPIresult, "resultInfo");
            if (aPIresult.getCode() == 0) {
                ((LogoutConfirmView) LogoutConfirmPresenter.this.mvpView).onSuccessRequest();
                return;
            }
            APIException apiExcept = APIException.getApiExcept(aPIresult.getMsg());
            C5544i0.m22521a((Object) apiExcept, "APIException.getApiExcept(resultInfo.msg)");
            onErrorMiddle(apiExcept);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutConfirmPresenter(@InterfaceC5816d Activity activity, @InterfaceC5816d LogoutConfirmView logoutConfirmView) {
        super(activity, logoutConfirmView);
        C5544i0.m22546f(activity, "activity");
        C5544i0.m22546f(logoutConfirmView, "view");
    }

    private final void loginOffHttp(HashMap<String, String> hashMap) {
        loginOffHttp(C4440a.m16395a("", 1, C4445b.f17009I), hashMap, new C7016a());
    }

    public final void loginOff(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "reason");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reason", str);
        C7257b1.m26203a("加载中...", true, this.mActivity);
        loginOffHttp(hashMap);
    }
}
