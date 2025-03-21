package p388ui.presenter;

import android.app.Activity;
import bean.VerifyHomePointBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.IDCheckView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class IDCheckPresenter extends ModelPresent<IDCheckView> {

    /* renamed from: ui.presenter.IDCheckPresenter$a */
    class C7007a extends MiddleSubscriber<APIresult> {
        C7007a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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

    /* renamed from: ui.presenter.IDCheckPresenter$b */
    class C7008b extends MiddleSubscriber<APIresult<VerifyHomePointBean>> {
        C7008b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return VerifyHomePointBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            C7331w1.m26688a(aPIException.getMessage());
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
        getVerifyHomePoint(C4440a.f16881c + C4445b.f17115p0, new C7008b());
    }

    public void verifyCreateCheck(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("invitedMobile", str);
        verifyCreate(hashMap, C4440a.f16881c + C4445b.f17127t0, new C7007a());
    }
}
