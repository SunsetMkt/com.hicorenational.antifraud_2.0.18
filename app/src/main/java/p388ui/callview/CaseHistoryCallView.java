package p388ui.callview;

import bean.CaseDetailBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CaseHistoryCallView extends BaseView {
    void onSuccessBack();

    void onSuccessCommit();

    void onSuccessDetail(CaseDetailBean caseDetailBean);
}
