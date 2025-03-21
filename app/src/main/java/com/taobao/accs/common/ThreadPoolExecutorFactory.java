package com.taobao.accs.common;

import com.taobao.accs.utl.ALog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ThreadPoolExecutorFactory {
    private static final String TAG = "ThreadPoolExecutorFactory";
    private static volatile ScheduledThreadPoolExecutor callbackThreadPoolExecutor;
    private static final AtomicInteger integer = new AtomicInteger();
    private static volatile ScheduledThreadPoolExecutor scheduleThreadPoolExecutor;
    private static volatile ScheduledThreadPoolExecutor sendThreadPoolExecutor;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.common.ThreadPoolExecutorFactory$a */
    static class ThreadFactoryC2981a implements ThreadFactory {

        /* renamed from: a */
        private String f9416a;

        public ThreadFactoryC2981a(String str) {
            this.f9416a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f9416a + ThreadPoolExecutorFactory.integer.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    public static void execute(Runnable runnable) {
        try {
            getScheduledExecutor().execute(runnable);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "ThreadPoolExecutorFactory execute", th, new Object[0]);
        }
    }

    public static void executeCallback(Runnable runnable) {
        try {
            getCallbackScheduledExecutor().execute(runnable);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "ThreadPoolExecutorFactory execute", th, new Object[0]);
        }
    }

    public static ScheduledThreadPoolExecutor getCallbackScheduledExecutor() {
        if (callbackThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (callbackThreadPoolExecutor == null) {
                    callbackThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC2981a("ACCS-CB"));
                }
            }
        }
        return callbackThreadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (scheduleThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (scheduleThreadPoolExecutor == null) {
                    scheduleThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC2981a("ACCS"));
                    scheduleThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    scheduleThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return scheduleThreadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor getSendScheduledExecutor() {
        if (sendThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (sendThreadPoolExecutor == null) {
                    sendThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC2981a("ACCS-SEND"));
                    sendThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    sendThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return sendThreadPoolExecutor;
    }

    public static ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            return getScheduledExecutor().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "ThreadPoolExecutorFactory schedule", th, new Object[0]);
            return null;
        }
    }
}
