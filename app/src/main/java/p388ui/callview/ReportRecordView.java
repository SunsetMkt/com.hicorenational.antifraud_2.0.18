package p388ui.callview;

import bean.ReportCaseBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportRecordView extends BaseView {
    void onSuccessRequest(ReportCaseBean reportCaseBean);

    void onfailRequest();
}
