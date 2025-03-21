package p388ui.callview;

import network.HistoryListInfo;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportCallView extends BaseView {
    void onSuccessRequest(HistoryListInfo.RowsBean rowsBean);

    void onfailRequest();
}
