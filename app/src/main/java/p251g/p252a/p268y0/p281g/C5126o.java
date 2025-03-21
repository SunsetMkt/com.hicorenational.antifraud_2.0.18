package p251g.p252a.p268y0.p281g;

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
import p251g.p252a.p255c1.C4476a;

/* compiled from: SchedulerPoolFactory.java */
/* renamed from: g.a.y0.g.o */
/* loaded from: classes2.dex */
public final class C5126o {

    /* renamed from: a */
    static final String f19906a = "rx2.purge-enabled";

    /* renamed from: b */
    public static final boolean f19907b;

    /* renamed from: c */
    static final String f19908c = "rx2.purge-period-seconds";

    /* renamed from: d */
    public static final int f19909d;

    /* renamed from: e */
    static final AtomicReference<ScheduledExecutorService> f19910e = new AtomicReference<>();

    /* renamed from: f */
    static final Map<ScheduledThreadPoolExecutor, Object> f19911f = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: g.a.y0.g.o$a */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(C5126o.f19911f.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        C5126o.f19911f.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                C4476a.m17152b(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int i2 = 1;
        boolean z = properties.containsKey(f19906a) ? Boolean.getBoolean(f19906a) : true;
        if (z && properties.containsKey(f19908c)) {
            i2 = Integer.getInteger(f19908c, 1).intValue();
        }
        f19907b = z;
        f19909d = i2;
        m18575b();
    }

    private C5126o() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static void m18574a() {
        ScheduledExecutorService scheduledExecutorService = f19910e.get();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        f19911f.clear();
    }

    /* renamed from: b */
    public static void m18575b() {
        if (!f19907b) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f19910e.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC5122k("RxSchedulerPurge"));
            if (f19910e.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f19909d;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m18573a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f19907b && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f19911f.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
