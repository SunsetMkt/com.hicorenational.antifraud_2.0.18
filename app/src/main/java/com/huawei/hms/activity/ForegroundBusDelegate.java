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

    /* renamed from: a, reason: collision with root package name */
    private RequestHeader f6519a;

    /* renamed from: b, reason: collision with root package name */
    private String f6520b;

    /* renamed from: c, reason: collision with root package name */
    private ForegroundInnerHeader f6521c = new ForegroundInnerHeader();

    /* renamed from: d, reason: collision with root package name */
    private ResponseHeader f6522d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f6523e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6524f;

    private class b implements AvailableAdapter.AvailableCallBack {
        private b() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i2) {
            if (i2 == 0) {
                ForegroundBusDelegate.this.h();
            } else {
                HMSLog.i("ForegroundBusDelegate", "version check failed");
                ForegroundBusDelegate.this.a(0, "apk version is invalid");
            }
        }
    }

    private BusResponseCallback b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private void c() {
        if (this.f6519a != null) {
            a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    private void d() {
        a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    private void e() {
        if (g() == null) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            a(0, "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.f6524f) {
            h();
            return;
        }
        if (!Util.isAvailableLibExist(g().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(g().getApplicationContext(), this.f6521c.getApkVersion()) == 0) {
                h();
                return;
            } else {
                HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
                a(0, "apk version is invalid");
                return;
            }
        }
        b bVar = new b();
        AvailableAdapter availableAdapter = new AvailableAdapter(this.f6521c.getApkVersion());
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(g());
        if (isHuaweiMobileServicesAvailable == 0) {
            bVar.onComplete(isHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            a(g(), availableAdapter, bVar);
        } else {
            bVar.onComplete(isHuaweiMobileServicesAvailable);
        }
    }

    private void f() {
        Activity g2 = g();
        if (g2 == null || g2.isFinishing()) {
            return;
        }
        g2.finish();
    }

    private Activity g() {
        WeakReference<Activity> weakReference = this.f6523e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
        Activity g2 = g();
        if (g2 == null) {
            HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        String packageName = this.f6524f ? g2.getPackageName() : HMSPackageManager.getInstance(g2.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(packageName)) {
            HMSLog.e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
            a(0, "hmsPackageName is null, Service is invalid.");
            return;
        }
        Intent intent = new Intent(this.f6521c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f6520b);
        try {
            intent.setPackage(packageName);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(g2));
        intent.setClassName(packageName, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f6519a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            b();
            g2.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e2) {
            HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e2);
            a(0, "launch bus intent failed");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.e("ForegroundBusDelegate", "activity is null");
            a(0, "activity is null");
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.e("ForegroundBusDelegate", "activity is finishing");
            a(0, "activity is finishing");
            return;
        }
        this.f6523e = new WeakReference<>(activity);
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                a(0, "intent is invalid");
                return;
            }
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            RequestHeader requestHeader = new RequestHeader();
            this.f6519a = requestHeader;
            if (!requestHeader.fromJson(stringExtra)) {
                a(0, "header is invalid");
                return;
            }
            this.f6520b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
            ForegroundInnerHeader foregroundInnerHeader = this.f6521c;
            if (foregroundInnerHeader == null) {
                a(0, "inner header is invalid");
                return;
            }
            foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
            if (TextUtils.isEmpty(this.f6519a.getApiName())) {
                a(0, "action is invalid");
                return;
            }
            a();
            if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                HMSLog.i("ForegroundBusDelegate", "isUseInnerHms: true");
                this.f6524f = true;
            }
            e();
        } catch (Throwable th) {
            HMSLog.e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
            a(0, "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        c();
        this.f6523e = null;
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
                HMSLog.w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
                str = "";
            }
            ResponseHeader responseHeader = new ResponseHeader();
            this.f6522d = responseHeader;
            JsonUtil.jsonToEntity(str, responseHeader);
        }
        d();
        BusResponseCallback b2 = b(this.f6521c.getResponseCallbackKey());
        if (b2 == null) {
            a(i3, intent);
            return true;
        }
        BusResponseResult succeedReturn = b2.succeedReturn(this.f6523e.get(), i3, intent);
        if (succeedReturn == null) {
            a(i3, intent);
            return true;
        }
        a(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
    }

    private void b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f6519a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f6519a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void a(int i2, Intent intent) {
        HMSLog.i("ForegroundBusDelegate", "succeedReturn");
        Activity g2 = g();
        if (g2 == null) {
            return;
        }
        g2.setResult(i2, IntentUtil.modifyIntentBehaviorsSafe(intent));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        HMSLog.e("ForegroundBusDelegate", str);
        Activity g2 = g();
        if (g2 == null) {
            return;
        }
        BusResponseCallback b2 = b(this.f6521c.getResponseCallbackKey());
        if (b2 != null) {
            BusResponseResult innerError = b2.innerError(this.f6523e.get(), i2, str);
            if (innerError == null) {
                g2.setResult(0);
            } else {
                g2.setResult(innerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(innerError.getIntent()));
            }
        } else {
            g2.setResult(0);
        }
        f();
    }

    private static void a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    private void a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f6519a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f6519a.getKitSdkVersion())));
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    private void a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f6519a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f6519a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f6522d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f6522d.getErrorCode()));
        }
        if (g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }
}
