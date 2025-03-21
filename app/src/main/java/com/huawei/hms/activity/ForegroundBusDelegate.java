package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* renamed from: a */
    private RequestHeader f7019a;

    /* renamed from: b */
    private String f7020b;

    /* renamed from: c */
    private ForegroundInnerHeader f7021c = new ForegroundInnerHeader();

    /* renamed from: d */
    private ResponseHeader f7022d;

    /* renamed from: e */
    private WeakReference<Activity> f7023e;

    /* renamed from: f */
    private boolean f7024f;

    /* renamed from: com.huawei.hms.activity.ForegroundBusDelegate$b */
    private class C2285b implements AvailableAdapter.AvailableCallBack {
        private C2285b() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i2) {
            if (i2 == 0) {
                ForegroundBusDelegate.this.m6526h();
            } else {
                HMSLog.m7717i("ForegroundBusDelegate", "version check failed");
                ForegroundBusDelegate.this.m6514a(0, "apk version is invalid");
            }
        }
    }

    /* renamed from: b */
    private BusResponseCallback m6519b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    /* renamed from: c */
    private void m6521c() {
        if (this.f7019a != null) {
            m6518a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    /* renamed from: d */
    private void m6522d() {
        m6518a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    /* renamed from: e */
    private void m6523e() {
        if (m6525g() == null) {
            HMSLog.m7715e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            m6514a(0, "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.f7024f) {
            m6526h();
            return;
        }
        if (!Util.isAvailableLibExist(m6525g().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(m6525g().getApplicationContext(), this.f7021c.getApkVersion()) == 0) {
                m6526h();
                return;
            } else {
                HMSLog.m7715e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
                m6514a(0, "apk version is invalid");
                return;
            }
        }
        C2285b c2285b = new C2285b();
        AvailableAdapter availableAdapter = new AvailableAdapter(this.f7021c.getApkVersion());
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(m6525g());
        if (isHuaweiMobileServicesAvailable == 0) {
            c2285b.onComplete(isHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            m6515a(m6525g(), availableAdapter, c2285b);
        } else {
            c2285b.onComplete(isHuaweiMobileServicesAvailable);
        }
    }

    /* renamed from: f */
    private void m6524f() {
        Activity m6525g = m6525g();
        if (m6525g == null || m6525g.isFinishing()) {
            return;
        }
        m6525g.finish();
    }

    /* renamed from: g */
    private Activity m6525g() {
        WeakReference<Activity> weakReference = this.f7023e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6526h() {
        HMSLog.m7717i("ForegroundBusDelegate", "startApkHubActivity");
        Activity m6525g = m6525g();
        if (m6525g == null) {
            HMSLog.m7715e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        String packageName = this.f7024f ? m6525g.getPackageName() : HMSPackageManager.getInstance(m6525g.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(packageName)) {
            HMSLog.m7715e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
            m6514a(0, "hmsPackageName is null, Service is invalid.");
            return;
        }
        Intent intent = new Intent(this.f7021c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f7020b);
        try {
            intent.setPackage(packageName);
        } catch (IllegalArgumentException unused) {
            HMSLog.m7715e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(m6525g));
        intent.setClassName(packageName, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f7019a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            m6520b();
            m6525g.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e2) {
            HMSLog.m7716e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e2);
            m6514a(0, "launch bus intent failed");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m7715e("ForegroundBusDelegate", "activity is null");
            m6514a(0, "activity is null");
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m7715e("ForegroundBusDelegate", "activity is finishing");
            m6514a(0, "activity is finishing");
            return;
        }
        this.f7023e = new WeakReference<>(activity);
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                m6514a(0, "intent is invalid");
                return;
            }
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            RequestHeader requestHeader = new RequestHeader();
            this.f7019a = requestHeader;
            if (!requestHeader.fromJson(stringExtra)) {
                m6514a(0, "header is invalid");
                return;
            }
            this.f7020b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
            ForegroundInnerHeader foregroundInnerHeader = this.f7021c;
            if (foregroundInnerHeader == null) {
                m6514a(0, "inner header is invalid");
                return;
            }
            foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
            if (TextUtils.isEmpty(this.f7019a.getApiName())) {
                m6514a(0, "action is invalid");
                return;
            }
            m6512a();
            if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                HMSLog.m7717i("ForegroundBusDelegate", "isUseInnerHms: true");
                this.f7024f = true;
            }
            m6523e();
        } catch (Throwable th) {
            HMSLog.m7715e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
            m6514a(0, "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        m6521c();
        this.f7023e = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        String str;
        if (i2 != 431057) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            try {
                str = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            } catch (Throwable unused) {
                HMSLog.m7718w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
                str = "";
            }
            ResponseHeader responseHeader = new ResponseHeader();
            this.f7022d = responseHeader;
            JsonUtil.jsonToEntity(str, responseHeader);
        }
        m6522d();
        BusResponseCallback m6519b = m6519b(this.f7021c.getResponseCallbackKey());
        if (m6519b == null) {
            m6513a(i3, intent);
            return true;
        }
        BusResponseResult succeedReturn = m6519b.succeedReturn(this.f7023e.get(), i3, intent);
        if (succeedReturn == null) {
            m6513a(i3, intent);
            return true;
        }
        m6513a(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
    }

    /* renamed from: b */
    private void m6520b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f7019a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f7019a.getKitSdkVersion())));
        if (m6525g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m6525g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m6513a(int i2, Intent intent) {
        HMSLog.m7717i("ForegroundBusDelegate", "succeedReturn");
        Activity m6525g = m6525g();
        if (m6525g == null) {
            return;
        }
        m6525g.setResult(i2, IntentUtil.modifyIntentBehaviorsSafe(intent));
        m6524f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6514a(int i2, String str) {
        HMSLog.m7715e("ForegroundBusDelegate", str);
        Activity m6525g = m6525g();
        if (m6525g == null) {
            return;
        }
        BusResponseCallback m6519b = m6519b(this.f7021c.getResponseCallbackKey());
        if (m6519b != null) {
            BusResponseResult innerError = m6519b.innerError(this.f7023e.get(), i2, str);
            if (innerError == null) {
                m6525g.setResult(0);
            } else {
                m6525g.setResult(innerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(innerError.getIntent()));
            }
        } else {
            m6525g.setResult(0);
        }
        m6524f();
    }

    /* renamed from: a */
    private static void m6515a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.m7717i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* renamed from: a */
    private void m6512a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f7019a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f7019a.getKitSdkVersion())));
        if (m6525g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m6525g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m6518a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f7019a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f7019a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f7022d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f7022d.getErrorCode()));
        }
        if (m6525g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m6525g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }
}
