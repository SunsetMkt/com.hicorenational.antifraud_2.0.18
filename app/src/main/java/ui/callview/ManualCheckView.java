package ui.callview;

import network.account.APIresult;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface ManualCheckView extends BaseView {
    void onSubmitSuccessRequest(APIresult aPIresult);

    void onfail();
}
