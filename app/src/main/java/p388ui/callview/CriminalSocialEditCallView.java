package p388ui.callview;

import bean.CriminalSocialTypeBean;
import java.util.List;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalSocialEditCallView extends BaseView {
    void onSuccessType(List<CriminalSocialTypeBean> list);

    void onfail();
}
