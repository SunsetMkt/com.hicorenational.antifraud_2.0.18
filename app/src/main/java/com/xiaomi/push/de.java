package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class de implements Application.ActivityLifecycleCallbacks {
    private Context a;

    /* JADX INFO: renamed from: a */
    private String f325a;

    /* JADX INFO: renamed from: b */
    private String f8856b;

    public de(Context context, String str) {
        this.f325a = "";
        this.a = context;
        this.f325a = str;
    }

    private void a(String str) {
        gn gnVar = new gn();
        gnVar.a(str);
        gnVar.a(System.currentTimeMillis());
        gnVar.a(gh.ActivityActiveTimeStamp);
        dl.a(this.a, gnVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f325a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f8856b = "";
        if (!TextUtils.isEmpty(this.f8856b) && !TextUtils.equals(this.f8856b, localClassName)) {
            this.f325a = "";
            return;
        }
        a(this.a.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + localClassName + Constants.COLON_SEPARATOR + this.f325a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
        this.f325a = "";
        this.f8856b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f8856b)) {
            this.f8856b = activity.getLocalClassName();
        }
        this.f325a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
