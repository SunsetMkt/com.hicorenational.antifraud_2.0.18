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
import util.w1;

/* loaded from: classes2.dex */
public class IDCheckPresenter extends ModelPresent<IDCheckView> {

    class a extends MiddleSubscriber<APIresult> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            w1.e(aPIException.getMessage());
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
            w1.a(aPIException.getMessage());
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
        getVerifyHomePoint(d.a.f13517c + e.b.p0, new b());
    }

    public void verifyCreateCheck(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("invitedMobile", str);
        verifyCreate(hashMap, d.a.f13517c + e.b.t0, new a());
    }
}
