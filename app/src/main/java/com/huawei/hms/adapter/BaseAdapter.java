package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p171ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.p171ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import com.taobao.accs.common.Constants;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseAdapter {

    /* renamed from: a */
    private WeakReference<ApiClient> f7048a;

    /* renamed from: b */
    private WeakReference<Activity> f7049b;

    /* renamed from: c */
    private BaseCallBack f7050c;

    /* renamed from: d */
    private String f7051d;

    /* renamed from: e */
    private String f7052e;

    /* renamed from: f */
    private Parcelable f7053f;

    /* renamed from: g */
    private BaseCallBack f7054g;

    /* renamed from: h */
    private String f7055h;

    /* renamed from: i */
    private Context f7056i;

    /* renamed from: j */
    private RequestHeader f7057j = new RequestHeader();

    /* renamed from: k */
    private ResponseHeader f7058k = new ResponseHeader();

    /* renamed from: l */
    private SystemObserver f7059l;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a */
        private AtomicBoolean f7063a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        /* renamed from: a */
        private void m6580a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i2) {
            if (!CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                if (!"installHMS".equals(str)) {
                    BaseAdapter.this.m6546a(baseCallBack, coreBaseResponse);
                    return;
                } else {
                    HMSLog.m7717i("BaseAdapter", "has resolutin: installHMS");
                    m6579a(baseCallBack, coreBaseResponse);
                    return;
                }
            }
            Activity m6564c = BaseAdapter.this.m6564c();
            HMSLog.m7717i("BaseAdapter", "activity is: " + m6564c);
            if (m6564c == null || m6564c.isFinishing()) {
                HMSLog.m7715e("BaseAdapter", "activity null");
                BaseAdapter.this.m6546a(baseCallBack, coreBaseResponse);
                return;
            }
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f7056i)) {
                    BaseAdapter.this.m6540a(m6564c, pendingIntent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.m6557b(-9));
                    return;
                }
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f7056i)) {
                    BaseAdapter.this.m6540a(m6564c, intent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.m6557b(-9));
                    return;
                }
            }
            if (i2 == 2) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.m6557b(baseAdapter.f7058k.getErrorCode()));
            } else {
                HMSLog.m7715e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                baseCallBack.onError(BaseAdapter.this.m6557b(-4));
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            HMSLog.m7717i("BaseAdapter", "BaseRequestResultCallback onResult");
            BaseCallBack m6556b = BaseAdapter.this.m6556b();
            if (m6556b == null) {
                HMSLog.m7715e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.m7715e("BaseAdapter", "result null");
                m6556b.onError(BaseAdapter.this.m6557b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.m7715e("BaseAdapter", "response null");
                m6556b.onError(BaseAdapter.this.m6557b(-1));
                return;
            }
            if (TextUtils.isEmpty(value.getJsonHeader())) {
                HMSLog.m7715e("BaseAdapter", "jsonHeader null");
                m6556b.onError(BaseAdapter.this.m6557b(-1));
                return;
            }
            JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f7058k);
            if (this.f7063a.compareAndSet(true, false)) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.m6542a(baseAdapter.f7056i, BaseAdapter.this.f7058k);
            }
            String resolution = BaseAdapter.this.f7058k.getResolution();
            int statusCode = BaseAdapter.this.f7058k.getStatusCode();
            HMSLog.m7717i("BaseAdapter", "api is: " + BaseAdapter.this.f7058k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
            m6580a(resolution, m6556b, value, statusCode);
        }

        /* renamed from: a */
        private void m6579a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (Util.isAvailableLibExist(BaseAdapter.this.f7056i)) {
                Activity m6564c = BaseAdapter.this.m6564c();
                if (m6564c != null && !m6564c.isFinishing()) {
                    HMSLog.m7717i("BaseAdapter", "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(m6564c, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i2) {
                            HMSLog.m7717i("BaseAdapter", "complete handleSolutionForHMS, result: " + i2);
                            if (i2 != 0) {
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.m6535a(i2, baseAdapter.m6538a(i2)).toJson());
                            } else {
                                HMSPackageManager.getInstance(BaseAdapter.this.f7056i).resetMultiServiceState();
                                BaseAdapter baseAdapter2 = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter2.m6535a(11, baseAdapter2.m6538a(11)).toJson());
                                BaseAdapter.this.m6578i();
                            }
                        }
                    });
                    return;
                }
                HMSLog.m7715e("BaseAdapter", "activity is null");
                try {
                    if (BaseAdapter.this.f7056i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.f7056i)) {
                        HMSLog.m7717i("BaseAdapter", "pass installHMS intent");
                        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f7056i, UpdateAdapter.class.getName());
                        intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, ExceptionCode.CRASH_EXCEPTION);
                        intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                        coreBaseResponse.setIntent(intentStartBridgeActivity);
                        BaseAdapter.this.m6546a(baseCallBack, coreBaseResponse);
                    } else {
                        HMSLog.m7717i("BaseAdapter", "pass ACTIVITY_NULL error");
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.m6535a(-3, baseAdapter.m6538a(-3)).toJson());
                    }
                    return;
                } catch (RuntimeException unused) {
                    HMSLog.m7715e("BaseAdapter", "handleSolutionForHms pass result failed");
                    return;
                }
            }
            HMSLog.m7717i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
            baseCallBack.onError(BaseAdapter.this.m6557b(-9));
        }
    }

    /* renamed from: com.huawei.hms.adapter.BaseAdapter$a */
    private static class C2291a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public C2291a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f7048a = new WeakReference<>(apiClient);
        if (apiClient == null) {
            HMSLog.m7718w("BaseAdapter", "BaseAdapter constructor client is null");
            return;
        }
        this.f7056i = apiClient.getContext().getApplicationContext();
        HMSLog.m7717i("BaseAdapter", "In constructor, WeakReference is " + this.f7048a);
    }

    /* renamed from: h */
    private void m6577h() {
        if (this.f7051d == null || this.f7054g == null) {
            return;
        }
        this.f7058k = null;
        this.f7058k = new ResponseHeader();
        baseRequest(m6569d(), m6572e(), m6574f(), m6533a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6578i() {
        if (this.f7056i == null) {
            HMSLog.m7715e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f7056i.getPackageName());
            this.f7056i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.m7715e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m6553a(str, str2, parcelable, baseCallBack);
        if (this.f7048a == null) {
            HMSLog.m7715e("BaseAdapter", "client is null");
            baseCallBack.onError(m6557b(-2));
            return;
        }
        this.f7050c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f7057j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f7057j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.m7715e("BaseAdapter", "get uri null");
            baseCallBack.onError(m6557b(-5));
            return;
        }
        String transactionId = this.f7057j.getTransactionId();
        this.f7055h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.m7715e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(m6557b(-6));
            return;
        }
        HMSLog.m7717i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f7055h);
        m6541a(this.f7056i, this.f7057j);
        m6537a(this.f7048a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    /* renamed from: d */
    private String m6569d() {
        return this.f7051d;
    }

    /* renamed from: e */
    private String m6572e() {
        return this.f7052e;
    }

    /* renamed from: f */
    private Parcelable m6574f() {
        return this.f7053f;
    }

    /* renamed from: g */
    private void m6576g() {
        this.f7059l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.2
            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i2) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.m7715e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack m6556b = BaseAdapter.this.m6556b();
                    if (m6556b == null) {
                        HMSLog.m7715e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    m6556b.onError(BaseAdapter.this.m6557b(-6));
                    return true;
                }
                if (!str.equals(BaseAdapter.this.f7055h)) {
                    return false;
                }
                HMSLog.m7717i("BaseAdapter", "onSolutionResult + id is :" + str);
                BaseCallBack m6556b2 = BaseAdapter.this.m6556b();
                if (m6556b2 == null) {
                    HMSLog.m7715e("BaseAdapter", "onResult baseCallBack null");
                    return true;
                }
                if (intent == null) {
                    HMSLog.m7715e("BaseAdapter", "onSolutionResult but data is null");
                    String m6557b = BaseAdapter.this.m6557b(-7);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.m6543a(baseAdapter.f7056i, BaseAdapter.this.f7058k, 0L);
                    m6556b2.onError(m6557b);
                    return true;
                }
                if (BaseAdapter.this.m6562b(intent, m6556b2) || BaseAdapter.this.m6554a(intent, m6556b2)) {
                    return true;
                }
                HMSLog.m7715e("BaseAdapter", "onComplete for on activity result");
                BaseAdapter.this.m6567c(intent, m6556b2);
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i2) {
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Activity m6564c() {
        if (this.f7049b == null) {
            HMSLog.m7717i("BaseAdapter", "activityWeakReference is " + this.f7049b);
            return null;
        }
        ApiClient apiClient = this.f7048a.get();
        if (apiClient == null) {
            HMSLog.m7717i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.m7717i("BaseAdapter", "activityWeakReference has " + this.f7049b.get());
        return Util.getActiveActivity(this.f7049b.get(), apiClient.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public BaseCallBack m6556b() {
        BaseCallBack baseCallBack = this.f7050c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.m7715e("BaseAdapter", "callback null");
        return null;
    }

    /* renamed from: b */
    private void m6559b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f7048a = new WeakReference<>(apiClient);
        this.f7049b = new WeakReference<>(activity);
        if (activity == null) {
            HMSLog.m7718w("BaseAdapter", "BaseAdapter constructor activity is null");
            return;
        }
        this.f7056i = activity.getApplicationContext();
        HMSLog.m7717i("BaseAdapter", "In constructor, activityWeakReference is " + this.f7049b + ", activity is " + this.f7049b.get());
    }

    /* renamed from: a */
    private PendingResult<ResolveResult<CoreBaseResponse>> m6537a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new C2291a(apiClient, str, coreBaseRequest);
    }

    /* renamed from: c */
    private void m6566c(int i2) {
        this.f7058k.setTransactionId(this.f7057j.getTransactionId());
        this.f7058k.setAppID(this.f7057j.getAppID());
        this.f7058k.setApiName(this.f7057j.getApiName());
        this.f7058k.setSrvName(this.f7057j.getSrvName());
        this.f7058k.setPkgName(this.f7057j.getPkgName());
        this.f7058k.setStatusCode(1);
        this.f7058k.setErrorCode(i2);
        this.f7058k.setErrorReason("Core error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6546a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.m7717i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent modifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), modifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m6557b(int i2) {
        m6566c(i2);
        return this.f7058k.toJson();
    }

    /* renamed from: b */
    private void m6561b(String str) {
        this.f7052e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6562b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.m7717i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.m7715e("BaseAdapter", "kit update success,replay request");
            m6577h();
        } else {
            HMSLog.m7715e("BaseAdapter", "kit update failed");
            baseCallBack.onError(m6535a(-10, m6538a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6540a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.m7717i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f7057j;
        if (requestHeader != null) {
            m6559b(this.f7056i, requestHeader);
        }
        if (this.f7059l == null) {
            m6576g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f7059l);
        if (Build.VERSION.SDK_INT >= 29) {
            m6551a(coreBaseResponse);
        }
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.f7055h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f7055h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6567c(Intent intent, BaseCallBack baseCallBack) {
        long j2;
        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                j2 = ((Long) infoFromJsonobject3).longValue();
                if (!(infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
                    int intValue = ((Integer) infoFromJsonobject).intValue();
                    m6557b(((Integer) infoFromJsonobject2).intValue());
                    this.f7058k.setStatusCode(intValue);
                    m6543a(this.f7056i, this.f7058k, j2);
                } else {
                    m6557b(-8);
                    m6543a(this.f7056i, this.f7058k, j2);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j2 = 0;
        if (!(infoFromJsonobject instanceof Integer)) {
        }
        m6557b(-8);
        m6543a(this.f7056i, this.f7058k, j2);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    /* renamed from: a */
    private void m6551a(final CoreBaseResponse coreBaseResponse) {
        HMSLog.m7717i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f7055h, new Runnable() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                HMSLog.m7717i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f7059l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f7055h);
                BaseCallBack m6556b = BaseAdapter.this.m6556b();
                if (m6556b == null) {
                    HMSLog.m7715e("BaseAdapter", "timeoutRunnable callBack is null");
                } else {
                    BaseAdapter.this.m6546a(m6556b, coreBaseResponse);
                }
            }
        });
    }

    /* renamed from: a */
    private void m6541a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6542a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f7057j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6543a(Context context, ResponseHeader responseHeader, long j2) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j2));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f7057j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ResponseWrap m6535a(int i2, String str) {
        m6566c(i2);
        ResponseWrap responseWrap = new ResponseWrap(this.f7058k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m6538a(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_ERROR_CODE, i2);
        } catch (JSONException e2) {
            HMSLog.m7715e("BaseAdapter", "buildBodyStr failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m6552a(String str) {
        this.f7051d = str;
    }

    /* renamed from: a */
    private void m6544a(Parcelable parcelable) {
        this.f7053f = parcelable;
    }

    /* renamed from: a */
    private BaseCallBack m6533a() {
        return this.f7054g;
    }

    /* renamed from: a */
    private void m6545a(BaseCallBack baseCallBack) {
        this.f7054g = baseCallBack;
    }

    /* renamed from: a */
    private void m6553a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m6552a(str);
        m6561b(str2);
        m6544a(parcelable);
        m6545a(baseCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6554a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.m7717i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            m6577h();
            return true;
        }
        HMSLog.m7717i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(m6535a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, m6538a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
