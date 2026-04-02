package ui.presenter;

import android.app.Activity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.BeforVerifyCallview;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: compiled from: BeforVerifyPresenter.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lui/presenter/BeforVerifyPresenter;", "Lui/model/ModelPresent;", "Lui/callview/BeforVerifyCallview;", "activity", "Landroid/app/Activity;", "vw", "(Landroid/app/Activity;Lui/callview/BeforVerifyCallview;)V", "checkID", "", "idNumber", "", "createInvited", "invitedMobile", CommonNetImpl.NAME, "image", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class BeforVerifyPresenter extends ModelPresent<BeforVerifyCallview> {

    /* JADX INFO: compiled from: BeforVerifyPresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<String>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@j.c.a.e APIException aPIException) {
            e2.a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@j.c.a.e APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onSuccessID();
            }
        }
    }

    /* JADX INFO: compiled from: BeforVerifyPresenter.kt */
    public static final class b extends MiddleSubscriber<APIresult<String>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@j.c.a.e APIException aPIException) {
            ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onFailCreate();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@j.c.a.e APIresult<String> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((BeforVerifyCallview) BeforVerifyPresenter.this.mvpView).onSuccessCreate();
            }
        }
    }

    public BeforVerifyPresenter(@j.c.a.e Activity activity, @j.c.a.e BeforVerifyCallview beforVerifyCallview) {
        super(activity, beforVerifyCallview);
    }

    public final void checkID(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "idNumber");
        HashMap<String, String> map = new HashMap<>();
        map.put("idNumber", str);
        postOperation(e.a.f10139c + f.b.v0, map, new a());
    }

    public final void createInvited(@j.c.a.d String str, @j.c.a.d String str2, @j.c.a.d String str3, @j.c.a.d String str4) {
        i.q2.t.i0.f(str, "invitedMobile");
        i.q2.t.i0.f(str2, CommonNetImpl.NAME);
        i.q2.t.i0.f(str3, "idNumber");
        i.q2.t.i0.f(str4, "image");
        HashMap<String, String> map = new HashMap<>();
        map.put("invitedMobile", str);
        map.put(CommonNetImpl.NAME, str2);
        map.put("idNumber", str3);
        map.put("image", str4);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        createInvited(e.a.f10138b + f.b.w0, map, new b());
    }
}
