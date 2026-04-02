package ui.callview;

import bean.InDustryBean;
import java.util.List;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface IndustryAddView extends BaseView {
    void onSuccIndustryRequest(List<InDustryBean> list);

    void onSuccUpdateRequest();
}
