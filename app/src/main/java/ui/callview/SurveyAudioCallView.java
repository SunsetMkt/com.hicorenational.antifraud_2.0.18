package ui.callview;

import bean.UploadFileBean;
import ui.basemvp.BaseView;

/* JADX INFO: loaded from: classes2.dex */
public interface SurveyAudioCallView extends BaseView {
    void onDeteleSuccess();

    void onErrorRequest();

    void onSaveSuccess(UploadFileBean uploadFileBean);

    void onStartRequest();
}
