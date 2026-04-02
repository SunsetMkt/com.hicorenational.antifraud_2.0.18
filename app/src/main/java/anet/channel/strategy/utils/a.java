package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f1636b = null;

    static ScheduledThreadPoolExecutor a() {
        if (f1636b == null) {
            synchronized (a.class) {
                if (f1636b == null) {
                    f1636b = new ScheduledThreadPoolExecutor(2, new b());
                    f1636b.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    f1636b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f1636b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "submit task failed", null, e2, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j2) {
        try {
            a().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "schedule task failed", null, e2, new Object[0]);
        }
    }
}
