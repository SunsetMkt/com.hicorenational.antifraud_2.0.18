package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.FeedbackInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.FeedbackCallView;
import p388ui.model.OSSModelPresent;
import util.C7301n1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class FeedbackPresenter extends OSSModelPresent<FeedbackCallView> {
    List<OssFileInfo> ossFiles;

    /* renamed from: ui.presenter.FeedbackPresenter$a */
    class C6981a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ List f24091a;

        /* renamed from: b */
        final /* synthetic */ OssFileRequest f24092b;

        /* renamed from: c */
        final /* synthetic */ FeedbackInfo f24093c;

        /* renamed from: d */
        final /* synthetic */ List f24094d;

        C6981a(List list, OssFileRequest ossFileRequest, FeedbackInfo feedbackInfo, List list2) {
            this.f24091a = list;
            this.f24092b = ossFileRequest;
            this.f24093c = feedbackInfo;
            this.f24094d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
            C7301n1.m26456b("ossFiles-------->" + FeedbackPresenter.this.ossFiles.size());
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f24091a.add(ossFileInfo);
            if (this.f24091a.size() == this.f24092b.getFilePaths().size()) {
                this.f24093c.setFileInfos(this.f24091a);
                FeedbackPresenter.this.confirmFeedbackHttp(this.f24093c);
            } else {
                this.f24092b.setFilePath((String) this.f24094d.get(this.f24091a.size()));
                FeedbackPresenter.this.upFileToOss(this.f24092b, this);
            }
        }
    }

    /* renamed from: ui.presenter.FeedbackPresenter$b */
    class C6982b extends MiddleSubscriber<APIresult> {
        C6982b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            C7301n1.m26454a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                C7331w1.m26688a("提交成功");
                FeedbackPresenter.this.mActivity.finish();
            }
        }
    }

    public FeedbackPresenter(Activity activity, FeedbackCallView feedbackCallView) {
        super(activity, feedbackCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmFeedbackHttp(FeedbackInfo feedbackInfo) {
        uploadReportParam(feedbackInfo, C4440a.m16395a(ModuelConfig.MODEL_FEEDBACK, 9, C4445b.f17019L0), new C6982b());
    }

    private List<String> hasUpFile(List<OssFileInfo> list, List<LocalMedia> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            arrayList.add(list2.get(i2).getPath());
        }
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                LocalMedia localMedia = list2.get(i3);
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (TextUtils.equals(localMedia.getPath(), list.get(i4).getLocalPath())) {
                        arrayList.remove(localMedia.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public void confirmFeedback(FeedbackInfo feedbackInfo, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmFeedbackHttp(feedbackInfo);
            return;
        }
        List<String> hasUpFile = hasUpFile(this.ossFiles, list);
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("2");
        ossFileRequest.setFilePaths(hasUpFile);
        ArrayList arrayList = new ArrayList();
        ossFileRequest.setFilePath(hasUpFile.get(arrayList.size()));
        upFileToOss(ossFileRequest, new C6981a(arrayList, ossFileRequest, feedbackInfo, hasUpFile));
    }

    public void uploadReportParam(FeedbackInfo feedbackInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        feedBack2(feedbackInfo, str, middleSubscriber);
    }
}
