package ui.callview;

import bean.ReportCaseBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface ReportRecordView extends BaseView {
    void onSuccessRequest(ReportCaseBean reportCaseBean);

    void onfailRequest();
}
