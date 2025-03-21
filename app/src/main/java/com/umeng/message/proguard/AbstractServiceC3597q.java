package com.umeng.message.proguard;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.umeng.message.proguard.q */
/* loaded from: classes2.dex */
public abstract class AbstractServiceC3597q extends Service {
    private static final String TAG = "BaseService";
    private static final int jobIndex = 21000;
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    b mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    private static final HashMap<Class<?>, Integer> jobMap = new HashMap<>();
    private static final Object mRealTimeModeLock = new Object();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    /* renamed from: com.umeng.message.proguard.q$a */
    static class a implements Runnable {

        /* renamed from: a */
        private AbstractServiceC3597q f13333a;

        a(AbstractServiceC3597q abstractServiceC3597q) {
            this.f13333a = abstractServiceC3597q;
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    e dequeueWork = this.f13333a.dequeueWork();
                    if (dequeueWork != null) {
                        this.f13333a.onHandleWork(dequeueWork.mo12436a());
                        dequeueWork.mo12437b();
                    }
                } catch (Throwable th) {
                    UPLog.m12143e(AbstractServiceC3597q.TAG, th);
                }
                try {
                    break;
                } catch (Throwable th2) {
                    UPLog.m12143e(AbstractServiceC3597q.TAG, th2);
                }
            }
            this.f13333a.processorFinished();
            this.f13333a = null;
        }
    }

    /* renamed from: com.umeng.message.proguard.q$b */
    interface b {
        /* renamed from: a */
        IBinder mo12430a();

        /* renamed from: b */
        e mo12431b();
    }

    /* renamed from: com.umeng.message.proguard.q$d */
    final class d implements e {

        /* renamed from: a */
        final Intent f13339a;

        /* renamed from: b */
        final int f13340b;

        d(Intent intent, int i2) {
            this.f13339a = intent;
            this.f13340b = i2;
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.e
        /* renamed from: a */
        public final Intent mo12436a() {
            return this.f13339a;
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.e
        /* renamed from: b */
        public final void mo12437b() {
            try {
                AbstractServiceC3597q.this.stopSelf(this.f13340b);
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.q$e */
    interface e {
        /* renamed from: a */
        Intent mo12436a();

        /* renamed from: b */
        void mo12437b();
    }

    @TargetApi(26)
    /* renamed from: com.umeng.message.proguard.q$f */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a */
        final AbstractServiceC3597q f13342a;

        /* renamed from: b */
        final Object f13343b;

        /* renamed from: c */
        JobParameters f13344c;

        /* renamed from: com.umeng.message.proguard.q$f$a */
        final class a implements e {

            /* renamed from: a */
            final JobWorkItem f13345a;

            a(JobWorkItem jobWorkItem) {
                this.f13345a = jobWorkItem;
            }

            @Override // com.umeng.message.proguard.AbstractServiceC3597q.e
            /* renamed from: a */
            public final Intent mo12436a() {
                return this.f13345a.getIntent();
            }

            @Override // com.umeng.message.proguard.AbstractServiceC3597q.e
            /* renamed from: b */
            public final void mo12437b() {
                try {
                    synchronized (f.this.f13343b) {
                        if (f.this.f13344c != null) {
                            try {
                                f.this.f13344c.completeWork(this.f13345a);
                            } catch (Throwable th) {
                                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    UPLog.m12143e(AbstractServiceC3597q.TAG, th2);
                }
            }
        }

        f(AbstractServiceC3597q abstractServiceC3597q) {
            super(abstractServiceC3597q);
            this.f13343b = new Object();
            this.f13342a = abstractServiceC3597q;
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.b
        /* renamed from: a */
        public final IBinder mo12430a() {
            return getBinder();
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.b
        /* renamed from: b */
        public final e mo12431b() {
            try {
                synchronized (this.f13343b) {
                    if (this.f13344c == null) {
                        return null;
                    }
                    JobWorkItem dequeueWork = this.f13344c.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    dequeueWork.getIntent().setExtrasClassLoader(this.f13342a.getClassLoader());
                    return new a(dequeueWork);
                }
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.f13344c = jobParameters;
            this.f13342a.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.f13342a.doStopCurrentWork();
            synchronized (this.f13343b) {
                this.f13344c = null;
            }
            return doStopCurrentWork;
        }
    }

    @TargetApi(21)
    /* renamed from: com.umeng.message.proguard.q$g */
    static final class g extends h {

        /* renamed from: a */
        private final JobInfo f13347a;

        /* renamed from: b */
        private JobScheduler f13348b;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            m12438a(i2);
            this.f13347a = new JobInfo.Builder(i2, this.f13349c).setOverrideDeadline(0L).build();
            try {
                this.f13348b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.h
        /* renamed from: a */
        final void mo12433a(Intent intent) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f13348b.enqueue(this.f13347a, new JobWorkItem(intent));
                }
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.q$h */
    static abstract class h {

        /* renamed from: c */
        final ComponentName f13349c;

        /* renamed from: d */
        boolean f13350d;

        /* renamed from: e */
        int f13351e;

        h(ComponentName componentName) {
            this.f13349c = componentName;
        }

        /* renamed from: a */
        public void mo12432a() {
        }

        /* renamed from: a */
        final void m12438a(int i2) {
            if (!this.f13350d) {
                this.f13350d = true;
                this.f13351e = i2;
            } else {
                if (this.f13351e == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f13351e);
            }
        }

        /* renamed from: a */
        abstract void mo12433a(Intent intent);

        /* renamed from: b */
        public void mo12434b() {
        }

        /* renamed from: c */
        public void mo12435c() {
        }
    }

    public AbstractServiceC3597q() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    private static void enqueueWork(Context context, Class<?> cls, int i2, Intent intent) {
        if (context == null || cls == null || intent == null) {
            return;
        }
        try {
            enqueueWork(context, new ComponentName(context, cls), i2, intent);
        } catch (Throwable th) {
            UPLog.m12144e(TAG, "jobId:", Integer.valueOf(i2), "failed:", th.getMessage());
        }
    }

    static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z, int i2) {
        h cVar;
        h hVar = sClassWorkEnqueuer.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i2);
        }
        h hVar2 = cVar;
        sClassWorkEnqueuer.put(componentName, hVar2);
        return hVar2;
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJobImpl = new f(this);
                this.mCompatWorkEnqueuer = null;
            } else {
                this.mJobImpl = null;
                this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
            }
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    e dequeueWork() {
        d remove;
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.mo12431b();
        }
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            remove = this.mCompatQueue.size() > 0 ? this.mCompatQueue.remove(0) : null;
        }
        return remove;
    }

    boolean doStopCurrentWork() {
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean z) {
        try {
            if (this.mCurProcessor == null) {
                this.mCurProcessor = new a(this);
                if (this.mCompatWorkEnqueuer != null && z) {
                    this.mCompatWorkEnqueuer.mo12434b();
                }
                C3578b.m12323a(this.mCurProcessor);
            }
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            try {
                if (this.mJobImpl != null) {
                    return this.mJobImpl.mo12430a();
                }
                return null;
            } catch (Throwable th) {
                UPLog.m12143e(TAG, th);
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.mCompatQueue != null) {
                synchronized (this.mCompatQueue) {
                    this.mDestroyed = true;
                    this.mCompatWorkEnqueuer.mo12435c();
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    protected void onHandleWork(Intent intent) {
        UPLog.m12145i(TAG, "onHandleWork");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            try {
                if (this.mCompatQueue == null) {
                    return 2;
                }
                if (this.mCompatWorkEnqueuer == null) {
                    init();
                }
                this.mCompatWorkEnqueuer.mo12432a();
                synchronized (this.mCompatQueue) {
                    this.mCompatQueue.add(new d(intent, i3));
                    ensureProcessorRunningLocked(true);
                }
                return 3;
            } catch (Throwable th) {
                UPLog.m12143e(TAG, th);
            }
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    void processorFinished() {
        try {
            if (this.mCompatQueue != null) {
                synchronized (this.mCompatQueue) {
                    this.mCurProcessor = null;
                    if (this.mCompatQueue.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.mo12435c();
                    }
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    public void setInterruptIfStopped(boolean z) {
        this.mInterruptIfStopped = z;
    }

    private static void enqueueWork(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        if (context == null || componentName == null) {
            return;
        }
        synchronized (sLock) {
            h workEnqueuer = getWorkEnqueuer(context, componentName, true, i2);
            workEnqueuer.m12438a(i2);
            workEnqueuer.mo12433a(intent);
        }
    }

    public static <T extends AbstractServiceC3597q> void enqueueWork(Context context, Class<T> cls, Intent intent) {
        int intValue;
        synchronized (mRealTimeModeLock) {
            if (context == null || cls == null || intent == null) {
                return;
            }
            UPLog.m12145i(TAG, "enqueue cls:", cls.getSimpleName());
            if (!jobMap.containsKey(cls)) {
                intValue = jobMap.size() + 21000;
                jobMap.put(cls, Integer.valueOf(intValue));
            } else {
                Integer num = jobMap.get(cls);
                if (num == null) {
                    return;
                } else {
                    intValue = num.intValue();
                }
            }
            UPLog.m12145i(TAG, "jobId:", Integer.valueOf(intValue));
            enqueueWork(context, (Class<?>) cls, intValue, intent);
        }
    }

    /* renamed from: com.umeng.message.proguard.q$c */
    static final class c extends h {

        /* renamed from: a */
        boolean f13334a;

        /* renamed from: b */
        boolean f13335b;

        /* renamed from: f */
        private final Context f13336f;

        /* renamed from: g */
        private final PowerManager.WakeLock f13337g;

        /* renamed from: h */
        private final PowerManager.WakeLock f13338h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f13336f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f13337g = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f13337g.setReferenceCounted(false);
            this.f13338h = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f13338h.setReferenceCounted(false);
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.h
        /* renamed from: a */
        final void mo12433a(Intent intent) {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.f13349c);
                if (this.f13336f.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.f13334a) {
                            this.f13334a = true;
                            if (!this.f13335b) {
                                this.f13337g.acquire(C2084a.f6122d);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.h
        /* renamed from: b */
        public final void mo12434b() {
            try {
                synchronized (this) {
                    if (!this.f13335b) {
                        this.f13335b = true;
                        this.f13338h.acquire(600000L);
                        this.f13337g.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.h
        /* renamed from: c */
        public final void mo12435c() {
            try {
                synchronized (this) {
                    if (this.f13335b) {
                        if (this.f13334a) {
                            this.f13337g.acquire(C2084a.f6122d);
                        }
                        this.f13335b = false;
                        this.f13338h.release();
                    }
                }
            } catch (Throwable th) {
                UPLog.m12143e(AbstractServiceC3597q.TAG, th);
            }
        }

        @Override // com.umeng.message.proguard.AbstractServiceC3597q.h
        /* renamed from: a */
        public final void mo12432a() {
            synchronized (this) {
                this.f13334a = false;
            }
        }
    }
}
