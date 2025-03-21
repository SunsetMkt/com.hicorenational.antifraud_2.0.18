package p388ui.callview;

import bean.PolicBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface PoliceLoginCallView extends BaseView {
    void onSendFailRequest();

    void onSendSuccessRequest();

    void onVerifySuccessRequest(PolicBean policBean);
}
