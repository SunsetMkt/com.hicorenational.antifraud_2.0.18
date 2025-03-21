package p388ui.callview;

import bean.CheckUserBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ManualView extends BaseView {
    void onSuccess(CheckUserBean checkUserBean);

    void onfail(String str);
}
