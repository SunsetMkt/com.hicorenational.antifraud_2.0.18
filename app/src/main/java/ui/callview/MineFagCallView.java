package ui.callview;

import bean.RecordCountBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface MineFagCallView extends BaseView {
    void onFailRequestReport();

    void onSuccessRequestReport(String str, RecordCountBean recordCountBean);
}
