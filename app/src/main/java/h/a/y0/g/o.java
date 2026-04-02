package h.a.y0.g;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SchedulerPoolFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    static final String a = "rx2.purge-enabled";

    /* JADX INFO: renamed from: b */
    public static final boolean f11973b;

    /* JADX INFO: renamed from: c */
    static final String f11974c = "rx2.purge-period-seconds";

    /* JADX INFO: renamed from: d */
    public static final int f11975d;

    /* JADX INFO: renamed from: e */
    static final AtomicReference<ScheduledExecutorService> f11976e = new AtomicReference<>();

    /* JADX INFO: renamed from: f */
    static final Map<ScheduledThreadPoolExecutor, Object> f11977f = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SchedulerPoolFactory.java */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(o.f11977f.keySet())) {
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        o.f11977f.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                h.a.c1.a.b(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int iIntValue = 1;
        boolean z = properties.containsKey(a) ? Boolean.getBoolean(a) : true;
        if (z && properties.containsKey(f11974c)) {
            iIntValue = Integer.getInteger(f11974c, 1).intValue();
        }
        f11973b = z;
        f11975d = iIntValue;
        b();
    }

    private o() {
        throw new IllegalStateException("No instances!");
    }

    public static void a() {
        ScheduledExecutorService scheduledExecutorService = f11976e.get();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        f11977f.clear();
    }

    public static void b() {
        if (!f11973b) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f11976e.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new k("RxSchedulerPurge"));
            if (f11976e.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f11975d;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f11973b && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f11977f.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        return scheduledExecutorServiceNewScheduledThreadPool;
    }
}
