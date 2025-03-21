package com.umeng.socialize.p215a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* compiled from: UMAppScanner.java */
/* renamed from: com.umeng.socialize.a.h */
/* loaded from: classes2.dex */
public class C3622h {

    /* renamed from: a */
    private static WeakReference<Future<?>> f13504a;

    /* renamed from: a */
    public static void m12538a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = f13504a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            f13504a = new WeakReference<>(C3624j.m12540a(new RunnableC3621g()));
        }
    }
}
