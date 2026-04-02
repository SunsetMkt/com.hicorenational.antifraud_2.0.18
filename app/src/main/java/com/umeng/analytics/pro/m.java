package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackgroundMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public class m implements Application.ActivityLifecycleCallbacks {
    private static m a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7330b = PathInterpolatorCompat.MAX_NUM_POINTS;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7331c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7332d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f7333e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<n> f7334f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f7335g = new a();

    /* JADX INFO: compiled from: BackgroundMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f7331c || !m.this.f7332d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f7331c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < m.this.f7334f.size(); i2++) {
                ((n) m.this.f7334f.get(i2)).n();
            }
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f7332d = true;
        a aVar = this.f7335g;
        if (aVar != null) {
            this.f7333e.removeCallbacks(aVar);
            this.f7333e.postDelayed(this.f7335g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f7332d = false;
        this.f7331c = true;
        a aVar = this.f7335g;
        if (aVar != null) {
            this.f7333e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i2 = 0; i2 < this.f7334f.size(); i2++) {
                if (this.f7334f.get(i2) == nVar) {
                    this.f7334f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static m a() {
        return a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f7334f.add(nVar);
        }
    }
}
