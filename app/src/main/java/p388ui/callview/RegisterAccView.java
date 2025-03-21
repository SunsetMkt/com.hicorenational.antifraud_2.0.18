package p388ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface RegisterAccView extends BaseView {
    void onLoginSuccRequest(APIresult<AccountInfo> aPIresult);
}
