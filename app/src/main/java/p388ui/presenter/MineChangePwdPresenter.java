package p388ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.MineChangePwdView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class MineChangePwdPresenter extends ModelPresent<MineChangePwdView> {

    /* renamed from: ui.presenter.MineChangePwdPresenter$a */
    class C7027a extends MiddleSubscriber<APIresult<Boolean>> {
        C7027a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26688a(aPIException.getMessage());
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
        getAccHasPwd(C4440a.f16881c + C4445b.f17114p, new C7027a());
    }
}
