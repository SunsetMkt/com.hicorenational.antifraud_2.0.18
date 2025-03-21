package p388ui.callview;

import bean.OssTokenBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface OssTokenCallView extends BaseView {
    void onSuccRequest(OssTokenBean ossTokenBean);

    void onfailRequest();
}
