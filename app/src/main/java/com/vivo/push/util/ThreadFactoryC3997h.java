package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* compiled from: ConcurrentUtils.java */
/* renamed from: com.vivo.push.util.h */
/* loaded from: classes2.dex */
final class ThreadFactoryC3997h implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f14250a;

    ThreadFactoryC3997h(String str) {
        this.f14250a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f14250a);
        thread.setDaemon(true);
        return thread;
    }
}
