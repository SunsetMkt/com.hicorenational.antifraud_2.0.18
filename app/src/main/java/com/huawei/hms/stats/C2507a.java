package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnalyticsCacheManager.java */
/* renamed from: com.huawei.hms.stats.a */
/* loaded from: classes.dex */
public class C2507a {

    /* renamed from: f */
    private static final C2507a f7817f = new C2507a();

    /* renamed from: a */
    private final Object f7818a = new Object();

    /* renamed from: b */
    private boolean f7819b = false;

    /* renamed from: c */
    private final List<Runnable> f7820c = new ArrayList();

    /* renamed from: d */
    private final Handler f7821d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final Runnable f7822e = new a();

    /* compiled from: AnalyticsCacheManager.java */
    /* renamed from: com.huawei.hms.stats.a$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m7717i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                C2507a.this.m7659b();
            } else {
                C2507a.this.m7657a();
            }
        }
    }

    private C2507a() {
    }

    /* renamed from: c */
    public static C2507a m7656c() {
        return f7817f;
    }

    /* renamed from: a */
    public void m7658a(Runnable runnable) {
        synchronized (this.f7818a) {
            if (runnable == null) {
                return;
            }
            if (this.f7819b) {
                return;
            }
            if (this.f7820c.size() >= 60) {
                return;
            }
            this.f7820c.add(runnable);
            this.f7821d.removeCallbacks(this.f7822e);
            this.f7821d.postDelayed(this.f7822e, C2084a.f6135q);
        }
    }

    /* renamed from: b */
    public void m7659b() {
        synchronized (this.f7818a) {
            HMSLog.m7717i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f7820c.size());
            this.f7819b = true;
            try {
                Iterator<Runnable> it = this.f7820c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.m7715e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                m7657a();
            }
            this.f7819b = false;
        }
    }

    /* renamed from: a */
    public void m7657a() {
        synchronized (this.f7818a) {
            HMSLog.m7717i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f7820c.clear();
        }
    }
}
