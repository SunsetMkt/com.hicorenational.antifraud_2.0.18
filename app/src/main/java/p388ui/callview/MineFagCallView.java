package p388ui.callview;

import bean.RecordCountBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface MineFagCallView extends BaseView {
    void onFailRequestReport();

    void onSuccessRequestReport(String str, RecordCountBean recordCountBean);
}
