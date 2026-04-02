package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnalyticsCacheManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f */
    private static final a f4913f = new a();
    private final Object a = new Object();

    /* JADX INFO: renamed from: b */
    private boolean f4914b = false;

    /* JADX INFO: renamed from: c */
    private final List<Runnable> f4915c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private final Handler f4916d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e */
    private final Runnable f4917e = new RunnableC0094a();

    /* JADX INFO: renamed from: com.huawei.hms.stats.a$a */
    /* JADX INFO: compiled from: AnalyticsCacheManager.java */
    class RunnableC0094a implements Runnable {
        RunnableC0094a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.b();
            } else {
                a.this.a();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f4913f;
    }

    public void a(Runnable runnable) {
        synchronized (this.a) {
            if (runnable == null) {
                return;
            }
            if (this.f4914b) {
                return;
            }
            if (this.f4915c.size() >= 60) {
                return;
            }
            this.f4915c.add(runnable);
            this.f4916d.removeCallbacks(this.f4917e);
            this.f4916d.postDelayed(this.f4917e, com.heytap.mcssdk.constant.a.q);
        }
    }

    public void b() {
        synchronized (this.a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f4915c.size());
            this.f4914b = true;
            try {
                Iterator<Runnable> it = this.f4915c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                a();
            }
            this.f4914b = false;
        }
    }

    public void a() {
        synchronized (this.a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f4915c.clear();
        }
    }
}
