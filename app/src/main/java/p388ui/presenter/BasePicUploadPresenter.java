package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import com.hicorenational.antifraud.C2113R;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.Hicore;
import p388ui.callview.BaseUploadView;
import p388ui.model.OSSModelPresent;
import util.C7257b1;
import util.C7301n1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class BasePicUploadPresenter extends OSSModelPresent<BaseUploadView> {
    private InterfaceC4552c mDisposable;

    /* renamed from: ui.presenter.BasePicUploadPresenter$a */
    class C6932a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ UploadFileBean f23983a;

        /* renamed from: b */
        final /* synthetic */ String f23984b;

        C6932a(UploadFileBean uploadFileBean, String str) {
            this.f23983a = uploadFileBean;
            this.f23984b = str;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            C7331w1.m26688a("提交失败~");
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f23983a.setFilePath(ossFileInfo.getFilePath());
                this.f23983a.setFileMd5(ossFileInfo.getFileMd5());
                this.f23983a.setFileSHA1(ossFileInfo.getFileSHA1());
                if (TextUtils.isEmpty(this.f23984b)) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess("", this.f23983a);
                } else {
                    BasePicUploadPresenter.this.uploadTransDetail(this.f23983a, this.f23984b);
                }
            }
        }
    }

    /* renamed from: ui.presenter.BasePicUploadPresenter$b */
    class C6933b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ UploadFileBean f23986a;

        C6933b(UploadFileBean uploadFileBean) {
            this.f23986a = uploadFileBean;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            C7301n1.m26454a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess(aPIresult.getData(), this.f23986a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.BasePicUploadPresenter$c */
    class C6934c extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ int f23988a;

        C6934c(int i2) {
            this.f23988a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onDeteleSuccess(this.f23988a);
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
        InterfaceC4552c interfaceC4552c = this.mDisposable;
        if (interfaceC4552c == null || interfaceC4552c.isDisposed()) {
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
        upFileToOss(ossFileRequest, new C6932a(uploadFileBean, str));
    }

    public void uploadTransDetail(UploadFileBean uploadFileBean, String str) {
        uploadTransDetail(str, uploadFileBean);
    }

    public void deleteDetail(String str, String str2, int i2) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str2);
        deleteReportCriminalPic(str, hashMap, new C6934c(i2));
    }

    public void uploadTransDetail(String str, UploadFileBean uploadFileBean) {
        uploadCriminalFile2(uploadFileBean, str, new C6933b(uploadFileBean));
    }
}
