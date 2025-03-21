package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ApkResolutionFailedManager {

    /* renamed from: c */
    private static final ApkResolutionFailedManager f7088c = new ApkResolutionFailedManager();

    /* renamed from: a */
    private final Handler f7089a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private final Map<String, Runnable> f7090b = new HashMap(2);

    private ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f7088c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m7715e("ApkResolutionFailedManager", "postTask is not in main thread");
        } else {
            this.f7090b.put(str, runnable);
            this.f7089a.postDelayed(runnable, 2000L);
        }
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m7715e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable remove = this.f7090b.remove(str);
        if (remove == null) {
            HMSLog.m7715e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f7089a.removeCallbacks(remove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.m7715e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f7090b.remove(str);
        }
    }
}
