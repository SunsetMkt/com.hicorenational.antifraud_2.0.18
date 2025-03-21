package p388ui.callview;

import bean.CheckTimeBean;
import network.account.APIresult;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface SettingView extends BaseView {
    void cancleTimeDlg();

    void ensureTimeDlg();

    void onItemClick(CheckTimeBean checkTimeBean);

    void onSuccessLoginOut(APIresult aPIresult);
}
