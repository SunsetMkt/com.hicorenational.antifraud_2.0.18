package ui.callview;

import bean.ChatDetailResultBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface ChatDetailCallView extends BaseView {
    void onDeteleSuccess();

    void onErrorRequest();

    void onSaveSuccess(ChatDetailResultBean chatDetailResultBean);

    void onStartRequest();
}
