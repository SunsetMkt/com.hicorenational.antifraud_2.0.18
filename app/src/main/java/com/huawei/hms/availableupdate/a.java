package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppSpoofResolveMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4485c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f4486d = new Object();
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Activity> f4487b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f4486d) {
            for (Activity activity2 : this.f4487b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f4487b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f4486d) {
            this.f4487b.remove(activity);
        }
    }

    public void a(boolean z) {
        this.a.set(z);
    }

    public AtomicBoolean a() {
        return this.a;
    }
}
