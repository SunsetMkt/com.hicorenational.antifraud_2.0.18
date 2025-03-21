package p388ui.callview;

import network.account.AccountInfo;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.basemvp.BaseView;

/* compiled from: AddressCallview.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, m23546d2 = {"Lui/callview/AddressCallview;", "Lui/basemvp/BaseView;", "onSuccessRegister", "", "accountInfo", "Lnetwork/account/AccountInfo;", "registerName", "", "registerCode", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface AddressCallview extends BaseView {
    void onSuccessRegister(@InterfaceC5816d AccountInfo accountInfo, @InterfaceC5816d String str, @InterfaceC5816d String str2);
}
