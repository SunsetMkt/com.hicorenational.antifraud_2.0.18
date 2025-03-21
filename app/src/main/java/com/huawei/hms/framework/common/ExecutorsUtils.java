package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class ExecutorsUtils {
    private static final String THREADNAME_HEADER = "NetworkKit_";

    public static ThreadFactory createThreadFactory(final String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException("ThreadName is empty");
        }
        return new ThreadFactory() { // from class: com.huawei.hms.framework.common.ExecutorsUtils.1
            private final AtomicInteger threadNumbers = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return ExecutorsUtils.newThread(runnable, str + AbstractC1191a.f2606s1 + this.threadNumbers.getAndIncrement());
            }
        };
    }

    public static ExecutorService newCachedThreadPool(String str) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return threadPoolExcutorEnhance;
    }

    public static ExecutorService newFixedThreadPool(int i2, String str) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return threadPoolExcutorEnhance;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i2, String str) {
        return new ScheduledThreadPoolExecutorEnhance(i2, createThreadFactory(str));
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
    }

    public static Thread newThread(Runnable runnable, String str) {
        return new Thread(runnable, THREADNAME_HEADER + str);
    }
}
