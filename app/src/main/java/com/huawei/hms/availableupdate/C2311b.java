package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotInstalledHmsResolveMgr.java */
/* renamed from: com.huawei.hms.availableupdate.b */
/* loaded from: classes.dex */
public class C2311b {

    /* renamed from: b */
    public static final C2311b f7169b = new C2311b();

    /* renamed from: c */
    private static final Object f7170c = new Object();

    /* renamed from: a */
    private final List<Activity> f7171a = new ArrayList(1);

    /* renamed from: a */
    public void m6656a(Activity activity) {
        synchronized (f7170c) {
            for (Activity activity2 : this.f7171a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f7171a.add(activity);
        }
    }

    /* renamed from: b */
    public void m6657b(Activity activity) {
        synchronized (f7170c) {
            this.f7171a.remove(activity);
        }
    }
}
