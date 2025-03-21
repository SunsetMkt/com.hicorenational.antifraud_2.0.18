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

/* loaded from: classes.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a */
    private Activity f7026a;

    /* renamed from: b */
    private RequestHeader f7027b;

    /* renamed from: c */
    private String f7028c;

    /* renamed from: d */
    private ForegroundInnerHeader f7029d;

    /* renamed from: e */
    private String f7030e;

    /* renamed from: f */
    private Context f7031f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.f7026a = activity;
        RequestHeader requestHeader = new RequestHeader();
        this.f7027b = requestHeader;
        requestHeader.setSdkVersion(61100302);
        this.f7028c = "";
        ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
        this.f7029d = foregroundInnerHeader;
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
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f7026a, ForegroundBusDelegate.class.getName());
        Context context = this.f7031f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f7031f);
        } else {
            packageName = this.f7026a.getPackageName();
            appId = Util.getAppId(this.f7026a);
        }
        if (this.f7027b.getAppID() == null) {
            this.f7027b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            this.f7027b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f7027b.getAppID());
        }
        if (TextUtils.isEmpty(this.f7027b.getTransactionId())) {
            RequestHeader requestHeader = this.f7027b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f7027b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f7027b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f7028c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f7029d.toJson());
        if (!TextUtils.isEmpty(this.f7030e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f7030e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f7027b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i2) {
        this.f7027b.setApiLevel(i2);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f7031f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f7030e = this.f7026a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i2) {
        this.f7027b.setKitSdkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i2) {
        this.f7029d.setApkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f7028c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f7029d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f7027b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f7027b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f7027b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f7029d.setResponseCallbackKey(str);
        return this;
    }
}
