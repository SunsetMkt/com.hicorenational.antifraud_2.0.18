package ui.callview;

import bean.CheckTimeBean;
import network.account.APIresult;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface SettingView extends BaseView {
    void cancleTimeDlg();

    void ensureTimeDlg();

    void onItemClick(CheckTimeBean checkTimeBean);

    void onSuccessLoginOut(APIresult aPIresult);
}
