package com.umeng.socialize.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: UMAppScanner.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static WeakReference<Future<?>> a;

    public static void a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            a = new WeakReference<>(j.a(new g()));
        }
    }
}
