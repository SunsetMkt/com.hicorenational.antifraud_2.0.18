package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.de */
/* loaded from: classes2.dex */
public class C4157de implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Context f14882a;

    /* renamed from: a */
    private String f14883a;

    /* renamed from: b */
    private String f14884b;

    public C4157de(Context context, String str) {
        this.f14883a = "";
        this.f14882a = context;
        this.f14883a = str;
    }

    /* renamed from: a */
    private void m14280a(String str) {
        C4247gn c4247gn = new C4247gn();
        c4247gn.m15021a(str);
        c4247gn.m15019a(System.currentTimeMillis());
        c4247gn.m15020a(EnumC4241gh.ActivityActiveTimeStamp);
        AbstractC4164dl.m14297a(this.f14882a, c4247gn);
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
        if (TextUtils.isEmpty(this.f14883a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f14884b = "";
        if (!TextUtils.isEmpty(this.f14884b) && !TextUtils.equals(this.f14884b, localClassName)) {
            this.f14883a = "";
            return;
        }
        m14280a(this.f14882a.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + localClassName + Constants.COLON_SEPARATOR + this.f14883a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
        this.f14883a = "";
        this.f14884b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f14884b)) {
            this.f14884b = activity.getLocalClassName();
        }
        this.f14883a = String.valueOf(System.currentTimeMillis() / 1000);
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
