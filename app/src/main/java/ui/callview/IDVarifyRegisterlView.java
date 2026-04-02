package ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface IDVarifyRegisterlView extends BaseView {
    void onSuccLoginRequest(APIresult<AccountInfo> aPIresult);

    void onSuccLogoutRequest();

    void onSuccRequest(APIresult<AccountInfo> aPIresult);
}
