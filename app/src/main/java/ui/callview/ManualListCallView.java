package ui.callview;

import bean.ManualListBean;
import bean.PageBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface ManualListCallView extends BaseView {
    void onSuccess(PageBean<ManualListBean> pageBean);
}
