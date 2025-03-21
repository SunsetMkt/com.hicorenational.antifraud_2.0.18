package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: UpdateAdapterMgr.java */
/* renamed from: com.huawei.hms.availableupdate.c */
/* loaded from: classes.dex */
public class C2312c {

    /* renamed from: b */
    public static final C2312c f7172b = new C2312c();

    /* renamed from: a */
    private WeakReference<Activity> f7173a;

    /* renamed from: a */
    public boolean m6659a(Activity activity) {
        HMSLog.m7717i("UpdateAdapterMgr", "onActivityCreate");
        Activity m6658a = m6658a();
        if (m6658a == null || m6658a.isFinishing()) {
            this.f7173a = new WeakReference<>(activity);
            return true;
        }
        activity.finish();
        HMSLog.m7717i("UpdateAdapterMgr", "finish one");
        return false;
    }

    /* renamed from: b */
    public void m6660b(Activity activity) {
        HMSLog.m7717i("UpdateAdapterMgr", "onActivityDestroy");
        Activity m6658a = m6658a();
        if (activity == null || !activity.equals(m6658a)) {
            return;
        }
        HMSLog.m7717i("UpdateAdapterMgr", "reset");
        this.f7173a = null;
    }

    /* renamed from: a */
    private Activity m6658a() {
        WeakReference<Activity> weakReference = this.f7173a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
