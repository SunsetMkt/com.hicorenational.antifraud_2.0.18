package p388ui.presenter;

import android.app.Activity;
import bean.CheckUserBean;
import bean.UserInfoBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.MinePersonalView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7301n1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class MinePersonalPresenter extends ModelPresent<MinePersonalView> {

    /* renamed from: ui.presenter.MinePersonalPresenter$a */
    class C7030a extends MiddleSubscriber<APIresult<UserInfoBean>> {
        C7030a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return UserInfoBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<UserInfoBean> aPIresult) {
            C7301n1.m26454a("register", "-->onNext");
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((MinePersonalView) MinePersonalPresenter.this.mvpView).onSuccRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            C7301n1.m26454a("register", "-->onSubscribe");
        }
    }

    /* renamed from: ui.presenter.MinePersonalPresenter$b */
    class C7031b extends MiddleSubscriber<APIresult<CheckUserBean>> {
        C7031b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CheckUserBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((MinePersonalView) MinePersonalPresenter.this.mvpView).onFailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CheckUserBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((MinePersonalView) MinePersonalPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public MinePersonalPresenter(Activity activity, MinePersonalView minePersonalView) {
        super(activity, minePersonalView);
    }

    private void accountHttp(HashMap<String, String> hashMap) {
        accountHttp(hashMap, C4440a.m16395a("", 1, C4445b.f17012J), new C7030a());
    }

    public void checkisverify() {
        checkisverify(C4440a.m16395a("", 1, C4445b.f17036R), new C7031b());
    }

    public void getUserInfo() {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        C7257b1.m26203a("加载中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", accountId);
        accountHttp(hashMap);
    }
}
