package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.CriminalSocialBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CriminalSocialCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalSocinalPresenter extends ModelPresent<CriminalSocialCallView> {

    /* renamed from: ui.presenter.CriminalSocinalPresenter$a */
    class C6968a extends MiddleSubscriber<APIresult<List<CriminalSocialBean>>> {

        /* renamed from: ui.presenter.CriminalSocinalPresenter$a$a */
        class a extends C2049a<List<CriminalSocialBean>> {
            a() {
            }
        }

        C6968a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalSocialBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CriminalSocialCallView) CriminalSocinalPresenter.this.mvpView).onSuccess(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSocinalPresenter$b */
    class C6969b extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ int f24049a;

        C6969b(int i2) {
            this.f24049a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CriminalSocialCallView) CriminalSocinalPresenter.this.mvpView).onSuccessDelete(this.f24049a);
            }
        }
    }

    public CriminalSocinalPresenter(Activity activity, CriminalSocialCallView criminalSocialCallView) {
        super(activity, criminalSocialCallView);
    }

    public void socialDeleteHttp(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17050V1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        hashMap.put("netAccountInfoID", str2);
        postOperation(m16395a, hashMap, new C6969b(i2));
    }

    public void socialHttp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17047U1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        socialList(m16395a, hashMap, new C6968a());
    }
}
