package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundIntentBuilder {
    private Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RequestHeader f4404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ForegroundInnerHeader f4406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f4408f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.a = activity;
        RequestHeader requestHeader = new RequestHeader();
        this.f4404b = requestHeader;
        requestHeader.setSdkVersion(61100302);
        this.f4405c = "";
        ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
        this.f4406d = foregroundInnerHeader;
        foregroundInnerHeader.setApkVersion(30000000);
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.a, ForegroundBusDelegate.class.getName());
        Context context = this.f4408f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f4408f);
        } else {
            packageName = this.a.getPackageName();
            appId = Util.getAppId(this.a);
        }
        if (this.f4404b.getAppID() == null) {
            this.f4404b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            this.f4404b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f4404b.getAppID());
        }
        if (TextUtils.isEmpty(this.f4404b.getTransactionId())) {
            RequestHeader requestHeader = this.f4404b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f4404b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f4404b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f4405c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f4406d.toJson());
        if (!TextUtils.isEmpty(this.f4407e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f4407e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f4404b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i2) {
        this.f4404b.setApiLevel(i2);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f4408f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f4407e = this.a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i2) {
        this.f4404b.setKitSdkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i2) {
        this.f4406d.setApkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f4405c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f4406d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f4404b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f4404b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f4404b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f4406d.setResponseCallbackKey(str);
        return this;
    }
}
