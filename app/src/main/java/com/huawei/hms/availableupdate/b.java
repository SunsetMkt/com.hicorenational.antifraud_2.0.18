package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: NotInstalledHmsResolveMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4488b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4489c = new Object();
    private final List<Activity> a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f4489c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f4489c) {
            this.a.remove(activity);
        }
    }
}
