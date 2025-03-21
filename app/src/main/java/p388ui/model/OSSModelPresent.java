package p388ui.model;

import android.app.Activity;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.OssTokenBean;
import bean.module.ModuelConfig;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import interfaces.IOssPicCallback;
import interfaces.IOssPicListCallback;
import interfaces.IRCallback;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.RetrofitFileHelp;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.alioss.OssUploadCallBack;
import okhttp3.MultipartBody;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.basemvp.BaseView;
import p388ui.callview.OssTokenCallView;
import p388ui.model.OSSModelPresent;
import util.C7301n1;
import util.C7304o1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class OSSModelPresent<V extends BaseView> extends ModelPresent {
    public V mvpView;
    private int upIndex;

    /* renamed from: ui.model.OSSModelPresent$a */
    class C6912a extends MiddleSubscriber<APIresult<OssTokenBean>> {

        /* renamed from: a */
        final /* synthetic */ OssTokenCallView f23932a;

        C6912a(OssTokenCallView ossTokenCallView) {
            this.f23932a = ossTokenCallView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return OssTokenBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            this.f23932a.onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<OssTokenBean> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            OssTokenBean data = aPIresult.getData();
            if (data == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            OssTokenBean.Credential stsCredentials = data.getStsCredentials();
            if (stsCredentials != null && data.isExist() == 0) {
                AliOssClient.getInstance().initClient(data.getEndPoint(), stsCredentials.getAccessKeyId(), stsCredentials.getAccessKeySecret(), stsCredentials.getSecurityToken());
            }
            this.f23932a.onSuccRequest(data);
        }
    }

    /* renamed from: ui.model.OSSModelPresent$b */
    class C6913b implements OssTokenCallView {

        /* renamed from: a */
        final /* synthetic */ OssFileRequest f23934a;

        /* renamed from: b */
        final /* synthetic */ IOssPicCallback f23935b;

        /* renamed from: ui.model.OSSModelPresent$b$a */
        class a extends MiddleSubscriber<APIresult> {

            /* renamed from: a */
            final /* synthetic */ OssFileInfo f23937a;

            a(OssFileInfo ossFileInfo) {
                this.f23937a = ossFileInfo;
            }

            /* renamed from: a */
            static /* synthetic */ void m25611a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
                ossFileInfo.setAlreadyUpload(true);
                iOssPicCallback.onSuccess(ossFileInfo);
            }

            @Override // network.MiddleSubscriber
            protected Type getType() {
                return super.getType();
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                C6913b.this.f23935b.onFail(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult aPIresult) {
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept(aPIresult));
                    return;
                }
                C6913b c6913b = C6913b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.f23937a;
                final IOssPicCallback iOssPicCallback = c6913b.f23935b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.C6913b.a.m25611a(OssFileInfo.this, iOssPicCallback);
                    }
                });
            }
        }

        /* renamed from: ui.model.OSSModelPresent$b$b */
        class b implements IRCallback {

            /* renamed from: a */
            final /* synthetic */ OssFileInfo f23939a;

            /* renamed from: ui.model.OSSModelPresent$b$b$a */
            class a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ String f23941a;

                a(String str) {
                    this.f23941a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7301n1.m26457b("hsc", "getOssToken onFailure------------");
                    C6913b.this.f23935b.onFail(this.f23941a);
                }
            }

            b(OssFileInfo ossFileInfo) {
                this.f23939a = ossFileInfo;
            }

            /* renamed from: a */
            static /* synthetic */ void m25612a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
                ossFileInfo.setAlreadyUpload(true);
                iOssPicCallback.onSuccess(ossFileInfo);
            }

            @Override // interfaces.IRCallback
            public void onFail(String str) {
                OSSModelPresent.this.mActivity.runOnUiThread(new a(str));
            }

            @Override // interfaces.IRCallback
            public void onSuccess() {
                C6913b c6913b = C6913b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.f23939a;
                final IOssPicCallback iOssPicCallback = c6913b.f23935b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.C6913b.b.m25612a(OssFileInfo.this, iOssPicCallback);
                    }
                });
            }
        }

        C6913b(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
            this.f23934a = ossFileRequest;
            this.f23935b = iOssPicCallback;
        }

        @Override // p388ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            OssTokenBean.CallBackBean callBack = ossTokenBean.getCallBack();
            if (this.f23934a == null) {
                this.f23935b.onSuccess(null);
                return;
            }
            OssFileInfo ossFileInfo = new OssFileInfo();
            String str = path + "/" + this.f23934a.getFileName();
            ossFileInfo.setFilePath(str);
            ossFileInfo.setFileMd5(this.f23934a.getFileMd5());
            ossFileInfo.setLocalPath(this.f23934a.getFilePath());
            ossFileInfo.setFileName(this.f23934a.getFileName());
            if (!TextUtils.equals(this.f23934a.getType(), "1")) {
                ossFileInfo.setFileSHA1(C7304o1.m26469b(new File(this.f23934a.getFilePath())));
            }
            if (ossTokenBean.isExist() == 1) {
                ossFileInfo.setAlreadyUpload(true);
                ossFileInfo.setFilePath(path);
                this.f23935b.onSuccess(ossFileInfo);
            } else {
                if (ossTokenBean.getStorageType() != 1) {
                    OSSModelPresent.this.conUpLoadFile(bucketName, str, callBack, this.f23934a.getFilePath(), new b(ossFileInfo));
                    return;
                }
                if (TextUtils.isEmpty(ossTokenBean.getPutFileUrl())) {
                    this.f23935b.onFail("本地文件地址为空");
                    return;
                }
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                RetrofitFileHelp.setTextParam(type, "filePath", ossFileInfo.getFilePath());
                if (!TextUtils.isEmpty(this.f23934a.getFilePath())) {
                    RetrofitFileHelp.setFileParamWithProgress(type, this.f23934a.getFileName(), this.f23934a.getFilePath());
                }
                OSSModelPresent.this.uploadFile(ossTokenBean.getPutFileUrl(), type.build(), new a(ossFileInfo));
            }
        }

        @Override // p388ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f23935b.onFail("Oss-token 获取失败");
        }
    }

    /* renamed from: ui.model.OSSModelPresent$c */
    class C6914c implements OssTokenCallView {

        /* renamed from: a */
        final /* synthetic */ OssFileRequest f23943a;

        /* renamed from: b */
        final /* synthetic */ IOssPicListCallback f23944b;

        C6914c(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) {
            this.f23943a = ossFileRequest;
            this.f23944b = iOssPicListCallback;
        }

        @Override // p388ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            ArrayList arrayList = new ArrayList();
            List<String> filePaths = this.f23943a.getFilePaths();
            if (filePaths == null || filePaths.size() <= 0) {
                this.f23944b.onSuccess(arrayList);
            } else {
                OSSModelPresent.this.upLoadFile(bucketName, path, OSSModelPresent.this.doUpFileInfo(path, filePaths), filePaths, arrayList, this.f23944b);
            }
        }

        @Override // p388ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f23944b.onFail("Oss-token 获取失败", null);
        }
    }

    /* renamed from: ui.model.OSSModelPresent$d */
    class C6915d implements OssUploadCallBack {

        /* renamed from: a */
        final /* synthetic */ IRCallback f23946a;

        C6915d(IRCallback iRCallback) {
            this.f23946a = iRCallback;
        }

        @Override // network.alioss.OssUploadCallBack
        public void onFailure() {
            this.f23946a.onFail("文件上传失败!");
        }

        @Override // network.alioss.OssUploadCallBack
        public void onProgress(long j2, long j3) {
        }

        @Override // network.alioss.OssUploadCallBack
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            this.f23946a.onSuccess();
        }
    }

    protected OSSModelPresent(Activity activity, V v) {
        super(activity, (BaseView) v);
        this.upIndex = 0;
        this.mActivity = activity;
        this.mvpView = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conUpLoadFile(String str, String str2, OssTokenBean.CallBackBean callBackBean, String str3, IRCallback iRCallback) {
        AliOssClient.getInstance().upLoadFile(str, str2, str3, callBackBean, new C6915d(iRCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OssFileInfo doUpFileInfo(String str, List<String> list) {
        String str2 = list.get(this.upIndex);
        File file = new File(str2);
        String m26466a = C7304o1.m26466a(file);
        String str3 = str + "/" + m26466a + C7337y1.m26779f(file.getName());
        OssFileInfo ossFileInfo = new OssFileInfo();
        ossFileInfo.setFilePath(str3);
        ossFileInfo.setFileMd5(m26466a);
        ossFileInfo.setFileSHA1(C7304o1.m26469b(file));
        ossFileInfo.setLocalPath(str2);
        return ossFileInfo;
    }

    private final void getOssToken(OssFileRequest ossFileRequest, OssTokenCallView ossTokenCallView) {
        String str = TextUtils.equals(ossFileRequest.getType(), "1") ? ModuelConfig.MODEL_REPORT : TextUtils.equals(ossFileRequest.getType(), "2") ? ModuelConfig.MODEL_FEEDBACK : TextUtils.equals(ossFileRequest.getType(), "3") ? ModuelConfig.MODEL_MANUAL : TextUtils.equals(ossFileRequest.getType(), "5") ? ModuelConfig.MODEL_CASEXC : "";
        File file = new File(ossFileRequest.getFilePath());
        String m26466a = C7304o1.m26466a(file);
        ossFileRequest.setFileMd5(m26466a);
        String m26470b = C7304o1.m26470b(m26466a + AccountManager.getAccountId() + System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(m26470b);
        sb.append(C7337y1.m26779f(file.getName()));
        String sb2 = sb.toString();
        ossFileRequest.setFileName(sb2);
        HashMap hashMap = new HashMap();
        hashMap.put("fileScopeType", ossFileRequest.getType());
        hashMap.put("fileName", sb2);
        getOssToken(C4440a.m16395a(str, 8, C4445b.f17039S), hashMap, new C6912a(ossTokenCallView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upLoadFile(String str, String str2, OssFileInfo ossFileInfo, List<String> list, List<OssFileInfo> list2, IOssPicListCallback iOssPicListCallback) {
    }

    public void upFileToOss(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
        getOssToken(ossFileRequest, new C6913b(ossFileRequest, iOssPicCallback));
    }

    public void upFileToOssList(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) {
        this.upIndex = 0;
        getOssToken(ossFileRequest, new C6914c(ossFileRequest, iOssPicListCallback));
    }
}
