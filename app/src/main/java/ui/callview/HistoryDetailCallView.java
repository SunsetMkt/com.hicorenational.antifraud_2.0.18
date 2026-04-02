package ui.callview;

import network.HistoryDetailInfo;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface HistoryDetailCallView extends BaseView {
    void onSuccessRequest(HistoryDetailInfo historyDetailInfo);

    void onfailRequest();
}
