package ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.SurveyAudioCallView;
import ui.model.OSSModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class SurveyAudioPresenter extends OSSModelPresent<SurveyAudioCallView> {
    private h.a.u0.c mDisposable;

    class a implements IOssPicCallback {
        final /* synthetic */ UploadFileBean a;

        a(UploadFileBean uploadFileBean) {
            this.a = uploadFileBean;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            e2.a("\u63d0\u4ea4\u5931\u8d25~");
            ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.a.setFilePath(ossFileInfo.getFilePath());
                this.a.setFileMd5(ossFileInfo.getFileMd5());
                this.a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onSaveSuccess(this.a);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onDeteleSuccess();
                    return;
                } else {
                    if (aPIresult.getCode() == -1) {
                        LoginManager.getInstance().exit();
                        return;
                    }
                    e2.a(aPIresult.getMsg());
                }
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public SurveyAudioPresenter(Activity activity, SurveyAudioCallView surveyAudioCallView) {
        super(activity, surveyAudioCallView);
        this.mDisposable = null;
    }

    public void cancleDisposable() {
        h.a.u0.c cVar = this.mDisposable;
        if (cVar == null || cVar.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
    }

    public void deleteDetail(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.v1), map, new b());
    }

    public void uploadDetail(UploadFileBean uploadFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(uploadFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new a(uploadFileBean));
    }
}
