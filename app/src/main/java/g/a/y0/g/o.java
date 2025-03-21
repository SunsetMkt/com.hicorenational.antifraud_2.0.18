package g.a.y0.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    static final String f15963a = "rx2.purge-enabled";

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f15964b;

    /* renamed from: c, reason: collision with root package name */
    static final String f15965c = "rx2.purge-period-seconds";

    /* renamed from: d, reason: collision with root package name */
    public static final int f15966d;

    /* renamed from: e, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f15967e = new AtomicReference<>();

    /* renamed from: f, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f15968f = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(o.f15968f.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        o.f15968f.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                g.a.c1.a.b(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int i2 = 1;
        boolean z = properties.containsKey(f15963a) ? Boolean.getBoolean(f15963a) : true;
        if (z && properties.containsKey(f15965c)) {
            i2 = Integer.getInteger(f15965c, 1).intValue();
        }
        f15964b = z;
        f15966d = i2;
        b();
    }

    private o() {
        throw new IllegalStateException("No instances!");
    }

    public static void a() {
        ScheduledExecutorService scheduledExecutorService = f15967e.get();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        f15968f.clear();
    }

    public static void b() {
        if (!f15964b) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f15967e.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new k("RxSchedulerPurge"));
            if (f15967e.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f15966d;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f15964b && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f15968f.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
