package p388ui.callview;

import bean.UploadFileBean;
import p388ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface SurveyAudioCallView extends BaseView {
    void onDeteleSuccess();

    void onErrorRequest();

    void onSaveSuccess(UploadFileBean uploadFileBean);

    void onStartRequest();
}
