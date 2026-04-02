package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: AsyncThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {
    private final ThreadGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4831b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4832c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f4832c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f4831b++;
        }
        Thread thread = new Thread(this.a, runnable, this.f4832c + this.f4831b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
