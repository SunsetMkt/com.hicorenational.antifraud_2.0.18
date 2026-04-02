package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class BindingFailedResolveMgr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final BindingFailedResolveMgr f4459b = new BindingFailedResolveMgr();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4460c = new Object();
    List<Activity> a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    void a(Activity activity) {
        synchronized (f4460c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    void b(Activity activity) {
        synchronized (f4460c) {
            this.a.remove(activity);
        }
    }
}
