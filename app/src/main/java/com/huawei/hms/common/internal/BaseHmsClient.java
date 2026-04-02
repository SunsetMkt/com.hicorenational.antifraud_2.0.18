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
import d.c.a.b.a.a;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* JADX INFO: renamed from: i */
    private static final Object f4537i = new Object();

    /* JADX INFO: renamed from: j */
    private static final AtomicInteger f4538j = new AtomicInteger(1);

    /* JADX INFO: renamed from: k */
    private static final AtomicInteger f4539k = new AtomicInteger(1);

    /* JADX INFO: renamed from: l */
    private static BinderAdapter f4540l;

    /* JADX INFO: renamed from: m */
    private static BinderAdapter f4541m;
    private final Context a;

    /* JADX INFO: renamed from: b */
    private String f4542b;

    /* JADX INFO: renamed from: c */
    private final ClientSettings f4543c;

    /* JADX INFO: renamed from: d */
    private volatile IAIDLInvoke f4544d;

    /* JADX INFO: renamed from: e */
    private final ConnectionCallbacks f4545e;

    /* JADX INFO: renamed from: f */
    private final OnConnectionFailedListener f4546f;

    /* JADX INFO: renamed from: g */
    private Handler f4547g = null;

    /* JADX INFO: renamed from: h */
    private HuaweiApi.RequestHandler f4548h;
    protected String sessionId;

    /* JADX INFO: renamed from: com.huawei.hms.common.internal.BaseHmsClient$1 */
    class AnonymousClass1 implements BinderAdapter.BinderCallBack {

        /* JADX INFO: renamed from: com.huawei.hms.common.internal.BaseHmsClient$1$1 */
        class C00921 implements FailedBinderCallBack.BinderCallBack {
            C00921() {
            }

            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
            public void binderCallBack(int i2) {
                if (i2 != 0) {
                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f4544d = null;
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i2) {
            onBinderFailed(i2, null);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onNullBinding(ComponentName componentName) {
            BaseHmsClient.this.b(1);
            BaseHmsClient.this.a(10);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
            BaseHmsClient.this.connectedInternal(iBinder);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
            BaseHmsClient.this.b(1);
            RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
            if (BaseHmsClient.this.f4545e == null || (BaseHmsClient.this.f4545e instanceof HuaweiApi.RequestHandler)) {
                return;
            }
            BaseHmsClient.this.f4545e.onConnectionSuspended(1);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onTimedDisconnected() {
            BaseHmsClient.this.b(6);
            if (BaseHmsClient.this.f4545e == null || (BaseHmsClient.this.f4545e instanceof HuaweiApi.RequestHandler)) {
                return;
            }
            BaseHmsClient.this.f4545e.onConnectionSuspended(1);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i2, Intent intent) {
            if (intent == null) {
                HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                BaseHmsClient.this.f4544d = null;
                return;
            }
            Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
            if (activeActivity == null) {
                HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.a, 11, intent, a.B1)));
                BaseHmsClient.this.f4544d = null;
                return;
            }
            HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
            long time = new Timestamp(System.currentTimeMillis()).getTime();
            FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                C00921() {
                }

                @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                public void binderCallBack(int i22) {
                    if (i22 != 0) {
                        BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                        BaseHmsClient.this.f4544d = null;
                    }
                }
            });
            intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
            activeActivity.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.common.internal.BaseHmsClient$2 */
    class AnonymousClass2 implements AvailableAdapter.AvailableCallBack {
        AnonymousClass2() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i2) {
            BaseHmsClient.this.a(i2);
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.common.internal.BaseHmsClient$3 */
    class AnonymousClass3 implements AvailableAdapter.AvailableCallBack {
        AnonymousClass3() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i2) {
            if (i2 == 0 && BaseHmsClient.this.c()) {
                BaseHmsClient.this.a();
            } else {
                BaseHmsClient.this.a(i2);
            }
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i2);
    }

    public static final class ConnectionResultWrapper {
        private HuaweiApi.RequestHandler a;

        /* JADX INFO: renamed from: b */
        private ConnectionResult f4549b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.a = requestHandler;
            this.f4549b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f4549b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.a = context;
        this.f4543c = clientSettings;
        if (clientSettings != null) {
            this.f4542b = clientSettings.getAppID();
        }
        this.f4546f = onConnectionFailedListener;
        this.f4545e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1

            /* JADX INFO: renamed from: com.huawei.hms.common.internal.BaseHmsClient$1$1 */
            class C00921 implements FailedBinderCallBack.BinderCallBack {
                C00921() {
                }

                @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                public void binderCallBack(int i22) {
                    if (i22 != 0) {
                        BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                        BaseHmsClient.this.f4544d = null;
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2) {
                onBinderFailed(i2, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f4545e == null || (BaseHmsClient.this.f4545e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f4545e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f4545e == null || (BaseHmsClient.this.f4545e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f4545e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2, Intent intent) {
                if (intent == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f4544d = null;
                    return;
                }
                Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                if (activeActivity == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.a, 11, intent, a.B1)));
                    BaseHmsClient.this.f4544d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                long time = new Timestamp(System.currentTimeMillis()).getTime();
                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                    C00921() {
                    }

                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                    public void binderCallBack(int i22) {
                        if (i22 != 0) {
                            BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                            BaseHmsClient.this.f4544d = null;
                        }
                    }
                });
                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                activeActivity.startActivity(intent);
            }
        };
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f4543c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f4541m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f4540l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void f() {
        if (this.f4543c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f4541m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f4540l;
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
        a(i2, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f4544d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f4544d != null) {
            onConnecting();
        } else {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            e();
        }
    }

    protected final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f4545e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i2 = (this.f4543c.isUseInnerHms() ? f4539k : f4538j).get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 3) {
            f();
            b(1);
        } else {
            if (i2 != 5) {
                return;
            }
            b();
            b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f4543c.isUseInnerHms() + ", mInnerBinderAdapter:" + f4541m + ", mOuterBinderAdapter:" + f4540l);
        return this.f4543c.isUseInnerHms() ? f4541m : f4540l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f4543c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f4542b;
    }

    protected ClientSettings getClientSettings() {
        return this.f4543c;
    }

    public int getConnectionStatus() {
        return (this.f4543c.isUseInnerHms() ? f4539k : f4538j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f4543c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f4543c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f4544d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.a);
        return this.f4543c.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f4543c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.f4543c.isUseInnerHms() ? f4538j.get() != 3 : f4539k.get() != 3;
    }

    public boolean isConnecting() {
        return (this.f4543c.isUseInnerHms() ? f4539k : f4538j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f4548h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f4544d = iAIDLInvoke;
    }

    public boolean c() {
        return HMSPackageManager.getInstance(this.a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    void b(int i2) {
        if (this.f4543c.isUseInnerHms()) {
            f4539k.set(i2);
        } else {
            f4538j.set(i2);
        }
    }

    public void connect(int i2, boolean z) {
        a(i2, z);
    }

    private void b() {
        synchronized (f4537i) {
            Handler handler = this.f4547g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f4547g = null;
            }
        }
    }

    void a() {
        String innerHmsPkg = this.f4543c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f4543c.isUseInnerHms()) {
            f4541m = InnerBinderAdapter.getInstance(this.a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                b(5);
                f4541m.binder(d());
                return;
            }
        }
        f4540l = OuterBinderAdapter.getInstance(this.a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            b(5);
            f4540l.binder(d());
        }
    }

    private void b(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.a, i2, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                AnonymousClass3() {
                }

                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i22) {
                    if (i22 == 0 && BaseHmsClient.this.c()) {
                        BaseHmsClient.this.a();
                    } else {
                        BaseHmsClient.this.a(i22);
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i2, boolean z) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61100302 ======");
        int i3 = (this.f4543c.isUseInnerHms() ? f4539k : f4538j).get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i3);
        if (z || !(i3 == 3 || i3 == 5)) {
            if (getMinApkVersion() > i2) {
                i2 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i2 + " packageName:" + this.f4543c.getInnerHmsPkg());
            if (this.a.getPackageName().equals(this.f4543c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
                return;
            }
            if (Util.isAvailableLibExist(this.a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i2);
                int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.a);
                HMSLog.i("BaseHmsClient", "check available result: " + iIsHuaweiMobileServicesAvailable);
                if (iIsHuaweiMobileServicesAvailable == 0) {
                    a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, iIsHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(iIsHuaweiMobileServicesAvailable)) {
                        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        a(availableAdapter, iIsHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + iIsHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(iIsHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int iIsHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.a, i2);
            HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + iIsHuaweiMobileServicesAvailable2);
            if (iIsHuaweiMobileServicesAvailable2 == 0) {
                a();
            } else {
                a(iIsHuaweiMobileServicesAvailable2);
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i2 == 29) {
                i2 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.a, i2, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    AnonymousClass2() {
                    }

                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i22) {
                        BaseHmsClient.this.a(i22);
                    }
                });
            } else {
                a(26);
            }
        }
    }

    public void a(int i2) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i2);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f4548h, new ConnectionResult(i2));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f4546f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
    }

    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f4548h;
        this.f4548h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f4546f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
