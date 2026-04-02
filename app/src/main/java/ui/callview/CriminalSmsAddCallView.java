package ui.callview;

import bean.BrandBean;
import c.a.a.e.i;
import java.util.List;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface CriminalSmsAddCallView extends BaseView {
    void onSuccessBrand(List<BrandBean> list, i.b<BrandBean> bVar);

    void onfail();
}
