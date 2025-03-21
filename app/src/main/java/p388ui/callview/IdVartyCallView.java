package p388ui.callview;

import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import java.util.List;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface IdVartyCallView extends BaseView {
    void onSuccessAccRequest(List<VerifyAcceptBean> list);

    void onSuccessRequest(List<IDVarfyBean.Rows> list);

    void onfailRequest();
}
