package p388ui.callview;

import bean.BrandBean;
import java.util.List;
import p023b.p024a.p025a.p027e.C0923i;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalSmsAddCallView extends BaseView {
    void onSuccessBrand(List<BrandBean> list, C0923i.b<BrandBean> bVar);

    void onfail();
}
