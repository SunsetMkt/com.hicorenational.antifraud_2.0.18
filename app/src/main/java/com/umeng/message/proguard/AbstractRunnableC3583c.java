package com.umeng.message.proguard;

import java.util.concurrent.Future;

/* renamed from: com.umeng.message.proguard.c */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC3583c implements Runnable {

    /* renamed from: a */
    protected Future<?> f13267a;

    /* renamed from: a */
    public final AbstractRunnableC3583c m12340a() {
        this.f13267a = mo12271b();
        return this;
    }

    /* renamed from: b */
    protected abstract Future<?> mo12271b();

    /* renamed from: c */
    public final void m12341c() {
        Future<?> future = this.f13267a;
        if (future != null) {
            try {
                if (!future.isCancelled() && !future.isDone()) {
                    future.cancel(false);
                }
            } catch (Throwable unused) {
            }
        }
        this.f13267a = null;
    }

    /* renamed from: d */
    public final boolean m12342d() {
        Future<?> future = this.f13267a;
        return (future == null || future.isDone()) ? false : true;
    }
}
