package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class BindingFailedResolveMgr {

    /* renamed from: b */
    static final BindingFailedResolveMgr f7112b = new BindingFailedResolveMgr();

    /* renamed from: c */
    private static final Object f7113c = new Object();

    /* renamed from: a */
    List<Activity> f7114a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    /* renamed from: a */
    void m6608a(Activity activity) {
        synchronized (f7113c) {
            for (Activity activity2 : this.f7114a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f7114a.add(activity);
        }
    }

    /* renamed from: b */
    void m6609b(Activity activity) {
        synchronized (f7113c) {
            this.f7114a.remove(activity);
        }
    }
}
