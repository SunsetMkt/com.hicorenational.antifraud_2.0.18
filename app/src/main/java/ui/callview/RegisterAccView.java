package ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface RegisterAccView extends BaseView {
    void onLoginSuccRequest(APIresult<AccountInfo> aPIresult);
}
