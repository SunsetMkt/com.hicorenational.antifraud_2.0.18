package ui.presenter;

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
import ui.callview.FeedbackCallView;
import ui.model.OSSModelPresent;
import util.e2;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackPresenter extends OSSModelPresent<FeedbackCallView> {
    List<OssFileInfo> ossFiles;

    class a implements IOssPicCallback {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f14330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedbackInfo f14331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f14332d;

        a(List list, OssFileRequest ossFileRequest, FeedbackInfo feedbackInfo, List list2) {
            this.a = list;
            this.f14330b = ossFileRequest;
            this.f14331c = feedbackInfo;
            this.f14332d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
            s1.b("ossFiles-------->" + FeedbackPresenter.this.ossFiles.size());
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.a.add(ossFileInfo);
            if (this.a.size() == this.f14330b.getFilePaths().size()) {
                this.f14331c.setFileInfos(this.a);
                FeedbackPresenter.this.confirmFeedbackHttp(this.f14331c);
            } else {
                this.f14330b.setFilePath((String) this.f14332d.get(this.a.size()));
                FeedbackPresenter.this.upFileToOss(this.f14330b, this);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            s1.a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                e2.a("\u63d0\u4ea4\u6210\u529f");
                FeedbackPresenter.this.mActivity.finish();
            }
        }
    }

    public FeedbackPresenter(Activity activity, FeedbackCallView feedbackCallView) {
        super(activity, feedbackCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmFeedbackHttp(FeedbackInfo feedbackInfo) {
        uploadReportParam(feedbackInfo, e.a.b(ModuelConfig.MODEL_FEEDBACK, 9, f.b.M0), new b());
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
        List<String> listHasUpFile = hasUpFile(this.ossFiles, list);
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("2");
        ossFileRequest.setFilePaths(listHasUpFile);
        ArrayList arrayList = new ArrayList();
        ossFileRequest.setFilePath(listHasUpFile.get(arrayList.size()));
        upFileToOss(ossFileRequest, new a(arrayList, ossFileRequest, feedbackInfo, listHasUpFile));
    }

    public void uploadReportParam(FeedbackInfo feedbackInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        feedBack2(feedbackInfo, str, middleSubscriber);
    }
}
