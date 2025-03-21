package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.WebArticleBean;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p247e.C4445b;
import p388ui.callview.PromosWebView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class PromosWebPresenter extends ModelPresent<PromosWebView> {

    /* renamed from: ui.presenter.PromosWebPresenter$a */
    class C7040a extends MiddleSubscriber<APIresult<WebArticleBean>> {
        C7040a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return WebArticleBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<WebArticleBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((PromosWebView) PromosWebPresenter.this.mvpView).onSuccRequest(aPIresult);
            }
        }
    }

    public PromosWebPresenter(Activity activity, PromosWebView promosWebView) {
        super(activity, promosWebView);
    }

    public void requestAticleInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + C4445b.f16985A;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("informationID", str2);
        requessArticInfo(str3, hashMap, new C7040a());
    }
}
