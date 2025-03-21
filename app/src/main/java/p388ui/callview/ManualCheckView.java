package p388ui.callview;

import network.account.APIresult;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ManualCheckView extends BaseView {
    void onSubmitSuccessRequest(APIresult aPIresult);

    void onfail();
}
