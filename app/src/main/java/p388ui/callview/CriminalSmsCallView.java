package p388ui.callview;

import bean.CriminalSmsBean;
import java.util.List;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalSmsCallView extends BaseView {
    void onSuccess(List<CriminalSmsBean> list);

    void onSuccessDelete(int i2);
}
