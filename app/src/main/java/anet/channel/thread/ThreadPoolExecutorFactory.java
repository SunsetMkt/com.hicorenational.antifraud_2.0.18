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

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ThreadPoolExecutorFactory {

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f1148a = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0850b("AWCN Scheduler"));

    /* renamed from: b */
    private static ThreadPoolExecutor f1149b = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN Worker(H)"));

    /* renamed from: c */
    private static ThreadPoolExecutor f1150c = new C0851a(16, 16, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0850b("AWCN Worker(M)"));

    /* renamed from: d */
    private static ThreadPoolExecutor f1151d = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN Worker(L)"));

    /* renamed from: e */
    private static ThreadPoolExecutor f1152e = new ThreadPoolExecutor(32, 32, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN Worker(Backup)"));

    /* renamed from: f */
    private static ThreadPoolExecutor f1153f = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN Detector"));

    /* renamed from: g */
    private static ThreadPoolExecutor f1154g = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN HR"));

    /* renamed from: h */
    private static ThreadPoolExecutor f1155h = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0850b("AWCN Cookie"));

    /* compiled from: Taobao */
    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.thread.ThreadPoolExecutorFactory$a */
    static class RunnableC0849a implements Comparable<RunnableC0849a>, Runnable {

        /* renamed from: a */
        Runnable f1156a;

        /* renamed from: b */
        int f1157b;

        /* renamed from: c */
        long f1158c;

        public RunnableC0849a(Runnable runnable, int i2) {
            this.f1156a = null;
            this.f1157b = 0;
            this.f1158c = System.currentTimeMillis();
            this.f1156a = runnable;
            this.f1157b = i2;
            this.f1158c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(RunnableC0849a runnableC0849a) {
            int i2 = this.f1157b;
            int i3 = runnableC0849a.f1157b;
            return i2 != i3 ? i2 - i3 : (int) (runnableC0849a.f1158c - this.f1158c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1156a.run();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.thread.ThreadPoolExecutorFactory$b */
    private static class ThreadFactoryC0850b implements ThreadFactory {

        /* renamed from: a */
        AtomicInteger f1159a = new AtomicInteger(0);

        /* renamed from: b */
        String f1160b;

        ThreadFactoryC0850b(String str) {
            this.f1160b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f1160b + this.f1159a.incrementAndGet());
            ALog.m716i("awcn.ThreadPoolExecutorFactory", "thread created!", null, CommonNetImpl.NAME, thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        f1149b.allowCoreThreadTimeOut(true);
        f1150c.allowCoreThreadTimeOut(true);
        f1151d.allowCoreThreadTimeOut(true);
        f1152e.allowCoreThreadTimeOut(true);
        f1153f.allowCoreThreadTimeOut(true);
        f1154g.allowCoreThreadTimeOut(true);
        f1155h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f1148a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i2) {
        synchronized (ThreadPoolExecutorFactory.class) {
            if (i2 < 6) {
                i2 = 6;
            }
            f1150c.setCorePoolSize(i2);
            f1150c.setMaximumPoolSize(i2);
        }
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f1152e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f1155h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f1153f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f1154g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, RemoteMessageConst.Notification.PRIORITY, Integer.valueOf(i2));
        }
        if (i2 < Priority.HIGH || i2 > Priority.LOW) {
            i2 = Priority.LOW;
        }
        return i2 == Priority.HIGH ? f1149b.submit(runnable) : i2 == Priority.LOW ? f1151d.submit(runnable) : f1150c.submit(new RunnableC0849a(runnable, i2));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f1148a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j2, TimeUnit timeUnit) {
        return f1148a.schedule(runnable, j2, timeUnit);
    }
}
