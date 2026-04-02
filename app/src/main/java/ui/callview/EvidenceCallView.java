package ui.callview;

import network.account.APIresult;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface EvidenceCallView extends BaseView {
    void onSuccessRequest(APIresult aPIresult);

    void onfailRequest();
}
