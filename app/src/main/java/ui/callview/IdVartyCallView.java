package ui.callview;

import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import java.util.List;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface IdVartyCallView extends BaseView {
    void onSuccessAccRequest(List<VerifyAcceptBean> list);

    void onSuccessRequest(List<IDVarfyBean.Rows> list);

    void onfailRequest();
}
