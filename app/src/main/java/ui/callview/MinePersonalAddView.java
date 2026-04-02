package ui.callview;

import network.account.APIresult;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface MinePersonalAddView extends BaseView {
    void onSuccModifyRequest(APIresult aPIresult);

    void onSuccUpdateRequest(int i2);
}
