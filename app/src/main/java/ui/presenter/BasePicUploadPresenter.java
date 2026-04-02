package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import com.hicorenational.antifraud.R;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.BaseUploadView;
import ui.model.OSSModelPresent;
import util.e2;
import util.f1;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class BasePicUploadPresenter extends OSSModelPresent<BaseUploadView> {
    private h.a.u0.c mDisposable;

    class a implements IOssPicCallback {
        final /* synthetic */ UploadFileBean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14283b;

        a(UploadFileBean uploadFileBean, String str) {
            this.a = uploadFileBean;
            this.f14283b = str;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            e2.a("\u63d0\u4ea4\u5931\u8d25~");
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.a.setFilePath(ossFileInfo.getFilePath());
                this.a.setFileMd5(ossFileInfo.getFileMd5());
                this.a.setFileSHA1(ossFileInfo.getFileSHA1());
                if (TextUtils.isEmpty(this.f14283b)) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess("", this.a);
                } else {
                    BasePicUploadPresenter.this.uploadTransDetail(this.a, this.f14283b);
                }
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {
        final /* synthetic */ UploadFileBean a;

        b(UploadFileBean uploadFileBean) {
            this.a = uploadFileBean;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            s1.a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess(aPIresult.getData(), this.a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onDeteleSuccess(this.a);
                    return;
                }
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public BasePicUploadPresenter(Activity activity, BaseUploadView baseUploadView) {
        super(activity, baseUploadView);
        this.mDisposable = null;
    }

    public void cancleDisposable() {
        h.a.u0.c cVar = this.mDisposable;
        if (cVar == null || cVar.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
    }

    public void deleteDetail(int i2) {
        ((BaseUploadView) ((OSSModelPresent) this).mvpView).onDeteleSuccess(i2);
    }

    public void uploadDetail(String str, UploadFileBean uploadFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(uploadFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new a(uploadFileBean, str));
    }

    public void uploadTransDetail(UploadFileBean uploadFileBean, String str) {
        uploadTransDetail(str, uploadFileBean);
    }

    public void deleteDetail(String str, String str2, int i2) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str2);
        deleteReportCriminalPic(str, map, new c(i2));
    }

    public void uploadTransDetail(String str, UploadFileBean uploadFileBean) {
        uploadCriminalFile2(uploadFileBean, str, new b(uploadFileBean));
    }
}
