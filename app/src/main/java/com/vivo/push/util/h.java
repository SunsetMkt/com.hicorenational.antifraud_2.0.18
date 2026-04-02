package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ConcurrentUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements ThreadFactory {
    final /* synthetic */ String a;

    h(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.a);
        thread.setDaemon(true);
        return thread;
    }
}
