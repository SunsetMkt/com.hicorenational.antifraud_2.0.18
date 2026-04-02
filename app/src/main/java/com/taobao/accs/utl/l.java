package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile l f5934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f5935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<b> f5936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Application f5937e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5940g;
    private static final String a = l.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f5938j = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5939f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5941h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5942i = 1;

    /* JADX INFO: compiled from: Taobao */
    public static class a implements Runnable {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f5944c = t.a(l.f5937e);

        public a(String str, int i2) {
            this.a = str;
            this.f5943b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ALog.e(l.a, "click report", "lastActiveTime", Long.valueOf(this.f5944c), "currentActiveTime", Long.valueOf(jCurrentTimeMillis));
            long j2 = this.f5944c;
            if (j2 == 0 || UtilityImpl.a(j2, jCurrentTimeMillis)) {
                this.f5943b |= 8;
            }
            TaobaoRegister.clickMessage(l.f5937e, this.a, null, this.f5943b, this.f5944c);
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public interface b {
        void a();

        void b();
    }

    private l() {
        f5935c = new ArrayList<>();
        f5936d = new ArrayList<>();
    }

    public static l a() {
        if (f5934b == null) {
            synchronized (l.class) {
                if (f5934b == null) {
                    f5934b = new l();
                }
            }
        }
        return f5934b;
    }

    public void b() {
        ArrayList<a> arrayList = f5935c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f5935c.clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i2 = this.f5939f;
        if ((i2 & 1) != 1) {
            this.f5939f = i2 | 1;
            this.f5939f |= 2;
        } else if ((i2 & 2) == 2) {
            this.f5939f = i2 & (-3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f5940g) {
            t.a(f5937e, System.currentTimeMillis());
            if (!f5938j) {
                f5938j = true;
            }
        }
        this.f5940g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f5941h;
        this.f5941h = i2 + 1;
        if (i2 == 0) {
            ALog.i(a, "onActivityStarted back to force", new Object[0]);
            this.f5940g = true;
            this.f5942i = 1;
            ThreadPoolExecutorFactory.execute(new m(this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f5941h - 1;
        this.f5941h = i2;
        if (i2 == 0) {
            this.f5942i = 0;
            ThreadPoolExecutorFactory.execute(new n(this));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f5936d.add(bVar);
        }
    }
}
