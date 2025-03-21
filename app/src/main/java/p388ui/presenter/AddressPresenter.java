package p388ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.AccountInfo;
import p245d.C4440a;
import p247e.C4445b;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.AddressCallview;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* compiled from: AddressPresenter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, m23546d2 = {"Lui/presenter/AddressPresenter;", "Lui/model/ModelPresent;", "Lui/callview/AddressCallview;", "activity", "Landroid/app/Activity;", "callview", "(Landroid/app/Activity;Lui/callview/AddressCallview;)V", "addRegisterRegion", "", "accountInfo", "Lnetwork/account/AccountInfo;", "regionName", "", "regionCode", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AddressPresenter extends ModelPresent<AddressCallview> {

    /* compiled from: AddressPresenter.kt */
    /* renamed from: ui.presenter.AddressPresenter$a */
    public static final class C6923a extends MiddleSubscriber<APIresult<Boolean>> {

        /* renamed from: b */
        final /* synthetic */ AccountInfo f23962b;

        /* renamed from: c */
        final /* synthetic */ String f23963c;

        /* renamed from: d */
        final /* synthetic */ String f23964d;

        C6923a(AccountInfo accountInfo, String str, String str2) {
            this.f23962b = accountInfo;
            this.f23963c = str;
            this.f23964d = str2;
        }

        @Override // network.MiddleSubscriber
        @InterfaceC5816d
        protected Type getType() {
            return Boolean.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(@InterfaceC5817e APIException aPIException) {
            AccountManager.mToken = "";
            C7331w1.m26688a(aPIException != null ? aPIException.getMessage() : null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(@InterfaceC5817e APIresult<Boolean> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                Boolean data = aPIresult.getData();
                C5544i0.m22521a((Object) data, "result.data");
                if (data.booleanValue()) {
                    ((AddressCallview) AddressPresenter.this.mvpView).onSuccessRegister(this.f23962b, this.f23963c, this.f23964d);
                    return;
                }
            }
            onErrorMiddle(APIException.getApiExcept(aPIresult));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressPresenter(@InterfaceC5816d Activity activity, @InterfaceC5816d AddressCallview addressCallview) {
        super(activity, addressCallview);
        C5544i0.m22546f(activity, "activity");
        C5544i0.m22546f(addressCallview, "callview");
    }

    public final void addRegisterRegion(@InterfaceC5816d AccountInfo accountInfo, @InterfaceC5816d String str, @InterfaceC5816d String str2) {
        C5544i0.m22546f(accountInfo, "accountInfo");
        C5544i0.m22546f(str, "regionName");
        C5544i0.m22546f(str2, "regionCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("registerregion", str2);
        String str3 = C4440a.f16881c + C4445b.f17108n;
        AccountManager.mToken = accountInfo.getToken();
        redName(str3, hashMap, new C6923a(accountInfo, str, str2));
    }
}
