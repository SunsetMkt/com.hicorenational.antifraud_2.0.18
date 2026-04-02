package interfaces;

import bean.module.RegionMudelBean;

/* JADX INFO: loaded from: classes2.dex */
public interface IResultMuCallback {
    void onIRFail();

    void onIRSuccess(RegionMudelBean regionMudelBean, boolean z);
}
