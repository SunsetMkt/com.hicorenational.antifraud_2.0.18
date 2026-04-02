package ui.callview;

import bean.AIInspectRecordBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface AIInspectRecordCallView extends BaseView {
    void onSuccessRequest(AIInspectRecordBean aIInspectRecordBean);

    void onfailRequest();
}
