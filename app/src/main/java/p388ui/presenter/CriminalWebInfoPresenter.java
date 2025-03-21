package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.WebInfoNumBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.WebInfoCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalWebInfoPresenter extends ModelPresent<WebInfoCallView> {

    /* renamed from: ui.presenter.CriminalWebInfoPresenter$a */
    class C6970a extends MiddleSubscriber<APIresult<WebInfoNumBean>> {
        C6970a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return WebInfoNumBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<WebInfoNumBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((WebInfoCallView) CriminalWebInfoPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    public CriminalWebInfoPresenter(Activity activity, WebInfoCallView webInfoCallView) {
        super(activity, webInfoCallView);
    }

    public void getWebNum(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17044T1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getCriminalWebInfoNum(m16395a, hashMap, new C6970a());
    }
}
