package com.huawei.hms.framework.common;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityUtil {
    private static final int MAX_NUM = 20;
    private static final String TAG = "ActivityUtil";
    private static volatile ActivityUtil instance;
    private boolean isForeground;
    private List<OnAppStatusListener> onAppStatusListeners = new ArrayList();
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.hms.framework.common.ActivityUtil.1
        private int activityStartCount = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.activityStartCount++;
            if (this.activityStartCount == 1) {
                ActivityUtil.this.isForeground = true;
                Logger.m6794d(ActivityUtil.TAG, "onActivityStarted");
                for (int i2 = 0; i2 < ActivityUtil.this.onAppStatusListeners.size(); i2++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i2)).onFront();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.activityStartCount--;
            if (this.activityStartCount == 0) {
                Logger.m6794d(ActivityUtil.TAG, "onActivityStopped");
                ActivityUtil.this.isForeground = false;
                for (int i2 = 0; i2 < ActivityUtil.this.onAppStatusListeners.size(); i2++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i2)).onBack();
                }
            }
        }
    };

    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    private ActivityUtil() {
    }

    public static PendingIntent getActivities(Context context, int i2, Intent[] intentArr, int i3) {
        if (context == null) {
            Logger.m6803w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i2, intentArr, i3);
        } catch (RuntimeException e2) {
            Logger.m6797e(TAG, "dealType rethrowFromSystemServer:", e2);
            return null;
        }
    }

    public static ActivityUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityUtil.class) {
                if (instance == null) {
                    instance = new ActivityUtil();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return getInstance().isForeground();
    }

    public void register() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.m6803w(TAG, "context is not application, register background fail");
        }
    }

    public void setOnAppStatusListener(OnAppStatusListener onAppStatusListener) {
        if (onAppStatusListener == null) {
            Logger.m6803w(TAG, "onAppStatusListener is null");
        } else if (this.onAppStatusListeners.size() >= 20) {
            Logger.m6803w(TAG, "onAppStatusListener of count is max");
        } else {
            this.onAppStatusListeners.add(onAppStatusListener);
        }
    }

    public void unRegister() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.m6803w(TAG, "context is not application, unRegister background fail");
        }
    }

    public boolean isForeground() {
        return this.isForeground;
    }
}
