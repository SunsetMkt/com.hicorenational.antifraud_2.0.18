package p388ui.presenter;

import android.app.Activity;
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
import p388ui.callview.BeforVerifyCallview;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* compiled from: BeforVerifyPresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n¨\u0006\u000f"}, m23546d2 = {"Lui/presenter/BeforVerifyPresenter;", "Lui/model/ModelPresent;", "Lui/callview/BeforVerifyCallview;", "activity", "Landroid/app/Activity;", "vw", "(Landroid/app/Activity;Lui/callview/BeforVerifyCallview;)V", "checkID", "", "idNumber", "", "createInvited", "invitedMobile", CommonNetImpl.NAME, "image", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class BeforVerifyPresenter extends ModelPresent<BeforVerifyCallview> {

    /* compiled from: BeforVerifyPresenter.kt */
    /* renamed from: ui.presenter.BeforVerifyPresenter$a */
    public static final class C6935a extends MiddleSubscriber<APIresult<String>> {
        C6935a() {
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
                ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onSuccessID();
            }
        }
    }

    /* compiled from: BeforVerifyPresenter.kt */
    /* renamed from: ui.presenter.BeforVerifyPresenter$b */
    public static final class C6936b extends MiddleSubscriber<APIresult<String>> {
        C6936b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onFailCreate();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onSuccessCreate();
            }
        }
    }

    public BeforVerifyPresenter(@InterfaceC5817e Activity activity, @InterfaceC5817e BeforVerifyCallview beforVerifyCallview) {
        super(activity, beforVerifyCallview);
    }

    public final void checkID(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "idNumber");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("idNumber", str);
        postOperation(C4440a.f16881c + C4445b.f17130u0, hashMap, new C6935a());
    }

    public final void createInvited(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, @InterfaceC5816d String str4) {
        C5544i0.m22546f(str, "invitedMobile");
        C5544i0.m22546f(str2, CommonNetImpl.NAME);
        C5544i0.m22546f(str3, "idNumber");
        C5544i0.m22546f(str4, "image");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("invitedMobile", str);
        hashMap.put(CommonNetImpl.NAME, str2);
        hashMap.put("idNumber", str3);
        hashMap.put("image", str4);
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        createInvited(C4440a.f16880b + C4445b.f17133v0, hashMap, new C6936b());
    }
}
