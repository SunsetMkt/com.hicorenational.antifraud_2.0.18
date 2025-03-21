package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: classes.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {

    /* renamed from: A */
    private static final Object f7126A = new Object();

    /* renamed from: B */
    private static final Object f7127B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: b */
    private final Context f7129b;

    /* renamed from: c */
    private final String f7130c;

    /* renamed from: d */
    private String f7131d;

    /* renamed from: e */
    private String f7132e;

    /* renamed from: f */
    private volatile IAIDLInvoke f7133f;

    /* renamed from: g */
    private String f7134g;

    /* renamed from: h */
    private WeakReference<Activity> f7135h;

    /* renamed from: i */
    private WeakReference<Activity> f7136i;

    /* renamed from: l */
    private List<Scope> f7139l;

    /* renamed from: m */
    private List<PermissionInfo> f7140m;

    /* renamed from: n */
    private Map<Api<?>, Api.ApiOptions> f7141n;

    /* renamed from: o */
    private SubAppInfo f7142o;

    /* renamed from: s */
    private final ReentrantLock f7146s;

    /* renamed from: t */
    private final Condition f7147t;

    /* renamed from: u */
    private ConnectionResult f7148u;

    /* renamed from: v */
    private HuaweiApiClient.ConnectionCallbacks f7149v;

    /* renamed from: w */
    private HuaweiApiClient.OnConnectionFailedListener f7150w;

    /* renamed from: x */
    private Handler f7151x;

    /* renamed from: y */
    private Handler f7152y;

    /* renamed from: z */
    private CheckUpdatelistener f7153z;

    /* renamed from: a */
    private int f7128a = -1;

    /* renamed from: j */
    private boolean f7137j = false;

    /* renamed from: k */
    private AtomicInteger f7138k = new AtomicInteger(1);

    /* renamed from: p */
    private long f7143p = 0;

    /* renamed from: q */
    private int f7144q = 0;

    /* renamed from: r */
    private final Object f7145r = new Object();

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$a */
    class C2303a implements Handler.Callback {
        C2303a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m7715e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f7138k.get() == 5) {
                HuaweiApiClientImpl.this.m6635c(1);
                HuaweiApiClientImpl.this.m6628b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$b */
    class C2304b implements Handler.Callback {
        C2304b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m7715e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f7138k.get() == 2) {
                HuaweiApiClientImpl.this.m6635c(1);
                HuaweiApiClientImpl.this.m6628b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$c */
    class BinderC2305c extends IAIDLCallback.Stub {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f7156a;

        BinderC2305c(ResultCallback resultCallback) {
            this.f7156a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer == null) {
                HMSLog.m7717i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
                this.f7156a.onResult(new BundleResult(-1, null));
                return;
            }
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            ResponseHeader responseHeader = new ResponseHeader();
            find.decode(dataBuffer.header, responseHeader);
            BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
            HMSLog.m7717i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
            this.f7156a.onResult(bundleResult);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$d */
    static class C2306d extends PendingResultImpl<Status, IMessageEntity> {
        public C2306d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e */
    private class C2307e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f7159a;

            a(ResolveResult resolveResult) {
                this.f7159a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m6626a((ResolveResult<ConnectResp>) this.f7159a);
            }
        }

        private C2307e() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ C2307e(HuaweiApiClientImpl huaweiApiClientImpl, C2303a c2303a) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f */
    private class C2308f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f7162a;

            a(ResolveResult resolveResult) {
                this.f7162a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m6632b((ResolveResult<DisconnectResp>) this.f7162a);
            }
        }

        private C2308f() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ C2308f(HuaweiApiClientImpl huaweiApiClientImpl, C2303a c2303a) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$g */
    private class C2309g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private C2309g() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            HMSLog.m7717i("HuaweiApiClientImpl", "get notice has intent.");
            Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.f7135h.get(), HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity == null) {
                HMSLog.m7715e("HuaweiApiClientImpl", "showNotice no valid activity!");
            } else {
                HuaweiApiClientImpl.this.f7137j = true;
                validActivity.startActivity(noticeIntent);
            }
        }

        /* synthetic */ C2309g(HuaweiApiClientImpl huaweiApiClientImpl, C2303a c2303a) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f7146s = reentrantLock;
        this.f7147t = reentrantLock.newCondition();
        this.f7151x = null;
        this.f7152y = null;
        this.f7153z = null;
        this.f7129b = context;
        String appId = Util.getAppId(context);
        this.f7130c = appId;
        this.f7131d = appId;
        this.f7132e = Util.getCpId(context);
    }

    /* renamed from: d */
    private DisconnectInfo m6637d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f7141n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new DisconnectInfo(this.f7139l, arrayList);
    }

    /* renamed from: e */
    private int m6638e() {
        int hmsVersion = Util.getHmsVersion(this.f7129b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int m6639f = m6639f();
        if (m6640g()) {
            if (m6639f < 20503000) {
                return 20503000;
            }
            return m6639f;
        }
        if (m6639f < 20600000) {
            return 20600000;
        }
        return m6639f;
    }

    /* renamed from: f */
    private int m6639f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i2 = 0;
        if (apiMap == null) {
            return 0;
        }
        Iterator<Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            String apiName = it.next().getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i2) {
                i2 = intValue;
            }
        }
        return i2;
    }

    /* renamed from: g */
    private boolean m6640g() {
        Map<Api<?>, Api.ApiOptions> map = this.f7141n;
        if (map == null) {
            return false;
        }
        Iterator<Api<?>> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private void m6641h() {
        Handler handler = this.f7151x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f7151x = new Handler(Looper.getMainLooper(), new C2303a());
        }
        this.f7151x.sendEmptyMessageDelayed(2, C2084a.f6136r);
    }

    /* renamed from: i */
    private void m6642i() {
        synchronized (f7127B) {
            Handler handler = this.f7152y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.f7152y = new Handler(Looper.getMainLooper(), new C2304b());
            }
            HMSLog.m7712d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + this.f7152y.sendEmptyMessageDelayed(3, 3000L));
        }
    }

    /* renamed from: j */
    private void m6643j() {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, m6633c()).setResultCallback(new C2307e(this, null));
    }

    /* renamed from: k */
    private void m6644k() {
        ConnectService.disconnect(this, m6637d()).setResultCallback(new C2308f(this, null));
    }

    /* renamed from: l */
    private void m6645l() {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, m6633c()).setResultCallback(new C2307e(this, null));
    }

    /* renamed from: m */
    private void m6646m() {
        if (this.f7137j) {
            HMSLog.m7717i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f7129b) == 0) {
            ConnectService.getNotice(this, 0, "6.11.0.302").setResultCallback(new C2309g(this, null));
        }
    }

    /* renamed from: n */
    private void m6647n() {
        Util.unBindServiceCatchException(this.f7129b, this);
        this.f7133f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i2, ResultCallback<BundleResult> resultCallback) {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.m7715e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        }
        if (!innerIsConnected()) {
            HMSLog.m7715e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        }
        DataBuffer dataBuffer = new DataBuffer(str, i2);
        MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
        dataBuffer.addBody(bundle);
        RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 61100302, getSessionId());
        requestHeader.setApiNameList(getApiNameList());
        dataBuffer.header = find.encode(requestHeader, new Bundle());
        try {
            getService().asyncCall(dataBuffer, new BinderC2305c(resultCallback));
            return 0;
        } catch (RemoteException e2) {
            HMSLog.m7715e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
            return CommonCode.ErrorCode.INTERNAL_ERROR;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.m7715e("HuaweiApiClientImpl", "listener is null!");
            return;
        }
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
            checkUpdatelistener.onResult(-1);
            return;
        }
        this.f7153z = checkUpdatelistener;
        try {
            Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
            cls.getMethod("initCheckUpdateCallBack", Object.class, Activity.class).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), this, activity);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            HMSLog.m7715e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e2.getMessage());
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.m7717i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i2 = this.f7138k.get();
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i2);
        if (i2 == 3 || i2 == 5 || i2 == 2 || i2 == 4) {
            return;
        }
        if (activity != null) {
            this.f7135h = new WeakReference<>(activity);
            this.f7136i = new WeakReference<>(activity);
        }
        this.f7131d = TextUtils.isEmpty(this.f7130c) ? Util.getAppId(this.f7129b) : this.f7130c;
        int m6638e = m6638e();
        HMSLog.m7717i("HuaweiApiClientImpl", "connect minVersion:" + m6638e);
        HuaweiApiAvailability.setServicesVersionCode(m6638e);
        int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f7129b, m6638e);
        HMSLog.m7717i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
        this.f7144q = HMSPackageManager.getInstance(this.f7129b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable != 0) {
            if (this.f7150w != null) {
                m6629b(isHuaweiMobileServicesAvailable);
                return;
            }
            return;
        }
        m6635c(5);
        if (this.f7133f == null) {
            m6622a();
            return;
        }
        m6635c(2);
        m6643j();
        m6642i();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.m7717i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i2 = this.f7138k.get();
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i2);
        if (i2 == 3 || i2 == 5 || i2 == 2 || i2 == 4) {
            return;
        }
        this.f7131d = TextUtils.isEmpty(this.f7130c) ? Util.getAppId(this.f7129b) : this.f7130c;
        m6645l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.f7128a < 0) {
            throw new IllegalStateException("disableLifeCycleManagement failed");
        }
        AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f7128a);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new C2306d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i2 = this.f7138k.get();
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 2) {
            m6635c(4);
            return;
        }
        if (i2 == 3) {
            m6635c(4);
            m6644k();
        } else {
            if (i2 != 5) {
                return;
            }
            m6623a(2);
            m6635c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f7141n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f7141n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f7131d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f7148u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f7148u;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f7129b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f7132e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f7129b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.f7140m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.f7139l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f7133f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.f7134g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.f7142o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f7136i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f7145r) {
            return this.f7150w == onConnectionFailedListener;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f7145r) {
            return this.f7149v == connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        this.f7146s.lock();
        try {
            connect((Activity) null);
            while (isConnecting()) {
                this.f7147t.await();
            }
            if (isConnected()) {
                this.f7148u = null;
                return new ConnectionResult(0, (PendingIntent) null);
            }
            ConnectionResult connectionResult = this.f7148u;
            return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, (PendingIntent) null);
        } finally {
            this.f7146s.unlock();
        }
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.f7138k.get() == 3 || this.f7138k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f7144q == 0) {
            this.f7144q = HMSPackageManager.getInstance(this.f7129b).getHmsMultiServiceVersion();
        }
        if (this.f7144q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f7143p;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.f7143p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.m7717i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        m6647n();
        m6635c(1);
        this.f7143p = System.currentTimeMillis();
        return false;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i2 = this.f7138k.get();
        return i2 == 2 || i2 == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.m7717i("HuaweiApiClientImpl", "onPause");
    }

    public void onResult(int i2) {
        this.f7153z.onResult(i2);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.m7717i("HuaweiApiClientImpl", "onResume");
            this.f7136i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m7717i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        m6623a(2);
        this.f7133f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f7133f != null) {
            if (this.f7138k.get() == 5) {
                m6635c(2);
                m6643j();
                m6642i();
                return;
            } else {
                if (this.f7138k.get() != 3) {
                    m6647n();
                    return;
                }
                return;
            }
        }
        HMSLog.m7715e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
        m6647n();
        m6635c(1);
        if (this.f7150w != null) {
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.f7135h;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f7135h.get(), 10);
            }
            ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
            this.f7150w.onConnectionFailed(connectionResult);
            this.f7148u = connectionResult;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f7133f = null;
        m6635c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f7149v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f7145r) {
            if (this.f7150w != onConnectionFailedListener) {
                HMSLog.m7718w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f7150w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f7145r) {
            if (this.f7149v != connectionCallbacks) {
                HMSLog.m7718w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f7149v = null;
            }
        }
    }

    public void resetListener() {
        this.f7153z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f7141n = map;
    }

    protected void setAutoLifecycleClientId(int i2) {
        this.f7128a = i2;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f7149v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f7150w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z) {
        this.f7137j = z;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f7140m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f7139l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.m7715e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m7715e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f7130c) ? Util.getAppId(this.f7129b) : this.f7130c)) {
            HMSLog.m7715e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f7142o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6635c(int i2) {
        this.f7138k.set(i2);
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            this.f7146s.lock();
            try {
                this.f7147t.signalAll();
            } finally {
                this.f7146s.unlock();
            }
        }
    }

    /* renamed from: b */
    private void m6629b(int i2) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f7135h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f7135h.get(), i2);
            HMSLog.m7717i("HuaweiApiClientImpl", "connect 2.0 fail: " + i2);
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
        this.f7150w.onConnectionFailed(connectionResult);
        this.f7148u = connectionResult;
    }

    /* renamed from: a */
    private void m6622a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f7129b).getServiceAction());
        HMSPackageManager.getInstance(this.f7129b).refreshForMultiService();
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f7129b).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.m7715e("HuaweiApiClientImpl", "servicePackageName is empty, Service is invalid, bind core service fail.");
                m6635c(1);
                m6628b();
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (f7126A) {
                if (this.f7129b.bindService(intent, this, 1)) {
                    m6641h();
                    return;
                }
                m6635c(1);
                HMSLog.m7715e("HuaweiApiClientImpl", "In connect, bind core service fail");
                m6628b();
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.m7715e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            m6635c(1);
            HMSLog.m7715e("HuaweiApiClientImpl", "In connect, bind core service fail");
            m6628b();
        }
    }

    /* renamed from: c */
    private ConnectInfo m6633c() {
        String packageSignature = new PackageManagerHelper(this.f7129b).getPackageSignature(this.f7129b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f7142o;
        return new ConnectInfo(getApiNameList(), this.f7139l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6628b() {
        m6647n();
        if (this.f7150w != null) {
            int i2 = UIUtil.isBackground(this.f7129b) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.f7135h;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f7135h.get(), i2);
            }
            ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
            this.f7150w.onConnectionFailed(connectionResult);
            this.f7148u = connectionResult;
        }
    }

    /* renamed from: c */
    private void m6636c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        m6635c(3);
        this.f7148u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f7149v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f7135h != null) {
            m6646m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.m7717i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.m7717i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.f7135h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6632b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        m6647n();
        m6635c(1);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j2, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f7146s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j2);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        return new ConnectionResult(14, (PendingIntent) null);
                    }
                    nanos = this.f7147t.awaitNanos(nanos);
                }
                if (isConnected()) {
                    this.f7148u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f7148u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f7146s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i2) {
        connect((Activity) null);
    }

    /* renamed from: a */
    private void m6623a(int i2) {
        if (i2 == 2) {
            synchronized (f7126A) {
                Handler handler = this.f7151x;
                if (handler != null) {
                    handler.removeMessages(i2);
                    this.f7151x = null;
                }
            }
        }
        if (i2 == 3) {
            synchronized (f7127B) {
                Handler handler2 = this.f7152y;
                if (handler2 != null) {
                    handler2.removeMessages(i2);
                    this.f7152y = null;
                }
            }
        }
        synchronized (f7126A) {
            Handler handler3 = this.f7151x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.f7151x = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6626a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.m7717i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f7133f != null && this.f7138k.get() == 2) {
            m6623a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.f7134g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.f7142o;
            PendingIntent pendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.f7131d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            HMSLog.m7717i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                m6636c(resolveResult);
                return;
            }
            if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                m6647n();
                m6635c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f7149v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            }
            m6647n();
            m6635c(1);
            if (this.f7150w != null) {
                WeakReference<Activity> weakReference = this.f7135h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f7135h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f7150w.onConnectionFailed(connectionResult);
                this.f7148u = connectionResult;
                return;
            }
            return;
        }
        HMSLog.m7715e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }
}
