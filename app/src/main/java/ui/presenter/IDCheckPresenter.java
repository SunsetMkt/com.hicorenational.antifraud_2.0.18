package ui.presenter;

import android.app.Activity;
import bean.VerifyHomePointBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.IDCheckView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class IDCheckPresenter extends ModelPresent<IDCheckView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((IDCheckView) IDCheckPresenter.this.mvpView).onSuccCreateCheckRequest();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<VerifyHomePointBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return VerifyHomePointBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<VerifyHomePointBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else if (aPIresult.getData() != null) {
                ((IDCheckView) IDCheckPresenter.this.mvpView).onSuccCreateRequest(aPIresult.getData());
            }
        }
    }

    public IDCheckPresenter(Activity activity, IDCheckView iDCheckView) {
        super(activity, iDCheckView);
    }

    public void getVerifyHomePoint() {
        getVerifyHomePoint(e.a.f10139c + f.b.q0, new b());
    }

    public void verifyCreateCheck(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("invitedMobile", str);
        verifyCreate(map, e.a.f10139c + f.b.u0, new a());
    }
}
