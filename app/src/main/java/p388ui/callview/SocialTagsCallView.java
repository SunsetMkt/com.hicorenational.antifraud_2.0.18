package p388ui.callview;

import bean.SocialTypeBean;
import java.util.List;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface SocialTagsCallView extends BaseView {
    void onErrorRequest();

    void onSuccessRequest(List<SocialTypeBean> list);
}
