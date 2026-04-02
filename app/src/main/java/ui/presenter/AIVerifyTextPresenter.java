package ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.OssTokenBean;
import bean.module.ModuelConfig;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import interfaces.IRCallback;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.alioss.OssUploadCallBack;
import ui.callview.AIVerifyTextCallView;
import ui.model.ModelPresent;
import util.g2;
import util.j1;
import util.t1;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyTextPresenter extends ModelPresent<AIVerifyTextCallView> {
    private boolean mCurrentState;

    class a extends MiddleSubscriber<APIresult<OssTokenBean>> {
        final /* synthetic */ OssFileRequest a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f14259b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f14260c;

        /* JADX INFO: renamed from: ui.presenter.AIVerifyTextPresenter$a$a */
        class C0294a implements IRCallback {
            final /* synthetic */ OssTokenBean a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ File f14262b;

            C0294a(OssTokenBean ossTokenBean, File file) {
                this.a = ossTokenBean;
                this.f14262b = file;
            }

            @Override // interfaces.IRCallback
            public void onFail(String str) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError(str);
            }

            @Override // interfaces.IRCallback
            public void onSuccess() {
                String str = this.a.getPath() + "/" + a.this.f14259b + "." + j1.d(this.f14262b.getName());
                a aVar = a.this;
                AIVerifyTextPresenter.this.startInformationVerify(this.f14262b, aVar.f14259b, str, aVar.f14260c);
            }
        }

        a(OssFileRequest ossFileRequest, String str, int i2) {
            this.a = ossFileRequest;
            this.f14259b = str;
            this.f14260c = i2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return OssTokenBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<OssTokenBean> aPIresult) {
            if (aPIresult.getCode() != 0) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            OssTokenBean data = aPIresult.getData();
            if (data == null) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            OssTokenBean.Credential stsCredentials = data.getStsCredentials();
            if (stsCredentials == null) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            if (data.isExist() == 0) {
                AliOssClient.getInstance().initAIClient(data.getEndPoint(), stsCredentials.getAccessKeyId(), stsCredentials.getAccessKeySecret(), stsCredentials.getSecurityToken());
            }
            String bucketName = data.getBucketName();
            String path = data.getPath();
            OssTokenBean.CallBackBean callBack = data.getCallBack();
            if (this.a == null) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError("\u6587\u4ef6\u4e3a\u7a7a,\u8bf7\u91cd\u65b0\u9009\u62e9");
                return;
            }
            OssFileInfo ossFileInfo = new OssFileInfo();
            String str = path + "/" + this.a.getFileName();
            ossFileInfo.setFilePath(str);
            ossFileInfo.setFileMd5(this.a.getFileMd5());
            ossFileInfo.setLocalPath(this.a.getFilePath());
            ossFileInfo.setFileName(this.a.getFileName());
            File file = new File(this.a.getFilePath());
            ossFileInfo.setFileSHA1(t1.b(file));
            AIVerifyTextPresenter.this.conUpLoadFile(bucketName, str, callBack, this.a.getFilePath(), new C0294a(data, file));
        }
    }

    class b implements OssUploadCallBack {
        final /* synthetic */ IRCallback a;

        b(IRCallback iRCallback) {
            this.a = iRCallback;
        }

        @Override // network.alioss.OssUploadCallBack
        public void onFailure() {
            this.a.onFail("\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25!");
        }

        @Override // network.alioss.OssUploadCallBack
        public void onProgress(long j2, long j3) {
        }

        @Override // network.alioss.OssUploadCallBack
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            this.a.onSuccess();
        }
    }

    class c extends MiddleSubscriber<APIresult<Object>> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Object> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onSuccess(aPIresult.getEncodeStr());
            } else {
                ((AIVerifyTextCallView) AIVerifyTextPresenter.this.mvpView).onError(aPIresult.getMsg());
            }
        }
    }

    public AIVerifyTextPresenter(Activity activity, AIVerifyTextCallView aIVerifyTextCallView) {
        super(activity, aIVerifyTextCallView);
        this.mCurrentState = false;
    }

    public void conUpLoadFile(String str, String str2, OssTokenBean.CallBackBean callBackBean, String str3, IRCallback iRCallback) {
        AliOssClient.getInstance().upAiLoadFile(str, str2, str3, callBackBean, new b(iRCallback));
    }

    public void startInformationVerify(File file, String str, String str2, int i2) {
        String str3 = e.a.f10139c + f.b.l2;
        HashMap map = new HashMap();
        map.put("ossFilePath", str2);
        map.put("localFilePath", file.getPath());
        map.put("fileName", str);
        map.put("fileFormat", j1.d(file.getName()));
        map.put("fileSize", "" + file.length());
        map.put("textSize", i2 + "");
        checkTextInformationVerify(str3, map, new c());
    }

    public void upAiTextFileToOss(OssFileRequest ossFileRequest, int i2) {
        File file = new File(ossFileRequest.getFilePath());
        String strA = t1.a(file);
        ossFileRequest.setFileMd5(strA);
        String strB = t1.b(strA + AccountManager.getAccountId() + System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(strB);
        sb.append(g2.f(file.getName()));
        String string = sb.toString();
        ossFileRequest.setFileName(string);
        HashMap map = new HashMap();
        map.put("fileScopeType", ossFileRequest.getType());
        map.put("fileName", string);
        getOssToken(e.a.a(ModuelConfig.MODEL_REPORT, 8, f.b.T), map, new a(ossFileRequest, strB, i2));
    }
}
