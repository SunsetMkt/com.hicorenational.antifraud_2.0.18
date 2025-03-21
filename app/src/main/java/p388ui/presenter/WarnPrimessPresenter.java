package p388ui.presenter;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import bean.GuideBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.WarnPrimessCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class WarnPrimessPresenter extends ModelPresent<WarnPrimessCallView> {

    /* renamed from: ui.presenter.WarnPrimessPresenter$a */
    class C7114a extends MiddleSubscriber<APIresult<List<GuideBean>>> {

        /* renamed from: ui.presenter.WarnPrimessPresenter$a$a */
        class a extends C2049a<List<GuideBean>> {
            a() {
            }
        }

        C7114a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WarnPrimessCallView) WarnPrimessPresenter.this.mvpView).onSuccessRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<GuideBean>> aPIresult) {
            List<GuideBean> data;
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null || (data = aPIresult.getData()) == null || data.size() <= 0) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HashMap<String, GuideBean> hashMap = new HashMap<>();
            for (GuideBean guideBean : data) {
                String content = guideBean.getContent();
                if (!TextUtils.isEmpty(content)) {
                    guideBean.setContent(content.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "\n"));
                }
                hashMap.put(guideBean.getCode() + "", guideBean);
            }
            ((WarnPrimessCallView) WarnPrimessPresenter.this.mvpView).onSuccessRequest(hashMap);
        }
    }

    public WarnPrimessPresenter(Activity activity, WarnPrimessCallView warnPrimessCallView) {
        super(activity, warnPrimessCallView);
    }

    public void requestGuideConfig() {
        String str = Build.BRAND;
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.MODEL;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("brand", str);
        hashMap.put("version", str2);
        hashMap.put("phonemodel", str3);
        requestGuideConfig(hashMap);
    }

    public void requestGuideConfig(HashMap<String, String> hashMap) {
        requestGuideConfig(C4440a.m16395a(ModuelConfig.MODEL_WARN, 8, C4445b.f17088g0), hashMap, new C7114a());
    }
}
