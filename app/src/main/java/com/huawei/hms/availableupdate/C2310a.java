package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AppSpoofResolveMgr.java */
/* renamed from: com.huawei.hms.availableupdate.a */
/* loaded from: classes.dex */
public class C2310a {

    /* renamed from: c */
    public static final C2310a f7165c = new C2310a();

    /* renamed from: d */
    private static final Object f7166d = new Object();

    /* renamed from: a */
    private final AtomicBoolean f7167a = new AtomicBoolean(false);

    /* renamed from: b */
    private final List<Activity> f7168b = new ArrayList(1);

    /* renamed from: a */
    public void m6653a(Activity activity) {
        synchronized (f7166d) {
            for (Activity activity2 : this.f7168b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f7168b.add(activity);
        }
    }

    /* renamed from: b */
    public void m6655b(Activity activity) {
        synchronized (f7166d) {
            this.f7168b.remove(activity);
        }
    }

    /* renamed from: a */
    public void m6654a(boolean z) {
        this.f7167a.set(z);
    }

    /* renamed from: a */
    public AtomicBoolean m6652a() {
        return this.f7167a;
    }
}
