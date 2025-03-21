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

/* loaded from: classes.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* renamed from: a */
    private Context f7197a;

    /* renamed from: b */
    private TOption f7198b;

    /* renamed from: c */
    private Context f7199c;

    /* renamed from: d */
    private AbstractClientBuilder<?, TOption> f7200d;

    /* renamed from: e */
    private String f7201e;

    /* renamed from: f */
    private String f7202f;

    /* renamed from: g */
    private SubAppInfo f7203g;

    /* renamed from: h */
    private WeakReference<Activity> f7204h;

    /* renamed from: i */
    private int f7205i;

    /* renamed from: j */
    private int f7206j = 1;

    /* renamed from: k */
    private boolean f7207k = false;

    /* renamed from: l */
    private String f7208l;

    /* renamed from: m */
    private boolean f7209m;

    /* renamed from: n */
    private RequestManager f7210n;

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* renamed from: b */
        private final AnyClient f7215b;

        /* renamed from: d */
        private final HuaweiApi<OptionsT> f7217d;

        /* renamed from: e */
        private ResolveClientBean f7218e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* renamed from: a */
        private final Queue<TaskApiCallbackWrapper> f7214a = new LinkedList();

        /* renamed from: c */
        private ConnectionResult f7216c = null;

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f7217d = huaweiApi;
            this.f7215b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f7215b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.m7717i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f7218e);
            this.f7218e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m6701b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.m7717i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f7218e);
            this.f7218e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m6702b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i2) {
            HMSLog.m7717i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f7218e);
            this.f7218e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m6705c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.m6711a().getTaskApiCall().getTransactionId(), this);
            this.f7214a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.m6711a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f7217d).f7199c == null ? this.f7217d.getContext() : ((HuaweiApi) this.f7217d).f7199c).getPackageName();
            if (((HuaweiApi) this.f7217d).f7199c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f7217d;
                huaweiApi.m6692b(((HuaweiApi) huaweiApi).f7199c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f7217d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f7217d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f7215b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.m6711a().getTaskApiCall();
            requestHeader.setTransactionId(m6697a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f7217d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f7217d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f7215b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack m6712b = taskApiCallbackWrapper.m6712b();
                    if (m6712b != null) {
                        m6712b.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f7214a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        /* renamed from: b */
        private TaskApiCallbackWrapper m6700b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* renamed from: a */
                private AtomicBoolean f7219a = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.m7715e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.m6708a();
                        HMSLog.m7717i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.m7715e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f7219a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f7217d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f7217d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f7215b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m6705c() {
            HMSLog.m7717i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.m7717i("HuaweiApi", "run queue size = " + this.f7214a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                m6699a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.f7214a.iterator();
            while (it2.hasNext()) {
                m6699a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.f7214a.clear();
            this.f7216c = null;
            this.f7215b.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m6702b(ConnectionResult connectionResult) {
            this.f7216c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                TaskApiCallWrapper m6711a = it.next().m6711a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + m6696a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(m6711a.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f7217d.getContext(), responseHeader, String.valueOf(this.f7217d.getKitSdkVersion()));
                if (this.f7216c.getResolution() != null && z) {
                    responseHeader.setParcelable(this.f7216c.getResolution());
                    z = false;
                    if (Util.isAvailableLibExist(this.f7217d.getContext()) && this.f7216c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                }
                int errorCode = this.f7216c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                m6711a.getTaskApiCall().onResponse(this.f7215b, responseHeader, null, m6711a.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f7214a.clear();
            this.f7216c = null;
            this.f7215b.disconnect();
        }

        /* renamed from: a */
        void m6710a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.m7717i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper m6700b = m6700b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f7217d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f7215b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f7217d).f7197a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f7215b.isConnected() && !((HuaweiApi) this.f7217d).f7209m && ((BaseHmsClient) this.f7215b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f7215b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f7215b.disconnect();
                }
            }
            if (this.f7215b.isConnected()) {
                HMSLog.m7717i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter2 = ((BaseHmsClient) this.f7215b).getAdapter();
                adapter2.updateDelayTask();
                ((HmsClient) this.f7215b).setService(IAIDLInvoke.Stub.asInterface(adapter2.getServiceBinder()));
                postMessage(m6700b);
                return;
            }
            HMSLog.m7717i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(m6700b);
            ConnectionResult connectionResult = this.f7216c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.m7717i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f7216c.getErrorCode());
                onConnectionFailed(this.f7216c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f7215b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            m6709a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), m6700b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m6701b() {
            this.f7216c = null;
            this.f7214a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        /* renamed from: a */
        private String m6697a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f7217d.getAppID(), str2) : str;
        }

        /* renamed from: a */
        synchronized void m6709a(int i2, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f7215b.isConnected()) {
                HMSLog.m7712d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f7215b.isConnecting()) {
                HMSLog.m7712d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f7217d.getActivity() != null) {
                if (this.f7218e == null) {
                    this.f7218e = new ResolveClientBean(this.f7215b, i2);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f7218e)) {
                    HMSLog.m7717i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f7218e);
            }
            this.f7215b.connect(i2);
        }

        /* renamed from: a */
        void m6708a() {
            this.f7215b.disconnect();
        }

        /* renamed from: a */
        private void m6699a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper m6711a = taskApiCallbackWrapper.m6711a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(m6711a.getTaskApiCall().getTransactionId());
            m6711a.getTaskApiCall().onResponse(this.f7215b, responseHeader, null, m6711a.getTaskCompletionSource());
        }

        /* renamed from: a */
        private String m6696a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f7217d.getContext())) {
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

        /* renamed from: a */
        private final TaskApiCallWrapper f7230a;

        /* renamed from: b */
        private final AnyClient.CallBack f7231b;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f7230a = taskApiCallWrapper;
            this.f7231b = callBack;
        }

        /* renamed from: a */
        TaskApiCallWrapper m6711a() {
            return this.f7230a;
        }

        /* renamed from: b */
        AnyClient.CallBack m6712b() {
            return this.f7231b;
        }
    }

    /* renamed from: com.huawei.hms.common.HuaweiApi$a */
    private static class RunnableC2328a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a */
        private final HuaweiApi<OptionsT> f7232a;

        /* renamed from: b */
        private final TaskApiCallWrapper f7233b;

        public RunnableC2328a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f7232a = huaweiApi;
            this.f7233b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m6713a(com.huawei.hms.common.HuaweiApi.RequestHandler r9, java.lang.Throwable r10) {
            /*
                r8 = this;
                java.lang.String r0 = "HuaweiApi"
                r1 = 1
                r2 = 0
                com.huawei.hms.common.internal.AnyClient r9 = r9.getClient()     // Catch: java.lang.Throwable -> L36
                com.huawei.hms.common.internal.ResponseHeader r3 = new com.huawei.hms.common.internal.ResponseHeader     // Catch: java.lang.Throwable -> L33
                r4 = 907135001(0x3611c819, float:2.1723156E-6)
                java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L33
                r3.<init>(r1, r4, r10)     // Catch: java.lang.Throwable -> L33
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2f
                r10.<init>()     // Catch: java.lang.Throwable -> L2f
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L2f
                com.huawei.hms.common.internal.TaskApiCallWrapper r4 = r8.f7233b     // Catch: java.lang.Throwable -> L2c
                com.huawei.hmf.tasks.TaskCompletionSource r4 = r4.getTaskCompletionSource()     // Catch: java.lang.Throwable -> L2c
                com.huawei.hms.common.internal.TaskApiCallWrapper r5 = r8.f7233b     // Catch: java.lang.Throwable -> L2a
                com.huawei.hms.common.internal.TaskApiCall r2 = r5.getTaskApiCall()     // Catch: java.lang.Throwable -> L2a
                goto L54
            L2a:
                r5 = move-exception
                goto L3c
            L2c:
                r5 = move-exception
                r4 = r2
                goto L3c
            L2f:
                r5 = move-exception
                r10 = r2
                r4 = r10
                goto L3c
            L33:
                r10 = move-exception
                r5 = r10
                goto L39
            L36:
                r9 = move-exception
                r5 = r9
                r9 = r2
            L39:
                r10 = r2
                r3 = r10
                r4 = r3
            L3c:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "<notifyCpException> "
                r6.append(r7)
                java.lang.String r5 = r5.getMessage()
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                com.huawei.hms.support.log.HMSLog.m7715e(r0, r5)
            L54:
                if (r9 == 0) goto L5f
                if (r3 == 0) goto L5f
                if (r10 == 0) goto L5f
                if (r4 == 0) goto L5f
                if (r2 == 0) goto L5f
                goto L60
            L5f:
                r1 = 0
            L60:
                if (r1 == 0) goto L66
                r2.onResponse(r9, r3, r10, r4)
                goto L6b
            L66:
                java.lang.String r9 = "<notifyCpException> isNotify is false, Can not notify CP."
                com.huawei.hms.support.log.HMSLog.m7715e(r0, r9)
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.RunnableC2328a.m6713a(com.huawei.hms.common.HuaweiApi$RequestHandler, java.lang.Throwable):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f7232a);
            try {
                requestHandler.m6710a(this.f7233b);
            } catch (Throwable th) {
                m6713a(requestHandler, th);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f7204h = new WeakReference<>(activity);
        m6688a(activity, api, toption, abstractClientBuilder, i2, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.m6690a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f7207k = true;
        if (taskApiCall == null) {
            HMSLog.m7715e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f7197a, taskApiCall.getUri(), TextUtils.isEmpty(this.f7203g.getSubAppID()) ? this.f7202f : this.f7203g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f7210n == null) {
            this.f7210n = RequestManager.getInstance();
        }
        return m6686a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f7204h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f7206j;
    }

    public String getAppID() {
        return this.f7202f;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f7200d.buildClient(this.f7197a, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f7197a.getPackageName(), this.f7197a.getClass().getName(), getScopes(), this.f7201e, null, this.f7203g);
        if (!this.f7209m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f7197a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f7208l = hMSPackageNameForMultiService;
            HMSLog.m7717i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f7208l);
        }
        clientSettings.setInnerHmsPkg(this.f7208l);
        clientSettings.setUseInnerHms(this.f7209m);
        WeakReference<Activity> weakReference = this.f7204h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f7197a;
    }

    public int getKitSdkVersion() {
        return this.f7205i;
    }

    public TOption getOption() {
        return this.f7198b;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f7203g.getSubAppID();
    }

    public void setApiLevel(int i2) {
        this.f7206j = i2;
    }

    public void setHostContext(Context context) {
        this.f7199c = context;
    }

    public void setInnerHms() {
        this.f7208l = this.f7197a.getPackageName();
        this.f7209m = true;
        HMSLog.m7717i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f7208l);
    }

    public void setKitSdkVersion(int i2) {
        this.f7205i = i2;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m7717i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f7203g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.m7715e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.m7715e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m7715e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f7201e)) {
            HMSLog.m7715e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f7207k) {
            HMSLog.m7715e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f7203g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6692b(Context context) {
        String appId = Util.getAppId(context);
        this.f7201e = appId;
        this.f7202f = appId;
    }

    /* renamed from: a */
    private void m6688a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        this.f7197a = context.getApplicationContext();
        this.f7198b = toption;
        this.f7200d = abstractClientBuilder;
        m6692b(context);
        this.f7203g = new SubAppInfo("");
        this.f7205i = i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f7201e)) {
                HMSLog.m7715e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.m7717i("HuaweiApi", "subAppId is " + str);
                this.f7203g = new SubAppInfo(str);
            }
        }
        m6687a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f7204h = new WeakReference<>(activity);
        m6688a(activity, api, toption, abstractClientBuilder, i2, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f7204h = new WeakReference<>(activity);
        m6688a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    /* renamed from: a */
    private void m6687a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m6688a(context, api, toption, abstractClientBuilder, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6690a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.m7717i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e2) {
            HMSLog.m7718w("HuaweiApi", "disconnect the binder failed for:" + e2.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m6688a(context, api, toption, abstractClientBuilder, i2, str);
    }

    /* renamed from: a */
    private <TResult, TClient extends AnyClient> Task<TResult> m6686a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new RunnableC2328a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m6688a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
