package anet.channel.strategy.utils;

import anet.channel.strategy.dispatch.C0830a;
import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.utils.a */
/* loaded from: classes.dex */
public class C0846a {

    /* renamed from: a */
    private static AtomicInteger f1146a = new AtomicInteger(0);

    /* renamed from: b */
    private static ScheduledThreadPoolExecutor f1147b = null;

    /* renamed from: a */
    static ScheduledThreadPoolExecutor m701a() {
        if (f1147b == null) {
            synchronized (C0846a.class) {
                if (f1147b == null) {
                    f1147b = new ScheduledThreadPoolExecutor(2, new ThreadFactoryC0847b());
                    f1147b.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    f1147b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f1147b;
    }

    /* renamed from: a */
    public static void m702a(Runnable runnable) {
        try {
            m701a().submit(runnable);
        } catch (Exception e2) {
            ALog.m714e(C0830a.TAG, "submit task failed", null, e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m703a(Runnable runnable, long j2) {
        try {
            m701a().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.m714e(C0830a.TAG, "schedule task failed", null, e2, new Object[0]);
        }
    }
}
