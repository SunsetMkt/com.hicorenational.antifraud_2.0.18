package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {
    private Context a;

    /* JADX INFO: renamed from: b */
    private TOption f4506b;

    /* JADX INFO: renamed from: c */
    private Context f4507c;

    /* JADX INFO: renamed from: d */
    private AbstractClientBuilder<?, TOption> f4508d;

    /* JADX INFO: renamed from: e */
    private String f4509e;

    /* JADX INFO: renamed from: f */
    private String f4510f;

    /* JADX INFO: renamed from: g */
    private SubAppInfo f4511g;

    /* JADX INFO: renamed from: h */
    private WeakReference<Activity> f4512h;

    /* JADX INFO: renamed from: i */
    private int f4513i;

    /* JADX INFO: renamed from: j */
    private int f4514j = 1;

    /* JADX INFO: renamed from: k */
    private boolean f4515k = false;

    /* JADX INFO: renamed from: l */
    private String f4516l;

    /* JADX INFO: renamed from: m */
    private boolean f4517m;

    /* JADX INFO: renamed from: n */
    private RequestManager f4518n;

    /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ HuaweiApi a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ TaskCompletionSource f4519b;

        AnonymousClass1(HuaweiApi huaweiApi, TaskCompletionSource taskCompletionSource) {
            huaweiApi = huaweiApi;
            taskCompletionSource = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            HuaweiApi.this.a((HuaweiApi<?>) huaweiApi, (TaskCompletionSource<Boolean>) taskCompletionSource);
        }
    }

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: b */
        private final AnyClient f4521b;

        /* JADX INFO: renamed from: d */
        private final HuaweiApi<OptionsT> f4523d;

        /* JADX INFO: renamed from: e */
        private ResolveClientBean f4524e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();
        private final Queue<TaskApiCallbackWrapper> a = new LinkedList();

        /* JADX INFO: renamed from: c */
        private ConnectionResult f4522c = null;

        /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$1 */
        class AnonymousClass1 implements AnyClient.CallBack {
            private AtomicBoolean a = new AtomicBoolean(true);

            /* JADX INFO: renamed from: b */
            final /* synthetic */ TaskApiCallWrapper f4525b;

            AnonymousClass1(TaskApiCallWrapper taskApiCallWrapper) {
                taskApiCallWrapper = taskApiCallWrapper;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(IMessageEntity iMessageEntity, String str) {
                if (!(iMessageEntity instanceof ResponseHeader)) {
                    HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                    return;
                }
                ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                if (responseHeader.getErrorCode() == 11) {
                    RequestHandler.this.a();
                    HMSLog.i("HuaweiApi", "unbind service");
                }
                if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                    HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                }
                if (this.a.compareAndSet(true, false)) {
                    HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f4523d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f4523d.getKitSdkVersion()));
                }
                taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f4521b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
            }
        }

        /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2 */
        class AnonymousClass2 implements AnyClient.CallBack {
            final /* synthetic */ TaskApiCallbackWrapper a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ RequestHeader f4527b;

            /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.a.remove(taskApiCallbackWrapper);
                }
            }

            AnonymousClass2(TaskApiCallbackWrapper taskApiCallbackWrapper, RequestHeader requestHeader) {
                taskApiCallbackWrapper = taskApiCallbackWrapper;
                requestHeader = requestHeader;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(IMessageEntity iMessageEntity, String str) {
                AnyClient.CallBack callBackB = taskApiCallbackWrapper.b();
                if (callBackB != null) {
                    callBackB.onCallback(iMessageEntity, str);
                }
                RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RequestHandler.this.a.remove(taskApiCallbackWrapper);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ ConnectionResult a;

            AnonymousClass3(ConnectionResult connectionResult) {
                connectionResult = connectionResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.b(connectionResult);
            }
        }

        /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$4 */
        class AnonymousClass4 implements Runnable {
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.b();
            }
        }

        /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$5 */
        class AnonymousClass5 implements Runnable {
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.c();
            }
        }

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f4523d = huaweiApi;
            this.f4521b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f4521b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f4524e);
            this.f4524e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f4524e);
            this.f4524e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                final /* synthetic */ ConnectionResult a;

                AnonymousClass3(ConnectionResult connectionResult2) {
                    connectionResult = connectionResult2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i2) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f4524e);
            this.f4524e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.c();
                }
            });
        }

        public void postMessage(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.a().getTaskApiCall().getTransactionId(), this);
            this.a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f4523d).f4507c == null ? this.f4523d.getContext() : ((HuaweiApi) this.f4523d).f4507c).getPackageName();
            if (((HuaweiApi) this.f4523d).f4507c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f4523d;
                huaweiApi.b(((HuaweiApi) huaweiApi).f4507c);
            }
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f4523d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f4523d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f4521b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f4523d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f4523d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f4521b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                final /* synthetic */ TaskApiCallbackWrapper a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ RequestHeader f4527b;

                /* JADX INFO: renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RequestHandler.this.a.remove(taskApiCallbackWrapper);
                    }
                }

                AnonymousClass2(TaskApiCallbackWrapper taskApiCallbackWrapper2, RequestHeader requestHeader2) {
                    taskApiCallbackWrapper = taskApiCallbackWrapper2;
                    requestHeader = requestHeader2;
                }

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack callBackB = taskApiCallbackWrapper.b();
                    if (callBackB != null) {
                        callBackB.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        private TaskApiCallbackWrapper b(TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1
                private AtomicBoolean a = new AtomicBoolean(true);

                /* JADX INFO: renamed from: b */
                final /* synthetic */ TaskApiCallWrapper f4525b;

                AnonymousClass1(TaskApiCallWrapper taskApiCallWrapper2) {
                    taskApiCallWrapper = taskApiCallWrapper2;
                }

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.a();
                        HMSLog.i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f4523d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f4523d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f4521b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        public void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.a.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.a.clear();
            this.f4522c = null;
            this.f4521b.disconnect();
        }

        public void b(ConnectionResult connectionResult) {
            this.f4522c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                TaskApiCallWrapper taskApiCallWrapperA = it.next().a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f4523d.getContext(), responseHeader, String.valueOf(this.f4523d.getKitSdkVersion()));
                if (this.f4522c.getResolution() != null && z) {
                    responseHeader.setParcelable(this.f4522c.getResolution());
                    z = false;
                    if (Util.isAvailableLibExist(this.f4523d.getContext()) && this.f4522c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                }
                int errorCode = this.f4522c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                taskApiCallWrapperA.getTaskApiCall().onResponse(this.f4521b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.a.clear();
            this.f4522c = null;
            this.f4521b.disconnect();
        }

        void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper taskApiCallbackWrapperB = b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f4523d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f4521b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f4523d).a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f4521b.isConnected() && !((HuaweiApi) this.f4523d).f4517m && ((BaseHmsClient) this.f4521b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f4521b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f4521b.disconnect();
                }
            }
            if (this.f4521b.isConnected()) {
                HMSLog.i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter2 = ((BaseHmsClient) this.f4521b).getAdapter();
                adapter2.updateDelayTask();
                ((HmsClient) this.f4521b).setService(IAIDLInvoke.Stub.asInterface(adapter2.getServiceBinder()));
                postMessage(taskApiCallbackWrapperB);
                return;
            }
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(taskApiCallbackWrapperB);
            ConnectionResult connectionResult = this.f4522c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f4522c.getErrorCode());
                onConnectionFailed(this.f4522c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f4521b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), taskApiCallbackWrapperB);
        }

        public void b() {
            this.f4522c = null;
            this.a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f4523d.getAppID(), str2) : str;
        }

        synchronized void a(int i2, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f4521b.isConnected()) {
                HMSLog.d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f4521b.isConnecting()) {
                HMSLog.d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f4523d.getActivity() != null) {
                if (this.f4524e == null) {
                    this.f4524e = new ResolveClientBean(this.f4521b, i2);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f4524e)) {
                    HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f4524e);
            }
            this.f4521b.connect(i2);
        }

        void a() {
            this.f4521b.disconnect();
        }

        private void a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper taskApiCallWrapperA = taskApiCallbackWrapper.a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
            taskApiCallWrapperA.getTaskApiCall().onResponse(this.f4521b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
        }

        private String a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f4523d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                        return "application configuration error, please developer check configuration";
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                    return "application configuration error, please developer check configuration";
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
        }
    }

    public static class TaskApiCallbackWrapper {
        private final TaskApiCallWrapper a;

        /* JADX INFO: renamed from: b */
        private final AnyClient.CallBack f4530b;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.a = taskApiCallWrapper;
            this.f4530b = callBack;
        }

        TaskApiCallWrapper a() {
            return this.a;
        }

        AnyClient.CallBack b() {
            return this.f4530b;
        }
    }

    private static class a<OptionsT extends Api.ApiOptions> implements Runnable {
        private final HuaweiApi<OptionsT> a;

        /* JADX INFO: renamed from: b */
        private final TaskApiCallWrapper f4531b;

        public a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.a = huaweiApi;
            this.f4531b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(RequestHandler requestHandler, Throwable th) {
            Throwable th2;
            AnyClient client;
            String string;
            ResponseHeader responseHeader;
            TaskCompletionSource taskCompletionSource;
            TaskApiCall taskApiCall = null;
            try {
                client = requestHandler.getClient();
            } catch (Throwable th3) {
                th2 = th3;
                client = null;
            }
            try {
                responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, th.getMessage());
                try {
                    string = new JSONObject().toString();
                    try {
                        taskCompletionSource = this.f4531b.getTaskCompletionSource();
                    } catch (Throwable th4) {
                        th2 = th4;
                        taskCompletionSource = null;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    string = null;
                    taskCompletionSource = null;
                }
                try {
                    taskApiCall = this.f4531b.getTaskApiCall();
                } catch (Throwable th6) {
                    th2 = th6;
                    HMSLog.e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                }
            } catch (Throwable th7) {
                th2 = th7;
                string = null;
                responseHeader = null;
                taskCompletionSource = null;
                HMSLog.e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                if ((client != null || responseHeader == null || string == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                }
            }
            if ((client != null || responseHeader == null || string == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                HMSLog.e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
            } else {
                taskApiCall.onResponse(client, responseHeader, string, taskCompletionSource);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.a);
            try {
                requestHandler.a(this.f4531b);
            } catch (Throwable th) {
                a(requestHandler, th);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f4512h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i2, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            final /* synthetic */ HuaweiApi a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ TaskCompletionSource f4519b;

            AnonymousClass1(HuaweiApi this, TaskCompletionSource taskCompletionSource2) {
                huaweiApi = this;
                taskCompletionSource = taskCompletionSource2;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.a((HuaweiApi<?>) huaweiApi, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource2.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f4515k = true;
        if (taskApiCall == null) {
            HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.a, taskApiCall.getUri(), TextUtils.isEmpty(this.f4511g.getSubAppID()) ? this.f4510f : this.f4511g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f4518n == null) {
            this.f4518n = RequestManager.getInstance();
        }
        return a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f4512h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f4514j;
    }

    public String getAppID() {
        return this.f4510f;
    }

    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f4508d.buildClient(this.a, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.a.getPackageName(), this.a.getClass().getName(), getScopes(), this.f4509e, null, this.f4511g);
        if (!this.f4517m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f4516l = hMSPackageNameForMultiService;
            HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f4516l);
        }
        clientSettings.setInnerHmsPkg(this.f4516l);
        clientSettings.setUseInnerHms(this.f4517m);
        WeakReference<Activity> weakReference = this.f4512h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.a;
    }

    public int getKitSdkVersion() {
        return this.f4513i;
    }

    public TOption getOption() {
        return this.f4506b;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f4511g.getSubAppID();
    }

    public void setApiLevel(int i2) {
        this.f4514j = i2;
    }

    public void setHostContext(Context context) {
        this.f4507c = context;
    }

    public void setInnerHms() {
        this.f4516l = this.a.getPackageName();
        this.f4517m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f4516l);
    }

    public void setKitSdkVersion(int i2) {
        this.f4513i = i2;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f4511g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f4509e)) {
            HMSLog.e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f4515k) {
            HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f4511g = new SubAppInfo(subAppInfo);
        return true;
    }

    public void b(Context context) {
        String appId = Util.getAppId(context);
        this.f4509e = appId;
        this.f4510f = appId;
    }

    private void a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        this.a = context.getApplicationContext();
        this.f4506b = toption;
        this.f4508d = abstractClientBuilder;
        b(context);
        this.f4511g = new SubAppInfo("");
        this.f4513i = i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f4509e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.i("HuaweiApi", "subAppId is " + str);
                this.f4511g = new SubAppInfo(str);
            }
        }
        a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f4512h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i2, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f4512h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i2, null);
    }

    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e2) {
            HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e2.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i2, str);
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
