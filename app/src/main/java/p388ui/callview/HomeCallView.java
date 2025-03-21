package p388ui.callview;

import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import java.util.List;
import network.BannerInfo;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface HomeCallView extends BaseView {
    void onBannerSuccRequest(List<BannerInfo> list);

    void onCheckPolice(boolean z, boolean z2);

    void onNewCaseFail(boolean z);

    void onNewCaseRequest(List<HomeNewCaseBean.RowsBean> list);

    void onNoteDlgRequest(NoteDlgBean noteDlgBean);

    void onRedDotStatus(boolean z);
}
