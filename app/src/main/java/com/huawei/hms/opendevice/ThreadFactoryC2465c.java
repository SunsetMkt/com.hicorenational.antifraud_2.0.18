package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* compiled from: AsyncThreadFactory.java */
/* renamed from: com.huawei.hms.opendevice.c */
/* loaded from: classes.dex */
public class ThreadFactoryC2465c implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f7655a;

    /* renamed from: b */
    private int f7656b = 1;

    /* renamed from: c */
    private final String f7657c;

    public ThreadFactoryC2465c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f7655a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f7657c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f7656b++;
        }
        Thread thread = new Thread(this.f7655a, runnable, this.f7657c + this.f7656b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
