package ui.presenter;

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
import ui.callview.MinePersonalView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class MinePersonalPresenter extends ModelPresent<MinePersonalView> {

    class a extends MiddleSubscriber<APIresult<UserInfoBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return UserInfoBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<UserInfoBean> aPIresult) {
            s1.a("register", "-->onNext");
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((MinePersonalView) MinePersonalPresenter.this.mvpView).onSuccRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(h.a.u0.c cVar) {
            s1.a("register", "-->onSubscribe");
        }
    }

    class b extends MiddleSubscriber<APIresult<CheckUserBean>> {
        b() {
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

    private void accountHttp(HashMap<String, String> map) {
        accountHttp(map, e.a.b("", 1, f.b.K), new a());
    }

    public void checkisverify() {
        checkisverify(e.a.b("", 1, f.b.S), new b());
    }

    public void getUserInfo() {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        f1.a("\u52a0\u8f7d\u4e2d...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        accountHttp(map);
    }
}
