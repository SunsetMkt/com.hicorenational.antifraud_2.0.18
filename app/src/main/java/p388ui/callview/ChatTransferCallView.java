package p388ui.callview;

import bean.ChatDetailResultBean;
import bean.ChatDetailResultBeanTest;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ChatTransferCallView extends BaseView {
    void onDeteleSuccess();

    void onErrorRequest();

    void onSaveSuccess(ChatDetailResultBeanTest chatDetailResultBeanTest);

    void onStartRequest();

    void onUploadSuccess(ChatDetailResultBean chatDetailResultBean);
}
