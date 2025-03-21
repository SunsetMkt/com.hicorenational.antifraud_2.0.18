package p388ui.callview;

import network.account.APIresult;
import network.account.AccountInfo;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface RegisterlView extends BaseView {
    void onOauthSuccRequest(APIresult<AccountInfo> aPIresult);

    void onSuccRequest(APIresult<AccountInfo> aPIresult);
}
