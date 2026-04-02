package ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import ui.callview.AddressCallview;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: compiled from: AddressPresenter.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u000e"}, d2 = {"Lui/presenter/AddressPresenter;", "Lui/model/ModelPresent;", "Lui/callview/AddressCallview;", "activity", "Landroid/app/Activity;", "callview", "(Landroid/app/Activity;Lui/callview/AddressCallview;)V", "addRegisterRegion", "", "accountInfo", "Lnetwork/account/AccountInfo;", "regionName", "", "regionCode", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class AddressPresenter extends ModelPresent<AddressCallview> {

    /* JADX INFO: compiled from: AddressPresenter.kt */
    public static final class a extends MiddleSubscriber<APIresult<Boolean>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AccountInfo f14272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14274d;

        a(AccountInfo accountInfo, String str, String str2) {
            this.f14272b = accountInfo;
            this.f14273c = str;
            this.f14274d = str2;
        }

        @Override // network.MiddleSubscriber
        @j.c.a.d
        protected Type getType() {
            return Boolean.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@j.c.a.e APIException aPIException) {
            AccountManager.mToken = "";
            e2.a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@j.c.a.e APIresult<Boolean> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                Boolean data = aPIresult.getData();
                i.q2.t.i0.a((Object) data, "result.data");
                if (data.booleanValue()) {
                    ((AddressCallview) AddressPresenter.this.mvpView).onSuccessRegister(this.f14272b, this.f14273c, this.f14274d);
                    return;
                }
            }
            onErrorMiddle(APIException.getApiExcept(aPIresult));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressPresenter(@j.c.a.d Activity activity, @j.c.a.d AddressCallview addressCallview) {
        super(activity, addressCallview);
        i.q2.t.i0.f(activity, "activity");
        i.q2.t.i0.f(addressCallview, "callview");
    }

    public final void addRegisterRegion(@j.c.a.d AccountInfo accountInfo, @j.c.a.d String str, @j.c.a.d String str2) {
        i.q2.t.i0.f(accountInfo, "accountInfo");
        i.q2.t.i0.f(str, "regionName");
        i.q2.t.i0.f(str2, "regionCode");
        HashMap<String, String> map = new HashMap<>();
        map.put("registerregion", str2);
        String str3 = e.a.f10139c + f.b.o;
        AccountManager.mToken = accountInfo.getToken();
        redName(str3, map, new a(accountInfo, str, str2));
    }
}
