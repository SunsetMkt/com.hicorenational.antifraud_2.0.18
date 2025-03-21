package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i */
    private static final Object f7244i = new Object();

    /* renamed from: j */
    private static final AtomicInteger f7245j = new AtomicInteger(1);

    /* renamed from: k */
    private static final AtomicInteger f7246k = new AtomicInteger(1);

    /* renamed from: l */
    private static BinderAdapter f7247l;

    /* renamed from: m */
    private static BinderAdapter f7248m;

    /* renamed from: a */
    private final Context f7249a;

    /* renamed from: b */
    private String f7250b;

    /* renamed from: c */
    private final ClientSettings f7251c;

    /* renamed from: d */
    private volatile IAIDLInvoke f7252d;

    /* renamed from: e */
    private final ConnectionCallbacks f7253e;

    /* renamed from: f */
    private final OnConnectionFailedListener f7254f;

    /* renamed from: g */
    private Handler f7255g = null;

    /* renamed from: h */
    private HuaweiApi.RequestHandler f7256h;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i2);
    }

    public static final class ConnectionResultWrapper {

        /* renamed from: a */
        private HuaweiApi.RequestHandler f7261a;

        /* renamed from: b */
        private ConnectionResult f7262b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f7261a = requestHandler;
            this.f7262b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f7262b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f7261a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f7249a = context;
        this.f7251c = clientSettings;
        if (clientSettings != null) {
            this.f7250b = clientSettings.getAppID();
        }
        this.f7254f = onConnectionFailedListener;
        this.f7253e = connectionCallbacks;
    }

    /* renamed from: d */
    private BinderAdapter.BinderCallBack m6732d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2) {
                onBinderFailed(i2, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.m6736b(1);
                BaseHmsClient.this.m6720a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.m7717i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.m7717i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.m6736b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f7253e == null || (BaseHmsClient.this.f7253e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f7253e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.m6736b(6);
                if (BaseHmsClient.this.f7253e == null || (BaseHmsClient.this.f7253e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f7253e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2, Intent intent) {
                if (intent == null) {
                    HMSLog.m7717i("BaseHmsClient", "onBinderFailed: intent is null!");
                    BaseHmsClient.this.m6723a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f7252d = null;
                    return;
                }
                Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                if (activeActivity == null) {
                    HMSLog.m7717i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.m6723a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f7249a, 11, intent, AbstractC1191a.f2487B1)));
                    BaseHmsClient.this.f7252d = null;
                    return;
                }
                HMSLog.m7717i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                long time = new Timestamp(System.currentTimeMillis()).getTime();
                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                    public void binderCallBack(int i3) {
                        if (i3 != 0) {
                            BaseHmsClient.this.m6723a(new ConnectionResult(10, (PendingIntent) null));
                            BaseHmsClient.this.f7252d = null;
                        }
                    }
                });
                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                activeActivity.startActivity(intent);
            }
        };
    }

    /* renamed from: e */
    private void m6733e() {
        HMSLog.m7718w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f7251c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f7248m;
            if (binderAdapter == null) {
                HMSLog.m7718w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f7247l;
            if (binderAdapter2 == null) {
                HMSLog.m7718w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        m6736b(1);
        m6720a(10);
    }

    /* renamed from: f */
    private void m6734f() {
        if (this.f7251c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f7248m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f7247l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i2) {
        m6721a(i2, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f7252d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f7252d != null) {
            onConnecting();
        } else {
            HMSLog.m7715e("BaseHmsClient", "mService is null, try to unBind.");
            m6733e();
        }
    }

    protected final void connectionConnected() {
        m6736b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f7253e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i2 = (this.f7251c.isUseInnerHms() ? f7246k : f7245j).get();
        HMSLog.m7717i("BaseHmsClient", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 3) {
            m6734f();
            m6736b(1);
        } else {
            if (i2 != 5) {
                return;
            }
            m6728b();
            m6736b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.m7717i("BaseHmsClient", "getAdapter:isInner:" + this.f7251c.isUseInnerHms() + ", mInnerBinderAdapter:" + f7248m + ", mOuterBinderAdapter:" + f7247l);
        return this.f7251c.isUseInnerHms() ? f7248m : f7247l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f7251c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f7250b;
    }

    protected ClientSettings getClientSettings() {
        return this.f7251c;
    }

    public int getConnectionStatus() {
        return (this.f7251c.isUseInnerHms() ? f7246k : f7245j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f7249a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f7251c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f7251c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f7252d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f7249a);
        return this.f7251c.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f7251c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.f7251c.isUseInnerHms() ? f7245j.get() != 3 : f7246k.get() != 3;
    }

    public boolean isConnecting() {
        return (this.f7251c.isUseInnerHms() ? f7246k : f7245j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f7256h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f7252d = iAIDLInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m6730c() {
        return HMSPackageManager.getInstance(this.f7249a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    /* renamed from: b */
    void m6736b(int i2) {
        if (this.f7251c.isUseInnerHms()) {
            f7246k.set(i2);
        } else {
            f7245j.set(i2);
        }
    }

    public void connect(int i2, boolean z) {
        m6721a(i2, z);
    }

    /* renamed from: b */
    private void m6728b() {
        synchronized (f7244i) {
            Handler handler = this.f7255g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f7255g = null;
            }
        }
    }

    /* renamed from: a */
    void m6735a() {
        String innerHmsPkg = this.f7251c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.m7717i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        m6726a(innerHmsPkg, serviceAction);
    }

    /* renamed from: a */
    private void m6726a(String str, String str2) {
        if (this.f7251c.isUseInnerHms()) {
            f7248m = InnerBinderAdapter.getInstance(this.f7249a, str2, str);
            if (isConnected()) {
                HMSLog.m7717i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                m6736b(5);
                f7248m.binder(m6732d());
                return;
            }
        }
        f7247l = OuterBinderAdapter.getInstance(this.f7249a, str2, str);
        if (isConnected()) {
            HMSLog.m7717i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            m6736b(5);
            f7247l.binder(m6732d());
        }
    }

    /* renamed from: b */
    private void m6729b(AvailableAdapter availableAdapter, int i2) {
        HMSLog.m7717i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            m6723a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f7249a, i2, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i3) {
                    if (i3 == 0 && BaseHmsClient.this.m6730c()) {
                        BaseHmsClient.this.m6735a();
                    } else {
                        BaseHmsClient.this.m6720a(i3);
                    }
                }
            });
        } else {
            m6720a(26);
        }
    }

    /* renamed from: a */
    private void m6721a(int i2, boolean z) {
        HMSLog.m7717i("BaseHmsClient", "====== HMSSDK version: 61100302 ======");
        int i3 = (this.f7251c.isUseInnerHms() ? f7246k : f7245j).get();
        HMSLog.m7717i("BaseHmsClient", "Enter connect, Connection Status: " + i3);
        if (z || !(i3 == 3 || i3 == 5)) {
            if (getMinApkVersion() > i2) {
                i2 = getMinApkVersion();
            }
            HMSLog.m7717i("BaseHmsClient", "connect minVersion:" + i2 + " packageName:" + this.f7251c.getInnerHmsPkg());
            if (this.f7249a.getPackageName().equals(this.f7251c.getInnerHmsPkg())) {
                HMSLog.m7717i("BaseHmsClient", "service packageName is same, bind core service return");
                m6735a();
                return;
            }
            if (Util.isAvailableLibExist(this.f7249a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i2);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f7249a);
                HMSLog.m7717i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    m6735a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.m7717i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    m6729b(availableAdapter, isHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                        HMSLog.m7717i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        m6722a(availableAdapter, isHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.m7717i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    m6720a(isHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f7249a, i2);
            HMSLog.m7717i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
            if (isHuaweiMobileServicesAvailable2 == 0) {
                m6735a();
            } else {
                m6720a(isHuaweiMobileServicesAvailable2);
            }
        }
    }

    /* renamed from: a */
    private void m6722a(AvailableAdapter availableAdapter, int i2) {
        HMSLog.m7717i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i2 == 29) {
                i2 = 9;
            }
            m6723a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f7249a, i2, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i3) {
                        BaseHmsClient.this.m6720a(i3);
                    }
                });
            } else {
                m6720a(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6720a(int i2) {
        HMSLog.m7717i("BaseHmsClient", "notifyFailed result: " + i2);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f7256h, new ConnectionResult(i2));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f7254f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6723a(ConnectionResult connectionResult) {
        HMSLog.m7717i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f7256h;
        this.f7256h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f7254f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
