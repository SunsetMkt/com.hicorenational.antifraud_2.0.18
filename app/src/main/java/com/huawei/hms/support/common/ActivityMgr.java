package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();

    /* renamed from: a */
    private WeakReference<Activity> f7858a;

    private ActivityMgr() {
    }

    /* renamed from: a */
    private static String m7693a(Object obj) {
        if (obj == null) {
            return AbstractC1191a.f2571h;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public Activity getCurrentActivity() {
        if (this.f7858a == null) {
            HMSLog.m7717i("ActivityMgr", "mCurrentActivity is " + this.f7858a);
            return null;
        }
        HMSLog.m7717i("ActivityMgr", "mCurrentActivity.get() is " + this.f7858a.get());
        return this.f7858a.get();
    }

    public void init(Application application) {
        HMSLog.m7712d("ActivityMgr", "init");
        if (application == null) {
            HMSLog.m7718w("ActivityMgr", "init failed for app is null");
            return;
        }
        ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        HMSLog.m7712d("ActivityMgr", "onCreated:" + m7693a(activity));
        this.f7858a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        HMSLog.m7712d("ActivityMgr", "onResumed:" + m7693a(activity));
        this.f7858a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        HMSLog.m7712d("ActivityMgr", "onStarted:" + m7693a(activity));
        this.f7858a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
