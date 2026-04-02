package ui.callview;

import bean.CheckUserBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface ManualView extends BaseView {
    void onSuccess(CheckUserBean checkUserBean);

    void onfail(String str);
}
