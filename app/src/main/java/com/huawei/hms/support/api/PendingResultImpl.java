package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* renamed from: a */
    private CountDownLatch f7829a;

    /* renamed from: c */
    private WeakReference<ApiClient> f7831c;
    protected DatagramTransport transport = null;

    /* renamed from: b */
    private R f7830b = null;

    /* renamed from: d */
    private String f7832d = null;

    /* renamed from: e */
    private String f7833e = null;

    /* renamed from: f */
    private boolean f7834f = true;

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$a */
    class C2509a implements DatagramTransport.InterfaceC2523a {
        C2509a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC2523a
        /* renamed from: a */
        public void mo7669a(int i2, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.m7665a(i2, iMessageEntity);
            PendingResultImpl.this.f7829a.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$b */
    class C2510b implements DatagramTransport.InterfaceC2523a {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f7836a;

        C2510b(AtomicBoolean atomicBoolean) {
            this.f7836a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC2523a
        /* renamed from: a */
        public void mo7669a(int i2, IMessageEntity iMessageEntity) {
            if (!this.f7836a.get()) {
                PendingResultImpl.this.m7665a(i2, iMessageEntity);
            }
            PendingResultImpl.this.f7829a.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$c */
    class C2511c implements DatagramTransport.InterfaceC2523a {

        /* renamed from: a */
        final /* synthetic */ HandlerC2512d f7838a;

        /* renamed from: b */
        final /* synthetic */ ResultCallback f7839b;

        C2511c(HandlerC2512d handlerC2512d, ResultCallback resultCallback) {
            this.f7838a = handlerC2512d;
            this.f7839b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC2523a
        /* renamed from: a */
        public void mo7669a(int i2, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.m7665a(i2, iMessageEntity);
            this.f7838a.m7670a(this.f7839b, PendingResultImpl.this.f7830b);
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$d */
    protected static class HandlerC2512d<R extends Result> extends Handler {
        public HandlerC2512d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m7670a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        protected void m7671b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Pair pair = (Pair) message.obj;
            m7671b((ResultCallback) pair.first, (Result) pair.second);
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        m7667a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.m7717i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.m7715e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.m7717i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f7831c;
        if (weakReference == null) {
            HMSLog.m7715e("PendingResultImpl", "api is null");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f7830b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m7715e("PendingResultImpl", "client invalid");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f7830b;
        }
        if (this.f7834f) {
            m7664a(0, 1);
        }
        this.transport.send(apiClient, new C2509a());
        try {
            this.f7829a.await();
        } catch (InterruptedException unused) {
            HMSLog.m7715e("PendingResultImpl", "await in anythread InterruptedException");
            m7665a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f7830b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    protected Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    protected R onError(int i2) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r = (R) type2.newInstance();
                this.f7830b = r;
                r.setStatus(new Status(i2));
            } catch (Exception e2) {
                HMSLog.m7715e("PendingResultImpl", "on Error:" + e2.getMessage());
                return null;
            }
        }
        return this.f7830b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f7834f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    /* renamed from: a */
    private void m7667a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i2) {
        HMSLog.m7717i("PendingResultImpl", "init uri:" + str);
        this.f7832d = str;
        if (apiClient == null) {
            HMSLog.m7715e("PendingResultImpl", "client is null");
            return;
        }
        this.f7831c = new WeakReference<>(apiClient);
        this.f7829a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i2));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            HMSLog.m7715e("PendingResultImpl", "gen transport error:" + e2.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e2.getMessage(), e2);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.m7717i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        HandlerC2512d handlerC2512d = new HandlerC2512d(looper);
        WeakReference<ApiClient> weakReference = this.f7831c;
        if (weakReference == null) {
            HMSLog.m7715e("PendingResultImpl", "api is null");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m7715e("PendingResultImpl", "client is invalid");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            handlerC2512d.m7670a(resultCallback, this.f7830b);
        } else {
            if (this.f7834f) {
                m7664a(0, 1);
            }
            this.transport.post(apiClient, new C2511c(handlerC2512d, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j2, TimeUnit timeUnit) {
        HMSLog.m7717i("PendingResultImpl", "await timeout:" + j2 + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j2, timeUnit);
        }
        HMSLog.m7717i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        m7667a(apiClient, str, iMessageEntity, cls, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m7665a(int i2, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.m7717i("PendingResultImpl", "setResult:" + i2);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i2 == 0) {
            this.f7830b = onComplete(iMessageEntity);
        } else {
            this.f7830b = onError(i2);
        }
        if (this.f7834f) {
            m7664a(i2, 2);
        }
        R r = this.f7830b;
        if (r == null || (status = r.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            HMSLog.m7715e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
            HMSLog.m7715e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            return;
        }
        if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
            return;
        }
        HMSLog.m7717i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
        this.f7830b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i2) {
        m7667a(apiClient, str, iMessageEntity, getResponseType(), i2);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j2, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j2, TimeUnit timeUnit) {
        HMSLog.m7717i("PendingResultImpl", "awaitOnAnyThread timeout:" + j2 + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.f7831c;
        if (weakReference == null) {
            HMSLog.m7715e("PendingResultImpl", "api is null");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f7830b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m7715e("PendingResultImpl", "client invalid");
            m7665a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f7830b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f7834f) {
            m7664a(0, 1);
        }
        this.transport.post(apiClient, new C2510b(atomicBoolean));
        try {
            if (!this.f7829a.await(j2, timeUnit)) {
                atomicBoolean.set(true);
                m7665a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.m7715e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            m7665a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f7830b;
    }

    /* renamed from: a */
    private void m7664a(int i2, int i3) {
        SubAppInfo subAppInfo;
        HMSLog.m7717i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.f7831c.get();
        if (apiClient != null && this.f7832d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.11.0.302");
            if (i3 == 1) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                hashMap.put("result", String.valueOf(i2));
                R r = this.f7830b;
                if (r != null && r.getStatus() != null) {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.f7830b.getStatus().getStatusCode()));
                }
            }
            hashMap.put("version", "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            hashMap.put("appid", appId);
            if (TextUtils.isEmpty(this.f7833e)) {
                String id = TransactionIdCreater.getId(appId, this.f7832d);
                this.f7833e = id;
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f7833e);
                this.f7833e = null;
            }
            String[] split = this.f7832d.split("\\.");
            if (split.length >= 2) {
                hashMap.put("service", split[0]);
                hashMap.put("apiName", split[1]);
            }
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
            return;
        }
        HMSLog.m7715e("PendingResultImpl", "<biReportEvent> has some error.");
    }
}
