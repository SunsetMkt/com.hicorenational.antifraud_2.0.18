package ui.presenter;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.OssTokenBean;
import bean.module.ModuelConfig;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IRCallback;
import interfaces.PermissionsListener;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.alioss.OssUploadCallBack;
import ui.callview.AIVerifyImageCallView;
import ui.model.ModelPresent;
import util.g2;
import util.j1;
import util.t1;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyImagePresenter extends ModelPresent<AIVerifyImageCallView> {
    private boolean mCurrentState;

    class a implements PermissionsListener {
        final /* synthetic */ Fragment a;

        a(Fragment fragment) {
            this.a = fragment;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(AIVerifyImagePresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(this.a, 5L, PictureMimeType.ofImage(), 1).forResult(1021);
        }
    }

    class b extends MiddleSubscriber<APIresult<OssTokenBean>> {
        final /* synthetic */ OssFileRequest a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f14254b;

        class a implements IRCallback {
            final /* synthetic */ OssTokenBean a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ File f14256b;

            a(OssTokenBean ossTokenBean, File file) {
                this.a = ossTokenBean;
                this.f14256b = file;
            }

            @Override // interfaces.IRCallback
            public void onFail(String str) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError(str);
            }

            @Override // interfaces.IRCallback
            public void onSuccess() {
                String str = this.a.getPath() + "/" + b.this.f14254b + "." + j1.d(this.f14256b.getName());
                b bVar = b.this;
                AIVerifyImagePresenter.this.startInformationVerify(this.f14256b, bVar.f14254b, str);
            }
        }

        b(OssFileRequest ossFileRequest, String str) {
            this.a = ossFileRequest;
            this.f14254b = str;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return OssTokenBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<OssTokenBean> aPIresult) {
            if (aPIresult.getCode() != 0) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            OssTokenBean data = aPIresult.getData();
            if (data == null) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            OssTokenBean.Credential stsCredentials = data.getStsCredentials();
            if (stsCredentials == null) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError("\u7cfb\u7edf\u51fa\u5c0f\u5dee,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            if (data.isExist() == 0) {
                AliOssClient.getInstance().initAIClient(data.getEndPoint(), stsCredentials.getAccessKeyId(), stsCredentials.getAccessKeySecret(), stsCredentials.getSecurityToken());
            }
            String bucketName = data.getBucketName();
            String path = data.getPath();
            OssTokenBean.CallBackBean callBack = data.getCallBack();
            if (this.a == null) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError("\u6587\u4ef6\u4e3a\u7a7a,\u8bf7\u91cd\u65b0\u9009\u62e9");
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
            AIVerifyImagePresenter.this.conUpLoadFile(bucketName, str, callBack, this.a.getFilePath(), new a(data, file));
        }
    }

    class c implements OssUploadCallBack {
        final /* synthetic */ IRCallback a;

        c(IRCallback iRCallback) {
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

    class d extends MiddleSubscriber<APIresult<Object>> {
        d() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Object> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onSuccess(aPIresult.getEncodeStr());
            } else {
                ((AIVerifyImageCallView) AIVerifyImagePresenter.this.mvpView).onError(aPIresult.getMsg());
            }
        }
    }

    public AIVerifyImagePresenter(Activity activity, AIVerifyImageCallView aIVerifyImageCallView) {
        super(activity, aIVerifyImageCallView);
        this.mCurrentState = false;
    }

    public void conUpLoadFile(String str, String str2, OssTokenBean.CallBackBean callBackBean, String str3, IRCallback iRCallback) {
        AliOssClient.getInstance().upAiLoadFile(str, str2, str3, callBackBean, new c(iRCallback));
    }

    private String getTruePath(String str) {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = this.mActivity.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    public void startInformationVerify(File file, String str, String str2) {
        String str3 = e.a.f10139c + f.b.j2;
        HashMap map = new HashMap();
        map.put("ossFilePath", str2);
        map.put("localFilePath", file.getPath());
        map.put("fileName", str);
        map.put("fileFormat", j1.d(file.getName()));
        map.put("resolutionRatio", j1.i(file.getPath()));
        map.put("fileSize", "" + file.length());
        checkImageInformationVerify(str3, map, new d());
    }

    public void changePath(List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    public final void getOssAIToken(OssFileRequest ossFileRequest) {
        File file = new File(ossFileRequest.getFilePath());
        String strA = t1.a(file);
        ossFileRequest.setFileMd5(strA);
        String strB = t1.b(strA + AccountManager.getAccountId() + System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(strB);
        sb.append(g2.f(file.getName()));
        ossFileRequest.setFileName(sb.toString());
        HashMap map = new HashMap();
        map.put("fileScopeType", ossFileRequest.getType());
        map.put("regionCode", AccountManager.getRegisterRegionCode());
        getOssToken(e.a.a(ModuelConfig.MODEL_REPORT, 8, f.b.T), map, new b(ossFileRequest, strB));
    }

    public void selectPicture(Fragment fragment) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a(fragment));
    }
}
