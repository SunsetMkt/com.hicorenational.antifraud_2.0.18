package p388ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ManualCheckView;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ManualCheckPresenter extends OSSModelPresent<ManualCheckView> {
    private boolean isIDCard;
    private OssFileInfo mBackImgInfo;
    private OssFileInfo mFrontImgInfo;
    private String phoneNum;
    private String strIDNumber;
    private String strName;

    /* renamed from: ui.presenter.ManualCheckPresenter$a */
    class C7020a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ OssFileInfo f24145a;

        C7020a(OssFileInfo ossFileInfo) {
            this.f24145a = ossFileInfo;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            C7331w1.m26688a(ManualCheckPresenter.this.mActivity.getString(C2113R.string.err_system));
            ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f24145a.setAlreadyUpload(true);
                this.f24145a.setFileSHA1(ossFileInfo.getFileSHA1());
                this.f24145a.setFileMd5(ossFileInfo.getFileMd5());
                this.f24145a.setFilePath(ossFileInfo.getFilePath());
                ManualCheckPresenter.this.uploadFile();
            }
        }
    }

    /* renamed from: ui.presenter.ManualCheckPresenter$b */
    class C7021b extends MiddleSubscriber<APIresult> {
        C7021b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
            C7331w1.m26688a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null && aPIresult.getCode() == 0) {
                ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onSubmitSuccessRequest(aPIresult);
            } else {
                ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    public ManualCheckPresenter(Activity activity, ManualCheckView manualCheckView, String str, String str2, String str3, boolean z) {
        super(activity, manualCheckView);
        this.mFrontImgInfo = null;
        this.mBackImgInfo = null;
        this.strName = str;
        this.phoneNum = str3;
        this.strIDNumber = str2;
        this.isIDCard = z;
    }

    private void confirmIDAuthHttp(HashMap hashMap) {
        confirmIDAuth(C4440a.m16395a(ModuelConfig.MODEL_MANUAL, 8, C4445b.f16995D0), hashMap, new C7021b());
    }

    private OssFileInfo getLocalPath() {
        if (!this.mFrontImgInfo.isAlreadyUpload()) {
            return this.mFrontImgInfo;
        }
        if (!this.mBackImgInfo.isAlreadyUpload()) {
            return this.mBackImgInfo;
        }
        confirmIDAuth(this.strName, this.strIDNumber, this.phoneNum, this.mFrontImgInfo, this.mBackImgInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFile() {
        OssFileInfo localPath = getLocalPath();
        if (localPath == null) {
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("3");
        ossFileRequest.setFilePath(localPath.getLocalPath());
        upFileToOss(ossFileRequest, new C7020a(localPath));
    }

    public void clearBack() {
        OssFileInfo ossFileInfo = this.mBackImgInfo;
        if (ossFileInfo != null) {
            ossFileInfo.toClear();
        }
    }

    public void clearFront() {
        OssFileInfo ossFileInfo = this.mFrontImgInfo;
        if (ossFileInfo != null) {
            ossFileInfo.toClear();
        }
    }

    public void confirmIDAuth(String str, String str2, String str3, OssFileInfo ossFileInfo, OssFileInfo ossFileInfo2) {
        HashMap hashMap = new HashMap();
        hashMap.put(CommonNetImpl.NAME, str);
        hashMap.put("idNumber", str2);
        hashMap.put("telnumber", str3);
        hashMap.put("frontImgInfo", ossFileInfo);
        hashMap.put("backImgInfo", ossFileInfo2);
        if (this.isIDCard) {
            hashMap.put("documentType", "1");
        } else {
            hashMap.put("documentType", "2");
        }
        confirmIDAuthHttp(hashMap);
    }

    public void uploadPic(String str, String str2) {
        OssFileInfo ossFileInfo = this.mFrontImgInfo;
        if (ossFileInfo == null) {
            this.mFrontImgInfo = new OssFileInfo(str);
        } else {
            ossFileInfo.setLocalPath(str);
        }
        OssFileInfo ossFileInfo2 = this.mBackImgInfo;
        if (ossFileInfo2 == null) {
            this.mBackImgInfo = new OssFileInfo(str2);
        } else {
            ossFileInfo2.setLocalPath(str2);
        }
        uploadFile();
    }
}
