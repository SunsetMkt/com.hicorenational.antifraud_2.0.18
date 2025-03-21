package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CaseVerifyCallview;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* compiled from: CaseVerifyPresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n¨\u0006\u000e"}, m23546d2 = {"Lui/presenter/CaseVerifyPresenter;", "Lui/model/ModelPresent;", "Lui/callview/CaseVerifyCallview;", "activity", "Landroid/app/Activity;", "vw", "(Landroid/app/Activity;Lui/callview/CaseVerifyCallview;)V", "checkID", "", "idNumber", "", "createInvited", CommonNetImpl.NAME, "image", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CaseVerifyPresenter extends ModelPresent<CaseVerifyCallview> {

    /* compiled from: CaseVerifyPresenter.kt */
    /* renamed from: ui.presenter.CaseVerifyPresenter$a */
    public static final class C6946a extends MiddleSubscriber<APIresult<String>> {
        C6946a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            C7331w1.m26688a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseVerifyCallview) CaseVerifyPresenter.this.mvpView).onSuccessID();
            }
        }
    }

    /* compiled from: CaseVerifyPresenter.kt */
    /* renamed from: ui.presenter.CaseVerifyPresenter$b */
    public static final class C6947b extends MiddleSubscriber<APIresult<String>> {
        C6947b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            ((CaseVerifyCallview) CaseVerifyPresenter.this.mvpView).onFail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseVerifyCallview) CaseVerifyPresenter.this.mvpView).onSuccess();
            }
        }
    }

    public CaseVerifyPresenter(@InterfaceC5817e Activity activity, @InterfaceC5817e CaseVerifyCallview caseVerifyCallview) {
        super(activity, caseVerifyCallview);
    }

    public final void checkID(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "idNumber");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("idNumber", str);
        postOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17055X0), hashMap, new C6946a());
    }

    public final void createInvited(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, CommonNetImpl.NAME);
        C5544i0.m22546f(str2, "idNumber");
        C5544i0.m22546f(str3, "image");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(CommonNetImpl.NAME, str);
        hashMap.put("identityCardNum", str2);
        hashMap.put("image", str3);
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        createInvited(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 3, C4445b.f17058Y0), hashMap, new C6947b());
    }
}
