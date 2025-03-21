package p388ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.C2113R;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.Hicore;
import p388ui.callview.SurveyAudioCallView;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SurveyAudioPresenter extends OSSModelPresent<SurveyAudioCallView> {
    private InterfaceC4552c mDisposable;

    /* renamed from: ui.presenter.SurveyAudioPresenter$a */
    class C7090a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ UploadFileBean f24332a;

        C7090a(UploadFileBean uploadFileBean) {
            this.f24332a = uploadFileBean;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            C7331w1.m26688a("提交失败~");
            ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f24332a.setFilePath(ossFileInfo.getFilePath());
                this.f24332a.setFileMd5(ossFileInfo.getFileMd5());
                this.f24332a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onSaveSuccess(this.f24332a);
            }
        }
    }

    /* renamed from: ui.presenter.SurveyAudioPresenter$b */
    class C7091b extends MiddleSubscriber<APIresult> {
        C7091b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(Hicore.getApp().getResources().getString(C2113R.string.err_system));
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
                    C7331w1.m26688a(aPIresult.getMsg());
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
        InterfaceC4552c interfaceC4552c = this.mDisposable;
        if (interfaceC4552c == null || interfaceC4552c.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
    }

    public void deleteDetail(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17131u1), hashMap, new C7091b());
    }

    public void uploadDetail(UploadFileBean uploadFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(uploadFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new C7090a(uploadFileBean));
    }
}
