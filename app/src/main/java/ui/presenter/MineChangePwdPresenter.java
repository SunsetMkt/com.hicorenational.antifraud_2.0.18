package ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.MineChangePwdView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class MineChangePwdPresenter extends ModelPresent<MineChangePwdView> {

    class a extends MiddleSubscriber<APIresult<Boolean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Boolean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((MineChangePwdView) MineChangePwdPresenter.this.mvpView).onHasPwdSuccRequest(aPIresult.getData().booleanValue());
            }
        }
    }

    public MineChangePwdPresenter(Activity activity, MineChangePwdView mineChangePwdView) {
        super(activity, mineChangePwdView);
    }

    public void getAccHasPwd() {
        getAccHasPwd(e.a.f10139c + f.b.q, new a());
    }
}
