package com.umeng.message.proguard;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    private static WeakReference<Future<?>> a;

    public static synchronized void a() {
        Future<?> future;
        if (a == null || (future = a.get()) == null || future.isDone() || future.isCancelled()) {
            a = new WeakReference<>(b.b(new m()));
        }
    }
}
