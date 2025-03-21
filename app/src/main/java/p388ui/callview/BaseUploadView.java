package p388ui.callview;

import bean.UploadFileBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface BaseUploadView extends BaseView {
    void onDeteleSuccess(int i2);

    void onErrorRequest();

    void onSaveSuccess();

    void onStartRequest();

    void onUploadSuccess(String str, UploadFileBean uploadFileBean);
}
