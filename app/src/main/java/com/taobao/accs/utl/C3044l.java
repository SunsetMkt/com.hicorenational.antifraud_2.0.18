package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.l */
/* loaded from: classes2.dex */
public class C3044l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;

    /* renamed from: b */
    private static volatile C3044l f9748b;

    /* renamed from: c */
    private static ArrayList<a> f9749c;

    /* renamed from: d */
    private static ArrayList<b> f9750d;

    /* renamed from: e */
    private static Application f9751e;

    /* renamed from: g */
    private boolean f9754g;

    /* renamed from: a */
    private static final String f9747a = C3044l.class.getSimpleName();

    /* renamed from: j */
    private static boolean f9752j = false;

    /* renamed from: f */
    private int f9753f = 0;

    /* renamed from: h */
    private int f9755h = 0;

    /* renamed from: i */
    private int f9756i = 1;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.utl.l$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private String f9757a;

        /* renamed from: b */
        private int f9758b;

        /* renamed from: c */
        private long f9759c = C3052t.m9273a(C3044l.f9751e);

        public a(String str, int i2) {
            this.f9757a = str;
            this.f9758b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ALog.m9182e(C3044l.f9747a, "click report", "lastActiveTime", Long.valueOf(this.f9759c), "currentActiveTime", Long.valueOf(currentTimeMillis));
            long j2 = this.f9759c;
            if (j2 == 0 || UtilityImpl.m9204a(j2, currentTimeMillis)) {
                this.f9758b |= 8;
            }
            TaobaoRegister.clickMessage(C3044l.f9751e, this.f9757a, null, this.f9758b, this.f9759c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.utl.l$b */
    public interface b {
        /* renamed from: a */
        void mo9076a();

        /* renamed from: b */
        void mo9077b();
    }

    private C3044l() {
        f9749c = new ArrayList<>();
        f9750d = new ArrayList<>();
    }

    /* renamed from: a */
    public static C3044l m9252a() {
        if (f9748b == null) {
            synchronized (C3044l.class) {
                if (f9748b == null) {
                    f9748b = new C3044l();
                }
            }
        }
        return f9748b;
    }

    /* renamed from: b */
    public void m9257b() {
        ArrayList<a> arrayList = f9749c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f9749c.clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i2 = this.f9753f;
        if ((i2 & 1) != 1) {
            this.f9753f = i2 | 1;
            this.f9753f |= 2;
        } else if ((i2 & 2) == 2) {
            this.f9753f = i2 & (-3);
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
        if (this.f9754g) {
            C3052t.m9274a(f9751e, System.currentTimeMillis());
            if (!f9752j) {
                f9752j = true;
            }
        }
        this.f9754g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f9755h;
        this.f9755h = i2 + 1;
        if (i2 == 0) {
            ALog.m9183i(f9747a, "onActivityStarted back to force", new Object[0]);
            this.f9754g = true;
            this.f9756i = 1;
            ThreadPoolExecutorFactory.execute(new RunnableC3045m(this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f9755h - 1;
        this.f9755h = i2;
        if (i2 == 0) {
            this.f9756i = 0;
            ThreadPoolExecutorFactory.execute(new RunnableC3046n(this));
        }
    }

    /* renamed from: a */
    public void m9256a(b bVar) {
        if (bVar != null) {
            f9750d.add(bVar);
        }
    }
}
