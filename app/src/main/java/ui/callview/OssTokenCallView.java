package ui.callview;

import bean.OssTokenBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface OssTokenCallView extends BaseView {
    void onSuccRequest(OssTokenBean ossTokenBean);

    void onfailRequest();
}
