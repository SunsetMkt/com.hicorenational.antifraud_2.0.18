package com.umeng.message.proguard;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Runnable {
    protected Future<?> a;

    public final c a() {
        this.a = b();
        return this;
    }

    protected abstract Future<?> b();

    public final void c() {
        Future<?> future = this.a;
        if (future != null) {
            try {
                if (!future.isCancelled() && !future.isDone()) {
                    future.cancel(false);
                }
            } catch (Throwable unused) {
            }
        }
        this.a = null;
    }

    public final boolean d() {
        Future<?> future = this.a;
        return (future == null || future.isDone()) ? false : true;
    }
}
