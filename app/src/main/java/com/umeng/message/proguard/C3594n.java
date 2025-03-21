package com.umeng.message.proguard;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* renamed from: com.umeng.message.proguard.n */
/* loaded from: classes2.dex */
public final class C3594n {

    /* renamed from: a */
    private static WeakReference<Future<?>> f13312a;

    /* renamed from: a */
    public static synchronized void m12421a() {
        Future<?> future;
        synchronized (C3594n.class) {
            if (f13312a == null || (future = f13312a.get()) == null || future.isDone() || future.isCancelled()) {
                f13312a = new WeakReference<>(C3578b.m12325b(new RunnableC3593m()));
            }
        }
    }
}
