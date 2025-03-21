package p388ui.callview;

import bean.WebArticleBean;
import network.account.APIresult;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface PromosWebView extends BaseView {
    void onSuccRequest(APIresult<WebArticleBean> aPIresult);
}
