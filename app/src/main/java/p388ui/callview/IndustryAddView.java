package p388ui.callview;

import bean.InDustryBean;
import java.util.List;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface IndustryAddView extends BaseView {
    void onSuccIndustryRequest(List<InDustryBean> list);

    void onSuccUpdateRequest();
}
