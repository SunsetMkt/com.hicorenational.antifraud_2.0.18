package anet.channel.thread;

import anet.channel.util.ALog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ThreadPoolExecutorFactory {
    private static ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f1637b = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f1638c = new anet.channel.thread.a(16, 16, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f1639d = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f1640e = new ThreadPoolExecutor(32, 32, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f1641f = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Detector"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f1642g = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN HR"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f1643h = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Cookie"));

    /* JADX INFO: compiled from: Taobao */
    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    /* JADX INFO: compiled from: Taobao */
    static class a implements Comparable<a>, Runnable {
        Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f1645c;

        public a(Runnable runnable, int i2) {
            this.a = null;
            this.f1644b = 0;
            this.f1645c = System.currentTimeMillis();
            this.a = runnable;
            this.f1644b = i2;
            this.f1645c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i2 = this.f1644b;
            int i3 = aVar.f1644b;
            return i2 != i3 ? i2 - i3 : (int) (aVar.f1645c - this.f1645c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    /* JADX INFO: compiled from: Taobao */
    private static class b implements ThreadFactory {
        AtomicInteger a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1646b;

        b(String str) {
            this.f1646b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f1646b + this.a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, CommonNetImpl.NAME, thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        f1637b.allowCoreThreadTimeOut(true);
        f1638c.allowCoreThreadTimeOut(true);
        f1639d.allowCoreThreadTimeOut(true);
        f1640e.allowCoreThreadTimeOut(true);
        f1641f.allowCoreThreadTimeOut(true);
        f1642g.allowCoreThreadTimeOut(true);
        f1643h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i2) {
        if (i2 < 6) {
            i2 = 6;
        }
        f1638c.setCorePoolSize(i2);
        f1638c.setMaximumPoolSize(i2);
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f1640e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f1643h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f1641f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f1642g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, RemoteMessageConst.Notification.PRIORITY, Integer.valueOf(i2));
        }
        if (i2 < Priority.HIGH || i2 > Priority.LOW) {
            i2 = Priority.LOW;
        }
        return i2 == Priority.HIGH ? f1637b.submit(runnable) : i2 == Priority.LOW ? f1639d.submit(runnable) : f1638c.submit(new a(runnable, i2));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j2, TimeUnit timeUnit) {
        return a.schedule(runnable, j2, timeUnit);
    }
}
