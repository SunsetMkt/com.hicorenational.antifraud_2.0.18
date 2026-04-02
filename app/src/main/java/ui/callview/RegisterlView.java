package ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface RegisterlView extends BaseView {
    void onOauthSuccRequest(APIresult<AccountInfo> aPIresult);

    void onSuccRequest(APIresult<AccountInfo> aPIresult);
}
