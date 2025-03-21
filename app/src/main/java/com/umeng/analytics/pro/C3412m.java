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

/* compiled from: BackgroundMonitor.java */
@TargetApi(14)
/* renamed from: com.umeng.analytics.pro.m */
/* loaded from: classes2.dex */
public class C3412m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static C3412m f12157a = new C3412m();

    /* renamed from: b */
    private final int f12158b = PathInterpolatorCompat.MAX_NUM_POINTS;

    /* renamed from: c */
    private boolean f12159c = false;

    /* renamed from: d */
    private boolean f12160d = true;

    /* renamed from: e */
    private Handler f12161e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private ArrayList<InterfaceC3413n> f12162f = new ArrayList<>();

    /* renamed from: g */
    private a f12163g = new a();

    /* compiled from: BackgroundMonitor.java */
    /* renamed from: com.umeng.analytics.pro.m$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C3412m.this.f12159c || !C3412m.this.f12160d) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            C3412m.this.f12159c = false;
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < C3412m.this.f12162f.size(); i2++) {
                ((InterfaceC3413n) C3412m.this.f12162f.get(i2)).mo10789n();
            }
        }
    }

    private C3412m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f12160d = true;
        a aVar = this.f12163g;
        if (aVar != null) {
            this.f12161e.removeCallbacks(aVar);
            this.f12161e.postDelayed(this.f12163g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f12160d = false;
        this.f12159c = true;
        a aVar = this.f12163g;
        if (aVar != null) {
            this.f12161e.removeCallbacks(aVar);
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

    /* renamed from: b */
    public synchronized void m11299b(InterfaceC3413n interfaceC3413n) {
        if (interfaceC3413n != null) {
            for (int i2 = 0; i2 < this.f12162f.size(); i2++) {
                if (this.f12162f.get(i2) == interfaceC3413n) {
                    this.f12162f.remove(i2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11293a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f12157a);
        }
    }

    /* renamed from: a */
    public static C3412m m11292a() {
        return f12157a;
    }

    /* renamed from: a */
    public synchronized void m11298a(InterfaceC3413n interfaceC3413n) {
        if (interfaceC3413n != null) {
            this.f12162f.add(interfaceC3413n);
        }
    }
}
