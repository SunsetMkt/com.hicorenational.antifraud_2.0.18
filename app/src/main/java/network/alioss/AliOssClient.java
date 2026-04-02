package network.alioss;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bean.OssTokenBean;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import java.util.ArrayList;
import java.util.HashMap;
import ui.Hicore;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class AliOssClient {
    static AliOssClient instance = null;
    static String mEndpoint = "oss-cn-shanghai.aliyuncs.com";
    private OSS aiOSS;
    private OSS oss;
    private OssUploadCallBack ossCallBack;
    private OSSAsyncTask task;
    String AccessKeyID = "STS.41Xx6Vtqoj1q1dR8WARxDtaZih";
    String SecretKeyId = "BpYfGTq6uwK2MZWFBApG7rYwLeC7LupU9eNA1NmMXeuT";
    String StsToken = "CAIS7wF1q6Ft5B6yfSjI1fLtM4zima5O3fOaM0Lj3FcUXvdom6Txi3bGAXtOeHNvBuEdt/4xm21S7PcajoMcTIReAFTZcZPffymvJkTzDbDasumZsJYm6vT8a0XxZjf/2MjNGZabKPrWZvaqbX3diyZ32sGUXD6+XlujQ/br4NwdGbZxZASjaidcD9p7PxZrrNRgVUHcLvGwKBXn8AGyZQhKwlMm1jIgtPzvmJDEs0GG1QPAp7VL99irEP+NdNJxOZpzadCx0dFte7DJuCwqsEIWrvgp3fcdo2mY44vHUgEL+XWcOu/O9dliPB+J0A34oDuOxhqAASKHFdAswMiV6plFNklr2JiI8KcLne1aVQrV01CUIi8NvdMd54IQOk3TO/g1PChM/oMEX8DOWNUV7PoXynRcg4a2+5GMMfPQpS4dtSDb5lB6Y1l1DkJJI3NWND9FrgfE/mvbBLLnydTUCvWH02J/sV95FDa5ozSsxRFeZEsekjzp";
    Handler myTime = new Handler() { // from class: network.alioss.AliOssClient.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            AliOssClient.this.ossCallBack.onFailure();
            AliOssClient.this.task.cancel();
        }
    };

    /* JADX INFO: renamed from: network.alioss.AliOssClient$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            AliOssClient.this.ossCallBack.onFailure();
            AliOssClient.this.task.cancel();
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$2 */
    class AnonymousClass2 extends HashMap<String, String> {
        final /* synthetic */ OssTokenBean.CallBackBean val$backBean;

        AnonymousClass2(OssTokenBean.CallBackBean callBackBean) {
            callBackBean = callBackBean;
            put("callbackUrl", callBackBean.getCallBackUrl());
            put("callbackBody", callBackBean.getCallbackBody());
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$3 */
    class AnonymousClass3 implements OSSProgressCallback<PutObjectRequest> {
        final /* synthetic */ OssUploadCallBack val$ossCallBack;

        AnonymousClass3(OssUploadCallBack ossUploadCallBack) {
            ossUploadCallBack = ossUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        public void onProgress(PutObjectRequest putObjectRequest, long j2, long j3) {
            String str = "currentSize: " + j2 + " totalSize: " + j3;
            ossUploadCallBack.onProgress(j2, j3);
            if (j2 == j3) {
                AliOssClient.this.myTime.sendEmptyMessageDelayed(-1000, 3000L);
            }
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$4 */
    class AnonymousClass4 implements OSSCompletedCallback<PutObjectRequest, PutObjectResult> {
        final /* synthetic */ OssUploadCallBack val$ossCallBack;

        AnonymousClass4(OssUploadCallBack ossUploadCallBack) {
            ossUploadCallBack = ossUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            AliOssClient.this.myTime.removeCallbacksAndMessages(null);
            AliOssClient.this.task.cancel();
            if (clientException != null) {
                clientException.printStackTrace();
            }
            if (serviceException != null) {
                s1.b("ErrorCode", serviceException.getErrorCode());
                s1.b("RequestId", serviceException.getRequestId());
                s1.b("HostId", serviceException.getHostId());
                s1.b("RawMessage", serviceException.getRawMessage());
            }
            ossUploadCallBack.onFailure();
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            AliOssClient.this.myTime.removeCallbacksAndMessages(null);
            s1.a("PutObject", "UploadSuccess");
            s1.a(HttpHeaders.ETAG, putObjectResult.getETag());
            s1.a("RequestId", putObjectResult.getRequestId());
            s1.b("StatusCode", putObjectResult.getStatusCode() + "");
            if (putObjectResult.getStatusCode() == 200) {
                ossUploadCallBack.onSuccess(putObjectRequest, putObjectResult);
            } else {
                ossUploadCallBack.onFailure();
            }
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$5 */
    class AnonymousClass5 extends HashMap<String, String> {
        final /* synthetic */ OssTokenBean.CallBackBean val$backBean;

        AnonymousClass5(OssTokenBean.CallBackBean callBackBean) {
            callBackBean = callBackBean;
            put("callbackUrl", callBackBean.getCallBackUrl());
            put("callbackBody", callBackBean.getCallbackBody());
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$6 */
    class AnonymousClass6 implements OSSProgressCallback<PutObjectRequest> {
        final /* synthetic */ OssUploadCallBack val$ossCallBack;

        AnonymousClass6(OssUploadCallBack ossUploadCallBack) {
            ossUploadCallBack = ossUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        public void onProgress(PutObjectRequest putObjectRequest, long j2, long j3) {
            String str = "currentSize: " + j2 + " totalSize: " + j3;
            ossUploadCallBack.onProgress(j2, j3);
            if (j2 == j3) {
                AliOssClient.this.myTime.sendEmptyMessageDelayed(-1000, 3000L);
            }
        }
    }

    /* JADX INFO: renamed from: network.alioss.AliOssClient$7 */
    class AnonymousClass7 implements OSSCompletedCallback<PutObjectRequest, PutObjectResult> {
        final /* synthetic */ OssUploadCallBack val$ossCallBack;

        AnonymousClass7(OssUploadCallBack ossUploadCallBack) {
            ossUploadCallBack = ossUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            AliOssClient.this.myTime.removeCallbacksAndMessages(null);
            AliOssClient.this.task.cancel();
            if (clientException != null) {
                clientException.printStackTrace();
            }
            if (serviceException != null) {
                s1.b("ErrorCode", serviceException.getErrorCode());
                s1.b("RequestId", serviceException.getRequestId());
                s1.b("HostId", serviceException.getHostId());
                s1.b("RawMessage", serviceException.getRawMessage());
            }
            ossUploadCallBack.onFailure();
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            AliOssClient.this.myTime.removeCallbacksAndMessages(null);
            s1.a("PutObject", "UploadSuccess");
            s1.a(HttpHeaders.ETAG, putObjectResult.getETag());
            s1.a("RequestId", putObjectResult.getRequestId());
            s1.b("StatusCode", putObjectResult.getStatusCode() + "");
            if (putObjectResult.getStatusCode() == 200) {
                ossUploadCallBack.onSuccess(putObjectRequest, putObjectResult);
            } else {
                ossUploadCallBack.onFailure();
            }
        }
    }

    private void OSClientConfiguration() {
    }

    public static AliOssClient getInstance() {
        if (instance == null) {
            synchronized (AliOssClient.class) {
                if (instance == null) {
                    instance = new AliOssClient();
                }
            }
        }
        return instance;
    }

    public void initAIClient(String str, String str2, String str3, String str4) {
        OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(str2, str3, str4);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            arrayList.add(mEndpoint);
        } else {
            arrayList.add(str);
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(10000);
        clientConfiguration.setSocketTimeout(1800000);
        clientConfiguration.setMaxConcurrentRequest(15);
        clientConfiguration.setMaxErrorRetry(2);
        clientConfiguration.setCustomCnameExcludeList(arrayList);
        if (TextUtils.isEmpty(str)) {
            this.aiOSS = new OSSClient(Hicore.getApp(), mEndpoint, oSSStsTokenCredentialProvider, clientConfiguration);
        } else {
            this.aiOSS = new OSSClient(Hicore.getApp(), str, oSSStsTokenCredentialProvider, clientConfiguration);
        }
    }

    public void initClient(String str, String str2, String str3, String str4) {
        OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(str2, str3, str4);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            arrayList.add(mEndpoint);
        } else {
            arrayList.add(str);
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(10000);
        clientConfiguration.setSocketTimeout(10000);
        clientConfiguration.setMaxConcurrentRequest(15);
        clientConfiguration.setMaxErrorRetry(2);
        clientConfiguration.setCustomCnameExcludeList(arrayList);
        if (TextUtils.isEmpty(str)) {
            this.oss = new OSSClient(Hicore.getApp(), mEndpoint, oSSStsTokenCredentialProvider, clientConfiguration);
        } else {
            this.oss = new OSSClient(Hicore.getApp(), str, oSSStsTokenCredentialProvider, clientConfiguration);
        }
    }

    public boolean isFileExist(String str, String str2) {
        return this.oss.doesObjectExist(str, str2);
    }

    public void taskCancle() {
        OSSAsyncTask oSSAsyncTask = this.task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.cancel();
        }
    }

    public void upAiLoadFile(String str, String str2, String str3, OssTokenBean.CallBackBean callBackBean, OssUploadCallBack ossUploadCallBack) {
        this.ossCallBack = ossUploadCallBack;
        PutObjectRequest putObjectRequest = new PutObjectRequest(str, str2, str3);
        if (callBackBean != null) {
            putObjectRequest.setCallbackParam(new HashMap<String, String>() { // from class: network.alioss.AliOssClient.5
                final /* synthetic */ OssTokenBean.CallBackBean val$backBean;

                AnonymousClass5(OssTokenBean.CallBackBean callBackBean2) {
                    callBackBean = callBackBean2;
                    put("callbackUrl", callBackBean.getCallBackUrl());
                    put("callbackBody", callBackBean.getCallbackBody());
                }
            });
        }
        putObjectRequest.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() { // from class: network.alioss.AliOssClient.6
            final /* synthetic */ OssUploadCallBack val$ossCallBack;

            AnonymousClass6(OssUploadCallBack ossUploadCallBack2) {
                ossUploadCallBack = ossUploadCallBack2;
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public void onProgress(PutObjectRequest putObjectRequest2, long j2, long j3) {
                String str4 = "currentSize: " + j2 + " totalSize: " + j3;
                ossUploadCallBack.onProgress(j2, j3);
                if (j2 == j3) {
                    AliOssClient.this.myTime.sendEmptyMessageDelayed(-1000, 3000L);
                }
            }
        });
        this.task = this.aiOSS.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() { // from class: network.alioss.AliOssClient.7
            final /* synthetic */ OssUploadCallBack val$ossCallBack;

            AnonymousClass7(OssUploadCallBack ossUploadCallBack2) {
                ossUploadCallBack = ossUploadCallBack2;
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(PutObjectRequest putObjectRequest2, ClientException clientException, ServiceException serviceException) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                AliOssClient.this.task.cancel();
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    s1.b("ErrorCode", serviceException.getErrorCode());
                    s1.b("RequestId", serviceException.getRequestId());
                    s1.b("HostId", serviceException.getHostId());
                    s1.b("RawMessage", serviceException.getRawMessage());
                }
                ossUploadCallBack.onFailure();
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(PutObjectRequest putObjectRequest2, PutObjectResult putObjectResult) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                s1.a("PutObject", "UploadSuccess");
                s1.a(HttpHeaders.ETAG, putObjectResult.getETag());
                s1.a("RequestId", putObjectResult.getRequestId());
                s1.b("StatusCode", putObjectResult.getStatusCode() + "");
                if (putObjectResult.getStatusCode() == 200) {
                    ossUploadCallBack.onSuccess(putObjectRequest2, putObjectResult);
                } else {
                    ossUploadCallBack.onFailure();
                }
            }
        });
    }

    public void upLoadFile(String str, String str2, String str3, OssTokenBean.CallBackBean callBackBean, OssUploadCallBack ossUploadCallBack) {
        this.ossCallBack = ossUploadCallBack;
        PutObjectRequest putObjectRequest = new PutObjectRequest(str, str2, str3);
        if (callBackBean != null) {
            putObjectRequest.setCallbackParam(new HashMap<String, String>() { // from class: network.alioss.AliOssClient.2
                final /* synthetic */ OssTokenBean.CallBackBean val$backBean;

                AnonymousClass2(OssTokenBean.CallBackBean callBackBean2) {
                    callBackBean = callBackBean2;
                    put("callbackUrl", callBackBean.getCallBackUrl());
                    put("callbackBody", callBackBean.getCallbackBody());
                }
            });
        }
        putObjectRequest.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() { // from class: network.alioss.AliOssClient.3
            final /* synthetic */ OssUploadCallBack val$ossCallBack;

            AnonymousClass3(OssUploadCallBack ossUploadCallBack2) {
                ossUploadCallBack = ossUploadCallBack2;
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public void onProgress(PutObjectRequest putObjectRequest2, long j2, long j3) {
                String str4 = "currentSize: " + j2 + " totalSize: " + j3;
                ossUploadCallBack.onProgress(j2, j3);
                if (j2 == j3) {
                    AliOssClient.this.myTime.sendEmptyMessageDelayed(-1000, 3000L);
                }
            }
        });
        this.task = this.oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() { // from class: network.alioss.AliOssClient.4
            final /* synthetic */ OssUploadCallBack val$ossCallBack;

            AnonymousClass4(OssUploadCallBack ossUploadCallBack2) {
                ossUploadCallBack = ossUploadCallBack2;
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(PutObjectRequest putObjectRequest2, ClientException clientException, ServiceException serviceException) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                AliOssClient.this.task.cancel();
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    s1.b("ErrorCode", serviceException.getErrorCode());
                    s1.b("RequestId", serviceException.getRequestId());
                    s1.b("HostId", serviceException.getHostId());
                    s1.b("RawMessage", serviceException.getRawMessage());
                }
                ossUploadCallBack.onFailure();
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(PutObjectRequest putObjectRequest2, PutObjectResult putObjectResult) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                s1.a("PutObject", "UploadSuccess");
                s1.a(HttpHeaders.ETAG, putObjectResult.getETag());
                s1.a("RequestId", putObjectResult.getRequestId());
                s1.b("StatusCode", putObjectResult.getStatusCode() + "");
                if (putObjectResult.getStatusCode() == 200) {
                    ossUploadCallBack.onSuccess(putObjectRequest2, putObjectResult);
                } else {
                    ossUploadCallBack.onFailure();
                }
            }
        });
    }

    public void waitUntilFinished() {
        OSSAsyncTask oSSAsyncTask = this.task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.waitUntilFinished();
        }
    }
}
