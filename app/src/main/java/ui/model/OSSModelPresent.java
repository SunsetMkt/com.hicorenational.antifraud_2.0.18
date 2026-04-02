package ui.model;

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
import ui.basemvp.BaseView;
import ui.callview.OssTokenCallView;
import ui.model.OSSModelPresent;
import util.g2;
import util.s1;
import util.t1;

/* JADX INFO: loaded from: classes2.dex */
public class OSSModelPresent<V extends BaseView> extends ModelPresent {
    public V mvpView;
    private int upIndex;

    class a extends MiddleSubscriber<APIresult<OssTokenBean>> {
        final /* synthetic */ OssTokenCallView a;

        a(OssTokenCallView ossTokenCallView) {
            this.a = ossTokenCallView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return OssTokenBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            this.a.onfailRequest();
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
            this.a.onSuccRequest(data);
        }
    }

    class b implements OssTokenCallView {
        final /* synthetic */ OssFileRequest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOssPicCallback f14237b;

        class a extends MiddleSubscriber<APIresult> {
            final /* synthetic */ OssFileInfo a;

            a(OssFileInfo ossFileInfo) {
                this.a = ossFileInfo;
            }

            static /* synthetic */ void a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
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
                b.this.f14237b.onFail(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult aPIresult) {
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept(aPIresult));
                    return;
                }
                b bVar = b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.a;
                final IOssPicCallback iOssPicCallback = bVar.f14237b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.b.a.a(ossFileInfo, iOssPicCallback);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: ui.model.OSSModelPresent$b$b, reason: collision with other inner class name */
        class C0292b implements IRCallback {
            final /* synthetic */ OssFileInfo a;

            /* JADX INFO: renamed from: ui.model.OSSModelPresent$b$b$a */
            class a implements Runnable {
                final /* synthetic */ String a;

                a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    s1.b("hsc", "getOssToken onFailure------------");
                    b.this.f14237b.onFail(this.a);
                }
            }

            C0292b(OssFileInfo ossFileInfo) {
                this.a = ossFileInfo;
            }

            static /* synthetic */ void a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
                ossFileInfo.setAlreadyUpload(true);
                iOssPicCallback.onSuccess(ossFileInfo);
            }

            @Override // interfaces.IRCallback
            public void onFail(String str) {
                OSSModelPresent.this.mActivity.runOnUiThread(new a(str));
            }

            @Override // interfaces.IRCallback
            public void onSuccess() {
                b bVar = b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.a;
                final IOssPicCallback iOssPicCallback = bVar.f14237b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.b.C0292b.a(ossFileInfo, iOssPicCallback);
                    }
                });
            }
        }

        b(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
            this.a = ossFileRequest;
            this.f14237b = iOssPicCallback;
        }

        @Override // ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            OssTokenBean.CallBackBean callBack = ossTokenBean.getCallBack();
            if (this.a == null) {
                this.f14237b.onSuccess(null);
                return;
            }
            OssFileInfo ossFileInfo = new OssFileInfo();
            String str = path + "/" + this.a.getFileName();
            ossFileInfo.setFilePath(str);
            ossFileInfo.setFileMd5(this.a.getFileMd5());
            ossFileInfo.setLocalPath(this.a.getFilePath());
            ossFileInfo.setFileName(this.a.getFileName());
            if (!TextUtils.equals(this.a.getType(), "1")) {
                ossFileInfo.setFileSHA1(t1.b(new File(this.a.getFilePath())));
            }
            if (ossTokenBean.isExist() == 1) {
                ossFileInfo.setAlreadyUpload(true);
                ossFileInfo.setFilePath(path);
                this.f14237b.onSuccess(ossFileInfo);
            } else {
                if (ossTokenBean.getStorageType() != 1) {
                    OSSModelPresent.this.conUpLoadFile(bucketName, str, callBack, this.a.getFilePath(), new C0292b(ossFileInfo));
                    return;
                }
                if (TextUtils.isEmpty(ossTokenBean.getPutFileUrl())) {
                    this.f14237b.onFail("\u672c\u5730\u6587\u4ef6\u5730\u5740\u4e3a\u7a7a");
                    return;
                }
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                RetrofitFileHelp.setTextParam(type, "filePath", ossFileInfo.getFilePath());
                if (!TextUtils.isEmpty(this.a.getFilePath())) {
                    RetrofitFileHelp.setFileParamWithProgress(type, this.a.getFileName(), this.a.getFilePath());
                }
                OSSModelPresent.this.uploadFile(ossTokenBean.getPutFileUrl(), type.build(), new a(ossFileInfo));
            }
        }

        @Override // ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f14237b.onFail("Oss-token \u83b7\u53d6\u5931\u8d25");
        }
    }

    class c implements OssTokenCallView {
        final /* synthetic */ OssFileRequest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOssPicListCallback f14242b;

        c(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) {
            this.a = ossFileRequest;
            this.f14242b = iOssPicListCallback;
        }

        @Override // ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            ArrayList arrayList = new ArrayList();
            List<String> filePaths = this.a.getFilePaths();
            if (filePaths == null || filePaths.size() <= 0) {
                this.f14242b.onSuccess(arrayList);
            } else {
                OSSModelPresent.this.upLoadFile(bucketName, path, OSSModelPresent.this.doUpFileInfo(path, filePaths), filePaths, arrayList, this.f14242b);
            }
        }

        @Override // ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f14242b.onFail("Oss-token \u83b7\u53d6\u5931\u8d25", null);
        }
    }

    class d implements OssUploadCallBack {
        final /* synthetic */ IRCallback a;

        d(IRCallback iRCallback) {
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

    protected OSSModelPresent(Activity activity, V v) {
        super(activity, (BaseView) v);
        this.upIndex = 0;
        this.mActivity = activity;
        this.mvpView = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conUpLoadFile(String str, String str2, OssTokenBean.CallBackBean callBackBean, String str3, IRCallback iRCallback) {
        AliOssClient.getInstance().upLoadFile(str, str2, str3, callBackBean, new d(iRCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OssFileInfo doUpFileInfo(String str, List<String> list) {
        String str2 = list.get(this.upIndex);
        File file = new File(str2);
        String strA = t1.a(file);
        String str3 = str + "/" + strA + g2.f(file.getName());
        OssFileInfo ossFileInfo = new OssFileInfo();
        ossFileInfo.setFilePath(str3);
        ossFileInfo.setFileMd5(strA);
        ossFileInfo.setFileSHA1(t1.b(file));
        ossFileInfo.setLocalPath(str2);
        return ossFileInfo;
    }

    private final void getOssToken(OssFileRequest ossFileRequest, OssTokenCallView ossTokenCallView) {
        String str = TextUtils.equals(ossFileRequest.getType(), "1") ? ModuelConfig.MODEL_REPORT : TextUtils.equals(ossFileRequest.getType(), "2") ? ModuelConfig.MODEL_FEEDBACK : TextUtils.equals(ossFileRequest.getType(), "3") ? ModuelConfig.MODEL_MANUAL : TextUtils.equals(ossFileRequest.getType(), "5") ? ModuelConfig.MODEL_CASEXC : "";
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
        getOssToken(e.a.b(str, 8, f.b.T), map, new a(ossTokenCallView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upLoadFile(String str, String str2, OssFileInfo ossFileInfo, List<String> list, List<OssFileInfo> list2, IOssPicListCallback iOssPicListCallback) {
    }

    public void upFileToOss(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
        getOssToken(ossFileRequest, new b(ossFileRequest, iOssPicCallback));
    }

    public void upFileToOssList(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) {
        this.upIndex = 0;
        getOssToken(ossFileRequest, new c(ossFileRequest, iOssPicListCallback));
    }
}
