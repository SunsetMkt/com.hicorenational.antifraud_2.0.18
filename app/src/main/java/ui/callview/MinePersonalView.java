package ui.callview;

import bean.CheckUserBean;
import bean.UserInfoBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface MinePersonalView extends BaseView {
    void onFailRequest();

    void onSuccRequest(UserInfoBean userInfoBean);

    void onSuccess(CheckUserBean checkUserBean);
}
