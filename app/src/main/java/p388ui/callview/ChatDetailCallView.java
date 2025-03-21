package p388ui.callview;

import bean.ChatDetailResultBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ChatDetailCallView extends BaseView {
    void onDeteleSuccess();

    void onErrorRequest();

    void onSaveSuccess(ChatDetailResultBean chatDetailResultBean);

    void onStartRequest();
}
